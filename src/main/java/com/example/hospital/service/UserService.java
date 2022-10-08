package com.example.hospital.service;

import com.example.hospital.entity.Account;
import com.example.hospital.entity.Role;
import com.example.hospital.reponsitory.AccountRepo;
import com.example.hospital.reponsitory.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;


@Service
public class UserService implements IUserService, UserDetailsService {

    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private RoleRepo roleRepo;


    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = accountRepo.findAccountByUsername(username);
        if(account==null){
            throw new UsernameNotFoundException("Username not found");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        account.getRoles().forEach(role ->{
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });

        return new org.springframework.security.core.userdetails.User(account.getUsername(),account.getPassword(),authorities);
    }

    @Override
    public Account GetAccountByName(String name){


        try{
            return accountRepo.findAccountByUsername(name);
        }catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public Account SaveAccount(Account account)
    {
        try{
            Role role = roleRepo.findRoleByName("ROLE_USER");
            account.setPassword(passwordEncoder().encode(account.getPassword()));
            account.getRoles().add(role);
            return accountRepo.save(account);
        }catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Role AddRole(Role role){
        try{
            return roleRepo.save(role);
        }catch (Exception e)
        {
            return null;
        }
    }


}
