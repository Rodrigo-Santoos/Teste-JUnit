package io.github.rodrigo_santoos.locadora;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DatabaseTest {
	
	static  Connection connection;
	
	@BeforeAll // AQUI ESTAMOS DIZENDO QUE ESSA FUNCAO VAI SER RODADA ENTES DE TUDO
	static void setUpDataBase() throws SQLException {
		//aqui estamos abrindo a conexao
		connection = DriverManager.getConnection("jdbc:h2:mem:testedb", "sa","");
		
		//estamos criando a tabela
		connection.createStatement().execute("CREATE TABLE users(id INT, name VARCHAR)");
	}
	
	//@Test
	@BeforeAll
	@DisplayName ("Teste de insercao de dados na tabela users")
	void inserindoDadosTest() throws SQLException {
		connection.createStatement().execute("INSERT INTO users(id, name) VALUES (1,'Rodrigo')");
	}
	
	@Test
	@DisplayName("Teste se trouxe dados do banco")
	void verificaSeExisteDadoNoBanco()  throws SQLException{
		
		ResultSet executeQuery = connection.createStatement().executeQuery("select * from usurs where id = 1");
		
		assertTrue(executeQuery.next());
		
	}
	
	@AfterAll
	void fechandoConexaoComBanco() throws SQLException{
		connection.close();
	}

}
