package dao;
import Model.Produit;
import Model.ProduitDaoImpl;

import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        ProduitDaoImpl pdao= new ProduitDaoImpl();
        Produit prod= pdao.save(new Produit("zoubair",2800,"hiba"));
        System.out.println(prod);
        List<Produit> prods =pdao.produitsParMC("HP");
        for (Produit p : prods)
            System.out.println(p);
    }
}