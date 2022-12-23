package com.hung.blog.hungblog.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "article_tags")
public class ArticleTags {
    private int id;
    private Integer articleId;
    private Integer tagId;
    private Articles articlesByArticleId;
    private Tags tagsByTagId;

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
    @Column(name = "tag_id", nullable = true, insertable=false, updatable=false)
    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleTags that = (ArticleTags) o;

        if (id != that.id) return false;
        if (articleId != null ? !articleId.equals(that.articleId) : that.articleId != null) return false;
        if (tagId != null ? !tagId.equals(that.tagId) : that.tagId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (articleId != null ? articleId.hashCode() : 0);
        result = 31 * result + (tagId != null ? tagId.hashCode() : 0);
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
    @JoinColumn(name = "tag_id", referencedColumnName = "id")
    public Tags getTagsByTagId() {
        return tagsByTagId;
    }

    public void setTagsByTagId(Tags tagsByTagId) {
        this.tagsByTagId = tagsByTagId;
    }
}
