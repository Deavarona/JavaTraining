package com.kkotto.model;

public enum CarModel {
    AUDI(0),
    BMW(1),
    OPEL(2);
    final int modelID;

    CarModel(int modelID) {
        this.modelID = modelID;
    }

    public static CarModel getById(int id) {
        switch (id) {
            case 1:
                return AUDI;
            case 2:
                return BMW;
            case 3:
                return OPEL;
        }
        return OPEL;
    }
}
