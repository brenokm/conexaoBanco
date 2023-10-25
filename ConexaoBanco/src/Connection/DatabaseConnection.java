/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Classes.Pessoa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DatabaseConnection {
 //COLOCAR O NOME DO BANCO DE DADOS QUE VOCE CRIOU
 private static final String URL="jdbc:mysql://192.168.10.129:3306/breno_crud";
 //COLOCAR O USUARIO QUE LOGA NO MYSQL WORKBENCH
 private static final String USER="bpassos";
 //COLOCAR A SENHA QUE LOGA NO MYSQL WORBENCH
 private static final String PASSWORD="root";
 
 
 
 public static Connection GetConnection(){
try{
    System.out.println("Funcionou");
    return DriverManager.getConnection(URL,USER,PASSWORD);
}
catch(SQLException e){
    System.err.println("Não funcionou");
      throw new RuntimeException(e);
}      
 finally{
         
}
 }

// Método para inserir uma nova Pessoa no banco.
    public void create(Pessoa pessoa) {
        // Query SQL para inserção.
        String query = "INSERT INTO crud(cpf, nome, idade) VALUES (?, ?, ?)";
        try (
            // Estabelece uma conexão com o banco.
            Connection conn = GetConnection();
            // Cria um PreparedStatement para executar a query.
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            // Atribui os valores da pessoa para a query.
            stmt.setString(1, pessoa.getCpf());
            stmt.setString(2, pessoa.getNome());
            stmt.setInt(3, pessoa.getIdade());
            // Executa a query.
            stmt.execute();
        } catch (SQLException e) {
            // Lança uma exceção em caso de erro.
            throw new RuntimeException(e);
        }
    }

 





 }



