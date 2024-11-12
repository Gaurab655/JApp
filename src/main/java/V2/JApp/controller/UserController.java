package V2.JApp.controller;
import V2.JApp.entity.UserEntity;
import V2.JApp.repository.UserRepository;
import V2.JApp.services.UserServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class UserController {
    @Autowired
    public UserServices userServices;
    @Autowired
    public UserRepository userRepository;

    @PostMapping
     public ResponseEntity<UserEntity> createEntry(@Valid @RequestBody UserEntity userEntity){
     try {
         return new ResponseEntity<>(userServices.saveEntry(userEntity),HttpStatus.CREATED);
     }catch (Exception e){
         return new ResponseEntity<>(HttpStatus.OK);
     }

}
@GetMapping
public List<UserEntity> getEntry(UserEntity userEntity){
        return  userServices.getEntry();

    }
    @GetMapping("/id/{id}")
    public ResponseEntity<UserEntity> findById(@PathVariable Integer id){
      Optional<UserEntity> userEntity=userRepository.findById(id);
      if (userEntity.isPresent()){
          return new ResponseEntity<>(userEntity.get(),HttpStatus.OK);
      }else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

    }
    @DeleteMapping("/id/{id}")
    public boolean deleteById(@PathVariable Integer id){
       userRepository.deleteById(id);
       return true;
    }
    @PutMapping("/id/{id}")
    public UserEntity updateEntity(@Valid @PathVariable Integer id, @RequestBody UserEntity newEntityData) {
        return userRepository.findById(id).map(existingEntity -> {
            existingEntity.setName(newEntityData.getName());
            existingEntity.setPosition(newEntityData.getPosition());
            return userRepository.save(existingEntity);
        }).orElseThrow(() -> new RuntimeException("Entity not found"));

    }
}
