package branch.manager.api.service;

import branch.manager.api.entity.Cliente;
import branch.manager.api.exception.UnprocessableEntity;
import branch.manager.api.repository.ClienteJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteJpaRepository clienteJpaRepository;

    @Transactional
    public Cliente salvar(Cliente cliente){
        this.validarInformacoes(cliente);
        cliente.setDataCadastro(new Date());

        return clienteJpaRepository.save(cliente);
    }

    private void validarInformacoes(Cliente cliente){
        if(Objects.isNull(cliente.getFilial()) || Objects.isNull(cliente.getFilial().getId())){
            throw UnprocessableEntity.builder().message("Necessário informar a filial").build();
        }
        if(Objects.isNull(cliente.getPlano()) || Objects.isNull(cliente.getPlano().getId())){
            throw UnprocessableEntity.builder().message("Necessário informar o plano").build();
        }
        if( Objects.isNull(cliente.getNome()) || cliente.getNome().isEmpty()){
            throw UnprocessableEntity.builder().message("Necessário informar o nome").build();
        }
        if(Objects.isNull(cliente.getNumero()) || cliente.getNumero().isEmpty()){
            throw UnprocessableEntity.builder().message("Necessário informar o cpf/cnpj").build();
        }
    }

    public Cliente retornarPorId(Long id){
        return clienteJpaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    @Transactional
    public Cliente atualizar(Cliente cliente, Long id){
        Optional<Cliente> clienteDb = clienteJpaRepository.findById(id);
        if(clienteDb.isPresent()){
            this.validarInformacoes(cliente);
            return clienteJpaRepository.save(cliente);
        }
        throw  new EntityNotFoundException("Id informado não encontrado na base");
    }

    @Transactional
    public void deletar(Long id){
        clienteJpaRepository.deleteById(id);
    }

    public Page<Cliente> listarClientes(String nome, Pageable paginacao){
        if(nome == null || nome.isEmpty()){
            return clienteJpaRepository.findAll(paginacao);
        }
        return  clienteJpaRepository.findByNomeLikeIgnoreCase(montarQuery(nome),paginacao);
    }

    private String montarQuery(String campo){
        if(campo == null){
            return "%%";
        }
        return "%" +campo + "%";
    }

}
