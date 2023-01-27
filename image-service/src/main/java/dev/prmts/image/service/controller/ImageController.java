package dev.prmts.image.service.controller;

import dev.prmts.image.service.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.apache.tika.Tika;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(path = "/images")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;
    private final Tika tika;

    @GetMapping(path = "/{fileName}")
    public ResponseEntity<Resource> findImageByFileName(@PathVariable String fileName) throws IOException {
        Resource image = imageService.load(fileName);
        String detectedMediaType = tika.detect(image.getInputStream());
        MediaType mediaType = MediaType.parseMediaType(detectedMediaType);
        return ResponseEntity.ok()
                .contentType(mediaType)
                .body(image);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadImage(@RequestPart("image") MultipartFile multipartFile) throws IOException {
        return imageService.saveImage(multipartFile);
    }
}
