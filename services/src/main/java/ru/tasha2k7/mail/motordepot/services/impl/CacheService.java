package ru.tasha2k7.mail.motordepot.services.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;

@Service
public class CacheService {

    @PostConstruct
    private void onStartUp() {

        Runtime.getRuntime().addShutdownHook(
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                       
                    }
                }));

    }

    @PreDestroy
    private void onShutDown() {
       
    }

}
