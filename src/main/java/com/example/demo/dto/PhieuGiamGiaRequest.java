package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhieuGiamGiaRequest {
    private String maPhieu;
    private String tenPhieu;
    private String ngayBatDau;
    private String ngayKetThuc;
    private String nguoiSoHuu;
}
