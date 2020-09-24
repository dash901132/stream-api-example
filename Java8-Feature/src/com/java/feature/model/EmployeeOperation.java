package com.java.feature.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeOperation {
    public static void main(String[]args){
        List<Employee> employeeList= Stream.of(new Employee(111,"dashrath",23232,"softwarae"),
                new Employee(112,"pankaj",2312,"testing"),
                new Employee(113,"rakesh",23232,"aws")).collect(Collectors.toList());

        System.out.println("Employeee list is");
        getAvgSalary(employeeList);
    filerData(employeeList);
    List<Employee> add=addOneListDataIntoOther(employeeList);
        System.out.println(add+"one list data into other");
      List<Employee>quinqueData = findQuniqeData(employeeList);
        System.out.println("quinique data is:"+quinqueData);

        //sorting
       sortUsingJava8(employeeList);
       //grouping by
        Map<String,List<Employee>>groupDept=getEmplaoyeeBasedOnDept(employeeList);
        System.out.println("Department grouping"+groupDept);;
        Map<String,Double> sakarygrouping=getEmpsalaryGrouping(employeeList);
        System.out.println("salary grouping "+sakarygrouping);

        findEmp(employeeList);
        //filterByKey(employeeList);
        startWith(employeeList);
        sorting(employeeList);
    }
    public static List<Employee>filerData(List<Employee>list){

        List<Employee>filterList=list.stream().filter(x-> x.getEname().equals("dashrath") &&x.getDept().equals("sofware")).collect(Collectors.toList());
        return  filterList;
    }
    public static List<Employee>addOneListDataIntoOther(List<Employee> addList){
        final List<Employee>addData=new ArrayList<>();
        addList.forEach(x->{
            x.getDept();
            x.getEname();
            x.getId();
            x.getSalary();
            addData.add(x);
        });
        return addData;
    }

    public static List<Employee>findQuniqeData(List<Employee>list){
       List<Employee> disempList= list.stream().distinct().collect(Collectors.toList());
        return disempList;
    }




/*
Stream.of(1,2,4,3,5).max(Comparator.naturalOrder())
        .ifPresent(maxInt->System.out.println("Maximum number in the set is " + maxInt));
*/

    //sort using java 7
    private void sortUsingJava7(List<String> names) {
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }
    //sort using java 8
    private static void sortUsingJava8(List<Employee> names) {
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));

    }
    //groupingby method for obtaining group of elements

    public static Map<String,List<Employee>>getEmplaoyeeBasedOnDept(List<Employee>employees){
      Map<String,List<Employee>> groupingbyDept= employees.stream().collect(Collectors.groupingBy(Employee::getDept));
      return groupingbyDept;
    }

    public static Map<String,Double>getEmpsalaryGrouping(List<Employee> employees){
       Map<String,Double>salaryGrouping= employees.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.summingDouble(Employee::getSalary)));
        return salaryGrouping;
    }
    //find perticular employee is there or not
    public static void  findEmp(List<Employee>employees){
       Map<Integer,List<Employee>> groupingByid=  employees.stream().collect(Collectors.groupingBy(Employee::getId));


        Optional<List<Employee>> filterList = groupingByid.entrySet().stream()
                .filter(e -> e.getKey().equals(111))
                .map(Map.Entry::getValue).findAny();
        System.out.println("*************************************************");
        System.out.println("fiter list"+filterList);;

        Optional<Integer> optionalIsbn = groupingByid.entrySet().stream()
                .filter(e -> e.getKey().equals(101))
                .map(Map.Entry::getKey)
                .findFirst();
        if(optionalIsbn.isPresent()){
            System.out.println("employee is find"+optionalIsbn.get());
        }
    }

    public static void getAvgSalary(List<Employee> employees){
        Map<String,Double>avgSalary=employees.stream().collect(Collectors.groupingBy(Employee::getEname,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("*******************************");;
        System.out.println("average salary"+avgSalary);
    }
/*
    public static void filterByKey(List<Employee>employees){

       Map<Object,Object>map= employees.stream().collect(Collectors.toMap(x->x.getSalary(),x->x.getDept()));
      //Map<Object,Object>map1= map.entrySet().stream().filter(x->x.getKey().equals(111)).collect(Collectors.toMap(y->y.getKey(),y->y.getValue()));

        System.out.println("sorted map is"+map);

        *//*Map<Integer, String> result = hmap.entrySet()
                .stream()
                .filter(map -> map.getKey().intValue() <= 22)
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));*//*
    }*/

    public static void startWith(List<Employee> employees){
      List<Employee> strings=  employees.stream().filter(x->x.getDept().startsWith("s")).collect(Collectors.toList());
        System.out.println("*******************************");
        System.out.println("start with s"+strings);
    }

    public static void sorting(List<Employee> employees){
        List result = employees.stream().sorted((o1, o2)->o1.getEname().
                compareTo(o2.getEname())).
                collect(Collectors.toList());

        System.out.println("****************************************");
        System.out.println("soretd list"+result);
    }

    public static void sorty(List<Employee> employees){

      employees .sort((s1,s2)-> {
           return Comparator.comparing(Employee::getSalary)
                   .compare(s1,s2);
       });
    }

}
