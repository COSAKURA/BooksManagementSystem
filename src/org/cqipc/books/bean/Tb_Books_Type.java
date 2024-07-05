package org.cqipc.books.bean;

public class Tb_Books_Type {
    private int id;
    private String type;
    private int type_max_num;

    public Tb_Books_Type() {
    }

    public Tb_Books_Type(int id, String type, int type_max_num) {
        this.id = id;
        this.type = type;
        this.type_max_num = type_max_num;
    }

    public Tb_Books_Type(String type, int type_max_num) {
        this.type = type;
        this.type_max_num = type_max_num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getType_max_num() {
        return type_max_num;
    }

    public void setType_max_num(int type_max_num) {
        this.type_max_num = type_max_num;
    }

    @Override
    public String toString() {
        return "Tb_Books_Type [id=" + id + ", type=" + type + ", type_max_num=" + type_max_num + "]";
    }
}
