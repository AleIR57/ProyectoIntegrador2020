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

public class mostrarproductos {

    String nombre, foto, descripcion;
    int id,cantidad,stock,idventa;
    double precio;
    ArrayList usersList,proList;
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
    
    public String delete(int id) {
        try {
            connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement("delete from producto where id_producto= " + id);
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return "index_vendedor.xhtml?faces-redirect=true";
    }
    
    
     public String update (mostrarproductos u){
         try {
             connection=getConnection();
             PreparedStatement stmt=connection.prepareStatement("update producto set nombre=?,foto=?,descripcion=?,precio=?,stock=? where id_producto=?");
             stmt.setString(1, u.getNombre());
             stmt.setString(2, u.getFoto());
             stmt.setString(3, u.getDescripcion());
             stmt.setDouble(4, u.getPrecio());
             stmt.setInt(5, u.getStock());
             stmt.setInt(6, u.getId());
             
             stmt.executeUpdate();
             connection.close();
         } catch (Exception e) {
             System.out.println();
         }
        return "index_vendedor.xhtml?faces-redirect=true";
     }
     
    
    public String buscar(){
        mostrarproductos user = null;
        
            try {
            connection = getConnection();
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select*from producto where id_producto='"+id+"'");
            rs.next();
            user = new mostrarproductos();
            user.setId(rs.getInt("id_producto"));
            user.setNombre(rs.getString("nombre"));
            user.setFoto(rs.getString("foto"));
            user.setDescripcion(rs.getString("descripcion"));
            user.setPrecio(rs.getInt("precio"));
            user.setStock(rs.getInt("stock"));
            System.out.println("nombre");
            sessionMap.put("producto", user);
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
            return "index_vendedor_1.xhtml?faces-redirect=true";
        }
    
    
   public ArrayList usersList(){
        try {
            usersList = new ArrayList();
            connection = getConnection();
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select*from producto " );
            while(rs.next()){
                mostrarproductos us = new mostrarproductos();
                us.setId(rs.getInt("id_producto"));
                us.setNombre(rs.getString("nombre"));
                us.setFoto(rs.getString("foto"));
                us.setDescripcion(rs.getString("descripcion"));
                us.setPrecio(rs.getDouble("precio"));
                usersList.add(us);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return usersList;
    }
  
    public String verpro() {
        mostrarproductos user = null;
        System.out.println(id);
        try {
            connection = getConnection();
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select*from producto where id_producto=" + (id));
            rs.next();
            user = new mostrarproductos();
            user.setId(rs.getInt("id_producto"));
            user.setNombre(rs.getString("nombre"));
            user.setFoto(rs.getString("foto"));
            user.setDescripcion(rs.getString("descripcion"));
            user.setPrecio(rs.getInt("precio"));
            System.out.println("precio");
            sessionMap.put("addventa",user);
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return "index_vendedor_1.xhtml?faces-redirect=true";
    }
   
       public String comprar(int id) {
        mostrarproductos user = null;
        System.out.println(id);
        try {
            connection = getConnection();
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select*from producto where id_producto=" + (id));
            rs.next();
            user = new mostrarproductos();
            user.setId(rs.getInt("id_producto"));
            user.setNombre(rs.getString("nombre"));
            user.setFoto(rs.getString("foto"));
            user.setDescripcion(rs.getString("descripcion"));
            user.setPrecio(rs.getInt("precio"));
            user.setStock(rs.getInt("stock"));
            System.out.println("precio");
            sessionMap.put("addventa",user);
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return "carro.xhtml?faces-redirect=true";
    }
   
       public String venta(int id, int precio, mostrarproductos u) {
        int result = 0;
        int result2 = 0;
        try {

            connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO detalles_compra(id_producto, cantidad, precio, nombre_cliente) VALUES (?,?,?,?)");
            stmt.setInt(1, id);
            stmt.setInt(2, cantidad);
            stmt.setDouble(3, precio * cantidad);
            stmt.setInt(4, this.id);
            result = stmt.executeUpdate();
            
             PreparedStatement stm = connection.prepareStatement("UPDATE producto SET stock = ? WHERE id_producto = "+id);
              stm.setInt(1, u.getStock()- getCantidad());
            result2 = stm.executeUpdate(); 
        } catch (Exception e) {
            System.out.println(e);
        }
        if (result != 0) {
            return "index_comprador.xhtml?faces-redirec=true";
        } else {
            return "carro.xhtml?faces-redirec=true";
        }
    }
       
       
        public String crearreporte() {
        int result = 0;
        try {
            
            connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO devolucion( nombre_producto, cantidad, precio, descripcion, id_producto, id_venta) VALUES (?,?,?,?,?,?)");
            stmt.setString(1, nombre);
            stmt.setInt(2, cantidad);
            stmt.setDouble(3, precio);
            stmt.setString(4, descripcion);
            stmt.setInt(5, id);
            stmt.setInt(6, idventa); 
            
            result = stmt.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        if (result != 0) {
            return "index.xhtml?faces-redirec=true";
        } else {
            return "reportes.xhtml?faces-redirec=true";
        }
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

        
        
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
       
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    
    
    
    public mostrarproductos() {
    }
    
}
