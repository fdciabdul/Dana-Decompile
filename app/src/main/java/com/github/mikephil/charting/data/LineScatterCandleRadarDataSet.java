package com.github.mikephil.charting.data;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class LineScatterCandleRadarDataSet<T extends Entry> extends BarLineScatterCandleBubbleDataSet<T> implements ILineScatterCandleRadarDataSet<T> {
    protected DashPathEffect SubSequence;
    protected boolean getCallingPid;
    protected float getSupportButtonTintMode;
    protected boolean whenAvailable;

    public LineScatterCandleRadarDataSet(List<T> list, String str) {
        super(list, str);
        this.getCallingPid = true;
        this.whenAvailable = true;
        this.getSupportButtonTintMode = 0.5f;
        this.SubSequence = null;
        this.getSupportButtonTintMode = Utils.PlaceComponentResult(0.5f);
    }

    public final void M() {
        this.whenAvailable = false;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet
    public final boolean L() {
        return this.getCallingPid;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet
    public final boolean K() {
        return this.whenAvailable;
    }

    public final void J() {
        this.getSupportButtonTintMode = Utils.PlaceComponentResult(64.0f);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet
    public final float H() {
        return this.getSupportButtonTintMode;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet
    public final DashPathEffect G() {
        return this.SubSequence;
    }
}
