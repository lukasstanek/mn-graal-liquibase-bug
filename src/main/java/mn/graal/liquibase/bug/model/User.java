package mn.graal.liquibase.bug.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(schema = "public") //https://stackoverflow.com/questions/45782327/org-postgresql-util-psqlexception-error-column-user0-id-does-not-exist-hibe

@Getter
@Setter
@ToString //https://thorben-janssen.com/lombok-hibernate-how-to-avoid-common-pitfalls/#Be_Careful_with_ToString
@EqualsAndHashCode(callSuper = false) //https://dzone.com/articles/lombok-and-jpa-what-may-go-wrong

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {

    @Id
    @Column(nullable = false, updatable = false, unique = true, columnDefinition = "VARCHAR(36)")
    private String id;

    @Column(nullable = false, columnDefinition = "VARCHAR(60)")
    private String givenName;

    @Column(nullable = false, columnDefinition = "VARCHAR(60)")
    private String surName;

    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(254)")
    private String email;

    @Column(columnDefinition = "VARCHAR(20)")
    private String phoneNumber;

    @Column(columnDefinition = "VARCHAR(30)")
    private String nationality;

    @Column(columnDefinition = "VARCHAR(10)")
    String birthDate;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "address_id")
    Address address;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15)")
    UserType type;

}

