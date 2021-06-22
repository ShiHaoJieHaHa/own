package com.demo.login.entity;

import lombok.Data;


@Data
public class Permission {
    private int id;
    private String permissionName;
    private int roleId;
}
