

public class EnrollmentService {
  
  @Autowired
  EnrollmentDAO enrollmentDao;  //Standard DAO with CRUD opeartions set
  
  @Autowired
  DependentDAO dependentDao; //Standard DAO with Crud operations set
  

  //User passes in enrollee data to create
  public _Enrollee addEnrollee(_Enrollee enrollee){

   if(enrollee.getName() == null || enrollee.getDob() == null || enrollee.getActivationStatus() == null)
	   throw RuntimeException("Missing a required field");
   
    //Would have DAO with basic SessionFactory info for save update and delete with hibernate 
    return enrollmentDao.persist(enrollee);
    
  }
  
  public _Enrollee modifyEnrollee(_Enrollee enrollee){
    
    _Enrollee actual = enrollmentDao.get(enrollee.getEnrolleeId());
    
    if(actual == null)
      throw RuntimeException("Enrollee does not exist");
    
    actual.setName(enrollee.getName());
    actual.setPhone(enrollee.getPhone());
    actual.setDob(enrollee.getDob());
    actual.setActivationstatus(enrollee.getAcivationStatus());      
    
    enrollmentDao.update(actual); 
    
    return actual;
    
  }
  
  public void removeEnrollee(long id){
    
    enrollmentDao.delete(id);
  }
  
  public void addDependents(long enrolleeId, List<_Dependent> dependents){
    
     _Enrollee actual = enrollmentDao.get(enrolleeId);
    
    if(actual == null)
      throw RuntimeException("Enrollee does not exist");

   
    dependents.stream().forEach(dependent-> verifyDependent(dependent));
    
    actual.getDependents().addAll(dependnents);
    
    enrollmentDao.update(actual); 

    
  }
  
  public void removeDependents(long enrolleeId, List<long> dependentIds){
    
     _Enrollee actual = enrollmentDao.get(enrolleeId);
    
    if(actual == null)
      throw RuntimeException("Enrollee does not exist");
    
    for(Long id: dependentIds){
	actual.getDependents().remove(dependentDao.get(id));
    }
    
    enrollmentDao.update(actual); 

    
  }
  
  public _Dependent modifyDependent(_Dependent dependent){
    
    _Dependent actual = dependentDao.get(dependent.getDependentId());
    
    if(actual == null)
      throw RuntimeException("dependent does not exist");
	  
    verifyDependent(dependent);
    
    actual.setName(dependent.getName());
    actual.setDob(dependent.getDob());
    
    dependentDao.update(actual); 
    
    return actual;
    
  }

 private void verifyDependent(_Dependent dependent){
	 
	 if(dependent.getName() == null || dependent.getDob() == null)
		 throw RuntimeException("Missing a required field");
	 
	 
 }
  
  
  
  
}
