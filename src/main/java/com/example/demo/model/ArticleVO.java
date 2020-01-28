package com.example.demo.model;


import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonPropertyOrder(value = {"content", "title"}) // 更改属性序列化顺序
public class ArticleVO {

    //@JsonIgnore // 属性忽略
    private Long id;

    //@JsonProperty("auther") // 属性别名
    private String author;
    private String title;
    private String content;

    @JsonInclude(JsonInclude.Include.NON_NULL) // 属性空值不参加序列化
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss", timezone = "GMT +8") // 自定义日期格式
    private Date createTime;
    private List<Reader> reader;


}

