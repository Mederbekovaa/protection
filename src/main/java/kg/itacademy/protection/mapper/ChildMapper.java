package kg.itacademy.protection.mapper;

import kg.itacademy.protection.entity.ChildEntity;
import kg.itacademy.protection.model.ChildModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ChildMapper {
    ChildMapper INSTANCE = Mappers.getMapper(ChildMapper.class);

    ChildEntity toEntity(ChildModel childModel);

    ChildModel toModel(ChildEntity childEntity);

    List<ChildModel> toChildModels(List<ChildEntity> childEntityList);
}
