package com.copypasteit.androidversionhistory.main.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("post_author")
    @Expose
    private String postAuthor;
    @SerializedName("post_title")
    @Expose
    private String postTitle;
    @SerializedName("post_details")
    @Expose
    private String postDetails;
    @SerializedName("post_image_url")
    @Expose
    private String postImageUrl;
    @SerializedName("post_image")
    @Expose
    private String postImage;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private Object updatedAt;
    @SerializedName("category_name")
    @Expose
    private String categoryName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(String postAuthor) {
        this.postAuthor = postAuthor;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostDetails() {
        return postDetails;
    }

    public void setPostDetails(String postDetails) {
        this.postDetails = postDetails;
    }

    public String getPostImageUrl() {
        return postImageUrl;
    }

    public void setPostImageUrl(String postImageUrl) {
        this.postImageUrl = postImageUrl;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", postAuthor='" + postAuthor + '\'' +
                ", postTitle='" + postTitle + '\'' +
                ", postDetails='" + postDetails + '\'' +
                ", postImageUrl='" + postImageUrl + '\'' +
                ", postImage='" + postImage + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt=" + updatedAt +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
