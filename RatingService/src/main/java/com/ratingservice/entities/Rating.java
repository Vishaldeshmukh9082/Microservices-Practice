package com.ratingservice.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("ratings")
public class Rating {

    @Id
    private String rId;

    @Field("uid")
    private String uId;
    
    @Field("hid")
    private String hId;

    @Field("rating")
    private int rating;

}
