package com.racing;

import java.util.concurrent.LinkedBlockingQueue;

public class CustomLinkedBlockingQueue<E> extends LinkedBlockingQueue<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2016290522051717386L;

	@Override
	public boolean offer(E e) {
		if (this.contains(e))
			return false;
		return super.offer(e);
	}
}
