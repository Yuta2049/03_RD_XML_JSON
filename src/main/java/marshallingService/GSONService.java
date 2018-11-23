package marshallingService;

import com.google.gson.*;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import productService.ProductsData;

import java.io.*;

public class GSONService {

    public ProductsData readFromGSON() {

        ProductsData productsData = new ProductsData();


        try (FileInputStream fis = new FileInputStream(new File("ProductList.json"));
             ObjectInputStream ois = new ObjectInputStream(fis)) {


            String jsonString = ois.readObject().toString();


            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(jsonString);

            JsonObject rootObject = jsonElement.getAsJsonObject(); // чтение главного объекта

            JsonElement categoryList = rootObject.get("categoryList");


            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            productsData = gson.fromJson(jsonString, ProductsData.class);

            System.out.println("==================================");
            System.out.println("ДЕСЕРИАЛИЗАЦИЯ ИЗ JSON ");
            System.out.println(productsData.toString());
            //System.out.println("==================================");


        } catch (Exception e) {
            System.out.println("ЧТО-ТО СЛУЧИЛОСЬ ПРИ ЧТЕНИИ ИЗ JSON");
            e.printStackTrace();
        }

        return productsData;

    }

    public void writeToGSON(ProductsData productsData) {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(productsData);

        try (FileOutputStream fos = new FileOutputStream(new File("ProductList.json"));
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(json);

        } catch (Exception e) {
            System.out.println("ЧТО-ТО СЛУЧИЛОСЬ ПРИ ЗАПИСИ В JSON");
            e.printStackTrace();
        }

    }
}
