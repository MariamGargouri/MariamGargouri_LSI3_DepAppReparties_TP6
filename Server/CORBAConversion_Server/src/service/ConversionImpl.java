package service;
// Importation de l'interface générée à partir de l'IDL CORBA
import corbaConversion.IConversionRemotePOA;

public class ConversionImpl extends IConversionRemotePOA {
    @Override
    // Implémentation de la méthode de conversion de montant
    public double convertirMontant(double mt)
        {return mt*3.3;}// La conversion du montant est effectuée en le multipliant par 3.3
}
