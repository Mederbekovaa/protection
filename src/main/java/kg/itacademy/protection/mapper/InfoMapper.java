package kg.itacademy.protection.mapper;

import kg.itacademy.protection.entity.InfoEntity;
import kg.itacademy.protection.model.InfoModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface InfoMapper {
    InfoMapper INSTANCE = Mappers.getMapper(InfoMapper.class);

    InfoEntity toEntity(InfoModel infoModel);

    InfoModel toModel(InfoEntity infoEntity);

    List<InfoModel> toInfoModels(List<InfoEntity> infoEntityList);
}
