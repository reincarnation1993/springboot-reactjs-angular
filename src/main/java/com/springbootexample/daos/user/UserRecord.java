package com.springbootexample.daos.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Optional;

@Getter
@Setter
@Entity
@ToString
@Table(name = "user", uniqueConstraints = @UniqueConstraint(name = "user_unique", columnNames = {"user_name"}))
public class UserRecord {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "identifier", nullable = false)
    private String identifier;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "avatar_path")
    private String avatarPath;

    @Column(name = "avatar_name")
    private String avatarName;

    @Column(name = "date_of_birth")
    private Timestamp dateOfBirth;

    @Column(name = "address_id")
    private String addressId;

    @Column(name = "delete_flg", nullable = false)
    private boolean deleteFlg;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Optional<String> getAvatarPath() {
        return Optional.ofNullable(avatarPath);
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public Optional<String> getAvatarName() {
        return Optional.ofNullable(avatarName);
    }

    public void setAvatarName(String avatarName) {
        this.avatarName = avatarName;
    }

    public Optional<Timestamp> getDateOfBirth() {
        return Optional.ofNullable(dateOfBirth);
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Optional<String> getAddressId() {
        return Optional.ofNullable(addressId);
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public boolean isDeleteFlg() {
        return deleteFlg;
    }

    public void setDeleteFlg(boolean deleteFlg) {
        this.deleteFlg = deleteFlg;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Optional<Timestamp> getUpdatedAt() {
        return Optional.ofNullable(updatedAt);
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}