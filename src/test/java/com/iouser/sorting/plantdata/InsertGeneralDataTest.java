package com.iouser.sorting.plantdata;

import com.iouser.sorting.plantdata.model.General;
import com.iouser.sorting.plantdata.repository.GeneralRepository;
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

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class InsertGeneralDataTest {
    @Autowired
    GeneralRepository generalRepository;

    public static final String CSV_FILE_PATH = "./Plant Data - General.csv";

    @Test
    @Ignore
    public void readWriteFromCsv() throws Exception {
        List<General> generals = new ArrayList<>();
        FileInputStream fis = new FileInputStream(CSV_FILE_PATH);
        generals = csvToTutorials(fis);
        generals.stream().forEach(general -> {
            General saveGeneral = new General();
            saveGeneral.setPlants(general.getPlants());
            saveGeneral.setFamily(general.getFamily());
            saveGeneral.setUsage(general.getUsage());
            saveGeneral.setActivationRange(general.getActivationRange());
            saveGeneral.setAttackDirection(general.getAttackDirection());
            saveGeneral.setShotStyle(general.getShotStyle());
            saveGeneral.setAcquisition(general.getAcquisition());
            generalRepository.save(general);
        });
        log.info(String.valueOf(generals));
    }


    public static List<General> csvToTutorials(FileInputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<General> generals = new ArrayList<General>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                General general = new General();
                general.setPlants(csvRecord.get("Plants"));
                general.setFamily(csvRecord.get("Family"));
                general.setUsage(csvRecord.get("Usage"));
                general.setActivationRange(csvRecord.get("Activation Range"));
                general.setAttackDirection(csvRecord.get("Attack Direction"));
                general.setShotStyle(csvRecord.get("Shot Style"));
                general.setAcquisition(csvRecord.get("Acquisition"));
                generals.add(general);
            }
            return generals;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}

