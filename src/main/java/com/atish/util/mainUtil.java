package com.atish.util;

import java.util.*;
import java.util.stream.Collectors;

public class mainUtil {
    public static void main(String[] args) {

//        List<String>data= Arrays.asList("atish","adarsh","sumati","gols","abhi");
//        List<String> newdata = data.stream().sorted().filter(x -> x.startsWith("a")).collect(Collectors.toList());
//System.out.print(newdata);


//        Post post2 = new Post();
//        post2.setId(5);
//        post2.setTitle("what the fuck");
//        post2.setContent("kya bat kar raha he yar");
//
//
//        Post post1 = new Post();
//        post1.setId(6);
//        post1.setTitle("what the dick");
//        post1.setContent("kya bat kar raha he dick");
//
//        List<Post> posts = Arrays.asList(post1, post2);
//        posts.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
//
//        for ( Post post:posts) {
//            System.out.println(post.getId());
//            System.out.println(post.getTitle());
//            System.out.println(post.getContent());
//
//        }
//    }
//        static PostDto mapToDto(Post post){
//            PostDto dto =new PostDto();
//            dto.setId(post.getId());
//            dto.setTitle(post.getTitle());
//            dto.setContent(post.getContent());
//
//            return dto;


//        Movie m = new Movie("salaga","5","1992");
//        Movie m1 = new Movie("gggg","8","1900");
//        Movie m2 = new Movie("llll","9","2002");
//        ArrayList<Movie>list= new ArrayList<Movie>();
//        list.add(m1);
//        list.add(m2);
//        list.add(m);
//
//        MovieYear year=new MovieYear();
//        Collections.sort(list,year);
//
//
//        for (Movie m3:list) {
//            System.out.println(m3.getName());
//            System.out.println(m3.getRating());
//            System.out.println(m3.getYear());
//        }

//        List<Integer>c=Arrays.asList(10,50,45,7,8,9,44,88,66,91,57,8,26,35,44,7,85,95,4,5);
//        Integer max = c.stream().max(Integer::compareTo).get();
//        Integer min = c.stream().min(Integer::compareTo).get();
//        System.out.println(min);
//        System.out.println(max);

        //HASH MAP example

        List<Employee> name=Arrays.asList(new Employee("atish",5000),//30-09-2023
                new Employee("chiru",6000),
                new Employee("konda",5000),
                new Employee("gangya",6000),
                new Employee("huccha",6000));
        Map<Integer, List<Employee>> collect = name.stream().collect(Collectors.groupingBy(Employee::getSalary));

        for (Map.Entry<Integer, List<Employee>> coll:collect.entrySet()) {

            Integer key = coll.getKey();
            System.out.println(key);

            List<Employee> value = coll.getValue();
            for (Employee employee:value) {
                System.out.println(employee.getName());

            }
        }

    }
 }
