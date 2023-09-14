package com.cafeflow.cafe.domain;

import com.cafeflow.cafe.exception.NonExistentException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CafeService {
    private final CafeRepository cafeRepository;

    public String count(Long cafeId, int cnt) {
        Cafe cafe = cafeRepository.findById(cafeId)
                .orElseThrow(() -> new NonExistentException("존재하지 않는 카페입니다."));
        cafe.setCount(cnt);
        cafeRepository.save(cafe);
        return "SUCCESS";
    }

    public List<CafeDTO.Response> viewMap() {
        List<Cafe> cafeList = cafeRepository.findAll();
        List<CafeDTO.Response> res = new ArrayList<>();
        cafeList.forEach(v->{
            res.add(CafeDTO.Response.builder()
                    .id(v.getId())
                    .name(v.getName())
                    .address(v.getAddress())
                    .xMap(v.getXMap())
                    .yMap(v.getYMap())
                    .count(v.getCount()).build());
        });
        return res;
    }
}
