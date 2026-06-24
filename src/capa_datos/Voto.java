/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capa_datos;

/**
 *
 * @author User
 */
public class Voto {
    private String tipo;        // Región o Extranjero
    private String ubicacion;   // Nombre del departamento o país
    private int votosKeiko;
    private int votosSanchez;

    public Voto(String tipo, String ubicacion, int votosKeiko, int votosSanchez) {
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.votosKeiko = votosKeiko;
        this.votosSanchez = votosSanchez;
    }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    public int getVotosKeiko() { return votosKeiko; }
    public void setVotosKeiko(int votosKeiko) { this.votosKeiko = votosKeiko; }
    public int getVotosSanchez() { return votosSanchez; }
    public void setVotosSanchez(int votosSanchez) { this.votosSanchez = votosSanchez; }

    public String getClave() {
        return tipo + "|" + ubicacion;
    }

    @Override
    public String toString() {
        return "Voto{" +
                "tipo='" + tipo + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", votosKeiko=" + votosKeiko +
                ", votosSanchez=" + votosSanchez +
                '}';
    }
}