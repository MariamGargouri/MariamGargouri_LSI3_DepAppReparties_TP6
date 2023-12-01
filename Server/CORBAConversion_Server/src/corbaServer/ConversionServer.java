package corbaServer;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import service.ConversionImpl;

import javax.naming.Context;
import javax.naming.InitialContext;

public class ConversionServer {
    public static void main(String[] args)
    {
        try {
            //initialisation du ORB
            ORB orb = ORB.init(args, null);//jndi c'est un standard
            //Récupération de la référence du Root POA à partir de l'ORB

            POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            //activation du POAManager
            poa.the_POAManager().activate();

            // Création d'une instance de l'implémentation du service de conversion.
            ConversionImpl od = new ConversionImpl();

            /* publication de l’objet dans l’annuaire */
            //Création d'une instance du contexte initial JNDI.
            Context ctx = new InitialContext();
            //Publication de l'objet de conversion dans l'annuaire JNDI avec le nom "BK".
            ctx.rebind("BK", poa.servant_to_reference(od));
            // Exécution de l'ORB, ce qui maintiendra le serveur en attente des demandes des clients.
            orb.run();
            } catch (Exception e) {e.printStackTrace();}
    }
}