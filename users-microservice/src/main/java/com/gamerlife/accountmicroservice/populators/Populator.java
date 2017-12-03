package com.gamerlife.accountmicroservice.populators;

public interface Populator<S,T> {

	void populate(S source, T target);
}
