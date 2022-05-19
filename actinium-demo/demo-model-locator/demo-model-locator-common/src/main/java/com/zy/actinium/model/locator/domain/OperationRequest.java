package com.zy.actinium.model.locator.domain;

import java.io.Serializable;

/**
 * @author Neo
 */
public class OperationRequest implements Serializable {
    private static final long serialVersionUID = -368969052231177170L;

    private Long id;

    private String name;

    private String paperNumber;

    private String phoneNumber;

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

    public String getPaperNumber() {
        return paperNumber;
    }

    public void setPaperNumber(String paperNumber) {
        this.paperNumber = paperNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "OperationRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", paperNumber='" + paperNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
