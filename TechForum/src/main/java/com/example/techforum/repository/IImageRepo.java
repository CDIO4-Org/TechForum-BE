package com.example.techforum.repository;

import com.example.techforum.dto.BlogDto;
import com.example.techforum.dto.ImageDto;
import com.example.techforum.model.Blogs;
import com.example.techforum.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IImageRepo extends JpaRepository<Images, Long> {
    @Modifying
    @Query(value = "insert into images (name_img,blog_id) values(?1,?2)", nativeQuery = true )
    void createImgBlog(String nameImg, Long blog_id);

    @Modifying
    @Query(value = "SELECT new com.example.techforum.dto.ImageDto(i.nameImg, i.blog) " +
            "FROM Images i JOIN Blogs b ON i.blog.id = b.id " +
            "WHERE b.id = :id")
    List<ImageDto> findImageDtosByBlogId(@Param("id") Long blogId);

}
