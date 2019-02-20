package com.citiestest.domain;

import io.reactivex.Observable;

/**
 * Use cases are the entry points to the domain layer.
 *
 * @param <Q> the request type
 * @param <P> the response type
 */
public abstract class UseCase<Q, P> {

    public Observable<P> run(Q requestValues) {
        return executeUseCase(requestValues);
    }

    protected abstract Observable<P> executeUseCase(Q requestValues);
}
