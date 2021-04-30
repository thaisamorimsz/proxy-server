package com.proxyserver.proxyserver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.proxyserver.proxyserver.model.Resource;

public class ProxyServerSimulation {

	public HashMap<String, Long> dictionary(String cacheDocumentName) {

		HashMap<String, Long> results = new HashMap<String, Long>();
		long tam_cache = 0;
		long qtdbytes = 0;

		HashMap<String, Resource> dictionary = new HashMap<String, Resource>();

		List<String> documentLines;
		try {
			documentLines = documentLines(cacheDocumentName);

			for (String line : documentLines) {
				List<String> listLine = Arrays.asList(line.split(" "));
				String key = listLine.get(1);
				int time = Integer.parseInt(listLine.get(0));
				int bytes = Integer.parseInt(listLine.get(2));
				if (dictionary.containsKey(key)) {
					Resource resource = dictionary.get(key);
					resource.setTime(time);
					dictionary.replace(key, resource);
					qtdbytes = qtdbytes + bytes;
				} else {
					Resource resource = new Resource();
					resource.setBytes(bytes);
					resource.setTime(time);
					dictionary.put(key, resource);
					tam_cache = tam_cache + bytes;
				}

			}

			results.put("tamanho final do cache", tam_cache);
			results.put("quantidade de bytes economizados em requisições", qtdbytes);

			System.out.println(dictionary);

			return results;
		} catch (IOException e) {
			System.out.println("Não foi possível encontrar ou ler o arquivo");
			e.printStackTrace();
		}

		return null;
	}

	protected List<String> documentLines(String cacheDocumentName) throws IOException {

		Path path = Paths.get(cacheDocumentName);

		List<String> ArqLines = Files.readAllLines(path);

		return ArqLines;

	}

}
