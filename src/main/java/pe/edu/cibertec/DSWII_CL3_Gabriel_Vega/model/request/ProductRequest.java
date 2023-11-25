package pe.edu.cibertec.DSWII_CL3_Gabriel_Vega.model.request;

import lombok.Data;

@Data
public class ProductRequest {
    private Integer productid;
    private String productname;
    private Double unitprice;
    private Boolean discontinued;
    private Integer supplierid;
    private Integer categoryid;
}
