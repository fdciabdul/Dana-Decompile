package id.dana.richview.calculator;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.richview.calculator.adapter.CalculatorAdapter;
import id.dana.richview.calculator.model.GenerateCalculatorData;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class CalculatorView extends BaseRichView implements CalculatorPadItemListener {
    private Context KClassImpl$Data$declaredNonStaticMembers$2;
    private CalculatorResultListener MyBillsEntityDataFactory;
    private int PlaceComponentResult;
    @Inject
    CalculatorAdapter calculatorAdapter;
    private boolean getAuthRequestContext;
    @BindView(R.id.rv_calculator)
    RecyclerView rvCalculator;
    @BindView(R.id.vw_calculator_line)
    View separator;
    @BindView(R.id.tv_hint_operand_left)
    TextView tvHintOperandLeft;
    @BindView(R.id.tv_hint_operand_right)
    TextView tvHintOperandRight;
    @BindView(R.id.tv_hint_operator)
    TextView tvHintOperator;

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_calculator;
    }

    public CalculatorView(Context context) {
        super(context);
        this.getAuthRequestContext = true;
    }

    public CalculatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.getAuthRequestContext = true;
    }

    public CalculatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.getAuthRequestContext = true;
    }

    public CalculatorView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.getAuthRequestContext = true;
    }

    @Override // id.dana.base.BaseRichView
    public void init(Context context, AttributeSet attributeSet, boolean z) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        super.init(context, attributeSet, z);
    }

    @Override // id.dana.base.BaseRichView
    public void parseAttrs(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.A);
            try {
                this.PlaceComponentResult = obtainStyledAttributes.getInt(0, 11);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        int i = ((this.KClassImpl$Data$declaredNonStaticMembers$2 instanceof Activity) && KClassImpl$Data$declaredNonStaticMembers$2()) ? R.dimen.f28272131165322 : R.dimen.f28262131165321;
        this.rvCalculator.setPadding(0, (int) getContext().getResources().getDimension(i), 0, 0);
        this.calculatorAdapter = new CalculatorAdapter(this, i);
        this.rvCalculator.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rvCalculator.setAdapter(this.calculatorAdapter);
        this.calculatorAdapter.setItems(GenerateCalculatorData.getAuthRequestContext());
        this.tvHintOperandLeft.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.PlaceComponentResult)});
        this.tvHintOperandRight.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.PlaceComponentResult)});
    }

    public void setSeparatorVisibility(boolean z) {
        this.separator.setVisibility(z ? 0 : 8);
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        ((Activity) this.KClassImpl$Data$declaredNonStaticMembers$2).getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        if (getResources().getDisplayMetrics().density <= 4.0d) {
            Activity activity = (Activity) this.KClassImpl$Data$declaredNonStaticMembers$2;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            double d = i;
            double d2 = displayMetrics.xdpi;
            Double.isNaN(d);
            Double.isNaN(d2);
            double d3 = d / d2;
            double d4 = i2;
            double d5 = displayMetrics.ydpi;
            Double.isNaN(d4);
            Double.isNaN(d5);
            if (Math.sqrt(Math.pow(d3, 2.0d) + Math.pow(d4 / d5, 2.0d)) < 5.5d) {
                return true;
            }
        }
        return false;
    }

    public void enableCalculator(boolean z) {
        this.getAuthRequestContext = z;
    }

    @Override // id.dana.richview.calculator.CalculatorPadItemListener
    public void onPadClicked(String str) {
        if (this.getAuthRequestContext && BuiltInFictitiousFunctionClassFactory(str)) {
            if (getAuthRequestContext()) {
                String BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(this.tvHintOperandLeft, str);
                this.tvHintOperandLeft.setText(BuiltInFictitiousFunctionClassFactory);
                this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory);
            } else if (PlaceComponentResult() || !PlaceComponentResult(str)) {
            } else {
                TextView textView = this.tvHintOperandRight;
                textView.setText(BuiltInFictitiousFunctionClassFactory(textView, str));
                this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory());
            }
        }
    }

    @Override // id.dana.richview.calculator.CalculatorPadItemListener
    public void onOperatorClicked(String str) {
        if (this.getAuthRequestContext) {
            if (!PlaceComponentResult() && BuiltInFictitiousFunctionClassFactory()) {
                this.tvHintOperator.setText(MyBillsEntityDataFactory(str));
            } else if (BuiltInFictitiousFunctionClassFactory()) {
            } else {
                String MyBillsEntityDataFactory = MyBillsEntityDataFactory();
                this.tvHintOperandLeft.setText(MyBillsEntityDataFactory);
                this.tvHintOperator.setText(MyBillsEntityDataFactory(str));
                this.tvHintOperandRight.setText("");
                this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory);
            }
        }
    }

    @Override // id.dana.richview.calculator.CalculatorPadItemListener
    public void onClearByCharacter() {
        if (this.getAuthRequestContext) {
            if (!getAuthRequestContext()) {
                if (!getAuthRequestContext() && BuiltInFictitiousFunctionClassFactory()) {
                    this.tvHintOperator.setText("");
                    return;
                } else if (BuiltInFictitiousFunctionClassFactory()) {
                    return;
                } else {
                    String charSequence = this.tvHintOperandRight.getText().toString();
                    if (!TextUtils.isEmpty(charSequence)) {
                        charSequence = charSequence.substring(0, charSequence.length() - 1);
                    }
                    this.tvHintOperandRight.setText(charSequence);
                    this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory());
                    return;
                }
            }
            String charSequence2 = this.tvHintOperandLeft.getText().toString();
            if (!TextUtils.isEmpty(charSequence2)) {
                charSequence2 = charSequence2.substring(0, charSequence2.length() - 1);
            }
            this.tvHintOperandLeft.setText(charSequence2);
            this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(charSequence2);
        }
    }

    @Override // id.dana.richview.calculator.CalculatorPadItemListener
    public void onClearAll() {
        if (this.getAuthRequestContext) {
            this.tvHintOperandLeft.setText("");
            this.tvHintOperator.setText("");
            this.tvHintOperandRight.setText("");
            this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory("0");
        }
    }

    private boolean getAuthRequestContext() {
        return TextUtils.isEmpty(this.tvHintOperator.getText().toString());
    }

    private boolean PlaceComponentResult() {
        return TextUtils.isEmpty(this.tvHintOperandLeft.getText().toString());
    }

    private boolean BuiltInFictitiousFunctionClassFactory() {
        return TextUtils.isEmpty(this.tvHintOperandRight.getText().toString());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static String MyBillsEntityDataFactory(String str) {
        char c;
        str.hashCode();
        switch (str.hashCode()) {
            case -1902665991:
                if (str.equals(OperandType.DIVIDER)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 2459034:
                if (str.equals(OperandType.PLUS)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 73363536:
                if (str.equals(OperandType.MINUS)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1750165953:
                if (str.equals(OperandType.MULTIPLIER)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        return c != 0 ? c != 1 ? c != 2 ? c != 3 ? "" : "×" : "−" : "+" : "÷";
    }

    private static long KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    private boolean BuiltInFictitiousFunctionClassFactory(String str) {
        if (getAuthRequestContext(str)) {
            return !PlaceComponentResult();
        }
        return true;
    }

    private static boolean getAuthRequestContext(String str) {
        return KClassImpl$Data$declaredNonStaticMembers$2(str) == 0;
    }

    private static String BuiltInFictitiousFunctionClassFactory(TextView textView, String str) {
        String charSequence = textView.getText().toString();
        if (TextUtils.isEmpty(charSequence)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence);
        sb.append(str);
        return sb.toString();
    }

    private boolean PlaceComponentResult(String str) {
        return (BuiltInFictitiousFunctionClassFactory() && getAuthRequestContext(str)) ? false : true;
    }

    public void setCalculatorResultListener(CalculatorResultListener calculatorResultListener) {
        this.MyBillsEntityDataFactory = calculatorResultListener;
    }

    private String MyBillsEntityDataFactory() {
        char c;
        long KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(this.tvHintOperandLeft.getText().toString());
        long KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(this.tvHintOperandRight.getText().toString());
        String charSequence = this.tvHintOperator.getText().toString();
        charSequence.hashCode();
        int hashCode = charSequence.hashCode();
        if (hashCode == 43) {
            if (charSequence.equals("+")) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode == 215) {
            if (charSequence.equals("×")) {
                c = 1;
            }
            c = 65535;
        } else if (hashCode != 247) {
            if (hashCode == 8722 && charSequence.equals("−")) {
                c = 3;
            }
            c = 65535;
        } else {
            if (charSequence.equals("÷")) {
                c = 2;
            }
            c = 65535;
        }
        return String.valueOf(Calculator.KClassImpl$Data$declaredNonStaticMembers$2(c != 0 ? c != 1 ? c != 2 ? c != 3 ? "" : OperandType.MINUS : OperandType.DIVIDER : OperandType.MULTIPLIER : OperandType.PLUS).apply(KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$22));
    }
}
