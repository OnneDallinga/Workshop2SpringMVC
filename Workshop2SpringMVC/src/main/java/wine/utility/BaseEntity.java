package wine.utility;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
@MappedSuperclass
public abstract class BaseEntity<ID> implements Serializable {

    /** Base entity superclass allows for a generic id type "ID" to accommodate possible future non-long id types */

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on", nullable = false)
    private Date createdAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_on")
    private Date lastModifiedAt;

    @PrePersist
    public void setCreationDate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    public void setModificationDate() {
        this.lastModifiedAt = new Date();
    }

}
