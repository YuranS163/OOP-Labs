package com.ssau;

import com.ssau.exceptions.DuplicateModelNameException;
import com.ssau.exceptions.NoSuchModelNameException;

import java.io.*;

public class Main {

    public static void main(String[] args) throws DuplicateModelNameException,
            NoSuchModelNameException, IOException, ClassNotFoundException {


        Motorcycle yamaha = new Motorcycle("Yamaha"); // создаем Мотоцикл
        // добавляем в него несколько моделей
        yamaha.addModel("YZF-R1", 1705000);
        yamaha.addModel("YZF-R6", 1153000);
        yamaha.addModel("YZF-R3", 499000);
        yamaha.addModel("MT-10 SP", 1523000);
        yamaha.addModel("MT-10", 1338000);
        yamaha.addModel("MT-09 SP", 989000);
        yamaha.addModel("MT-09", 891000);
        yamaha.addModel("MT-07", 757000);
        yamaha.addModel("MT-03", 473000);
        yamaha.addModel("XSR900", 888000);
        yamaha.addModel("WR450F", 818000);


        IOStaticMethods.writeVehicle(yamaha, new FileWriter("inputMotorcycle.txt")); // записываем в файл
        Vehicle vehicle1 = IOStaticMethods.readMotorcycle
                        (new FileReader("inputMotorcycle.txt"));
        IOStaticMethods.printVehicle(vehicle1);


        //сериализация
        FileOutputStream fileOutMotorcycle = new FileOutputStream("outputMotorcycle");
        ObjectOutputStream outMotorcycle = new ObjectOutputStream(fileOutMotorcycle);
        outMotorcycle.writeObject(yamaha);
        //десериализация
        FileInputStream fileInMotorcycle = new FileInputStream("outputMotorcycle");
        ObjectInputStream inMotorcycle = new ObjectInputStream(fileInMotorcycle);
        Motorcycle yamaha_2 = (Motorcycle) inMotorcycle.readObject();
        IOStaticMethods.printVehicle(yamaha_2);

        Car lada = new Car("Lada", 7); // создаем Машину
        // добавляем в нее несколько моделей
        lada.addModel("Granta седан", 504900);
        lada.addModel("Granta лифтбек", 526900);
        lada.addModel("Granta хэтчбек", 550500);
        lada.addModel("Granta универсал", 533900);
        lada.addModel("Granta Cross", 625900);
        lada.addModel("Granta учебная", 547900);
        lada.addModel("Granta Drive Active", 694900);

        IOStaticMethods.writeVehicle(lada, new FileWriter("inputCar.txt")); // записываем в файл
        Vehicle vehicle = IOStaticMethods.readCar // записываем в другой файл ту Машину, что считаем в первом
                (new FileReader("inputCar.txt"));
        IOStaticMethods.printVehicle(vehicle);

        //сериализация
        FileOutputStream fileOutCar = new FileOutputStream("outputCar");
        ObjectOutputStream outCar = new ObjectOutputStream(fileOutCar);
        outCar.writeObject(lada);
        //десериализация
        FileInputStream fileInCar = new FileInputStream("outputCar");
        ObjectInputStream inCar = new ObjectInputStream(fileInCar);
        Car lada_2 = (Car) inCar.readObject();
        IOStaticMethods.printVehicle(lada_2);
        // ввод и вывод в байтовые потоки

        Vehicle res = IOStaticMethods.readCar(new InputStreamReader(System.in));
        IOStaticMethods.writeVehicle(res, new OutputStreamWriter(System.out));


        IOStaticMethods.outputVehicle(lada, new FileOutputStream("inputCar.byte")); // записываем в файл
        Vehicle res1 = IOStaticMethods.inputCar( // записываем в другой файл ту Машину, что считаем в первом
                (new FileInputStream("inputCar.byte")));
        IOStaticMethods.printVehicle(res1);

        //IOStaticMethods.outputVehicle(lada, System.out);
        //IOStaticMethods.inputCar(System.in);
    }
}
