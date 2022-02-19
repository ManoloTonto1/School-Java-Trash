import java.io.*; import java.lang.reflect.*; import java.lang.annotation.*; import java.util.*; import java.util.stream.*; import java.time.*; // Please do not change or remove this line.

class Trainingsschema {

	private static ArrayList<Oefening> alleOefeningen = initialiseerOefeningen();
	private static Integer volgendUniekNummer = 20220201;
	private Integer nummer;
	private String klant;
	private String trainer;

	private static ArrayList<Oefening> initialiseerOefeningen(){
		//Create the class instances/ objects and then add them to the arraylist
		Oefening PushUps = new Oefening("Push-ups","Armen",3,3,30);
		Oefening SitUps = new Oefening("Sit-ups","Buik",3,4,30);
		Oefening Squats = new Oefening("Squats","Benen",2,5,30);
		Oefening Supermans = new Oefening("Supermans", "Rug",3,3,15);
		Oefening ChestDip = new Oefening("Chest-dips","Borst",3,3,30);
		ArrayList<Oefening> List = new ArrayList<>();
		Collections.addAll(List,PushUps,SitUps,Squats,Supermans,ChestDip);

		return List;

	}
	private static ArrayList<Oefening> getOefeningen(ArrayList<String> spierGroepen){
		ArrayList<Oefening> newList = new ArrayList<>();
		for(int i = 0;i<spierGroepen.size();i++){
			for(int j=0; j<alleOefeningen.size();j++){
				if(alleOefeningen.get(j).getSpierGroep().contains(spierGroepen.get(i))){
					newList.add(alleOefeningen.get(j));
				}
			}

		}
		return newList;

	}
	private static  Integer uniekNummer(){
		Integer current_num = volgendUniekNummer;
		volgendUniekNummer++;
		return current_num;

	}

	private static void printOefening(String naam, String spierGroep, Integer aantalSets, Integer herhalingen, Integer rustTijd)
	{
		System.out.println("Oefening voor " + spierGroep + ":" +
				" herhaal " + aantalSets + " keer " +
				"(rust tussendoor " + rustTijd + " seconden) " +
				herhalingen +
				" " + naam);
	}

	public Trainingsschema(String klant){
		this.klant = klant;
		this.nummer = uniekNummer();

	}
	public Trainingsschema(String klant,String trainer){

		this(klant);
		this.trainer = trainer;

	}
	public void printSchema(ArrayList<String> spierGroepen){

		//print the name and number of the customer
		System.out.println("Schema: "+this.klant);
		System.out.println("Nummer: "+this.nummer);
        if(this.trainer != null){
            System.out.println("Trainer: "+this.trainer);
        }
		
		for (int i=0;i<spierGroepen.size();i++){
			//print the exercises for each spiergroep
			//return the relevant objects from the array
			ArrayList<Oefening> newlist = getOefeningen(spierGroepen);

			printOefening(
					newlist.get(i).getNaam(),
					spierGroepen.get(i),
					newlist.get(i).getAantalSets(),
					newlist.get(i).getHerhalingen(),
					newlist.get(i).getRustTijd());

		}
		System.out.println(" ");

	}

}


class Oefening{
	private String naam;
	private String spierGroep;
	private Integer aantalSets;
	private Integer herhalingen;
	private Integer rustTijd;

	//Constructor.
	public Oefening(String naam,String spierGroep,Integer aantalSets,Integer herhalingen,Integer rustijd){
		this.naam = naam;
		this.spierGroep = spierGroep;
		this.aantalSets = aantalSets;
		this.herhalingen = herhalingen;
		this.rustTijd = rustijd;

	}

	public String getNaam() {
		return naam;
	}

	public String getSpierGroep() {
		return spierGroep;
	}

	public Integer getAantalSets() {
		return aantalSets;
	}

	public Integer getHerhalingen() {
		return herhalingen;
	}

	public Integer getRustTijd() {
		return rustTijd;
	}
}



class Main
{
	public static void main(String[] args)
	{
		ArrayList<String> spierGroepenArnold = new ArrayList<>();
		spierGroepenArnold.add("Armen");
		spierGroepenArnold.add("Buik");
		spierGroepenArnold.add("Benen");
		spierGroepenArnold.add("Rug");
		spierGroepenArnold.add("Borst");
		Trainingsschema arnold = new Trainingsschema("Arnold Schwarzenegger");
		arnold.printSchema(spierGroepenArnold);

		ArrayList<String> spierGroepenKim = new ArrayList<>();
		spierGroepenKim.add("Buik");
		spierGroepenKim.add("Rug");
		Trainingsschema Kim = new Trainingsschema("Kim Kardashian","Daphne Jongejans");
		Kim.printSchema(spierGroepenKim);
	}
}