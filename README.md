# stream-plus
Let's use stream more elegantly.

- 6/8/2018 provide ``` StrongStream ``` and ``` ListHelper ```

We don't need care NullPointerException.<br/>
At a same time, let operation is more simple. For example, distinct, convert to HashSet, etc.<br/>

```Java
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
```