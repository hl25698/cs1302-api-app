package cs1302.api;

import java.util.List;

public class QuoteResponse {
    int count;
    int totalCount;
    int page;
    int totalPages;
    Integer lastItemIndex;
    List<Quote> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getLastItemIndex() {
        return lastItemIndex;
    }

    public void setLastItemIndex(Integer lastItemIndex) {
        this.lastItemIndex = lastItemIndex;
    }

    public List<Quote> getResults() {
        return results;
    }

    public void setResults(List<Quote> results) {
        this.results = results;
    }
}
