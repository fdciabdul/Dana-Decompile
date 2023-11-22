package id.dana.feeds.data.config.model;

import id.dana.feeds.domain.config.model.ProfileCtaConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lid/dana/feeds/data/config/model/ProfileCtaConfigResponse;", "Lid/dana/feeds/domain/config/model/ProfileCtaConfig;", "toProfileCtaConfig", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProfileCtaConfigResponseKt {
    public static final List<ProfileCtaConfig> toProfileCtaConfig(List<ProfileCtaConfigResponse> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<ProfileCtaConfigResponse> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((ProfileCtaConfigResponse) it.next()).toProfileCtaConfig());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            ProfileCtaConfig profileCtaConfig = (ProfileCtaConfig) obj;
            if ((profileCtaConfig.getKey().length() > 0) && profileCtaConfig.getEnable()) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }
}
