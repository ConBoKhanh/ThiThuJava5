package com.example.demo.reponsitory;

import com.example.demo.entity.PhieuGiamGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhieuGiamGiaRepo extends JpaRepository<PhieuGiamGia,String> {

}
