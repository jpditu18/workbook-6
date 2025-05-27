package com.pluralsight.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        String[][] people = {
                {"Emma", "Johnson", "28"},
                {"Liam", "Smith", "34"},
                {"Olivia", "Brown", "22"},
                {"Noah", "Davis", "41"},
                {"Ava", "Miller", "19"},
                {"Elijah", "Wilson", "30"},
                {"Sophia", "Moore", "26"},
                {"James", "Taylor", "38"},
                {"Isabella", "Anderson", "25"},
                {"Benjamin", "Thomas", "33"}
        };
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a first or last name to search: ");
        String nameSearch = scanner.nextLine().trim();

        List<String> matches = Arrays.stream(people)
                .filter(person -> person[0].equalsIgnoreCase(nameSearch) || person[1].equalsIgnoreCase(nameSearch))
                .map(person -> person[0] + " " + person[1])
                .collect(Collectors.toList());

        if (matches.isEmpty()){
            System.out.println("There were no matches found.");
        }else {
            System.out.println("Matching people:");
            matches.forEach(System.out::println);
        }
        double averageAge = Arrays.stream(people)
                .mapToInt(person -> Integer.parseInt(person[2]))
                .average()
                .orElse(0);

        int oldest = Arrays.stream(people)
                .mapToInt(person -> Integer.parseInt(person[2]))
                .max()
                .orElse(-1);

        int youngest = Arrays.stream(people)
                .mapToInt(person -> Integer.parseInt(person[2]))
                .min()
                .orElse(-1);


        System.out.println("Average age: " + averageAge);
        System.out.println("Oldest age: " + oldest);
        System.out.println("Youngest age: " + youngest);
    }
}
