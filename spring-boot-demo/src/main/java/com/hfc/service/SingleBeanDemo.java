package com.hfc.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SingleBeanDemo implements SingleBeanDemoService {
    private Logger logger = LoggerFactory.getLogger(SingleBeanDemo.class);

    private Integer m = 0;

    @Override
    public void say() {
        System.err.println(m + "-----------");
        m++;
    }
}
