package utils;

import collection.Color;
import collection.Country;
import collection.Dragon;
import collection.DragonCharacter;
import collectionworker.CollectionManager;

import java.util.Arrays;

public class CollectionInfo {
    public void getInfoAboutCollection(CollectionManager collectionManager) {
        System.out.println("Дата создания коллекции " + collectionManager.getCreationCollectionDate());
        System.out.println("Количество элементов в коллеции " + collectionManager.getDragons().size());
    }

    public void show(CollectionManager collectionManager){
        if (collectionManager.getDragons().size() == 0) {
            System.out.println("Коллекция пуста!");
        } else {
            for (Dragon vals : collectionManager.getDragons()) {
                System.out.println(vals.toString());
            }
        }
    }

    public String getFieldsName() {
        return "Список всех полей:\nname(String)\ncoordinate_x(Integer)\ncoordinate_y(Double)\nage(Integer)\nweight\nspeaking\ncharacter: " +
                Arrays.toString(DragonCharacter.values()) + "killer\npassport\ncolor_heir: " + Arrays.toString(Color.values()) +
                "nationality: " + Arrays.toString(Country.values()) + "location_X\nlocation_Y\nlocation";
    }
}
