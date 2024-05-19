package org.rick.service;

import org.rick.instrument.Instrument;
import org.rick.instrument.InstrumentSpec;

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
        Instrument instrument = new Instrument(serialNumber, price, instrumentSpec);
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

    public List<Instrument> search(InstrumentSpec instrumentSpec) {
        List<Instrument> searchedGuitars = new ArrayList<>();
        for (Iterator<Instrument> i = instruments.iterator(); i.hasNext(); ) {
            Instrument instrument = (Instrument) i.next();
            if (instrument.getInstrumentSpec().matches(instrumentSpec)) {
                searchedGuitars.add(instrument);
            }
        }
        return searchedGuitars;
    }
}
