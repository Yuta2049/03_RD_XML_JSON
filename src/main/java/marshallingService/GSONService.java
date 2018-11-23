package marshallingService;

import com.google.gson.*;
import productService.ProductsData;

import java.io.*;

import static productService.Constants.jsonFileName;

public class GSONService implements IGSONService {

    @Override
    public ProductsData readFromGSON() {

        ProductsData productsData = new ProductsData();

        try (FileInputStream fis = new FileInputStream(new File(jsonFileName));
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            String jsonString = ois.readObject().toString();

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            productsData = gson.fromJson(jsonString, ProductsData.class);

        } catch (Exception e) {
            System.out.println("ЧТО-ТО СЛУЧИЛОСЬ ПРИ ЧТЕНИИ ИЗ JSON");
            e.printStackTrace();
        }

        return productsData;

    }

    @Override
    public void writeToGSON(ProductsData productsData) {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(productsData);

        try (FileOutputStream fos = new FileOutputStream(new File(jsonFileName));
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(json);

        } catch (Exception e) {
            System.out.println("ЧТО-ТО СЛУЧИЛОСЬ ПРИ ЗАПИСИ В JSON");
            e.printStackTrace();
        }

    }
}
