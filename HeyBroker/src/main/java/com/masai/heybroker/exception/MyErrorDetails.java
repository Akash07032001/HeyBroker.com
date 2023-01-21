package com.masai.heybroker.exception;

import lombok.*;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MyErrorDetails {
    
	private LocalDateTime timestamp;
    private String message;
    private String details;
}
