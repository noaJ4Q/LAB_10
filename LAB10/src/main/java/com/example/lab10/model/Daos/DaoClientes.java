package com.example.lab10.model.Daos;

import com.example.laboratorio9_20192858.model.beans.Clientes;

import java.sql.*;
import java.util.ArrayList;

public class DaoClientes {
    public ArrayList<Clientes> listarClientes(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/bi_corp_business";
        ArrayList<Clientes> lista = new ArrayList<>();
        try {
            //Mi base de datos tiene contraseña 123456
            Connection connection = DriverManager.getConnection(url, "root", "123456");
            String sql = "SELECT concat(g4093_name,' ',coalesce(g4093_last_name,' ')) as'Nombre de Cliente', \n" +
                    "g4093_age as 'Edad de Cliente', g4093_type as 'Tipo de Cliente',\n" +
                    "g4093_documentType as 'Tipo de Documento',g4093_nro_id, count(g4093_nro_id) as 'numero de contratos'\n" +
                    "FROM bi_corp_business.jm_client_bii clientes, bi_corp_business.jm_cotr_bis contratos, bi_corp_business.jm_values valores\n" +
                    "where (clientes.g4093_nro_id = contratos.client_nro_id and\n" +
                    "contratos.g6789_cod_nup = valores.jm_cotr_bis_g6789_cod_nup)\n" +
                    "group by g4093_nro_id";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                Clientes client = new Clientes();
                client.setNombreCliente(rs.getString(1));
                client.setEdad(rs.getString(2));
                String variable =rs.getString(3);
                if (variable.equalsIgnoreCase("N")){
                    variable = "Normal";
                }else{
                    variable = "Juridico";
                }
                client.setTipoCliente(variable);
                client.setTipoDocumento(rs.getString(4));
                client.setNumeroDocumento(rs.getString(5));
                client.setCantidaddeContratos(rs.getInt(6));
                lista.add(client);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
}
