package com.example.FileCompare.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class CompareService {

	
	private static final String DELIMITER = "|";

    public void  compare() {
        String currentFilePath = "C:\\JavaPrac\\inputFileFile\\CDF_GBR_CCADB_GI.txt";
        String previousFilePath = "C:\\JavaPrac\\ArchiveFile\\CDF_GBR_CCADB_GI.txt";

        try {
            boolean areFilesEqual = compareTextFiles(currentFilePath, previousFilePath);
            if (areFilesEqual) {
                System.out.println("Text files are equal.");
            } else {
                System.out.println("Text files are not equal.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean compareTextFiles(String currentFilePath, String previousFilePath) throws IOException {
        try (BufferedReader currentReader = new BufferedReader(new FileReader(currentFilePath));
             BufferedReader previousReader = new BufferedReader(new FileReader(previousFilePath))) {

            String currentLine, previousLine;

            while ((currentLine = currentReader.readLine()) != null && (previousLine = previousReader.readLine()) != null) {
                if (!compareRecords(currentLine, previousLine)) {
                    return false; // If any record is different, text files are not equal
                }
            }

            // If reached here, text files are equal
            return true;
        }
    }

    private static boolean compareRecords(String currentRecord, String previousRecord) {
        String[] currentFields = currentRecord.split(DELIMITER);
        String[] previousFields = previousRecord.split(DELIMITER);

        // Compare fields based on specified conditions
        return currentFields[0].equals(previousFields[0])  // UID
                && currentFields[1].equals(previousFields[1])  // Surname
                && currentFields[2].equals(previousFields[2])  // Forenames
                && currentFields[9].equals(previousFields[9]); // Postcode
    }
	
}
