package lukasz.exercise_app.Service;


import lukasz.exercise_app.Entities.Registration;

import java.time.LocalDate;
import java.util.List;

public interface RegistrationService {

    public List<Registration> findAll();
    public List<String> findName(String name);
    public List<String> findSurname(String surname);
    public List<Integer> findAge(Integer age);
    public List<Long> findPesel(Long pesel);
    public List<String> findBirth(String birth);
    public  List<String> findAdress(String adress);
    public  List<String> findEmail(String email);
    public List<Integer> findMobile(Integer mobile);

    public List<Registration> addAll();
    public void addName(String name);
    public void addSurname(String surname);
    public void addAge(Integer age);
    public void addPesel(Long pesel);
    public void addBirth(LocalDate birth);
    public void addAdress(String adress);
    public void addEmail(String email);
    public void addMobile(Integer mobile);

    public List<Registration> updateAll();
    public void updateName(String name);
    public void updateSurname(String surname);
    public void updateAge(Integer age);
    public void updatePesel(Long pesel);
    public void updateBirth(LocalDate birth);
    public void updateAdress(String adress);
    public void updateEmail(String email);
    public void updateMobile(Integer mobile);

    public List<Registration> deleteAll();
    public void deleteName(String name);
    public void deleteSurname(String surname);
    public void deleteAge(Integer age);
    public void deletePesel(Long pesel);
    public void deleteBirth(LocalDate birth);
    public void deleteAdress(String adress);
    public void deleteEmail(String email);
    public void deleteMobile(Integer mobile);



}
