package com.jaxb.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customer")
public class Customer {

    private String name;
    private int age;
    private Integer id;

    public String getName() {
        return name;
    }

    // name attribute is optional if tag name follows getter naming convention
    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @XmlElement(name = "age")
    public void setAge(int age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    @XmlAttribute(name = "id")
    public void setId(Integer id) {
        this.id = id;
    }
}
