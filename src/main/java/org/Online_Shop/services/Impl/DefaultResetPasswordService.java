package org.Online_Shop.services.Impl;

import org.Online_Shop.enteties.User;
import org.Online_Shop.services.ResetPasswordService;
import org.Online_Shop.utils.mail.MailSender;

public class DefaultResetPasswordService implements ResetPasswordService {
    private MailSender mailSender;

    {
        mailSender = DefaultMailSender.getInstance();
    }

    @Override
    public void resetPasswordForUser(User user) {
        mailSender.sendEmail(user.getEmail(), "Please, use this password to login: " + user.getPassword());
    }
}
