package models;

public class Squad {
    private String maxsize;
    private String naming;
    private String cause;

    public Squad(String name, String maxsize, String cause) {
        this.naming = name;
        this.maxsize = maxsize;
        this.cause = cause;
    }

    public String getName() {
        return naming;
    }

    public void setName(String name) {
        this.naming = name;
    }

    public String getMaxsize() {
        return maxsize;
    }

    public void setMaxsize(String maxsize) {
        this.maxsize = maxsize;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}
