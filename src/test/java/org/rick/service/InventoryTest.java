package org.rick.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rick.enums.InstrumentType;
import org.rick.enums.Builder;
import org.rick.enums.Type;
import org.rick.enums.Wood;
import org.rick.instrument.Instrument;
import org.rick.instrument.InstrumentSpec;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


class InventoryTest {

    Inventory inventory;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        Map<String, Object> properties = new HashMap<>();
        properties.put("instrumentType", InstrumentType.GUITAR);
        properties.put("builder", Builder.COLLINGS);
        properties.put("model", "CJ");
        properties.put("type", Type.ACOUSTIC);
        properties.put("numStrings", 6);
        properties.put("topWood", Wood.INDIAN_ROSEWOOD);
        properties.put("backWood", Wood.SITKA);
        inventory.addInstrument("11277", 3999.95, new InstrumentSpec(properties));

        properties.put("builder", Builder.MARTIN);
        properties.put("model", "D-18");
        properties.put("topWood", Wood.MAHOGANY);
        properties.put("backWood", Wood.ADIRONDACK);
        inventory.addInstrument("122784", 5495.95, new InstrumentSpec(properties));

        properties.put("builder", Builder.FENDER);
        properties.put("model", "Stratocastor");
        properties.put("type", Type.ELECTRIC);
        properties.put("topWood", Wood.ALDER);
        properties.put("backWood", Wood.ALDER);
        inventory.addInstrument("V95693", 1499.95, new InstrumentSpec(properties));
        inventory.addInstrument("V9512", 1549.95, new InstrumentSpec(properties));

        properties.put("builder", Builder.GIBSON);
        properties.put("model", "Les Paul");
        properties.put("topWood", Wood.MAPLE);
        properties.put("backWood", Wood.MAPLE);
        inventory.addInstrument("70108276", 2295.95, new InstrumentSpec(properties));

        properties.put("model", "SG '61 Reissue");
        properties.put("topWood", Wood.MAHOGANY);
        properties.put("backWood", Wood.MAHOGANY);
        inventory.addInstrument("82765501", 1890.95, new InstrumentSpec(properties));

        properties.put("instrumentType", InstrumentType.MANDOLIN);
        properties.put("type", Type.ACOUSTIC);
        properties.put("model", "F-5G");
        properties.put("backWood", Wood.MAPLE);
        properties.put("topWood", Wood.MAPLE);
        properties.remove("numStrings");
        inventory.addInstrument("9019920", 5495.99, new InstrumentSpec(properties));

        properties.put("instrumentType", InstrumentType.BANJO);
        properties.put("model", "RB-3 Wreath");
        properties.remove("topWood");
        properties.put("numStrings", 5);
        inventory.addInstrument("8900231", 2945.95, new InstrumentSpec(properties));
    }

    @Test
    void addInstrument() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("instrumentType", InstrumentType.GUITAR);
        properties.put("builder", Builder.COLLINGS);
        properties.put("model", "CJ");
        properties.put("type", Type.ACOUSTIC);
        properties.put("numStrings", 6);
        properties.put("topWood", Wood.INDIAN_ROSEWOOD);
        properties.put("backWood", Wood.SITKA);
        inventory.addInstrument("11277", 3999.95, new InstrumentSpec(properties));
    }

    @Test
    void get() {
        Instrument instrument = inventory.get("11277");
        Map<String, Object> guitar = instrument.getInstrumentSpec().getProperties();
        Assertions.assertEquals(guitar.get("builder"), Builder.COLLINGS);
        Assertions.assertEquals(instrument.getPrice(), 3999.95);
    }

    @Test
    void search() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("builder", Builder.GIBSON);
        properties.put("backWood", Wood.MAPLE);
        InstrumentSpec whatBryanLikes = new InstrumentSpec(properties);
        List<Instrument> instruments = inventory.search(whatBryanLikes);
        Assertions.assertEquals(3, instruments.size());
    }

}