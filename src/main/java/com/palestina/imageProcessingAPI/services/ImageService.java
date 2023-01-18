package com.palestina.imageProcessingAPI.services;

import com.palestina.imageProcessingAPI.models.entities.Image;
import com.palestina.imageProcessingAPI.repositories.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    private final ImageRepository imageRepository;

    public ImageService(final ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Iterable<Image> findAll() {
        return imageRepository.findAll();
    }

    public <S extends Image> S save(S entity) {
        return this.imageRepository.save(entity);
    }


}
