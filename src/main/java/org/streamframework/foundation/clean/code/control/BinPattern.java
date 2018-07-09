package org.streamframework.foundation.clean.code.control;

import java.util.Objects;
import java.util.function.Predicate;

public class BinPattern<T> {
	
	private T t;
	private boolean success;
	private Branch executeBranch;
	
	private BinPattern(T t) {
		this.t = t;
		
	}
	
	public static <T> BinPattern<T> of(T t) {
		return new BinPattern<T>(t);
	}

	public BinPattern<T> is(Predicate<T> filter) {
		this.success = filter.test(t);
		return this;
	}
	
	public BinPattern<T> success(Branch branch) {
		if (success) {
			this.executeBranch = branch;
		}
		return this;
	}
	
	public BinPattern<T> error(Branch branch) {
		if (!success) {
			this.executeBranch = branch;
		}
		return this;
	}
	
	public void execute() {
		Objects.requireNonNull(this.executeBranch, "Executable branch cannot be null.");
		
		this.executeBranch.execute();
	}
}
