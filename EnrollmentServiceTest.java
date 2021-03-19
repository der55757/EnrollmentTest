import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.mockito.Mock;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;



public class EnrollmentServiceTest {
 
  
   @Mock
   private DependentDAO mockDependentDao;
  
   @Mock
   private EnrolleeDao mockEnrolleDao;
  
   private EnrollmentService subject = new EnrollmentService();
  
  
  @Test
  public void addEnrollee_happyCase_returnsEnrollee(){
   
    _Enrollee actual = subject.addEnrollee(buildEnrollee());
    
    assertThat(actual.getEnrolleeId()).isNotNull();
    assertThat(actual.getDob()).isNotNull();
    assertThat(actual.getActivationstatus()).isEqualTo(false);
    assertThat(actual.getPhone()).isEqualTo("313-987-6543");
    assertThat(actual.getName()).isEqualTo("Test");
    
  }
  
  //name and DOB can not equal null so an error is thrown
   @Test(expected = RuntimeException.class)
    public void addEnrollee_whenNanmeAndDobIsNull_throwsRuntimeException() {
       _Enrollee enrollee = new _Enrollee();

        subject.addEnrollee(enrollee);
    }
  
  @Test
  public void modifyEnrollee_happyCase_returnsEnrollee(){
    
    
    _Enrollee enrollee = subject.addEnrollee(buildEnrollee());
    
    enrollee.setActivationstatus(true);
    enrollee.setName("Tester");
   
    _Enrollee actual = subject.modifyEnrollee(enrollee);
    
    assertThat(actual.getEnrolleeId()).isNotNull();
    assertThat(actual.getDob()).isNotNull();
    assertThat(actual.getActivationstatus()).isEqualTo(true);
    assertThat(actual.getPhone()).isEqualTo("313-987-6543");
    assertThat(actual.getName()).isEqualTo("Tester");
    
  }
  
  //enrollee does not exist so an error is thrown
   @Test(expected = RuntimeException.class)
    public void modifyEnrollee_whenNanmeAndDobIsNull_throwsRuntimeException() {
       _Enrollee enrollee = new _Enrollee();

        subject.modifyEnrollee(enrollee);
    }
  
  @Test
  public void removeEnrollee_happyCase_removesEnrollee(){
   
    _Enrollee enrollee = subject.addEnrollee(buildEnrollee());
    
    subject.removeEnrollee(enrollee.getEnrolleeId());
    
    _Enrollee actual = mockEnrolleDao.get(enrollee.getEnrolleeId());
    
    assertThat(actual).isNull();
    
  }
  
  @Test
  public void addDependents_happyCase_addDependents(){
   
    _Enrollee enrollee = subject.addEnrollee(buildEnrollee());
    
    subject.addDependents(enrollee.getEnrolleeId(), buildDependents());
    
    _Enrollee actual = mockEnrolleDao.get(enrollee.getEnrolleeId());
    
    assertThat(actual.getDependents.size()).isEqualTo(2);
    
  }
 
  @Test(expected = RuntimeException.class)
  public void addDependents_nullCheck_throwsError(){
   
    _Enrollee enrollee = subject.addEnrollee(buildEnrollee());
   
    List<_Dependent> dependents =  buildDependents()
    _Dependent dep3 = new _Dependent(); 
    dependents.add(dep3);
    
    subject.addDependents(enrollee.getEnrolleeId(), dependents);
    
  }
  
  @Test
  public void removeDependent_happyCase_removeDependent(){
    
    List<long> ids = new ArrayList();
    
    ids.add(321L);
   
    _Enrollee enrollee = subject.addEnrollee(buildEnrollee());
    
    subject.addDependents(enrollee.getEnrolleeId(), buildDependents());
    subject.removeDependents(enrollee.getEnrolleeId(), ids);
    
    _Enrollee actual = mockEnrolleDao.get(enrollee.getEnrolleeId());
    
    assertThat(actual.getDependents.size()).isEqualTo(1);
    
  }
  
  private List<_Dependent> buildDependents(){
    
    List<_Dependent> dependents = new ArrayList();
    
    _Dependent dp1 = new _Dependent();
    
    dp1.setName("depend One");
    dp1.setDob(new Date());  
    dp1.setId(123L);
    
    dp2.setName("depend Two");
    dp2.setDob(new Date());  
    dp2.setId(321L);
    
    dependents.add(dp1);
    dependents.add(db2);
    
    return dependents;
  }
  
  
  private _Enrollee buildEnrollee(){ 
    _Enrollee enrollee = new _Enrollee();
    
    enrollee.setName("Test");
    enrollee.setDob(new Date());
    enrollee.setActivationstatus(false);
    enrollee.setPhone("313-987-6543"); 
    
    return enrollee;
  }
  
  
  
}
