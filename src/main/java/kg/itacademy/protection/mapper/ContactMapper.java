package kg.itacademy.protection.mapper;

import kg.itacademy.protection.entity.ContactEntity;
import kg.itacademy.protection.model.ContactModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContactMapper {
    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    ContactEntity toEntity(ContactModel contactModel);

    ContactModel toModel(ContactEntity contactEntity);

    List<ContactModel> toContactModels(List<ContactEntity> contactEntityList);
}
