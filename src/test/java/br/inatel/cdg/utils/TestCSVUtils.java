package br.inatel.cdg.utils;

import br.inatel.cdg.model.Jogo;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestCSVUtils {

    private static List<Jogo> jogoList;

    @BeforeClass
    public static void initClass() throws URISyntaxException {
        Path caminho = Paths.get(ClassLoader.getSystemResource("vendas-games.csv").toURI());
        jogoList = CsvUtils.lerArquivoCsv(caminho);
    }

    @Test
    public void testNumberOfLines(){
        int numLines = jogoList.size();
        Assert.assertEquals(100,numLines);
    }
}