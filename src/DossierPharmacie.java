import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DossierPharmacie {
    private String nom ;
    private HashMap <String , Patient > patients ;
    public DossierPharmacie ( String n){
        nom =n;
        patients = new HashMap <String , Patient >();
    }
    void nouveauPatient ( String nom , String [] ord ){
        String minNom=nom.toLowerCase();
        Patient patient=new Patient(minNom);
        for(int i=0;i<ord.length;i++){
            patient.ajoutMedicament(ord[i]);
        }
        patients.put(minNom,patient);
    }
    public boolean ajoutMedicament (String nom, String m){
        for(Patient patient : patients.values()){
            if(patient.getNom().equalsIgnoreCase(nom)){
                patient.ajoutMedicament(m);
                return true;
            }
        }
        return false;
    }
    public void affichePatient(String nom) {
        boolean patientTrouve = false;
        for (Patient patient : patients.values()) {
            if (patient.getNom().equalsIgnoreCase(nom)) {
                patient.affiche();
                patientTrouve = true;
                break;
            }
        }
        if (!patientTrouve) {
            System.out.println("Le patient " + nom + " n'a pas été trouvé.");
        }
    }
    public void affiche (){
        if(patients.isEmpty()){
            System.out.println("le dossier de pharmacie de nom "+nom+" est vide !");
        }
        else{
            System.out.println("le dossier de pharmacie de nom "+nom+"est :");
            for (Patient patient:patients.values() ){
                if (patient!=null){ 
                    patient.affiche();
                }
            }
            System.out.println();
        }
    }
    public Collection <String > affichePatientAvecMedicament (String m){
        Set <String > pat = new HashSet <>();
        if (!patients.isEmpty()) {
            for(Patient patient:patients.values()){
                if(patient.contientMedicament(m)){
                    pat.add(patient.getNom());
                }
            }
        }
        return pat;
    }
    public static void main(String[] args) {
        DossierPharmacie dos=new DossierPharmacie("pharmacie");
        String[] ordonnance = {"med1", "med2", "med3"};
        String[] ordonnance2 = {"med5", "med6", "med3"};
        dos.nouveauPatient("iyed", ordonnance);  
        dos.nouveauPatient("mouhamed", ordonnance);
        dos.nouveauPatient ("Ali", ordonnance2);
        dos.ajoutMedicament("iyed", "med4");
        dos.affiche();
        dos.affichePatient("iyed");
        System.out.println(dos.affichePatientAvecMedicament("med2"));
    }
}
