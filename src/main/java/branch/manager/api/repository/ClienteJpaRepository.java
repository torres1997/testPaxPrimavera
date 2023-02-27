package branch.manager.api.repository;

import branch.manager.api.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteJpaRepository extends JpaRepository<Cliente,Long> {
    Page<Cliente> findByNomeLikeIgnoreCase(String montarQuery, Pageable paginacao);
}
