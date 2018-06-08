package com.streamframework.foundation.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.junit.Test;
import org.streamframework.foundation.DefaultStrongStream;
import org.streamframework.foundation.StrongStream;

import com.streamframework.foundation.collections.domain.Order;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrongStreamTest {

	@Test
	public void testStrongStream() {
		List<Order> orders = Arrays.asList(new Order(1, 123456789), new Order(2, 987654321), new Order(1, 193746285));
		List<Integer> orderTypes = Arrays.asList(1);
		
		List<Order> result = 
				new DefaultStrongStream<Integer, Order, Integer>()
					.datas(orders)
					.key(Order::getOrderType)
					.templates(orderTypes)
					.collect();
		for (Order order : result) {
			log.info("order info: {}", order);
		}
	}
	
	@Test
	public void testSimpleStrongStream() {
		log.info("any match: is null: {}", StrongStream.stream(null).anyMatch(Objects::isNull));
	
		new DefaultStrongStream<>().datas(null).key(null).templates(null).collect();
	}
}
