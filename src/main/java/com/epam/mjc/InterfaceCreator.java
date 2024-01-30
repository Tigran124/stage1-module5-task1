package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String y : x) {
                if (Character.isLowerCase(y.charAt(0)) || Character.isDigit(y.charAt(0))) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            x.addAll(x.stream().
                    filter(z -> z % 2 == 0).
                    collect(Collectors.toList()));
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream().
                filter(y -> Character.isUpperCase(y.charAt(0))).
                filter(y -> y.charAt(y.length() - 1) == '.').
                filter(y -> y.split(" ").length > 3).
                collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x ->{
            Map<String, Integer> map = new HashMap<>();
            x.forEach(z -> map.put(z, z.length()));
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (x, y) ->{
            List<Integer> list = new ArrayList<>();
            list.addAll(x);
            list.addAll(y);
            return list;
        };
    }
}
