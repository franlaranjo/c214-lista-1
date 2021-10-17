package br.inatel.cdg.utils;

import br.inatel.cdg.model.Jogo;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {

    public static List<Jogo> lerArquivoCsv(Path csvFilePath){

        List<Jogo> jogoList = new ArrayList<>();

        try {
            Reader reader = Files.newBufferedReader(csvFilePath);
            CsvToBean<Jogo> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Jogo.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            jogoList = csvToBean.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jogoList;
    }

}