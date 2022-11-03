package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecoveryRoomService {

    public RecoveryRoomRepository repo;

    @Autowired
    public RecoveryRoomService(RecoveryRoomRepository repo) {
        this.repo = repo;
    }

    public List<RecoveryRoom> getAll(){
        return repo.findAll();
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return null;
    }

    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return repo.getRecoveryRoomType(typeName);
    }

    public RecoveryRoom save(RecoveryRoom p) throws DuplicatedRoomNameException {
        RecoveryRoom result = null;
        try {
            result = repo.save(p);
        } catch (Exception e) {
            throw new DuplicatedRoomNameException();
        }
        return result;
    }

    
}
