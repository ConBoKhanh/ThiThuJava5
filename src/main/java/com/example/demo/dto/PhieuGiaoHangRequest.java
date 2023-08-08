package com.example.demo.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhieuGiaoHangRequest {

    @NotBlank(message = "nguoiNhan not null")
    private String nguoiNhan;

    @NotBlank(message = "phiGiaoHang not null")
    private String phiGiaoHang;

    @NotBlank(message = "nguoiLap not null")
    private String nguoiLap;

    @NotBlank(message = "sdtNhan not null")
    private String sdtNhan;

    @NotBlank(message = "hoaDonGiao not null")
    private String hoaDonGiao;


}
