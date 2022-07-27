package kg.itacademy.protection.service;

import kg.itacademy.protection.model.ParentModel;

public interface ParentService {
    ParentModel create(ParentModel parentModel);

    boolean update(ParentModel parentModel);

    boolean delete(ParentModel parentModel);
}
