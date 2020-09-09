package model.exceptions;

public class DomainException extends RuntimeException {
	private static final long serialVersionUID = 1L;//declarando versão de uma classe serialaisbol

	public DomainException(String msg) {
		super(msg);//passando a mensagem para o construtor da superclasse, permite instanciar esta exceção personalizada
	}
	
}
