package com.masai.heybroker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerCurrentSession {
    @Id
    @Column(unique = true)
    private Integer customerId;

    private String cid;

    private LocalDateTime time;
}
