import java.util.*;

public class CollectionExamples {
    public static void ex1(){
        HashSet<Integer> set = new HashSet();
        Random rand = new Random();
        while(set.size() != 10){
            set.add(rand.nextInt(21));
        }

        System.out.println(set);
    }

    public static void ex2(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Find and remove duplicates in: ");
        String input = sc.nextLine();

        LinkedHashSet<Character> charactersSet = new LinkedHashSet<>();
        HashSet<Character> duplicates = new HashSet<>();

        for(int i=0;i<input.length();i++){
            if(charactersSet.contains(input.charAt(i)))
            {
                duplicates.add(input.charAt(i));
            }

            charactersSet.add(input.charAt(i));
        }

        System.out.println("All characters(a single time): " + charactersSet);
        System.out.println("Duplicates: " + duplicates);
    }

    public static void ex3(){
        StudentImproved student1 = new StudentImproved("Ana", "1A34F");
        StudentImproved student2 = new StudentImproved("Alex", "42G4B");
        StudentImproved student3 = new StudentImproved("Alex", "42G4B");
        StudentImproved student4 = new StudentImproved("Ion", "A5G4H");
        StudentImproved student5 = new StudentImproved("Florin", "DF43J");
        StudentImproved student6 = new StudentImproved("Georgiana", "P2D5H");
        StudentImproved student7 = new StudentImproved("Florin", "DF43J");

        List<StudentImproved> studentList = Arrays.asList(student1, student2, student3, student4, student5, student6, student7);
        LinkedHashSet<StudentImproved> uniqueStudentList = new LinkedHashSet<>(studentList);

        System.out.println("Initial list: " + studentList);
        System.out.println();
        System.out.println("Unique elements list: " + uniqueStudentList);

    }

    public static void ex4(){
        HashSet<Integer> set = new HashSet<>();
        Collections.addAll(set, 1,2,3,4,5,6);
        for(Integer nr:set){
            System.out.println(nr);
        }
    }

    public static void ex5(){
        StudentImproved student1 = new StudentImproved("Ana", "1A34F");
        StudentImproved student2 = new StudentImproved("Alex", "42G4B");
        StudentImproved student3 = new StudentImproved("Ion", "A5G4H");
        StudentImproved student4 = new StudentImproved("Florin", "DF43J");
        StudentImproved student5 = new StudentImproved("Georgiana", "P2D5H");

        List<StudentImproved> students = Arrays.asList(student1, student2,student3 ,student4, student5);

        ArrayList<StudentImproved> studentsList = new ArrayList<>(students);

        HashSet<StudentImproved> studentsSet = new HashSet<>(students);

        Scanner sc = new Scanner(System.in);


        String name1 = "Alex";
        String personalCode1 = "42G4B";

        String name2 = "Cosmin";
        String personalCode2 = "74HSA";

        StudentImproved target1 = new StudentImproved(name1, personalCode1);
        StudentImproved target2 = new StudentImproved(name2, personalCode2);


        if(ex5_1(studentsList, target1)){
            System.out.println("Student with code " + personalCode1 + " exists in the ArrayList");
        }
        else{
            System.out.println("Student with code " + personalCode1 + " doesn't exist in the ArrayList");
        }

        if(ex5_2(studentsSet, target2)){
            System.out.println("Student with code " + personalCode2 + " exists HashSet");
        }
        else{
            System.out.println("Student with code " + personalCode2 + " doesn't exist in the HashSet");
        }

    }
    public static boolean ex5_1(ArrayList studentsList, StudentImproved target){
        System.out.println(target.equals(studentsList.get(1)));
        return studentsList.contains(target);
    }
    public static boolean ex5_2(HashSet studentsSet, StudentImproved target){
        return studentsSet.contains(target);
    }



    public static void ex6(){
        HashMap<Integer, String> IdNameMap = new HashMap<>();
        IdNameMap.put(1, "Alex");
        IdNameMap.put(2,"Andreea");
        IdNameMap.put(3,"Cristian");

        System.out.println("Elements in hashmap: ");
        for(Object item:IdNameMap.entrySet()){
            System.out.println(item);
        }

    }

    public static void ex7(){
        StudentImproved student1 = new StudentImproved("Ana", "1A34F");
        StudentImproved student2 = new StudentImproved("Alex", "42G4B");
        StudentImproved student3 = new StudentImproved("Ion", "A5G4H");
        StudentImproved student4 = new StudentImproved("Florin", "DF43J");
        StudentImproved student5 = new StudentImproved("Georgiana", "P2D5H");

        List<StudentImproved> students = Arrays.asList(student1, student2,student3 ,student4, student5);

        ArrayList<StudentImproved> studentsList = new ArrayList<>(students);

        System.out.println("Initial list: " + studentsList);
        Collections.sort(studentsList, new StudentComparator());
        System.out.println();
        System.out.println("Sorted list: " + studentsList);
    }
}
