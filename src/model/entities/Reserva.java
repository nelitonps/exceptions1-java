package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private Integer numeroReserva;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
	}

	public Reserva(Integer numeroReserva, Date checkIn, Date checkOut) {
		this.numeroReserva = numeroReserva;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroReserva() {
		return numeroReserva;
	}

	public void setNumeroReserva(Integer numeroReserva) {
		this.numeroReserva = numeroReserva;
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
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Reserva "
				+ numeroReserva
				+ ", Check-In: "
				+ sdf.format(checkIn)
				+ ", Check-Out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duracao()
				+ " noites";
	}
}
