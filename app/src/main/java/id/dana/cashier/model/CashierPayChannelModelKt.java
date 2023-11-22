package id.dana.cashier.model;

import id.dana.cashier.model.CashierPayMethodModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0019\u0010\b\u001a\u00020\u0007*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u000e\u0010\f"}, d2 = {"", "Lid/dana/cashier/model/CashierPayChannelModel;", "Lid/dana/cashier/model/CashierPayMethodModel$BalanceFamilyPayMethod;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/List;)Lid/dana/cashier/model/CashierPayMethodModel$BalanceFamilyPayMethod;", "PlaceComponentResult", "(Ljava/util/List;)Lid/dana/cashier/model/CashierPayChannelModel;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;)Z", "Lid/dana/cashier/model/CashierPayMethodModel$OTCPayMethod;", "MyBillsEntityDataFactory", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/cashier/model/CashierPayMethodModel$VirtualAccountPayMethod;", "getAuthRequestContext"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierPayChannelModelKt {
    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(List<CashierPayChannelModel> list) {
        Object obj = null;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((CashierPayChannelModel) next).PlaceComponentResult()) {
                    obj = next;
                    break;
                }
            }
            obj = (CashierPayChannelModel) obj;
        }
        return obj != null;
    }

    public static final List<CashierPayMethodModel.VirtualAccountPayMethod> getAuthRequestContext(List<CashierPayChannelModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<CashierPayChannelModel> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new CashierPayMethodModel.VirtualAccountPayMethod((CashierPayChannelModel) it.next()));
        }
        return arrayList;
    }

    public static final List<CashierPayMethodModel.OTCPayMethod> MyBillsEntityDataFactory(List<CashierPayChannelModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<CashierPayChannelModel> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new CashierPayMethodModel.OTCPayMethod((CashierPayChannelModel) it.next()));
        }
        return arrayList;
    }

    public static final CashierPayMethodModel.BalanceFamilyPayMethod BuiltInFictitiousFunctionClassFactory(List<CashierPayChannelModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        CashierPayMethodModel.Companion companion = CashierPayMethodModel.INSTANCE;
        return CashierPayMethodModel.Companion.PlaceComponentResult(list, null);
    }

    public static final CashierPayChannelModel PlaceComponentResult(List<CashierPayChannelModel> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((CashierPayChannelModel) obj).BuiltInFictitiousFunctionClassFactory()) {
                break;
            }
        }
        return (CashierPayChannelModel) obj;
    }
}
