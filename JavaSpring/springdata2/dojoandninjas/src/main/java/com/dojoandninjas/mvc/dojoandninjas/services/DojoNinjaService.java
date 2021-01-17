package com.dojoandninjas.mvc.dojoandninjas.services;

import com.dojoandninjas.mvc.dojoandninjas.models.Dojo;
import com.dojoandninjas.mvc.dojoandninjas.models.Ninja;
import com.dojoandninjas.mvc.dojoandninjas.repositories.DojoRepository;
import com.dojoandninjas.mvc.dojoandninjas.repositories.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DojoNinjaService {
    private final DojoRepository dojoRepository;
    private final NinjaRepository ninjaRepository;

    public DojoNinjaService(DojoRepository dojoRepository, NinjaRepository ninjaRepository) {
        this.dojoRepository = dojoRepository;
        this.ninjaRepository = ninjaRepository;
    }
    public List<Dojo> allDojos(){
        return dojoRepository.findAll();
    }
    public List<Ninja> allNinjas(){
        return ninjaRepository.findAll();
    }
    public Dojo createDojo(Dojo dojo){
        return dojoRepository.save(dojo);
    }
    public Ninja createNinja(Ninja ninja){
        return ninjaRepository.save(ninja);
    }
    public Dojo findDojo(Long id){
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()){
            return optionalDojo.get();
        }
        else
            return null;
    }
    public Ninja findNinja(Long id){
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if(optionalNinja.isPresent()){
            return optionalNinja.get();
        }
        else
            return null;
    }
    public Ninja createNinjaForDojo(Ninja ninja,Dojo dojo){
        ninja.setDojo(dojo);
        return ninjaRepository.save(ninja);
    }

}
