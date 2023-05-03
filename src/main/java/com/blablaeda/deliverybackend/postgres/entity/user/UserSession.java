package com.blablaeda.deliverybackend.postgres.entity.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(schema = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSession {
    @Id
    private Long id;
    @OneToOne
    private User user;
    private String ipAddress;
    private LocalDateTime createDate;
    private LocalDateTime lastActivity;
    private Boolean isActive;
    private LocalDateTime expirationTermDate;
}
