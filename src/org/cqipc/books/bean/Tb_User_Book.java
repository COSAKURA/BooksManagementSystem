package org.cqipc.books.bean;

public class Tb_User_Book {
    private int id;
    private Tb_User userId;
    private Tb_Books bookId;
    private String begin_time;
    private String end_time;
    private int stat;

    public Tb_User_Book() {
    }

    public Tb_User_Book(int id, Tb_User userId, Tb_Books bookId, String begin_time, String end_time, int stat) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.begin_time = begin_time;
        this.end_time = end_time;
        this.stat = stat;
    }

    public Tb_User_Book(Tb_User userId, Tb_Books bookId, String begin_time, String end_time, int stat) {
        this.userId = userId;
        this.bookId = bookId;
        this.begin_time = begin_time;
        this.end_time = end_time;
        this.stat = stat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tb_User getUserId() {
        return userId;
    }

    public void setUserId(Tb_User userId) {
        this.userId = userId;
    }

    public Tb_Books getBookId() {
        return bookId;
    }

    public void setBookId(Tb_Books bookId) {
        this.bookId = bookId;
    }

    public String getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(String begin_time) {
        this.begin_time = begin_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public int getStat() {
        return stat;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        return "Tb_User_Book [id=" + id + ", userId=" + userId + ", bookId=" + bookId + ", begin_time=" + begin_time + ", end_time=" + end_time + ", stat=" + stat + "]";
    }
}
