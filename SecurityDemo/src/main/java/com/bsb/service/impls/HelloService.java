package com.bsb.service.impls;

import com.bsb.service.IHelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloService implements IHelloService {

    @Override
    public String greeting(String name) {
        System.out.println("greeting");
        return "hello " + name;
    }
}
