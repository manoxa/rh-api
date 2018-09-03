package br.com.api.rh.resources;

import br.com.api.rh.domain.Cargo;
import br.com.api.rh.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cargos")
public class CargoResource {

    @Autowired
    private CargoService cargoService;

    @RequestMapping(method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<List<Cargo>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(cargoService.buscarTodos());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Cargo> buscarPorId(@PathVariable("id") Long id){
        Cargo cargo = cargoService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(cargo);
    }

    @RequestMapping(value = "/temfuncionarios/{id}", method = RequestMethod.GET)
    public boolean cargoTemFuncionarios(@PathVariable("id") Long id){
        return cargoService.cargoTemFuncionarios(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody Cargo cargo){
        cargo = cargoService.salvar(cargo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(cargo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void atualizar(@RequestBody Cargo cargo, @PathVariable("id") Long id) {
        cargo.setId(id);
        cargoService.editar(cargo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable("id") Long id) {
        cargoService.excluir(id);
    }
}
