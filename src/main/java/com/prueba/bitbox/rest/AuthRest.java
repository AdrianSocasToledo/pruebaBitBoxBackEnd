package com.prueba.bitbox.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.prueba.bitbox.dto.LoginDTO;
import com.prueba.bitbox.dto.UserDTO;
import com.prueba.bitbox.model.Role;
import com.prueba.bitbox.model.User;
import com.prueba.bitbox.security.dto.JwtDTO;
import com.prueba.bitbox.security.enums.RoleName;
import com.prueba.bitbox.security.jwt.JwtProvider;
import com.prueba.bitbox.service.RoleServiceImpl;
import com.prueba.bitbox.service.UserServiceImpl;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthRest {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    RoleServiceImpl roleService;

    @Autowired
    JwtProvider jwtProvider;
    
    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/registerUser")
    public ResponseEntity<?> nuevo(@Validated @RequestBody UserDTO userDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity("campos mal puestos o email inválido", HttpStatus.BAD_REQUEST);
        if(userService.existsByUserName(userDTO.getUserName()))
            return new ResponseEntity("El usuario ya existe", HttpStatus.BAD_REQUEST);
        
        User user =  new User(userDTO.getUserName(), passwordEncoder.encode(userDTO.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getByRoleName(RoleName.ROLE_USER));
        if(userDTO.getRoles().contains("admin"))
            roles.add(roleService.getByRoleName(RoleName.ROLE_ADMIN));
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity("usuario guardado", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login( @RequestBody LoginDTO userDTO, BindingResult bindingResult){
    	
        if(bindingResult.hasErrors())
            return new ResponseEntity("campos mal puestos", HttpStatus.BAD_REQUEST);
        
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDTO.getUserName(),userDTO.getPassword()));
        
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDTO jwtDto = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('Admin')")
    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> delete(@RequestBody String nameUser){
    	userService.delete(nameUser);
    	return ResponseEntity.accepted().body("User "+nameUser+" was deleted");
    }
}

