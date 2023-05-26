package com.gridnine.testing.filter;

import java.util.List;
import java.util.function.Predicate;

public interface Filter<T> {
    List<T> filter( List<T> list, Predicate<T>... predicate );


}
