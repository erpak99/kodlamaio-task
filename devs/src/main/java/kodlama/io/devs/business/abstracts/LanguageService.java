package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.CreateLanguageRequest;
import kodlama.io.devs.business.requests.UpdateLanguageRequest;
import kodlama.io.devs.business.responses.GetAllLanguagesResponse;
import kodlama.io.devs.business.responses.GetByIdLanguageResponse;

public interface LanguageService {
	void add(CreateLanguageRequest createLanguageRequest);
	List<GetAllLanguagesResponse> getAll();
	GetByIdLanguageResponse getById(int id);
	void update(UpdateLanguageRequest updateLanguageRequest);
	void delete(int id);
}
