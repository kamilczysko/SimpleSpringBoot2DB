package com.kamil.Simple.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    @Autowired
    OwnerRepository ownerRepo;

    public Owner addOwner(Owner o) {
        Owner save = ownerRepo.save(o);
        return save;
    }

    public List<Owner> getOwners() {
        return ownerRepo.findAll();
    }

    public List<Owner> getOwner(String name){
        return ownerRepo.findByName(name);
    }

    public void deleteOwner(Owner o){
        ownerRepo.delete(o);
    }


}
