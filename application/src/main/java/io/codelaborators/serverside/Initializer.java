package io.codelaborators.serverside;

import io.codelaborators.serverside.models.*;
import io.codelaborators.serverside.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Initializer implements CommandLineRunner {

    @Resource
    private AppleRepository appleRepo;
    @Resource
    private BananaRepository bananaRepo;
    @Resource
    private PepperRepository pepperRepo;
    @Resource
    private BeanRepository beanRepo;
    @Resource
    private ListItemRepository listItemRepo;

    @Override
    public void run(String... args) throws Exception {

        Apple goldenDelicious = new Apple("Golden Delicious", .50, 4, 7, "/images/golden-delicious.png");
        appleRepo.save(goldenDelicious);
        Apple redApple = new Apple("Red Apples", .35, 4, 8, "/images/red-apple.png");
        appleRepo.save(redApple);
        Banana miniBanana = new Banana("Mini Bananas", .75, 6, 5,"/images/mini-bananas.png");
        bananaRepo.save(miniBanana);
        Pepper greenPepper = new Pepper("Green Peppers", 1, 4, 10, "/images/green-peppers.png");
        pepperRepo.save(greenPepper);
        Beans bakedBeans = new Beans("Baked Beans", 1, 10, false, "/images/baked-beans.png");
        beanRepo.save(bakedBeans);
        ListItem addedGoldenDelicious = new ListItem("Golden Delicious", 2, false);
        listItemRepo.save(addedGoldenDelicious);
        ListItem addedRedApple = new ListItem("Red Apples", 1.40, false);
        listItemRepo.save(addedRedApple);
    }
}
