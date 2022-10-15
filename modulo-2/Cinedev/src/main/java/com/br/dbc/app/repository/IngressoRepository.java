package com.br.dbc.app.repository;

import com.br.dbc.app.exceptions.BancoDeDadosException;
import com.br.dbc.app.model.Filme;
import com.br.dbc.app.model.Ingresso;

import java.sql.*;
import java.util.List;

public class IngressoRepository implements Repository<Integer, Ingresso> {

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT SEQ_ID_INGRESSO.nextval seq FROM DUAL";
        Statement stat = connection.createStatement();
        ResultSet rest = stat.executeQuery(sql);
        if(rest.next()){
            rest.getInt("seq");
        }
        return null;

    }

    @Override
    public Ingresso adicionar(Ingresso ingresso) throws BancoDeDadosException {
        Connection conexao = null;
        try{
            conexao = ConexaoDadosCineDev.getConnection();

            Integer chaveId = this.getProximoId(conexao);
            ingresso.setIdIngresso(chaveId);

            String sql = "INSERT INTO INGRESSO (ID_INGRESSO,ID_CINEMA, ID_FILME, ID_CLIENTE, VALOR, CADEIRA, DATA_HORA, DISPONIBLIDADE)\n" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, ingresso.getIdIngresso());
            pst.setInt(2,ingresso.getCinema().getIdCinema());
            pst.setInt(3,  ingresso.getFilme().getIdFilme());
            pst.setInt(4, ingresso.getCliente().getIdCliente());
            pst.setDouble(5, ingresso.getPreco());
            pst.setInt(6, ingresso.getCadeira());
            pst.setTimestamp(7, ingresso.getDataHora());
            pst.setBoolean(8, ingresso.getDisponibilidade().isDisponibilidade());

            int ret = pst.executeUpdate();
            if(ret==0){
                System.out.println("Não foi possivel realizar a compra!");
            }
            System.out.println("Parabéns! Você realizou sua compra!");
            return ingresso;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        Connection conexao = null;
        try{
            conexao = ConexaoDadosCineDev.getConnection();
            String sql = "DELETE FROM INGRESSO WHERE ID_INGRESSO = ?";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            int ret = pst.executeUpdate();
            if(ret==0){
                System.out.println("Não foi possível realizar o cancelamento do Ingresso!");
            }
            System.out.println("O Ingresso foi cancelado com sucesso!");
            return ret>0;
        }catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean editar(Integer id, Ingresso ingresso) throws BancoDeDadosException {
        Connection conexao = null;
        try{
            conexao = ConexaoDadosCineDev.getConnection();


            String sql = "UPDATE INGRESSO SET VALOR = ?, CADEIRA = ?," +
                    "DATA_HORA = ?, DISPONIBILIDADE = ? WHERE ID_INGRESSO = ?";

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setDouble(5, ingresso.getPreco());
            pst.setInt(6, ingresso.getCadeira());
            pst.setTimestamp(7, ingresso.getDataHora());
            pst.setBoolean(8, ingresso.getDisponibilidade().isDisponibilidade());
            pst.setInt(5, id);

            int ret = pst.executeUpdate();
            if(ret==0){
                System.out.println("Não foi possível realizar a alteração do seu Ingresso!");
            }
            System.out.println("O Ingresso foi alterado com sucesso!");
            return ret>0;

        }catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Ingresso> listar() throws BancoDeDadosException {
        return null;
    }
}
