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
@Table(name = "ingredients")
public class Ingredient {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ingredient_id;

    @Column(name = "title")
    private String title;

    @ManyToMany(mappedBy = "ingredients")
    Set<Recipe> recipes;

    public Ingredient() {
    }

    public Ingredient(String title) {
        this.title = title;
        this.recipes = new HashSet<>();
    }

}
