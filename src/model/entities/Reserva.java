package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reserva {

	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
	}

	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) {
		/*if (!checkOut.after(checkIn)) {
			throw new DomainException("A data de check-out deve ser posterior à data de check-in");
		}*/
		atualizaData(checkIn, checkOut);
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getChecOut() {
		return checkOut;
	}

	public long duracao() {
		long dif = checkOut.getTime() - checkIn.getTime();// Calculando diferença entre duas datas em mile segundos
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);// Converte os mile segundos para dias
	}
	
	public void atualizaData(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("As datas de reserva para atualização devem ser datas futuras");
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainException("A data de check-out deve ser posterior à data de check-in");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Quarto "
				+ numeroQuarto
				+ ", Check-In: "
				+ sdf.format(checkIn)
				+ ", Check-Out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duracao()
				+ " noites";
	}
}
