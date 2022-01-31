package com.consultadd.springsecurityjpa.service;

import com.consultadd.springsecurityjpa.model.Customer;
import com.consultadd.springsecurityjpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    CustomerRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = repository.findByUsername(username);

        if(customer == null){
            throw new UsernameNotFoundException("Not found " + username);
        }

        return customer;
    }
}
