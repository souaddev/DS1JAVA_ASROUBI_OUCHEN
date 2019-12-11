
public class Test {

	public static void main(String[] args) {
		
		MyBuffer buffer=new MyBuffer(100);
		
		Processor processor1=new Processor("Premiere processeur",buffer);
		Processor processor2=new Processor("Deuxieme processeur",buffer);
		
		
		Lecteur lecteur1=new Lecteur("Premiere lecteur","fichier1",buffer);
		Lecteur lecteur2=new Lecteur("Deuxieme lecteur","fichier2",buffer);

		processor1.start();
		processor2.start();
		
		lecteur1.start();
		lecteur2.start();
	}

}
