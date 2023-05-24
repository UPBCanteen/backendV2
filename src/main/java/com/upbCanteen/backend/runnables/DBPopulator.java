package com.upbCanteen.backend.runnables;


import com.upbCanteen.backend.model.Canteen;
import com.upbCanteen.backend.model.*;
import com.upbCanteen.backend.repository.RoleRepository;
import com.upbCanteen.backend.service.CanteenService;
import com.upbCanteen.backend.service.MealService;
import com.upbCanteen.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DBPopulator implements CommandLineRunner {
    @Autowired
    CanteenService cafeteriaService;
    @Autowired
    MealService menuElementService;

    @Autowired
    UserService userService;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) {
        Role userRole, adminRole, cafeteriaRole;
        if (roleRepository.findAll().size() != 3) {
            roleRepository.deleteAll(roleRepository.findAll());

            userRole = new Role();
            userRole.setName(ERole.ROLE_USER);
            adminRole = new Role();
            adminRole.setName(ERole.ROLE_ADMIN);
            cafeteriaRole = new Role();
            cafeteriaRole.setName(ERole.ROLE_MODERATOR);

            roleRepository.save(userRole);
            roleRepository.save(adminRole);
            roleRepository.save(cafeteriaRole);
        } else {
            userRole = roleRepository.findByName(ERole.ROLE_USER);
            adminRole = roleRepository.findByName(ERole.ROLE_ADMIN);
            cafeteriaRole = roleRepository.findByName(ERole.ROLE_MODERATOR);
        }


        ArrayList<User> users = new ArrayList<>();
        List<String> emails = Arrays.asList("emailtest@polifood.com", "emailtest2@polifood.com");
        List<String> firstNames = Arrays.asList("Andrei", "Bogdan");
        List<String> lastNames = Arrays.asList("Ion", "Buliga");
        List<String> passwords = Arrays.asList("12345678", "password");
        User admin;

        for (int i = 0; i < emails.size(); i++) {
            if (userService.getUserByEmail(emails.get(i)) == null) {
                User user = new User();
                user.setEmail(emails.get(i));
                user.setPassword(passwordEncoder.encode(passwords.get(i)));
                user.setRoles(userRole);
                userService.save(user);
                users.add(user);
            }
        }

        if (userService.getUserByEmail("admin@polifood.com") == null) {
            admin = new User();
            admin.setEmail("admin@polifood.com");
            admin.setRoles(adminRole);
            admin.setPassword(passwordEncoder.encode("admin"));
            userService.save(admin);
        }


//        MenuElementType felul1, felul2, desert, bautura;
//        if (menuElementTypeRepository.findAll().size() != 4) {
//            for (MenuElementType met : menuElementTypeRepository.findAll()) {
//                menuElementTypeRepository.delete(met);
//            }
//
//            felul1 = new MenuElementType();
//            felul2 = new MenuElementType();
//            desert = new MenuElementType();
//            bautura = new MenuElementType();
//
//            felul1.setName("felul1");
//            felul2.setName("felul2");
//            desert.setName("desert");
//            bautura.setName("bautura");
//
//            menuElementTypeRepository.save(felul1);
//            menuElementTypeRepository.save(felul2);
//            menuElementTypeRepository.save(desert);
//            menuElementTypeRepository.save(bautura);
//        } else {
//            felul1 = menuElementTypeRepository.findByName("felul1");
//            felul2 = menuElementTypeRepository.findByName("felul2");
//            desert = menuElementTypeRepository.findByName("desert");
//            bautura = menuElementTypeRepository.findByName("bautura");
//        }

        List<String> names = Arrays.asList("Cantina ACS", "Cantina ETTI", "Cantina Rectorat", "Cantina Leu");
        List<String> locations = Arrays.asList("ACS", "ETTI", "Rectorat", "Leu cladirea A");
        List<String> schedules = Arrays.asList("09:00-17:00", "09:00-18:00", "10:00-17:00", "10:00-19:00");
        List<String> workers = Arrays.asList("acs", "etti", "rectorat", "leu");

        List<String> MEnamesFelul1 = Arrays.asList("Ciorba de Vaca", "Ciorba de Legume", "Ciorba de pasare", "Supa cu galuste");
        List<Float> MEpricesFelul1 = Arrays.asList(2.5F, 1.5F, 2F, 1.5F);
        List<Float> MEunitvalueFelul1 = Arrays.asList(500F, 500F, 400F, 400F);
        List<String> MEunittypeFelul1 = Arrays.asList("g", "g", "g", "g");
        List<String> MEimageFelul1 = Arrays.asList("https://savoriurbane.com/wp-content/uploads/2015/10/cea-mai-buna-ciorba-de-vacuta-reteta-pas-cu-pas.jpg"
                , "https://www.lauralaurentiu.ro/wp-content/uploads/2017/11/reteta-pas-cu-pas-de-ciorba-de-legume-de-post-fotografii-si-text@lauralaurentiu.jpg"
                , "https://jamilacuisine.ro/wp-content/uploads/2019/07/Ciorba-de-pui-olteneasca.jpg"
                , "https://thumbor.unica.ro/unsafe/715x566/smart/filters:format(webp):contrast(8):quality(80)/https://retete.unica.ro/wp-content/uploads/2017/03/GALUSTE-POST-e1489417056825.jpg");

        List<String> MEnamesFelul2 = Arrays.asList("Piept de Pui", "Orez cu legume", "Piure de cartofi", "Cartofi la cuptor", "Snitel de pui", "Ceafa de porc", "Parjoale", "Salata de varza", "Gogosari", "Mamaliga");
        List<Float> MEpricesFelul2 = Arrays.asList(5.5F, 1.5F, 1F, 1F, 3F, 6F, 3F, 1F, 1.5F, 1F);
        List<Float> MEunitvalueFelul2 = Arrays.asList(200F, 300F, 200F, 200F, 300F, 200F, 150F, 200F, 100F, 200F);
        List<String> MEunittypeFelul2 = Arrays.asList("g", "g", "g", "g", "g", "g", "g", "g", "g", "g");
        List<String> MEimageFelul2 = Arrays.asList("https://www.retetedecasa.com/wp-content/uploads/2020/11/grilled-chicken-breast-official.png",
                "https://media.kaufland.com/images/PPIM/AP_Content_1010/std.lang.all/01/99/Asset_1020199.jpg"
                , "https://www.retetepractice.ro/wp-content/uploads/2019/01/Cum-pregatesti-cel-mai-cremos-piure-de-cartofi.jpg"
                , "https://www.e-retete.ro/files/recipes/cartofi-crocanti-la-cuptor.jpg"
                , "https://www.lauralaurentiu.ro/wp-content/uploads/2017/11/snitel-din-piept-de-pui-reteta-pas-cu-pas-cum-se-face-snitel-de-pui-snitel-de-pui-in-pesmet-reteta-cu-poze.jpg"
                , "https://pizzacolosseum.ro/wp-content/uploads/2019/01/ceafa-de-porc-la-gratar-180-gr..jpg"
                , "https://i.ytimg.com/vi/NQvgOFc2rw0/maxresdefault.jpg"
                , "https://www.chicmeniu.ro/wp-content/uploads/2012/10/salata-de-varza.jpg"
                , "https://lh3.googleusercontent.com/proxy/GuWITncvxHgjoYoG9tJlazn-2DGZ9ocMqoNPQ0rGqt9l76PIVmTs9_04OF3j20911rJkNFaLNk0ASdnB0VLsX1y-S9kAVkkH1WUXczdp4cw"
                , "https://ciprianmuntele.ro/wordpress/wp-content/uploads/IMG_0986.jpg");

        List<String> MEnamesDesert = Arrays.asList("Tiramisu", "Savarina", "Amandina", "Ecler");
        List<Float> MEpricesDesert = Arrays.asList(4F, 3F, 3F, 2F);
        List<Float> MEunitvalueDesert = Arrays.asList(200F, 200F, 150F, 100F);
        List<String> MEunittypeDesert = Arrays.asList("g", "g", "g", "g");
        List<String> MEimageDesert = Arrays.asList("https://www.askchefdennis.com/wp-content/uploads/2011/04/Tiramisu10b.jpg",
                "https://www.cofetariaarmand.ro/foto_big/534_1.jpg"
                , "https://jamilacuisine.ro/wp-content/uploads/2013/10/Amandine-pas-cu-pas-500x375.jpg"
                , "http://s.cdnmpro.com/954786671/p/l/0/bunexim-prajitura-ecler-caramel~2100.jpg");

        List<String> MEnamesBautura = Arrays.asList("Apa plata", "Fanta", "Coca Cola", "Sprite");
        List<Float> MEpricesBautura = Arrays.asList(2F, 3F, 3F, 3F);
        List<Float> MEunitvalueBautura = Arrays.asList(500F, 500F, 500F, 500F);
        List<String> MEunittypeBautura = Arrays.asList("ml", "ml", "ml", "ml");
        List<String> MEimageBautura = Arrays.asList("https://www.fiorino.ro/image/cache/catalog/MTR/ALIMENTE/Apa/apa-plata-dorna-izvorul-alb-0-5-l-450x450.jpg",
                "https://assets.sainsburys-groceries.co.uk/gol/3300510/1/640x640.jpg", "https://www.fishbox.ro/wp-content/uploads/2015/12/coca-cola.jpg"
                , "https://coralia-online.ro/wp-content/uploads/sprite-6216.jpg");

        for (int i = 0; i < names.size(); i++) {
            if (cafeteriaService.findByName(names.get(i)).isEmpty()) {
                Canteen cafeteria = new Canteen();
                cafeteria.setName(names.get(i));
                cafeteria.setLocation(locations.get(i));
                cafeteria.setSchedule(schedules.get(i));
                cafeteriaService.save(cafeteria);

//                Menu menu1 = new Menu();
//                menu1.setCafeteria(cafeteria);
//                menu1.setDay(DayOfWeek.MONDAY);
//                Menu menu2 = new Menu();
//                menu2.setCafeteria(cafeteria);
//                menu2.setDay(DayOfWeek.TUESDAY);
//                Menu menu3 = new Menu();
//                menu3.setCafeteria(cafeteria);
//                menu3.setDay(DayOfWeek.WEDNESDAY);
//                Menu menu4 = new Menu();
//                menu4.setCafeteria(cafeteria);
//                menu4.setDay(DayOfWeek.THURSDAY);
//                Menu menu5 = new Menu();
//                menu5.setCafeteria(cafeteria);
//                menu5.setDay(DayOfWeek.FRIDAY);

//                for (int j = 0; j < MEnamesFelul1.size(); j++) {
//                    MenuElement menuElement = new MenuElement();
//                    menuElement.setType(felul1);
//                    menuElement.setName(MEnamesFelul1.get(j));
//                    menuElement.setUnitPrice(MEpricesFelul1.get(j));
//                    menuElement.setUnitValue(MEunitvalueFelul1.get(j));
//                    menuElement.setUnitType(MEunittypeFelul1.get(j));
//                    menuElement.setImageURL(MEimageFelul1.get(j));
//                    menuElementService.save(menuElement);
//                    menu1.getMenuElements().add(menuElement);
//                    menu2.getMenuElements().add(menuElement);
//                    menu3.getMenuElements().add(menuElement);
//                    menu4.getMenuElements().add(menuElement);
//                    menu5.getMenuElements().add(menuElement);
//                }
//
//                for (int j = 0; j < MEnamesFelul2.size(); j++) {
//                    MenuElement menuElement = new MenuElement();
//                    menuElement.setType(felul2);
//                    menuElement.setName(MEnamesFelul2.get(j));
//                    menuElement.setUnitPrice(MEpricesFelul2.get(j));
//                    menuElement.setUnitValue(MEunitvalueFelul2.get(j));
//                    menuElement.setUnitType(MEunittypeFelul2.get(j));
//                    menuElement.setImageURL(MEimageFelul2.get(j));
//                    menuElementService.save(menuElement);
//                    menu1.getMenuElements().add(menuElement);
//                    menu2.getMenuElements().add(menuElement);
//                    menu3.getMenuElements().add(menuElement);
//                    menu4.getMenuElements().add(menuElement);
//                    menu5.getMenuElements().add(menuElement);
//                }
//
//                for (int j = 0; j < MEnamesDesert.size(); j++) {
//                    MenuElement menuElement = new MenuElement();
//                    menuElement.setType(desert);
//                    menuElement.setName(MEnamesDesert.get(j));
//                    menuElement.setUnitPrice(MEpricesDesert.get(j));
//                    menuElement.setUnitValue(MEunitvalueDesert.get(j));
//                    menuElement.setUnitType(MEunittypeDesert.get(j));
//                    menuElement.setImageURL(MEimageDesert.get(j));
//                    menuElementService.save(menuElement);
//                    menu1.getMenuElements().add(menuElement);
//                    menu2.getMenuElements().add(menuElement);
//                    menu3.getMenuElements().add(menuElement);
//                    menu4.getMenuElements().add(menuElement);
//                    menu5.getMenuElements().add(menuElement);
//                }
//
//                for (int j = 0; j < MEnamesBautura.size(); j++) {
//                    MenuElement menuElement = new MenuElement();
//                    menuElement.setType(bautura);
//                    menuElement.setName(MEnamesBautura.get(j));
//                    menuElement.setUnitPrice(MEpricesBautura.get(j));
//                    menuElement.setUnitValue(MEunitvalueBautura.get(j));
//                    menuElement.setUnitType(MEunittypeBautura.get(j));
//                    menuElement.setImageURL(MEimageBautura.get(j));
//                    menuElementService.save(menuElement);
//                    menu1.getMenuElements().add(menuElement);
//                    menu2.getMenuElements().add(menuElement);
//                    menu3.getMenuElements().add(menuElement);
//                    menu4.getMenuElements().add(menuElement);
//                    menu5.getMenuElements().add(menuElement);
//                }
//
//
//                menuService.save(menu1);
//                menuService.save(menu2);
//                menuService.save(menu3);
//                menuService.save(menu4);
//                menuService.save(menu5);

                User cafeteriaWorker = new User();
                cafeteriaWorker.setEmail(workers.get(i) + "@polifood.com");
                cafeteriaWorker.setPassword(passwordEncoder.encode(workers.get(i)));
                cafeteriaWorker.setRoles(cafeteriaRole);
//                cafeteriaWorker.setCafeteria(cafeteria);
                userService.save(cafeteriaWorker);
            }

        }

    }
}
