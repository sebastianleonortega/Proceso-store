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
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
    }

    public User updateUser(User user, Long id) {
        Optional<User> userExist = userRepository.findById(id);
        if (userExist.isPresent()) {
            User existingUser = userExist.get();
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setPhone(user.getPhone());
            return userRepository.save(existingUser);
        }
        return null;
    }

    public Boolean delete(Long id) {
        Optional<User> userExist = userRepository.findById(id);
        if (userExist.isPresent()) {
            userRepository.delete(userExist.get());
            return true;
        }
        return false;
    }

    public List<User> findAllUsers(){
        return (List<User>) userRepository.findAll();
    }

}
