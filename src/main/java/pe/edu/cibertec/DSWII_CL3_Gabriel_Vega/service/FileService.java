package pe.edu.cibertec.DSWII_CL3_Gabriel_Vega.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileService {


    public void guardar(MultipartFile archivo) throws Exception{
        Files.copy(archivo.getInputStream(),
                this.rootFolder.resolve(archivo.getOriginalFilename()));
    }

    public void guardarArchivos(List<MultipartFile> archivos) throws Exception {
        for (MultipartFile archivo : archivos){
            this.guardar(archivo);
        }
    }


    private final Path rootFolder = Paths.get("Images");

    public void guardar(MultipartFile archivo, String subDirectorio) throws IOException {
        String nombreArchivo = StringUtils.cleanPath(archivo.getOriginalFilename());
        Path directorio = this.rootFolder.resolve(subDirectorio);
        Path rutaArchivo = directorio.resolve(nombreArchivo);
        if (!nombreArchivo.toLowerCase().endsWith(".png")) {
            throw new IllegalArgumentException("La extensión del archivo debe ser PNG");
        }
        Files.createDirectories(directorio);
        Files.copy(archivo.getInputStream(), rutaArchivo);
    }

    public void guardarArchivosImages(List<MultipartFile> archivos) throws IOException {
        for (MultipartFile archivo : archivos) {
            this.guardar(archivo, "Images");
        }
    }

    private final Path rootFolder2 = Paths.get("Documentos");
    private static final long MAX_FILE_SIZE = 1_500_000; // 1.5MB

    public void guardar(MultipartFile archivo, String subDirectorio, String extensionPermitida) throws IOException {
        String nombreArchivo = StringUtils.cleanPath(archivo.getOriginalFilename());
        Path directorio = this.rootFolder2.resolve(subDirectorio);
        Path rutaArchivo = directorio.resolve(nombreArchivo);

        if (!nombreArchivo.toLowerCase().endsWith(extensionPermitida)) {
            throw new IllegalArgumentException("La extensión del archivo debe ser " + extensionPermitida);
        }

        if (archivo.getSize() > MAX_FILE_SIZE) {
            throw new IllegalArgumentException("El tamaño del archivo debe ser como máximo " + MAX_FILE_SIZE + " bytes");
        }
        Files.createDirectories(directorio);
        Files.copy(archivo.getInputStream(), rutaArchivo);
    }

    public void guardarArchivosExcel(List<MultipartFile> archivos) throws IOException {
        for (MultipartFile archivo : archivos) {
            this.guardar(archivo, "Documentos", ".xlsx");
        }
    }


}
