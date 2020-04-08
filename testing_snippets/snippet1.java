String[] arr1 = {"A","B","A","C","D"};
List<String> list1 = new ArrayList<String>(new LinkedHashSet<>(Arrays.asList(arr1)));
list1.stream().forEach(x -> System.out.println(x));