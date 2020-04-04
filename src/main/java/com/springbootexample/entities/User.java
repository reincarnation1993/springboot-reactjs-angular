package com.springbootexample.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user", uniqueConstraints = @UniqueConstraint(name = "user_unique", columnNames = {"user_name"}))
public class User {

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
    private LocalDateTime dateOfBirth;

    @Column(name = "address_id")
    private String addressId;

    @Column(name = "delete_flg", nullable = false)
    private boolean deleteFlg;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

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

    public Optional<LocalDateTime> getDateOfBirth() {
        return Optional.ofNullable(dateOfBirth);
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Optional<LocalDateTime> getUpdatedAt() {
        return Optional.ofNullable(updatedAt);
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

