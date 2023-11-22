package id.dana.cashier.model;

import id.dana.cashier.domain.model.CashierOrderGood;
import id.dana.cashier.domain.model.OrderCreateExtendInfo;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModelKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\u001a\u001d\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\b\u001a\u00020\u0007*\u00020\u0001¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\n\u001a\u00020\u0007*\u00020\u0001¢\u0006\u0004\b\n\u0010\t\u001a\u0011\u0010\u0005\u001a\u00020\u0007*\u00020\u0001¢\u0006\u0004\b\u0005\u0010\t\u001a\u0011\u0010\u000b\u001a\u00020\u0007*\u00020\u0001¢\u0006\u0004\b\u000b\u0010\t\u001a\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\b\u0012\u0004\u0012\u00020\f0\u0000¢\u0006\u0004\b\u000b\u0010\u0003"}, d2 = {"", "Lid/dana/cashier/model/CashierOrderGoodModel;", "MyBillsEntityDataFactory", "(Ljava/util/List;)Ljava/util/List;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;)Ljava/lang/String;", "", "getAuthRequestContext", "(Lid/dana/cashier/model/CashierOrderGoodModel;)Z", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/cashier/domain/model/CashierOrderGood;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierOrderGoodModelKt {
    public static final List<CashierOrderGoodModel> MyBillsEntityDataFactory(List<CashierOrderGoodModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            CashierOrderGoodModel cashierOrderGoodModel = (CashierOrderGoodModel) obj;
            if (Intrinsics.areEqual(cashierOrderGoodModel.scheduleImpl, Boolean.TRUE) && Intrinsics.areEqual(cashierOrderGoodModel.PrepareContext, "CHILD")) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final String KClassImpl$Data$declaredNonStaticMembers$2(List<CashierOrderGoodModel> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((CashierOrderGoodModel) obj).PrepareContext, "PARENT")) {
                break;
            }
        }
        CashierOrderGoodModel cashierOrderGoodModel = (CashierOrderGoodModel) obj;
        if (cashierOrderGoodModel != null) {
            return cashierOrderGoodModel.MyBillsEntityDataFactory;
        }
        return null;
    }

    public static final List<CashierOrderGoodModel> BuiltInFictitiousFunctionClassFactory(List<CashierOrderGood> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<CashierOrderGood> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Iterator it = list2.iterator(); it.hasNext(); it = it) {
            CashierOrderGood cashierOrderGood = (CashierOrderGood) it.next();
            Intrinsics.checkNotNullParameter(cashierOrderGood, "");
            String category = cashierOrderGood.getCategory();
            Boolean choosable = cashierOrderGood.getChoosable();
            Boolean chosen = cashierOrderGood.getChosen();
            Boolean displayable = cashierOrderGood.getDisplayable();
            MoneyView goodsAmount = cashierOrderGood.getGoodsAmount();
            MoneyViewModel authRequestContext = goodsAmount != null ? MoneyViewModelKt.getAuthRequestContext(goodsAmount) : null;
            String goodsDescription = cashierOrderGood.getGoodsDescription();
            String goodsId = cashierOrderGood.getGoodsId();
            String goodsName = cashierOrderGood.getGoodsName();
            String goodsType = cashierOrderGood.getGoodsType();
            String goodsUnitType = cashierOrderGood.getGoodsUnitType();
            String quantity = cashierOrderGood.getQuantity();
            String toolTip = cashierOrderGood.getToolTip();
            Boolean stackInsurance = cashierOrderGood.getStackInsurance();
            OrderCreateExtendInfo orderCreateExtendInfo = cashierOrderGood.getOrderCreateExtendInfo();
            arrayList.add(new CashierOrderGoodModel(category, choosable, chosen, displayable, authRequestContext, goodsDescription, goodsId, goodsName, goodsType, goodsUnitType, quantity, toolTip, stackInsurance, orderCreateExtendInfo != null ? OrderCreateExtendInfoModelKt.BuiltInFictitiousFunctionClassFactory(orderCreateExtendInfo) : null, 0, null, null, 114688, null));
        }
        return arrayList;
    }

    public static final boolean getAuthRequestContext(CashierOrderGoodModel cashierOrderGoodModel) {
        Intrinsics.checkNotNullParameter(cashierOrderGoodModel, "");
        return Intrinsics.areEqual(cashierOrderGoodModel.getErrorConfigVersion, Boolean.TRUE);
    }

    public static final boolean PlaceComponentResult(CashierOrderGoodModel cashierOrderGoodModel) {
        Intrinsics.checkNotNullParameter(cashierOrderGoodModel, "");
        AddOnChannelSupportInfo addOnChannelSupportInfo = cashierOrderGoodModel.KClassImpl$Data$declaredNonStaticMembers$2;
        if (addOnChannelSupportInfo != null) {
            return Intrinsics.areEqual(addOnChannelSupportInfo.getAuthRequestContext, Boolean.TRUE);
        }
        return false;
    }

    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(CashierOrderGoodModel cashierOrderGoodModel) {
        Intrinsics.checkNotNullParameter(cashierOrderGoodModel, "");
        Boolean bool = cashierOrderGoodModel.scheduleImpl;
        Boolean bool2 = Boolean.TRUE;
        return Intrinsics.areEqual(bool, bool2) && Intrinsics.areEqual(cashierOrderGoodModel.PlaceComponentResult, bool2);
    }

    public static final boolean BuiltInFictitiousFunctionClassFactory(CashierOrderGoodModel cashierOrderGoodModel) {
        Intrinsics.checkNotNullParameter(cashierOrderGoodModel, "");
        return cashierOrderGoodModel.KClassImpl$Data$declaredNonStaticMembers$2 == null;
    }
}
