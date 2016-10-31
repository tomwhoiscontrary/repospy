package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PotatoServiceTests {

    @Autowired
    private PotatoService potatoService;

    @SpyBean
    private PotatoRepository potatoRepository;

    @Test
    public void listsKindsOfAllPotatoes() throws Exception {
        doReturn(Arrays.asList(new Potato("Maris Piper"), new Potato("King Edward"))).when(potatoRepository).findAll();

        Set<String> potatoKinds = potatoService.listPotatoKinds();

        assertThat(potatoKinds, contains("King Edward", "Maris Piper"));
    }

}
