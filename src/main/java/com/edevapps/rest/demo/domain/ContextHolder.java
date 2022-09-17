package com.edevapps.rest.demo.domain;

public abstract class ContextHolder {

    private static Context context;

    protected void setCurrentContext(Context context) {
        ContextHolder.context = context;
    }

    public static Context context() {
        if (context == null) {
            throw new IllegalStateException("Context is not init.");
        }
        return context;
    }
}
