package com.ladyishenlong.elasticsearch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @Author ruanchenhao
 * @Date 2020/4/24 4:03 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "user")
public class UserModel implements Serializable {

    @Id
    private Long id;

    public String username;

    public String password;

    @Field(type = FieldType.Keyword)
    public String group;

}
