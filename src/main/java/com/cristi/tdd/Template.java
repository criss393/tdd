package com.cristi.tdd;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by criss on 3/5/16.
 */
public class Template {
    private Map<String, String> variables;
    private String templateText;


    public Template(String templateText) {
        this.variables = new HashMap<>();
        this.templateText = templateText;
    }

    public void set(String name, String value) {
        this.variables.put(name, value);
    }

    public String evaluate() throws MissingValueException {
        String result = replaceVariables();
        checkForMissingValues(result);
        return result;
    }

    private void checkForMissingValues(String result) {
        if(result.matches(".*\\$\\{.+\\}.*")) {
            throw new MissingValueException();
        }

    }

    private String replaceVariables() {
        String result = templateText;
        for (Map.Entry<String, String> entry: variables.entrySet()) {
            String regex = "\\$\\{" + entry.getKey() + "\\}";
            result = result.replaceAll(regex, entry.getValue());
        }
        return result;
    }
}
