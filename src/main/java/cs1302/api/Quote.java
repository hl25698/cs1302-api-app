package cs1302.api;

import com.google.gson.annotations.SerializedName;

public class Quote {
    @SerializedName("_id")
    String quoteId;
    String content;
    String author;

    // Getters and Setters
    public String getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
