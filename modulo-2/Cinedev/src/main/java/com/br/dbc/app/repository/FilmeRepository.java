package com.br.dbc.app.repository;

import com.br.dbc.app.exceptions.BancoDeDadosException;
import com.br.dbc.app.model.Filme;
import com.br.dbc.app.model.enums.Idioma;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmeRepository implements Repository<Integer, Filme>{
    @Override
    public Integer getProximoId(Connection connection) throws SQLException {

        String sql = "SELECT SEQ_ID_FILME.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if (res.next()) {
            return res.getInt("mysequence");
        }

        return null;
    }


    @Override
    public Filme adicionar(Filme filme) throws BancoDeDadosException {
        Connection conexao = null;

        try{
            conexao = ConexaoDadosCineDev.getConnection();

            Integer chaveId = this.getProximoId(conexao);
           filme.setIdFilme(chaveId);

            String sql = "INSERT INTO FILME (ID_FILME, NOME, IDIOMA, CLASSIFICACAO, DURACAO)\n" +
                    "VALUES (?, ?, ?, ?, ?)\n";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, filme.getIdFilme());
            pst.setString(2, filme.getNome());
            pst.setString(3, filme.getIdioma().getIdioma());
            pst.setInt(4, filme.getClassificacaoEtaria());
            pst.setInt(5, filme.getDuracao());

            int ret = pst.executeUpdate();
            if(ret==0){
                System.out.println("Não foi possivel realizar o cadastramento!");
            }
                System.out.println("O Filme foi cadastrado com sucesso!");
                return filme;
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
            String sql = "DELETE FROM FILME WHERE ID_FILME = ?";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            int ret = pst.executeUpdate();
            if(ret==0){
                System.out.println("Não foi possível realizar a remoção do Filme!");
            }
            System.out.println("O filme foi removido com sucesso!");
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
    public boolean editar(Integer id, Filme filme) throws BancoDeDadosException {
        Connection conexao = null;
        try{
            conexao = ConexaoDadosCineDev.getConnection();


            String sql = "UPDATE FILME SET NOME = ?, IDIOMA = ?," +
                    "CLASSIFICACAO = ?, DURACAO = ? WHERE ID_FILME = ?";

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, filme.getNome());
            pst.setString(2, filme.getIdioma().getIdioma());
            pst.setInt(3, filme.getClassificacaoEtaria());
            pst.setInt(4, filme.getDuracao());
            pst.setInt(5, id);

            int ret = pst.executeUpdate();
            if(ret==0){
                System.out.println("Não foi possível realizar a alteração do Filme!");
            }
            System.out.println("O filme foi alterado com sucesso!");
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
    public List<Filme> listar() throws BancoDeDadosException {
        List<Filme> listaFilmes = new ArrayList<>();
        Connection conexao = null;
        try{
            conexao = ConexaoDadosCineDev.getConnection();
            Statement stat = conexao.createStatement();

            String sql = "SELECT * FROM FILME";

            ResultSet ret = stat.executeQuery(sql);
            while(ret.next()){
                Filme filme = new Filme();
                filme.setIdFilme(ret.getInt("ID_FILME"));
                filme.setNome(ret.getString("NOME"));
                filme.setIdioma(Idioma.valueOf(ret.getString("IDIOMA")));
                filme.setClassificacaoEtaria(ret.getInt("CLASSIFICACAO"));
                filme.setDuracao(ret.getInt("DURACAO"));
                listaFilmes.add(filme);
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
        return listaFilmes;
    }
}
