import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Patient {
    private String nom;
    private Set <String > ordonnance ;
    public Patient ( String n){
        this.nom=n;
        ordonnance = new HashSet <String >();
    }
    public String getNom () { return nom ;}
    public boolean ordonnanceVide (){
        return ordonnance.isEmpty();
    }
    public void ajoutMedicament ( String m) {
        ordonnance.add(m);
    }
    public void affiche(){
        if(this.ordonnanceVide()){
            System.out.println("l'ordonnance de patient "+nom+" est vide !");
        }
        else{
            System.out.println("l'ordonnance de patient "+nom+" est :");
            for (String med:ordonnance ){
                if (med!=null){ 
                    System.out.println(med);
                }
                
            }
            System.out.println();
        }
    }
    public boolean contientMedicament (String m) {
        return ordonnance.contains(m);
    }
    public void trieOrdonnace() {
        ordonnance=new TreeSet<String>(ordonnance);
    }
    
    public static void main(String[] args) {
        Patient p=new Patient("Iyed");
        p.ajoutMedicament("med 1");
        p.ajoutMedicament("med 2");
        p.ajoutMedicament("med 3");
        p.ajoutMedicament("aed 1");
        p.trieOrdonnace();
        p.affiche();
        System.out.println(p.contientMedicament("med 1"));
        System.out.println(p.ordonnanceVide());
    }
}