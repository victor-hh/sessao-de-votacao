package com.haberkamp.sessaodevotacao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetailsDTO {
    private Date timestamp;
    private String message;
    private int status;
    private String error;
    private String path;
}