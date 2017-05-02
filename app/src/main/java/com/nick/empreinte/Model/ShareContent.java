package com.nick.empreinte.Model;

/**
 * Created by huanghaojian on 17/4/15.
 */

public class ShareContent {
    private int id;
    private String userName;
    private int imageId;
    private String title;
    private String publishTime;
    private String content;

    public ShareContent(int id,String userName,int imageId,String title,String publishTime){
        this.id=id;
        this.userName=userName;
        this.imageId=imageId;
        this.title=title;
        this.publishTime=publishTime;
    }
    public ShareContent(int id,String userName,int imageId,String title,String publishTime,String content){
        this.id=id;
        this.userName=userName;
        this.imageId=imageId;
        this.title=title;
        this.publishTime=publishTime;
        this.content=content;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName=userName;
    }
    public int getImageId(){
        return imageId;
    }
    public void setImageId(int imageId){
        this.imageId=imageId;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getPublishTime(){
        return publishTime;
    }
    public void setPublishTime(String publishTime){
        this.publishTime=publishTime;
    }
    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content=content;
    }
}
