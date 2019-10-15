package com.jckuntz.cursomc.domain.enums;

public enum EstadoPagamento {
	
	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private int code;
	private String desc;
	
	private EstadoPagamento(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	public int getCode() {
		return code;
		
	}
	
	public String getDesc() {
		return desc;
	}

	
	public static EstadoPagamento toEnum(Integer code) {
		if (code == null) {
			return null;
		}
		
		for (EstadoPagamento x: EstadoPagamento.values()) {
			if (code.equals(x.getCode())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("ID inválido");
	}

}
