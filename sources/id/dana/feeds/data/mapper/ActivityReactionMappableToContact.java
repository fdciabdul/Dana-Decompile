package id.dana.feeds.data.mapper;

import id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable;
import id.dana.feeds.domain.reactions.model.ActivityReactionsUser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/feeds/data/mapper/ActivityReactionMappableToContact;", "Lid/dana/data/social/repository/source/persistence/entity/PhoneNumberToContactNameMappable;", "", "getActorUserId", "()Ljava/lang/String;", "getActorUsername", "getContactPhoneNumber", "getNickname", "p0", "", "updateNickName", "(Ljava/lang/String;)V", "Lid/dana/feeds/domain/reactions/model/ActivityReactionsUser;", "MyBillsEntityDataFactory", "Lid/dana/feeds/domain/reactions/model/ActivityReactionsUser;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Lid/dana/feeds/domain/reactions/model/ActivityReactionsUser;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActivityReactionMappableToContact implements PhoneNumberToContactNameMappable {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final ActivityReactionsUser KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable
    public final /* synthetic */ String getHeaderName() {
        return PhoneNumberToContactNameMappable.CC.$default$getHeaderName(this);
    }

    @Override // id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable
    public final /* synthetic */ void updateHeaderName(String str) {
        Intrinsics.checkNotNullParameter(str, "");
    }

    public ActivityReactionMappableToContact(ActivityReactionsUser activityReactionsUser) {
        Intrinsics.checkNotNullParameter(activityReactionsUser, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = activityReactionsUser;
    }

    @Override // id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable
    public final String getNickname() {
        String nickName = this.KClassImpl$Data$declaredNonStaticMembers$2.getNickName();
        return nickName == null ? "" : nickName;
    }

    @Override // id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable
    /* renamed from: getContactPhoneNumber */
    public final String getLoginId() {
        String phoneNumber = this.KClassImpl$Data$declaredNonStaticMembers$2.getPhoneNumber();
        return phoneNumber == null ? "" : phoneNumber;
    }

    @Override // id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable
    public final void updateNickName(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.setNickName(p0);
        this.KClassImpl$Data$declaredNonStaticMembers$2.setDisplayName(p0);
    }

    @Override // id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable
    /* renamed from: getActorUsername */
    public final String getUsername() {
        String username = this.KClassImpl$Data$declaredNonStaticMembers$2.getUsername();
        return username == null ? "" : username;
    }

    @Override // id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable
    /* renamed from: getActorUserId */
    public final String getUserId() {
        String id2 = this.KClassImpl$Data$declaredNonStaticMembers$2.getId();
        return id2 == null ? "" : id2;
    }
}
