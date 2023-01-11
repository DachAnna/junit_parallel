package com.annadach;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class SimpleCallBack implements BeforeEachCallback, AfterEachCallback {

    private String value;

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        if (context.getDisplayName().contains("JDI")) {
            value = "JDI";
        }
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        System.out.println("This is a string: " + value);
    }
}
