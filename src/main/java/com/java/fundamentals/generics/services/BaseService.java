package com.java.fundamentals.generics.services;

import com.java.fundamentals.generics.repository.BaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class  BaseService<T,DTO,ID extends Serializable> {

    @Autowired
    private ModelMapper modelMapper;
    private final BaseRepository<T, ID> repository;
    private final Class<T> entityClass;
    private final Class<DTO> dtoClass;

    public BaseService(ModelMapper modelMapper, BaseRepository<T, ID> repository, Class<T> entityClass, Class<DTO> dtoClass) {
        this.modelMapper = modelMapper;
        this.repository = repository;
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }


    @Transactional
    public DTO addUser(DTO dto){
        modelMapper.map(dto, entityClass);
        T savedEntity = repository.save(modelMapper.map(dto, entityClass));
        return modelMapper.map(savedEntity,dtoClass);}

    public List<DTO> findAll(){
        return repository.findAll().
                stream()
                .map(entity -> modelMapper.map(entity,dtoClass))
                        .collect(Collectors.toList());}

    public Optional<DTO> findById(ID id){
        return repository.findById(id).map(entity -> modelMapper.map(entity,dtoClass));}

    @Transactional
    public void deleteById(ID id){ repository.deleteById(id);}

    public List<DTO> findByIds(List<ID> ids){
        return repository.findByIdIn(ids).
                stream().
                map(entity -> modelMapper.map(entity,dtoClass)).
                collect(Collectors.toList());
    }
 }
