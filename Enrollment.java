import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "ENROLLEE")

public class _Enrollee  {

/**
- Enrollees must have an id, name, and activation status (true or false), and a birth date
- Enrollees may have a phone number (although they do not have to supply this)
- Enrollees may have zero or more dependents
- Each of an enrollee's dependents must have an id, name, and birth date

*/

    private long enrolleeId;
    private Boolean activationStatus;
    private Date dob;
    private String phone;
    private Set <_Dependents> dependents = new HashSet<>();



    @Id
    @Column(name = "ENROLLEE_ID", nullable = false)
    @GeneratedValue(generator = "OIdGenerator", strategy = GenerationType.SEQUENCE)
    public Long getEnrolleeId() {
        return enrolleeId;
    }

    @Column(name = "ENROLLEE_ID", nullable = false)
    public void setCreditApplicationOid(Long enrolleeId) {
        this.enrolleeId = enrolleeId;
    }
    
    @Column(name="ACTIVATION_STATUS", nullable = false)
    @Type(type="true_false")
    public Boolean iSActivationStatus() {
        return activationStatus;
    }

    public void setActivationStatus(final Boolean activationStatus) {
        this.activationStatus = activationStatus;
    }
    
    @Column(name = "DOB", nullable = false)
    public Date getDob() {
        return dob;
    }

    @Column(name = "DOB", nullable = false)
    public void setDob(Date dob) {
        this.dob = dob;
    }
    
    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    @Column(name = "PHONE")
    public void setphone(String phone) {
        this.phone = phone;
    }
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "enrolleeId")
    @Fetch(FetchMode.JOIN)
    public Set<_Dependents> getDependents() {
        return dependents;
    }

    public void setApplicants(Set<_Dependents> dependents) {
        this.dependents = dependents;
    }






}
