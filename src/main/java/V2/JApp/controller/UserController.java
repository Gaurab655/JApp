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
    private UserServices userServices;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<UserEntity> createEntity(@Valid @RequestBody UserEntity userEntity){
        return userServices.saveEntry(userEntity);
    }

    @GetMapping
    public List<UserEntity> getEntry() {
        return userServices.getEntry();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UserEntity> findById(@PathVariable Integer id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        return userEntity.map(entity -> new ResponseEntity<>(entity, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<UserEntity> updateEntity(@PathVariable Integer id, @RequestBody UserEntity newEntityData) {
        Optional<UserEntity> existingEntity = userRepository.findById(id);
        if (existingEntity.isPresent()) {
            existingEntity.get().setName(newEntityData.getName());
            existingEntity.get().setPosition(newEntityData.getPosition());
            UserEntity updatedEntity = userRepository.save(existingEntity.get());
            return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
