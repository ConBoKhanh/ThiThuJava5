package com.example.demo.controller;


import com.example.demo.dto.PhieuGiaoHangRequest;
import com.example.demo.entity.PhieuGiaoHang;
import com.example.demo.service.PhieuGiaoHangService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phieuGiaoHang")
public class PhieuGiaoHangContoller {

    @Autowired
    PhieuGiaoHangService service;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0",name = "page") Integer page){
        return ResponseEntity.ok(service.getAll(page));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @Valid PhieuGiaoHangRequest request, BindingResult result){
        if(result.hasErrors()){
            List<ObjectError> errors = result.getAllErrors();
            return ResponseEntity.ok(errors);
        }else{
            return ResponseEntity.ok(service.add(request));
        }

    }
    @PutMapping("/update/{ma}")
    public ResponseEntity<?> update(@RequestBody @Valid PhieuGiaoHangRequest request, BindingResult result,@PathVariable String ma){
        if(result.hasErrors()){
            List<ObjectError> errors = result.getAllErrors();
            return ResponseEntity.ok(errors);
        }else{
            return ResponseEntity.ok(service.update(request,ma));
        }

    }
    @DeleteMapping("/delete/{ma}")
    public ResponseEntity<?> getAll(@PathVariable String ma){
        return ResponseEntity.ok(service.delete(ma));
    }

}
