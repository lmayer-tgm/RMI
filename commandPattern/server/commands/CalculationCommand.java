package server.commands;

import java.io.Serializable;

import calculation.Calculation;
import calculation.PICalc;

public class CalculationCommand implements Command, Serializable {

	private static final long serialVersionUID = 3202369269194172790L;
	private Calculation calc;

	@Override
	public void execute() {
		System.out.println("CalculationCommand called!");
		calc = new PICalc();
		calc.calculate();
		calc.getResult();
	}
}
