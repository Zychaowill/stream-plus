package org.streamframework.foundation.clean.code;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Interface to help remove the tedious if and else.
 *  
 * @author jangz
 *
 */
public interface Chain {
	
	Chain and();
	
	Chain or();
	
	Chain not();
	
	Chain on(Predicate<?> cond);
	
	Chain when(Predicate<?> cond);
	
	Chain to(Function<?, ?> done);
	
	Chain otherwise(Function<?, ?> done);
}
