package com.cafeflow.cafe.domain;

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
    }
}
