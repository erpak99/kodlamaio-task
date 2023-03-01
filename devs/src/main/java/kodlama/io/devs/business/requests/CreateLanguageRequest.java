package kodlama.io.devs.business.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateLanguageRequest {
	
	@NotNull(message = "Name can not be null")
	@NotBlank(message = "Name can not be empty")
	private String name;

}
