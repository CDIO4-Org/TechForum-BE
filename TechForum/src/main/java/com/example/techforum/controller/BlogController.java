package com.example.techforum.controller;

import com.example.techforum.dto.BlogDto;
import com.example.techforum.model.Blogs;
import com.example.techforum.service.blog.IBlogService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @GetMapping("/getAllBlog")
    public ResponseEntity<List<BlogDto>> getAllBlogs() {
        try {
            List<BlogDto> blogs = blogService.findAll();
            return ResponseEntity.ok(blogs); // HTTP 200
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); // HTTP 500
        }
    }
    @GetMapping("/nonActivedBlogs")
    public ResponseEntity<Page<BlogDto>> getBlogNonActived(
            @RequestParam(defaultValue = "0") int page, // Trang bắt đầu, mặc định là 0
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "beginDate,asc") String[] sort// Kích thước mỗi trang, mặc định là 10
    ) {
        Sort.Direction direction = Sort.Direction.fromString(sort[1]);
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sort[0]));

        Page<BlogDto> activeBlogs = blogService.findByStatus(false, pageable);
        return ResponseEntity.ok(activeBlogs);
    }
    @GetMapping("/activedBlogs")
    public ResponseEntity<Page<BlogDto>> getActivedBlos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "beginDate,asc") String[] sort
    ) {
        Sort.Direction direction = Sort.Direction.fromString(sort[1]);
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sort[0]));

        Page<BlogDto> activeBlogs = blogService.findByStatus(true, pageable);
        return ResponseEntity.ok(activeBlogs);
    }


    @PostMapping("/addNewBlog")
    public ResponseEntity<Blogs> addNewBlog(@RequestBody @Valid BlogDto blog) {
        Blogs savedBlog = blogService.addNewBlog(blog);
        return new ResponseEntity<>(savedBlog, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteBlog")
    public ResponseEntity<String> deleteBlog(@RequestParam Long id){
        blogService.delete(id);
        return new ResponseEntity<>("Xoa thanh cong",HttpStatus.OK);
    }

    @PutMapping("/updateBlog")
    public ResponseEntity<String> updateBlog(@RequestParam Long id, @RequestBody  BlogDto blogDTO) {
        try {
            blogService.updateBlog(id, blogDTO);
            return new ResponseEntity<>("Blog updated successfully", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>("Blog not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to update Product", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/acctiveBlog")
    public ResponseEntity<String> acctiveBlog(@RequestParam Long id) {
        try {
            blogService.acctiveBlog(id);

            return new ResponseEntity<>("Blog acctive successfully", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>("Blog not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to update Blog", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/findByTitle")
    public ResponseEntity<List<BlogDto>> getBlogsByTitle(@RequestParam String title) {
        List<BlogDto> blogs = blogService.findByTitle(title);
        if (blogs.isEmpty()) {
            return ResponseEntity.noContent().build();  // Nếu không có kết quả, trả về 204 No Content
        }
        return ResponseEntity.ok(blogs);  // Trả về danh sách blog với mã 200 OK
    }
    @GetMapping("/getByid/{id}")
    public ResponseEntity<BlogDto> getBlogById(@PathVariable("id") long id) {
        try {
            BlogDto blog = blogService.findOne(id);
            return ResponseEntity.ok(blog);  // Trả về blog nếu tìm thấy
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // Nếu không tìm thấy, trả về lỗi 404
        }
    }


//    @GetMapping("/findByStatusFalse")
//    public ResponseEntity<List<BlogDto>> getBlogsByFalse() {
//        List<BlogDto> blogs = blogService.findByStatusFalse();
//        if (blogs.isEmpty()) {
//            return ResponseEntity.noContent().build();  // Nếu không có kết quả, trả về 204 No Content
//        }
//        return ResponseEntity.ok(blogs);  // Trả về danh sách blog với mã 200 OK
//    }

}
