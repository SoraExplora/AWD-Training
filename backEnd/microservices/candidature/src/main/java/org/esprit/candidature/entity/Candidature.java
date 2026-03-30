package org.esprit.candidature.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Candidature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int candId;
    private int jobId;
    private String motivation;
    @Enumerated(EnumType.STRING)
    private Status status;
}
