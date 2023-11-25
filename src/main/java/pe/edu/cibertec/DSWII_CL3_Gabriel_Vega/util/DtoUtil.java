package pe.edu.cibertec.DSWII_CL3_Gabriel_Vega.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.DSWII_CL3_Gabriel_Vega.model.dto.ProductDto;
import pe.edu.cibertec.DSWII_CL3_Gabriel_Vega.model.dto.DtoEntity;

@Component
public class DtoUtil {

    public DtoEntity convertirADto(Object obj, ProductDto mapper){
        return new ModelMapper().map(obj, mapper.getClass());
    }

    public Object convertirAEntidad(Object obj, DtoEntity mapper){
        return new ModelMapper().map(mapper, obj.getClass());
    }

}
