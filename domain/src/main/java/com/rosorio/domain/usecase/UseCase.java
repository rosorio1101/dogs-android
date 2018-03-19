package com.rosorio.domain.usecase;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */

public interface UseCase<T, P> {
    T execute(P param);
}
