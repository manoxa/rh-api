package br.com.api.rh.service;

import br.com.api.rh.domain.Departamento;

import java.util.List;

public interface DepartamentoService {
	
	Departamento salvar(Departamento departamento);
	
	void editar(Departamento departamento);
	
	void excluir(Long id);
	
	Departamento buscarPorId(Long id);
	
	List<Departamento> buscarTodos();

	boolean departamentoTemcargos(Long id);

}
