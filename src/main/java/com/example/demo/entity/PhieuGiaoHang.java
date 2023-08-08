package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "PhieuGiaoHang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhieuGiaoHang {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "MaPhieuGiao")
    private UUID maPhieuGiao;

    @Column(name = "NguoiNhan")
    private String nguoiNhan;

    @Column(name = "PhiGiaoHang")
    private String phiGiaoHang;

    @Column(name = "NguoiTao")
    private String nguoiLap;

    @Column(name = "SdtNhan")
    private String sdtNhan;

    @ManyToOne
    @JoinColumn(name = "HoaDonGiao")
    private HoaDon hoaDonGiao;

}
