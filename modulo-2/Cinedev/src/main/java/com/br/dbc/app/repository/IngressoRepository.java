package com.br.dbc.app.repository;

import com.br.dbc.app.exceptions.BancoDeDadosException;
import com.br.dbc.app.model.*;
import com.br.dbc.app.model.enums.Disponibilidade;
import com.br.dbc.app.model.enums.Idioma;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

            String sql = "UPDATE INGRESSO SET ID_CLIENTE = ?, VALOR = ?, DISPONIBLIDADE = ? WHERE ID_INGRESSO = ?";

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, ingresso.getIdCliente());
            pst.setDouble(2, ingresso.getPreco());
            pst.setString(3, ingresso.getDisponibilidade().isDisponibilidade());
            pst.setInt(4, ingresso.getIdIngresso());

            int ret = pst.executeUpdate();
            if (ret == 0) {
                System.out.println("Não foi possível realizar a alteração do seu Ingresso!");
            }
            System.out.println("O Ingresso foi alterado com sucesso!");
            return ret > 0;
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

    public List<IngressoComprado> listarIngressoComprado(Integer id) throws SQLException{
            List<IngressoComprado> ingressosComprados = new ArrayList<>();
            Connection conexao = null;


            try{
                conexao = ConexaoDadosCineDev.getConnection();

                String sql =
                        "SELECT F.NOME AS FILME, C.NOME AS CINEMA,ID_INGRESSO,I.DATA_HORA FROM INGRESSO I\n" +
                                "INNER JOIN CLIENTE CT ON I.ID_CLIENTE = I.ID_CLIENTE \n" +
                                "INNER JOIN FILME F ON F.ID_FILME = I.ID_FILME  \n" +
                                "INNER JOIN CINEMA C ON C.ID_CINEMA = I.ID_CINEMA WHERE CT.ID_CLIENTE = ? ORDER BY I.DATA_HORA";

                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setInt(1, id);

                ResultSet res = stmt.executeQuery(sql);
                while(res.next()){
                    IngressoComprado ingresso = getIngressoResultSet(res);
                    ingressosComprados.add(ingresso);

                }

                return ingressosComprados;

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

    public IngressoComprado getIngressoResultSet(ResultSet res) throws SQLException {

        IngressoComprado ingresso = new IngressoComprado();
        Cliente cliente = new Cliente();

        cliente.setIdCliente(res.getInt("ID_CLIENTE"));
//        ingresso.setIdCliente(res.getInt("ID_CLIENTE"));
        ingresso.setIdIngressoComprado(res.getInt("ID_INGRESSO"));
        ingresso.setNomeFilme(res.getString("FILME"));
        ingresso.setDataHora(res.getTimestamp("DATA_HORA").toLocalDateTime());
        ingresso.setNomeCinema(res.getString("CINEMA"));

        return ingresso;
    }

    public Optional<Ingresso> listarIngressoPeloId(int idIngresso) throws BancoDeDadosException {
        Optional<Ingresso> ingressoOptional = Optional.empty();

        Connection con = null;
        try {
            con = ConexaoDadosCineDev.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM INGRESSO i");
            sql.append(" WHERE i.ID_INGRESSO = ?");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setInt(1, idIngresso);

            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                Ingresso ingresso = new Ingresso();
                ingresso.setIdIngresso(res.getInt("ID_INGRESSO"));
                ingresso.setIdFilme(res.getInt("ID_FILME"));
                ingresso.setIdCliente(res.getInt("ID_CLIENTE"));
                ingresso.setPreco(res.getDouble("VALOR"));
                ingresso.setDataHora(res.getTimestamp("DATA_HORA").toLocalDateTime());
                ingresso.setDisponibilidade(Disponibilidade.valueOf(res.getString("DISPONIBLIDADE")));

                ingressoOptional = Optional.of(ingresso);
            }
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return ingressoOptional;
    }
}
