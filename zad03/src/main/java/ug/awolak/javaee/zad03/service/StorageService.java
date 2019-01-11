package ug.awolak.javaee.zad03.service;

import java.util.ArrayList;
import java.util.List;

import ug.awolak.javaee.zad03.domain.Bed;

public class StorageService {

    private int id = 0;
    private List<Bed> db = new ArrayList<Bed>();
    private List<Bed> cart = new ArrayList<Bed>();

    public void add(Bed bed) {
        Bed newBed = new Bed(bed.getId(), bed.getProducer(), bed.getProductionDate(), bed.getWidth(), bed.getPrice(), bed.getQuantity(), bed.getIsSoft());
        db.add(newBed);
    }

    public int getId() {
        id++;

        return this.id;
    }

    public List<Bed> getAllBeds() {
        return db;
    }

    public void addToCart(Bed bed) {
        cart.add(bed);
    }

    public List<Bed> getCart() {
        return cart;
    }

}
