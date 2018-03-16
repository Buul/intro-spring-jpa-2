package br.com.paulofirmino.curso.web.conversor;

import org.springframework.core.convert.converter.Converter;

import br.com.paulofirmino.curso.domain.GenderType;

public class GenderTypeConverter implements Converter<String, GenderType>{

	@Override
	public GenderType convert(String text) {
		char type = text.charAt(0);
		return type == GenderType.FEMALE.getDesc() ? GenderType.FEMALE : GenderType.MALE;
	}

}
