package com.sensorhub.iot.comment.domain;

import com.sensorhub.iot.article.domain.Article;
import com.sensorhub.iot.user.domain.UserInfo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 2015/4/6.
 */

@Entity
@Table(name = "IOT_COMMENT")
@SequenceGenerator(name = "SEQ_COMMENT_INFO_ID", sequenceName = "SEQ_COMMENT_INFO_ID", allocationSize = 1, initialValue = 1)
public class Comment implements Serializable
{
    private long id;

    private String content;//评论内容

    private String storeLocation;//存放图片的物理路径
    /*
    0:正常
    1:已删除
     */
    private int status=0;

    private Date commentDate;

    private UserInfo userInfo;

    private Article article;

    private double fileSize=0;

    private Comment parent;

    private Set<Comment> comments = new HashSet<Comment>(0);

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    public Comment getParent()
    {
        return parent;
    }
    public void setParent(Comment parent)
    {
        this.parent = parent;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    public Set<Comment> getComments()
    {
        return comments;
    }
    public void setComments(Set<Comment> comments)
    {
        this.comments = comments;
    }

    @Column(name="FILESIZE")
    public double getFileSize()
    {
        return fileSize;
    }
    public void setFileSize(double fileSize)
    {
        this.fileSize = fileSize;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COMMENT_INFO_ID")
    @Column(name = "DBID")
    public long getId()
    {
        return id;
    }
    public void setId(long id)
    {
        this.id = id;
    }

    @Column(name = "CONTENT")
    public String getContent()
    {
        return content;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    @Column(name = "STORELOCATION")
    public String getStoreLocation()
    {
        return storeLocation;
    }
    public void setStoreLocation(String storeLocation)
    {
        this.storeLocation = storeLocation;
    }

    @Column(name = "STATUS")
    public int getStatus()
    {
        return status;
    }
    public void setStatus(int status)
    {
        this.status = status;
    }

    @Column(name = "COMMENTDATE")
    public Date getCommentDate()
    {
        return commentDate;
    }
    public void setCommentDate(Date commentDate)
    {
        this.commentDate = commentDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    public UserInfo getUserInfo()
    {
        return userInfo;
    }
    public void setUserInfo(UserInfo userInfo)
    {
        this.userInfo = userInfo;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ARTICLE_ID")
    public Article getArticle()
    {
        return article;
    }
    public void setArticle(Article article)
    {
        this.article = article;
    }
}
