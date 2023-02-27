package branch.manager.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class DetalheDeErrosDto implements Serializable {

    private Integer status;

    private OffsetDateTime timestamp;

    private String titulo;

    private String detail;

}
