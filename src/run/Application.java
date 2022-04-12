package run;

import collectionworker.CollectionManager;
import commands.CommandInvoker;
import file.FileWorker;
import utils.DragonFieldsReader;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Application {
    Scanner in = new Scanner(System.in);
    CollectionManager collectionManager = new CollectionManager();
    FileWorker fileWorker = new FileWorker(collectionManager);
    CommandInvoker commandInvoker;

    public void start(String inputFile) {
        Scanner in = new Scanner(System.in);
        DragonFieldsReader dragonFieldsReader = new DragonFieldsReader();
        this.commandInvoker = new CommandInvoker(collectionManager, in, dragonFieldsReader);
        try {
            File file = new File(inputFile);
            if (!file.canWrite() || !file.isFile() || file.isDirectory()) throw new IOException();
            fileWorker.fromCSVtoObj();
            if (collectionManager.getSize() == 0) {
                System.out.println("Добавьте объекты с помощью команды add, после чего введите команды save для сохранения в csv!");
            } else System.out.println("Объекты из файла загружены!");

        } catch (IOException e) {
            throw new RuntimeException("Такого файла нет");
        }

        try {
            process();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Закрыт поток ввода");
        }

    }

    public void process() {
        System.out.println("Программа запущена");
        while (true) {
            System.out.println("\nВведите название команды");
            String command = in.nextLine();
            commandInvoker.execute(command);
        }
    }
}

