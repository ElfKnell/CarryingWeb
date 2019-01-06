package ua.carrying.formsvalidator;

public class RegisterFormValidator {

    private String userName;
    private String email;
    private String password;
    private String phone;
    private String messageError;

    private interface CheckField {
        boolean isCorrect(String field);
    }

    public RegisterFormValidator() {
    }

    public RegisterFormValidator(String userName, String email, String password, String phone) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessageError() {
        return messageError;
    }

    public boolean isFormValid() {

        // check userName min 4 letters
        CheckField checkFieldMin4 = field -> {
            if ( field.length() < 4 ) {
                messageError = "Min. 4 letters in userName!";
                return false;
            }
            return true;
        };
        if ( ! checkFieldMin4.isCorrect(userName)) {
            return false;
        }

        //check email if correct
        CheckField checkFieldEmail = field -> {
            boolean res =  field.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            if (! res) {
                messageError = "Invalid Email!";
            }
            return res;
        };

        if ( ! checkFieldEmail.isCorrect(email)) {
            return false;
        }

        // check password secure
        //(?=.*[@#$%^&+=,.])
        CheckField checkFieldPassword = field -> {
            boolean res = field.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}$");
            if (! res) {
                messageError = "Your password has low safety. It will has must: a min. 6 symbols, at least once a digit," +
                        "a lower case letter, an upper case letter, no whitespace allowed in the entire string, only latin letters!";
            }
            return res;
        };
        if ( ! checkFieldPassword.isCorrect(password)) {
            return false;
        }

        // check phone must to be
        CheckField checkFieldPhone = field -> {
            if ( field.isEmpty ()) {
                messageError = "Phone number can not be empty";
                return false;
            }
            return true;
        };
        if ( ! checkFieldPhone.isCorrect(phone)) {
            return false;
        }

        return true;
    }
}
