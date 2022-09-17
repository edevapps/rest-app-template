package com.edevapps.rest.demo;

import com.edevapps.rest.demo.domain.Context;
import com.edevapps.rest.demo.domain.ContextHolder;
import com.edevapps.rest.demo.error.ObjectNotFoundException;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Objects;
import java.util.concurrent.Callable;

import static org.springframework.beans.factory.BeanFactoryUtils.beanOfTypeIncludingAncestors;

public final class SpringContextHolder extends ContextHolder implements ApplicationContextAware, Context {

    private static final SpringContextHolder instance = new SpringContextHolder();
    private static ApplicationContext context;

    public static SpringContextHolder instance() {
        return instance;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
        super.setCurrentContext(this);
    }

    @Override
    public <T> T instance(Class<T> clazz) throws ObjectNotFoundException {
        Objects.requireNonNull(clazz);
        checkApplicationContext();
        try {
            return beanOfTypeIncludingAncestors(context, clazz);
        } catch (Exception ex) {
            throw new ObjectNotFoundException(ex);
        }
    }

    @Override
    public <T> void wrapInTransaction(Callable<T> action) {
        Objects.requireNonNull(action);
        checkApplicationContext();
        PlatformTransactionManager transactionManager = beanOfTypeIncludingAncestors(context, PlatformTransactionManager.class);
        new TransactionTemplate(transactionManager).execute(status -> {
            try {
                return action.call();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void checkApplicationContext() {
        if (context == null) {
            throw new IllegalStateException("Context is not init.");
        }
    }
}
