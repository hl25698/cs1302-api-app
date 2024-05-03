package cs1302.api;

public class JokeResponse {
    private String id;
    private String pun;

    public JokeResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPun() {
        return pun;
    }

    public void setPun(String pun) {
        this.pun = pun;
    }
}
