package kg.itacademy.protection.service.impl;

import kg.itacademy.protection.entity.ParentEntity;
import kg.itacademy.protection.mapper.ParentMapper;
import kg.itacademy.protection.model.ParentModel;
import kg.itacademy.protection.repository.ParentRepository;
import kg.itacademy.protection.service.ParentService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ParentServiceImpl implements ParentService {

    final ParentRepository parentRepository;

    @Override
    public ParentModel create(ParentModel parentModel) {
        ParentEntity parentEntity = ParentMapper.INSTANCE.toEntity(parentModel);
        return ParentMapper.INSTANCE.toModel(parentRepository.save(parentEntity));
    }

    @Override
    public boolean update(ParentModel parentModel) {

        ParentEntity parentEntity = ParentMapper.INSTANCE.toEntity(parentModel);
        return parentRepository.save(parentEntity).getId() != null;
    }

    @Override
    public boolean delete(ParentModel parentModel) {
        try {
            parentRepository.delete(parentRepository.getByName(parentModel.getName()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
