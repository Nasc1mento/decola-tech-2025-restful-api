package me.dio.decola_tech_2025.service;

import me.dio.decola_tech_2025.domain.model.BaseEntity;

public interface BaseService <T extends BaseEntity> {

    T findById(Long id);

    T create(T t);

}
