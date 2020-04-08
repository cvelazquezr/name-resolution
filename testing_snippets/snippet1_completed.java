import java.util.LinkedHashSet;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

String[] arr1 = {"A","B","A","C","D"};
List<String> list1 = new ArrayList<String>(new LinkedHashSet<>(Arrays.asList(arr1)));
list1.stream().forEach(x -> System.out.println(x));
