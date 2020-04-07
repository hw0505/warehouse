package com.hw.warehouse.entity;

import lombok.Data;

/**
 * user entity
 * @author liurl
 */
@Data
public class UserEntity {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String name;
    private String password;

    public String getName() {
        return this.name;
    }
}
