package dev.prmts.image.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageService {
    @Value("${app.locations.images}")
    private String imageDirectory;

    public Resource load(String fileName) throws FileNotFoundException {
        if (Objects.equals(fileName, "undefined")) {
            return null;
        }
        String path = imageDirectory + fileName;
        Resource resource = new FileSystemResource(path);
        if (resource.exists() && resource.isFile()) {
            return resource;
        } else {
            throw new FileNotFoundException("Image " + fileName + " does not exist!");
        }
    }

    public String saveImage(MultipartFile imageFile) throws IOException {
        String originalFilename = imageFile.getOriginalFilename();
        UUID uuid = UUID.randomUUID();
        String fileName = String.format("%s-%s", uuid, originalFilename);
        Path saveDir = Paths.get(imageDirectory + fileName);
        Files.copy(imageFile.getInputStream(), saveDir, StandardCopyOption.REPLACE_EXISTING);
        return fileName;
    }
}
