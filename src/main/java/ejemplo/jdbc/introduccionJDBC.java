package ejemplo.jdbc;
        
import java.sql.*;


public class introduccionJDBC {
    
    public static void main(String[] args) {
        //paso 1: se crea la cadena de conexion en este caso mysql
    String url = "jdbc:mysql://localhost:3307/test?useSSL=false&"
            + "serverTimezone=UTC";
    
        try {
            //paso 2:creamos el objeto de  conexion a la base de datos
            Connection conexion = DriverManager.getConnection(url, "root", "(Tu clave)");
            
            //paso 3: Creamos un objeto de tipo Statement
            Statement instruccion = conexion.createStatement();
            
            //paso 4: Creamos el query
            String sql = "select id_persona, nombre, apellido, email, telefono"
                    + " from test.persona ";
            
            //paso 5: ejecucion del query
            ResultSet resultado = instruccion.executeQuery(sql);
            
            //paso 6: procesamos el resultado
            while(resultado.next()){
                System.out.print("Id persona: " + resultado.getInt(1));
                System.out.print(" Nombre: " + resultado.getString(2));
                System.out.print(" Apellido: " + resultado.getString(3));
                System.out.print(" Email: " + resultado.getString(4));
                System.out.println(" Telefono: " + resultado.getString(5));
            }
            
            //paso 7: cerramos el objeto utilizado
            resultado.close();
            instruccion.close();
            conexion.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
}
