package com.hung.blog.hungblog.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
public class Articles {
    private int id;
    private String title;
    private String content;
    private Date publishDate;
    private Integer authorId;
    private Integer categoryId;
    private Collection<ArticleTags> articleTagsById;
    private Users usersByAuthorId;
    private Categories categoriesByCategoryId;
    private Collection<Comments> commentsById;
    private Collection<Likes> likesById;
    private Collection<Views> viewsById;

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
    @Column(name = "title", nullable = true, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content", nullable = true, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "publish_date", nullable = true)
    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Basic
    @Column(name = "author_id", nullable = true, insertable=false, updatable=false)
    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    @Basic
    @Column(name = "category_id", nullable = true, insertable=false, updatable=false)
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }



    @OneToMany(mappedBy = "articlesByArticleId")
    public Collection<ArticleTags> getArticleTagsById() {
        return articleTagsById;
    }

    public void setArticleTagsById(Collection<ArticleTags> articleTagsById) {
        this.articleTagsById = articleTagsById;
    }

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    public Users getUsersByAuthorId() {
        return usersByAuthorId;
    }

    public void setUsersByAuthorId(Users usersByAuthorId) {
        this.usersByAuthorId = usersByAuthorId;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    public Categories getCategoriesByCategoryId() {
        return categoriesByCategoryId;
    }

    public void setCategoriesByCategoryId(Categories categoriesByCategoryId) {
        this.categoriesByCategoryId = categoriesByCategoryId;
    }

    @OneToMany(mappedBy = "articlesByArticleId")
    public Collection<Comments> getCommentsById() {
        return commentsById;
    }

    public void setCommentsById(Collection<Comments> commentsById) {
        this.commentsById = commentsById;
    }

    @OneToMany(mappedBy = "articlesByArticleId")
    public Collection<Likes> getLikesById() {
        return likesById;
    }

    public void setLikesById(Collection<Likes> likesById) {
        this.likesById = likesById;
    }

    @OneToMany(mappedBy = "articlesByArticleId")
    public Collection<Views> getViewsById() {
        return viewsById;
    }

    public void setViewsById(Collection<Views> viewsById) {
        this.viewsById = viewsById;
    }
}
