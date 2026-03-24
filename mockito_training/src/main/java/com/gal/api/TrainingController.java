package com.gal.api;
import com.gal.dto.TrainingDTO;
import com.gal.model.Training;
import com.gal.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/training")
public class TrainingController {
    private TrainingService trainingService;

    @Autowired
    public TrainingController(TrainingService trainingService){
        super();
        this.trainingService = trainingService;
    }

   /* @GetMapping("/{trainingid}")
    Training findById(@PathVariable int trainingid){
        Training training = trainingService.findById(trainingid);
        return training;
    }*/
    @GetMapping("/{id}")
    public TrainingDTO getTraining(@PathVariable int id) {
        Training t = trainingService.findById(id);

        return new TrainingDTO(
                t.getTrainingId(),
                t.getTopic()
        );
    }




}
