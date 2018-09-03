package br.com.api.rh.resources;

import br.com.api.rh.domain.Funcionario;
import br.com.api.rh.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioResource {

    @Autowired
    private FuncionarioService funcionarioServie;

    @RequestMapping(method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<List<Funcionario>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioServie.buscarTodos());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable("id") Long id){
        Funcionario funcionario = funcionarioServie.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(funcionario);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody Funcionario funcionario){
        funcionario = funcionarioServie.salvar(funcionario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(funcionario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void atualizar(@RequestBody Funcionario funcionario, @PathVariable("id") Long id) {
        funcionarioServie.editar(funcionario);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable("id") Long id) {
        funcionarioServie.excluir(id);
    }

}
