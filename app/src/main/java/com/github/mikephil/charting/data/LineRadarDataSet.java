package com.github.mikephil.charting.data;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class LineRadarDataSet<T extends Entry> extends LineScatterCandleRadarDataSet<T> implements ILineRadarDataSet<T> {
    private int NetworkUserEntityData$$ExternalSyntheticLambda2;
    protected Drawable NetworkUserEntityData$$ExternalSyntheticLambda8;
    public boolean PrepareContext;
    private int newProxyInstance;
    public float readMicros;

    public LineRadarDataSet(List<T> list, String str) {
        super(list, str);
        this.newProxyInstance = Color.rgb(140, 234, 255);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 85;
        this.readMicros = 2.5f;
        this.PrepareContext = false;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet
    public final int VerifyPinStateManager$executeRiskChallenge$2$2() {
        return this.newProxyInstance;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet
    public final Drawable I() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda8;
    }

    public final void PlaceComponentResult(Drawable drawable) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = drawable;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet
    public final int E() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet
    public final float F() {
        return this.readMicros;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet
    public final boolean AppCompatEmojiTextHelper() {
        return this.PrepareContext;
    }
}
