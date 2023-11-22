package com.github.mikephil.charting.data;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import com.github.mikephil.charting.formatter.DefaultFillFormatter;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class LineDataSet extends LineRadarDataSet<Entry> implements ILineDataSet {
    private DashPathEffect A;
    private IFillFormatter B;
    private float BottomSheetCardBindingView$watcherCardNumberView$1;
    private boolean C;
    private Mode D;
    public int NetworkUserEntityData$$ExternalSyntheticLambda2;
    public float NetworkUserEntityData$$ExternalSyntheticLambda7;
    private List<Integer> VerifyPinStateManager$executeRiskChallenge$2$1;
    public boolean isLayoutRequested;
    public float newProxyInstance;

    /* loaded from: classes3.dex */
    public enum Mode {
        LINEAR,
        STEPPED,
        CUBIC_BEZIER,
        HORIZONTAL_BEZIER
    }

    public LineDataSet(List<Entry> list, String str) {
        super(list, str);
        this.D = Mode.LINEAR;
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
        this.newProxyInstance = 8.0f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = 4.0f;
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = 0.2f;
        this.A = null;
        this.B = new DefaultFillFormatter();
        this.isLayoutRequested = true;
        this.C = true;
        if (this.VerifyPinStateManager$executeRiskChallenge$2$1 == null) {
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = new ArrayList();
        }
        this.VerifyPinStateManager$executeRiskChallenge$2$1.clear();
        this.VerifyPinStateManager$executeRiskChallenge$2$1.add(Integer.valueOf(Color.rgb(140, 234, 255)));
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public final Mode SubSequence() {
        return this.D;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public final float BuiltInFictitiousFunctionClassFactory() {
        return this.BottomSheetCardBindingView$watcherCardNumberView$1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public final float MyBillsEntityDataFactory() {
        return this.newProxyInstance;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public final float getAuthRequestContext() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda7;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public final boolean A() {
        return this.A != null;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public final DashPathEffect lookAheadTest() {
        return this.A;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public final boolean getValueOfTouchPositionAbsolute() {
        return this.isLayoutRequested;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public final int moveToNextValue(int i) {
        return this.VerifyPinStateManager$executeRiskChallenge$2$1.get(i).intValue();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.VerifyPinStateManager$executeRiskChallenge$2$1.size();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public final int PlaceComponentResult() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public final boolean B() {
        return this.C;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public final IFillFormatter getErrorConfigVersion() {
        return this.B;
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda0(int i) {
        if (this.VerifyPinStateManager$executeRiskChallenge$2$1 == null) {
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = new ArrayList();
        }
        this.VerifyPinStateManager$executeRiskChallenge$2$1.clear();
        this.VerifyPinStateManager$executeRiskChallenge$2$1.add(Integer.valueOf(i));
    }
}
