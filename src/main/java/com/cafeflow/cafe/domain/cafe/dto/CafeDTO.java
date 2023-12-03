package com.cafeflow.cafe.domain.cafe.dto;

import lombok.Builder;
import lombok.Data;

public class CafeDTO {
    @Data
    @Builder
    public static class Response{
        private Long id;
        private String name;
        private String address;
        private double xMap;
        private double yMap;
        private int count;
        private String category;
    }
}
