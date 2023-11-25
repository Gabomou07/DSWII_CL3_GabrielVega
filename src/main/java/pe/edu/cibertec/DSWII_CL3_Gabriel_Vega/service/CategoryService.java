package pe.edu.cibertec.DSWII_CL3_Gabriel_Vega.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_CL3_Gabriel_Vega.model.bd.Category;
import pe.edu.cibertec.DSWII_CL3_Gabriel_Vega.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    public List<Category> listarCategorias(){
        return categoryRepository.findAll();
    }
    public Category guardar(Category category){
        return categoryRepository.save(category);
    }
    public Optional<Category> obtenerCategoriaPorId(Integer id){
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isEmpty()){
            return Optional.empty();
        }else
            return category;
    }

    public Optional<Category> obtenerCatogoriaPorNombre(String categoryName){
        Optional<Category> category = categoryRepository.findByCategoryname(categoryName);
        if(category.isEmpty())
            return  Optional.empty();
        else
            return category;
    }

    public List<Category> obtenerCategoriasPorFiltro(String filtro){
        return categoryRepository.filtrarCategoriasPorNombreSQL(filtro);
    }


}
