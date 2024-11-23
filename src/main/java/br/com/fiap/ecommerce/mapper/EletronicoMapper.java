package br.com.fiap.ecommerce.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.ecommerce.dtos.EletronicoRequestCreateDto;
import br.com.fiap.ecommerce.dtos.EletronicoRequestUpdateDto;
import br.com.fiap.ecommerce.dtos.EletronicoResponseDto;
import br.com.fiap.ecommerce.model.Eletronicos;

@Component
public class EletronicoMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public EletronicoResponseDto toDto(Eletronicos eletronico) {
		return modelMapper.map(eletronico, EletronicoResponseDto.class);
	}
	
	public Eletronicos toModel(EletronicoRequestCreateDto dto) {
		return modelMapper.map(dto, Eletronicos.class);
	}
	
	public Eletronicos toModel(Long id, EletronicoRequestUpdateDto dto) {
		Eletronicos eletronico = modelMapper.map(dto, Eletronicos.class);
		eletronico.setId(id);
		return eletronico;
	}
	
}
