/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edib;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author alumno
 */
public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        
        int nThreads = 2;
        
        ExecutorService executor = Executors.newFixedThreadPool(nThreads);
        
        List<Callable> callables = Utils.createCallableList();
        
        long time = System.currentTimeMillis();
        
        executor.invokeAll((Collection) callables);
        
        System.out.println("Punto 1 --> " + (System.currentTimeMillis() - time) + "ms");
        
        ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor)executor;
        
        System.out.println("# Tareas completadas " + poolExecutor.getCompletedTaskCount());
        
        executor.shutdown();

    }
    
}
