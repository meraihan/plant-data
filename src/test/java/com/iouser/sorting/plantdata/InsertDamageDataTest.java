package com.iouser.sorting.plantdata;

import com.iouser.sorting.plantdata.model.Damage;
import com.iouser.sorting.plantdata.model.Plant;
import com.iouser.sorting.plantdata.repository.DamageRepository;
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
public class InsertDamageDataTest {

    @Autowired
    DamageRepository damageRepository;

    public static final String CSV_FILE_PATH = "./Plant Data - Damage.csv";

    @Test
    @Ignore
    public void readWriteFromCsv() throws Exception {
        List<Damage> specials = new ArrayList<>();
        FileInputStream fis = new FileInputStream(CSV_FILE_PATH);
        specials = csvToTutorials(fis);
        specials.stream().forEach(special -> {
            Damage saveDamage = new Damage();
//            saveDamage.setPlants(special.getPlants());
            saveDamage.setLevel1(special.getLevel1());
            saveDamage.setLevel2(special.getLevel2());
            saveDamage.setLevel3(special.getLevel3());
            saveDamage.setLevel4(special.getLevel4());
            saveDamage.setLevel5(special.getLevel5());
            saveDamage.setLevel6(special.getLevel6());
            saveDamage.setLevel7(special.getLevel7());
            saveDamage.setLevel8(special.getLevel8());
            saveDamage.setLevel9(special.getLevel9());
            saveDamage.setLevel10(special.getLevel10());
            saveDamage.setLevel11(special.getLevel11());
            saveDamage.setLevel12(special.getLevel12());
            saveDamage.setLevel13(special.getLevel13());
            saveDamage.setLevel14(special.getLevel14());
            saveDamage.setLevel15(special.getLevel15());
            saveDamage.setLevel16(special.getLevel16());
            saveDamage.setLevel17(special.getLevel17());
            saveDamage.setLevel18(special.getLevel18());
            saveDamage.setLevel19(special.getLevel19());
            saveDamage.setLevel20(special.getLevel20());
            damageRepository.save(saveDamage);
        });
        log.info(String.valueOf(specials));
    }


    public static List<Damage> csvToTutorials(FileInputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Damage> damages = new ArrayList<Damage>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Damage damage = new Damage();
//                damage.setPlants(new Plant(csvRecord.get("Plants")));
                damage.setLevel1(csvRecord.get("Level 1"));
                damage.setLevel2(csvRecord.get("Level 2"));
                damage.setLevel3(csvRecord.get("Level 3"));
                damage.setLevel4(csvRecord.get("Level 4"));
                damage.setLevel5(csvRecord.get("Level 5"));
                damage.setLevel6(csvRecord.get("Level 6"));
                damage.setLevel7(csvRecord.get("Level 7"));
                damage.setLevel8(csvRecord.get("Level 8"));
                damage.setLevel9(csvRecord.get("Level 9"));
                damage.setLevel10(csvRecord.get("Level 10"));
                damage.setLevel11(csvRecord.get("Level 11"));
                damage.setLevel12(csvRecord.get("Level 12"));
                damage.setLevel13(csvRecord.get("Level 13"));
                damage.setLevel14(csvRecord.get("Level 14"));
                damage.setLevel15(csvRecord.get("Level 15"));
                damage.setLevel16(csvRecord.get("Level 16"));
                damage.setLevel17(csvRecord.get("Level 17"));
                damage.setLevel18(csvRecord.get("Level 18"));
                damage.setLevel19(csvRecord.get("Level 19"));
                damage.setLevel20(csvRecord.get("Level 20"));
                damages.add(damage);
            }
            return damages;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
