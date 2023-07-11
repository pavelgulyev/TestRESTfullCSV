package com.my.TestRESTfullCSV;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TutorialService {

    @Autowired
    TutorialRepository repository;

    public void exsportCSV(HttpServletResponse response) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        // set file name and content type
        String filename = "Tutorial.csv";
        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");

        // create a csv writer
        StatefulBeanToCsv<Tutorial> writer =
                new StatefulBeanToCsvBuilder<Tutorial>
                        (response.getWriter())
                        .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                        .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                        .withOrderedResults(false).build();
        // write all employees to csv file
        writer.write(this.readAll());
    }
    public Tutorial createTutorial(Tutorial tutorial) {
        return repository.save(tutorial);
    }
    public List<Tutorial> readAll() {
        return repository.findAll();
    }
    public Tutorial update(Tutorial tutorial) {
        return repository.save(tutorial);
    }
    public Tutorial getBuildingById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

