import java.util.HashMap;

public class Processor extends Thread{
	
	private MyBuffer buff;
	private String Pname;
	private HashMap<String,Integer> wordsCounts;
	
	public Processor( String Pname,MyBuffer buff) {
		this.Pname=Pname;
		this.buff=buff;
		wordsCounts=new  HashMap<String,Integer> ();
	}
	
	public void run() {
	
			while((buff.getList().isEmpty())) {				
				try {
					sleep(100);
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		
			while((buff.getList().size())!=0)
			{
				processe();
				System.out.println(Pname+" is in proccess");
				notify();
			
		}
			System.out.println(this.getWordsCounts());
			
		}
		
	public synchronized void processe() {
			String word=buff.getWord();
			if(wordsCounts.containsKey(word)) {
				int value=wordsCounts.get(word);
				value++;
				wordsCounts.replace(word,value);
				buff.removeWord(word);
			}
			else
			{
				wordsCounts.put(word,1);
				buff.removeWord(word);
			}
	}
	
	public HashMap<String,Integer> getWordsCounts(){
		return wordsCounts;
	}
	
}
