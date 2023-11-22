package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import android.graphics.Paint;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class Legend extends ComponentBase {
    public LegendEntry[] NetworkUserEntityData$$ExternalSyntheticLambda0;
    public LegendEntry[] KClassImpl$Data$declaredNonStaticMembers$2 = new LegendEntry[0];
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda5 = false;
    public LegendHorizontalAlignment initRecordTimeStamp = LegendHorizontalAlignment.LEFT;
    public LegendVerticalAlignment NetworkUserEntityData$$ExternalSyntheticLambda7 = LegendVerticalAlignment.BOTTOM;
    public LegendOrientation DatabaseTableConfigUtil = LegendOrientation.HORIZONTAL;
    private boolean FragmentBottomSheetPaymentSettingBinding = false;
    public LegendDirection BuiltInFictitiousFunctionClassFactory = LegendDirection.LEFT_TO_RIGHT;
    public LegendForm NetworkUserEntityData$$ExternalSyntheticLambda8 = LegendForm.SQUARE;
    public float moveToNextValue = 8.0f;
    public float lookAheadTest = 3.0f;
    public DashPathEffect getErrorConfigVersion = null;
    public float NetworkUserEntityData$$ExternalSyntheticLambda4 = 6.0f;
    public float NetworkUserEntityData$$ExternalSyntheticLambda6 = 0.0f;
    public float scheduleImpl = 5.0f;
    public float newProxyInstance = 3.0f;
    public float GetContactSyncConfig = 0.95f;
    public float NetworkUserEntityData$$ExternalSyntheticLambda2 = 0.0f;
    public float NetworkUserEntityData$$ExternalSyntheticLambda1 = 0.0f;
    public float PrepareContext = 0.0f;
    public float isLayoutRequested = 0.0f;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda3 = false;
    public List<FSize> getAuthRequestContext = new ArrayList(16);
    public List<Boolean> MyBillsEntityDataFactory = new ArrayList(16);
    public List<FSize> PlaceComponentResult = new ArrayList(16);

    /* loaded from: classes3.dex */
    public enum LegendDirection {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT
    }

    /* loaded from: classes3.dex */
    public enum LegendForm {
        NONE,
        EMPTY,
        DEFAULT,
        SQUARE,
        CIRCLE,
        LINE
    }

    /* loaded from: classes3.dex */
    public enum LegendHorizontalAlignment {
        LEFT,
        CENTER,
        RIGHT
    }

    /* loaded from: classes3.dex */
    public enum LegendOrientation {
        HORIZONTAL,
        VERTICAL
    }

    /* loaded from: classes3.dex */
    public enum LegendVerticalAlignment {
        TOP,
        CENTER,
        BOTTOM
    }

    public Legend() {
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = Utils.PlaceComponentResult(10.0f);
        this.C = Utils.PlaceComponentResult(5.0f);
        this.B = Utils.PlaceComponentResult(3.0f);
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda5;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.FragmentBottomSheetPaymentSettingBinding;
    }

    public final void PlaceComponentResult(Paint paint, ViewPortHandler viewPortHandler) {
        float f;
        float f2;
        float f3;
        float f4;
        float PlaceComponentResult = Utils.PlaceComponentResult(this.moveToNextValue);
        float PlaceComponentResult2 = Utils.PlaceComponentResult(this.newProxyInstance);
        float PlaceComponentResult3 = Utils.PlaceComponentResult(this.scheduleImpl);
        float PlaceComponentResult4 = Utils.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
        float PlaceComponentResult5 = Utils.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
        boolean z = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
        LegendEntry[] legendEntryArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int length = legendEntryArr.length;
        float PlaceComponentResult6 = Utils.PlaceComponentResult(this.scheduleImpl);
        float f5 = 0.0f;
        float f6 = 0.0f;
        for (LegendEntry legendEntry : this.KClassImpl$Data$declaredNonStaticMembers$2) {
            float PlaceComponentResult7 = Utils.PlaceComponentResult(Float.isNaN(legendEntry.KClassImpl$Data$declaredNonStaticMembers$2) ? this.moveToNextValue : legendEntry.KClassImpl$Data$declaredNonStaticMembers$2);
            if (PlaceComponentResult7 > f6) {
                f6 = PlaceComponentResult7;
            }
            String str = legendEntry.getErrorConfigVersion;
            if (str != null) {
                float MyBillsEntityDataFactory = Utils.MyBillsEntityDataFactory(paint, str);
                if (MyBillsEntityDataFactory > f5) {
                    f5 = MyBillsEntityDataFactory;
                }
            }
        }
        this.isLayoutRequested = f5 + f6 + PlaceComponentResult6;
        float f7 = 0.0f;
        for (LegendEntry legendEntry2 : this.KClassImpl$Data$declaredNonStaticMembers$2) {
            String str2 = legendEntry2.getErrorConfigVersion;
            if (str2 != null) {
                float authRequestContext = Utils.getAuthRequestContext(paint, str2);
                if (authRequestContext > f7) {
                    f7 = authRequestContext;
                }
            }
        }
        this.PrepareContext = f7;
        int i = AnonymousClass1.KClassImpl$Data$declaredNonStaticMembers$2[this.DatabaseTableConfigUtil.ordinal()];
        if (i == 1) {
            float KClassImpl$Data$declaredNonStaticMembers$2 = Utils.KClassImpl$Data$declaredNonStaticMembers$2(paint);
            float f8 = 0.0f;
            float f9 = 0.0f;
            boolean z2 = false;
            float f10 = 0.0f;
            for (int i2 = 0; i2 < length; i2++) {
                LegendEntry legendEntry3 = legendEntryArr[i2];
                boolean z3 = legendEntry3.BuiltInFictitiousFunctionClassFactory != LegendForm.NONE;
                float PlaceComponentResult8 = Float.isNaN(legendEntry3.KClassImpl$Data$declaredNonStaticMembers$2) ? PlaceComponentResult : Utils.PlaceComponentResult(legendEntry3.KClassImpl$Data$declaredNonStaticMembers$2);
                String str3 = legendEntry3.getErrorConfigVersion;
                if (!z2) {
                    f9 = 0.0f;
                }
                if (z3) {
                    if (z2) {
                        f9 += PlaceComponentResult2;
                    }
                    f9 += PlaceComponentResult8;
                }
                if (str3 != null) {
                    if (z3 && !z2) {
                        f9 += PlaceComponentResult3;
                    } else if (z2) {
                        f8 += KClassImpl$Data$declaredNonStaticMembers$2 + PlaceComponentResult5;
                        f10 = Math.max(f10, f9);
                        f9 = 0.0f;
                        z2 = false;
                    }
                    float MyBillsEntityDataFactory2 = Utils.MyBillsEntityDataFactory(paint, str3);
                    if (i2 < length - 1) {
                        f8 += KClassImpl$Data$declaredNonStaticMembers$2 + PlaceComponentResult5;
                    }
                    f9 += MyBillsEntityDataFactory2;
                } else {
                    f9 += PlaceComponentResult8;
                    if (i2 < length - 1) {
                        f9 += PlaceComponentResult2;
                    }
                    z2 = true;
                }
                f10 = Math.max(f10, f9);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = f10;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = f8;
        } else if (i == 2) {
            float KClassImpl$Data$declaredNonStaticMembers$22 = Utils.KClassImpl$Data$declaredNonStaticMembers$2(paint);
            float authRequestContext2 = Utils.getAuthRequestContext(paint);
            float NetworkUserEntityData$$ExternalSyntheticLambda0 = viewPortHandler.NetworkUserEntityData$$ExternalSyntheticLambda0();
            float f11 = this.GetContactSyncConfig;
            this.MyBillsEntityDataFactory.clear();
            this.getAuthRequestContext.clear();
            this.PlaceComponentResult.clear();
            float f12 = 0.0f;
            int i3 = 0;
            int i4 = -1;
            float f13 = 0.0f;
            float f14 = 0.0f;
            while (i3 < length) {
                float f15 = PlaceComponentResult4;
                LegendEntry legendEntry4 = legendEntryArr[i3];
                LegendEntry[] legendEntryArr2 = legendEntryArr;
                float f16 = PlaceComponentResult5;
                boolean z4 = legendEntry4.BuiltInFictitiousFunctionClassFactory != LegendForm.NONE;
                float PlaceComponentResult9 = Float.isNaN(legendEntry4.KClassImpl$Data$declaredNonStaticMembers$2) ? PlaceComponentResult : Utils.PlaceComponentResult(legendEntry4.KClassImpl$Data$declaredNonStaticMembers$2);
                String str4 = legendEntry4.getErrorConfigVersion;
                float f17 = authRequestContext2;
                float f18 = KClassImpl$Data$declaredNonStaticMembers$22;
                this.MyBillsEntityDataFactory.add(Boolean.FALSE);
                float f19 = i4 == -1 ? 0.0f : f13 + PlaceComponentResult2;
                if (str4 != null) {
                    f = PlaceComponentResult2;
                    this.getAuthRequestContext.add(Utils.PlaceComponentResult(paint, str4));
                    f2 = f19 + (z4 ? PlaceComponentResult3 + PlaceComponentResult9 : 0.0f) + this.getAuthRequestContext.get(i3).PlaceComponentResult;
                } else {
                    f = PlaceComponentResult2;
                    float f20 = PlaceComponentResult9;
                    this.getAuthRequestContext.add(FSize.MyBillsEntityDataFactory(0.0f, 0.0f));
                    f2 = f19 + (!z4 ? 0.0f : f20);
                    if (i4 == -1) {
                        i4 = i3;
                    }
                }
                if (str4 != null || i3 == length - 1) {
                    float f21 = f12 == 0.0f ? 0.0f : f15;
                    if (!z || f12 == 0.0f || (NetworkUserEntityData$$ExternalSyntheticLambda0 * f11) - f12 >= f21 + f2) {
                        f3 = f14;
                        f4 = f18;
                        f12 += f21 + f2;
                    } else {
                        f4 = f18;
                        this.PlaceComponentResult.add(FSize.MyBillsEntityDataFactory(f12, f4));
                        float max = Math.max(f14, f12);
                        this.MyBillsEntityDataFactory.set(i4 >= 0 ? i4 : i3, Boolean.TRUE);
                        f12 = f2;
                        f3 = max;
                    }
                    if (i3 == length - 1) {
                        this.PlaceComponentResult.add(FSize.MyBillsEntityDataFactory(f12, f4));
                        f3 = Math.max(f3, f12);
                    }
                    f14 = f3;
                } else {
                    f4 = f18;
                }
                if (str4 != null) {
                    i4 = -1;
                }
                i3++;
                PlaceComponentResult2 = f;
                PlaceComponentResult4 = f15;
                PlaceComponentResult5 = f16;
                authRequestContext2 = f17;
                f13 = f2;
                KClassImpl$Data$declaredNonStaticMembers$22 = f4;
                legendEntryArr = legendEntryArr2;
            }
            float f22 = PlaceComponentResult5;
            float f23 = KClassImpl$Data$declaredNonStaticMembers$22;
            float f24 = authRequestContext2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = f14;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = (f23 * this.PlaceComponentResult.size()) + ((f24 + f22) * (this.PlaceComponentResult.size() == 0 ? 0 : this.PlaceComponentResult.size() - 1));
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 += this.B;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 += this.C;
    }

    /* renamed from: com.github.mikephil.charting.components.Legend$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[LegendOrientation.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            try {
                iArr[LegendOrientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[LegendOrientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
