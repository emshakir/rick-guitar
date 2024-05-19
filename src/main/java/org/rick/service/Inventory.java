package org.rick.service;

import org.rick.instrument.guitar.Guitar;
import org.rick.instrument.guitar.GuitarSpec;
import org.rick.instrument.Instrument;
import org.rick.instrument.InstrumentSpec;
import org.rick.instrument.mandolin.Mandolin;
import org.rick.instrument.mandolin.MandolinSpec;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Inventory {

    private List<Instrument> instruments;

    public Inventory() {
        this.instruments = new LinkedList<>();
    }

    public void addInstrument(String serialNumber, double price, InstrumentSpec instrumentSpec) {
        Instrument instrument = null;
        if (instrumentSpec instanceof GuitarSpec) {
            instrument = new Guitar(serialNumber, price, (GuitarSpec) instrumentSpec);
        } else if (instrumentSpec instanceof MandolinSpec) {
            instrument = new Mandolin(serialNumber, price, (MandolinSpec) instrumentSpec);
        }
        instruments.add(instrument);
    }


    public Instrument get(String serialNumber) {
        for (Iterator<Instrument> i = instruments.iterator(); i.hasNext(); ) {
            Instrument instrument = (Instrument) i.next();
            if (instrument.getSerialNumber().equals(serialNumber)) {
                return instrument;
            }
        }
        return null;
    }

    public List<Guitar> search(GuitarSpec searchGuitarSpec) {
        List<Guitar> searchedGuitars = new ArrayList<>();
        for (Iterator<Instrument> i = instruments.iterator(); i.hasNext(); ) {
            Instrument instrument = (Instrument) i.next();
            if (instrument instanceof Guitar guitar) {
                if (guitar.getInstrumentSpec().matches(searchGuitarSpec)) {
                    searchedGuitars.add(guitar);
                }
            }
        }
        return searchedGuitars;
    }

    public List<Mandolin> search(MandolinSpec searchGuitarSpec) {
        List<Mandolin> searchedMandolins = new ArrayList<>();
        for (Iterator<Instrument> i = instruments.iterator(); i.hasNext(); ) {
            Instrument instrument = (Instrument) i.next();
            if (instrument instanceof Mandolin mandolin) {
                if (mandolin.getInstrumentSpec().matches(searchGuitarSpec)) {
                    searchedMandolins.add(mandolin);
                }
            }
        }
        return searchedMandolins;
    }
}
