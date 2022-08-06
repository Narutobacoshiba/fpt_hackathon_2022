package mvc.backend_server.service;

import mvc.backend_server.dto.AccountDTO;
import mvc.backend_server.dto.RegisterResponse;
import mvc.backend_server.entity.Account;
import mvc.backend_server.entity.Role;
import mvc.backend_server.repository.AccountRepo;
import mvc.backend_server.repository.RoleRepo;
import mvc.backend_server.service.interfaces.IAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private final AccountRepo accountRepo;
    @Autowired
    private final RoleRepo roleRepo;
    @Autowired
    private ModelMapper mapper;

    public AccountService(AccountRepo accountRepo, RoleRepo roleRepo, ModelMapper mapper) {
        this.accountRepo = accountRepo;
        this.roleRepo = roleRepo;
        this.mapper = mapper;
    }

    @Override
    public List<AccountDTO> getAllAccount() {
        return accountRepo.findAll().stream()
                .map(account -> mapper.map(account, AccountDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Account saveAccount(AccountDTO accountDTO) {
        Account account = mapper.map(accountDTO, Account.class);
        accountRepo.save(account);
        return account;
    }

    @Override
    public RegisterResponse registerAccount(AccountDTO registerRequest) {
        Account newAccount = mapper.map(registerRequest, Account.class);
        String generateId = "User".concat(String.valueOf(accountRepo.findAll().size()+1));
        newAccount.setId(generateId);
        newAccount.setRegisterDate(Date.valueOf(LocalDate.now()));
        Role role = roleRepo.getById(registerRequest.getRoleId());
        System.out.println(role.getRoleId());
        newAccount.setRole(role);
        newAccount.setStatus(1);
        accountRepo.save(newAccount);
        RegisterResponse response = new RegisterResponse("Register successfully!");
        return response;
    }

    public AccountDTO getAccountById(String id) {
        Optional<Account> optAccount = accountRepo.findById(id);
        if (optAccount.isPresent()) {
            Account account = optAccount.get();
            AccountDTO accountDTO = mapper.map(account, AccountDTO.class);
            return accountDTO;
        }
        return null;
    }

}
