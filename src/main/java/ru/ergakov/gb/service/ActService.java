package ru.ergakov.gb.service;

import org.springframework.stereotype.Service;
import ru.ergakov.gb.model.Act;
import ru.ergakov.gb.repositories.ActRepository;

import java.util.List;

@Service
public class ActService {
    private final ActRepository actRepository;

    public ActService(ActRepository actRepository) {
        this.actRepository = actRepository;
    }


    public List<Act> findAll(){
        return actRepository.findAll();
    }

    public Act saveAct(Act act){
        return actRepository.save(act);
    }

    public void deleteById(int id){
        actRepository.deleteById(id);
    }

    public Act getOneActByID(int id)  {
       return actRepository.getOne(id);
    }

    public Act updateAct(Act act){
        return actRepository.updateAct(act);
    }
}
