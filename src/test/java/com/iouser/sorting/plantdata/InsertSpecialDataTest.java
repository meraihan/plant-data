package com.iouser.sorting.plantdata;

import com.iouser.sorting.plantdata.model.General;
import com.iouser.sorting.plantdata.model.Special;
import com.iouser.sorting.plantdata.repository.SpecialRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class InsertSpecialDataTest {

    @Autowired
    SpecialRepository specialRepository;

    public static final String CSV_FILE_PATH = "./Plant Data - Special.csv";


    @Test
    @Ignore
    public void readWriteFromCsv() throws Exception {
        List<Special> specials = new ArrayList<>();
        FileInputStream fis = new FileInputStream(CSV_FILE_PATH);
        specials = csvToTutorials(fis);
        specials.stream().forEach(special -> {
            Special saveSpecial = new Special();
            saveSpecial.setPlants(special.getPlants());
            saveSpecial.setLevel1(special.getLevel1());
            saveSpecial.setLevel2(special.getLevel2());
            saveSpecial.setLevel3(special.getLevel3());
            saveSpecial.setLevel4(special.getLevel4());
            saveSpecial.setLevel5(special.getLevel5());
            saveSpecial.setLevel6(special.getLevel6());
            saveSpecial.setLevel7(special.getLevel7());
            saveSpecial.setLevel8(special.getLevel8());
            saveSpecial.setLevel9(special.getLevel9());
            saveSpecial.setLevel10(special.getLevel10());
            saveSpecial.setLevel11(special.getLevel11());
            saveSpecial.setLevel12(special.getLevel12());
            saveSpecial.setLevel13(special.getLevel13());
            saveSpecial.setLevel14(special.getLevel14());
            saveSpecial.setLevel15(special.getLevel15());
            saveSpecial.setLevel16(special.getLevel16());
            saveSpecial.setLevel17(special.getLevel17());
            saveSpecial.setLevel18(special.getLevel18());
            saveSpecial.setLevel19(special.getLevel19());
            saveSpecial.setLevel20(special.getLevel20());
            specialRepository.save(saveSpecial);
        });
        log.info(String.valueOf(specials));
    }


    public static List<Special> csvToTutorials(FileInputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Special> generals = new ArrayList<Special>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Special special = new Special();
                special.setPlants(new General(csvRecord.get("Plants")));
                special.setLevel1(csvRecord.get("Level 1"));
                special.setLevel2(csvRecord.get("Level 2"));
                special.setLevel3(csvRecord.get("Level 3"));
                special.setLevel4(csvRecord.get("Level 4"));
                special.setLevel5(csvRecord.get("Level 5"));
                special.setLevel6(csvRecord.get("Level 6"));
                special.setLevel7(csvRecord.get("Level 7"));
                special.setLevel8(csvRecord.get("Level 8"));
                special.setLevel9(csvRecord.get("Level 9"));
                special.setLevel10(csvRecord.get("Level 10"));
                special.setLevel11(csvRecord.get("Level 11"));
                special.setLevel12(csvRecord.get("Level 12"));
                special.setLevel13(csvRecord.get("Level 13"));
                special.setLevel14(csvRecord.get("Level 14"));
                special.setLevel15(csvRecord.get("Level 15"));
                special.setLevel16(csvRecord.get("Level 16"));
                special.setLevel17(csvRecord.get("Level 17"));
                special.setLevel18(csvRecord.get("Level 18"));
                special.setLevel19(csvRecord.get("Level 19"));
                special.setLevel20(csvRecord.get("Level 20"));
                generals.add(special);
            }
            return generals;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

}
