package org.streamframework.foundation.clean.code;

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
	
	Chain when();
	
	Chain to();
	
	Chain otherwise();
}
