package com.example.backend;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Test")

public class Student {
    
    private String name;
    private String des;
    
    public void setName(String name) {
        this.name = name;
    }
    public void setDes(String des) {
        this.des = des;
    }
    public String getName() {
        return name;
    }
    public String getDes() {
        return des;
    }
}
