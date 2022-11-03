package com.fidelity.smallChange.business;

/**
 * CarBodyType describes the type of a vehicle's body.
 *
 * @author ROI Instructor Team
 */
public enum IncomeCategory {
	LOW(1, "Low"), 
	MIDDLE(2, "Middle"), 
	HIGH(3, "High");

	private int code;
	private String name;

	private IncomeCategory(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public static IncomeCategory of(int code) {
		for (IncomeCategory ic : values()) {
			if (ic.code == code) {
				return ic;
			}
		}
		throw new IllegalArgumentException("Unknown category type code " + code);
	}

	public static IncomeCategory of(String name) {
		for (IncomeCategory ic : values()) {
			if (name.equals(ic.name)) {
				return ic;
			}
		}
		throw new IllegalArgumentException("Unknown category type name " + name);
	}

	public int getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
}
