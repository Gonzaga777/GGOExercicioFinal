package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {
	
	public DAO() {
		
	}
	
	public void adicionarVeiculo(Veiculos veiculo) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("insert into veiculos (nome_veiculo, marca, ano_veiculo ) values (?, ?, ?)");
			p.setString(1, veiculo.getNome_veiculo()); 
			p.setString(2, veiculo.getMarca()); 
			p.setInt(3, veiculo.getAno_veiculo());
			
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Veiculos> exibirVeiculos(){
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		ArrayList<Veiculos> lista = new ArrayList<Veiculos>();
		try {
			PreparedStatement p = con.prepareStatement("select * from veiculos");
			ResultSet r = p.executeQuery();	
			
			while (r.next()) {
				Integer cod_veiculo = r.getInt("cod_veiculo");
				String nome_veiculo = r.getString("nome_veiculo");
				String marca = r.getString("marca");
				Integer ano_veiculo = r.getInt("ano_veiculo");

				Veiculos v = new Veiculos(nome_veiculo, marca,ano_veiculo);
				v.setCod_veiculo(cod_veiculo);
				lista.add(v);
			}
			
			r.close();
			p.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public void deletarVeiculos(Integer cod_veiculo) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("delete from veiculos where cod_veiculo = ?");
			p.setInt(1, cod_veiculo);
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void AtualizarVeiculos(Veiculos update) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("update veiculos set nome_veiculo = ? , marca = ? , ano_veiculo = ? where cod_veiculo = ?");
			p.setString(1, update.getNome_veiculo()); 
			p.setString(2, update.getMarca()); 
			p.setInt(3, update.getAno_veiculo());
			p.setInt(4, update.getCod_veiculo());
			
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Veiculos buscarVeiculo(Integer cod_veiculo) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		Veiculos v = null;
		try {
			PreparedStatement p = con.prepareStatement("select * from veiculos where cod_veiculo = ?");
			p.setInt(1, cod_veiculo);
			ResultSet r = p.executeQuery();			
			
			
			while (r.next()) {
				Integer id_veiculo2 = r.getInt("cod_veiculo");
				String nome_veiculo = r.getString("nome_Veiculo");
				String marca = r.getString("marca");
				Integer ano_veiculo = r.getInt("ano_veiculo");
				
			
				v = new Veiculos(nome_veiculo, marca ,ano_veiculo);
				v.setCod_veiculo(id_veiculo2);
			}
			r.close();
			p.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}
	
}
