package kodlama.io.devs.core.utilities.exceptions;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ValidationProblemDetails extends ProblemDetails{

	private Map<String, String> validationErrors;
	
}
