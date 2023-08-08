package com.example.demo.reponsitory;

import com.example.demo.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhacHangReponsitory extends JpaRepository<KhachHang,Long> {
    @Query(value = "select kh.MaKhachHang, kh.TenKhachHang, kh.SoDienThoai,kh.GioiTinh, hkh.MaHang, hkh.TenHang\n" +
            "from KhachHang kh join HangKhachHang hkh on kh.HangKhachHang = hkh.MaHang",nativeQuery = true)
    List<KhachHang>getKhachHangAll();

    KhachHang getKhachHangByMa(Long ma);

    List<KhachHang> getKhachHangByHangKhachHang_Ma(String ma);

    List<KhachHang> getKhachHangByTenLike(String ten);
}
