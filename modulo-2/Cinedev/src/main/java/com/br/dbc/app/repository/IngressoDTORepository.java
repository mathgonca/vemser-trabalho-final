package com.br.dbc.app.repository;

import com.br.dbc.app.exceptions.BancoDeDadosException;
import com.br.dbc.app.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IngressoDTORepository implements Repository<Integer, IngressoDTO> {

    public List<IngressoDTO> listIngressos(int idFilme, int idCinema) throws BancoDeDadosException {
        List<IngressoDTO> ingressos = new ArrayList<>();

        Connection conexao = null;
        try {
            conexao = ConexaoDadosCineDev.getConnection();
            String sql = "SELECT i.ID_INGRESSO, i.DATA_HORA, i.VALOR FROM INGRESSO" +
                    " i WHERE i.ID_FILME = ? AND i.ID_CINEMA = ? AND i.DISPONIBLIDADE = 'S'";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idFilme);
            stmt.setInt(2, idCinema);

            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                IngressoDTO ingressoDTO = new IngressoDTO();
                ingressoDTO.setIdIngressoDTO(res.getInt("ID_INGRESSO"));
                ingressoDTO.setDataHora(res.getTimestamp("DATA_HORA").toLocalDateTime());
                ingressoDTO.setValor(res.getDouble("VALOR"));
                ingressos.add(ingressoDTO);
            }
            return ingressos;
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
    public Integer getProximoId(Connection connection) throws SQLException {
        return null;
    }

    @Override
    public IngressoDTO adicionar(IngressoDTO object) throws BancoDeDadosException {
        return null;
    }

    @Override
    public Ingresso adicionar(Ingresso ingresso, Cliente cliente, Cinema cinema, Filme filme) throws BancoDeDadosException {
        return null;
    }

    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        return false;
    }

    @Override
    public boolean editar(Integer id, IngressoDTO ingressoDTO) throws BancoDeDadosException {
        return false;
    }

    @Override
    public List<IngressoDTO> listar() throws BancoDeDadosException {
        return null;
    }
}
