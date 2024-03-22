package com.ptl.exercise.ig.magnitGlobal_angularUI;


public class TravelCompanyWeatherPlatform {

}

/* 
@RestController
@RequestMapping("/weather")   //fix1: dont forget this line
class WeatherController {

    
    //remember to import for all the annotations if not auo-imported

    //fill all below to the controller class
    @Autowired
    private WeatherRepository repo;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Weather addWeather(@RequestBody Weather weather) {
        return repo.save(weather);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Weather> getWeatherList() {
        List<Weather> list = repo.findAll();
        Collections.sort(list, (w1, w2) -> w1.getId().compareTo(w2.getId()));
        return list;
    } // import java.util.*;

    @GetMapping("/{id}")
    public ResponseEntity<Weather> getWeatherById(@PathVariable Integer id) {
        Optional<Weather> optionalWeather = repo.findById(id);
        if (optionalWeather.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(optionalWeather.get());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWeatherById(@PathVariable Integer id){
        Optional<Weather> optionalWeather = repo.findByID(id);
        if (optionalWeather.isEmpty()) {
            return ResponseEntity.notFound().build();
        }else{
            repo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }
}

*/
