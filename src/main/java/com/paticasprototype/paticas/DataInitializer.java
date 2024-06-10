package com.paticasprototype.paticas;

import com.paticasprototype.paticas.application.services.volunteers.dtos.CreateVolunteerRequest;
import com.paticasprototype.paticas.application.services.volunteers.services.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private VolunteerService volunteerService;

    @Override
    public void run(String... args) throws Exception {
        // Ruta base de las imágenes
        String basePath = "/Users/mychemical_eli/Desktop/TFG/Repos/API/paticas-api/external-resources/optimized-images-for-testing/";

        // Datos de los voluntarios
        String[] fullNames = {"Juan Pérez", "María López", "Pedro García", "Ana Martínez", "David Rodríguez", "Laura Ruiz", "Carlos Sánchez", "Sofía García", "Pablo Díaz"};
        String[] phones = {"623456789", "687654321", "656789123", "654321987", "621654987", "689123456", "634567891", "676543219", "667891234"};
        String[] emails = {"juan@example.com", "maria@example.com", "pedro@example.com", "ana@example.com", "david@example.com", "laura@example.com", "carlos@example.com", "sofia@example.com", "pablo@example.com"};
        int[] availabilities = {1, 2, 3, 1, 2, 3, 1, 2, 3};
        long shelterId = 10L;

        // Insertar 9 registros de voluntarios
        for (int i = 0; i < 9; i++) {
            // Crear la ruta completa de la imagen
            String imagePath = basePath + "profile_image_" + (i + 1) + ".jpg";

            // Cargar la imagen desde una ruta local en tu sistema de archivos
            File imageFile = new File(imagePath);

            // Convertir el archivo en un objeto MultipartFile
            MultipartFile profileImage = convertToMultipartFile(imageFile);

            // Insertar datos de ejemplo al iniciar la aplicación
            CreateVolunteerRequest request = new CreateVolunteerRequest();
            request.setFullName(fullNames[i]);
            request.setEmail(emails[i]);
            request.setPhone(phones[i]);
            request.setAvailability(availabilities[i]);
            request.setShelterId(shelterId); // Establecer el ID del refugio asociado
            request.setProfileImage(profileImage); // Establecer la imagen del perfil

            // Crear el voluntario
            volunteerService.createVolunteer(request);
        }
    }



    private static MultipartFile convertToMultipartFile(File file) throws IOException {
        FileInputStream input = new FileInputStream(file);
        return new MultipartFile() {
            @Override
            public String getName() {
                return file.getName();
            }

            @Override
            public String getOriginalFilename() {
                return file.getName();
            }

            @Override
            public String getContentType() {
                return "image/jpeg"; // Cambia esto según el tipo de archivo
            }

            @Override
            public boolean isEmpty() {
                return file.length() == 0;
            }

            @Override
            public long getSize() {
                return file.length();
            }

            @Override
            public byte[] getBytes() throws IOException {
                byte[] bytes = new byte[(int) file.length()];
                FileInputStream fis = new FileInputStream(file);
                fis.read(bytes);
                fis.close();
                return bytes;
            }

            @Override
            public InputStream getInputStream() throws IOException {
                return new FileInputStream(file);
            }

            @Override
            public void transferTo(File dest) throws IOException, IllegalStateException {
                new FileInputStream(file).transferTo(new FileOutputStream(dest));
            }
        };
    }
}
