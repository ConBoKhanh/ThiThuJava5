package com.example.demo.service;


import com.example.demo.dto.PhieuGiaoHangRequest;
import com.example.demo.entity.HoaDon;
import com.example.demo.entity.KhachHang;
import com.example.demo.entity.PhieuGiaoHang;
import com.example.demo.reponsitory.PhieuGiaoHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PhieuGiaoHangService {

    @Autowired
    PhieuGiaoHangRepo repo;

    public Page<PhieuGiaoHang> getAll(Integer page){
        Pageable pageable = PageRequest.of(page,5);
        return repo.findAll(pageable);
    }

    public PhieuGiaoHang add(PhieuGiaoHangRequest request){

        HoaDon hoaDon =  HoaDon.builder().
        maHoaDon(Integer.parseInt(request.getHoaDonGiao()))
        .build();

        PhieuGiaoHang Phieu = PhieuGiaoHang.builder()
                .nguoiLap(request.getNguoiLap())
                .hoaDonGiao(hoaDon)
                .phiGiaoHang(request.getPhiGiaoHang())
                .sdtNhan(request.getSdtNhan())
                .nguoiNhan(request.getNguoiNhan())
        .build();

        return repo.save(Phieu);
    }

    public PhieuGiaoHang update(PhieuGiaoHangRequest request,String ma){

        HoaDon hoaDon =  HoaDon.builder().
                maHoaDon(Integer.parseInt(request.getHoaDonGiao()))
                .build();

        PhieuGiaoHang Phieu = PhieuGiaoHang.builder()
                .maPhieuGiao(UUID.fromString(ma))
                .nguoiLap(request.getNguoiLap())
                .hoaDonGiao(hoaDon)
                .phiGiaoHang(request.getPhiGiaoHang())
                .sdtNhan(request.getSdtNhan())
                .nguoiNhan(request.getNguoiNhan())
                .build();

        return repo.save(Phieu);
    }

    public PhieuGiaoHang delete(String ma){
        Optional<PhieuGiaoHang> optional = repo.findById(UUID.fromString(ma));
        return optional.map(o ->{
            repo.delete(o);
            return o;
        }).orElse(null);

    }

}
