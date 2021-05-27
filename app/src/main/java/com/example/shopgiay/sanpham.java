package com.example.shopgiay;

public class sanpham {
     int ID ;
     String Ten_sp ;
     String Hang_sp ;
     String Thongt_sp ;
     int Size;
     int Soluong ;
     float Gia ;
     String img;

    public sanpham(int ID, String ten_sp, String hang_sp, String thongt_sp, int size, int soluong, float gia, String img) {
        this.ID = ID;
        Ten_sp = ten_sp;
        Hang_sp = hang_sp;
        Thongt_sp = thongt_sp;
        Size = size;
        Soluong = soluong;
        Gia = gia;
        this.img = img;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTen_sp() {
        return Ten_sp;
    }

    public void setTen_sp(String ten_sp) {
        Ten_sp = ten_sp;
    }

    public String getHang_sp() {
        return Hang_sp;
    }

    public void setHang_sp(String hang_sp) {
        Hang_sp = hang_sp;
    }

    public String getThongt_sp() {
        return Thongt_sp;
    }

    public void setThongt_sp(String thongt_sp) {
        Thongt_sp = thongt_sp;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int soluong) {
        Soluong = soluong;
    }

    public float getGia() {
        return Gia;
    }

    public void setGia(float gia) {
        Gia = gia;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public sanpham() {
    }
}
