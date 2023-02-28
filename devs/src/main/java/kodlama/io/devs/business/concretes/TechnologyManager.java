package kodlama.io.devs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.requests.CreateTechnologyRequest;
import kodlama.io.devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.devs.business.responses.GetAllTechnologiesResponse;
import kodlama.io.devs.business.responses.GetByIdTechnologyResponse;
import kodlama.io.devs.business.rules.LanguageBusinessRules;
import kodlama.io.devs.business.rules.TechnologyBusinessRules;
import kodlama.io.devs.core.utilities.mappers.ModelMapperService;
import kodlama.io.devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.devs.entities.concretes.Technology;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TechnologyManager implements TechnologyService {
	
	private TechnologyRepository technologyRepository;
	private ModelMapperService modelMapperService;
	private LanguageBusinessRules languageBusinessRules;
	private TechnologyBusinessRules technologyBusinessRules;

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		
		technologyBusinessRules.checkIfTechnologyNameExists(createTechnologyRequest.getName());
		languageBusinessRules.checkIfLanguageExists(createTechnologyRequest.getLanguageId());
		Technology technology = modelMapperService.forRequest().map(createTechnologyRequest, Technology.class);
		
		technologyRepository.save(technology);
	}

	@Override
	public List<GetAllTechnologiesResponse> getAll() {
		
		List<Technology> technologies = technologyRepository.findAll();
		
		List<GetAllTechnologiesResponse> technologiesResponse = 
					technologies.stream().map(technology -> this.modelMapperService.forResponse()
							.map(technology, GetAllTechnologiesResponse.class)).collect(Collectors.toList());
		
		return technologiesResponse;
	}

	@Override
	public GetByIdTechnologyResponse getById(int id) {
		
		technologyBusinessRules.checkIfTechnologyExists(id);
		Technology technology = technologyRepository.findById(id).orElseThrow();
		
		GetByIdTechnologyResponse response = 
				modelMapperService.forResponse().map(technology, GetByIdTechnologyResponse.class);
		
		return response;
		
	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) {
		Technology technology = 
				modelMapperService.forRequest().map(updateTechnologyRequest, Technology.class);
		technologyRepository.save(technology);
	}

	@Override
	public void delete(int id) {
		technologyBusinessRules.checkIfTechnologyExists(id);
		technologyRepository.deleteById(id);
	}

}
