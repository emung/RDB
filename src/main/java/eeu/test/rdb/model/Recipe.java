package eeu.test.rdb.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@ToString
@Data
@Entity
@Table(name = "recipes")
public class Recipe {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer recipe_id;

    @Column(name = "title")
    private String title;

    @Column(name = "category")
    private String category;

    @Column(name = "typeOfCooking")
    private String typeOfCooking;

    @ManyToMany
    @JoinTable(
            name = "ingredients_list",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    Set<Ingredient> ingredients;

    public Recipe() {
    }

    public Recipe(String title, String category, String typeOfCooking) {
        this.title = title;
        this.category = category;
        this.typeOfCooking = typeOfCooking;
        this.ingredients = new HashSet<>();
    }


}
