package branch.manager.api.controller;

import branch.manager.api.entity.Plano;
import branch.manager.api.service.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/api/planos")
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Page<Plano> retornarPlanos(@RequestParam(required = false) String descricao,
                                        @PageableDefault(sort = "descricao", direction = Sort.Direction.ASC) Pageable paginacao){
        return planoService.listarPlanos(descricao,paginacao);
    }
    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Plano> retornarPorId(@PathVariable Long id){
        return ResponseEntity.ok(planoService.retornarPorId(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<Plano> salvarPlano(@RequestBody  Plano plano){
        return ResponseEntity.ok(planoService.salvar(plano));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Plano> atualizarPlano(@RequestBody Plano plano,@PathVariable Long id){
        return ResponseEntity.ok(planoService.atualizar(plano,id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        planoService.deletar(id);
    }

}
