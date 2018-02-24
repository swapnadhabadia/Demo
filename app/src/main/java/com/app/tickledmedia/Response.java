package com.app.tickledmedia;

/**
 * Created by SappiKaran on 24/02/18.
 */

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "id",
        "user_id",
        "message",
        "image",
        "comments"
})
public class Response {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("user_id")
    public Integer userId;
    @JsonProperty("message")
    public String message;
    @JsonProperty("image")
    public String image;
    @JsonProperty("comments")
    public List<Comment> comments = new ArrayList<Comment>();

}
