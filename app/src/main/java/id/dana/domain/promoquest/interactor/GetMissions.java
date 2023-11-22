package id.dana.domain.promoquest.interactor;

import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.promoquest.model.Mission;
import id.dana.domain.promoquest.respository.PromoQuestRepository;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u000eB\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/promoquest/interactor/GetMissions;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/promoquest/model/Mission;", "Lid/dana/domain/promoquest/interactor/GetMissions$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/promoquest/interactor/GetMissions$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/promoquest/respository/PromoQuestRepository;", "promoQuestRepository", "Lid/dana/domain/promoquest/respository/PromoQuestRepository;", "<init>", "(Lid/dana/domain/promoquest/respository/PromoQuestRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class GetMissions extends BaseUseCase<List<? extends Mission>, Params> {
    private final PromoQuestRepository promoQuestRepository;

    @Inject
    public GetMissions(PromoQuestRepository promoQuestRepository) {
        Intrinsics.checkNotNullParameter(promoQuestRepository, "");
        this.promoQuestRepository = promoQuestRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<List<Mission>> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.promoQuestRepository.getMissions(params.getPageSize(), params.getPageNumber());
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0019\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/domain/promoquest/interactor/GetMissions$Params;", "", "", ZdocRecordService.PAGE_NUMBER, "I", "getPageNumber$domain_productionRelease", "()I", SecurityConstants.KEY_PAGE_SIZE, "getPageSize$domain_productionRelease", "<init>", "(II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int pageNumber;
        private final int pageSize;

        public /* synthetic */ Params(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2);
        }

        private Params(int i, int i2) {
            this.pageSize = i;
            this.pageNumber = i2;
        }

        @JvmName(name = "getPageSize$domain_productionRelease")
        /* renamed from: getPageSize$domain_productionRelease  reason: from getter */
        public final int getPageSize() {
            return this.pageSize;
        }

        @JvmName(name = "getPageNumber$domain_productionRelease")
        /* renamed from: getPageNumber$domain_productionRelease  reason: from getter */
        public final int getPageNumber() {
            return this.pageNumber;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/domain/promoquest/interactor/GetMissions$Params$Companion;", "", "", SecurityConstants.KEY_PAGE_SIZE, ZdocRecordService.PAGE_NUMBER, "Lid/dana/domain/promoquest/interactor/GetMissions$Params;", ARiverTrackWatchDogEventConstant.FLAG_START_UP_CREATE, "(II)Lid/dana/domain/promoquest/interactor/GetMissions$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes8.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Params create(int pageSize, int pageNumber) {
                return new Params(pageSize, pageNumber, null);
            }
        }
    }
}
