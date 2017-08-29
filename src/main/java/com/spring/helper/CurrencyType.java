package com.spring.helper;

import net.sf.dynamicreports.report.builder.datatype.BigDecimalType;

public class CurrencyType extends BigDecimalType {

	private static final long serialVersionUID = 1L;

	@Override

	public String getPattern() {

		return "#,###.00 VND";

	}

}