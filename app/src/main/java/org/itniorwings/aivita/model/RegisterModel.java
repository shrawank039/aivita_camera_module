package org.itniorwings.aivita.model;

public class RegisterModel {
    String email;
    String password;
    String username;
    String phone;
    String fileToUpload;

    public RegisterModel(String email, String password, String username, String phone, String fileToUpload) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.phone = phone;
        this.fileToUpload = fileToUpload;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFileToUpload() {
        return fileToUpload;
    }

    public void setFileToUpload(String fileToUpload) {
        this.fileToUpload = fileToUpload;
    }

    @Override
    public String toString() {
        return "RegisterModel{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", fileToUpload='" + fileToUpload + '\'' +
                '}';
    }
}
