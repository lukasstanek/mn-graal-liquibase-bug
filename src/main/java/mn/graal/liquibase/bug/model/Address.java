package mn.graal.liquibase.bug.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(schema = "public") //https://stackoverflow.com/questions/45782327/org-postgresql-util-psqlexception-error-column-user0-id-does-not-exist-hibe

@Getter
@ToString //https://thorben-janssen.com/lombok-hibernate-how-to-avoid-common-pitfalls/#Be_Careful_with_ToString
@EqualsAndHashCode(callSuper = false) //https://dzone.com/articles/lombok-and-jpa-what-may-go-wrong

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address extends BaseEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    @Column(nullable = false, updatable = false, unique = true, columnDefinition = "VARCHAR(36)")
    private String id;

    @Column(nullable = false, columnDefinition = "VARCHAR(16)")
    private String postalCode;

    @Column(nullable = false, columnDefinition = "VARCHAR(15)")
    private String stateProvince;

    @Column(nullable = false, columnDefinition = "VARCHAR(60)")
    private String street;

    @Column(nullable = false, columnDefinition = "VARCHAR(10)")
    private String houseNumber;

}
