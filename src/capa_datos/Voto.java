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
    private String tipo;        // "Departamento" o "Extranjero"
    private String region;      // nombre del departamento o continente
    private String provincia;   // nombre de la provincia o país, si region es extranjero, o sea, continente, provincia asume el papel de pais de ese continente
    private int votosKeiko;
    private int votosSanchez;

    public Voto(String tipo, String region, String provincia, int votosKeiko, int votosSanchez) {
        this.tipo = tipo;
        this.region = region;
        this.provincia = provincia;
        this.votosKeiko = votosKeiko;
        this.votosSanchez = votosSanchez;
    }

    // Getters y setters
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }
    public String getProvincia() { return provincia; }
    public void setProvincia(String provincia) { this.provincia = provincia; }
    public int getVotosKeiko() { return votosKeiko; }
    public void setVotosKeiko(int votosKeiko) { this.votosKeiko = votosKeiko; }
    public int getVotosSanchez() { return votosSanchez; }
    public void setVotosSanchez(int votosSanchez) { this.votosSanchez = votosSanchez; }

    // Clave única: tipo|region|provincia
    public String getClave() {
        return tipo + "|" + region + "|" + provincia;
    }

    @Override
    public String toString() {
        return "Voto{" +
                "tipo='" + tipo + '\'' +
                ", region='" + region + '\'' +
                ", provincia='" + provincia + '\'' +
                ", votosKeiko=" + votosKeiko +
                ", votosSanchez=" + votosSanchez +
                '}';
    }
}