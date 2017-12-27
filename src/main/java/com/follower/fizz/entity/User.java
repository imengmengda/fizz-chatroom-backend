package com.follower.fizz.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Arrays;

/**
 * Created by lin on 17-12-23.
 */
@Entity
@Table(name = "user")
public class User {
    private String nickname;
    private String password;
    private Date registerDate;
    private String email;
    private String region;
    private Integer sex;
    private Timestamp lastLoginTime;
    private byte[] profilePicture;
    private Integer onlineStatus;
    private String signingMessage;
    private int userId;

    public User() {}

    public User(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
        this.registerDate = Date.valueOf(LocalDate.now());
    }

    @Basic
    @Column(name = "nickname", nullable = false, length = 50)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "register_date", nullable = false)
    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "region", nullable = true, length = 50)
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name = "sex", nullable = true)
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "last_login_time", nullable = true)
    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Basic
    @Column(name = "profile_picture", nullable = true)
    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    @Basic
    @Column(name = "online_status", nullable = true)
    public Integer getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(Integer onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    @Basic
    @Column(name = "signing_message", nullable = true, length = 200)
    public String getSigningMessage() {
        return signingMessage;
    }

    public void setSigningMessage(String signingMessage) {
        this.signingMessage = signingMessage;
    }

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (nickname != null ? !nickname.equals(user.nickname) : user.nickname != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (registerDate != null ? !registerDate.equals(user.registerDate) : user.registerDate != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (region != null ? !region.equals(user.region) : user.region != null) return false;
        if (sex != null ? !sex.equals(user.sex) : user.sex != null) return false;
        if (lastLoginTime != null ? !lastLoginTime.equals(user.lastLoginTime) : user.lastLoginTime != null)
            return false;
        if (!Arrays.equals(profilePicture, user.profilePicture)) return false;
        if (onlineStatus != null ? !onlineStatus.equals(user.onlineStatus) : user.onlineStatus != null) return false;
        if (signingMessage != null ? !signingMessage.equals(user.signingMessage) : user.signingMessage != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nickname != null ? nickname.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (registerDate != null ? registerDate.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (lastLoginTime != null ? lastLoginTime.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(profilePicture);
        result = 31 * result + (onlineStatus != null ? onlineStatus.hashCode() : 0);
        result = 31 * result + (signingMessage != null ? signingMessage.hashCode() : 0);
        result = 31 * result + userId;
        return result;
    }
}
