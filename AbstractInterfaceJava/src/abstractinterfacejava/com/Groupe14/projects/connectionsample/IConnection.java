/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractinterfacejava.com.Groupe14.projects.connectionsample;

import java.sql.Connection;
import java.sql.SQLException;


public interface IConnection {
    Connection getConnection() throws SQLException;
}
