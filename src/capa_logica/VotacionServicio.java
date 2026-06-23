/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capa_logica;


import capa_datos.Voto;
import capa_datos.VotoDAO;
import java.util.List;


/**
 *
 * @author User
 */


public class VotacionServicio {
    private VotoDAO repositorio;

    public VotacionServicio() {
        this.repositorio = new VotoDAO();
    }

    public void registrarVotos(String tipo, String ubicacion, int votosKeiko, int votosSanchez) {
        Voto voto = new Voto(tipo, ubicacion, votosKeiko, votosSanchez);
        repositorio.guardarVoto(voto);
    }

    public List<Voto> obtenerTodos() {
        return repositorio.obtenerTodos();
    }

    public List<Voto> obtenerPorTipo(String tipo) {
        return repositorio.obtenerPorTipo(tipo);
    }

    public Voto obtenerPorUbicacion(String ubicacion) {
        return repositorio.obtenerPorUbicacion(ubicacion);
    }

    public ResultadosTotales obtenerTotales() {
        List<Voto> todos = repositorio.obtenerTodos();
        int totalKeiko = 0, totalSanchez = 0;
        for (Voto v : todos) {
            totalKeiko += v.getVotosKeiko();
            totalSanchez += v.getVotosSanchez();
        }
        return new ResultadosTotales(totalKeiko, totalSanchez);
    }

    // Agregar en VotacionServicio.java
    public ResultadosTotales obtenerTotalesPorUbicacion(String ubicacion) {
        List<Voto> lista = repositorio.obtenerTodos();
        int totalKeiko = 0, totalSanchez = 0;
        for (Voto v : lista) {
            if (v.getUbicacion().equals(ubicacion)) {
                totalKeiko += v.getVotosKeiko();
                totalSanchez += v.getVotosSanchez();
            }
        }
        return new ResultadosTotales(totalKeiko, totalSanchez);
    }

    public ResultadosTotales obtenerTotalesPorTipo(String tipo) {
        List<Voto> lista = repositorio.obtenerPorTipo(tipo);
        int totalKeiko = 0, totalSanchez = 0;
        for (Voto v : lista) {
            totalKeiko += v.getVotosKeiko();
            totalSanchez += v.getVotosSanchez();
        }
        return new ResultadosTotales(totalKeiko, totalSanchez);
    }

    public void limpiarDatos() {
        repositorio.limpiar();
    }

    public static class ResultadosTotales {
        private int totalKeiko;
        private int totalSanchez;

        public ResultadosTotales(int totalKeiko, int totalSanchez) {
            this.totalKeiko = totalKeiko;
            this.totalSanchez = totalSanchez;
        }

        public int getTotalKeiko() { return totalKeiko; }
        public int getTotalSanchez() { return totalSanchez; }
        public int getTotalVotos() { return totalKeiko + totalSanchez; }

        public double getPorcentajeKeiko() {
            int total = getTotalVotos();
            return total == 0 ? 0 : (totalKeiko * 100.0) / total;
        }

        public double getPorcentajeSanchez() {
            int total = getTotalVotos();
            return total == 0 ? 0 : (totalSanchez * 100.0) / total;
        }
    }
}