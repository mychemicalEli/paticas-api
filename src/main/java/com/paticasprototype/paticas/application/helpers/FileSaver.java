package com.paticasprototype.paticas.application.helpers;

import com.paticasprototype.paticas.infrastructure.config.ConfigConstants;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Component
public class FileSaver {
    private ConfigConstants config = new ConfigConstants();

    public String saveFile(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            return null;
        }

        File uploadDirFile = new File(config.getUploadDir());
        if (!uploadDirFile.exists()) {
            uploadDirFile.mkdirs();
        }

        String fileName =UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        String filePath = config.getUploadDir() + fileName;
        file.transferTo(new File(filePath));
        return fileName;
    }

    public static String toUrl(String filePath) {
        ConfigConstants config = new ConfigConstants();
        return filePath != null ? config.getBaseUrl()+"uploads/" + filePath : null;
    }
}
