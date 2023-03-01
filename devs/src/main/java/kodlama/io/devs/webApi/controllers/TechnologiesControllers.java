package kodlama.io.devs.webApi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.requests.CreateTechnologyRequest;
import kodlama.io.devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.devs.business.responses.GetAllTechnologiesResponse;
import kodlama.io.devs.business.responses.GetByIdTechnologyResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/technologies")
@AllArgsConstructor
public class TechnologiesControllers {

	private TechnologyService technologyService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@Valid CreateTechnologyRequest createTechnologyRequest) {
		technologyService.add(createTechnologyRequest);
	}
	
	@GetMapping
	public List<GetAllTechnologiesResponse> getAll() {
		return technologyService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdTechnologyResponse getById(@PathVariable int id) {
		return technologyService.getById(id);
	}
	
	@PutMapping
	public void update(@Valid UpdateTechnologyRequest updateTechnologyRequest) {
		technologyService.update(updateTechnologyRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		technologyService.delete(id);
	}
}
