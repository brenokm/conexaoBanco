/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaobanco;

import Classes.Pessoa;
import Connection.DatabaseConnection;

/**
 *
 * @author bpassos
 */
public class ConexaoBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatabaseConnection DBC=new DatabaseConnection();
        Pessoa pessoinha=new Pessoa("Breno",22,"148.197.028.88");
        DBC.create(pessoinha);
    }
    
}
