package demoService;

import marshallingService.GSONService;
import marshallingService.IGSONService;
import marshallingService.IXMLService;
import marshallingService.XMLService;
import productService.ProductService;
import productService.ProductsData;

import java.io.File;

import static productService.Constants.*;

public class DemoService implements IDemoService {

    @Override
    public void showDemo() {

        /*
        Если в папке нет ни xml, ни json, то генерируем xml (заполняем предопределенными данными)
        Если в папке есть файл xml и нет json, то формируем json из xml
        Если в папке есть файл json и нет xml, то формируем xml из json
        Если в папке оба файла, то ругаемся
        */

        // Проверяем, есть ли файл с сохраненными тестовыми данными
        File xmlFile = new File(xmlFileName);
        File jsonFile = new File(jsonFileName);

        boolean xmlFileIsPresent = xmlFile.isFile();
        boolean jsonFileIsPresent = jsonFile.isFile();

        if (xmlFileIsPresent && jsonFileIsPresent) { // есть xml, есть json

            // ругаемся и ничего не делаем
            System.out.println("В рабочем каталоге присутствует и файл *.xml и *.json. Удалите один или оба");

        } else if (xmlFileIsPresent) {      // есть xml, нет json

            // Читаем xml
            IXMLService xmlService = new XMLService();
            ProductsData productsData = xmlService.readFromXML();
            System.out.println("ДЕСЕРИАЛИЗАЦИЯ ИЗ XML: ");
            System.out.println(productsData);

            // Формируем json
            IGSONService gsonService = new GSONService();
            gsonService.writeToGSON(productsData);

        } else if (jsonFileIsPresent) {     // нет xml, есть json

            // Читаем json
            IGSONService gsonService = new GSONService();
            ProductsData productsData = gsonService.readFromGSON();
            System.out.println("ДЕСЕРИАЛИЗАЦИЯ ИЗ JSON: ");
            System.out.println(productsData);

            // Формируем xml
            IXMLService xmlService = new XMLService();
            xmlService.writeToXML(productsData);

        } else {                            // нет ни xml, ни json

            // Генерируем тестовые данные для xml-файла
            ProductService productService = new ProductService();
            ProductsData productsData = productService.generateData();
            System.out.println("СГЕНЕРИРОВАЛИ ТЕСТОВЫЕ ДАННЫЕ (ФАЙЛ " + xmlFileName);
            System.out.println(productsData);

            // Формируем xml
            IXMLService xmlService = new XMLService();
            xmlService.writeToXML(productsData);
        }

    }

}
