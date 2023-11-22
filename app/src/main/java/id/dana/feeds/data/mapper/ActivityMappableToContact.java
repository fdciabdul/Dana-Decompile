package id.dana.feeds.data.mapper;

import id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable;
import id.dana.data.storage.Serializer;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.feeds.domain.timeline.model.ActivityResponse;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u001aJ;\u0010\u0005\u001a.\u0012\b\u0012\u0006*\u00020\u00030\u0003\u0012\b\u0012\u0006*\u00020\u00030\u0003*\u0016\u0012\b\u0012\u0006*\u00020\u00030\u0003\u0012\b\u0012\u0006*\u00020\u00030\u00030\u00040\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0016"}, d2 = {"Lid/dana/feeds/data/mapper/ActivityMappableToContact;", "Lid/dana/data/social/repository/source/persistence/entity/PhoneNumberToContactNameMappable;", "", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/util/Map;", "getActorUserId", "()Ljava/lang/String;", "getActorUsername", "getContactPhoneNumber", "getHeaderName", "getNickname", "p0", "", "updateHeaderName", "(Ljava/lang/String;)V", "updateNickName", "Lid/dana/feeds/domain/timeline/model/ActivityResponse;", "Lid/dana/feeds/domain/timeline/model/ActivityResponse;", "MyBillsEntityDataFactory", "Lid/dana/data/storage/Serializer;", "Lid/dana/data/storage/Serializer;", "getAuthRequestContext", "p1", "<init>", "(Lid/dana/data/storage/Serializer;Lid/dana/feeds/domain/timeline/model/ActivityResponse;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActivityMappableToContact implements PhoneNumberToContactNameMappable {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final ActivityResponse MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Serializer getAuthRequestContext;

    public ActivityMappableToContact(Serializer serializer, ActivityResponse activityResponse) {
        Intrinsics.checkNotNullParameter(serializer, "");
        Intrinsics.checkNotNullParameter(activityResponse, "");
        this.getAuthRequestContext = serializer;
        this.MyBillsEntityDataFactory = activityResponse;
    }

    @Override // id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable
    public final String getNickname() {
        Map<String, String> KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
        String str = KClassImpl$Data$declaredNonStaticMembers$2.get("nickname");
        if (str == null) {
            String str2 = KClassImpl$Data$declaredNonStaticMembers$2.get(ExtendInfoUtilKt.DISPLAY_NAME_KEY);
            return str2 == null ? getLoginId() : str2;
        }
        return str;
    }

    @Override // id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable
    /* renamed from: getContactPhoneNumber */
    public final String getLoginId() {
        String str = KClassImpl$Data$declaredNonStaticMembers$2().get("phoneNumber");
        return str == null ? "" : str;
    }

    @Override // id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable
    public final void updateNickName(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Map<String, String> KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        KClassImpl$Data$declaredNonStaticMembers$2.put("nickname", p0);
        KClassImpl$Data$declaredNonStaticMembers$2.put(ExtendInfoUtilKt.DISPLAY_NAME_KEY, p0);
        HashMap<String, String> extendInfo = this.MyBillsEntityDataFactory.getExtendInfo();
        if (extendInfo != null) {
            extendInfo.put(ExtendInfoUtilKt.ACTOR_KEY, this.getAuthRequestContext.serialize(KClassImpl$Data$declaredNonStaticMembers$2));
        }
    }

    private final Map<String, String> KClassImpl$Data$declaredNonStaticMembers$2() {
        Serializer serializer = this.getAuthRequestContext;
        HashMap<String, String> extendInfo = this.MyBillsEntityDataFactory.getExtendInfo();
        return serializer.deserializeMap(extendInfo != null ? extendInfo.get(ExtendInfoUtilKt.ACTOR_KEY) : null);
    }

    @Override // id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable
    /* renamed from: getActorUsername */
    public final String getUsername() {
        String str = KClassImpl$Data$declaredNonStaticMembers$2().get("username");
        return str == null ? "" : str;
    }

    @Override // id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable
    public final void updateHeaderName(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Map<String, String> KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        KClassImpl$Data$declaredNonStaticMembers$2.put(ExtendInfoUtilKt.HEADER_NAME_KEY, p0);
        HashMap<String, String> extendInfo = this.MyBillsEntityDataFactory.getExtendInfo();
        if (extendInfo != null) {
            extendInfo.put(ExtendInfoUtilKt.ACTOR_KEY, this.getAuthRequestContext.serialize(KClassImpl$Data$declaredNonStaticMembers$2));
        }
    }

    @Override // id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable
    public final String getHeaderName() {
        String str = KClassImpl$Data$declaredNonStaticMembers$2().get(ExtendInfoUtilKt.HEADER_NAME_KEY);
        return str == null ? "" : str;
    }

    @Override // id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable
    /* renamed from: getActorUserId */
    public final String getUserId() {
        String str = KClassImpl$Data$declaredNonStaticMembers$2().get("userId");
        return str == null ? "" : str;
    }
}
