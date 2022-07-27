package kg.itacademy.protection.service;

import kg.itacademy.protection.model.InfoModel;

public interface InfoService {
    InfoModel create(InfoModel infoModel);

    boolean update(InfoModel infoModel);

    boolean delete(InfoModel infoModel);

}
