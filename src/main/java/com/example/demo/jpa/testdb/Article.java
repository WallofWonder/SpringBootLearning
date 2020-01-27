package com.example.demo.jpa.testdb;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity                 // 表示这个类是一个实体类，接受JPA控制管理，对应数据库中的一个表
@Table(name="article")  // 指定这个类对应数据库中的表名。如果这个类名和数据库表名符合驼峰及下划线规则，可以省略这个注解。如FlowType类名对应表名flow_type。
public class Article {

    @Id // 指定这个字段为表的主键
    @GeneratedValue // 指定主键的生成方式，一般主键为自增的话，就采用GenerationType.IDENTITY的生成方式
    private Long id;

    @Column(nullable = false,length = 32) // 注解针对一个字段，对应表中的一列。
    private String author;

    @Column(nullable = false, unique = true,length = 32)
    private String title;

    @Column(length = 512)
    private String content;

    private Date createTime;
}