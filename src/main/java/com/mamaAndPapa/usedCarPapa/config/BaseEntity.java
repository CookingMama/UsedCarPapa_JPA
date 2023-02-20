package com.mamaAndPapa.usedCarPapa.config;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
abstract public class BaseEntity {
    @CreatedDate
    private LocalDateTime createAt;
    @LastModifiedBy
    private LocalDateTime modifiedAt;
}
