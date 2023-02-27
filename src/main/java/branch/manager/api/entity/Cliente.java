package branch.manager.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "CLIENTE")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Cliente implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "TELEFONE")
    private String telefone;

    @Column(name = "ENDERECO")
    private String endereco;

    @Column(name = "DATA_CONTRATO")
    private Date dataContrato;

    @Column(name = "DATA_CADASTRO")
    private Date dataCadastro;

    @Column(name = "NUMERO_CONTRATO")
    private Long numeroContrato;

    @JoinColumn(name = "FK_PLANO", referencedColumnName = "ID")
    @ManyToOne
    private Plano plano;

    @JoinColumn(name = "FK_FILIAL", referencedColumnName = "ID")
    @ManyToOne
    private Filial filial;

    public Cliente() {

    }
}
