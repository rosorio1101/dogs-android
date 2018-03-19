package com.rosorio.domain.mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */

public abstract class AbstractMapper<I, O> implements Mapper<I,O> {

    @Override
    public List<O> mapAll(List<I> inputs) {
        List<O> outputs = new ArrayList<>();
        for (I input: inputs) {
            outputs.add(map(input));
        }
        return outputs;
    }
}
