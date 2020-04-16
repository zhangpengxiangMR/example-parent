package com.pykj.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private Integer age;

}
