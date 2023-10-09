package it.licia.fabricktest.dto;

import java.util.Arrays;

public class TransactionList {

	private Transaction[] list;

	public Transaction[] getList() {
		return list;
	}

	public void setList(Transaction[] list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "TransactionList [list=" + Arrays.toString(list) + "]";
	}

	
	
}
