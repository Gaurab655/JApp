package V2.JApp.services;

import V2.JApp.dto.UserDto;
import V2.JApp.entity.UserEntity;
import V2.JApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;


    public ResponseEntity<UserEntity> saveEntry(UserDto userDto) {
        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setEmail(userDto.getEmail());
            userEntity.setPassword(userDto.getPassword());
            return new ResponseEntity<>(userRepository.save(userEntity), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public List<UserEntity> getEntry() {
        return userRepository.findAll();
    }


    public ResponseEntity<UserEntity> getById(Integer id) {
       Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isPresent()){
            return new ResponseEntity<>(userEntity.get(),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<Void> deleteByID(Integer id){
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<UserEntity> updateUsers(Integer id,UserEntity userEntity ){
        Optional<UserEntity> updateEntity = userRepository.findById(id);
        if (updateEntity.isPresent()){
            updateEntity.get().setEmail(updateEntity.userEntity.getEmail(id));

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
