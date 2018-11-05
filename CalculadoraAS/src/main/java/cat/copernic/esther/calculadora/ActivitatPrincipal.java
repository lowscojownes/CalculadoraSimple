package cat.copernic.esther.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Activitat que mostra una calculadora simple amb 4 operacions:
 * suma, resta, multiplicació i divisió
 * @author LoWs
 * @since 22/10/2018
 * @version 1.0
 * @see Calculadora {@link Calculadora}
 */
public class ActivitatPrincipal extends AppCompatActivity {


    public static final String logActivittat = "ActivitatPrincipal";
    private Calculadora mCalculadora;

    private EditText mOperandOneEditText;
    private EditText mOperandTwoEditText;

    private TextView mResultTextView;

    /**
     * Métode inicialitzador dels layouts i vidgets
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mCalculadora = new Calculadora();
        inicialitzacio();
    }

    private void inicialitzacio() {
        mResultTextView = findViewById(R.id.operation_result_text_view);
        mOperandOneEditText = findViewById(R.id.operand_one_edit_text);
        mOperandTwoEditText = findViewById(R.id.operand_two_edit_text);
    }


    /**
     * Captura el onClick del botó sumar
     * @param view
     */
    public void onAdd(View view) {
        compute(Calculadora.Operator.ADD);
    }


    /**
     * Captura el onClick del botó restar
     * @param view
     */
    public void onSub(View view) {
        compute(Calculadora.Operator.SUB);
    }

    /**
     * S'encarrega de agafar l'excepció del argument il·legal en el mètode que captura el
     * onClick del botó dividir
     * @param view
     * @throws IllegalArgumentException L'entrada no es vàlida
     */
    public void onDiv(View view) {
        try {
            compute(Calculadora.Operator.DIV);
        } catch (IllegalArgumentException iae) {
            Log.e(logActivittat, "IllegalArgumentException", iae);
            mResultTextView.setText(getString(R.string.computationError));
        }
    }

    /**
     * Mètode que captura el onClick del botó multiplicar
     * @param view
     */
    public void onMul(View view) {
        compute(Calculadora.Operator.MUL);
    }

    /**
     *
     * @param operator
     */
    private void compute(Calculadora.Operator operator) {
        double operandOne;
        double operandTwo;
        try {
            operandOne = getOperand(mOperandOneEditText);
            operandTwo = getOperand(mOperandTwoEditText);
        } catch (NumberFormatException nfe) {
            Log.e("CalculatorActivity", "NumberFormatException", nfe);
            mResultTextView.setText(getString(R.string.computationError));
            return;
        }

        String result;

        /**
         * Cas que crida segons l'opció escollida al mètode adient de Calculadora
         */
        switch (operator) {
            case ADD:
                result = String.valueOf(
                        mCalculadora.add(operandOne, operandTwo));
                break;
            case SUB:
                result = String.valueOf(
                        mCalculadora.sub(operandOne, operandTwo));
                break;
            case DIV:
                result = String.valueOf(
                        mCalculadora.div(operandOne, operandTwo));
                break;
            case MUL:
                result = String.valueOf(
                        mCalculadora.mul(operandOne, operandTwo));
                break;
            default:
                result = getString(R.string.computationError);
                break;
        }
        mResultTextView.setText(result);
    }


    /**
     * Mètode que agafa el string del edit Text del operador
     * @param operandEditText
     * @return el valor de operandText
     */
    private static Double getOperand(EditText operandEditText) {
        String operandText = getOperandText(operandEditText);
        return Double.valueOf(operandText);
    }


    /**
     * Mètode que transforma a string el contingut del edittext
     * @param operandEditText
     * @return String de EditText
     */
    private static String getOperandText(EditText operandEditText) {
        return operandEditText.getText().toString();
    }
}
