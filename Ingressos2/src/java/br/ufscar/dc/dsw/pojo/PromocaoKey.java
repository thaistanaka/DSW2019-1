/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.pojo;

import java.io.Serializable;

/**
 *
 * @author Windows
 */
public class PromocaoKey implements Serializable{
    private String endereco;
    private String dia; 
    private String hora;
    
    public PromocaoKey() {
 
	}
    
    public PromocaoKey(String endereco, String dia, String hora) {
		this.endereco = endereco;
		this.dia = dia;
                this.hora = hora;
	}
 
    public String getEndereco() {
		return endereco;
	}
 
    public String getDia() {
		return dia;
	}
    
    public String getHora() {
		return hora;
	}
    
    @Override
    public int hashCode() {
	final int prime = 31;
    int result = 1;
    result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
    result = prime * result + ((dia == null) ? 0 : dia.hashCode());
    result = prime * result
        + ((hora == null) ? 0 : hora.hashCode());
    return result;
	}
 
	@Override
	public boolean equals(Object obj) {
            if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    PromocaoKey other = (PromocaoKey) obj;
    if (endereco == null) {
      if (other.endereco != null)
        return false;
    } else if (!endereco.equals(other.endereco))
      return false;
    if (dia == null) {
      if (other.dia != null)
        return false;
    } else if (!dia.equals(other.dia))
      return false;
    if (hora == null) {
      if (other.hora != null)
        return false;
    } else if (!hora.equals(other.hora))
      return false;
    return true;
	}
 
}
