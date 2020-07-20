package com.system.springboot.backend.service;

import com.system.springboot.backend.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ServerErrorException;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;


@Service
public class UploadsService {

    private final static String DIRECTORY_UPLOAD = "uploads";

    private final Logger log = LoggerFactory.getLogger(UploadsService.class);


    public Resource load(String namePhoto, String nameRoute) throws MalformedURLException {
        Path routeFile = getPath(namePhoto,nameRoute);

        log.info(routeFile.toString());

        Resource resourse = new UrlResource(routeFile.toUri());

        if(!resourse.exists() && !resourse.isReadable()) {
            routeFile = Paths.get("uploads").resolve("no-imagen.jpg").toAbsolutePath();

            resourse = new UrlResource(routeFile.toUri());

            log.error("Error not load the image: " + namePhoto);

        }
        return resourse;
    }


    public String copy(MultipartFile file,String nameRoute) throws IOException {

        String nameFile = UUID.randomUUID().toString() + "_" +  file.getOriginalFilename().replace(" ", "");

        Path routeFile = getPath(nameFile,nameRoute);
        log.info(routeFile.toString());

        Files.copy(file.getInputStream(), routeFile);

        return  Optional.ofNullable(nameFile)
                .orElseThrow(()-> new ServerErrorException("error the load image", new Exception("")));
    }

    public boolean delete(String namePhoto, String nameRoute) {
        if(namePhoto !=null && namePhoto.length() >0) {
            Path routePreviousPhoto = Paths.get(this.getPath(namePhoto,nameRoute).toString()).resolve(namePhoto).toAbsolutePath();
            File filePreviousPhoto = routePreviousPhoto.toFile();
            if(filePreviousPhoto.exists() && filePreviousPhoto.canRead()) {
                filePreviousPhoto.delete();
                return true;
            }
        }

        return false;
    }

    public Path getPath(String namePhoto, String nameRoute) {
       return Optional.ofNullable(Paths.get(DIRECTORY_UPLOAD+'/'+nameRoute).resolve(namePhoto).toAbsolutePath())
                .orElseThrow(()-> new ServerErrorException("error get path", new Exception("")));
    }
}
