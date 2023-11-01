package com.bae.admintemp.common.valid;

import com.bae.admintemp.common.annotation.ValidationAnnotation;
import lombok.Getter;

@Getter
public class TempDto {
    @ValidationAnnotation
    private String value;
}