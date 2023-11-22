package id.dana.promocenter.mapper;

import id.dana.domain.promocenter.model.Promo;
import id.dana.promocenter.model.PromoModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/promocenter/model/Promo;", "Lid/dana/promocenter/model/PromoModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/domain/promocenter/model/Promo;)Lid/dana/promocenter/model/PromoModel;", "", "PlaceComponentResult", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PromoAdsModelMapperKt {
    /* JADX WARN: Code restructure failed: missing block: B:54:0x009b, code lost:
    
        if (r6 == null) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final id.dana.promocenter.model.PromoModel KClassImpl$Data$declaredNonStaticMembers$2(id.dana.domain.promocenter.model.Promo r10) {
        /*
            id.dana.promocenter.model.PromoModel r0 = new id.dana.promocenter.model.PromoModel
            r0.<init>()
            r1 = 0
            if (r10 == 0) goto Ld
            java.lang.String r2 = r10.getId()
            goto Le
        Ld:
            r2 = r1
        Le:
            java.lang.String r3 = ""
            if (r2 != 0) goto L13
            r2 = r3
        L13:
            r0.PlaceComponentResult = r2
            if (r10 == 0) goto L1c
            java.lang.String r2 = r10.getName()
            goto L1d
        L1c:
            r2 = r1
        L1d:
            if (r2 != 0) goto L20
            r2 = r3
        L20:
            r0.scheduleImpl = r2
            r4 = 0
            if (r10 == 0) goto L2b
            long r6 = r10.getExpiryDate()
            goto L2c
        L2b:
            r6 = r4
        L2c:
            r0.BuiltInFictitiousFunctionClassFactory = r6
            if (r10 == 0) goto L35
            java.lang.String r2 = r10.getBannerUrl()
            goto L36
        L35:
            r2 = r1
        L36:
            if (r2 != 0) goto L39
            r2 = r3
        L39:
            r0.getAuthRequestContext = r2
            if (r10 == 0) goto L9d
            java.util.List r2 = r10.getPromoActions()
            if (r2 == 0) goto L9d
            if (r2 == 0) goto L97
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r6 = new java.util.ArrayList
            r7 = 10
            int r7 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r7)
            r6.<init>(r7)
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r2 = r2.iterator()
        L58:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L94
            java.lang.Object r7 = r2.next()
            id.dana.domain.promocenter.model.PromoAction r7 = (id.dana.domain.promocenter.model.PromoAction) r7
            id.dana.promocenter.model.PromoActionModel r8 = new id.dana.promocenter.model.PromoActionModel
            r8.<init>()
            if (r7 == 0) goto L70
            java.lang.String r9 = r7.getType()
            goto L71
        L70:
            r9 = r1
        L71:
            if (r9 != 0) goto L74
            r9 = r3
        L74:
            r8.getAuthRequestContext = r9
            if (r7 == 0) goto L7d
            java.lang.String r9 = r7.getName()
            goto L7e
        L7d:
            r9 = r1
        L7e:
            if (r9 != 0) goto L81
            r9 = r3
        L81:
            r8.MyBillsEntityDataFactory = r9
            if (r7 == 0) goto L8a
            java.lang.String r7 = r7.getRedirectUrl()
            goto L8b
        L8a:
            r7 = r1
        L8b:
            if (r7 != 0) goto L8e
            r7 = r3
        L8e:
            r8.PlaceComponentResult = r7
            r6.add(r8)
            goto L58
        L94:
            java.util.List r6 = (java.util.List) r6
            goto L9b
        L97:
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
        L9b:
            if (r6 != 0) goto La1
        L9d:
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
        La1:
            r0.MyBillsEntityDataFactory = r6
            if (r10 == 0) goto Laa
            int r2 = r10.getPromoPriority()
            goto Lab
        Laa:
            r2 = 0
        Lab:
            r0.moveToNextValue = r2
            if (r10 == 0) goto Lb3
            long r4 = r10.getPromoIndexId()
        Lb3:
            r0.NetworkUserEntityData$$ExternalSyntheticLambda0 = r4
            if (r10 == 0) goto Lbc
            java.lang.String r2 = r10.getPromoBannerVerticalImageUrl()
            goto Lbd
        Lbc:
            r2 = r1
        Lbd:
            if (r2 != 0) goto Lc0
            r2 = r3
        Lc0:
            r0.getErrorConfigVersion = r2
            if (r10 == 0) goto Lc8
            java.lang.String r1 = r10.getMerchantType()
        Lc8:
            if (r1 != 0) goto Lcb
            goto Lcc
        Lcb:
            r3 = r1
        Lcc:
            r0.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.promocenter.mapper.PromoAdsModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.domain.promocenter.model.Promo):id.dana.promocenter.model.PromoModel");
    }

    public static final List<PromoModel> PlaceComponentResult(List<? extends Promo> list) {
        if (list != null) {
            List<? extends Promo> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(KClassImpl$Data$declaredNonStaticMembers$2((Promo) it.next()));
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }
}
