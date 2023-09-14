package com.cafeflow.cafe.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cafe")
public class CafeController {
    private final CafeService cafeService;
    @PostMapping("/count/{cafe}")
    public ResponseEntity count(@PathVariable("cafe") Long cafeId, @RequestParam("cnt") int cnt){
        String status = cafeService.count(cafeId, cnt);
        return ResponseEntity.status(HttpStatus.OK).body(status);
    }

    @GetMapping("/view-map")
    public ResponseEntity viewMap(){
        List<CafeDTO.Response> res = cafeService.viewMap();
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}
