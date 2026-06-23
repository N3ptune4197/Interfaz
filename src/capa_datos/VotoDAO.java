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
        votosMap.put(voto.getClave(), voto);
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

    public List<Voto> obtenerPorTipoYRegion(String tipo, String region) {
        List<Voto> resultado = new ArrayList<>();
        for (Voto v : votosMap.values()) {
            if (v.getTipo().equals(tipo) && v.getRegion().equals(region)) {
                resultado.add(v);
            }
        }
        return resultado;
    }

    // Filtro completo: tipo, región, provincia (cualquiera puede ser null para no filtrar)
    public List<Voto> obtenerPorFiltros(String tipo, String region, String provincia) {
        List<Voto> resultado = new ArrayList<>();
        for (Voto v : votosMap.values()) {
            boolean coincide = true;
            if (tipo != null && !tipo.isEmpty() && !tipo.equals(v.getTipo())) coincide = false;
            if (region != null && !region.isEmpty() && !region.equals(v.getRegion())) coincide = false;
            if (provincia != null && !provincia.isEmpty() && !provincia.equals(v.getProvincia())) coincide = false;
            if (coincide) resultado.add(v);
        }
        return resultado;
    }

    public Voto obtenerPorClave(String tipo, String region, String provincia) {
        String clave = tipo + "|" + region + "|" + provincia;
        return votosMap.get(clave);
    }

    public void limpiar() {
        votosMap.clear();
    }
}