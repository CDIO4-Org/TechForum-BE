package com.example.techforum.service.blog;

import com.example.techforum.dto.BlogDto;
import com.example.techforum.dto.BlogDtoNew;
import com.example.techforum.model.Blogs;
import com.example.techforum.model.Categories;
import com.example.techforum.model.Users;
import com.example.techforum.repository.ICategoryRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.techforum.repository.IBlogRepo;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepo iBlogRepository;
    @Autowired
    private ICategoryRepo iCategoryRepo;

    @Override
    public Blogs updateBlog(Integer id,@Valid BlogDto updatedBlog) {
        if (iBlogRepository.existsById(id)) {
            Blogs blog = iBlogRepository.findById(id).get();
            blog.setCategory(updatedBlog.getCategory());
            blog.setUser(updatedBlog.getUser());
            blog.setContent(updatedBlog.getContent());
            blog.setTitle(updatedBlog.getTitle());
            blog.setStatus(updatedBlog.getStatus());
            return iBlogRepository.save(blog);
        } else {
            throw new EntityNotFoundException("Blog with id " + id + " not found");
        }
    }

    @Override
    public void acctiveBlog(Integer id) {
        Blogs blog = iBlogRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Blog with id " + id + " not found"));
        blog.setStatus(true);
        iBlogRepository.save(blog);
    }

    @Override
    public List<BlogDto> findByUser(Integer user) {
        List<Blogs> blogs = iBlogRepository.getAllByUserId(user);
        return blogs.stream()
                .map(blog -> new BlogDto(blog))
                .collect(Collectors.toList());
    }


    @Override
    public Page<BlogDto> findByStatus(Boolean status, Pageable pageable) {
        Page<Blogs>blogs = iBlogRepository.findByStatus(status, pageable);
        return  blogs.map(blog -> new BlogDto(blog));
    }

    @Override
    public List<BlogDto> getAcctivedBlogs() {
        List<Blogs> blogs = iBlogRepository.findByStatusTrue();
        return blogs.stream()
                .map(blog -> new BlogDto(blog))
                .collect(Collectors.toList());
    }

    @Override
    public Blogs addNewBlog(BlogDto blog) {
        return iBlogRepository.save(dtoToObject(blog));
    }



    @Override
    public BlogDto findOne(Integer id) {
        Blogs blog = iBlogRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Blog not found with id: " + id));

        return new BlogDto(blog);
    }


    @Override
    public void delete(Integer id) {
        if (iBlogRepository.existsById(id)){
            iBlogRepository.deleteById(id);
        }else {
            throw new EntityNotFoundException("Blog not found with id: " + id);
        }
    }


    @Override
    public List<BlogDto> findByTitle(String title) {
        return iBlogRepository.findByTitle(title);

    }

    @Override
    public Integer getLastInsert() {
        return iBlogRepository.getLastInsert();
    }



    @Override
    public Blogs findById(Integer id) {
        return iBlogRepository.findObject(id);
    }
    @Override
    public List<BlogDto> findByCategoryId(Integer id) {
        Categories categories = iCategoryRepo.findById(id).get();
        return iBlogRepository.findAllByCategory(categories);
    }

    public Blogs dtoToObject(BlogDto blogDTO){
        return new Blogs(blogDTO);
    }



}
