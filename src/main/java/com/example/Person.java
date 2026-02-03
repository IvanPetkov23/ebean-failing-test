package com.example;

import io.ebean.annotation.WhenCreated;
import io.ebean.annotation.WhenModified;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(schema="schema_test", name = "person_test")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 8591687683352009922L;

    @Id
    private UUID id;
    private String name;

    @WhenCreated
    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @WhenModified
    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;
}
