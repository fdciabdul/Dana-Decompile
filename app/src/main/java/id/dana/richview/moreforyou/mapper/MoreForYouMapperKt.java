package id.dana.richview.moreforyou.mapper;

import id.dana.domain.home.model.MoreForYouData;
import id.dana.richview.moreforyou.model.MoreForYouModel;
import id.dana.utils.DateTimeUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u0011\u0010\u0006\u001a\u00020\u0000*\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004*\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0004\b\b\u0010\u0005"}, d2 = {"Lid/dana/richview/moreforyou/model/MoreForYouModel;", "Lid/dana/domain/home/model/MoreForYouData;", "toMoreForYouData", "(Lid/dana/richview/moreforyou/model/MoreForYouModel;)Lid/dana/domain/home/model/MoreForYouData;", "", "(Ljava/util/List;)Ljava/util/List;", "toMoreForYouModel", "(Lid/dana/domain/home/model/MoreForYouData;)Lid/dana/richview/moreforyou/model/MoreForYouModel;", "toMoreForYouModels"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MoreForYouMapperKt {
    public static final List<MoreForYouModel> toMoreForYouModels(List<MoreForYouData> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<MoreForYouData> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toMoreForYouModel((MoreForYouData) it.next()));
        }
        return arrayList;
    }

    public static final MoreForYouModel toMoreForYouModel(MoreForYouData moreForYouData) {
        Locale locale;
        Intrinsics.checkNotNullParameter(moreForYouData, "");
        String clientId = moreForYouData.getClientId();
        String scopes = moreForYouData.getScopes();
        String redirectType = moreForYouData.getRedirectType();
        String icon = moreForYouData.getIcon();
        String title = moreForYouData.getTitle();
        String subtitle = moreForYouData.getSubtitle();
        String redirectUrl = moreForYouData.getRedirectUrl();
        String contentId = moreForYouData.getContentId();
        String contentName = moreForYouData.getContentName();
        String contentType = moreForYouData.getContentType();
        String spaceCode = moreForYouData.getSpaceCode();
        Integer priority = moreForYouData.getPriority();
        Integer createdDate = moreForYouData.getCreatedDate();
        String bizScenario = moreForYouData.getBizScenario();
        Integer localIconId = moreForYouData.getLocalIconId();
        String expireDate = moreForYouData.getExpireDate();
        locale = Locale.getDefault();
        return new MoreForYouModel(clientId, scopes, redirectType, icon, title, subtitle, redirectUrl, contentId, contentName, contentType, spaceCode, priority, createdDate, bizScenario, localIconId, DateTimeUtil.getAuthRequestContext(expireDate, "yyyy-MM-dd HH:mm:ss", locale));
    }

    public static final List<MoreForYouData> toMoreForYouData(List<MoreForYouModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<MoreForYouModel> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toMoreForYouData((MoreForYouModel) it.next()));
        }
        return arrayList;
    }

    public static final MoreForYouData toMoreForYouData(MoreForYouModel moreForYouModel) {
        Locale locale;
        Intrinsics.checkNotNullParameter(moreForYouModel, "");
        String clientId = moreForYouModel.getClientId();
        String scopes = moreForYouModel.getScopes();
        String redirectType = moreForYouModel.getRedirectType();
        String icon = moreForYouModel.getIcon();
        String title = moreForYouModel.getTitle();
        String subtitle = moreForYouModel.getSubtitle();
        String redirectUrl = moreForYouModel.getRedirectUrl();
        String contentId = moreForYouModel.getContentId();
        String contentName = moreForYouModel.getContentName();
        String contentType = moreForYouModel.getContentType();
        String spaceCode = moreForYouModel.getSpaceCode();
        Integer priority = moreForYouModel.getPriority();
        Integer createdDate = moreForYouModel.getCreatedDate();
        String bizScenario = moreForYouModel.getBizScenario();
        Integer localIconId = moreForYouModel.getLocalIconId();
        Date expireDate = moreForYouModel.getExpireDate();
        locale = Locale.getDefault();
        return new MoreForYouData(clientId, scopes, redirectType, icon, title, subtitle, redirectUrl, contentId, contentName, contentType, spaceCode, priority, createdDate, bizScenario, localIconId, DateTimeUtil.MyBillsEntityDataFactory(expireDate, "yyyy-MM-dd HH:mm:ss", locale));
    }
}
