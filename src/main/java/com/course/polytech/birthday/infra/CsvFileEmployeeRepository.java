package com.course.polytech.birthday.infra;

import com.course.polytech.birthday.domain.Employee;
import com.course.polytech.birthday.domain.EmployeeRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileEmployeeRepository implements EmployeeRepository {

    private final Path filePath;
    private static final String SEPARATOR = ",";

    public CsvFileEmployeeRepository(Path filePath) {
        this.filePath = filePath;
    }


    @Override
    public List<Employee> allEmployees() {
        try {
            return Files.readAllLines(filePath).stream().skip(1).map(line -> {
                String[] arrays = line.split(SEPARATOR);
                return new Employee(arrays[0], arrays[1], LocalDate.parse(arrays[2], DateTimeFormatter.ofPattern("yyyy/MM/dd")),arrays[3]);
            }).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Impossible to read file at " + filePath, e);
        }
    }
}
