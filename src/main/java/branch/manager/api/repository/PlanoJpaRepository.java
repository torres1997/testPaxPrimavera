package branch.manager.api.repository;

import branch.manager.api.entity.Plano;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoJpaRepository extends JpaRepository<Plano,Long> {
    Page<Plano> findByDescricaoLikeIgnoreCase(String descricao, Pageable pageable);
}
