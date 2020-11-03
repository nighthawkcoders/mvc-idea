package mvc_calc;

import util.Math.OPERATOR;

/**
 * Basic functioning Calculator
 *
 * @author John Mortensen
 * @version 1.0
 */
public class Calculator //control class
{
    // instance variables - replace the example below with your own
    
    private enum STATE {  INITIAL, SAVE1, SAVE2, CALC }
    private STATE mathState;

    CalcData model; // calculator values
    CalcUI view;
    
    /**
     * Setup View and Model
     */
    public Calculator()
    {
        //note calculator is managing model and view
        this.model = new CalcData();
        this.view = new  CalcUI(this);
        view.setVisible(true);  //activates view event system
    }
    
    /**
     * Clear Calculator View and Model
     */
    public void clearCalculator() {  // helper method to clear and update calculator to default
        // calculator control
        mathState = STATE.INITIAL;
        model = new CalcData();
        view.initCalcArea();
    }
    
    public void calculateAnswer()  // method to perform calculation
    {
        //calculate and set answer
        double result = model.calculate();
        //set model and view to answer
        model.setArg1(result);
        mathState = STATE.CALC;
        view.setCalcArea(String.valueOf(result));
    }

    /**
     * Save values for Calculator.
     */
    public void saveValueOfArg1(Double value) { // method to store 1st value in calculation (arg1)
        //store arg and alert view to input state change
        model.setArg1(value);
        mathState = STATE.SAVE1;
        view.initInputState();      
    }
    
    public void saveValueOfArg2(Double value) { // method to store 2nd value in calculation (arg2)
        //save arg prior to transtion to calculating answer
        if (mathState != STATE.CALC) { //if allows you to repeat previous operation
            model.setArg2(value);
            mathState = STATE.SAVE2;
        }
    }
    
    public void saveValueOfMathOp(OPERATOR op) { // method to store operator
        model.setMathOp(op); //simple setter
    }
    
    /**
     * Start Calculator control
     *
     */
    public static void main(String[] args) {
        new Calculator();
    }
}
