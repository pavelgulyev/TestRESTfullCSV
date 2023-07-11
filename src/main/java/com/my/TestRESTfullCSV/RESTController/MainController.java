package com.my.TestRESTfullCSV.RESTController;

import com.my.TestRESTfullCSV.Tutorial;
import com.my.TestRESTfullCSV.TutorialService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    TutorialService service;
    @GetMapping("/tutorials")
    public ResponseEntity<List<Tutorial>> readAll() {
        return mappingResponseListBuilding(service.readAll());
    }
    @GetMapping("/export")
    public void exportCSV(HttpServletResponse response)
            throws Exception {
        service.exsportCSV(response);
    }
    private ResponseEntity<List<Tutorial>> mappingResponseListBuilding(List<Tutorial> buildingList) {
        if (buildingList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(buildingList, HttpStatus.OK);
    }
    private ResponseEntity<Tutorial> mappingResponseBuilding(Tutorial building) {
        if (building ==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(building, HttpStatus.OK);
    }

    @GetMapping("/tutorial/{id}")
    public ResponseEntity<Tutorial> fingById(@PathVariable Long id) {
        Tutorial findFaculty = service.getBuildingById(id);
        return mappingResponseBuilding(findFaculty);
    }
    @GetMapping("/tutorial")
    public ResponseEntity<Tutorial> readGroupUniversityDto() {
        Tutorial dto = new Tutorial();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    @PutMapping("/tutorial/{id}")
    public ResponseEntity<Tutorial> update(@PathVariable Long id,
                                           @RequestBody Tutorial faculty) {
        return mappingResponseBuilding(service.update(faculty));
    }

    @DeleteMapping("/tutorial/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        service.delete(id);
        return HttpStatus.OK;
    }
    @PostMapping("/tutorial")
    public ResponseEntity<Tutorial> create(@RequestBody Tutorial dto) {
        return mappingResponseBuilding(service.createTutorial(dto));
    }
}
