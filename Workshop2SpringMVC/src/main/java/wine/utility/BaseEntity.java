package wine.utility;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Data
@MappedSuperclass
public abstract class BaseEntity<ID> implements Serializable {

    /** Base entity superclass allows for a generic id type "ID" to accommodate possible future non-long id types */

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected ID id;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    protected Date createdOn;

    @LastModifiedDate
    protected Date lastModifiedOn;

    @PrePersist
    public void setCreationDate() {
        this.createdOn = new Date();
    }

    @PreUpdate
    public void setLastUpdated() {
        this.lastModifiedOn = new Date();
    }

}
