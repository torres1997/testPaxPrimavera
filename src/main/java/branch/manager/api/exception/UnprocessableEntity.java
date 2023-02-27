package branch.manager.api.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UnprocessableEntity extends RuntimeException{

    private String message;

    private Integer code;


}
