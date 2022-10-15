package com.br.dbc.app.repository;

import com.br.dbc.app.exceptions.BancoDeDadosException;
import com.br.dbc.app.model.Cinema;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CinemaRepository implements Repository< Integer, Cinema>{

    public Integer getProximoId( Connection connection) throws SQLException{

        String sql = "SELECT SEQ_ID_CINEMA.NEXTVAL SEQUENCIA FROM CINEMA";
        Statement stat = connection.createStatement();
        ResultSet rest = stat.executeQuery(sql);
        if(rest.next()){
            rest.getInt("sequencia");

        }
        return null;
    }

@Override
    public Cinema adicionar(Cinema cinema) throws BancoDeDadosException {
        Connection conexao = null;
        try {
            conexao = ConexaoDadosCineDev.getConnection();
            Integer chaveID = this.getProximoId(conexao);
//            cinema.setId(chaveID);

            String sql = "INSERT INTO CINEMA (ID_CINEMA, NOME, ESTADO, CIDADE)\n" +
                    "values (?, ?, ?, ?):";
            PreparedStatement pst = conexao.prepareStatement(sql);
//            pst.setInt(1, cinema.getId());
            pst.setString(2, cinema.getNome());
            pst.setString(3, cinema.getEstado());
            pst.setString(4, cinema.getCidade());

            int ret = pst.executeUpdate();
            if (ret == 0) {
                System.out.println("Não foi possivel realizar o cadastro");
            }

            System.out.println("o cinema foi cadastrado com sucesso");
            return cinema;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (conexao != null){
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
        try {
            conexao = ConexaoDadosCineDev.getConnection();
            String sql = "DELETE FROM CINEMA WHERE ID_CINEMA = ?";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            int ret = pst.executeUpdate();
            if (ret == 0) {
                System.out.println("Não foi possivel realizar a remoção do cinema");
            }
            System.out.println("O cinema foi removido com sucesso");
            return ret > 0;
        }catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
            }finally {
            try {
                if (conexao != null){
                    conexao.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public boolean editar(Integer id, Cinema cinema) throws BancoDeDadosException {
        Connection conexao = null;
        try{
            conexao = ConexaoDadosCineDev.getConnection();


            String sql = "UPDATE CINEMA SET NOME = ?, ESTADO = ?," +
                    "CIDADE = ? WHERE ID_CINEMA = ?";

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, cinema.getNome());
            pst.setString(2, cinema.getEstado());
            pst.setString(3, cinema.getCidade());
            pst.setInt(4, id);

            int ret = pst.executeUpdate();
            if(ret==0){
                System.out.println("Não foi possível realizar a alteração do Cinema!");
            }
            System.out.println("O Cinema foi alterado com sucesso!");
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
    public List<Cinema> listar() throws BancoDeDadosException {
        List<Cinema> listaCinema = new ArrayList<>();
        Connection conexao = null;
        try{
            conexao = ConexaoDadosCineDev.getConnection();
            Statement stat = conexao.createStatement();

            String sql = "SELECT * FROM CINEMA";

            ResultSet ret = stat.executeQuery(sql);
            while(ret.next()){
                Cinema cinema = new Cinema();
//                cinema.setId(ret.getInt("ID_CINEMA"));
                cinema.setNome(ret.getString("NOME"));
                cinema.setEstado(ret.getString("ESTADO"));
                cinema.setCidade(ret.getString("CIDADE"));
                listaCinema.add(cinema);
            }

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
        return listaCinema;
    }
}

