
  
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.Date;


@Entity
@Table(name = "ENROLLEE")

public class _Dependent  {

    private long dependentId;
    private long enrolleeId
    private Date dob;
    private String name;



    @Id
    @Column(name = "DEPENDENT_ID", nullable = false)
    @GeneratedValue(generator = "OIdGenerator", strategy = GenerationType.SEQUENCE)
    public Long getDependentId() {
        return dependentId;
    }

    @Column(name = "DEPENDENT_ID", nullable = false)
    public void setDependentId(Long dependentId) {
        this.dependentId = dependentId;
    }
    
    @Id
    @Column(name = "ENROLLEE_ID", nullable = false)
    public Long getEnrolleeId() {
        return enrolleeId;
    }

    @Column(name = "ENROLLEE_ID", nullable = false)
    public void setEnrolleeId(Long enrolleeId) {
        this.enrolleeId = enrolleeId;
    }
  
    
    @Column(name = "DOB", nullable = false)
    public Date getDob() {
        return dob;
    }

    @Column(name = "DOB", nullable = false)
    public void setDob(Date dob) {
        this.dob = dob;
    }
    
     @Column(name = "NAME", nullable = false)
    public String getName() {
        return name;
    }

    @Column(name = "NAME", nullable = false)
    public void setName(final String name) {
        this.name = name;
    }


}
