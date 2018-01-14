package Dto.Example;

import Dto.*;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {

    @SerializedName("posts")
    @Expose
    private List<Post> posts = null;
    @SerializedName("comments")
    @Expose
    private List<Comment> comments = null;
    @SerializedName("albums")
    @Expose
    private List<Album> albums = null;
    @SerializedName("users")
    @Expose
    private List<User> users = null;
    @SerializedName("todos")
    @Expose
    private List<Todo> todos = null;
    @SerializedName("photos")
    @Expose
    private List<Photo> photos = null;

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
