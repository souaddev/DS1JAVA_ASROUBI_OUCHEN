import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.io.*;

public class Lecteur extends Thread{
	private String fileName;
	private String threadName;
	private MyBuffer buff;

	public Lecteur(String threadName,String fileName,MyBuffer buff) {
		 this.fileName=fileName;
		 this.threadName=threadName;
		 this.buff=buff;
	}
	
	public void run() {
		File fichier;
		FileReader fr;
		BufferedReader reader;
					
			try {
				fichier=new File(fileName+".txt");
				fr = new FileReader(fichier);
				reader=new BufferedReader(fr);
				String line;
				String [] words = null;
				while((line=reader.readLine())!=null) {
					words = line.split("[\\s?!?,.:]+");
					
				}
				for(String i:words) {
					readWord(i);
					System.out.println(threadName+" is in proccess");
					sleep(100);
				}
			} catch (IOException | InterruptedException e) {

				e.printStackTrace();
			}

	}
	
	public synchronized void readWord(String word) throws IOException, InterruptedException {
		if(buff.getList().size()<(buff.listMaxSize())) {
			 System.out.println(word);
			buff.addWords(word);
			notify();
		}else
			sleep(100);
         
	}

}
