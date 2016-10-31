package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PotatoServiceTests {

    @Autowired
    private PotatoService potatoService;

    @Autowired
    private PotatoRepository potatoRepository;

    @Test
    public void listsKindsOfAllPotatoes() throws Exception {
        potatoRepository.save(new Potato("Maris Piper"));
        potatoRepository.save(new Potato("King Edward"));

        Set<String> potatoKinds = potatoService.listPotatoKinds();

        assertThat(potatoKinds, contains("King Edward", "Maris Piper"));
    }

}
