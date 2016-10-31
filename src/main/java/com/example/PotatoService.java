package com.example;

import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.TreeSet;

@Service
public class PotatoService {

    private final PotatoRepository repository;

    public PotatoService(PotatoRepository repository) {
        this.repository = repository;
    }

    public Set<String> listPotatoKinds() {
        Set<String> kinds = new TreeSet<>();
        repository.findAll().forEach(spud -> kinds.add(spud.getKind()));
        return kinds;
    }

}
