package id.dana.richview.calculator;

/* loaded from: classes5.dex */
public interface CalculatorPadItemListener {
    void onClearAll();

    void onClearByCharacter();

    void onOperatorClicked(String str);

    void onPadClicked(String str);
}
