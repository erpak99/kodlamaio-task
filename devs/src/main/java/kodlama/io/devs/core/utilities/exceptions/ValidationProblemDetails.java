package kodlama.io.devs.core.utilities.exceptions;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidationProblemDetails extends ProblemDetails {

	private Map<String, String> validationErrors;

	
}
