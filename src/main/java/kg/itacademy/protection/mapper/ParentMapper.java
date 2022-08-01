package kg.itacademy.protection.mapper;

import kg.itacademy.protection.entity.ParentEntity;
import kg.itacademy.protection.model.ParentModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ParentMapper {

    ParentMapper INSTANCE = Mappers.getMapper(ParentMapper.class);

    ParentEntity toEntity(ParentModel parentModel);

    ParentModel toModel(ParentEntity parentEntity);

    List<ParentModel> toParentModels(List<ParentEntity> parentEntityList);
}
