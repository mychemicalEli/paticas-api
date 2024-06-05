package com.paticasprototype.paticas.application.helpers;

import com.paticasprototype.paticas.infrastructure.config.ConfigConstants;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Component // Marca esta clase como un componente de Spring
public class FileSaver {
    // Instancia de ConfigConstants para acceder a configuraciones
    private ConfigConstants config = new ConfigConstants();

    /**
     * Guarda un archivo en el sistema de archivos.
     *
     * @param file El archivo a guardar.
     * @return El nombre único del archivo guardado, o null si el archivo es nulo o vacío.
     * @throws IOException Si ocurre un error durante la operación de guardado.
     */
    public String saveFile(MultipartFile file) throws IOException {
        // Verifica si el archivo es nulo o está vacío
        if (file == null || file.isEmpty()) {
            return null; // Retorna null si no hay archivo que guardar
        }

        // Obtiene el directorio de subida desde la configuración
        File uploadDirFile = new File(config.getUploadDir());
        // Crea el directorio si no existe
        if (!uploadDirFile.exists()) {
            uploadDirFile.mkdirs();
        }

        // Genera un nombre único para el archivo usando UUID y el nombre original del archivo
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        // Construye la ruta completa del archivo a guardar
        String filePath = config.getUploadDir() + fileName;
        // Transfiere el contenido del archivo subido a la ubicación especificada
        file.transferTo(new File(filePath));
        return fileName; // Retorna el nombre único del archivo guardado
    }

    /**
     * Convierte una ruta de archivo relativa en una URL completa.
     *
     * @param filePath La ruta relativa del archivo.
     * @return La URL completa del archivo, o null si filePath es null.
     */
    public static String toUrl(String filePath) {
        // Instancia de ConfigConstants para acceder a configuraciones
        ConfigConstants config = new ConfigConstants();
        // Retorna la URL completa del archivo o null si filePath es null
        return filePath != null ? config.getBaseUrl() + "uploads/" + filePath : null;
    }
}
