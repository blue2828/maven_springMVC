package entity;

public class Page {
    private int page;
    private int limit;
    private int start;

    public void setStart(int start) {
        this.start = (this.page-1)*this.limit;
    }

    public Page(int page, int limit) {
        this.page = page;
        this.limit = limit;
    }

    public Page() {
    }

    public int getPage() {

        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getStart() {
        return (this.page-1)*this.limit;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
