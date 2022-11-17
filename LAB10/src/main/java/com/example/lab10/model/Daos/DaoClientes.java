package com.example.lab10.model.Daos;

import com.example.lab10.model.Beans.Clientes;
import com.example.lab10.model.Beans.Contratos;

import java.sql.*;
import java.util.ArrayList;

public class DaoClientes extends DaoBase{
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
                //client.setCantidaddeContratos(rs.getInt(6));
                lista.add(client);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public ArrayList<Contratos> listarContratos (int idCliente){

        ArrayList<Contratos> contratos = new ArrayList<>();
        String sql = "select contrato.g6789_contract,\n" +
                "contrato.client_nro_id,\n" +
                "contrato.g6789_currency,   \n" +
                "case when contrato.G6789_status=0 then 'Normal' when contrato.G6789_status=1 then 'Cura' when contrato.G6789_status=2 then 'Mora' end as 'estado', \n" +
                "contrato.g6789_months \n" +
                "from jm_cotr_bis contrato \n" +
                "inner join jm_client_bii cliente on (cliente.g4093_nro_id = contrato.client_nro_id)\n" +
                "where cliente.g4093_nro_id = ?";

        try (Connection conn = this.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setInt(1, idCliente);

            try (ResultSet rs = pstmt.executeQuery()){
                while (rs.next()){
                    Contratos contrato = new Contratos();

                    contrato.setNroDeContrato(String.valueOf(rs.getInt(1)));
                    contrato.setIdCliente(rs.getInt(2));
                    contrato.setDivisa(rs.getString(3));
                    contrato.setEstado(rs.getString(4));
                    contrato.setMesesEnEseEstado(rs.getInt(5));

                    contratos.add(contrato);

                }
            }

        }catch (SQLException e){
            throw new RuntimeException();
        }

        return contratos;
    }

    public Clientes buscarCliente(int idCliente){

        String sql = "";

        try (Connection conn = this.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

        }
    }

}
