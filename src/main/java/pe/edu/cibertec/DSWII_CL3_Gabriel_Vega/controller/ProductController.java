package pe.edu.cibertec.DSWII_CL3_Gabriel_Vega.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.DSWII_CL3_Gabriel_Vega.model.bd.Product;
import pe.edu.cibertec.DSWII_CL3_Gabriel_Vega.model.dto.DtoEntity;
import pe.edu.cibertec.DSWII_CL3_Gabriel_Vega.model.dto.ProductDto;
import pe.edu.cibertec.DSWII_CL3_Gabriel_Vega.service.ProductService;
import pe.edu.cibertec.DSWII_CL3_Gabriel_Vega.util.DtoUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@AllArgsConstructor
@RequestMapping("api/v1/product")
public class ProductController {
    private ProductService productService;
    @GetMapping("")
    public ResponseEntity<List<Product>> listarProductos(){
        List<Product> productList = new ArrayList<>();
        productService.listarProductos().forEach(productList::add);
        if(productList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/dto")
    public ResponseEntity<List<DtoEntity>> listarProductosDto(){
        List<DtoEntity> productList = new ArrayList<>();
        productList = productService.listarProductos()
                .stream()
                .map(prod -> new DtoUtil().convertirADto(prod, new ProductDto()))
                .collect(Collectors.toList());
        if(productList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(productList, HttpStatus.OK);
    }

}
