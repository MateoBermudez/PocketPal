package com.devcrew.logmicroservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(
        name = "LOG_USER",
        schema = "dbo"
)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogUser implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private String username;

    private String email;
}
