package ar.edu.unju.fi.ejercicio03.constantes;

public enum Provincia {
	JUJUY(672260, 53219), // Cantidad de habitantes y superficie en km^2
	SALTA(1333365, 155488), TUCUMAN(1687305, 22524), CATAMARCA(367820, 102602), LA_RIOJA(331847, 89680),
	SANTIAGO_DEL_ESTERO(988245, 136351);

	private int cantidadPoblacion;
	private int superficie;

	private Provincia(int cantidadPoblacion, int superficie) {
		this.cantidadPoblacion = cantidadPoblacion;
		this.superficie = superficie;
	}

	public int getCantidadPoblacion() {
		return cantidadPoblacion;
	}

	public void setCantidadPoblacion(int cantidadPoblacion) {
		this.cantidadPoblacion = cantidadPoblacion;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public double calcularDensidadPoblacional() {
		return (double) cantidadPoblacion / superficie;
	}
}