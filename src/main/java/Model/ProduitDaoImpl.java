package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitDaoImpl implements IProduitDao {
    @Override
    public Produit save(@org.jetbrains.annotations.NotNull Produit p) {
        Connection conn= ConnectBD.getConnection();
        try {
            PreparedStatement ps= conn.prepareStatement("INSERT INTO produits(nomproduit,prix,fournisseurProduit) VALUES(?,?,?)");
            ps.setString(1, p.getNomProduit());
            ps.setDouble(2, p.getPrix());
            ps.setString(3, p.getfournisseurProduit());
            ps.executeUpdate();
            PreparedStatement ps2= conn.prepareStatement
                    ("SELECT MAX(idproduit) as MAX_ID FROM produits");
            ResultSet rs =ps2.executeQuery();
            if (rs.next()) {
                p.setIdProduit(rs.getLong("MAX_ID"));
            }
            ps.close();
            ps2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
    @Override
    public List<Produit> produitsParMC(String mc) {
        List<Produit> prods= new ArrayList<Produit>();
        Connection conn=ConnectBD.getConnection();
        try {
            PreparedStatement ps= conn.prepareStatement("select * from produits where produits.nomproduit LIKE ?");
            ps.setString(1,
                    "%"+mc+"%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produit p = new Produit();
                p.setIdProduit(rs.getLong("idproduit"));
                p.setNomProduit(rs.getString("nomproduit"));
                p.setPrix(rs.getDouble("prix"));
                p.setfournisseurProduit(rs.getString("fournisseurProduit"));
                prods.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prods;
    }
    @Override
    public Produit getProduit(Long id) {
        Connection conn=ConnectBD.getConnection();
        Produit p = new Produit();
        try {
            PreparedStatement ps= conn.prepareStatement("select * from produits where idproduit = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p.setIdProduit(rs.getLong("idproduit"));
                p.setNomProduit(rs.getString("nomproduit"));
                p.setPrix(rs.getDouble("prix"));
                p.setfournisseurProduit(rs.getString("fournisseuProduit"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
    @Override
    public Produit updateProduit(Produit p) {
        Connection conn=ConnectBD.getConnection();
        try {
            PreparedStatement ps= conn.prepareStatement("UPDATE produits SET nomproduit=?,prix=?,fournisseurProduit=? WHERE idproduit=?");
            ps.setString(1, p.getNomProduit());
            ps.setDouble(2, p.getPrix());
            ps.setString(3, p.getfournisseurProduit());

            ps.setLong(4, p.getIdProduit());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
    @Override
    public void deleteProduit(Long id) {
        Connection conn=ConnectBD.getConnection();
        try {
            PreparedStatement ps= conn.prepareStatement("DELETE FROM produits WHERE idproduit = ?");
            ps.setLong(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}