package hello.demos.basic.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Nereus Yi
 */
@RestController
@RequestMapping("foods")
public class FoodController {

    private List<String> foods = List.of("Bread","Sandwich");

    @GetMapping
    @PreAuthorize("hasAuthority('FOODS_VIEW')")
    public List<String> getFood(){
        return foods;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('FOODS_EDIT')")
    public void addFood(String food){
        foods.add(food);
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('FOODS_EDIT')")
    public void deleteFood(String food){
        boolean removed = foods.remove(food);
        if (!removed) {
            throw new IllegalArgumentException("no such food : " + food);
        }
    }

}
