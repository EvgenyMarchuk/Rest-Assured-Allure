package Dto;

import com.google.gson.annotations.*;
import io.restassured.mapper.ObjectMapper;

public class Post {

    @SerializedName("id")
    @Expose(serialize = false)
    private Integer id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("author")
    @Expose
    private String author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("Post: Id:%d, Title:%s, Author:%s", getId(), getTitle(), getAuthor());
    }
}
