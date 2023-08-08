package com.example.demo.reponsitory;

import com.example.demo.entity.PhieuGiaoHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PhieuGiaoHangRepo extends JpaRepository<PhieuGiaoHang, UUID> {
}
