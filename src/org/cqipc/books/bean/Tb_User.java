package org.cqipc.books.bean;

public class Tb_User {
    private int id;
    private String user;
    private String passwd;

    public Tb_User() {
    }

    public Tb_User(int id, String user, String passwd) {
        this.id = id;
        this.user = user;
        this.passwd = passwd;
    }

    public Tb_User(String user, String passwd) {
        this.user = user;
        this.passwd = passwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "Tb_User [id=" + id + ", user=" + user + ", passwd=" + passwd + "]";
    }
}
