package com.example.application.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "info_studentTESTING")
public class TestingEntity extends AbstractEntity{

    private String first_name;
    private String last_name;
    private enum gender {
        Männlich,
        Weiblich
    };
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('MALE', 'FEMALE')")
    private gender gender;

    private String s_class;

    private String stud_loc;

    @ManyToOne
    @JoinColumn(name = "roles")
    private Roles role;

    @Entity
    @Table(name = "roles")
    public class Roles {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;

    }




}
