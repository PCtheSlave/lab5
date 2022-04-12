package commands;

import collection.DragonFactory;
import collectionworker.CollectionManager;
import interfaces.Command;

public class Add implements Command {

    private CollectionManager collectionManager;
    DragonFactory dragonFactory = new DragonFactory();

    public Add(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        collectionManager.insert(dragonFactory.createDragon());
    }

    @Override
    public String getDescription() {
        return "Добавить новый элемент в коллекцию";
    }
}
