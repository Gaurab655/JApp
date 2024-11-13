package V2.JApp.repository;

import V2.JApp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
}
