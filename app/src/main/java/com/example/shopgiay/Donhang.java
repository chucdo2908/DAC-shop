package com.example.shopgiay;

public class Donhang {
     int id , id_sp ,id_tk , soluong , gia ;
     String ten_sp ,  ten_user , diachi , sdt , ngaymua , hinhanh ;

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_sp() {
        return id_sp;
    }

    public void setId_sp(int id_sp) {
        this.id_sp = id_sp;
    }

    public int getId_tk() {
        return id_tk;
    }

    public void setId_tk(int id_tk) {
        this.id_tk = id_tk;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getTen_sp() {
        return ten_sp;
    }

    public void setTen_sp(String ten_sp) {
        this.ten_sp = ten_sp;
    }

    public String getTen_user() {
        return ten_user;
    }

    public void setTen_user(String ten_user) {
        this.ten_user = ten_user;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNgaymua() {
        return ngaymua;
    }

    public void setNgaymua(String ngaymua) {
        this.ngaymua = ngaymua;
    }

    public Donhang(int id, int id_sp, int id_tk, int soluong, int gia, String ten_sp, String ten_user, String diachi, String sdt, String ngaymua , String hinhanh) {
        this.id = id;
        this.id_sp = id_sp;
        this.id_tk = id_tk;
        this.soluong = soluong;
        this.gia = gia;
        this.ten_sp = ten_sp;
        this.ten_user = ten_user;
        this.diachi = diachi;
        this.sdt = sdt;
        this.ngaymua = ngaymua;
        this.hinhanh = hinhanh;
    }


    @Override
    public String toString() {
        return "Donhang{" +
                "id=" + id +
                ", id_sp=" + id_sp +
                ", id_tk=" + id_tk +
                ", soluong=" + soluong +
                ", gia=" + gia +
                ", ten_sp='" + ten_sp + '\'' +
                ", ten_user='" + ten_user + '\'' +
                ", diachi='" + diachi + '\'' +
                ", sdt='" + sdt + '\'' +
                ", ngaymua='" + ngaymua + '\'' +
                '}';
    }
}
