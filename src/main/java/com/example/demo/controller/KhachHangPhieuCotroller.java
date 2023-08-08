package com.example.demo.controller;


import com.example.demo.dto.KhachHangRequest;
import com.example.demo.dto.PhieuGiamGiaRequest;
import com.example.demo.entity.PhieuGiamGia;
import com.example.demo.service.KhachHangPhieuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phieuKhachHang")
public class KhachHangPhieuCotroller {

    @Autowired
    KhachHangPhieuService phieuService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0",name = "page") Integer page){
        return ResponseEntity.ok(phieuService.getAll(page));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody  PhieuGiamGiaRequest request){
        return ResponseEntity.ok(phieuService.add(request));
    }
    @PutMapping("/update/{ma}")
    public ResponseEntity<?> add(@RequestBody  PhieuGiamGiaRequest request,@PathVariable("ma") String ma){
        return ResponseEntity.ok(phieuService.update(request,ma));
    }
    @DeleteMapping("/delete/{ma}")
    public ResponseEntity<?> add(@PathVariable("ma") String ma){
        return ResponseEntity.ok(phieuService.delete(ma));
    }

}
