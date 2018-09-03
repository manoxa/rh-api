package br.com.api.rh.service;

import java.util.List;

import br.com.api.rh.dao.DepartamentoDao;
import br.com.api.rh.domain.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false)
public class DepartamentoServiceImpl implements DepartamentoService{
	
	@Autowired
	private DepartamentoDao departamentoDao;

	@Override
	public Departamento salvar(Departamento departamento) {
		departamentoDao.save(departamento);
		return departamento;
	}

	@Override
	public void editar(Departamento departamento) {
		departamentoDao.update(departamento);
	}

	@Override
	public void excluir(Long id) {
		departamentoDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Departamento buscarPorId(Long id) {
		return departamentoDao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Departamento> buscarTodos() {
		return departamentoDao.findAll();
	}

	@Override
	public boolean departamentoTemcargos(Long id) {
		return !buscarPorId(id).getCargos().isEmpty();
	}

}
