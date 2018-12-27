package ua.nure.kn.dziuba.usermanagement.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {

    private static final String BUNDLE_NAME = "messages";
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    private Messages() {

    }

<<<<<<< HEAD
    /**
     * Gets String in depend on key in messages.properties file.
     *
     * @param key to find string on.
     * @return string in depend on key.
     * */
=======
>>>>>>> agent2
    public static String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return key + "was not found";
        }
    }
}
