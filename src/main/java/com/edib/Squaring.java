/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edib;

import java.util.concurrent.Callable;

/**
 *
 * @author alumno
 */
public class Squaring implements Callable<Integer> {

    private Integer base;
    private Long time = 0L;

    public Squaring(Integer base) {
        this.base = base;
    }
    
    public Squaring(Integer base, Long time) {
        this(base);
        this.time = time;
    }

    public Integer call() throws Exception {
        Thread.sleep(time);
        if (time != 0) System.out.println(Thread.currentThread().getName());
        return base + base;
    }

}
