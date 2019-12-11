import java.util.LinkedList;

public class MyBuffer {
	
	private LinkedList<String> list;
	private int size;
	
	public MyBuffer(int size) {
		list=new LinkedList<String>();
		this.size=size;
	}
	
	public void addWords(String word){
		if(list.size()<size) {
			list.add(word);
			System.out.println(word+" have been added to list");
		}
		else
			System.out.println("La list est pleine !!");
	}
	public String getWord() {
		return list.getLast();
	}
	public void removeWord(String word) {
		 list.remove(word);
	}
	public LinkedList<String> getList() {
		return list;
	}
	public int listMaxSize() {
		return size;
	}
	

}
