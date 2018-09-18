package br.com.api.rh.service;

import java.time.LocalDate;
import java.util.List;

import br.com.api.rh.domain.Funcionario;

public interface FuncionarioService {

	Funcionario salvar(Funcionario funcionario);

	void editar(Funcionario funcionario);

	void excluir(Long id);

	Funcionario buscarPorId(Long id);

	List<Funcionario> buscarTodos();

	List<Funcionario> buscarPorNome(String nome);

	List<Funcionario> buscarCargoPorId(Long id);

	List<Funcionario> buscarPorDatas(LocalDate entrada, LocalDate saida);

}
