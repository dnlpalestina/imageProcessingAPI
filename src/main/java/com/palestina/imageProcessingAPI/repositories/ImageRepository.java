package com.palestina.imageProcessingAPI.repositories;

import com.palestina.imageProcessingAPI.models.entities.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Integer> {
}
