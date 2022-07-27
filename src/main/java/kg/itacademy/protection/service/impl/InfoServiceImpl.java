package kg.itacademy.protection.service.impl;

import kg.itacademy.protection.entity.InfoEntity;
import kg.itacademy.protection.mapper.InfoMapper;
import kg.itacademy.protection.model.InfoModel;
import kg.itacademy.protection.repository.InfoRepository;
import kg.itacademy.protection.service.InfoService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InfoServiceImpl implements InfoService {

    final InfoRepository infoRepository;

    @Override
    public InfoModel create(InfoModel infoModel) {

        InfoEntity infoEntity= InfoMapper.INSTANCE.toEntity(infoModel);
        return InfoMapper.INSTANCE.toModel(infoRepository.save(infoEntity));
    }

    @Override
    public boolean update(InfoModel infoModel) {

        InfoEntity infoEntity = InfoMapper.INSTANCE.toEntity(infoModel);
        return infoRepository.save(infoEntity).getId() != null;
    }
    @Override
    public boolean delete(InfoModel infoModel) {
        try {
            infoRepository.delete(infoRepository.getByName(infoModel.getName()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
