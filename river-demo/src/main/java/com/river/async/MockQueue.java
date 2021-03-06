package com.river.async;

import org.springframework.stereotype.Component;

@Component
public class MockQueue {

	private String placeOrder;// order

	private String completeOrder;// complete

	public String getPlaceOrder() {
		return placeOrder;
	}

	public void setPlaceOrder(String placeOrder) throws Exception {
		new Thread(() -> {
			System.out.println("receive a order....");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			this.completeOrder = placeOrder;
			System.out.println("Order request processing completed:" + placeOrder);

		}).start();
	}

	public String getCompleteOrder() {
		return completeOrder;
	}

	public void setCompleteOrder(String completeOrder) {
		if (this.completeOrder != null) {
			System.out.println("order is complete....");
			this.completeOrder = null;
		}

	}

}
