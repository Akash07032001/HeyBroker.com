package com.masai.heybroker.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class BrokerCurrentSession {

	
	@Id
    @Column(unique = true)
    private Integer brokerId;

    private String bid;

    private LocalDateTime time;
}
