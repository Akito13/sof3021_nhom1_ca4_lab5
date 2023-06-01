package com.example.sof3021_nhom1_ca4_lab5.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Loai {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MALOAI")
    private int maloai;
    @Basic
    @Column(name = "TENLOAI")
    private String tenloai;
    @OneToMany(mappedBy = "maloai")
    private List<Sach> books;

    public int getMaloai() {
        return maloai;
    }

    public void setMaloai(int maloai) {
        this.maloai = maloai;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loai loai = (Loai) o;
        return maloai == loai.maloai && Objects.equals(tenloai, loai.tenloai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maloai, tenloai);
    }

    public List<Sach> getBooks() {
        return books;
    }

    public void setBooks(List<Sach> books) {
        this.books = books;
    }
}
