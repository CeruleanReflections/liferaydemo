package com.liferaybook.courses.api;

import java.util.Date;

public class LiferayCourse {

    private Long courseId;
    private String name;
    private String description;
    private String userName;
    private Date createDate;
    private Date modifiedDate;

    public LiferayCourse(Long courseId, String name, String description, String userName) {
        this.courseId = courseId;
        this.name = name;
        this.description = description;
        this.userName = userName;
    }
    public LiferayCourse() {}
    public String getName() {return name;}
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Long getCourseId() {return courseId;}
    public void setCourseId(Long courseId) {this.courseId = courseId;}
    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}
    public Date getCreateDate() {return createDate;}
    public void setCreateDate(Date createDate) {this.createDate = createDate;}
    public Date getModifiedDate() {return modifiedDate;}
    public void setModifiedDate(Date modifiedDate) {this.modifiedDate = modifiedDate;}
}
