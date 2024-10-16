package com.trave.travel;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class DistanciaEntreCidades {


    private String partida;
    private String destino;
    private int kml;

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getKml() {
        return kml;
    }

    public void setKml(int kml) {
        this.kml = kml;
    }

    public DistanciaEntreCidades() {
        this.partida = partida;
        this.destino = destino;
        this.kml = kml;
    }

    // Mapa para armazenar distâncias entre cidades
    private final Map<String, Map<String, Integer>> distancias = new HashMap<>();

    public void adicionarDistancia(String cidade1, String cidade2, int distancia) {
        // Adiciona a distância no mapa
        distancias.putIfAbsent(cidade1, new HashMap<>());
        distancias.putIfAbsent(cidade2, new HashMap<>());
        distancias.get(cidade1).put(cidade2, distancia);
        distancias.get(cidade2).put(cidade1, distancia); // Distância reversa
    }

    public Integer obterDistancia(String cidade1, String cidade2) {
        if (distancias.containsKey(cidade1)) {
            return distancias.get(cidade1).get(cidade2);
        }
        return null; // Distância não encontrada
    }

    // Mapa das cidades e suas distâncias
    private static final DistanciaEntreCidades sistema = new DistanciaEntreCidades();

    static {
         // Adicionando distâncias entre as 12 cidades
        sistema.adicionarDistancia("São Paulo", "Rio de Janeiro", 446);
        sistema.adicionarDistancia("São Paulo", "Belo Horizonte", 585);
        sistema.adicionarDistancia("São Paulo", "Brasilia", 1005);
        sistema.adicionarDistancia("São Paulo", "Fortaleza", 2881);
        sistema.adicionarDistancia("São Paulo", "Belém", 2867);
        sistema.adicionarDistancia("São Paulo", "Manaus", 3880);
        sistema.adicionarDistancia("São Paulo", "Cuiabá", 1531);
        sistema.adicionarDistancia("São Paulo", "Aracaju", 2188);
        sistema.adicionarDistancia("São Paulo", "Palmas", 1721);
        sistema.adicionarDistancia("São Paulo", "Pirenópolis", 1022);
        sistema.adicionarDistancia("São Paulo", "Caldas Novas", 757);

        sistema.adicionarDistancia("Rio de Janeiro", "Belo Horizonte", 441);
        sistema.adicionarDistancia("Rio de Janeiro", "Brasilia", 1166);
        sistema.adicionarDistancia("Rio de Janeiro", "Fortaleza", 2581);
        sistema.adicionarDistancia("Rio de Janeiro", "Belém", 3178);
        sistema.adicionarDistancia("Rio de Janeiro", "Manaus", 4228);
        sistema.adicionarDistancia("Rio de Janeiro", "Cuiabá", 1932);
        sistema.adicionarDistancia("Rio de Janeiro", "Aracaju", 1826);
        sistema.adicionarDistancia("Rio de Janeiro", "Palmas", 1973);
        sistema.adicionarDistancia("Rio de Janeiro", "Pirenópolis", 1267);
        sistema.adicionarDistancia("Rio de Janeiro", "Caldas Novas", 1101);


        sistema.adicionarDistancia("Belo Horizonte", "Brasilia", 733);
        sistema.adicionarDistancia("Belo Horizonte", "Fortaleza", 2361);
        sistema.adicionarDistancia("Belo Horizonte", "Belém", 2693);
        sistema.adicionarDistancia("Belo Horizonte", "Manaus", 3919);
        sistema.adicionarDistancia("Belo Horizonte", "Cuiabá", 1569);
        sistema.adicionarDistancia("Belo Horizonte", "Aracaju", 1606);
        sistema.adicionarDistancia("Belo Horizonte", "Palmas", 1540);
        sistema.adicionarDistancia("Belo Horizonte", "Pirenópolis", 835);
        sistema.adicionarDistancia("Belo Horizonte", "Caldas Novas", 695);


        sistema.adicionarDistancia("Brasilia", "Fortaleza", 2277);
        sistema.adicionarDistancia("Brasilia", "Belém", 2357);
        sistema.adicionarDistancia("Brasilia", "Manaus", 3931);
        sistema.adicionarDistancia("Brasilia", "Cuiabá", 848);
        sistema.adicionarDistancia("Brasilia", "Aracaju", 1596);
        sistema.adicionarDistancia("Brasilia", "Palmas", 878);
        sistema.adicionarDistancia("Brasilia", "Pirenópolis", 116);
        sistema.adicionarDistancia("Brasilia", "Caldas Novas", 143);


        sistema.adicionarDistancia("Fortaleza", "Belém", 1510);
        sistema.adicionarDistancia("Fortaleza", "Manaus", 4208);
        sistema.adicionarDistancia("Fortaleza", "Cuiabá", 3167);
        sistema.adicionarDistancia("Fortaleza", "Aracaju", 1077);
        sistema.adicionarDistancia("Fortaleza", "Palmas", 1729);
        sistema.adicionarDistancia("Fortaleza", "Pirenópolis", 2258);
        sistema.adicionarDistancia("Fortaleza", "Caldas Novas", 2416);


        sistema.adicionarDistancia("Belém", "Manaus", 1470);
        sistema.adicionarDistancia("Belém", "Cuiabá", 2968);
        sistema.adicionarDistancia("Belém", "Aracaju", 3864);
        sistema.adicionarDistancia("Belém", "Palmas", 2976);
        sistema.adicionarDistancia("Belém", "Pirenópolis", 3450);
        sistema.adicionarDistancia("Belém", "Caldas Novas", 3673);


        sistema.adicionarDistancia("Manaus", "Cuiabá", 3046);
        sistema.adicionarDistancia("Manaus", "Aracaju", 4135);
        sistema.adicionarDistancia("Manaus", "Palmas", 3312);
        sistema.adicionarDistancia("Manaus", "Pirenópolis", 4071);
        sistema.adicionarDistancia("Manaus", "Caldas Novas", 4294);


        sistema.adicionarDistancia("Cuiabá", "Aracaju", 2502);
        sistema.adicionarDistancia("Cuiabá", "Palmas", 659);
        sistema.adicionarDistancia("Cuiabá", "Pirenópolis", 707);
        sistema.adicionarDistancia("Cuiabá", "Caldas Novas", 756);


        sistema.adicionarDistancia("Aracaju", "Palmas", 1671);
        sistema.adicionarDistancia("Aracaju", "Pirenópolis", 1779);
        sistema.adicionarDistancia("Aracaju", "Caldas Novas", 1937);


        sistema.adicionarDistancia("Palmas", "Pirenópolis", 913);
        sistema.adicionarDistancia("Palmas", "Caldas Novas", 991);


        sistema.adicionarDistancia("Pirenópolis", "Caldas Novas", 280);

    }

    public int obterDistancia() {
        Integer distancia = sistema.obterDistancia(this.getPartida(), this.getDestino());
        if (distancia == null) {
            throw new IllegalArgumentException("Distância não encontrada entre as cidades.");
        }
        return distancia;
    }

    // Calculo de litros gastos
    public double LitrosGastos() {
        double distancia = obterDistancia();
        return distancia / this.getKml();
    }

    public List<String> obterCidades() {
        return new ArrayList<>(distancias.keySet());
    }
    public static DistanciaEntreCidades getInstance() {
        return sistema;
    }
}
