package com.fas.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    //姓名
    @Column(nullable = false, unique = true)
    private String userName;

    //密码
    @Column(nullable = false)
    private String password;

    //年龄
    @Column(nullable = false)
    private Integer age;

    //邮箱
    @Column(nullable = false, unique = true)
    private String email;

    //昵称
    @Column(nullable = true, unique = true)
    private String nickName;

    //注册时间
    @Column(nullable = false)
    private Date regTime;

}
