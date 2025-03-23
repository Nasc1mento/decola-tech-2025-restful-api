package me.dio.decola_tech_2025.domain.model;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseItem extends BaseEntity {

    private String icon;
    private String description;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BaseItem{" +
                super.toString() +
                "icon='" + icon + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
