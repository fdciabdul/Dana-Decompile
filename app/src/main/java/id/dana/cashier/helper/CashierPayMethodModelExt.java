package id.dana.cashier.helper;

import id.dana.cashier.model.AssetCardModel;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.CashierPayMethodModelKt;
import id.dana.cashier.model.QueryInstallmentModel;
import id.dana.data.util.NumberUtils;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b-\u0010.J!\u0010\u0007\u001a\u00020\u0006*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u0006*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u0006*\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000b\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u000b\u0010\rJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u0003*\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u0003*\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u0003*\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0007\u0010\u000fJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u0003*\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u0013\u0010\u000e\u001a\u00020\u0006*\u00020\u0012H\u0002¢\u0006\u0004\b\u000e\u0010\u0013J\u0013\u0010\u0015\u001a\u00020\u0006*\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\t\u001a\u00020\u0006*\u00020\u0012H\u0002¢\u0006\u0004\b\t\u0010\u0013J\u001b\u0010\u0007\u001a\u00020\u0006*\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\u0017J\u001b\u0010\u000e\u001a\u00020\u0006*\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u0018J\u001f\u0010\u000e\u001a\u00020\u0006*\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u000e\u0010\u0019J\u0011\u0010\u0010\u001a\u00020\u0006*\u00020\u0012¢\u0006\u0004\b\u0010\u0010\u0013J\u0011\u0010\u0007\u001a\u00020\u0006*\u00020\u001a¢\u0006\u0004\b\u0007\u0010\u001bJ\u0011\u0010\u000b\u001a\u00020\u0006*\u00020\u0012¢\u0006\u0004\b\u000b\u0010\u0013J\u0013\u0010\u0007\u001a\u00020\u0006*\u00020\u0012H\u0002¢\u0006\u0004\b\u0007\u0010\u0013J\u0011\u0010\u000e\u001a\u00020\u0006*\u00020\u001c¢\u0006\u0004\b\u000e\u0010\u001dJ\u0011\u0010\u000b\u001a\u00020\u0006*\u00020\u0014¢\u0006\u0004\b\u000b\u0010\u0016J\u0011\u0010\u0010\u001a\u00020\u0006*\u00020\u0014¢\u0006\u0004\b\u0010\u0010\u0016J\u0011\u0010\u000e\u001a\u00020\u0006*\u00020\u0014¢\u0006\u0004\b\u000e\u0010\u0016J\u001b\u0010\u0010\u001a\u00020\u0006*\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\fJ\u0011\u0010\u0007\u001a\u00020\u0006*\u00020\u0014¢\u0006\u0004\b\u0007\u0010\u0016J\u0011\u0010\t\u001a\u00020\u0006*\u00020\u0014¢\u0006\u0004\b\t\u0010\u0016J\u0011\u0010\u0011\u001a\u00020\u0006*\u00020\u0014¢\u0006\u0004\b\u0011\u0010\u0016JU\u0010\u0010\u001a\u00020\u001f*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0018\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u001f0\u001e2\u0018\u0010 \u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u001f0\u001e2\b\u0010!\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\"Jw\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001e2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001e2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001e2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001e2\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b\u000e\u0010&J\u001f\u0010\u0007\u001a\u00020\u001f*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010'JY\u0010\u0010\u001a\u00020\u001f*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0(2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001f0(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001f0(¢\u0006\u0004\b\u0010\u0010*J7\u0010\u0007\u001a\u00020\u001f*\b\u0012\u0004\u0012\u00020\u00030\u00022\u001e\u0010\u0005\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001f0+¢\u0006\u0004\b\u0007\u0010,"}, d2 = {"Lid/dana/cashier/helper/CashierPayMethodModelExt;", "", "", "Lid/dana/cashier/model/CashierPayMethodModel;", "", "p0", "", "PlaceComponentResult", "(Ljava/util/List;Ljava/lang/String;)Z", "MyBillsEntityDataFactory", "(Ljava/util/List;)Z", "getAuthRequestContext", "(Lid/dana/cashier/model/CashierPayMethodModel;Lid/dana/cashier/model/CashierPayMethodModel;)Z", "(Ljava/util/List;)Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;)Lid/dana/cashier/model/CashierPayMethodModel;", "BuiltInFictitiousFunctionClassFactory", "getErrorConfigVersion", "Lid/dana/cashier/model/CashierPayMethodModel$BalancePayMethod;", "(Lid/dana/cashier/model/CashierPayMethodModel$BalancePayMethod;)Z", "Lid/dana/cashier/model/CashierPayMethodModel$PaylaterPayMethod;", "scheduleImpl", "(Lid/dana/cashier/model/CashierPayMethodModel$PaylaterPayMethod;)Z", "(Lid/dana/cashier/model/CashierPayMethodModel;Z)Z", "(Lid/dana/cashier/model/CashierPayMethodModel;Ljava/lang/String;)Z", "(Lid/dana/cashier/model/CashierPayMethodModel;Ljava/util/List;)Z", "Lid/dana/cashier/model/CashierPayMethodModel$DanaPlusPayMethod;", "(Lid/dana/cashier/model/CashierPayMethodModel$DanaPlusPayMethod;)Z", "Lid/dana/cashier/model/CashierPayMethodModel$BalanceFamilyPayMethod;", "(Lid/dana/cashier/model/CashierPayMethodModel$BalanceFamilyPayMethod;)Z", "Lkotlin/Function1;", "", "p1", "p2", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lid/dana/cashier/model/CashierPayMethodModel;)V", "p3", "Lid/dana/cashier/model/QueryInstallmentModel;", "p4", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lid/dana/cashier/model/QueryInstallmentModel;)Ljava/util/List;", "(Ljava/util/List;Lid/dana/cashier/model/CashierPayMethodModel;)V", "Lkotlin/Function0;", "p5", "(Ljava/util/List;ZZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function2;", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierPayMethodModelExt {
    public static final CashierPayMethodModelExt INSTANCE = new CashierPayMethodModelExt();

    private CashierPayMethodModelExt() {
    }

    public static boolean BuiltInFictitiousFunctionClassFactory(CashierPayMethodModel.BalancePayMethod balancePayMethod) {
        Intrinsics.checkNotNullParameter(balancePayMethod, "");
        return KClassImpl$Data$declaredNonStaticMembers$2(balancePayMethod) || PlaceComponentResult(balancePayMethod);
    }

    public static boolean getAuthRequestContext(CashierPayMethodModel.BalancePayMethod balancePayMethod) {
        Intrinsics.checkNotNullParameter(balancePayMethod, "");
        return MyBillsEntityDataFactory(balancePayMethod);
    }

    public static boolean BuiltInFictitiousFunctionClassFactory(CashierPayMethodModel.PaylaterPayMethod paylaterPayMethod) {
        Intrinsics.checkNotNullParameter(paylaterPayMethod, "");
        return scheduleImpl(paylaterPayMethod);
    }

    public static boolean BuiltInFictitiousFunctionClassFactory(CashierPayMethodModel cashierPayMethodModel, CashierPayMethodModel cashierPayMethodModel2) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        if (CashierPayMethodModelKt.NetworkUserEntityData$$ExternalSyntheticLambda6(cashierPayMethodModel) && CashierPayMethodModelKt.NetworkUserEntityData$$ExternalSyntheticLambda6(cashierPayMethodModel2)) {
            if (Intrinsics.areEqual(cashierPayMethodModel2 != null ? cashierPayMethodModel2.initRecordTimeStamp() : null, cashierPayMethodModel.initRecordTimeStamp())) {
                return true;
            }
        }
        return false;
    }

    public static boolean getAuthRequestContext(CashierPayMethodModel cashierPayMethodModel, CashierPayMethodModel cashierPayMethodModel2) {
        if (!(cashierPayMethodModel2 != null && CashierPayMethodModelKt.getSupportButtonTintMode(cashierPayMethodModel2))) {
            if (!(cashierPayMethodModel != null && CashierPayMethodModelKt.getSupportButtonTintMode(cashierPayMethodModel)) && !CashierPayMethodModelKt.NetworkUserEntityData$$ExternalSyntheticLambda6(cashierPayMethodModel2) && !CashierPayMethodModelKt.NetworkUserEntityData$$ExternalSyntheticLambda6(cashierPayMethodModel)) {
                return false;
            }
        }
        return true;
    }

    public static boolean PlaceComponentResult(CashierPayMethodModel cashierPayMethodModel, boolean z) {
        return z && CashierPayMethodModelKt.NetworkUserEntityData$$ExternalSyntheticLambda6(cashierPayMethodModel);
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(CashierPayMethodModel cashierPayMethodModel, String str) {
        CashierPayMethodModel.PaylaterCicilPayMethod authRequestContext;
        Intrinsics.checkNotNullParameter(str, "");
        if (CashierPayMethodModelKt.NetworkUserEntityData$$ExternalSyntheticLambda6(cashierPayMethodModel)) {
            return cashierPayMethodModel != null && (authRequestContext = CashierPayMethodModelKt.getAuthRequestContext(cashierPayMethodModel)) != null && authRequestContext.getAuthRequestContext(str);
        }
        return false;
    }

    public static CashierPayMethodModel PlaceComponentResult(List<? extends CashierPayMethodModel> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((CashierPayMethodModel) obj).getNetworkUserEntityData$$ExternalSyntheticLambda0()) {
                break;
            }
        }
        return (CashierPayMethodModel) obj;
    }

    public static CashierPayMethodModel getErrorConfigVersion(List<? extends CashierPayMethodModel> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            CashierPayMethodModel cashierPayMethodModel = (CashierPayMethodModel) obj;
            if (!CashierPayMethodModelKt.DatabaseTableConfigUtil(cashierPayMethodModel) && cashierPayMethodModel.getNetworkUserEntityData$$ExternalSyntheticLambda0()) {
                break;
            }
        }
        return (CashierPayMethodModel) obj;
    }

    public static CashierPayMethodModel KClassImpl$Data$declaredNonStaticMembers$2(List<? extends CashierPayMethodModel> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (CashierPayMethodModelKt.NetworkUserEntityData$$ExternalSyntheticLambda6((CashierPayMethodModel) obj)) {
                break;
            }
        }
        return (CashierPayMethodModel) obj;
    }

    public static CashierPayMethodModel BuiltInFictitiousFunctionClassFactory(List<? extends CashierPayMethodModel> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            CashierPayMethodModel cashierPayMethodModel = (CashierPayMethodModel) obj;
            boolean z = false;
            if (CashierPayMethodModelKt.NetworkUserEntityData$$ExternalSyntheticLambda6(cashierPayMethodModel) && Intrinsics.areEqual(CashierPayMethodModelKt.BottomSheetCardBindingView$watcherCardNumberView$1(cashierPayMethodModel), Boolean.FALSE)) {
                z = true;
            }
            if (z) {
                break;
            }
        }
        return (CashierPayMethodModel) obj;
    }

    public static String getAuthRequestContext(List<? extends CashierPayMethodModel> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (CashierPayMethodModelKt.NetworkUserEntityData$$ExternalSyntheticLambda6((CashierPayMethodModel) obj)) {
                break;
            }
        }
        CashierPayMethodModel cashierPayMethodModel = (CashierPayMethodModel) obj;
        String lookAheadTest = cashierPayMethodModel != null ? cashierPayMethodModel.lookAheadTest() : null;
        return lookAheadTest == null ? "" : lookAheadTest;
    }

    public static boolean PlaceComponentResult(List<? extends CashierPayMethodModel> list, String str) {
        Intrinsics.checkNotNullParameter(str, "");
        Object obj = null;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(((CashierPayMethodModel) next).lookAheadTest(), str)) {
                    obj = next;
                    break;
                }
            }
            obj = (CashierPayMethodModel) obj;
        }
        return obj != null;
    }

    public static boolean MyBillsEntityDataFactory(List<? extends CashierPayMethodModel> list) {
        CashierPayMethodModel KClassImpl$Data$declaredNonStaticMembers$2;
        CashierPayMethodModel cashierPayMethodModel = null;
        if (list != null && (KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(list)) != null) {
            if (Intrinsics.areEqual(CashierPayMethodModelKt.BottomSheetCardBindingView$watcherCardNumberView$1(KClassImpl$Data$declaredNonStaticMembers$2), Boolean.TRUE) && KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult()) {
                cashierPayMethodModel = KClassImpl$Data$declaredNonStaticMembers$2;
            }
        }
        return cashierPayMethodModel != null;
    }

    public static List<CashierPayMethodModel> KClassImpl$Data$declaredNonStaticMembers$2(List<? extends CashierPayMethodModel> list, Function1<? super CashierPayMethodModel, ? extends CashierPayMethodModel> function1, Function1<? super CashierPayMethodModel, ? extends CashierPayMethodModel> function12, Function1<? super CashierPayMethodModel, ? extends CashierPayMethodModel> function13, Function1<? super CashierPayMethodModel, ? extends CashierPayMethodModel> function14, QueryInstallmentModel queryInstallmentModel) {
        CashierPayMethodModel invoke;
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(function12, "");
        Intrinsics.checkNotNullParameter(function13, "");
        Intrinsics.checkNotNullParameter(function14, "");
        List<? extends CashierPayMethodModel> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (CashierPayMethodModel cashierPayMethodModel : list2) {
            boolean z = CashierPayMethodModelKt.NetworkUserEntityData$$ExternalSyntheticLambda6(cashierPayMethodModel) && cashierPayMethodModel.PlaceComponentResult();
            if (z && Intrinsics.areEqual(CashierPayMethodModelKt.BottomSheetCardBindingView$watcherCardNumberView$1(cashierPayMethodModel), Boolean.TRUE) && queryInstallmentModel == null) {
                invoke = function1.invoke(cashierPayMethodModel);
            } else if (z && queryInstallmentModel != null && Intrinsics.areEqual(queryInstallmentModel.KClassImpl$Data$declaredNonStaticMembers$2, Boolean.TRUE)) {
                invoke = function12.invoke(cashierPayMethodModel);
            } else {
                invoke = (!z || queryInstallmentModel == null || Intrinsics.areEqual(queryInstallmentModel.KClassImpl$Data$declaredNonStaticMembers$2, Boolean.TRUE)) ? function14.invoke(cashierPayMethodModel) : function13.invoke(cashierPayMethodModel);
            }
            arrayList.add(invoke);
        }
        return arrayList;
    }

    public static void PlaceComponentResult(List<? extends CashierPayMethodModel> list, Function2<? super List<? extends CashierPayMethodModel>, ? super CashierPayMethodModel, Unit> function2) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(function2, "");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (CashierPayMethodModelKt.NetworkUserEntityData$$ExternalSyntheticLambda6((CashierPayMethodModel) obj)) {
                break;
            }
        }
        CashierPayMethodModel cashierPayMethodModel = (CashierPayMethodModel) obj;
        CashierPayMethodModel cashierPayMethodModel2 = cashierPayMethodModel != null ? cashierPayMethodModel : null;
        if (cashierPayMethodModel2 != null) {
            function2.invoke(list, cashierPayMethodModel2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x001e, code lost:
    
        if (((r6 == null || id.dana.cashier.model.CashierPayMethodModelKt.getSupportButtonTintMode(r6)) ? false : true) != false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void BuiltInFictitiousFunctionClassFactory(java.util.List<? extends id.dana.cashier.model.CashierPayMethodModel> r3, kotlin.jvm.functions.Function1<? super java.util.List<? extends id.dana.cashier.model.CashierPayMethodModel>, kotlin.Unit> r4, kotlin.jvm.functions.Function1<? super java.util.List<? extends id.dana.cashier.model.CashierPayMethodModel>, kotlin.Unit> r5, id.dana.cashier.model.CashierPayMethodModel r6) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            boolean r0 = id.dana.cashier.model.CashierPayMethodModelKt.KClassImpl$Data$declaredNonStaticMembers$2(r3)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L21
            if (r6 == 0) goto L1d
            boolean r6 = id.dana.cashier.model.CashierPayMethodModelKt.getSupportButtonTintMode(r6)
            if (r6 != 0) goto L1d
            r6 = 1
            goto L1e
        L1d:
            r6 = 0
        L1e:
            if (r6 == 0) goto L21
            goto L22
        L21:
            r1 = 0
        L22:
            r6 = 0
            if (r1 == 0) goto L27
            r0 = r3
            goto L28
        L27:
            r0 = r6
        L28:
            if (r0 == 0) goto L2f
            r4.invoke(r0)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
        L2f:
            if (r6 != 0) goto L34
            r5.invoke(r3)
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.helper.CashierPayMethodModelExt.BuiltInFictitiousFunctionClassFactory(java.util.List, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, id.dana.cashier.model.CashierPayMethodModel):void");
    }

    public static void BuiltInFictitiousFunctionClassFactory(List<? extends CashierPayMethodModel> list, boolean z, boolean z2, boolean z3, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(function02, "");
        Intrinsics.checkNotNullParameter(function03, "");
        boolean z4 = false;
        boolean z5 = CashierPayMethodModelKt.KClassImpl$Data$declaredNonStaticMembers$2(list) && (!z || z2 || z3);
        if (CashierPayMethodModelKt.KClassImpl$Data$declaredNonStaticMembers$2(list) && z && !z2 && !z3) {
            z4 = true;
        }
        if (z5) {
            function0.invoke();
        } else if (z4) {
            function02.invoke();
        } else {
            function03.invoke();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void PlaceComponentResult(List<? extends CashierPayMethodModel> list, CashierPayMethodModel cashierPayMethodModel) {
        Object obj;
        Object obj2;
        AssetCardModel assetCardModel;
        AssetCardModel assetCardModel2;
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        if (CashierPayMethodModelKt.PrepareContext(cashierPayMethodModel)) {
            Intrinsics.checkNotNullParameter(list, "");
            ArrayList arrayList = new ArrayList();
            for (Object obj3 : list) {
                if (CashierPayMethodModelKt.PrepareContext((CashierPayMethodModel) obj3)) {
                    arrayList.add(obj3);
                }
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                CashierPayMethodModel.CardPayMethod MyBillsEntityDataFactory = CashierPayMethodModelKt.MyBillsEntityDataFactory((CashierPayMethodModel) next);
                String str = (MyBillsEntityDataFactory == null || (assetCardModel2 = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? null : assetCardModel2.scheduleImpl;
                CashierPayMethodModel.CardPayMethod MyBillsEntityDataFactory2 = CashierPayMethodModelKt.MyBillsEntityDataFactory(cashierPayMethodModel);
                if (Intrinsics.areEqual(str, (MyBillsEntityDataFactory2 == null || (assetCardModel = MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? null : assetCardModel.scheduleImpl)) {
                    r3 = next;
                    break;
                }
            }
            CashierPayMethodModel cashierPayMethodModel2 = r3;
            if (cashierPayMethodModel2 != null) {
                cashierPayMethodModel2.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
            }
        } else if (CashierPayMethodModelKt.GetContactSyncConfig(cashierPayMethodModel)) {
            Intrinsics.checkNotNullParameter(list, "");
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                if (CashierPayMethodModelKt.GetContactSyncConfig((CashierPayMethodModel) next2)) {
                    r3 = next2;
                    break;
                }
            }
            CashierPayMethodModel cashierPayMethodModel3 = r3;
            if (cashierPayMethodModel3 != null) {
                cashierPayMethodModel3.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
            }
        } else if (CashierPayMethodModelKt.getSupportButtonTintMode(cashierPayMethodModel)) {
            Intrinsics.checkNotNullParameter(list, "");
            Iterator<T> it3 = list.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it3.next();
                if (CashierPayMethodModelKt.getSupportButtonTintMode((CashierPayMethodModel) obj2)) {
                    break;
                }
            }
            CashierPayMethodModel cashierPayMethodModel4 = (CashierPayMethodModel) obj2;
            r3 = cashierPayMethodModel4 != null ? CashierPayMethodModelKt.NetworkUserEntityData$$ExternalSyntheticLambda0(cashierPayMethodModel4) : null;
            if (r3 != null) {
                r3.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
            }
        } else if (CashierPayMethodModelKt.NetworkUserEntityData$$ExternalSyntheticLambda6(cashierPayMethodModel)) {
            CashierPayMethodModel KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(list);
            if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
            }
        } else {
            Intrinsics.checkNotNullParameter(list, "");
            Iterator<T> it4 = list.iterator();
            while (true) {
                if (!it4.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it4.next();
                if (CashierPayMethodModelKt.DatabaseTableConfigUtil((CashierPayMethodModel) obj)) {
                    break;
                }
            }
            CashierPayMethodModel cashierPayMethodModel5 = (CashierPayMethodModel) obj;
            r3 = cashierPayMethodModel5 != null ? CashierPayMethodModelKt.KClassImpl$Data$declaredNonStaticMembers$2(cashierPayMethodModel5) : null;
            if (r3 != null) {
                r3.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
            }
        }
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(CashierPayMethodModel cashierPayMethodModel, List<? extends CashierPayMethodModel> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        Intrinsics.checkNotNullParameter(list, "");
        if (CashierPayMethodModelKt.DatabaseTableConfigUtil(cashierPayMethodModel)) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(cashierPayMethodModel.initRecordTimeStamp(), ((CashierPayMethodModel) obj).initRecordTimeStamp())) {
                break;
            }
        }
        CashierPayMethodModel cashierPayMethodModel2 = (CashierPayMethodModel) obj;
        if (cashierPayMethodModel2 != null) {
            return cashierPayMethodModel2.PlaceComponentResult();
        }
        return false;
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(CashierPayMethodModel.BalancePayMethod balancePayMethod) {
        return Intrinsics.areEqual(balancePayMethod.lookAheadTest.NetworkUserEntityData$$ExternalSyntheticLambda2, "AE13112168000903");
    }

    private static boolean scheduleImpl(CashierPayMethodModel.PaylaterPayMethod paylaterPayMethod) {
        return Intrinsics.areEqual(paylaterPayMethod.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda2, "AE13112168000982");
    }

    private static boolean MyBillsEntityDataFactory(CashierPayMethodModel.BalancePayMethod balancePayMethod) {
        return Intrinsics.areEqual(balancePayMethod.lookAheadTest.NetworkUserEntityData$$ExternalSyntheticLambda2, "AE13112168000996");
    }

    private static boolean PlaceComponentResult(CashierPayMethodModel.BalancePayMethod balancePayMethod) {
        MoneyViewModel moneyViewModel = balancePayMethod.lookAheadTest.PlaceComponentResult;
        if (moneyViewModel != null) {
            String cleanAll = NumberUtils.getCleanAll(moneyViewModel.PlaceComponentResult);
            if (cleanAll == null) {
                cleanAll = "0";
            }
            Long longOrNull = StringsKt.toLongOrNull(cleanAll);
            long longValue = longOrNull != null ? longOrNull.longValue() : 0L;
            MoneyViewModel moneyViewModel2 = balancePayMethod.MyBillsEntityDataFactory;
            if (moneyViewModel2 != null) {
                String cleanAll2 = NumberUtils.getCleanAll(moneyViewModel2.PlaceComponentResult);
                Long longOrNull2 = StringsKt.toLongOrNull(cleanAll2 != null ? cleanAll2 : "0");
                return (longOrNull2 != null ? longOrNull2.longValue() : 0L) > longValue;
            }
            return false;
        }
        return false;
    }

    public static boolean PlaceComponentResult(CashierPayMethodModel.DanaPlusPayMethod danaPlusPayMethod) {
        Intrinsics.checkNotNullParameter(danaPlusPayMethod, "");
        return Intrinsics.areEqual(danaPlusPayMethod.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda2, "AE13112168000903");
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(CashierPayMethodModel.BalanceFamilyPayMethod balanceFamilyPayMethod) {
        Intrinsics.checkNotNullParameter(balanceFamilyPayMethod, "");
        return Intrinsics.areEqual(balanceFamilyPayMethod.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2, "AE13112168000917");
    }

    public static boolean getAuthRequestContext(CashierPayMethodModel.PaylaterPayMethod paylaterPayMethod) {
        Intrinsics.checkNotNullParameter(paylaterPayMethod, "");
        return Intrinsics.areEqual(paylaterPayMethod.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda2, "AE11112060000019");
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(CashierPayMethodModel.PaylaterPayMethod paylaterPayMethod) {
        Intrinsics.checkNotNullParameter(paylaterPayMethod, "");
        return Intrinsics.areEqual(paylaterPayMethod.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda2, "AE11112060000511");
    }

    public static boolean PlaceComponentResult(CashierPayMethodModel.PaylaterPayMethod paylaterPayMethod) {
        Intrinsics.checkNotNullParameter(paylaterPayMethod, "");
        return Intrinsics.areEqual(paylaterPayMethod.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda2, "AE11112060000999");
    }

    public static boolean MyBillsEntityDataFactory(CashierPayMethodModel.PaylaterPayMethod paylaterPayMethod) {
        Intrinsics.checkNotNullParameter(paylaterPayMethod, "");
        return Intrinsics.areEqual(paylaterPayMethod.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda2, "AE11112060030116");
    }

    public static boolean getErrorConfigVersion(CashierPayMethodModel.PaylaterPayMethod paylaterPayMethod) {
        Intrinsics.checkNotNullParameter(paylaterPayMethod, "");
        return Intrinsics.areEqual(paylaterPayMethod.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda2, "AE13112168000979");
    }
}
