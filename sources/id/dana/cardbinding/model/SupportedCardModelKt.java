package id.dana.cardbinding.model;

import id.dana.cardbinding.domain.model.SupportedCard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cardbinding/domain/model/SupportedCard;", "Lid/dana/cardbinding/model/SupportedCardModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/cardbinding/domain/model/SupportedCard;)Lid/dana/cardbinding/model/SupportedCardModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SupportedCardModelKt {
    public static final SupportedCardModel KClassImpl$Data$declaredNonStaticMembers$2(SupportedCard supportedCard) {
        Intrinsics.checkNotNullParameter(supportedCard, "");
        String str = supportedCard.BuiltInFictitiousFunctionClassFactory;
        if (str == null) {
            str = "";
        }
        String str2 = supportedCard.MyBillsEntityDataFactory;
        return new SupportedCardModel(str, str2 != null ? str2 : "");
    }
}
