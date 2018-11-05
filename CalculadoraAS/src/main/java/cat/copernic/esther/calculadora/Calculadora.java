package cat.copernic.esther.calculadora;

/**
 * Classe que realitza les operacions de suma, resta, divisio i multiplicacio
 * @author LoWs
 * @since 22/10/2018
 * @version 1.0
 * @see ActivitatPrincipal {@link ActivitatPrincipal}
 */

public class Calculadora {


    public enum Operator {ADD, SUB, DIV, MUL}


    /**
     * Realitza la suma dels parametres
     * @param firstOperand
     * @param secondOperand
     * @return firstOperand + secondOperand
     * @Link
     */
    public double add(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }

    /**
     * Realitza la resta dels parametres
     * @param firstOperand
     * @param secondOperand
     * @return firstOperand-secondOperand
     */
    public double sub(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }

    /**
     * Realitza la divisió dels parametres
     * @param firstOperand
     * @param secondOperand
     * @return firstOperand/secondOperand
     */
    public double div(double firstOperand, double secondOperand) {
        return firstOperand / secondOperand;
    }

    /**
     * Realitza la multiplicació dels parametres
     * @param firstOperand
     * @param secondOperand
     * @return firstOperand*secondOperand
     */
    public double mul(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }
}
