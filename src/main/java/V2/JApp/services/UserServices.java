package V2.JApp.services;
import V2.JApp.entity.UserEntity;
import V2.JApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServices {
    @Autowired
    public UserRepository userRepository;

    public UserEntity saveEntry(UserEntity userEntity){
       return userRepository.save(userEntity);
    }

    public List<UserEntity> getEntry(){
        return userRepository.findAll();
    }
}
