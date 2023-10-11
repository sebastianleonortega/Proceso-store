package com.procesos.store.service;

import com.procesos.store.model.User;
import com.procesos.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User getUserById(Long id){
        return  userRepository.findById(id).get();
    }

    public User updateUser(User user, Long id){
        Optional<User> userExist = userRepository.findById(id);
        if(userExist.isEmpty()){
            return null;
        }
        userExist.get().setFirstName(user.getFirstName());
        userExist.get().setLastName(user.getLastName());
        userExist.get().setPhone(user.getPhone());
        return userRepository.save(userExist.get());
    }

    public Boolean delete(Long id){
        Optional<User> userExist = userRepository.findById(id);
        if(userExist.isEmpty()){
            return false;
        }
        userRepository.delete(userExist.get());
        return true;
    }

    public List<User> findAllUsers(){
        return (List<User>) userRepository.findAll();
    }

}
