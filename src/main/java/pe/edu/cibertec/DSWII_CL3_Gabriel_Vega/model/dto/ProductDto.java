package pe.edu.cibertec.DSWII_CL3_Gabriel_Vega.model.dto;

import lombok.Data;

@Data
public class ProductDto implements DtoEntity {
    private Integer productid;
    private String productname;
    private String quantityperunit;
    private Double unitprice;
    private CategoryDto category;
    private SupplierDto supplier;
}
