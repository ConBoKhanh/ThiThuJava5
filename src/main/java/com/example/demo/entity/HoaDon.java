package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "HoaDon")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HoaDon {

    @Id
    @Column(name = "MaHoaDon")
    private Integer maHoaDon;

    @Column(name = "GhiChu")
    private String ghiChu;
}
