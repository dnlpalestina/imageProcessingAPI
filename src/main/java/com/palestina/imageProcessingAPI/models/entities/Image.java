package com.palestina.imageProcessingAPI.models.entities;

import com.palestina.imageProcessingAPI.models.converters.EmailConverter;
import com.palestina.imageProcessingAPI.models.enums.StatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Builder
@Data
@Entity
@Table(name = "IMAGE")
public class Image {

    @Id
    @GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "title")
    @NotBlank(message = "The title is required.")
    private String title;

    @Column(name = "description")
    @NotBlank(message = "The description is required.")
    private String description;

    @Convert(converter = EmailConverter.class)
    @NotBlank(message = "The emails is required.")
    private List<String> emails;

    @Column(name = "target_folder_name")
    @NotBlank(message = "The folder is required.")
    private String folder;

    @Temporal(TemporalType.TIMESTAMP)
    @Builder.Default
    @Column(name = "created_at")
    private Date createdAt = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Builder.Default
    @Column(name = "updated_at")
    private Date updatedAt = new Date();

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private StatusEnum status;

}