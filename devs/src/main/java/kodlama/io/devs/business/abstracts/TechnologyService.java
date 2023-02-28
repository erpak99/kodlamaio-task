package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.CreateTechnologyRequest;
import kodlama.io.devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.devs.business.responses.GetAllTechnologiesResponse;
import kodlama.io.devs.business.responses.GetByIdTechnologyResponse;

public interface TechnologyService {
	void add(CreateTechnologyRequest createTechnologyRequest);
	List<GetAllTechnologiesResponse> getAll();
	GetByIdTechnologyResponse getById(int id);
	void update(UpdateTechnologyRequest updateTechnologyRequest);
	void delete(int id);
}
