package com.example.upcycling.service;

import com.example.upcycling.domain.dto.AdministratorDto;
import com.example.upcycling.domain.dto.ProductDto;
import com.example.upcycling.domain.vo.Criteria;
import com.example.upcycling.mapper.AdministratorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdministratorService {
    private final AdministratorMapper administratorMapper;

//    가입자만 다음페이지 접근 가능
    public Long findAdminLogin(AdministratorDto administratorDto){
        Long number = administratorMapper.selectAdminNumber(administratorDto)
                .orElseThrow(() -> new IllegalStateException("유효하지 않은 회원정보"));
        return number;
    }

//    상품 리스트 조회
    public List<ProductDto> findProductInfo(Criteria criteria){
        return administratorMapper.selectProductInfo(criteria);
    }

//    상품 카운트 조회
    public int findTotal(){
        return administratorMapper.selectTotal();
    }



}
