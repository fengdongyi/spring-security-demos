package hello.demos.basic.web;

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
    public List<String> getFood(){
        return foods;
    }

    @PostMapping
    public void addFood(String food){
        foods.add(food);
    }

    @DeleteMapping
    public void deleteFood(String food){
        boolean removed = foods.remove(food);
        if (!removed) {
            throw new IllegalArgumentException("no such food : " + food);
        }
    }

}
