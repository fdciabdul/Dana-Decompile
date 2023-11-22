package id.dana.challenge.pin;

import android.app.Activity;
import android.os.Bundle;
import id.dana.base.AbstractContract;
import id.dana.cardbinding.model.CashierPayParamModel;
import id.dana.cashier.model.CashierPayModel;
import id.dana.model.Trust2RiskLoginModel;
import java.util.List;

/* loaded from: classes4.dex */
public interface AbstractPinContract {

    /* loaded from: classes4.dex */
    public interface CardBindingPinPresenter extends Presenter {
        void BuiltInFictitiousFunctionClassFactory(CashierPayParamModel cashierPayParamModel);

        void KClassImpl$Data$declaredNonStaticMembers$2(CashierPayParamModel cashierPayParamModel);
    }

    /* loaded from: classes4.dex */
    public interface FamilyAccountPinPresenter extends Presenter {
        void MyBillsEntityDataFactory(String str, String str2, String str3);

        void PlaceComponentResult(String str, String str2, String str3);

        void getAuthRequestContext(String str, String str2);

        void getAuthRequestContext(String str, String str2, String str3, String str4, String str5, String str6);
    }

    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {

        /* renamed from: id.dana.challenge.pin.AbstractPinContract$Presenter$-CC  reason: invalid class name */
        /* loaded from: classes4.dex */
        public final /* synthetic */ class CC {
            public static void BuiltInFictitiousFunctionClassFactory() {
            }

            public static void KClassImpl$Data$declaredNonStaticMembers$2() {
            }

            public static void MyBillsEntityDataFactory() {
            }

            public static void NetworkUserEntityData$$ExternalSyntheticLambda0() {
            }

            public static void PlaceComponentResult() {
            }

            public static void getAuthRequestContext() {
            }

            public static void getErrorConfigVersion() {
            }

            public static void moveToNextValue() {
            }
        }

        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(String str);

        void BuiltInFictitiousFunctionClassFactory(String str, Bundle bundle);

        void KClassImpl$Data$declaredNonStaticMembers$2(Trust2RiskLoginModel trust2RiskLoginModel);

        void KClassImpl$Data$declaredNonStaticMembers$2(String str);

        void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2);

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(String str, String str2);

        void MyBillsEntityDataFactory(String str, String str2, String str3, String str4);

        void PlaceComponentResult();

        void PlaceComponentResult(String str, String str2, boolean z, String str3, String str4);

        void getAuthRequestContext(String str);

        void getAuthRequestContext(String str, String str2, String str3, Boolean bool, Activity activity);

        void getAuthRequestContext(String str, String str2, String str3, boolean z);

        void getAuthRequestContext(String str, String str2, boolean z, boolean z2);

        void getAuthRequestContext(String str, boolean z);
    }

    /* loaded from: classes4.dex */
    public interface View extends AbstractContract.AbstractView {

        /* renamed from: id.dana.challenge.pin.AbstractPinContract$View$-CC  reason: invalid class name */
        /* loaded from: classes4.dex */
        public final /* synthetic */ class CC {
            public static void MyBillsEntityDataFactory() {
            }

            public static void PlaceComponentResult() {
            }

            public static void getAuthRequestContext() {
            }
        }

        void BuiltInFictitiousFunctionClassFactory(CashierPayModel cashierPayModel, boolean z);

        void BuiltInFictitiousFunctionClassFactory(List<String> list);

        void BuiltInFictitiousFunctionClassFactory(boolean z);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(long j);

        void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, Integer num, String str3, Integer num2);

        void KClassImpl$Data$declaredNonStaticMembers$2(boolean z);

        void MyBillsEntityDataFactory(String str, String str2);

        void MyBillsEntityDataFactory(String str, String str2, Integer num, String str3);

        void PlaceComponentResult();

        void PlaceComponentResult(int i);

        void getAuthRequestContext();
    }
}
