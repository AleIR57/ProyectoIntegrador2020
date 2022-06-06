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

public class iniciarsesion {

    String email;
    String identificacion;
    String direccion;
    String nombre;
    String clave;
    int id;
    int rol;
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

    
         public String inicio() {
        int result = 0;
        String sql = "select * from cliente where email ='" + email + "'and clave='" + clave + "'and roles='1'";
        String sql2 = "select * from cliente where email ='" + email + "'and clave='" + clave + "'and roles='2'";
        String sql3 = "select * from cliente where email ='" + email + "'and clave='" + clave + "'and roles='3'";
        try {
            Statement stmt = getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                result = 1;

                if (result == 1) {
                    return "index_admin.xhtml?faces-redirect=true";
                }
            }

            Statement stm = getConnection().prepareStatement(sql2);
            ResultSet r = stmt.executeQuery(sql2);

            if (r.next()) {
                result = 1;

                if (result == 1) {
                    return "index_comprador.xhtml?faces-redirect=true";
                }
            }
            Statement st = getConnection().prepareStatement(sql3);
            ResultSet rsr = stmt.executeQuery(sql3);

            if (rsr.next()) {
                result = 1;

                if (result == 1) {
                    return "index_vendedor.xhtml?faces-redirect=true";
                }
            }
        } catch (Exception e) {
        }
        
        return "Sesion.xhtml?faces-redirect=true";
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

    
    public iniciarsesion() {
    }

}
