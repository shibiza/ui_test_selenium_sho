package org.example.properties.converters;


import org.example.configuration.SupportedBrowsers;

public class SupportedBrowserConverter {
    public static SupportedBrowsers valueOfWebBrowsers(String webBrowserName) {
        switch (webBrowserName) {
            case "local_chrome":
                return SupportedBrowsers.LOCAL_CHROME;

            default:
                throw new IllegalArgumentException("Incorrect browser name");
        }
    }
}
