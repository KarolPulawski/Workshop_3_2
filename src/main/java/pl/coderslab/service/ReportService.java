package pl.coderslab.service;

import pl.coderslab.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReportService {

    public static List<Worker> employeeWorkingHours(List<Order> orders){
        List<Worker> summarize;

        summarize = orders.stream().map(s-> {
            Integer id = s.getEmployee().getId();
            String name = s.getEmployee().getName();
            String surname = s.getEmployee().getSurname();
            Integer workingHour = s.getNumberHour(); return new Worker(id, name, surname, workingHour);}).collect(Collectors.toList());

        summarize.forEach(s -> System.out.println(s.getId()));

        List<Worker> finalList = new ArrayList<>();

        for(Worker worker : summarize) {
            if(finalList.stream().filter(s -> s.getId() == worker.getId()).findFirst().isPresent()){
                finalList.stream().filter(s -> s.getId() == worker.getId()).findFirst()
                        .map(v -> { v.setWorkingHour(v.getWorkingHour() + worker.getWorkingHour()); return v;}).get();
            } else {
                finalList.add(worker);
            }
        }
        System.out.println("---");
        finalList.forEach(s -> System.out.println(s.getName()));
        return finalList;
    }
}

