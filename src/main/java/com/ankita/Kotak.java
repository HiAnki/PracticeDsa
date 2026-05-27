//package com.ankita;
//
//import java.util.*;
//
//class Person {
//    String name;
//    int salary;
//
//    Person() {
//    }
//
//    Person(String n, int s) {
//        this.name = n;
//        this.salary = s;
//    }
//}
//
//public class Kotak {
//
//    // Group by salary and return map with key = salary and value = list of person names with that salary
//    //
//    //Person1  -> 	name=Alice,      	salary=5000
//    //Person2 -> 	name=Bob,        	salary=6000
//    //Person3 -> 	name=Charlie,  	salary=5000
//    //Person4 -> 	name=David,     	salary=7000
//    //Person5 -> 	name=Eve,         	salary=6000
//    //
//    //		new Person("Alice", 5000),
//    //            new Person("Bob", 6000),
//    //            new Person("Charlie", 5000),
//    //            new Person("David", 7000),
//    //            new Person("Eve", 6000)
//    //
//    //Expected output = {5000=[Alice,Charlie ]}
//    // Person object, List<Person> --> HashMap <salary , List<String> names highest length of the list (all edge cases)
//
//    public static void main(String[] args) {
//        List<Person> input = new ArrayList<>();
//        input.add(new Person("Alice", 5000));
//        input.add(new Person("Bob", 6000));
//        input.add(new Person("Charlie", 5000));
//        input.add(new Person("David", 7000));
//        input.add(new Person("Eve", 6000));
//
//        int salary = 0;
//
//        Map<Integer, List<String>> map1 = getPersonWithSalary(input, 0);
//
//        Map<Integer, List<String>> map = getPersonWithSalary(input, 5000);
//
//        System.out.println(map1);
//        System.out.println(map);
//
////        System.out.println(salary + " " + map.getOrDefault(salary, new ArrayList<>()));
//
//
//    }
//
//    private static Map getPersonWithSalary(List<Person> input, int salary) {
//        Map<Integer, List<String>> result = new TreeMap<>();
//
//        if (input == null || input.isEmpty()) {
//            return new TreeMap();
//        }
//
//        for (Person person : input) {
//            List<String> personList = result.getOrDefault(person.salary, new ArrayList<>());
//            personList.add(person.name);
//            result.put(person.salary, personList);
//        }
//
//        if (result.containsKey(salary)) {
//            HashMap<Integer, List<String>> personWithSalary = new HashMap<>();
//            personWithSalary.put(salary, result.get(salary));
//            return personWithSalary;
//        }
//
//        return result;
//    }
//
////    private static TreeMap getPersonWithSalaryUsingSteam(List<Person> input, int salary) {
////        Map<Integer, List<String>> result = new TreeMap<>();
////
////        input.stream().
////    }
//}
//
////Find free times among users to schedule meeting, where below is the schedule
////	time schedule = [
////		[	[1,3],	[6,7],	[8,9]	],
////		[	[2,3],	[5,7],	[8,9]	],
////		[	[1,3],	[7,8]			],
////	]
////output = [ [3,5], [9,10] ]
//
//// 1 2 3 4 5 6 7 8 9
//// b b     b b b b
//// 3 - 5, 9 - 10
//
//
//private static List<List<Integer>> getFreeSlots(int[][] slots) {
//    List<List<Integer>> ans = new ArrayList<>();
//    if (slots == null || slots.length == 0) {
//        List<Integer> slot = new ArrayList<>();
//        slot.add(1);
//        slot.add(10);
//        ans.add(slot);
//        return ans;
//    }
//
//    boolean[] isSlotBlocked = new boolean[10];
//
//    for (int[] sl: slots) {
//
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
