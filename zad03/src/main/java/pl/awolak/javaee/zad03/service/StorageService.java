package pl.awolak.javaee.zad03.service;

import java.util.ArrayList;
import java.util.List;

import pl.awolak.javaee.zad03.domain.Bed;


    private List<Bed> db = new ArrayList<Bed>();

    public void add(Bed bed) {
        Bed newBed = new Bed(bed.getName(), bed.getProductionDate(), bed.getWidth(), bed.isSoftStatus());
        db.add(newBed);
    }

    public List<Bed> getAllBeds() {
        return db;
    }

}
