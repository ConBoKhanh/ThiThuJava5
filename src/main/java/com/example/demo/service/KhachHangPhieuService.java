package com.example.demo.service;

import com.example.demo.dto.KhachHangRequest;
import com.example.demo.dto.PhieuGiamGiaRequest;
import com.example.demo.entity.KhachHang;
import com.example.demo.entity.PhieuGiamGia;
import com.example.demo.reponsitory.KhacHangReponsitory;
import com.example.demo.reponsitory.PhieuGiamGiaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhachHangPhieuService {

    @Autowired
    PhieuGiamGiaRepo phieuRepo;

    public Page<PhieuGiamGia> getAll(Integer page){
        Pageable pageable = PageRequest.of(page,2);
        return phieuRepo.findAll(pageable);
    }

     public PhieuGiamGia add(PhieuGiamGiaRequest request){
        KhachHang khachHang =  KhachHang.builder().
         ma(Long.valueOf(request.getNguoiSoHuu()))
         .
                build();
        PhieuGiamGia phieu =  PhieuGiamGia.builder().
         maPhieu(request.getMaPhieu())
                .tenPhieu(request.getTenPhieu())
                .ngayBatDau(request.getNgayBatDau())
                .ngayKetThuc(request.getNgayKetThuc())
                .nguoiSoHuu(khachHang)
         .build();
        return phieuRepo.save(phieu);
     }
    public PhieuGiamGia update(PhieuGiamGiaRequest request,String ma){
        KhachHang khachHang =  KhachHang.builder().
                ma(Long.valueOf(request.getNguoiSoHuu()))
                .build();

        PhieuGiamGia phieu =  PhieuGiamGia.builder()
                .tenPhieu(request.getTenPhieu())
                .ngayBatDau(request.getNgayBatDau())
                .ngayKetThuc(request.getNgayKetThuc())
                .nguoiSoHuu(khachHang)
                .maPhieu(ma)
                .build();
        return phieuRepo.save(phieu);
    }
    public PhieuGiamGia delete(String ma){
        Optional<PhieuGiamGia> optional = phieuRepo.findById(ma);
        return optional.map(o -> {
             phieuRepo.delete(o);
            return o;
        }).orElse(null);
    }

}
