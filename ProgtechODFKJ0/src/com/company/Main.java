package com.company;

import controller.RaktarController;
import view.Megjelenites;

public class Main {

    public static void main(String[] args) {
        RaktarController raktarController = new RaktarController();

        raktarController.raktarAlapallapot();

        do {
            try {
                raktarController.bevitelKezeles();
            } catch (Exception e) {
                Megjelenites.adatokMegjelenitese(e.getMessage());
            }
        } while(true);
    }
}
