package branch.manager.api.controller;

import branch.manager.api.entity.Cliente;
import branch.manager.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private  ClienteService clienteService;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Page<Cliente> retornarClientes(@RequestParam(required = false) String nome,
                                          @PageableDefault(sort = "nome", direction = Sort.Direction.ASC) Pageable paginacao){
        return clienteService.listarClientes(nome,paginacao);
    }
    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Cliente> retornarPorId(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.retornarPorId(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<Cliente> salvarCliente(@RequestBody @Validated Cliente cliente){
        return ResponseEntity.ok(clienteService.salvar(cliente));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id,@RequestBody @Validated Cliente cliente){
        return ResponseEntity.ok(clienteService.atualizar(cliente,id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        clienteService.deletar(id);
    }

}
