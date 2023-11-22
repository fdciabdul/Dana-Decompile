package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis;

/* loaded from: classes3.dex */
public class Highlight {
    public float BuiltInFictitiousFunctionClassFactory;
    public YAxis.AxisDependency KClassImpl$Data$declaredNonStaticMembers$2;
    public int MyBillsEntityDataFactory;
    public float NetworkUserEntityData$$ExternalSyntheticLambda0;
    public float PlaceComponentResult;
    public int getAuthRequestContext;
    public int getErrorConfigVersion;
    public float lookAheadTest;
    public float moveToNextValue;
    public float scheduleImpl;

    public Highlight(float f, float f2, int i) {
        this.getAuthRequestContext = -1;
        this.getErrorConfigVersion = -1;
        this.moveToNextValue = f;
        this.lookAheadTest = f2;
        this.MyBillsEntityDataFactory = i;
    }

    public Highlight(float f, int i, int i2) {
        this(f, Float.NaN, i);
        this.getErrorConfigVersion = i2;
    }

    public Highlight(float f, float f2, float f3, float f4, int i, YAxis.AxisDependency axisDependency) {
        this.getAuthRequestContext = -1;
        this.getErrorConfigVersion = -1;
        this.moveToNextValue = f;
        this.lookAheadTest = f2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = f3;
        this.scheduleImpl = f4;
        this.MyBillsEntityDataFactory = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = axisDependency;
    }

    public Highlight(float f, float f2, float f3, float f4, int i, int i2, YAxis.AxisDependency axisDependency) {
        this(f, f2, f3, f4, i, axisDependency);
        this.getErrorConfigVersion = i2;
    }

    public final boolean getAuthRequestContext(Highlight highlight) {
        return highlight != null && this.MyBillsEntityDataFactory == highlight.MyBillsEntityDataFactory && this.moveToNextValue == highlight.moveToNextValue && this.getErrorConfigVersion == highlight.getErrorConfigVersion && this.getAuthRequestContext == highlight.getAuthRequestContext;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Highlight, x: ");
        sb.append(this.moveToNextValue);
        sb.append(", y: ");
        sb.append(this.lookAheadTest);
        sb.append(", dataSetIndex: ");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", stackIndex (only stacked barentry): ");
        sb.append(this.getErrorConfigVersion);
        return sb.toString();
    }
}
