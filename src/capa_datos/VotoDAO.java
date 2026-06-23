/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capa_datos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author User
 */



public class VotoDAO {
    private Map<String, Voto> votosMap = new HashMap<>();

    public void guardarVoto(Voto voto) {
        String clave = voto.getClave();

        if (votosMap.containsKey(clave)) {
            Voto existente = votosMap.get(clave);

            existente.setVotosKeiko(
                existente.getVotosKeiko() + voto.getVotosKeiko()
            );

            existente.setVotosSanchez(
                existente.getVotosSanchez() + voto.getVotosSanchez()
            );

        } else {
            votosMap.put(clave, voto);
        }
    }

    public List<Voto> obtenerTodos() {
        return new ArrayList<>(votosMap.values());
    }

    public List<Voto> obtenerPorTipo(String tipo) {
        List<Voto> resultado = new ArrayList<>();
        for (Voto v : votosMap.values()) {
            if (v.getTipo().equals(tipo)) {
                resultado.add(v);
            }
        }
        return resultado;
    }

    public Voto obtenerPorUbicacion(String ubicacion) {
        for (Voto v : votosMap.values()) {
            if (v.getUbicacion().equalsIgnoreCase(ubicacion)) {
                return v;
            }
        }
        return null;
    }

    public void limpiar() {
        votosMap.clear();
    }
}