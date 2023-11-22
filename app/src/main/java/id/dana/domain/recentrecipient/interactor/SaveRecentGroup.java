package id.dana.domain.recentrecipient.interactor;

import com.alibaba.griver.core.GriverParams;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.recentrecipient.model.RecentRecipient;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import io.reactivex.Observable;
import java.util.Date;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\r\u000eB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/recentrecipient/interactor/SaveRecentGroup;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/recentrecipient/interactor/SaveRecentGroup$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/recentrecipient/interactor/SaveRecentGroup$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/recentrecipient/repository/RecentRecipientRepository;", "recentRecipientRepository", "Lid/dana/domain/recentrecipient/repository/RecentRecipientRepository;", "<init>", "(Lid/dana/domain/recentrecipient/repository/RecentRecipientRepository;)V", "Companion", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SaveRecentGroup extends BaseUseCase<Boolean, Params> {
    private static final String BANK = "group_bank";
    private static final String CONTACT = "group_phone";
    private final RecentRecipientRepository recentRecipientRepository;

    @Inject
    public SaveRecentGroup(RecentRecipientRepository recentRecipientRepository) {
        Intrinsics.checkNotNullParameter(recentRecipientRepository, "");
        this.recentRecipientRepository = recentRecipientRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        RecentRecipient recentRecipient = new RecentRecipient();
        recentRecipient.setId(params.getGroupId());
        recentRecipient.setAlias(params.getGroupName());
        recentRecipient.setName(params.getGroupName());
        recentRecipient.setImageUrl(params.getImageUrl());
        recentRecipient.setLastUpdated(new Date().getTime());
        recentRecipient.setParticipantCount(Integer.valueOf(params.getParticipantCount()));
        recentRecipient.setFavorite(params.getIsFavorite());
        recentRecipient.setType(Intrinsics.areEqual(params.getGroupRecipientType(), "group_phone") ? 2 : 3);
        Observable<Boolean> saveRecentGroup = this.recentRecipientRepository.saveRecentGroup(recentRecipient, params.getIsUpdate());
        Intrinsics.checkNotNullExpressionValue(saveRecentGroup, "");
        return saveRecentGroup;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019BA\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000f\u001a\u0004\b\u0011\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u00128\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/domain/recentrecipient/interactor/SaveRecentGroup$Params;", "", "", "groupId", "Ljava/lang/String;", "getGroupId", "()Ljava/lang/String;", "groupName", "getGroupName", "groupRecipientType", "getGroupRecipientType", GriverParams.ShareParams.IMAGE_URL, "getImageUrl", "", TrackerKey.SendMoneyProperties.IS_FAVORITE, "Z", "()Z", "isUpdate", "", "participantCount", "I", "getParticipantCount", "()I", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZ)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String groupId;
        private final String groupName;
        private final String groupRecipientType;
        private final String imageUrl;
        private final boolean isFavorite;
        private final boolean isUpdate;
        private final int participantCount;

        public /* synthetic */ Params(String str, String str2, String str3, int i, String str4, boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, i, str4, z, z2);
        }

        private Params(String str, String str2, String str3, int i, String str4, boolean z, boolean z2) {
            this.groupId = str;
            this.groupName = str2;
            this.imageUrl = str3;
            this.participantCount = i;
            this.groupRecipientType = str4;
            this.isFavorite = z;
            this.isUpdate = z2;
        }

        @JvmName(name = "getGroupId")
        public final String getGroupId() {
            return this.groupId;
        }

        @JvmName(name = "getGroupName")
        public final String getGroupName() {
            return this.groupName;
        }

        @JvmName(name = "getImageUrl")
        public final String getImageUrl() {
            return this.imageUrl;
        }

        @JvmName(name = "getParticipantCount")
        public final int getParticipantCount() {
            return this.participantCount;
        }

        @JvmName(name = "getGroupRecipientType")
        public final String getGroupRecipientType() {
            return this.groupRecipientType;
        }

        @JvmName(name = TrackerKey.SendMoneyProperties.IS_FAVORITE)
        /* renamed from: isFavorite  reason: from getter */
        public final boolean getIsFavorite() {
            return this.isFavorite;
        }

        @JvmName(name = "isUpdate")
        /* renamed from: isUpdate  reason: from getter */
        public final boolean getIsUpdate() {
            return this.isUpdate;
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J=\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ=\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\r"}, d2 = {"Lid/dana/domain/recentrecipient/interactor/SaveRecentGroup$Params$Companion;", "", "", "groupId", "groupName", GriverParams.ShareParams.IMAGE_URL, "", "participantCount", "groupRecipientType", "", TrackerKey.SendMoneyProperties.IS_FAVORITE, "Lid/dana/domain/recentrecipient/interactor/SaveRecentGroup$Params;", "forSaveRecentGroup", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Z)Lid/dana/domain/recentrecipient/interactor/SaveRecentGroup$Params;", "forUpdateRecentGroup", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Params forSaveRecentGroup(String groupId, String groupName, String imageUrl, int participantCount, String groupRecipientType, boolean isFavorite) {
                Intrinsics.checkNotNullParameter(groupId, "");
                Intrinsics.checkNotNullParameter(groupName, "");
                Intrinsics.checkNotNullParameter(imageUrl, "");
                Intrinsics.checkNotNullParameter(groupRecipientType, "");
                return new Params(groupId, groupName, imageUrl, participantCount, groupRecipientType, isFavorite, false, null);
            }

            public final Params forUpdateRecentGroup(String groupId, String groupName, String imageUrl, int participantCount, String groupRecipientType, boolean isFavorite) {
                Intrinsics.checkNotNullParameter(groupId, "");
                Intrinsics.checkNotNullParameter(groupName, "");
                Intrinsics.checkNotNullParameter(imageUrl, "");
                Intrinsics.checkNotNullParameter(groupRecipientType, "");
                return new Params(groupId, groupName, imageUrl, participantCount, groupRecipientType, isFavorite, true, null);
            }
        }
    }
}
