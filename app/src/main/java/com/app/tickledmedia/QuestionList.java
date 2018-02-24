package com.app.tickledmedia;

/**
 * Created by SappiKaran on 24/02/18.
 */
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "status",
        "message",
        "response"
})

class QuestionList {

    @JsonProperty("status")
    public Boolean status;
    @JsonProperty("message")
    public String message;
    @JsonProperty("response")
    public List<Response> response = new ArrayList<Response>();
}
