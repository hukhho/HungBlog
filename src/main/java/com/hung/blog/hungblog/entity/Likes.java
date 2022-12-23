package com.hung.blog.hungblog.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Likes {
    private int id;
    private Integer articleId;
    private Integer userId;
    private Date likeDate;
    private Articles articlesByArticleId;
    private Users usersByUserId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "article_id", nullable = true, insertable=false, updatable=false)
    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    @Basic
    @Column(name = "user_id", nullable = true, insertable=false, updatable=false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "like_date", nullable = true)
    public Date getLikeDate() {
        return likeDate;
    }

    public void setLikeDate(Date likeDate) {
        this.likeDate = likeDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Likes likes = (Likes) o;

        if (id != likes.id) return false;
        if (articleId != null ? !articleId.equals(likes.articleId) : likes.articleId != null) return false;
        if (userId != null ? !userId.equals(likes.userId) : likes.userId != null) return false;
        if (likeDate != null ? !likeDate.equals(likes.likeDate) : likes.likeDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (articleId != null ? articleId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (likeDate != null ? likeDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "article_id", referencedColumnName = "id")
    public Articles getArticlesByArticleId() {
        return articlesByArticleId;
    }

    public void setArticlesByArticleId(Articles articlesByArticleId) {
        this.articlesByArticleId = articlesByArticleId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public Users getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(Users usersByUserId) {
        this.usersByUserId = usersByUserId;
    }
}
