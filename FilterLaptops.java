package hw_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class FilterLaptops {
    private Set<Laptop> laptops = new HashSet<>();
    private List<Criterion> criterionList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void printList(){
        for (Laptop laptop : laptops){
            if (laptopIsCorrect(laptop)){
                System.out.println(laptop);
            }
        }
    }

    public boolean laptopIsCorrect(Laptop laptop){

        for (Criterion criterion : criterionList){
            Object valueLaptop = null;

            if (criterion.property.equals("name")){
                valueLaptop = laptop.getName();
            }else if (criterion.property.equals("model")){
                valueLaptop = laptop.getModel();
            }else if (criterion.property.equals("operatingSystem")){
                valueLaptop = laptop.getOperatingSystem();
            }else if (criterion.property.equals("storageSize")){
                valueLaptop = laptop.getStorageSize();
            }else if (criterion.property.equals("RAMSize")){
                valueLaptop = laptop.getRAMSize();
            }else if (criterion.property.equals("CPUModel")){
                valueLaptop = laptop.getCPUModel();
            }else if (criterion.property.equals("price")){
                valueLaptop = laptop.getPrice();
            }else {
                continue;
            }

            if (criterion.value != null && !criterion.value.equals(valueLaptop)){
                return false;
            }

            if (criterion.maxValue != null && criterion.maxValue < Double.parseDouble(Objects.toString(valueLaptop))){
                return false;
            }

            if (criterion.minValue != null && criterion.minValue > Double.parseDouble(Objects.toString(valueLaptop))){
                return false;
            }
        }

        return true;
    }
    public FilterLaptops(Set<Laptop> laptops) {
        this.scanner = new Scanner(System.in);
        this.laptops = laptops;
    }

    public FilterLaptops(Set<Laptop> laptops, List<Criterion> criterionList) {
        this.scanner = new Scanner(System.in);
        this.laptops = laptops;
        this.criterionList = criterionList;
    }

    public int getCriteria(){
        String text = "Введите цифру, соответствующую необходимому критерию: ";

        List<String> properties = propertiesForFilter();

        for (int i = 0; i < properties.size(); i++)
        {
            text += "\n" + (i + 1) + ". " + getPropertyDescription(properties.get(i));
        }

        System.out.println(text);

        int value = scanner.nextInt();

        return value;
    }

    public String getPropertyDescription(String property){

        Map<String, String> descriptionsProperties = descriptionsProperties();

        return descriptionsProperties.get(property);

    }

    public Map<String, String> descriptionsProperties(){
        Map<String, String> map = new HashMap<>();
        map.put("name", "Наименование");
        map.put("model", "Модель");
        map.put("operatingSystem", "Операционная система");
        map.put("storageSize", "Объем встроенной паряти");
        map.put("RAMSize", "Объем оперативной памяти");
        map.put("CPUModel", "Модель процессора");
        map.put("price", "Цена");
        return map;
    }

    public List<String> propertiesForFilter(){
        List<String> list = new ArrayList<>();
        list.add("name");
        list.add("operatingSystem");
        list.add("storageSize");
        list.add("RAMSize");
        list.add("CPUModel");
        list.add("price");
        return list;
    }

    public String getOperations(){

        String text = "Выберите операцию: \n " +
                "1. Добавить критерий \n " +
                "2. Вывести список \n " +
                "3. Завершить";

        System.out.println(text);
        String answer = scanner.next();
        return answer;
    }

    public Set<String> quantitativeSelection(){
        Set<String> set = new HashSet<>();
        set.add("storageSize");
        set.add("RAMSize");
        set.add("price");

        return set;
    }

    public Set<String> stringSelection(){
        Set<String> set = new HashSet<>();

        set.add("name");
        set.add("operatingSystem");
        set.add("CPUModel");
        set.add("model");

        return set;
    }

    public void start(){

        boolean flag = true;
        while (flag){

            String operation = getOperations();
            if (operation.equals("3")){
                flag = false;
                scanner.close();
                continue;
            }else if(operation.equals("1")){

                int criterion = getCriteria();
                List<String> properties = propertiesForFilter();
                if (criterion - 1 < 0 || criterion - 1 > properties.size() - 1){
                    System.out.println("Введено некорректное значение");
                    continue;
                }
                String property = properties.get(criterion - 1);
                Criterion criterionObject = null;
                try {
                    if (quantitativeSelection().contains(property)){
                        criterionObject = Criterion.startGetting(scanner, property, true);
                    }else {
                        criterionObject = Criterion.startGetting(scanner, property, false);
                    }
                }catch (Exception e){
                    System.out.println("Ошибка при выборе критерия");
                    continue;
                }
                if (criterionObject != null){
                    System.out.println("Критерий добавлен");
                    criterionList.add(criterionObject);
                }
            }
            else if (operation.equals("2")){
                printList();
            }
        }
    }
}
