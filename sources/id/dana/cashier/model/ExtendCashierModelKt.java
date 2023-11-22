package id.dana.cashier.model;

import id.dana.cashier.domain.model.ExtendCashierInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cashier/domain/model/ExtendCashierInfo;", "Lid/dana/cashier/model/ExtendCashierModel;", "PlaceComponentResult", "(Lid/dana/cashier/domain/model/ExtendCashierInfo;)Lid/dana/cashier/model/ExtendCashierModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ExtendCashierModelKt {
    public static final ExtendCashierModel PlaceComponentResult(ExtendCashierInfo extendCashierInfo) {
        Intrinsics.checkNotNullParameter(extendCashierInfo, "");
        return new ExtendCashierModel(extendCashierInfo.getBankMobileNo(), extendCashierInfo.getBankToken(), extendCashierInfo.getCardBin(), extendCashierInfo.getCardCacheToken(), extendCashierInfo.getDailyLimit(), extendCashierInfo.getBizProcessId(), extendCashierInfo.getCardScheme(), extendCashierInfo.getEktp(), extendCashierInfo.getInterbankSupport(), extendCashierInfo.getHeaderDescription(), extendCashierInfo.getServiceInstID(), extendCashierInfo.getNeedRegistration());
    }
}
