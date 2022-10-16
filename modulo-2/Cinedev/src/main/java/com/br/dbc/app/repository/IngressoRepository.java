package com.br.dbc.app.repository;

import com.br.dbc.app.exceptions.BancoDeDadosException;
import com.br.dbc.app.model.Cinema;
import com.br.dbc.app.model.Cliente;
import com.br.dbc.app.model.Filme;
import com.br.dbc.app.model.Ingresso;
import com.br.dbc.app.model.enums.Disponibilidade;
import com.br.dbc.app.model.enums.Idioma;

import java.sql.*;
import java.util.ArrayList;
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
    public Ingresso adicionar(Ingresso object) throws BancoDeDadosException {
        return null;
    }


    @Override
    public Ingresso adicionar(Ingresso ingresso, Cliente cliente, Cinema cinema, Filme filme) throws BancoDeDadosException {
        Connection conexao = null;

        try{
            conexao = ConexaoDadosCineDev.getConnection();


            Integer chaveId = this.getProximoId(conexao);
            ingresso.setIdIngresso(chaveId);

            String sql = "INSERT INTO INGRESSO (ID_INGRESSO,ID_CINEMA, ID_FILME, ID_CLIENTE, VALOR, CADEIRA, DATA_HORA, DISPONIBLIDADE)\n" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, ingresso.getIdIngresso());
            pst.setInt(2,cinema.getIdCinema());
            pst.setInt(3,  filme.getIdFilme());
            pst.setInt(4, cliente.getIdCliente());
            pst.setDouble(5, ingresso.getPreco());
            pst.setInt(6, ingresso.getCadeira());
            pst.setTimestamp(7, Timestamp.valueOf(ingresso.getDataHora()));
            pst.setString(8, ingresso.getDisponibilidade().isDisponibilidade());

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
            pst.setTimestamp(7, Timestamp.valueOf(ingresso.getDataHora()));
            pst.setString(8, ingresso.getDisponibilidade().isDisponibilidade());
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
        List<Ingresso> listarIngresso = new ArrayList<>();
        Connection conexao = null;
        try{
            conexao = ConexaoDadosCineDev.getConnection();
            Statement stmt = conexao.createStatement();
            String sql = "SELECT * FROM INGRESSO";
            ResultSet res = stmt.executeQuery(sql);
            while(res.next()){
                Ingresso ingresso = new Ingresso();
                Cliente cliente = new Cliente();
                Cinema cinema = new Cinema();
                Filme filme = new Filme();
                ingresso.setIdIngresso(res.getInt("ID_INGRESSO"));
                filme.setIdFilme(res.getInt("ID_FILME"));
                cliente.setIdCliente(res.getInt("ID_CLIENTE"));
                cinema.setIdCinema(res.getInt("ID_CINEMA"));
                ingresso.setPreco(res.getDouble("VALOR"));
                ingresso.setCadeira(res.getInt("CADEIRA"));
                ingresso.setDataHora(res.getTimestamp("DATA_HORA").toLocalDateTime());
                ingresso.setDisponibilidade(Disponibilidade.valueOf(res.getString("DISPONIBLIDADE")));
                listarIngresso.add(ingresso);
            }

            return listarIngresso;
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

    public List<Ingresso> listarIngressoComCliente() throws SQLException{
            List<Ingresso> ingressosEclientes = new ArrayList<>();
            Connection conexao = null;

            try{
                conexao = ConexaoDadosCineDev.getConnection();

                String sql = "SELECT I.ID_INGRESSO, C.ID_CLIENTE, C.PRIMEIRO_NOME AS NOME, C.CPF, C.EMAIL, F.ID_FILME, F.NOME AS FILME, F.DURACAO, " +
                        "CM.ID_CINEMA, CM.NOME AS CINEMA, I.VALOR, I.CADEIRA, I.DATA_HORA, I.DISPONIBLIDADE \n" +
                        "FROM CLIENTE C\n" +
                        "INNER JOIN INGRESSO I ON (C.ID_CLIENTE = I.ID_CLIENTE) \n" +
                        "INNER JOIN FILME F ON (I.ID_FILME = F.ID_FILME) \n" +
                        "INNER JOIN CINEMA CM ON (I.ID_CINEMA = CM.ID_CINEMA)";

                PreparedStatement stmt = conexao.prepareStatement(sql);

                ResultSet res = stmt.executeQuery(sql);
                while(res.next()){
                    Ingresso ingresso = getIngressoResultSet(res);
                    ingressosEclientes.add(ingresso);

                }

                return ingressosEclientes;

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

    public Ingresso getIngressoResultSet(ResultSet res) throws SQLException {

        Ingresso ingresso = new Ingresso();
        Cliente cliente = new Cliente();
        Filme filme = new Filme();
        Cinema cinema = new Cinema();

        ingresso.setIdIngresso(res.getInt("ID_INGRESSO"));
        cliente.setIdCliente(res.getInt("ID_CLIENTE"));
        filme.setIdFilme(res.getInt("ID_FILME"));
        cinema.setIdCinema(res.getInt("ID_CINEMA"));

        ingresso.setPreco(res.getInt("VALOR"));
        ingresso.setCadeira(res.getInt("CADEIRA"));
        ingresso.setDataHora(res.getTimestamp("DATA_HORA").toLocalDateTime());
        ingresso.setDisponibilidade(Disponibilidade.valueOf(res.getString("DISPONIBLIDADE")));

        cliente.setPrimeiroNome(res.getString("NOME"));
        cliente.setCpf(res.getString("CPF"));
        cliente.setEmail(res.getString("EMAIL"));

        filme.setNome(res.getString("FILME"));
        filme.setDuracao(res.getInt("DURACAO"));

        cinema.setNome(res.getString("CINEMA"));

        return ingresso;
    }
}
