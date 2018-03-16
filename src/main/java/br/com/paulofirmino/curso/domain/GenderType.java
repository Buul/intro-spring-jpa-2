package br.com.paulofirmino.curso.domain;

public enum GenderType {
	FEMALE('F'), MALE('M');

	private char desc;

	GenderType(char desc) {
		this.desc = desc;
	}

	public char getDesc() {
		return desc;
	}

}
