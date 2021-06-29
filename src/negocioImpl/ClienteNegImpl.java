package negocioImpl;

import Dao.ClienteDao;
import DaoImpl.ClienteDaoImpl;
import Entidad.Cliente;
import negocio.ClienteNeg;

public class ClienteNegImpl implements ClienteNeg {
	
	private ClienteDao cliDao = new ClienteDaoImpl();

	@Override
	public boolean insertar(Cliente cliente) {
		return cliDao.insertar(cliente);
	}

}
