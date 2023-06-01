package com.example.sof3021_nhom1_ca4_lab5.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Sach {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MASACH")
    private int masach;
    @Basic
    @Column(name = "TENSACH")
    private String tensach;
    @Basic
    @Column(name = "TACGIA")
    private String tacgia;
    @Basic
    @Column(name = "NXB")
    @Temporal(TemporalType.DATE)
    private Date nxb;
    @Basic
    @Column(name = "GIA")
    private Double gia;
    @Basic
    @Column(name = "IMG")
    private String img;
    @Basic
    @Column(name = "SOLUONG")
    private Integer soluong;
    @OneToMany(mappedBy = "masach")
    private List<Donhangchitiet> billDetails;
    @ManyToOne
    @JoinColumn(name = "MALOAI", referencedColumnName = "MALOAI")
    private Loai maloai;

    public int getMasach() {
        return masach;
    }

    public void setMasach(int masach) {
        this.masach = masach;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public Date getNxb() {
        return nxb;
    }

    public void setNxb(Date nxb) {
        this.nxb = nxb;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sach sach = (Sach) o;
        return masach == sach.masach && Objects.equals(tensach, sach.tensach) && Objects.equals(tacgia, sach.tacgia) && Objects.equals(nxb, sach.nxb) && Objects.equals(gia, sach.gia) && Objects.equals(img, sach.img) && Objects.equals(soluong, sach.soluong);
    }

    @Override
    public int hashCode() {
        return Objects.hash(masach, tensach, tacgia, nxb, gia, img, soluong);
    }

    public List<Donhangchitiet> getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(List<Donhangchitiet> billDetails) {
        this.billDetails = billDetails;
    }

    public Loai getMaloai() {
        return maloai;
    }

    public void setMaloai(Loai maloai) {
        this.maloai = maloai;
    }
}
