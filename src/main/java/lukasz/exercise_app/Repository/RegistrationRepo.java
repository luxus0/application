package lukasz.exercise_app.Repository;

import lukasz.exercise_app.Entities.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface RegistrationRepo  extends JpaRepository<Registration,Integer> {


    //Transaction id
    @Query(value="SELECT tx.trx_id FROM information_schema.innodb_trx tx "
            + "WHERE tx.trx_mysql_thread_id = connection_id()", nativeQuery=true)
    public Object getTransactionId();

    @Query(value = "Select * from registration where name = ?",nativeQuery = true)
    @Transactional(readOnly=true)
    List<Registration> findName(String name);

    @Query(value = "Select * from registration where surname = ?",nativeQuery = true)
    List<Registration> findSurname(String surname);

    @Query(value = "Select * from registration where age = ?",nativeQuery = true)
    List<Registration> findAge(Integer age);

    @Query(value = "Select * from registration where pesel = ?",nativeQuery = true)
    List<Registration> findPesel(Long pesel);

    @Query(value = "Select * from registration where birth = ?",nativeQuery = true)
    List<Registration> findBirth(String birth);

    @Query(value = "Select * from registration where adress = ?",nativeQuery = true)
    List<Registration> findAdress(String adress);

    @Query(value = "Select * from registration where email = ?",nativeQuery = true)
    List<Registration> findEmail(String email);

    @Query(value = "Select * from registration where mobile = ?",nativeQuery = true)
    List<Registration> findMobile(Integer mobile);



}
