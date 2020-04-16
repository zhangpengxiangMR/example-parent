package com.pykj.springmvc.entity;

import lombok.Data;

import java.util.Map;

@Data
public class UserMap {

    private Map<String,Users> users;

}
