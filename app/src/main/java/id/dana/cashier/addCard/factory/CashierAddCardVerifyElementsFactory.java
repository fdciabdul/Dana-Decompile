package id.dana.cashier.addCard.factory;

import id.dana.cashier.addCard.model.DailyLimitCardVerifyElementModel;
import id.dana.cashier.addCard.model.QueryCardVerifyElementModel;
import id.dana.cashier.model.DailyLimitAmountConfModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ%\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/cashier/addCard/factory/CashierAddCardVerifyElementsFactory;", "", "", "", "p0", "Lid/dana/cashier/model/DailyLimitAmountConfModel;", "p1", "Lid/dana/cashier/addCard/model/QueryCardVerifyElementModel;", "PlaceComponentResult", "(Ljava/util/List;Lid/dana/cashier/model/DailyLimitAmountConfModel;)Ljava/util/List;", "", "", "getAuthRequestContext", "(Ljava/util/List;)Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CashierAddCardVerifyElementsFactory {
    public static final CashierAddCardVerifyElementsFactory INSTANCE = new CashierAddCardVerifyElementsFactory();

    private CashierAddCardVerifyElementsFactory() {
    }

    public static List<QueryCardVerifyElementModel> PlaceComponentResult(List<Integer> p0, DailyLimitAmountConfModel p1) {
        DailyLimitCardVerifyElementModel queryCardVerifyElementModel;
        Intrinsics.checkNotNullParameter(p0, "");
        List<Integer> list = p0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            if (intValue == 3) {
                queryCardVerifyElementModel = new DailyLimitCardVerifyElementModel(p1);
            } else {
                queryCardVerifyElementModel = new QueryCardVerifyElementModel(intValue, null, null, 6, null);
            }
            arrayList.add(queryCardVerifyElementModel);
        }
        return arrayList;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static List<Integer> getAuthRequestContext(List<String> p0) {
        Integer num;
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        if (p0 != null && p0.contains("cvv2")) {
            arrayList.add(1);
        } else {
            arrayList.add(4);
        }
        List<String> list = p0;
        if (list != null && !list.isEmpty()) {
            z = false;
        }
        if (!z) {
            ArrayList arrayList2 = new ArrayList();
            for (String str : p0) {
                switch (str.hashCode()) {
                    case -1712628250:
                        if (str.equals("limitAmountDaily")) {
                            num = 3;
                            break;
                        }
                        num = null;
                        break;
                    case -274728461:
                        if (str.equals("bankPhoneNo")) {
                            num = 0;
                            break;
                        }
                        num = null;
                        break;
                    case 3115426:
                        if (str.equals("ektp")) {
                            num = 2;
                            break;
                        }
                        num = null;
                        break;
                    case 1476073970:
                        if (str.equals("bankAccountNo")) {
                            num = 5;
                            break;
                        }
                        num = null;
                        break;
                    default:
                        num = null;
                        break;
                }
                if (num != null) {
                    arrayList2.add(num);
                }
            }
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }
}
