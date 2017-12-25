package Dto.DtoExample;

import Dto.Comment;
import Dto.Post;
import Dto.Profile;
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

    @SerializedName("profile")
    @Expose
    private Profile profile;

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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
