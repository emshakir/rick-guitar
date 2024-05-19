package org.rick.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rick.enums.Style;
import org.rick.instrument.Instrument;
import org.rick.instrument.guitar.Guitar;
import org.rick.instrument.guitar.GuitarSpec;

import static org.junit.jupiter.api.Assertions.*;

import org.rick.guitar.enums.Builder;
import org.rick.guitar.enums.Type;
import org.rick.guitar.enums.Wood;
import org.rick.instrument.mandolin.Mandolin;
import org.rick.instrument.mandolin.MandolinSpec;

import java.util.List;


class InventoryTest {

    Inventory inventory;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();

        inventory.addInstrument("11277", 3999.95,
                new GuitarSpec(Builder.COLLINGS, "CJ", Type.ACOUSTIC, 6,
                        Wood.INDIAN_ROSEWOOD, Wood.SITKA));
        inventory.addInstrument("V95693", 1499.95,
                new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, 6,
                        Wood.ALDER, Wood.ALDER));
        inventory.addInstrument("V9512", 1549.95,
                new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, 6,
                        Wood.ALDER, Wood.ALDER));
        inventory.addInstrument("122784", 5495.95,
                new GuitarSpec(Builder.MARTIN, "D-18", Type.ACOUSTIC, 6,
                        Wood.MAHOGANY, Wood.ADIRONDACK));
        inventory.addInstrument("76531", 6295.95,
                new GuitarSpec(Builder.MARTIN, "OM-28", Type.ACOUSTIC, 6,
                        Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK));
        inventory.addInstrument("70108276", 2295.95,
                new GuitarSpec(Builder.GIBSON, "Les Paul", Type.ELECTRIC, 6,
                        Wood.MAHOGANY, Wood.MAHOGANY));
        inventory.addInstrument("82765501", 1890.95,
                new GuitarSpec(Builder.GIBSON, "SG '61 Reissue", Type.ELECTRIC, 6,
                        Wood.MAHOGANY, Wood.MAHOGANY));
        inventory.addInstrument("77023", 6275.95,
                new GuitarSpec(Builder.MARTIN, "D-28", Type.ACOUSTIC, 6,
                        Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK));
        inventory.addInstrument("1092", 12995.95,
                new GuitarSpec(Builder.OLSON, "SJ", Type.ACOUSTIC, 12,
                        Wood.INDIAN_ROSEWOOD, Wood.CEDAR));
        inventory.addInstrument("566-62", 8999.95,
                new GuitarSpec(Builder.RYAN, "Cathedral", Type.ACOUSTIC, 12,
                        Wood.COCOBOLO, Wood.CEDAR));
        inventory.addInstrument("629584", 2100.95,
                new GuitarSpec(Builder.PRS, "Dave Navarro Signature", Type.ELECTRIC,
                        6, Wood.MAHOGANY, Wood.MAPLE));

        inventory.addInstrument("9019920", 5495.99,
                new MandolinSpec(Builder.PRS, "F-5G", Type.ACOUSTIC,
                        Style.A, Wood.MAPLE, Wood.MAPLE));

        inventory.addInstrument("9015820", 5458.99,
                new MandolinSpec(Builder.PRS, "F-6G", Type.ACOUSTIC,
                        Style.F, Wood.MAPLE, Wood.MAPLE));


    }

    @Test
    void addInstrument() {

        inventory.addInstrument("629584", 2100.95,
                new GuitarSpec(Builder.PRS, "Dave Navarro Signature", Type.ELECTRIC,
                        6, Wood.MAHOGANY, Wood.MAPLE));

        inventory.addInstrument("9015820", 5458.99,
                new MandolinSpec(Builder.PRS, "F-6G", Type.ACOUSTIC,
                        Style.F, Wood.MAPLE, Wood.MAPLE));

    }

    @Test
    void get() {
        Instrument mandolinIns = inventory.get("9015820");
        MandolinSpec mandolinSpec = (MandolinSpec) mandolinIns.getInstrumentSpec();
        assertEquals(mandolinSpec.getStyle(), Style.F);

        Instrument instrumentGui = inventory.get("629584");
        GuitarSpec guitarSpec = (GuitarSpec) instrumentGui.getInstrumentSpec();
        assertEquals(guitarSpec.getNumStrings(), 6);
    }

    @Test
    void search() {
        GuitarSpec guitarSpec = new GuitarSpec(Builder.PRS, "Dave Navarro Signature", Type.ELECTRIC,
                6, Wood.MAHOGANY, Wood.MAPLE);
        List<Guitar> guitars = inventory.search(guitarSpec);
        assertEquals(guitars.size(), 1);

        MandolinSpec mandolinSpec = new MandolinSpec(Builder.PRS, "F-6G", Type.ACOUSTIC,
                Style.F, Wood.MAPLE, Wood.MAPLE);
        List<Mandolin> mandolins = inventory.search(mandolinSpec);
        assertEquals(mandolins.size(), 1);
    }
    
}