package com.rosorio.domain.mapper;

import java.util.List;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */

public interface Mapper<I,O> {
    O map(I input);
    List<O> mapAll(List<I> inputs);
}
