package id.dana.richview.calculator;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class CalculatorView_ViewBinding implements Unbinder {
    private CalculatorView KClassImpl$Data$declaredNonStaticMembers$2;

    public CalculatorView_ViewBinding(CalculatorView calculatorView, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = calculatorView;
        calculatorView.rvCalculator = (RecyclerView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.rv_calculator, "field 'rvCalculator'", RecyclerView.class);
        calculatorView.tvHintOperandLeft = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_hint_operand_left, "field 'tvHintOperandLeft'", TextView.class);
        calculatorView.tvHintOperandRight = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_hint_operand_right, "field 'tvHintOperandRight'", TextView.class);
        calculatorView.tvHintOperator = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_hint_operator, "field 'tvHintOperator'", TextView.class);
        calculatorView.separator = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.vw_calculator_line, "field 'separator'");
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        CalculatorView calculatorView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (calculatorView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        calculatorView.rvCalculator = null;
        calculatorView.tvHintOperandLeft = null;
        calculatorView.tvHintOperandRight = null;
        calculatorView.tvHintOperator = null;
        calculatorView.separator = null;
    }
}
