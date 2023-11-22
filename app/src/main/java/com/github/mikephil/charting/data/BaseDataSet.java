package com.github.mikephil.charting.data;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class BaseDataSet<T extends Entry> implements IDataSet<T> {
    protected boolean BuiltInFictitiousFunctionClassFactory;
    protected boolean DatabaseTableConfigUtil;
    protected Typeface GetContactSyncConfig;
    protected boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private Legend.LegendForm MyBillsEntityDataFactory;
    protected List<Integer> NetworkUserEntityData$$ExternalSyntheticLambda0;
    protected float NetworkUserEntityData$$ExternalSyntheticLambda1;
    private DashPathEffect NetworkUserEntityData$$ExternalSyntheticLambda2;
    private float NetworkUserEntityData$$ExternalSyntheticLambda7;
    protected List<Integer> PlaceComponentResult;
    private String PrepareContext;
    protected YAxis.AxisDependency getAuthRequestContext;
    protected boolean getErrorConfigVersion;
    protected transient ValueFormatter initRecordTimeStamp;
    private float isLayoutRequested;
    protected List<GradientColor> lookAheadTest;
    protected MPPointF moveToNextValue;
    protected GradientColor scheduleImpl;

    public BaseDataSet() {
        this.PlaceComponentResult = null;
        this.scheduleImpl = null;
        this.lookAheadTest = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        this.PrepareContext = "DataSet";
        this.getAuthRequestContext = YAxis.AxisDependency.LEFT;
        this.getErrorConfigVersion = true;
        this.MyBillsEntityDataFactory = Legend.LegendForm.DEFAULT;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = Float.NaN;
        this.isLayoutRequested = Float.NaN;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
        this.BuiltInFictitiousFunctionClassFactory = true;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        this.moveToNextValue = new MPPointF();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = 17.0f;
        this.DatabaseTableConfigUtil = true;
        this.PlaceComponentResult = new ArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ArrayList();
        this.PlaceComponentResult.add(Integer.valueOf(Color.rgb(140, 234, 255)));
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.add(-16777216);
    }

    public BaseDataSet(String str) {
        this();
        this.PrepareContext = str;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final List<Integer> NetworkUserEntityData$$ExternalSyntheticLambda2() {
        return this.PlaceComponentResult;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final int moveToNextValue() {
        return this.PlaceComponentResult.get(0).intValue();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final int PlaceComponentResult(int i) {
        List<Integer> list = this.PlaceComponentResult;
        return list.get(i % list.size()).intValue();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final GradientColor isLayoutRequested() {
        return this.scheduleImpl;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final List<GradientColor> NetworkUserEntityData$$ExternalSyntheticLambda8() {
        return this.lookAheadTest;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final GradientColor BuiltInFictitiousFunctionClassFactory(int i) {
        List<GradientColor> list = this.lookAheadTest;
        return list.get(i % list.size());
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final String newProxyInstance() {
        return this.PrepareContext;
    }

    public final void readMicros() {
        this.getErrorConfigVersion = false;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda5() {
        return this.getErrorConfigVersion;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final void getAuthRequestContext(ValueFormatter valueFormatter) {
        if (valueFormatter == null) {
            return;
        }
        this.initRecordTimeStamp = valueFormatter;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final ValueFormatter NetworkUserEntityData$$ExternalSyntheticLambda7() {
        ValueFormatter valueFormatter;
        if (getCallingPid()) {
            valueFormatter = Utils.moveToNextValue;
            return valueFormatter;
        }
        return this.initRecordTimeStamp;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final boolean getCallingPid() {
        return this.initRecordTimeStamp == null;
    }

    public final void getSupportButtonTintMode() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = Utils.PlaceComponentResult(0.0f);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final int getAuthRequestContext(int i) {
        List<Integer> list = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        return list.get(i % list.size()).intValue();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final Typeface NetworkUserEntityData$$ExternalSyntheticLambda4() {
        return this.GetContactSyncConfig;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final float NetworkUserEntityData$$ExternalSyntheticLambda3() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final Legend.LegendForm DatabaseTableConfigUtil() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final float GetContactSyncConfig() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda7;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final float initRecordTimeStamp() {
        return this.isLayoutRequested;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final DashPathEffect NetworkUserEntityData$$ExternalSyntheticLambda1() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda6() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final boolean FragmentBottomSheetPaymentSettingBinding() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final MPPointF PrepareContext() {
        return this.moveToNextValue;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final boolean whenAvailable() {
        return this.DatabaseTableConfigUtil;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final YAxis.AxisDependency scheduleImpl() {
        return this.getAuthRequestContext;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        if (this.PlaceComponentResult == null) {
            this.PlaceComponentResult = new ArrayList();
        }
        this.PlaceComponentResult.clear();
        this.PlaceComponentResult.add(Integer.valueOf(i));
    }
}
