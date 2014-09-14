public class AKArrayListTest{
	public static void main(String args[]){
		AKArrayList al = new AKArrayList(5);
		String[] s= {"A", "B", "C"};
		for(int i=0; i<3; i++){
			al.add(s[i]);
		}

		al.add("a");
		al.add("b");
		al.insert(2, "f");
		System.out.println(al.toString());
		
	}
}
