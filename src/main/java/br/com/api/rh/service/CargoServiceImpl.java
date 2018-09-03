package br.com.api.rh.service;

import java.util.List;

import br.com.api.rh.dao.CargoDao;
import br.com.api.rh.domain.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false)
public class CargoServiceImpl implements CargoService{
	
	@Autowired
	private CargoDao cargoDao;

	@Override
	public Cargo salvar(Cargo cargo) {
		cargoDao.save(cargo);
		return cargo;
	}

	@Override
	public void editar(Cargo cargo) {
		cargoDao.update(cargo);
	}

	@Override
	public void excluir(Long id) {
		cargoDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Cargo buscarPorId(Long id) {
		return cargoDao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cargo> buscarTodos() {
		return cargoDao.findAll();
	}

	@Override
	public boolean cargoTemFuncionarios(Long id) {
		return !buscarPorId(id).getFuncionarios().isEmpty();
	}


}
