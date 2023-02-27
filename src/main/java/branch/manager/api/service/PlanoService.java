package branch.manager.api.service;

import branch.manager.api.entity.Plano;
import branch.manager.api.exception.UnprocessableEntity;
import branch.manager.api.repository.PlanoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Objects;
import java.util.Optional;

@Service
public class PlanoService {

    @Autowired
    private PlanoJpaRepository planoJpaRepository;

    @Transactional
    public Plano salvar(Plano plano){
        this.validarInformacoes(plano);
        return planoJpaRepository.save(plano);
    }

    public Plano retornarPorId(Long id){
        return planoJpaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    @Transactional
    public Plano atualizar(Plano plano, Long id){
        Optional<Plano> planoDb = planoJpaRepository.findById(id);
        if(planoDb.isPresent()){
            this.validarInformacoes(plano);
            return planoJpaRepository.save(plano);
        }
        throw  new EntityNotFoundException("Id informado não encontrado na base");
    }

    @Transactional
    public void deletar(Long id){
        planoJpaRepository.deleteById(id);
    }

    public Page<Plano> listarPlanos(String descricao,Pageable pageable){
        if(descricao == null || descricao.isEmpty()){
            return planoJpaRepository.findAll(pageable);
        }
        return planoJpaRepository.findByDescricaoLikeIgnoreCase(montarQuery(descricao), pageable);
    }

    private String montarQuery(String campo){
        return "%" +campo + "%";
    }

    private void validarInformacoes(Plano plano){
        if (Objects.isNull(plano.getDescricao()) || plano.getDescricao().isEmpty()){
            throw UnprocessableEntity.builder().message("Necessário informar a descrição").build();
        }
    }
}
