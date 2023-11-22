package id.dana.data.expresspurchase.mapper;

import id.dana.data.expresspurchase.model.ExpressPurchasePaylaterConfigResult;
import id.dana.domain.expresspurchase.interaction.model.ExpressPurchasePaylaterConfig;
import id.dana.lib.gcontainer.extension.NumberExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/expresspurchase/model/ExpressPurchasePaylaterConfigResult;", "Lid/dana/domain/expresspurchase/interaction/model/ExpressPurchasePaylaterConfig;", "toExpressPurchasePaylaterConfig", "(Lid/dana/data/expresspurchase/model/ExpressPurchasePaylaterConfigResult;)Lid/dana/domain/expresspurchase/interaction/model/ExpressPurchasePaylaterConfig;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ExpressPurchasePaylaterConfigResultMapperKt {
    public static final ExpressPurchasePaylaterConfig toExpressPurchasePaylaterConfig(ExpressPurchasePaylaterConfigResult expressPurchasePaylaterConfigResult) {
        Intrinsics.checkNotNullParameter(expressPurchasePaylaterConfigResult, "");
        int safeInt$default = NumberExtKt.toSafeInt$default(expressPurchasePaylaterConfigResult.getDismiss(), 0, 1, (Object) null);
        StringBuilder sb = new StringBuilder();
        sb.append("https://m.dana.id");
        String url = expressPurchasePaylaterConfigResult.getUrl();
        if (url == null) {
            url = "";
        }
        sb.append(url);
        String obj = sb.toString();
        String spaceCode = expressPurchasePaylaterConfigResult.getSpaceCode();
        return new ExpressPurchasePaylaterConfig(safeInt$default, obj, spaceCode != null ? spaceCode : "");
    }
}
