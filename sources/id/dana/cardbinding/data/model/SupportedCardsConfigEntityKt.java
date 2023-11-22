package id.dana.cardbinding.data.model;

import id.dana.cardbinding.domain.model.SupportedCardsConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cardbinding/data/model/SupportedCardsConfigEntity;", "Lid/dana/cardbinding/domain/model/SupportedCardsConfig;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/cardbinding/data/model/SupportedCardsConfigEntity;)Lid/dana/cardbinding/domain/model/SupportedCardsConfig;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SupportedCardsConfigEntityKt {
    public static final SupportedCardsConfig KClassImpl$Data$declaredNonStaticMembers$2(SupportedCardsConfigEntity supportedCardsConfigEntity) {
        ArrayList emptyList;
        Intrinsics.checkNotNullParameter(supportedCardsConfigEntity, "");
        String str = supportedCardsConfigEntity.BuiltInFictitiousFunctionClassFactory;
        String str2 = str == null ? "" : str;
        String str3 = supportedCardsConfigEntity.MyBillsEntityDataFactory;
        String str4 = str3 == null ? "" : str3;
        List<SupportedCardEntity> list = supportedCardsConfigEntity.getAuthRequestContext;
        if (list != null) {
            List<SupportedCardEntity> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(SupportedCardEntityKt.MyBillsEntityDataFactory((SupportedCardEntity) it.next()));
            }
            emptyList = arrayList;
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        String str5 = supportedCardsConfigEntity.PlaceComponentResult;
        String str6 = str5 == null ? "" : str5;
        String str7 = supportedCardsConfigEntity.KClassImpl$Data$declaredNonStaticMembers$2;
        return new SupportedCardsConfig(str2, str4, emptyList, str6, str7 == null ? "" : str7);
    }
}
