package com.github.godofwharf.streaming.routing;


import com.github.godofwharf.streaming.graph.Graph;
import com.github.godofwharf.streaming.singletonfactory.SingletonFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGossiper {

    public List<Integer> getNeighbours(int id) {
        Graph g = SingletonFactory.getGraph();

        return g.getNeighbourList(id);

    }

    public List<Integer> getRandomSubset(int id) {
        List<Integer> neigbours = getNeighbours(id);

        if (neigbours.size() < 2)
            return neigbours;

        Random generator = new Random(System.currentTimeMillis());

        List<Integer> chosenOnes = new ArrayList<Integer>();

        for (Integer n : neigbours) {
            if (generator.nextDouble() > 0.5)
                chosenOnes.add(n);
        }

        return chosenOnes;
    }

}
