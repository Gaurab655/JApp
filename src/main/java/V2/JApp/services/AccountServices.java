package V2.JApp.services;

import V2.JApp.dto.AccountDto;
import V2.JApp.dto.UserDto;
import V2.JApp.entity.AccountEntity;
import V2.JApp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServices {
   @Autowired
   private AccountRepository accountRepository;

   public ResponseEntity<AccountDto> createAccount(AccountDto accountDto){
       try {
           AccountEntity accountEntity = new AccountEntity();
           accountEntity.setEmail(accountDto.getEmail());
           accountEntity.setFullName(accountDto.getFullName());
           accountEntity.setBalance(accountDto.getBalance());
           accountEntity.setPin(accountDto.getPin());
           accountRepository.save(accountEntity);
           return new ResponseEntity<>(accountDto,HttpStatus.CREATED);
       }catch (Exception e){
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
   }
   public List<AccountEntity> getAccounts(AccountDto accountDto){
     return accountRepository.findAll();

   }
   public ResponseEntity<AccountEntity> findById(Long id){
       Optional<AccountEntity> accountEntity = accountRepository.findById(id);
       if (accountEntity.isPresent()){
           return new ResponseEntity<>(accountEntity.get(),HttpStatus.FOUND);
       }else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
   }
   public ResponseEntity<Void> delete(Long id){
       if (accountRepository.existsById(id)){
           accountRepository.deleteById(id);
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
       else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }

   }
}
