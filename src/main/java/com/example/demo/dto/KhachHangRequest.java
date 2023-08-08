package com.example.demo.dto;

import com.example.demo.entity.HangKhachHang;
import com.example.demo.entity.KhachHang;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class KhachHangRequest {

    @NotBlank(message = "ma hang khong dc de trong")
    private String maHang;

    @NotBlank(message = "sdt hang khong dc de trong")
    private String sdt;

    @NotBlank(message = "gioi tinh hang khong dc de trong")
    private String gioiTinh;

    @NotBlank(message = "ten hang khong dc de trong")
    private String ten;

}
