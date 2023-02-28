package kodlama.io.devs.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.devs.core.utilities.exceptions.BusinessException;
import kodlama.io.devs.dataAccess.abstracts.TechnologyRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TechnologyBusinessRules {

	private TechnologyRepository technologyRepository;
	
	public void checkIfTechnologyNameExists(String name) {
		if(technologyRepository.existsByName(name)) {
			throw new BusinessException("Technology name "  + name + " already exists");
		}
	}
	
	public void checkIfTechnologyExists(int id) {
		if(!technologyRepository.existsById(id)) {
			throw new BusinessException("Technology with id " + id + " not found");
		}
	}
	
}
