package id.dana.cardbinding.model;

import id.dana.cardbinding.domain.model.SupportedCard;
import id.dana.cardbinding.domain.model.SupportedCardsConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cardbinding/domain/model/SupportedCardsConfig;", "Lid/dana/cardbinding/model/SupportedCardsConfigModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/cardbinding/domain/model/SupportedCardsConfig;)Lid/dana/cardbinding/model/SupportedCardsConfigModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SupportedCardsConfigModelKt {
    public static final SupportedCardsConfigModel BuiltInFictitiousFunctionClassFactory(SupportedCardsConfig supportedCardsConfig) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(supportedCardsConfig, "");
        String str = supportedCardsConfig.PlaceComponentResult;
        String str2 = str == null ? "" : str;
        String str3 = supportedCardsConfig.MyBillsEntityDataFactory;
        String str4 = str3 == null ? "" : str3;
        List<SupportedCard> list = supportedCardsConfig.KClassImpl$Data$declaredNonStaticMembers$2;
        if (list != null) {
            List<SupportedCard> list2 = list;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList2.add(SupportedCardModelKt.KClassImpl$Data$declaredNonStaticMembers$2((SupportedCard) it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = new ArrayList();
        }
        String str5 = supportedCardsConfig.getAuthRequestContext;
        String str6 = str5 == null ? "" : str5;
        String str7 = supportedCardsConfig.BuiltInFictitiousFunctionClassFactory;
        return new SupportedCardsConfigModel(str2, str4, arrayList, str6, str7 == null ? "" : str7);
    }
}
