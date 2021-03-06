package model;


import basica.Cliente;
import repository.ConexaoException;
import repository.DAOCliente;
import repository.RepositoryException;

public class RNClienteConsultar {
	public Cliente consultar(Cliente cliente) throws Exception{
		valida(cliente);
		Cliente aux = consulta(cliente);
		
		return aux;
	}
	
	private void valida(Cliente cliente) throws Exception{
		if((cliente.getCpf() == null) || (cliente.getCpf().isEmpty())) {
			throw new Exception("CPF Inv�lido");
		}
	}
	
	private Cliente consulta(Cliente cliente) throws Exception{
		DAOCliente dao = new DAOCliente();
		
		try {
			Cliente aux = dao.consultar(cliente);
			
			if(aux == null) {
				throw new Exception("Nenhum dado encontrado ao consultar ");
			}
			
			return aux;
		} catch(ConexaoException e) {
			throw new Exception("Erro Conex�o ao Consultar " + e.getMessage());
		} catch(RepositoryException e) {
			throw new Exception("Erro Reposit�rio ao Consultar " + e.getMessage());
		}
	}
}