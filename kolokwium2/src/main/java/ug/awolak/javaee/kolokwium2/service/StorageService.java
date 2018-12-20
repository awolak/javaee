package ug.awolak.javaee.kolokwium2.service;

import java.util.ArrayList;
import java.util.List;

import ug.awolak.javaee.kolokwium2.domain.Lace;

public class StorageService {

    private int id = 0;
    private List<Lace> db = new ArrayList<Lace>();
    private List<Lace> cart = new ArrayList<Lace>();

    public void add(Lace lace) {
        Lace newLace = new Lace(lace.getId(), lace.getProducer(), lace.getProductionDate(), lace.getWidth(), lace.getPrice(), lace.getQuantity());
        db.add(newLace);
    }

    public int getId() {
        id++;

        return this.id;
    }

    public List<Lace> getAllLaces() {
        return db;
    }

    public void addToCart(Lace lace) {
        cart.add(lace);
    }

    public List<Lace> getCart() {
        return cart;
    }

}
