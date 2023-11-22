package com.airbnb.lottie.model;

/* loaded from: classes3.dex */
public class DocumentData {
    public int BuiltInFictitiousFunctionClassFactory;
    public int GetContactSyncConfig;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public float MyBillsEntityDataFactory;
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;
    public float PlaceComponentResult;
    public Justification getAuthRequestContext;
    public boolean getErrorConfigVersion;
    public float lookAheadTest;
    public int moveToNextValue;
    public float scheduleImpl;

    /* loaded from: classes3.dex */
    public enum Justification {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData(String str, String str2, float f, Justification justification, int i, float f2, float f3, int i2, int i3, float f4, boolean z) {
        PlaceComponentResult(str, str2, f, justification, i, f2, f3, i2, i3, f4, z);
    }

    public DocumentData() {
    }

    public final void PlaceComponentResult(String str, String str2, float f, Justification justification, int i, float f2, float f3, int i2, int i3, float f4, boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        this.lookAheadTest = f;
        this.getAuthRequestContext = justification;
        this.GetContactSyncConfig = i;
        this.MyBillsEntityDataFactory = f2;
        this.PlaceComponentResult = f3;
        this.BuiltInFictitiousFunctionClassFactory = i2;
        this.moveToNextValue = i3;
        this.scheduleImpl = f4;
        this.getErrorConfigVersion = z;
    }

    public int hashCode() {
        int hashCode = (int) ((((this.NetworkUserEntityData$$ExternalSyntheticLambda0.hashCode() * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode()) * 31) + this.lookAheadTest);
        int ordinal = this.getAuthRequestContext.ordinal();
        int i = this.GetContactSyncConfig;
        long floatToRawIntBits = Float.floatToRawIntBits(this.MyBillsEntityDataFactory);
        return (((((((hashCode * 31) + ordinal) * 31) + i) * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.BuiltInFictitiousFunctionClassFactory;
    }
}
