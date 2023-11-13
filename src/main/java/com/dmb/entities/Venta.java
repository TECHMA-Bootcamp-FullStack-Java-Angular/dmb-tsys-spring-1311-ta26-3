package com.dmb.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "ventas")
public class Venta {




	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cajero_codigo")
    private Cajero cajero;

    @ManyToOne
    @JoinColumn(name = "producto_codigo")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "maquina_codigo")
    private Maquina_Registradora maquinaRegistradora;
    
    public Venta(Long id, Cajero cajero, Producto producto, Maquina_Registradora maquinaRegistradora) {

		this.id = id;
		this.cajero = cajero;
		this.producto = producto;
		this.maquinaRegistradora = maquinaRegistradora;
	}
    
    public Venta() {
	}
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cajero getCajero() {
		return cajero;
	}

	public void setCajero(Cajero cajero) {
		this.cajero = cajero;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Maquina_Registradora getMaquinaRegistradora() {
		return maquinaRegistradora;
	}

	public void setMaquinaRegistradora(Maquina_Registradora maquinaRegistradora) {
		this.maquinaRegistradora = maquinaRegistradora;
	}
    
}