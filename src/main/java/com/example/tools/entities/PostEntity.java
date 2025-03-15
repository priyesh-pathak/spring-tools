package com.example.tools.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="post")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

     private String description;
}
