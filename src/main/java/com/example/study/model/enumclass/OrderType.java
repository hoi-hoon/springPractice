package com.example.study.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderType {
    ALL(0,"묶음","모든 상품을 묶음배송"),
    EACH(1,"개별","준비되는대로 발송")
    ;
    private Integer id;
    private String title;
    private String description;
}
