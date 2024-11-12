package dto;

import model.Blogs;
import model.Users;

public class ViewsDto {
    private Integer id;
    private Integer amount;
    private Blogs blog;
    private Users user;

    public ViewsDto(Integer id, Integer amount, Blogs blog, Users user) {
        this.id = id;
        this.amount = amount;
        this.blog = blog;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
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
