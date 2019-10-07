package com.jckuntz.cursomc.domain.enums;

public enum TipoCliente {
	
	PESSOA_FISICA(0,"Pessoa Física"),
	PESSOA_JURIFICA(1, "Pessoa Jur[idica");
	
	private int code;
	private String desc;
	
	private TipoCliente(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	public int getCode() {
		return code;
		
	}
	
	public String getDesc() {
		return desc;
	}

	
	public static TipoCliente toEnum(Integer code) {
		if (code == null) {
			return null;
		}
		
		for (TipoCliente x: TipoCliente.values()) {
			if (code.equals(x.getCode())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("ID inválido");
	}
}
