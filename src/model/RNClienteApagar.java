package model;


import basica.Cliente;
import repository.ConexaoException;
import repository.DAOCliente;
import repository.RepositoryException;

public class RNClienteApagar {

	public void apagar(Cliente cliente) throws Exception {
		valida(cliente);
		verifica(cliente);
		apaga(cliente);
	}
	
	private void valida(Cliente cliente) throws Exception{
		if( ((cliente.getCpf() == null) || (cliente.getCpf().isEmpty()))
				&&
			((cliente.getEmail() == null) || (cliente.getEmail().isEmpty())) ){
			throw new Exception("Dados inv�lidos");
		}
	}
	
	private void verifica(Cliente cliente) throws Exception {
		DAOCliente dao = new DAOCliente();
		
		try {
			Cliente aux = dao.consultar(cliente);
			
			if(aux == null) {
				throw new Exception("Nenhum dado encontrado");
			}
		} catch(ConexaoException e) {
			throw new Exception("Erro Conex�o ao Verificar" + e.getMessage());
		} catch(RepositoryException e) {
			throw new Exception("Erro Reposit�rio ao Verificar" + e.getMessage());
		}
	}
	
	private void apaga(Cliente cliente) throws Exception {
		DAOCliente dao = new DAOCliente();
		
		try {
			dao.excluir(cliente);
		} catch(ConexaoException e) {
			throw new Exception("Erro Conex�o ao Apagar" + e.getMessage());
		} catch(RepositoryException e) {
			throw new Exception("Erro Reposit�rio ao Apagar" + e.getMessage());
		}
	}
}
