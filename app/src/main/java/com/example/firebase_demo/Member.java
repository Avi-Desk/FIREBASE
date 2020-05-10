package com.example.firebase_demo;

public class Member {
    private String  Name;
    private Integer Age;
    private  Long Phone;
    private  Float Height;

    public Member() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public Long getPhone() {
        return Phone;
    }

    public void setPhone(Long phone) {
        Phone = phone;
    }

    public Float getHeight() {
        return Height;
    }

    public void setHeight(Float height) {
        Height = height;
    }
}
