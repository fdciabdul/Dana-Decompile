package id.dana.expresspurchase.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0004*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/expresspurchase/model/PriceModel;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/expresspurchase/model/PriceModel;)Ljava/lang/String;", "", "getAuthRequestContext", "(Lid/dana/expresspurchase/model/PriceModel;)I"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PriceModelKt {
    public static final String KClassImpl$Data$declaredNonStaticMembers$2(PriceModel priceModel) {
        Intrinsics.checkNotNullParameter(priceModel, "");
        return StringsKt.substringBefore$default(priceModel.getAuthRequestContext, ".", (String) null, 2, (Object) null);
    }

    public static final int getAuthRequestContext(PriceModel priceModel) {
        Intrinsics.checkNotNullParameter(priceModel, "");
        return Integer.parseInt(StringsKt.replace(priceModel.getAuthRequestContext, ".", "", true));
    }
}
