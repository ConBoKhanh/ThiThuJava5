package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "PhieuGiamGia")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class PhieuGiamGia {

    @Id
    @Column(name = "MaPhieu")
    private String maPhieu;

    @Column(name = "TenPhieu")
    private String tenPhieu;

    @Column(name = "NgayBatDau")
    private String ngayBatDau;

    @Column(name = "NgayKetThuc")
    private String ngayKetThuc;

    @ManyToOne
    @JoinColumn(name = "NguoiSoHuu")
    private KhachHang nguoiSoHuu;
}
