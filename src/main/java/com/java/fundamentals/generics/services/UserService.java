package com.java.fundamentals.generics.services;

import com.java.fundamentals.generics.dto.UserDTO;
import com.java.fundamentals.generics.entity.User;
import com.java.fundamentals.generics.repository.BaseRepository;
import com.java.fundamentals.generics.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User, UserDTO,Long>{
    public UserService(ModelMapper modelMapper, BaseRepository<User, Long> repository) {
        super(modelMapper, repository, User.class, UserDTO.class    );
    }
}

