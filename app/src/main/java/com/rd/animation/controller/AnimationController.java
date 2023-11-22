package com.rd.animation.controller;

import com.rd.animation.controller.ValueController;
import com.rd.animation.type.AnimationType;
import com.rd.animation.type.BaseAnimation;
import com.rd.animation.type.ColorAnimation;
import com.rd.animation.type.DropAnimation;
import com.rd.animation.type.FillAnimation;
import com.rd.animation.type.ScaleAnimation;
import com.rd.animation.type.ScaleDownAnimation;
import com.rd.animation.type.SlideAnimation;
import com.rd.animation.type.SwapAnimation;
import com.rd.animation.type.ThinWormAnimation;
import com.rd.animation.type.WormAnimation;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;
import com.rd.utils.CoordinatesUtils;

/* loaded from: classes3.dex */
public class AnimationController {
    private Indicator BuiltInFictitiousFunctionClassFactory;
    private ValueController.UpdateListener KClassImpl$Data$declaredNonStaticMembers$2;
    public boolean MyBillsEntityDataFactory;
    public BaseAnimation PlaceComponentResult;
    public float getAuthRequestContext;
    private ValueController moveToNextValue;

    public AnimationController(Indicator indicator, ValueController.UpdateListener updateListener) {
        this.moveToNextValue = new ValueController(updateListener);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = updateListener;
        this.BuiltInFictitiousFunctionClassFactory = indicator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rd.animation.controller.AnimationController$1 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[AnimationType.values().length];
            MyBillsEntityDataFactory = iArr;
            try {
                iArr[AnimationType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MyBillsEntityDataFactory[AnimationType.COLOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                MyBillsEntityDataFactory[AnimationType.SCALE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                MyBillsEntityDataFactory[AnimationType.WORM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                MyBillsEntityDataFactory[AnimationType.FILL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                MyBillsEntityDataFactory[AnimationType.SLIDE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                MyBillsEntityDataFactory[AnimationType.THIN_WORM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                MyBillsEntityDataFactory[AnimationType.DROP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                MyBillsEntityDataFactory[AnimationType.SWAP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                MyBillsEntityDataFactory[AnimationType.SCALE_DOWN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        Indicator indicator = this.BuiltInFictitiousFunctionClassFactory;
        if (indicator.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            indicator.KClassImpl$Data$declaredNonStaticMembers$2 = AnimationType.NONE;
        }
        switch (AnonymousClass1.MyBillsEntityDataFactory[indicator.KClassImpl$Data$declaredNonStaticMembers$2.ordinal()]) {
            case 1:
                this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(null);
                return;
            case 2:
                KClassImpl$Data$declaredNonStaticMembers$2();
                return;
            case 3:
                PlaceComponentResult();
                return;
            case 4:
                moveToNextValue();
                return;
            case 5:
                MyBillsEntityDataFactory();
                return;
            case 6:
                getErrorConfigVersion();
                return;
            case 7:
                NetworkUserEntityData$$ExternalSyntheticLambda0();
                return;
            case 8:
                getAuthRequestContext();
                return;
            case 9:
                lookAheadTest();
                return;
            case 10:
                scheduleImpl();
                return;
            default:
                return;
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2() {
        int i = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda6;
        int i2 = this.BuiltInFictitiousFunctionClassFactory.FragmentBottomSheetPaymentSettingBinding;
        long j = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
        ValueController valueController = this.moveToNextValue;
        if (valueController.getAuthRequestContext == null) {
            valueController.getAuthRequestContext = new ColorAnimation(valueController.moveToNextValue);
        }
        BaseAnimation MyBillsEntityDataFactory = valueController.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(i2, i).MyBillsEntityDataFactory(j);
        if (this.MyBillsEntityDataFactory) {
            MyBillsEntityDataFactory.getAuthRequestContext(this.getAuthRequestContext);
        } else {
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
        }
        this.PlaceComponentResult = MyBillsEntityDataFactory;
    }

    private void PlaceComponentResult() {
        int i = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda6;
        int i2 = this.BuiltInFictitiousFunctionClassFactory.FragmentBottomSheetPaymentSettingBinding;
        int i3 = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda8;
        float f = this.BuiltInFictitiousFunctionClassFactory.PrepareContext;
        long j = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
        ValueController valueController = this.moveToNextValue;
        if (valueController.PlaceComponentResult == null) {
            valueController.PlaceComponentResult = new ScaleAnimation(valueController.moveToNextValue);
        }
        BaseAnimation MyBillsEntityDataFactory = valueController.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(i2, i, i3, f).MyBillsEntityDataFactory(j);
        if (this.MyBillsEntityDataFactory) {
            MyBillsEntityDataFactory.getAuthRequestContext(this.getAuthRequestContext);
        } else {
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
        }
        this.PlaceComponentResult = MyBillsEntityDataFactory;
    }

    private void moveToNextValue() {
        int i;
        int i2;
        if (this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult()) {
            i = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda4;
        } else {
            i = this.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil;
        }
        if (this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult()) {
            i2 = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda3;
        } else {
            i2 = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda4;
        }
        int authRequestContext = CoordinatesUtils.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, i);
        int authRequestContext2 = CoordinatesUtils.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, i2);
        boolean z = i2 > i;
        int i3 = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda8;
        long j = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
        ValueController valueController = this.moveToNextValue;
        if (valueController.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
            valueController.NetworkUserEntityData$$ExternalSyntheticLambda0 = new WormAnimation(valueController.moveToNextValue);
        }
        WormAnimation MyBillsEntityDataFactory = valueController.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory(authRequestContext, authRequestContext2, i3, z).MyBillsEntityDataFactory(j);
        if (this.MyBillsEntityDataFactory) {
            MyBillsEntityDataFactory.getAuthRequestContext(this.getAuthRequestContext);
        } else {
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
        }
        this.PlaceComponentResult = MyBillsEntityDataFactory;
    }

    private void getErrorConfigVersion() {
        int i;
        int i2;
        if (this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult()) {
            i = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda4;
        } else {
            i = this.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil;
        }
        if (this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult()) {
            i2 = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda3;
        } else {
            i2 = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda4;
        }
        int authRequestContext = CoordinatesUtils.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, i);
        int authRequestContext2 = CoordinatesUtils.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, i2);
        long j = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
        ValueController valueController = this.moveToNextValue;
        if (valueController.getErrorConfigVersion == null) {
            valueController.getErrorConfigVersion = new SlideAnimation(valueController.moveToNextValue);
        }
        BaseAnimation MyBillsEntityDataFactory = valueController.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory(authRequestContext, authRequestContext2).MyBillsEntityDataFactory(j);
        if (this.MyBillsEntityDataFactory) {
            MyBillsEntityDataFactory.getAuthRequestContext(this.getAuthRequestContext);
        } else {
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
        }
        this.PlaceComponentResult = MyBillsEntityDataFactory;
    }

    private void MyBillsEntityDataFactory() {
        int i = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda6;
        int i2 = this.BuiltInFictitiousFunctionClassFactory.FragmentBottomSheetPaymentSettingBinding;
        int i3 = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda8;
        int i4 = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda5;
        long j = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
        ValueController valueController = this.moveToNextValue;
        if (valueController.MyBillsEntityDataFactory == null) {
            valueController.MyBillsEntityDataFactory = new FillAnimation(valueController.moveToNextValue);
        }
        BaseAnimation MyBillsEntityDataFactory = valueController.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(i2, i, i3, i4).MyBillsEntityDataFactory(j);
        if (this.MyBillsEntityDataFactory) {
            MyBillsEntityDataFactory.getAuthRequestContext(this.getAuthRequestContext);
        } else {
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
        }
        this.PlaceComponentResult = MyBillsEntityDataFactory;
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        int i;
        int i2;
        if (this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult()) {
            i = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda4;
        } else {
            i = this.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil;
        }
        if (this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult()) {
            i2 = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda3;
        } else {
            i2 = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda4;
        }
        int authRequestContext = CoordinatesUtils.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, i);
        int authRequestContext2 = CoordinatesUtils.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, i2);
        boolean z = i2 > i;
        int i3 = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda8;
        long j = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
        ValueController valueController = this.moveToNextValue;
        if (valueController.scheduleImpl == null) {
            valueController.scheduleImpl = new ThinWormAnimation(valueController.moveToNextValue);
        }
        WormAnimation MyBillsEntityDataFactory = valueController.scheduleImpl.BuiltInFictitiousFunctionClassFactory(authRequestContext, authRequestContext2, i3, z).MyBillsEntityDataFactory(j);
        if (this.MyBillsEntityDataFactory) {
            MyBillsEntityDataFactory.getAuthRequestContext(this.getAuthRequestContext);
        } else {
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
        }
        this.PlaceComponentResult = MyBillsEntityDataFactory;
    }

    private void getAuthRequestContext() {
        int i;
        int i2;
        if (this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult()) {
            i = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda4;
        } else {
            i = this.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil;
        }
        if (this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult()) {
            i2 = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda3;
        } else {
            i2 = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda4;
        }
        int authRequestContext = CoordinatesUtils.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, i);
        int authRequestContext2 = CoordinatesUtils.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, i2);
        int i3 = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda7;
        int i4 = this.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp;
        Indicator indicator = this.BuiltInFictitiousFunctionClassFactory;
        if (indicator.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
            indicator.NetworkUserEntityData$$ExternalSyntheticLambda2 = Orientation.HORIZONTAL;
        }
        if (indicator.NetworkUserEntityData$$ExternalSyntheticLambda2 != Orientation.HORIZONTAL) {
            i3 = i4;
        }
        int i5 = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda8;
        long j = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
        ValueController valueController = this.moveToNextValue;
        if (valueController.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            valueController.KClassImpl$Data$declaredNonStaticMembers$2 = new DropAnimation(valueController.moveToNextValue);
        }
        DropAnimation KClassImpl$Data$declaredNonStaticMembers$2 = valueController.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(j).KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, authRequestContext2, (i5 * 3) + i3, i5 + i3, i5);
        if (this.MyBillsEntityDataFactory) {
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(this.getAuthRequestContext);
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
        }
        this.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2;
    }

    private void lookAheadTest() {
        int i;
        int i2;
        if (this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult()) {
            i = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda4;
        } else {
            i = this.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil;
        }
        if (this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult()) {
            i2 = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda3;
        } else {
            i2 = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda4;
        }
        int authRequestContext = CoordinatesUtils.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, i);
        int authRequestContext2 = CoordinatesUtils.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, i2);
        long j = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
        ValueController valueController = this.moveToNextValue;
        if (valueController.lookAheadTest == null) {
            valueController.lookAheadTest = new SwapAnimation(valueController.moveToNextValue);
        }
        BaseAnimation MyBillsEntityDataFactory = valueController.lookAheadTest.BuiltInFictitiousFunctionClassFactory(authRequestContext, authRequestContext2).MyBillsEntityDataFactory(j);
        if (this.MyBillsEntityDataFactory) {
            MyBillsEntityDataFactory.getAuthRequestContext(this.getAuthRequestContext);
        } else {
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
        }
        this.PlaceComponentResult = MyBillsEntityDataFactory;
    }

    private void scheduleImpl() {
        int i = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda6;
        int i2 = this.BuiltInFictitiousFunctionClassFactory.FragmentBottomSheetPaymentSettingBinding;
        int i3 = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda8;
        float f = this.BuiltInFictitiousFunctionClassFactory.PrepareContext;
        long j = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
        ValueController valueController = this.moveToNextValue;
        if (valueController.BuiltInFictitiousFunctionClassFactory == null) {
            valueController.BuiltInFictitiousFunctionClassFactory = new ScaleDownAnimation(valueController.moveToNextValue);
        }
        BaseAnimation MyBillsEntityDataFactory = valueController.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(i2, i, i3, f).MyBillsEntityDataFactory(j);
        if (this.MyBillsEntityDataFactory) {
            MyBillsEntityDataFactory.getAuthRequestContext(this.getAuthRequestContext);
        } else {
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
        }
        this.PlaceComponentResult = MyBillsEntityDataFactory;
    }
}
