package br.com.fiap.ecommerce.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.ecommerce.dtos.EletronicoRequestCreateDto;
import br.com.fiap.ecommerce.dtos.EletronicoRequestUpdateDto;
import br.com.fiap.ecommerce.dtos.EletronicoResponseDto;
import br.com.fiap.ecommerce.dtos.ProdutoRequestCreateDto;
import br.com.fiap.ecommerce.dtos.ProdutoRequestUpdateDto;
import br.com.fiap.ecommerce.dtos.ProdutoResponseDto;
import br.com.fiap.ecommerce.mapper.EletronicoMapper;
import br.com.fiap.ecommerce.mapper.ProdutoMapper;
import br.com.fiap.ecommerce.repository.EletronicoRepository;
import br.com.fiap.ecommerce.repository.ProdutoRepository;
import br.com.fiap.ecommerce.service.EletronicoService;
import br.com.fiap.ecommerce.service.ProdutoService;
import br.com.fiap.ecommerce.views.ProdutoFullView;
import br.com.fiap.ecommerce.views.ProdutoSimpleView;
import br.com.fiap.ecommerce.views.ProdutoViewType;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/eletronicos")
public class EletronicoController {  
	@Autowired
    private ProdutoService produtoService;
	@Autowired
    private ProdutoMapper produtoMapper;
	@Autowired
    private ProdutoRepository produtoRepository;
	@Autowired
    private EletronicoMapper eletronicoMapper;
	@Autowired
    private EletronicoService eletronicoService;
	@Autowired
	private EletronicoRepository eletronicoRepository;

	@GetMapping
	public ResponseEntity<List<EletronicoResponseDto>> list() {
		List<EletronicoResponseDto> dtos = eletronicoService.list()
				.stream()
				.map(e -> eletronicoMapper.toDto(e))
				.toList();
		
		return ResponseEntity.ok().body(dtos);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<EletronicoResponseDto> findById(@PathVariable Long id) {
		return ResponseEntity.ok()
						.body(
								eletronicoService
											.findById(id)
											.map(e -> eletronicoMapper.toDto(e))
											.orElseThrow(() -> new RuntimeException("Id inexistente"))
						);
	}
	
	@GetMapping("/find")
	public ResponseEntity<?> findByNome(@RequestParam String nome) {
		return ResponseEntity.ok().body(eletronicoRepository.findByNome(nome));
	}
    
    @PostMapping
	public ResponseEntity<EletronicoResponseDto> create(@RequestBody EletronicoRequestCreateDto dto) {
		
		return ResponseEntity
						.status(HttpStatus.CREATED)
						.body(
									eletronicoMapper.toDto(
										eletronicoService.save(eletronicoMapper.toModel(dto)))
						);
	}

    @PutMapping("{id}")
    public ResponseEntity<ProdutoResponseDto> update(
                        @PathVariable Long id, 
                        @RequestBody ProdutoRequestUpdateDto dto) {
        if (! produtoService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }                
        return ResponseEntity.ok()
        		.body(
        			produtoMapper.toDto(
        				produtoService.save(produtoMapper.toModel(id, dto)))
        		);
    }
    
	@PutMapping("/eletro/{id}")
	public ResponseEntity<EletronicoResponseDto> update(@PathVariable Long id, @RequestBody EletronicoRequestUpdateDto dto) {
		if (! eletronicoService.existsById(id)) {
			throw new RuntimeException("Id inexistente");
		}
		return ResponseEntity.ok()
						.body(
								 eletronicoMapper.toDto(
										eletronicoService.save(eletronicoMapper.toModel(id, dto)))
						);
	}
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (! produtoService.existsById(id)){
        	throw new RuntimeException("Id inexistente");
        }

        produtoService.delete(id);
    }
}
