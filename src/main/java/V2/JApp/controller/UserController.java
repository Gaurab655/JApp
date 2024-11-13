package V2.JApp.controller;

import V2.JApp.dto.UserDto;
import V2.JApp.entity.UserEntity;
import V2.JApp.repository.UserRepository;
import V2.JApp.services.UserServices;
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
    private UserServices userServices;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<UserEntity> createEntity( @RequestBody UserDto userDto){
        return userServices.saveEntry(userDto);
    }

    @GetMapping
    public List<UserEntity> getEntry() {
        return userServices.getEntry();
    }

    @GetMapping("/id/{id}")
    public Optional<UserEntity> getById(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    @DeleteMapping("/id/{id}")
    public boolean deleteById(@PathVariable Integer id) {
        userRepository.deleteById(id);
        return true;
    }

//    @PutMapping("/id/{id}")
//    public ResponseEntity<UserEntity> updateEntity(@PathVariable Integer id, @RequestBody UserEntity newEntityData) {
//
//        Optional<UserEntity> existingEntity = userRepository.findById(id);
//        if (existingEntity.isPresent()) {
//            existingEntity.get().setEmail(newEntityData.getEmail());
//            existingEntity.get().setPassword(newEntityData.getPassword());
//            UserEntity updatedEntity = userRepository.save(existingEntity.get());
//            return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
    @PutMapping("/id/{id}")
    public ResponseEntity<UserEntity> updateEntity(@PathVariable Integer id , @RequestBody UserEntity userEntity){
       return userServices.updateUsers(id,userEntity);
    }

}
