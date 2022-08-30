package eeu.test.rdb.repository;

import eeu.test.rdb.model.Ingredient;
import eeu.test.rdb.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    List<Ingredient> findByTitle();
}
