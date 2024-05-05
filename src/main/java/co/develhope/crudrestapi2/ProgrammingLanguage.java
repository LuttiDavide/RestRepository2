package co.develhope.crudrestapi2;

import jakarta.persistence.*;

@Entity
public class ProgrammingLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Integer firstAppearance;

    @Column(nullable = false)
    private String inventor;

}
