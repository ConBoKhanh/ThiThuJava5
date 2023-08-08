package com.example.demo.controller;

import com.example.demo.dto.KhachHangRequest;
import com.example.demo.service.KhachHangService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/khachHang")
public class KhachHangCotroller {

    @Autowired
    private KhachHangService service;

    // get list khach hang
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0", name = "page") Integer page){
        return  ResponseEntity.ok(service.getAll(page));
    }

    //add khach hang
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @Valid KhachHangRequest request, BindingResult result){
        if(result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.ok(list);
        }else {
            return  ResponseEntity.ok(service.add(request));
        }
    }

    //update khach hang
    @PutMapping("/update/{ma}")
    public ResponseEntity<?> add(@RequestBody @Valid KhachHangRequest request, BindingResult result,@PathVariable Long ma){
        if(result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.ok(list);
        }else {
            return  ResponseEntity.ok(service.update(request,ma));
        }
    }

    //detail khach hang
    @GetMapping("/detail/{ma}")
    public ResponseEntity<?> detail(@PathVariable Long ma){

       return  ResponseEntity.ok(service.detail(ma));

    }

    //xoa
    @DeleteMapping("/delete/{ma}")
    public ResponseEntity<?> Delete(@PathVariable Long ma){
        return  ResponseEntity.ok(service.delete(ma));
    }

    //tim theo hang
    @GetMapping("/hang/{ma}")
    public ResponseEntity<?> hang(@PathVariable String ma){

        return  ResponseEntity.ok(service.hang(ma));

    }

    //tim theo ten
    @GetMapping("/tenLike/{ten}")
    public ResponseEntity<?> getTen(@PathVariable String ten){

        return  ResponseEntity.ok(service.getTenLike(ten));

    }

}
