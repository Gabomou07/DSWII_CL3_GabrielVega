package pe.edu.cibertec.DSWII_CL3_Gabriel_Vega.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DSWII_CL3_Gabriel_Vega.model.bd.Supplier;

@Repository
public interface SupplierRepository
        extends JpaRepository<Supplier, Integer>
{
}
