package com.streamframework.foundation.collections.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	
	private Integer orderType;
	private Integer orderNo;
}
