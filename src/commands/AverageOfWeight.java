package commands;

import collection.Dragon;
import collectionworker.CollectionManager;
import interfaces.Command;

public class AverageOfWeight implements Command {
    private CollectionManager collectionManager;

    AverageOfWeight (CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        int i = 0;
        Double srWeight = 0.0;
        for (Dragon val : collectionManager.getDragons()) {
            srWeight += val.getWeight();
            i++;
        }
        System.out.println(srWeight/i);
    }

    @Override
    public String getDescription() {
        return "Средний вес всех драконов в коллекции";
    }
}
