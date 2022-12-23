package com.hung.blog.hungblog.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Tags {
    private int id;
    private String name;
    private Collection<ArticleTags> articleTagsById;

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
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tags tags = (Tags) o;

        if (id != tags.id) return false;
        if (name != null ? !name.equals(tags.name) : tags.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tagsByTagId")
    public Collection<ArticleTags> getArticleTagsById() {
        return articleTagsById;
    }

    public void setArticleTagsById(Collection<ArticleTags> articleTagsById) {
        this.articleTagsById = articleTagsById;
    }
}
