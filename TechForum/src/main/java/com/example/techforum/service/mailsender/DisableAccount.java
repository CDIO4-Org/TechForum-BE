package com.example.techforum.service.mailsender;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
@Component
public class DisableAccount {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmailDisableAccount(String email, String accountName) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");

        // Cấu hình Thymeleaf template resolver
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("/templates/"); // Đường dẫn đến thư mục chứa template
        templateResolver.setSuffix(".html");       // Chỉ định phần mở rộng là .html
        templateResolver.setTemplateMode("HTML");

        // Khởi tạo SpringTemplateEngine với template resolver
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        // Tạo context và truyền dữ liệu (nếu cần)
        Context context = new Context();
        context.setVariable("name", accountName);

        // context.setVariable("variableName", value); // Truyền biến vào template nếu cần

        // Render template thành chuỗi HTML
        String htmlContent = templateEngine.process("DisableAccount", context); // Tên template không cần phần mở rộng

        // Thiết lập email với nội dung HTML
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("Thông báo tài khoản bạn đã bị vô hiệu hoá");
        mimeMessageHelper.setText(htmlContent, true); // true để chỉ định đây là nội dung HTML

        // Gửi email
        mailSender.send(mimeMessage);
    }
}
