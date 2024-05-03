package cs1302.api;

import java.util.List;

/**
 * Represents a response containing a list of the quotes retrieved from the Quotable API.
 */
public class QuoteResponse {
    int count;
    int totalCount;
    int page;
    int totalPages;
    Integer lastItemIndex;
    List<Quote> results;

    /**
     * Retrieves the count of quotes in the response.
     *
     * @return the count of quotes
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets the count of quotes in the response.
     *
     * @param count the count of quotes
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Retrieves the total count of quotes available.
     *
     * @return the total count of quotes
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * Sets the total count of quotes available.
     *
     * @param totalCount the total count of quotes
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * Retrieves the page number of the response.
     *
     * @return the page number
     */
    public int getPage() {
        return page;
    }

    /**
     * Sets the page number of the response.
     *
     * @param page the page number
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * Sets the total number of pages available.
     *
     * @param totalPages the total number of pages
     */
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    /**
     * Retrieves the index of the last item in the response.
     *
     * @return the index of the last item
     */
    public Integer getLastItemIndex() {
        return lastItemIndex;
    }

    /**
     * Sets the index of the last item in the response.
     *
     * @param lastItemIndex the index of the last item
     */
    public void setLastItemIndex(Integer lastItemIndex) {
        this.lastItemIndex = lastItemIndex;
    }

    /**
     * Retrieves the list of quotes in the response.
     *
     * @return the list of quotes
     */
    public List<Quote> getResults() {
        return results;
    }

    /**
     * Sets the list of quotes in the response.
     *
     * @param results the list of quotes
     */
    public void setResults(List<Quote> results) {
        this.results = results;
    }
}
