package mvc.backend_server.controller;

import mvc.backend_server.config.JwtUtils;
import mvc.backend_server.dto.AccountDTO;
import mvc.backend_server.dto.LoginRequest;
import mvc.backend_server.dto.LoginResponse;
import mvc.backend_server.dto.RegisterResponse;
import mvc.backend_server.jwtService.JwtUserDetailsService;
import mvc.backend_server.service.interfaces.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("authenticate")
@CrossOrigin
public class AuthController {

    @Autowired
    private IAccountService accountService;

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final JwtUserDetailsService jwtUserDetailsService;

    public AuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils, JwtUserDetailsService jwtUserDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.jwtUserDetailsService = jwtUserDetailsService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest) throws Exception{
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        System.out.println(userDetails.getUsername());
        if(userDetails.getUsername().equalsIgnoreCase("lockedAccount")){
            return ResponseEntity.ok(new LoginResponse(null, "Account has been locked!"));
        } else {
            final String token = jwtUtils.generateToken(userDetails);
            return ResponseEntity.ok(new LoginResponse(token, "login successfully"));
        }
//        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody AccountDTO newAccount){
        RegisterResponse accountResponse = accountService.registerAccount(newAccount);
        return ResponseEntity.ok(accountResponse);
    }
}
