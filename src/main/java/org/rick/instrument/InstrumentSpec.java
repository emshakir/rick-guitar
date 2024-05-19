package org.rick.instrument;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class InstrumentSpec {

    private Map<String, Object> properties;

    public InstrumentSpec(Map<String, Object> properties) {
        if (properties == null) {
            this.properties = new HashMap<>();
        } else {
            this.properties = new HashMap<>(properties);
        }
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public Object getProperty(String name) {
        return properties.get(name);
    }

    public boolean matches(InstrumentSpec spec) {
        for (Iterator<String> i = spec.properties.keySet().iterator(); i.hasNext(); ) {
            String key = i.next();
            if (!properties.get(key).equals(spec.getProperty(key))) {
                return false;
            }
        }
        return true;
    }
}
