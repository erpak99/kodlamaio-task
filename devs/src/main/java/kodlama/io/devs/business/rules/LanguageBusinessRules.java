package kodlama.io.devs.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.devs.core.utilities.exceptions.BusinessException;
import kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LanguageBusinessRules {

	private LanguageRepository languageRepository;
	
	public void checkIfLanguageNameExists(String name) {
		if(languageRepository.existsByName(name)) {
			throw new BusinessException("Language name " + name + " already exists");
		}
	}
	
	public void checkIfLanguageExists(int id) {
		if(!languageRepository.existsById(id)) {
			throw new BusinessException("Language with id " + id + " not found");
		}
	}
	
}
