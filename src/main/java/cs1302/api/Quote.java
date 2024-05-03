package cs1302.api;

import com.google.gson.annotations.SerializedName;

/**
 * Represents the quote retrieved from an external Quotes API.
 */
public class Quote {
    @SerializedName("_id")
    String quoteId;
    String content;
    String author;

    // Getters and Setters
    /**
     * Gets ID of the quote.
     *
     * @return the ID of the quote
     */
    public String getQuoteId() {
        return quoteId;
    }

    /**
     * Sets the ID of the quote.
     *
     * @param quoteId the ID of the quote
     */
    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId;
    }

    /**
     * Retrieves the content of the quote.
     *
     * @return the content of the quote
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the quote.
     *
     * @param content the content of the quote
     */
    public void setContent(String content) {
        this.content = content;
    }


    /**
     * Retrieves the author of the quote.
     *
     * @return the author of the quote
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the quote.
     *
     * @param author the author of the quote
     */
    public void setAuthor(String author) {
        this.author = author;
    }
}
