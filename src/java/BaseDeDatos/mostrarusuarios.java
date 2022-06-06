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

public class mostrarusuarios {

    String email;
    String identificacion;
    String direccion;
    String nombre;
    String clave;
    String foto;
    int id;
    int rol;
    ArrayList usersList;
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
            usersList = new ArrayList();
            connection = getConnection();
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select*from cliente " );
            while(rs.next()){
                mostrarusuarios us = new mostrarusuarios();
                us.setId(rs.getInt("id_cliente"));
                us.setNombre(rs.getString("nombe"));
                us.setIdentificacion(rs.getString("identificacion"));
                us.setDireccion(rs.getString("direccion"));
                us.setEmail(rs.getString("email"));
                us.setClave(rs.getString("clave"));
                 usersList.add(us);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return usersList;
    }
    
    public String editar(int id) {
        mostrarusuarios user = null;
        System.out.println(id);
        try {
            connection = getConnection();
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select*from cliente where id_cliente=" + (id));
            rs.next();
            user = new mostrarusuarios();
            user.setId(rs.getInt("id_cliente"));
            user.setNombre(rs.getString("nombe"));
            user.setIdentificacion(rs.getString("identificacion"));
            user.setDireccion(rs.getString("direccion"));
            user.setEmail(rs.getString("email"));
            user.setClave(rs.getString("clave"));
            user.setFoto(rs.getString("foto"));
            sessionMap.put("edituser", user);
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return "editU.xhtml?faces-redirect=true";
    }
    
     
     public String update (mostrarusuarios u){
         try {
             connection=getConnection();
             PreparedStatement stmt=connection.prepareStatement("update cliente set nombe=?,identificacion=?,direccion=?,email=?,clave=?,foto=? where id_cliente=?");
             stmt.setString(1, u.getNombre());
             stmt.setString(2, u.getIdentificacion());
             stmt.setString(3, u.getDireccion());
             stmt.setString(4, u.getEmail());
             stmt.setString(5, u.getClave());
             stmt.setString(6, u.getFoto());
             stmt.setInt(7, u.getId());
             stmt.executeUpdate();
             connection.close();
         } catch (Exception e) {
             System.out.println();
         }
        return "index_admin.xhtml?faces-redirect=true";
     }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public ArrayList getUsersList() {
        return usersList;
    }

    public void setUsersList(ArrayList usersList) {
        this.usersList = usersList;
    }

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    
    public mostrarusuarios() {
    }

}
