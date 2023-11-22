package id.dana.domain.user.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.repository.UserRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/user/interactor/GetUserStatusInfo;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/user/UserInfoResponse;", "Lid/dana/domain/user/interactor/GetUserStatusInfo$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/user/interactor/GetUserStatusInfo$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/user/repository/UserRepository;", "userRepository", "Lid/dana/domain/user/repository/UserRepository;", "<init>", "(Lid/dana/domain/user/repository/UserRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetUserStatusInfo extends BaseUseCase<UserInfoResponse, Param> {
    private final UserRepository userRepository;

    @Inject
    public GetUserStatusInfo(UserRepository userRepository) {
        Intrinsics.checkNotNullParameter(userRepository, "");
        this.userRepository = userRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<UserInfoResponse> buildUseCase(Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<UserInfoResponse> userStatusInfo = this.userRepository.getUserStatusInfo(params.getNeedBackendUpdate());
        Intrinsics.checkNotNullExpressionValue(userStatusInfo, "");
        return userStatusInfo;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/user/interactor/GetUserStatusInfo$Param;", "", "", "needBackendUpdate", "Z", "getNeedBackendUpdate$domain_productionRelease", "()Z", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Param {
        private final boolean needBackendUpdate;

        public Param() {
            this(false, 1, null);
        }

        public Param(boolean z) {
            this.needBackendUpdate = z;
        }

        public /* synthetic */ Param(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z);
        }

        @JvmName(name = "getNeedBackendUpdate$domain_productionRelease")
        /* renamed from: getNeedBackendUpdate$domain_productionRelease  reason: from getter */
        public final boolean getNeedBackendUpdate() {
            return this.needBackendUpdate;
        }
    }
}
