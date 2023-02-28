package kodlama.io.devs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.business.requests.CreateLanguageRequest;
import kodlama.io.devs.business.requests.UpdateLanguageRequest;
import kodlama.io.devs.business.responses.GetAllLanguagesResponse;
import kodlama.io.devs.business.responses.GetByIdLanguageResponse;
import kodlama.io.devs.business.rules.LanguageBusinessRules;
import kodlama.io.devs.core.utilities.mappers.ModelMapperService;
import kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.entities.concretes.Language;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;
	private ModelMapperService modelMapperService;
	private LanguageBusinessRules languageBusinessRules;
	
	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {
		
		languageBusinessRules.checkIfLanguageNameExists(createLanguageRequest.getName());
		
		Language language = this.modelMapperService.forRequest().map(createLanguageRequest, Language.class);
		
		this.languageRepository.save(language);		
				
	}

	@Override
	public List<GetAllLanguagesResponse> getAll() {
		List<Language> languages = languageRepository.findAll();
		
		List<GetAllLanguagesResponse> languagesResponse =
				languages
				.stream().map(language -> this.modelMapperService.forResponse()
				.map(language, GetAllLanguagesResponse.class)).collect(Collectors.toList());
				
		return languagesResponse;		
	}

	@Override
	public GetByIdLanguageResponse getById(int id) {
		
		languageBusinessRules.checkIfLanguageExists(id);
		Language language = languageRepository.findById(id).orElseThrow();
		
		GetByIdLanguageResponse response = 
				modelMapperService.forResponse().map(language, GetByIdLanguageResponse.class);		
		
		return response;
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) {
		Language language = modelMapperService.forRequest().map(updateLanguageRequest, Language.class);
		languageRepository.save(language);
	}

	@Override
	public void delete(int id) {
		languageRepository.deleteById(id);
	}

}
