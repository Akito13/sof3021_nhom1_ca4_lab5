package com.example.sof3021_nhom1_ca4_lab5.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MAKH")
    private int makh;
    @Basic
    @Column(name = "TENKH")
    private String tenkh;
    @Basic
    @Column(name = "SDT")
    private String sdt;
    @Basic
    @Column(name = "DIACHI")
    private String diachi;
    @Basic
    @Column(name = "EMAIL")
    private String email;
    @Basic
    @Column(name = "ADMIN")
    private Boolean admin;
    @Basic
    @Column(name = "PASSWORD")
    private String password;
    @OneToMany(mappedBy = "makh")
    private List<Donhang> bills;

    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return makh == user.makh && Objects.equals(tenkh, user.tenkh) && Objects.equals(sdt, user.sdt) && Objects.equals(diachi, user.diachi) && Objects.equals(email, user.email) && Objects.equals(admin, user.admin) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(makh, tenkh, sdt, diachi, email, admin, password);
    }

    public List<Donhang> getBills() {
        return bills;
    }

    public void setBills(List<Donhang> bills) {
        this.bills = bills;
    }
}
