package id.dana.domain.promoquest.interactor;

import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.promoquest.model.Mission;
import id.dana.domain.promoquest.respository.PromoQuestRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/promoquest/interactor/GetMissionDetail;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/promoquest/model/Mission;", "Lid/dana/domain/promoquest/interactor/GetMissionDetail$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/promoquest/interactor/GetMissionDetail$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/promoquest/respository/PromoQuestRepository;", "questRepository", "Lid/dana/domain/promoquest/respository/PromoQuestRepository;", "<init>", "(Lid/dana/domain/promoquest/respository/PromoQuestRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetMissionDetail extends BaseUseCase<Mission, Params> {
    private final PromoQuestRepository questRepository;

    @Inject
    public GetMissionDetail(PromoQuestRepository promoQuestRepository) {
        Intrinsics.checkNotNullParameter(promoQuestRepository, "");
        this.questRepository = promoQuestRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Mission> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.questRepository.getMissionDetail(params.getMissionId(), params.getWithMissionInfo());
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/promoquest/interactor/GetMissionDetail$Params;", "", "", BranchLinkConstant.Params.MISSION_ID, "Ljava/lang/String;", "getMissionId$domain_productionRelease", "()Ljava/lang/String;", "", "withMissionInfo", "Z", "getWithMissionInfo$domain_productionRelease", "()Z", "<init>", "(Ljava/lang/String;Z)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String missionId;
        private final boolean withMissionInfo;

        public /* synthetic */ Params(String str, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, z);
        }

        @JvmStatic
        public static final Params create(String str, boolean z) {
            return INSTANCE.create(str, z);
        }

        private Params(String str, boolean z) {
            this.missionId = str;
            this.withMissionInfo = z;
        }

        @JvmName(name = "getMissionId$domain_productionRelease")
        /* renamed from: getMissionId$domain_productionRelease  reason: from getter */
        public final String getMissionId() {
            return this.missionId;
        }

        @JvmName(name = "getWithMissionInfo$domain_productionRelease")
        /* renamed from: getWithMissionInfo$domain_productionRelease  reason: from getter */
        public final boolean getWithMissionInfo() {
            return this.withMissionInfo;
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/domain/promoquest/interactor/GetMissionDetail$Params$Companion;", "", "", BranchLinkConstant.Params.MISSION_ID, "", "withMissionInfo", "Lid/dana/domain/promoquest/interactor/GetMissionDetail$Params;", ARiverTrackWatchDogEventConstant.FLAG_START_UP_CREATE, "(Ljava/lang/String;Z)Lid/dana/domain/promoquest/interactor/GetMissionDetail$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public static /* synthetic */ Params create$default(Companion companion, String str, boolean z, int i, Object obj) {
                if ((i & 2) != 0) {
                    z = false;
                }
                return companion.create(str, z);
            }

            @JvmStatic
            public final Params create(String missionId, boolean withMissionInfo) {
                Intrinsics.checkNotNullParameter(missionId, "");
                return new Params(missionId, withMissionInfo, null);
            }
        }
    }
}
