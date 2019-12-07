package lukasz.exercise_app.Service;

import lukasz.exercise_app.Entities.Registration;
import lukasz.exercise_app.Repository.RegistrationRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public class RegistrationServiceImpl implements RegistrationService{

private RegistrationRepo repo;
private RegistrationService service;
private Registration registration;

private Logger log = LoggerFactory.getLogger(RegistrationServiceImpl.class);

@Transactional
public void displayTransactionId()
{
    repo.findName("Milek");

    Object transactionId = repo.getTransactionId();
    System.out.println("Transaction id: " +transactionId);

}





    @Override
    public List<Registration> findAll() {
        return service.findAll();
    }

    @Override
    public List<String> findName(String name) {

        if(name == null)
        {
            log.error("Names is empty!!");
        }
        else
        {
            log.info(name);
        }
        return service.findName(name);
    }

    @Override
    public List<String> findSurname(String surname) {
        if(surname == null)
        {
            log.error("Surname is empty!");
        }
        else
        {
            log.info(surname);
        }
        return service.findSurname(surname);
    }

    @Override
    public List<Integer> findAge(Integer age) {
        return service.findAge(age);
    }

    @Override
    public List<Long> findPesel(Long pesel) {
        return service.findPesel(pesel);
    }

    @Override
    public List<String> findBirth(String birth) {
        return service.findBirth(birth);
    }

    @Override
    public List<String> findAdress(String adress) {
        return service.findAdress(adress);
    }

    @Override
    public List<String> findEmail(String email) {
        return service.findEmail(email);
    }

    @Override
    public List<Integer> findMobile(Integer mobile) {
        return service.findMobile(mobile);
    }

    @Override
    public List<Registration> addAll() {
        return service.addAll();
    }

    @Override
    public void addName(String name) {

    }

    @Override
    public void addSurname(String surname) {

    }

    @Override
    public void addAge(Integer age) {

    }

    @Override
    public void addPesel(Long pesel) {

    }

    @Override
    public void addBirth(LocalDate birth) {

    }

    @Override
    public void addAdress(String adress) {

    }

    @Override
    public void addEmail(String email) {

    }

    @Override
    public void addMobile(Integer mobile) {

    }

    @Override
    public List<Registration> updateAll() {
        return null;
    }

    @Override
    public void updateName(String name) {

    }

    @Override
    public void updateSurname(String surname) {

    }

    @Override
    public void updateAge(Integer age) {

    }

    @Override
    public void updatePesel(Long pesel) {

    }

    @Override
    public void updateBirth(LocalDate birth) {

    }

    @Override
    public void updateAdress(String adress) {

    }

    @Override
    public void updateEmail(String email) {

    }

    @Override
    public void updateMobile(Integer mobile) {

    }

    @Override
    public List<Registration> deleteAll() {
        return null;
    }

    @Override
    public void deleteName(String name) {

    }

    @Override
    public void deleteSurname(String surname) {

    }

    @Override
    public void deleteAge(Integer age) {

    }

    @Override
    public void deletePesel(Long pesel) {

    }

    @Override
    public void deleteBirth(LocalDate birth) {

    }

    @Override
    public void deleteAdress(String adress) {

    }

    @Override
    public void deleteEmail(String email) {

    }

    @Override
    public void deleteMobile(Integer mobile) {

    }
}
