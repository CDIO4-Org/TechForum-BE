package dto;

import model.Blogs;
import model.Users;

import java.time.LocalDate;

public class BlogStorageDto {
    private Integer id;
    private LocalDate date;
    private Blogs blog;
    private Users user;
    public BlogStorageDto() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Blogs getBlog() {
        return blog;
    }

    public void setBlog(Blogs blog) {
        this.blog = blog;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
