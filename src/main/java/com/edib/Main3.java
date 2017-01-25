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
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author alumno
 */
public class Main3 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        int nThreads = 2;
        
        ExecutorService executor = Executors.newFixedThreadPool(nThreads);

        List<Callable> callables = Utils.createCallableList();

        List<Future<Integer>> results = new ArrayList();
        
        long time = System.currentTimeMillis();
        
        for (Callable callable : callables) {
            Future<Integer> future = executor.submit(callable);
            results.add(future);
        }
        
        for (Future<Integer> result : results){
            Integer resultado = result.get();
            System.out.println(resultado);
        }
        
        System.out.println("Punto 2.1 --> " + (System.currentTimeMillis() - time) + "ms");
        
        ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) executor;

        System.out.println("# Tareas completadas " + poolExecutor.getCompletedTaskCount());

        executor.shutdown();

    }

}
