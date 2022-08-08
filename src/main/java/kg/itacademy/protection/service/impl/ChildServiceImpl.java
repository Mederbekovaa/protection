package kg.itacademy.protection.service.impl;

import kg.itacademy.protection.entity.ChildEntity;
import kg.itacademy.protection.entity.UserEntity;
import kg.itacademy.protection.exception.child.ChildNotFoundException;
import kg.itacademy.protection.exception.user.UserNameNotFoundException;
import kg.itacademy.protection.mapper.ChildMapper;
import kg.itacademy.protection.model.ChildModel;
import kg.itacademy.protection.repository.ChildRepository;
import kg.itacademy.protection.repository.UserRepository;
import kg.itacademy.protection.service.ChildService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChildServiceImpl implements ChildService {


    final ChildRepository childRepository;
    final UserRepository userRepository;

    @Override
    public ChildModel getByEmail(String email) {
        ChildEntity childEntity = childRepository
                .getByEmail(String.valueOf(childRepository.getByEmail(email)));
        if (childEntity == null) {
            throw new ChildNotFoundException("Child not found");
        } else {
            return ChildMapper.INSTANCE.toModel(childRepository.getByEmail(email));
//            Random
        }

    }


//    public boolean searchAndSendCodeToChild(String emailChild, Long parentId) {
//
//    }
}

        //найти пользователя по емайл
        //если его нет, то выбросить ошибку не найден
        //если есть, то
        //ищещь парента, если его нет то кидаешь ошибку
        //генерируешь 4 значный код с помощью Random
        //создаешь ChildEntity
        //сеттишь все что можно в поля, включая generatedCode
        //сохрянешь
        // отправляешь generatedCode и емайл парента в класс MailSender


