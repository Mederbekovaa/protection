package kg.itacademy.protection.service.impl;

import kg.itacademy.protection.entity.ChildEntity;
import kg.itacademy.protection.entity.UserEntity;
import kg.itacademy.protection.exception.child.ChildNotFoundException;
import kg.itacademy.protection.exception.user.UserNameNotFoundException;
import kg.itacademy.protection.mapper.ChildMapper;
import kg.itacademy.protection.model.ChildModel;
import kg.itacademy.protection.model.UserModel;
import kg.itacademy.protection.repository.ChildRepository;
import kg.itacademy.protection.repository.UserRepository;
import kg.itacademy.protection.service.ChildService;
import kg.itacademy.protection.util.MailSender;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ChildServiceImpl implements ChildService {


    final ChildRepository childRepository;
    final UserRepository userRepository;

    final MailSender mailSender;

    @Override
    public boolean searchAndSendCodeToChild(String emailChild, Long parentId) {
        UserModel child = userRepository.getByLogin(emailChild)
                .orElseThrow(() -> new UserNameNotFoundException("Child not found"));
        UserModel parent = userRepository.getById(parentId)
                .orElseThrow(() -> new UserNameNotFoundException("Not found"));

        Random random = new Random();
        int rage = 9999;
        Integer generatedCode = 1000 + random.nextInt(rage - 1000);

        ChildEntity childEntity = new ChildEntity();
        ChildModel childModel = new ChildModel();
        childEntity.setChild(childModel.getChild());
        childEntity.setParent(childModel.getParent());
        childEntity.setCode(String.valueOf(generatedCode));
        childEntity.setIsConfirmed(true);
        childEntity = childRepository.save(childEntity);

        String bodyMsg = "Код подтверждения " + generatedCode;
        mailSender.sendMail(parent.getEmail(), bodyMsg);
        return true;

    }
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


