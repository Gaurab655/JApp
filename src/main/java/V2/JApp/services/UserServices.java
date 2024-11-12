package V2.JApp.services;

import V2.JApp.entity.UserEntity;
import V2.JApp.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;


//    public UserEntity saveEntry(UserEntity userEntity) {
//        return userRepository.save(userEntity);
//    }
    public ResponseEntity<UserEntity> saveEntry( UserEntity userEntity){
        try {
            return new ResponseEntity<>(userRepository.save(userEntity), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public List<UserEntity> getEntry() {
        return userRepository.findAll();
    }


    public Optional<UserEntity> getById(Integer id) {
        return userRepository.findById(id);
    }
}
