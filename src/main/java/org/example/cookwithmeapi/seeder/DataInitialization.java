package org.example.cookwithmeapi.seeder;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.cookwithmeapi.model.Category;
import org.example.cookwithmeapi.model.Recipe;
import org.example.cookwithmeapi.model.account.Administrator;
import org.example.cookwithmeapi.model.account.Client;
import org.example.cookwithmeapi.service.AdministratorService;
import org.example.cookwithmeapi.service.CategoryService;
import org.example.cookwithmeapi.service.ClientService;
import org.example.cookwithmeapi.service.RecipeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class DataInitialization implements CommandLineRunner {
    private final ClientService clientService;
    private final AdministratorService administratorService;
    private final CategoryService categoryService;
    private final RecipeService recipeService;

    @Override
    public void run(String... args) throws Exception {
        List<Client> clients = new ArrayList<>();

        Client client1 = clientService.create(Client
                .builder()
                .username("tBrick")
                .email("client1@mail.com")
                .firstName("Tom")
                .lastName("Brick")
                .password("password")
                .build());

        Client client2 = clientService.create(Client
                .builder()
                .username("jRow")
                .email("client2@mail.com")
                .firstName("Jack")
                .lastName("Row")
                .password("password")
                .build());

        Client client3 = clientService.create(Client
                .builder()
                .username("rWall")
                .email("client3@mail.com")
                .firstName("Rick")
                .lastName("Wall")
                .password("password")
                .build());

        clients.add(client1);
        clients.add(client2);
        clients.add(client3);

        Administrator admin1 = administratorService.create(Administrator
                .builder()
                .username("admin")
                .email("admin@mail.com")
                .firstName("Paul")
                .lastName("Finger")
                .password("password")
                .build());

        Category cat1 = categoryService.create(Category
                .builder()
                .name("breakfast")
                .build());

        Category cat2 = categoryService.create(Category
                .builder()
                .name("lunch")
                .build());

        Category cat3 = categoryService.create(Category
                .builder()
                .name("dinner")
                .build());

        List<Category> categories = new ArrayList<>();
        categories.add(cat1);
        categories.add(cat2);
        categories.add(cat3);

        for(int i = 0; i < 100; i++) {
            String name = RandomStringUtils.randomAlphabetic((int)(Math.random() * 20 + 5)).toLowerCase();
            StringBuilder ingredients = new StringBuilder();
            for (int j = 0; j < ((int)(Math.random() * 4) + 1); j++) {
                ingredients.append(RandomStringUtils.randomAlphabetic((int) (Math.random() * 10 + 5)).toLowerCase());
                ingredients.append(", ");
            }
            String description = RandomStringUtils.randomAlphabetic((int)(Math.random() * 500 + 300)).toLowerCase();

            Recipe recipe = recipeService.create(Recipe
                    .builder()
                    .name(name)
                    .preparationTime((int)(Math.random() * 120 + 1))
                    .ingredients(ingredients.toString())
                    .description(description)
                    .categories(List.of(categories.get((int)(Math.random() * (categories.size() - 1)))))
                    .build(), clients.get((int)(Math.random() * (clients.size() - 1))));
        }

//        StringBuilder builder1 = new StringBuilder();
//        builder1.append("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas blandit nisl eu pellentesque fringilla. Morbi condimentum erat et dolor maximus bibendum. Mauris pellentesque pharetra posuere. Mauris eu lorem ac nulla facilisis mattis a id arcu. Nulla facilisi. Quisque a justo a ante pharetra tempor. Aliquam gravida semper urna, id sollicitudin purus finibus et. Morbi vitae convallis neque.\n");
//        builder1.append("\n");
//        builder1.append("\"Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Suspendisse sit amet tellus lacus. Donec ultrices tempor suscipit. Aliquam erat volutpat. Maecenas ultricies ultrices odio in ullamcorper. Donec feugiat ac sapien facilisis venenatis. Cras viverra interdum elit in consectetur. Curabitur non vestibulum turpis, non malesuada lectus. Duis faucibus sem ut nisl efficitur facilisis. Maecenas et placerat libero. Cras eu massa sit amet est iaculis congue. Nam ligula eros, vulputate semper facilisis a, congue tristique lacus. Vivamus semper rutrum ex, ac gravida metus tempor non. Interdum et malesuada fames ac ante ipsum primis in faucibus.\"");
//
//        Recipe recipe1 = recipeService.create(Recipe
//                .builder()
//                .name("scrambled eggs")
//                .preparationTime(15)
//                .ingredients("eggs, pepper, salt")
//                .description(builder1.toString())
//                .categories(categories)
//                .build(), client1);
//
//        StringBuilder builder2 = new StringBuilder();
//        builder2.append("Pellentesque aliquam fermentum laoreet. Morbi aliquam lacinia orci non rhoncus. Duis sodales gravida ex ac faucibus. Integer eu dictum tortor. Maecenas justo purus, lobortis non rhoncus ac, lobortis ut nibh. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vivamus id quam quis sem facilisis pellentesque pellentesque eget turpis. Morbi sed velit euismod, ultrices nisl a, sodales metus. Sed varius eget arcu non egestas. Donec ornare cursus leo, sit amet molestie leo elementum lacinia. Praesent eget lacus blandit, mattis ante ac, convallis risus.");
//
//        Recipe recipe2 = recipeService.create(Recipe
//                .builder()
//                .name("sandwiches")
//                .preparationTime(15)
//                .ingredients("bread, butter, ham, cheese")
//                .description(builder2.toString())
//                .categories(categories)
//                .build(), client1);
    }
}
