package ohremchuk.hometask.task10.validation;


public class ServletValidator {

    public static Boolean validateAllConditions(String name, String email, String phone) {
        return name.isBlank() | ((email.isBlank() && phone.isBlank()));
    }


    private static final String NAME_REGEX = "^[a-zA-Z][ ]*$";
    private static final String NUMBER_REGEX = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    public static final boolean regexName(String name){
        return name.matches(NAME_REGEX);
    }
    public static final boolean regexNumber(String phone){
        return phone.matches(NUMBER_REGEX);
    }
    public static final boolean regexEmail(String email){
        return email.matches(EMAIL_REGEX);
    }

}
