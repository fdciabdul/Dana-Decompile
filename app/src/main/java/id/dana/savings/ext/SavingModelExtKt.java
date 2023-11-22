package id.dana.savings.ext;

import id.dana.savings.model.SavingCategoryModel;
import id.dana.savings.model.SavingModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\t\u001a\u00020\b*\u00020\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0011\u0010\u000b\u001a\u00020\u0005*\u00020\u0000¢\u0006\u0004\b\u000b\u0010\u0007\u001a\u0011\u0010\r\u001a\u00020\f*\u00020\u0000¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/savings/model/SavingModel;", "", "PlaceComponentResult", "(Lid/dana/savings/model/SavingModel;)D", "getAuthRequestContext", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/savings/model/SavingModel;)Ljava/lang/String;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/savings/model/SavingModel;)I", "MyBillsEntityDataFactory", "", "lookAheadTest", "(Lid/dana/savings/model/SavingModel;)Z"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SavingModelExtKt {
    public static final int KClassImpl$Data$declaredNonStaticMembers$2(SavingModel savingModel) {
        Intrinsics.checkNotNullParameter(savingModel, "");
        Intrinsics.checkNotNullParameter(savingModel, "");
        int roundToInt = MathKt.roundToInt((savingModel.lookAheadTest.BuiltInFictitiousFunctionClassFactory() * 100) / savingModel.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory());
        if (roundToInt == 100) {
            return 5;
        }
        boolean z = false;
        if (76 <= roundToInt && roundToInt < 100) {
            return 4;
        }
        if (51 <= roundToInt && roundToInt < 76) {
            return 3;
        }
        if (26 <= roundToInt && roundToInt < 51) {
            z = true;
        }
        return z ? 2 : 1;
    }

    public static final String BuiltInFictitiousFunctionClassFactory(SavingModel savingModel) {
        String BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(savingModel, "");
        if (lookAheadTest(savingModel)) {
            SavingCategoryModel savingCategoryModel = savingModel.BuiltInFictitiousFunctionClassFactory;
            if (savingCategoryModel != null) {
                BuiltInFictitiousFunctionClassFactory = savingCategoryModel.scheduleImpl;
            }
            BuiltInFictitiousFunctionClassFactory = null;
        } else {
            SavingCategoryModel savingCategoryModel2 = savingModel.BuiltInFictitiousFunctionClassFactory;
            if (savingCategoryModel2 != null) {
                BuiltInFictitiousFunctionClassFactory = savingCategoryModel2.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2(savingModel));
            }
            BuiltInFictitiousFunctionClassFactory = null;
        }
        return BuiltInFictitiousFunctionClassFactory == null ? "" : BuiltInFictitiousFunctionClassFactory;
    }

    public static final double PlaceComponentResult(SavingModel savingModel) {
        Intrinsics.checkNotNullParameter(savingModel, "");
        return (savingModel.lookAheadTest.BuiltInFictitiousFunctionClassFactory() * 100) / savingModel.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory();
    }

    public static final double getAuthRequestContext(SavingModel savingModel) {
        Intrinsics.checkNotNullParameter(savingModel, "");
        if (savingModel.lookAheadTest.BuiltInFictitiousFunctionClassFactory() <= 0) {
            return 1.0d;
        }
        Intrinsics.checkNotNullParameter(savingModel, "");
        return (savingModel.lookAheadTest.BuiltInFictitiousFunctionClassFactory() * 100) / savingModel.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory();
    }

    public static final String MyBillsEntityDataFactory(SavingModel savingModel) {
        Intrinsics.checkNotNullParameter(savingModel, "");
        long BuiltInFictitiousFunctionClassFactory = savingModel.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory();
        if (BuiltInFictitiousFunctionClassFactory == 10000000) {
            return "5";
        }
        if (7600000 <= BuiltInFictitiousFunctionClassFactory && BuiltInFictitiousFunctionClassFactory < 10000000) {
            return "4";
        }
        if (5100000 <= BuiltInFictitiousFunctionClassFactory && BuiltInFictitiousFunctionClassFactory < 7600000) {
            return "3";
        }
        return 2600000 <= BuiltInFictitiousFunctionClassFactory && BuiltInFictitiousFunctionClassFactory < 5100000 ? "2" : "1";
    }

    public static final boolean lookAheadTest(SavingModel savingModel) {
        Intrinsics.checkNotNullParameter(savingModel, "");
        return Intrinsics.areEqual(savingModel.DatabaseTableConfigUtil.PlaceComponentResult, savingModel.lookAheadTest.PlaceComponentResult);
    }
}
