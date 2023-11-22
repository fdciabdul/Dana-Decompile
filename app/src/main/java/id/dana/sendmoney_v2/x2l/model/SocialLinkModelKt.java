package id.dana.sendmoney_v2.x2l.model;

import id.dana.domain.sendmoney.x2l.model.SocialLink;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lid/dana/domain/sendmoney/x2l/model/SocialLink;", "Lid/dana/sendmoney_v2/x2l/model/SocialLinkModel;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SocialLinkModelKt {
    public static final List<SocialLinkModel> BuiltInFictitiousFunctionClassFactory(List<SocialLink> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<SocialLink> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (SocialLink socialLink : list2) {
            Intrinsics.checkNotNullParameter(socialLink, "");
            arrayList.add(new SocialLinkModel(socialLink.getTitle(), socialLink.getSubTitle(), socialLink.getAction(), socialLink.getIcon()));
        }
        return arrayList;
    }
}
