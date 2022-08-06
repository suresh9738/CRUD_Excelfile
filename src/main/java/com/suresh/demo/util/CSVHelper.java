package com.suresh.demo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.suresh.demo.entity.Exercise;

public class CSVHelper {

	public static String TYPE = "text/csv";
	public static boolean hasCSVFormat(MultipartFile file) {
		if (!TYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}

	public static List<Exercise> csvToExercise(InputStream is) {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			CSVParser csvParser = new CSVParser(fileReader,CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
			List<Exercise> exerciseList = new ArrayList<Exercise>();
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			for (CSVRecord csvRecord : csvRecords) {
				Exercise exercise = new Exercise(
						csvRecord.get("source"),
						csvRecord.get("codeListCode"),
						csvRecord.get("code"),
						csvRecord.get("displayValue"),
						csvRecord.get("longDescription"),
						csvRecord.get("fromDate"),
						csvRecord.get("toDate"),
						csvRecord.get("sortingPriority")
						);
				exerciseList.add(exercise);
			}
			return exerciseList;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}

}
