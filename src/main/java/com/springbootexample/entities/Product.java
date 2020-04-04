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
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "identifier", nullable = false)
    private String identifier;

    @Column(name = "category_id", nullable = false)
    private String categoryId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image_path", nullable = false)
    private String imagePath;

    @Column(name = "image_name", nullable = false)
    private String imageName;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "sell_price", nullable = false)
    private Double sellPrice;

    @Column(name = "manufacturer_price", nullable = false)
    private Double manufacturerPrice;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "delete_flg", nullable = false)
    private boolean deleteFlg;

    @Column(name = "expire_date", nullable = false)
    private LocalDateTime expireDate;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Double getManufacturerPrice() {
        return manufacturerPrice;
    }

    public void setManufacturerPrice(Double manufacturerPrice) {
        this.manufacturerPrice = manufacturerPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeleteFlg() {
        return deleteFlg;
    }

    public void setDeleteFlg(boolean deleteFlg) {
        this.deleteFlg = deleteFlg;
    }

    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
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
