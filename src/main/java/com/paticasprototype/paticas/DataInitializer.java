package com.paticasprototype.paticas;

import com.paticasprototype.paticas.application.services.shelters.dtos.ShelterDTO;
import com.paticasprototype.paticas.application.services.shelters.services.ShelterService;
import com.paticasprototype.paticas.application.services.volunteers.dtos.CreateVolunteerRequest;
import com.paticasprototype.paticas.application.services.volunteers.services.VolunteerService;
import com.paticasprototype.paticas.application.services.paticas.dtos.CreatePetRequest;
import com.paticasprototype.paticas.application.services.paticas.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private VolunteerService volunteerService;
    @Autowired
    private PetService petService;

    @Autowired
    private ShelterService shelterService;

    @Override
    public void run(String... args) throws Exception {

        insertShelter();
        // Insertar datos de voluntarios
        insertVolunteers();

        // Insertar datos de mascotas
        insertPets();

    }

    private void insertShelter() {
        // Datos del refugio
        Long id = 10L;
        String profileImage = "ruta_de_la_imagen.jpg";
        String name = "Paticas Unidas";
        String location = "Murcia";
        String description = "Nuestro refugio ofrece un hogar seguro y amoroso para animales necesitados. Garantizamos que cada mascota reciba la atención y el cuidado que merece. Ven a visitarnos y encuentra a tu nuevo amigo peludo.";

        // Crear el objeto DTO del refugio
        ShelterDTO shelterDTO = new ShelterDTO();
        shelterDTO.setId(id);
        shelterDTO.setProfileImage(profileImage);
        shelterDTO.setName(name);
        shelterDTO.setLocation(location);
        shelterDTO.setDescription(description);
        // Llamar al servicio para crear el refugio
        shelterService.createShelter(shelterDTO);
    }

    private void insertVolunteers() throws IOException {
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


    private void insertPets() throws IOException {
        String basePath = "/Users/mychemical_eli/Desktop/TFG/Repos/API/paticas-api/external-resources/optimized-images-for-testing/";

        // Datos de las mascotas
        String[] petProfileImages = {"profile_1.jpg", "profile_2.jpg", "profile_3.jpg", "profile_4.jpg", "profile_5.jpg", "profile_6.jpg", "profile_7.jpg", "profile_8.jpg", "profile_9.jpg", "profile_10.jpg", "profile_11.jpg", "profile_12.jpg", "profile_13.jpg", "profile_14.jpg", "profile_15.jpg", "profile_16.jpg", "profile_17.jpg", "profile_18.jpg", "profile_19.jpg", "profile_20.jpg"};
        String[] petCarousel1Images = {"carousel1_1.jpg", "carousel1_2.jpg", "carousel1_3.jpg", "carousel1_4.jpg", "carousel1_5.jpg", "carousel1_6.jpg", "carousel1_7.jpg", "carousel1_8.jpg", "carousel1_9.jpg", "carousel1_10.jpg", "carousel1_11.jpg", "carousel1_12.jpg", "carousel1_13.jpg", "carousel1_14.jpg", "carousel1_15.jpg", "carousel1_16.jpg", "carousel1_17.jpg", "carousel1_18.jpg", "carousel1_19.jpg", "carousel1_20.jpg"};
        String[] petCarousel2Images = {"carousel2_1.jpg", "carousel2_2.jpg", "carousel2_3.jpg", "carousel2_4.jpg", "carousel2_5.jpg", "carousel2_6.jpg", "carousel2_7.jpg", "carousel2_8.jpg", "carousel2_9.jpg", "carousel2_10.jpg", "carousel2_11.jpg", "carousel2_12.jpg", "carousel2_13.jpg", "carousel2_14.jpg", "carousel2_15.jpg", "carousel2_16.jpg", "carousel2_17.jpg", "carousel2_18.jpg", "carousel2_19.jpg", "carousel2_20.jpg"};
        String[] petCarousel3Images = {"carousel3_1.jpg", "carousel3_2.jpg", "carousel3_3.jpg", "carousel3_4.jpg", "carousel3_5.jpg", "carousel3_6.jpg", "carousel3_7.jpg", "carousel3_8.jpg", "carousel3_9.jpg", "carousel3_10.jpg", "carousel3_11.jpg", "carousel3_12.jpg", "carousel3_13.jpg", "carousel3_14.jpg", "carousel3_15.jpg", "carousel3_16.jpg", "carousel3_17.jpg", "carousel3_18.jpg", "carousel3_19.jpg", "carousel3_20.jpg"};
        String[] petNames = {"Max", "Luna", "Charlie", "Bella", "Rocky", "Milo", "Chloe", "Oscar", "Lucy", "Leo", "Coco", "Buddy", "Mia", "Simba", "Daisy", "Oreo", "Paquito", "Star", "Sam", "Dean"};
        String[] petGenders = {"male", "female", "male", "female", "male", "male", "female", "male", "female", "male", "female", "male", "female", "male", "female", "male", "male", "female", "male", "male"};
        int[] petSizes = {2, 3, 1, 2, 3, 1, 2, 3, 2, 1, 2, 3, 1, 2, 3, 1, 3, 2, 1, 3};

        boolean[]petLiked={true, false, false, false, false, true, true, false, false, true, false, false, false, false, false, true, true, false, false, true};
        String[] petBirthDatesStr = {"15-05-2018", "20-07-2019", "10-10-2017", "28-02-2019", "05-08-2016", "12-04-2020", "18-11-2019", "25-09-2018", "30-01-2020", "10-03-2019", "12-12-2018", "20-08-2017", "05-10-2020", "15-04-2019", "28-02-2018", "10-07-2020", "20-08-2017", "10-12-2019", "20-03-2020", "15-08-2018"};

        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        Date[] petBirthDates = new Date[petBirthDatesStr.length];
        for (int i = 0; i < petBirthDatesStr.length; i++) {
            try {
                petBirthDates[i] = dateFormatter.parse(petBirthDatesStr[i]);
            } catch (ParseException e) {
                e.printStackTrace(); // Manejo del error, puedes ajustarlo según tu necesidad
            }
        }

        long shelterId = 10L;
        String[] petSpecies = {"Perro", "Gato", "Perro", "Gato", "Perro", "Perro", "Gato", "Perro", "Gato", "Perro", "Gato", "Perro", "Perro", "Gato", "Perro", "Gato", "Perro", "Perro", "Gato", "Perro"};
        String[] petDescriptions = {"Max es un perro cariñoso y juguetón. Siempre ansioso por paseos y haciendo nuevos amigos", "Luna es una gatita tranquila y afectuosa, exploradora y juguetona. Su curiosidad la lleva a descubrir cada rincón.", "Charlie es un perrito adorable y juguetón, amante del aire libre y las siestas. Su energía es contagiosa y su ternura, irresistible.", "Bella es una gatita elegante y cariñosa, adora mimarse y explorar. Su gracia y curiosidad la hacen única.", "Rocky es un perro valiente y leal, listo para explorar y jugar. Su amor por la vida es inspirador.", "Milo es un cachorro dulce y juguetón, ansioso por explorar y jugar. Siempre lleno de alegría y energía.", "Chloe es una gatita curiosa y cariñosa, feliz explorando y acariciada. Su amor es contagioso y su curiosidad, infinita.", "Oscar es un perro amigable y activo, disfruta caminatas y amigos. Siempre lleno de energía y entusiasmo.", "Lucy es una gata cariñosa y tranquila, disfruta siestas y mimos. Su calma y dulzura son reconfortantes.", "Leo es un cachorro lleno de energía y entusiasmo, siempre curioso. Siempre dispuesto a descubrir algo nuevo.", "Coco es una gatita traviesa y cariñosa, amante de la aventura. Su espíritu juguetón la hace encantadora.", "Buddy es un perro cariñoso y protector, ideal para compañía fiel. Siempre listo para cuidar a su familia.", "Mia es una cachorra dulce y juguetona, llena de alegría. Su vitalidad y cariño son contagiosos.", "Simba es un gato valiente y curioso, disfruta trepando. Siempre explorando su reino con confianza.", "Daisy es una perrita enérgica y juguetona, perfecta para aventuras. Siempre lista para correr y jugar.", "Oreo es un gato cariñoso y juguetón, siempre explorando. Siempre descubriendo nuevos rincones.", "Paquito es un perro cariñoso y protector, leal y activo. Siempre dispuesto a proteger a sus seres queridos.", "Star es una gata elegante y cariñosa, adora mimarse y explorar.Su gracia y curiosidad la hacen única.", "Sam es un perro juguetón y leal, siempre listo para una aventura.Su lealtad y energía lo hacen especial.", "Dean es un gato cariñoso y tranquilo, disfruta de la calma y los mimos.Siempre dispuesto a relajarse y disfrutar de la vida."};

        // Insertar registros de mascotas
        for (int i = 0; i < petNames.length; i++) {
            // Crear la ruta completa de la imagen de perfil
            String profileImagePath = basePath + petProfileImages[i];
            // Cargar la imagen desde una ruta local en tu sistema de archivos
            File profileImageFile = new File(profileImagePath);
            // Convertir el archivo en un objeto MultipartFile
            MultipartFile profileImage = convertToMultipartFile(profileImageFile);

            // Crear la ruta completa de las imágenes del carrusel 1
            String carousel1ImagePath = basePath + petCarousel1Images[i];
            // Cargar la imagen desde una ruta local en tu sistema de archivos
            File carousel1ImageFile = new File(carousel1ImagePath);
            // Convertir el archivo en un objeto MultipartFile
            MultipartFile carousel1Image = convertToMultipartFile(carousel1ImageFile);

            // Crear la ruta completa de las imágenes del carrusel 2
            String carousel2ImagePath = basePath + petCarousel2Images[i];
            // Cargar la imagen desde una ruta local en tu sistema de archivos
            File carousel2ImageFile = new File(carousel2ImagePath);
            // Convertir el archivo en un objeto MultipartFile
            MultipartFile carousel2Image = convertToMultipartFile(carousel2ImageFile);

            // Crear la ruta completa de las imágenes del carrusel 3
            String carousel3ImagePath = basePath + petCarousel3Images[i];
            // Cargar la imagen desde una ruta local en tu sistema de archivos
            File carousel3ImageFile = new File(carousel3ImagePath);
            // Convertir el archivo en un objeto MultipartFile
            MultipartFile carousel3Image = convertToMultipartFile(carousel3ImageFile);

            // Insertar datos de ejemplo al iniciar la aplicación
            CreatePetRequest request = new CreatePetRequest();
            request.setName(petNames[i]);
            request.setGender(petGenders[i]);
            request.setSize(petSizes[i]);
            request.setBirthDate(petBirthDates[i]);
            request.setSpecies(petSpecies[i]);
            request.setDescription(petDescriptions[i]);
            request.setProfileImage(profileImage);
            request.setImageCarousel1(carousel1Image);
            request.setImageCarousel2(carousel2Image);
            request.setImageCarousel3(carousel3Image);
            request.setShelterId(shelterId);
            request.setLiked(petLiked[i]);


            // Crear la mascota
            petService.createPet(request);
        }
    }



        private static MultipartFile convertToMultipartFile (File file) throws IOException {
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
                        try (FileInputStream fis = new FileInputStream(file)) {
                            byte[] bytes = new byte[(int) file.length()];
                            fis.read(bytes);
                            return bytes;
                        }
                    }

                    @Override
                    public InputStream getInputStream() throws IOException {
                        return new FileInputStream(file);
                    }

                    @Override
                    public void transferTo(File dest) throws IOException, IllegalStateException {
                        try (InputStream in = new FileInputStream(file);
                             OutputStream out = new FileOutputStream(dest)) {
                            byte[] buffer = new byte[1024];
                            int length;
                            while ((length = in.read(buffer)) > 0) {
                                out.write(buffer, 0, length);
                            }
                        }
                    }
                };
            }
        }
