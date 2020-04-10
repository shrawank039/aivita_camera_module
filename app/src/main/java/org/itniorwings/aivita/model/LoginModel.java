package org.itniorwings.aivita.model;

public class LoginModel {


    private String username;
    private String firstName;
    private String lastName;
    private String gender;
    private Object bio;
    private String profilePic;
    private String block;
    private String version;
    private String device;
    private String signupType;
    private Object tokon;
    private String created;
    private String email;
    private String phone;
    private String password;

    public LoginModel(String id, Object fbId, String username, String firstName, String lastName, String gender, Object bio, String profilePic, String block, String version, String device, String signupType, Object tokon, String created, String email, String phone, String password) {

        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.bio = bio;
        this.profilePic = profilePic;
        this.block = block;
        this.version = version;
        this.device = device;
        this.signupType = signupType;
        this.tokon = tokon;
        this.created = created;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Object getBio() {
        return bio;
    }

    public void setBio(Object bio) {
        this.bio = bio;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getSignupType() {
        return signupType;
    }

    public void setSignupType(String signupType) {
        this.signupType = signupType;
    }

    public Object getTokon() {
        return tokon;
    }

    public void setTokon(Object tokon) {
        this.tokon = tokon;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
