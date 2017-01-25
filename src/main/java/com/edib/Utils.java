/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edib;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 *
 * @author alumno
 */
public class Utils {

    public static final Integer maxTasks = 100;
    public static final Long timeToWait = 100L;

    public static List<Callable> createCallableList() {
        
        List<Callable> callables = new ArrayList();

        for (int i = 0; i < Utils.maxTasks; i++) {

            callables.add(new Squaring(i,timeToWait));
        }

        return callables;
    }

}
