package com.proyecto.evento.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class CargaService {

    // Directorio donde se carga las imagenes
    private static final String UPLOAD_DIR = "src/main/resources/static/carga/";

    // carga de imagen
    public void cargarImagen(MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            String pathImg= UPLOAD_DIR+file.getOriginalFilename();
            Path pathFile = Paths.get(pathImg);
            Files.copy(file.getInputStream(), pathFile,
                    StandardCopyOption.REPLACE_EXISTING);
        }
    }

}
