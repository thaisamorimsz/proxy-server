package com.proxyserver.proxyserver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class ProxyServerSimulationTests {

    private ProxyServerSimulation proxyServerSimulation;

    @Before
    public void setup() {
        proxyServerSimulation = new ProxyServerSimulation();
    }

    @Test
    public void primaryTest() {
        String cacheDocumentName = "teste.txt";
        HashMap<String, Long> results = proxyServerSimulation.dictionary(cacheDocumentName);

        assertEquals(results.get("tamanho final do cache"), 216724L);
        assertEquals(results.get("quantidade de bytes economizados em requisições"), 506714L);

    }

    @Test
    public void Simulation() {
        String cacheDocumentName = "wikipedia.txt";
        HashMap<String, Long> results = proxyServerSimulation.dictionary(cacheDocumentName);

        System.out.println("tamanho final do cache: " + results.get("tamanho final do cache"));
        System.out.println("quantidade de bytes economizados em requisições: "
                + results.get("quantidade de bytes economizados em requisições"));

    }

}
