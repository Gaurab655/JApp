package V2.JApp.controller;

import V2.JApp.dto.AccountDto;
import V2.JApp.entity.AccountEntity;
import V2.JApp.services.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountsController {
    @Autowired
    private AccountServices accountServices;
    @PostMapping
    public ResponseEntity<AccountDto> openAccount(@RequestBody AccountDto accountDto){
        return accountServices.createAccount(accountDto);
    }

    @GetMapping
    public List<AccountEntity> getAccounts(@RequestBody AccountDto accountDto){
        return accountServices.getAccounts(accountDto);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<AccountEntity> getById(@PathVariable Long id){
        return accountServices.findById(id);

    }
    @DeleteMapping("id/{id}")
    public boolean deleteById(@PathVariable Long id){
        accountServices.delete(id);
        return true;
    }

}
