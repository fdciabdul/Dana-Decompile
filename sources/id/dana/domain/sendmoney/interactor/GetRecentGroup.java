package id.dana.domain.sendmoney.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.recentrecipient.model.RecentRecipient;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u000eB\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/sendmoney/interactor/GetRecentGroup;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/recentrecipient/model/RecentRecipient;", "Lid/dana/domain/sendmoney/interactor/GetRecentGroup$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/sendmoney/interactor/GetRecentGroup$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/recentrecipient/repository/RecentRecipientRepository;", "recentRecipientRepository", "Lid/dana/domain/recentrecipient/repository/RecentRecipientRepository;", "<init>", "(Lid/dana/domain/recentrecipient/repository/RecentRecipientRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetRecentGroup extends BaseUseCase<List<? extends RecentRecipient>, Params> {
    private final RecentRecipientRepository recentRecipientRepository;

    @Inject
    public GetRecentGroup(RecentRecipientRepository recentRecipientRepository) {
        Intrinsics.checkNotNullParameter(recentRecipientRepository, "");
        this.recentRecipientRepository = recentRecipientRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<List<RecentRecipient>> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<List<RecentRecipient>> recentGroup = this.recentRecipientRepository.getRecentGroup(params.getFilter());
        Intrinsics.checkNotNullExpressionValue(recentGroup, "");
        return recentGroup;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0013\b\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/sendmoney/interactor/GetRecentGroup$Params;", "", "", "filter", "Ljava/lang/String;", "getFilter$domain_productionRelease", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String filter;

        public /* synthetic */ Params(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        @JvmStatic
        public static final Params createParams(String str) {
            return INSTANCE.createParams(str);
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/sendmoney/interactor/GetRecentGroup$Params$Companion;", "", "", "filter", "Lid/dana/domain/sendmoney/interactor/GetRecentGroup$Params;", "createParams", "(Ljava/lang/String;)Lid/dana/domain/sendmoney/interactor/GetRecentGroup$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Params createParams(String filter) {
                Intrinsics.checkNotNullParameter(filter, "");
                return new Params(filter, null);
            }
        }

        private Params(String str) {
            this.filter = str;
        }

        /* synthetic */ Params(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @JvmName(name = "getFilter$domain_productionRelease")
        /* renamed from: getFilter$domain_productionRelease  reason: from getter */
        public final String getFilter() {
            return this.filter;
        }
    }
}
