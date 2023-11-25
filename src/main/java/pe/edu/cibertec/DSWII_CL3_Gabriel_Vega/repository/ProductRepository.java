package pe.edu.cibertec.DSWII_CL3_Gabriel_Vega.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DSWII_CL3_Gabriel_Vega.model.bd.Product;

@Repository
public interface ProductRepository
        extends JpaRepository<Product, Integer> {
}
