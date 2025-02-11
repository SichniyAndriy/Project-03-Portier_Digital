package s_lab.sichniy_andriy.portier_digital.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.Objects;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.type.SqlTypes;

@Getter @Setter @ToString @NoArgsConstructor
@Entity @Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skills_gen")
    @SequenceGenerator(name = "skills_gen", sequenceName = "skills_seq", allocationSize = 1)
    @Column(nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @Column(name = "title", nullable = false, length = 50, unique = true, updatable = false, insertable = false)
    private String title;

    @Column(name = "description", length = 2000)
    private String description;


    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        Class<?> oEffectiveClass = o instanceof HibernateProxy ?
                ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ?
                ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) {
            return false;
        }
        Skill skill = (Skill) o;
        return getId() != null && Objects.equals(getId(), skill.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ?
                ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

}
