package org.example;
public class PasswordVerifier {

    public void verifyPassword(String password) throws Exception {
        if (password.length() < 8){
            throw new Exception("Пароль должен быть не менее 8 символов");
        }

        boolean containsDigit = false;

        for (int i = 0; i < password.length(); i++){
            char ch = password.charAt(i);
            if (Character.isDigit(ch)){
                containsDigit = true;
                break;
            }
        }

        if (!containsDigit){
            throw new Exception("Пароль должен содержать хотя бы одну цифру");
        }

        boolean containsUppercase = false;

        for (int i = 0; i < password.length(); i++){
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)){
                containsUppercase = true;
                break;
            }
        }

        if (!containsUppercase){
            throw new Exception("Пароль должен содержать хотя бы одну заглавную букву");
        }
    }
}