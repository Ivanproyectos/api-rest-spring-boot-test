package com.testapi.testapi.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
@Service
public class FileStorageService {
    private final Path rootLocation = Paths.get("archivos");

    public void store(MultipartFile file) throws IOException {
        // Asegurarse de que la carpeta exista
        Files.createDirectories(rootLocation);

        // Nombre del archivo
        String filename = file.getOriginalFilename();

        // Ruta completa donde se guardará el archivo
        Path destinationFile = rootLocation.resolve(Paths.get(filename)).normalize().toAbsolutePath();

        // Guardar el archivo en el destino
        file.transferTo(destinationFile);
    }
}
