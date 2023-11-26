package pe.edu.cibertec.DSWII_CL3_Gabriel_Vega.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.cibertec.DSWII_CL3_Gabriel_Vega.model.response.ResponseFile;
import pe.edu.cibertec.DSWII_CL3_Gabriel_Vega.service.FileService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/file")
public class FileController {
    private FileService fileService;
//    @PostMapping("/upload")
//    public ResponseEntity<ResponseFile> subirArchivos(
//            @RequestParam("files")List<MultipartFile> files) throws  Exception{
//        fileService.guardarArchivos(files);
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(
//                        ResponseFile.builder().message("Los archivos fueron cargados correctamente")
//                                .build()
//                );
//    }



    @PostMapping("/filesimages")
    public ResponseEntity<ResponseFile> subirArchivos(
            @RequestParam("files") List<MultipartFile> files) {
        try {
            fileService.guardarArchivosImages(files);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(ResponseFile.builder().message("Los archivos fueron cargados correctamente").build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ResponseFile.builder().message("Error al cargar archivos").build());
        }
    }

    @PostMapping("/filesexcel")
    public ResponseEntity<ResponseFile> subirArchivosExcel(
            @RequestParam("files") List<MultipartFile> files) {
        try {
            fileService.guardarArchivosExcel(files);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(ResponseFile.builder().message("Los archivos Excel fueron cargados correctamente").build());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ResponseFile.builder().message(e.getMessage()).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ResponseFile.builder().message("Error al cargar archivos Excel").build());
        }
    }

}
