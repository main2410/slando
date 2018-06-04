package service;

import java.util.regex.Pattern;
import org.springframework.stereotype.Service;

@Service
public class VerificationService {

    private static final String LOGIN_REGEX = "^\\w{3,}";
    private static final String PHONE_REGEX = "^\\+380\\d{9}";
    private static final String PHONE_REGEX2 = "^0\\d{9}";
    private static final String EMAIL_REGEX = "^\\w+([.\\w]+)*\\w@\\w((.\\w)*\\w+)*\\.\\w{2,3}$";

    public boolean notLessThan(int length, String text) {
        return text.length() >= length;
    }

    public boolean isCorrectEmail(String email) {
        return isCorrect(EMAIL_REGEX, email);
    }

    public boolean isCorrectPhone(String phone) {
        return isCorrect(PHONE_REGEX, phone) || isCorrect(PHONE_REGEX2, phone);
    }

    public boolean isCorrectLogin(String login) {
        return isCorrect(LOGIN_REGEX, login);
    }

    private boolean isCorrect(String regex, String text) {
        return Pattern.compile(regex).matcher(text).matches();
    }

    public boolean isCorrectUserData(String login, String phone, String email) {
        return isCorrectLogin(login)
                && isCorrectPhone(phone)
                && (email.equals("") 
                || isCorrectEmail(email));
    }

}
