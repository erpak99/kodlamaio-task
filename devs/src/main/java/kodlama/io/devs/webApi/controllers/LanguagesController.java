package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.business.requests.CreateLanguageRequest;
import kodlama.io.devs.business.requests.UpdateLanguageRequest;
import kodlama.io.devs.business.responses.GetAllLanguagesResponse;
import kodlama.io.devs.business.responses.GetByIdLanguageResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/languages")
@AllArgsConstructor
public class LanguagesController {

	private LanguageService languageService;
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(CreateLanguageRequest createLanguageRequest) {
		languageService.add(createLanguageRequest);
	}
	
	@GetMapping()
	public List<GetAllLanguagesResponse> getAll() {
		return languageService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdLanguageResponse getById(@PathVariable int id) {
		return languageService.getById(id);
	}
	
	@PutMapping()
	public void update(UpdateLanguageRequest updateLanguageRequest) {
		languageService.update(updateLanguageRequest);
	}
	
	@DeleteMapping()
	public void delete(int id) {
		languageService.delete(id);
	}
	
}
