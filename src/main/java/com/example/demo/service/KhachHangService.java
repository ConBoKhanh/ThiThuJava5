package com.example.demo.service;

import com.example.demo.dto.KhachHangRequest;
import com.example.demo.entity.HangKhachHang;
import com.example.demo.entity.KhachHang;
import com.example.demo.reponsitory.KhacHangReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhachHangService {
    @Autowired
    private KhacHangReponsitory reponsitory;


    // get list
    public Page<KhachHang> getAll(Integer page) {
        Pageable pageable = PageRequest.of(page, 1);
        return reponsitory.findAll(pageable);
    }
    //add
    public KhachHang add(KhachHangRequest request) {

        HangKhachHang hang = HangKhachHang.builder().
                ma(Integer.parseInt(request.getMaHang()))
                .build();

        KhachHang khachHang =  KhachHang.builder().
                hangKhachHang(hang)
                .gioiTinh(Boolean.valueOf(request.getGioiTinh()))
                .sdt(request.getSdt())
                .ten(request.getTen())
        .build();
        return reponsitory.save(khachHang);
    }
    //update
    public KhachHang update(KhachHangRequest request , Long ma) {

        HangKhachHang hang = HangKhachHang.builder().
                ma(Integer.parseInt(request.getMaHang()))
                .build();

        KhachHang khachHang =  KhachHang.builder()
                .ma(ma)
                .hangKhachHang(hang)
                .gioiTinh(Boolean.valueOf(request.getGioiTinh()))
                .sdt(request.getSdt())
                .ten(request.getTen())
                .build();
        return reponsitory.save(khachHang);
    }


    //delete
    public KhachHang delete(Long ma){
        Optional<KhachHang> optional = reponsitory.findById(ma);
        return optional.map(o-> {
            reponsitory.delete(o);
            return o;
        }).orElse(null);

    }

    public KhachHang detail(Long ma){
      return reponsitory.getKhachHangByMa(ma);
    }

    public List<KhachHang> hang(String ma){
        return reponsitory.getKhachHangByHangKhachHang_Ma(ma);
    }

    public List<KhachHang> getTenLike(String ten){
        return reponsitory.getKhachHangByTenLike(ten);
    }
}
