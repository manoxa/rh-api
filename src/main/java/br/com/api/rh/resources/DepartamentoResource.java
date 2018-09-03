package br.com.api.rh.resources;

import br.com.api.rh.domain.Departamento;
import br.com.api.rh.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoResource {

    @Autowired
    private DepartamentoService departamentoService;

    @RequestMapping(method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<List<Departamento>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(departamentoService.buscarTodos());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Departamento> buscarPorId(@PathVariable("id") Long id){
        Departamento departamento = departamentoService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(departamento);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody Departamento departamento){
        departamento = departamentoService.salvar(departamento);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(departamento.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void atualizar(@RequestBody Departamento departamento, @PathVariable("id") Long id) {
        departamento.setId(id);
        departamentoService.editar(departamento);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable("id") Long id) {
        departamentoService.excluir(id);
    }

    @RequestMapping(value = "/temcargos/{id}", method = RequestMethod.GET)
    public boolean departamentoTemCargos(@PathVariable("id") Long id){
        return departamentoService.departamentoTemcargos(id);
    }
}
