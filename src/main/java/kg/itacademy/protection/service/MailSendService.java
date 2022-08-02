package kg.itacademy.protection.service;

import kg.itacademy.protection.model.MailSendModel;

public interface MailSendService {
    boolean mailSend(MailSendModel mailSendModel);
}
