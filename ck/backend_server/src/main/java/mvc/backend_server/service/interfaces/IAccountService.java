package mvc.backend_server.service.interfaces;



import mvc.backend_server.dto.AccountDTO;
import mvc.backend_server.dto.RegisterResponse;
import mvc.backend_server.entity.Account;

import java.util.List;

public interface IAccountService {
    List<AccountDTO> getAllAccount();
    Account saveAccount(AccountDTO accountDTO);
    RegisterResponse registerAccount(AccountDTO registerRequest);
}
