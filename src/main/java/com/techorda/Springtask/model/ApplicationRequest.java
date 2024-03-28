package com.techorda.Springtask.model;

import jakarta.persistence.*;
import lombok.*;
import org.w3c.dom.Text;

@Entity
@Table(name = "request")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApplicationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Column
    private String userName;
    @Column
    private String courseName;

    @Column(name = "commentary", columnDefinition = "TEXT")
    private String commentary;

    @Column(name = "number_phone")
    private String phone;

    boolean handled; //обработано или нет
}
