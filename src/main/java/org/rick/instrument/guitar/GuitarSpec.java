package org.rick.guitar;

import org.rick.guitar.enums.Builder;
import org.rick.guitar.enums.Type;
import org.rick.guitar.enums.Wood;

public class GuitarSpec extends InstrumentSpec {

    private int numStrings;

    public GuitarSpec(Builder builder, String model, Type type,
                      int numStrings, Wood backWood, Wood topWood) {
        super(builder, model, type, backWood, topWood);
        this.numStrings = numStrings;
    }

    public int getNumStrings() {
        return numStrings;
    }

    @Override
    public boolean matches(InstrumentSpec otherSpec) {

        if (!super.matches(otherSpec)) {
            return false;
        }

        if (!(otherSpec instanceof GuitarSpec)) {
            return false;
        }
        GuitarSpec guitarSpec = (GuitarSpec) otherSpec;
        if (numStrings != guitarSpec.getNumStrings()) {
            return false;
        }
        return true;
    }
}
