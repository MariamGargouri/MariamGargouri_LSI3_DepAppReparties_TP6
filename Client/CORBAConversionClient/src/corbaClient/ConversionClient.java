package corbaClient;
import corbaConversion.IConversionRemote;
import corbaConversion.IConversionRemoteHelper;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConversionClient {
    public static void main(String[] args)
    {
        try
        {
            //Création d'un contexte initial JNDI pour interagir avec l'annuaire.
            Context ctx = new InitialContext();

            // Recherche l'objet avec le nom "BK" dans l'annuaire JNDI et obtient une référence de type Object.
            java.lang.Object ref = ctx.lookup("BK");

            //Conversion de la référence récupérée en une référence de type IConversionRemote
            IConversionRemote stub= IConversionRemoteHelper.narrow((org.omg.CORBA.Object)ref); //forçage de corba

            // Appel de la méthode distante pour convertir des montants
            System.out.println(stub.convertirMontant(70.000));
            System.out.println(stub.convertirMontant(150.000));
        }
        catch (NamingException e){e.printStackTrace();}
    }
}
