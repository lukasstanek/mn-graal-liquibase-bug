package mn.graal.liquibase.bug.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass //https://vladmihalcea.com/how-to-inherit-properties-from-a-base-class-entity-using-mappedsuperclass-with-jpa-and-hibernate/ or https://stackoverflow.com/questions/221611/creation-timestamp-and-last-update-timestamp-with-hibernate-and-mysql/60360233#60360233
// @ToString and @EqualsAndHashCode are not useful here because the values are dynamically created by Hibernate
public abstract class BaseEntity {

    @Version
    @Column(nullable = false)
    private Long version;

    @CreationTimestamp
    @Column(nullable = false, updatable=false)
    private LocalDateTime createdOn;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime modifiedOn;

}
