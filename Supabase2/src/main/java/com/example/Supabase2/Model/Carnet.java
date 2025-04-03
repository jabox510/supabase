package com.example.Supabase2.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "carnet")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carnet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo; // Código único del carnet

    @OneToOne(mappedBy = "carnet", cascade = CascadeType.ALL)
    private Estudiante estudiante;
}
