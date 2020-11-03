package mvc_calc;

import util.Math;

/**
 * Calculator Data Management
 *
 * @author John Mortensen
 * @version 1.0
 */
public class CalcData
{
    //answer to operation
    private double answer;

    //operation values
    private Math.OPERATOR mathOp;
    private double arg1;
    private double arg2;
    
    public CalcData() { //constructor default sets 
        mathOp = Math.OPERATOR.NOOP;
        arg1 = 0.0;
        arg2 = 0.0;
        answer = 0.0;
    }
    
    public void setMathOp(Math.OPERATOR value) { //method to set operator
        mathOp = value;
    }
    
    public void setArg1(double value) { //method to set argument 1
        arg1 = value;
    }
    
    public void setArg2(double value) { //method to set argument 2
        arg2 = value;
    }
    
    public double calculate() {
        return Math.calculateIt(arg1, mathOp, arg2);	
    }
}
