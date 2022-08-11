package kg.itacademy.protection.service.impl;

import kg.itacademy.protection.entity.ChildEntity;
import kg.itacademy.protection.entity.UserEntity;
import kg.itacademy.protection.exception.user.UserNameNotFoundException;
import kg.itacademy.protection.model.ChildModel;
import kg.itacademy.protection.repository.ChildRepository;
import kg.itacademy.protection.repository.UserRepository;
import kg.itacademy.protection.service.ChildService;
import kg.itacademy.protection.util.MailSenderComponent;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class ChildServiceImpl implements ChildService {


    private final ChildRepository childRepository;
    private final UserRepository userRepository;
    private final MailSenderComponent mailSender;

    @Override
    public ChildModel searchAndSendCodeToChild(String emailChild, Long parentId) {
        UserEntity child = userRepository.getByEmail(emailChild);
        if (child == null)
            throw new UserNameNotFoundException("Child not found");

        UserEntity parent = userRepository.findById(parentId).orElseThrow();

        Random random = new Random();
        int rage = 9999;
        Integer generatedCode = 1000 + random.nextInt(rage - 1000);

        ChildEntity childEntity = new ChildEntity();
        childEntity.setChild(child);
        childEntity.setParent(parent);
        childEntity.setCode(String.valueOf(generatedCode));
        childEntity = childRepository.save(childEntity);

        String bodyMsg = "Код подтверждения " + generatedCode;
        mailSender.sendMail(parent.getEmail(), bodyMsg);
        return ChildModel.builder()
                .code(childEntity.getCode())
                .isConfirmed(childEntity.getIsConfirmed())
                .build();

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


