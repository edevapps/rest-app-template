package com.edevapps.rest.demo.domain;

import com.edevapps.rest.demo.error.ObjectNotFoundException;

import java.util.concurrent.Callable;

public interface Context {

    <T> T instance(Class<T> clazz) throws ObjectNotFoundException;

    <T> void wrapInTransaction(Callable<T> action);
}
