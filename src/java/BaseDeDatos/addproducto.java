package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;
import javafx.scene.control.Alert;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped

public class addproducto {

    String nombre, descr, foto, email;
    int id, idCli, sotck;
    Double precio;
    ArrayList userList;
    private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    Connection connection;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/integrador", "root", "");
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }

    
     public ArrayList usersList(){
        try {
            userList = new ArrayList();
            connection = getConnection();
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select*from cliente " );
            while(rs.next()){
                addproducto us = new addproducto();
                us.setId(rs.getInt("id_cliente"));
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return userList;
    }


    public String crear() {
        int result = 0;
        try {
            
            connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO  producto(nombre,foto,descripcion,precio,id_cliente,stock) values(?,?,?,?,?,?)");

            stmt.setString(1, nombre);
            stmt.setString(2, foto);
            stmt.setString(3, descr);
            stmt.setDouble(4, precio);
            stmt.setInt(5, idCli);
            stmt.setInt(6, sotck);
            result = stmt.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        if (result != 0) {
            return "index_vendedor.xhtml?faces-redirec=true";
        } else {
            return "addproducto.xhtml?faces-redirec=true";
        }
    }

    public int getSotck() {
        return sotck;
    }

    public void setSotck(int sotck) {
        this.sotck = sotck;
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCli() {
        return idCli;
    }

    public void setIdCli(int idCli) {
        this.idCli = idCli;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public ArrayList getUserList() {
        return userList;
    }

    public void setUserList(ArrayList userList) {
        this.userList = userList;
    }

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public addproducto() {
    }

}
