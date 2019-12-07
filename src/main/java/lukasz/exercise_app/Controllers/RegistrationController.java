package lukasz.exercise_app.Controllers;

import lukasz.exercise_app.Entities.Registration;
import lukasz.exercise_app.Error_Handling.ResourceNotFoundException;
import lukasz.exercise_app.Repository.RegistrationRepo;
import lukasz.exercise_app.Service.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationRepo repo;
    private RegistrationService service;
    private Registration registration;
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/registration")
    public List<Registration> getAll() {
        return repo.findAll();
    }


    @GetMapping("/registration/{id}")
    public @ResponseStatus
    ResponseEntity<Optional<Registration>> getById(@PathVariable Integer id) {

        Optional<Registration> registration =  repo.findById(id);
        return ResponseEntity.ok().body(registration);

    }


    @PostMapping("/registration")
    public Registration addAll(@Valid @RequestBody Registration registation) throws ResourceNotFoundException {

    return repo.save(registration);


    }

    @PutMapping("/registration/{id}")
    public @ResponseStatus
    ResponseEntity<Registration> updateRegistration(@RequestBody Registration reg, @PathVariable Integer id) throws ResourceNotFoundException {
        Registration registration = repo.findById(reg.getId()).orElseThrow(() -> new ResourceNotFoundException("Registration not found for this id: ",reg.getId()));

        registration.setId(reg.getId());
        registration.setName(reg.getName());
        registration.setSurname(reg.getSurname());
        registration.setAge(reg.getAge());
        registration.setBirth(reg.getBirth());
        registration.setEmail(reg.getEmail());
        registration.setAdress(reg.getAdress());
        registration.setMobile(reg.getMobile());
        registration.setPesel(reg.getPesel());

        Registration updateRegistration = repo.save(registration);
        return ResponseEntity.ok(updateRegistration);
    }

    @DeleteMapping("/registration/{id}")
    public ResponseEntity<Registration> deteleById(@PathVariable("id") Integer id) throws ResourceNotFoundException {

                repo.deleteById(id);

                if(repo.findAll().isEmpty())
                {
                    return ResponseEntity.ok().build();
                }
                else
                {
                    throw new ResourceNotFoundException("REGISTRATION IS FULL RECORD: ",id);
                }


            }



    }


