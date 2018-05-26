/*
 * Copyright IBM Corp. 2017
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package asr.proyectoFinal.dominio;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents a Visitor document stored in Cloudant.
 */

public class Palabra implements Comparable<Palabra> {
	private String _id;
	private String _rev;
	private String espanol = null;
	private String ingles = null;
	private String tono = null;
	private Double puntuacionTono=null;
	Date fecha=null;

	public Palabra() {
		this.espanol = "";
		this.ingles = "";
	}

	/**
	 * Gets the ID.
	 * 
	 * @return The ID.
	 */
	public String get_id() {
		return _id;
	}

	/**
	 * Sets the ID
	 * 
	 * @param _id
	 *            The ID to set.
	 */
	public void set_id(String _id) {
		this._id = _id;
	}

	/**
	 * Gets the revision of the document.
	 * 
	 * @return The revision of the document.
	 */
	public String get_rev() {
		return _rev;
	}

	/**
	 * Sets the revision.
	 * 
	 * @param _rev
	 *            The revision to set.
	 */
	public void set_rev(String _rev) {
		this._rev = _rev;
	}
	
	
	/**
	 * Gets the visitorName of the document.
	 * 
	 * @return The name of the document.
	 */
	public String getEspanol() {
		return espanol;
	}
	
	public String getIngles() {
		return ingles;
	}

	/**
	 * Sets the name
	 * 
	 * @param name
	 *            The visitorName to set.
	 */
	public void setEspanol(String espanol) {
		this.espanol = espanol;
	}
	
	public void setIngles(String ingles) {
		this.ingles = ingles;
	}

	public String getTono() {
		return tono;
	}

	public void setTono(String tono) {
		this.tono = tono;
	}

	public Double getPuntuacionTono() {
		return puntuacionTono;
	}

	public void setPuntuacionTono(Double puntuacionTono) {
		this.puntuacionTono = puntuacionTono;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getFechaFormateada()
	{
		return (new SimpleDateFormat("dd/MM/yy HH:mm")).format(fecha);
	}

	@Override
	public int compareTo(Palabra o) {
		// TODO Auto-generated method stub
		return o.getFecha().compareTo(fecha);
	}
	
	


}