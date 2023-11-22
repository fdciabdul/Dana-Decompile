package id.dana.data.sendmoney.x2l.model;

import id.dana.domain.sendmoney.x2l.model.SocialLink;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/sendmoney/x2l/model/SocialLinkEntity;", "Lid/dana/domain/sendmoney/x2l/model/SocialLink;", "toSocialLink", "(Lid/dana/data/sendmoney/x2l/model/SocialLinkEntity;)Lid/dana/domain/sendmoney/x2l/model/SocialLink;", "", "toSocialLinks", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SocialLinkEntityKt {
    public static final SocialLink toSocialLink(SocialLinkEntity socialLinkEntity) {
        Intrinsics.checkNotNullParameter(socialLinkEntity, "");
        String title = socialLinkEntity.getTitle();
        if (title == null) {
            title = "";
        }
        String subTitle = socialLinkEntity.getSubTitle();
        if (subTitle == null) {
            subTitle = "";
        }
        String action = socialLinkEntity.getAction();
        if (action == null) {
            action = "";
        }
        String icon = socialLinkEntity.getIcon();
        return new SocialLink(title, subTitle, action, icon != null ? icon : "");
    }

    public static final List<SocialLink> toSocialLinks(List<SocialLinkEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<SocialLinkEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toSocialLink((SocialLinkEntity) it.next()));
        }
        return arrayList;
    }
}
