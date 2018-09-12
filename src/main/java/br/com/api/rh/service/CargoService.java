package br.com.api.rh.service;

import java.util.List;

import br.com.api.rh.domain.Cargo;

public interface CargoService {
	
	Cargo salvar(Cargo cargo);
	
	void editar(Cargo cargo);
	
	void excluir(Long id);
	
	Cargo buscarPorId(Long id);
	
	List<Cargo> buscarTodos();

	boolean cargoTemFuncionarios(Long id);

}
