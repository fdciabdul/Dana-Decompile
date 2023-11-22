package id.dana.component.cellcomponent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import id.dana.component.BaseRichView;
import id.dana.component.R;

/* loaded from: classes4.dex */
public class DanaStepperView extends BaseRichView {
    private int PlaceComponentResult;
    LinearLayout btnMinus;
    LinearLayout btnPlus;
    TextView textCounter;

    public DanaStepperView(Context context) {
        super(context);
        this.PlaceComponentResult = 0;
    }

    public DanaStepperView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.PlaceComponentResult = 0;
    }

    public DanaStepperView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.PlaceComponentResult = 0;
    }

    @Override // id.dana.component.BaseRichView
    public int getLayout() {
        return R.layout.view_dana_stepper;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$btnPressed$0$id-dana-component-cellcomponent-DanaStepperView  reason: not valid java name */
    public /* synthetic */ void m608x31e61904(View view) {
        plusCounter();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$btnPressed$1$id-dana-component-cellcomponent-DanaStepperView  reason: not valid java name */
    public /* synthetic */ void m609x316fb305(View view) {
        minusCounter();
    }

    void plusCounter() {
        int i = this.PlaceComponentResult + 1;
        this.PlaceComponentResult = i;
        this.textCounter.setText(Integer.toString(i));
    }

    void minusCounter() {
        int i = this.PlaceComponentResult - 1;
        this.PlaceComponentResult = i;
        this.textCounter.setText(Integer.toString(i));
    }

    @Override // id.dana.component.BaseRichView
    public void setup() {
        this.btnMinus = (LinearLayout) getRootView().findViewById(R.id.res_0x7f0a0d88_verifypinstatemanager_executeriskchallenge_2_1);
        this.btnPlus = (LinearLayout) getRootView().findViewById(R.id.ll_button_plus);
        this.textCounter = (TextView) getRootView().findViewById(R.id.tv_text_counter);
        this.btnPlus.setOnClickListener(new View.OnClickListener() { // from class: id.dana.component.cellcomponent.DanaStepperView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DanaStepperView.this.m608x31e61904(view);
            }
        });
        this.btnMinus.setOnClickListener(new View.OnClickListener() { // from class: id.dana.component.cellcomponent.DanaStepperView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DanaStepperView.this.m609x316fb305(view);
            }
        });
    }
}
