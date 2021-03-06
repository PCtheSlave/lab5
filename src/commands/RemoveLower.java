package commands;

import collection.Dragon;
import collection.DragonFactory;
import collectionworker.CollectionManager;
import interfaces.Command;

import java.util.Stack;

public class RemoveLower implements Command {

    private CollectionManager collectionManager;

    RemoveLower(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        DragonFactory dragonFactory = new DragonFactory();
        Dragon currentDragon = collectionManager.insert(dragonFactory.createDragon());
        Stack<Dragon> needToRemoveDragons = new Stack<>();
        for (Dragon dragon : collectionManager.getDragons()) {
            if (dragon.compareTo(currentDragon) < 0) {
                needToRemoveDragons.push(dragon);
            }
        }
        collectionManager.getDragons().removeAll(needToRemoveDragons);
    }

    @Override
    public String getDescription() {
        return "Удалить из коллекции все элементы, меньшие, чем заданный";
    }
}
