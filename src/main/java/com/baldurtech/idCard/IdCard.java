package com.baldurtech.idCard;

import java.sql.Blob;
import javax.persistence.*;

@Entity
@Table(name="idCard")
public class IdCard {
    @Id
    @GeneratedValue
    Long id;
    private String card;
    private String name;
    private String gender;
    private String nation;
    private String birthday;
    
    @Column(name="content")
    @Lob
    private byte[] content;
     
    @Column(name="content_type")
    private String contentType;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getNation() {
        return nation;
    }
    public void setNation(String nation) {
        this.nation = nation;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getCard() {
        return card;
    }
    public void setCard(String card) {
        this.card = card;
    }
    
    public byte[] getContent() {
        return content;
    }
    public void setContent(byte[] content) {
        this.content = content;
    }
    
    public String getContentType() {
        return contentType;
    }
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

}