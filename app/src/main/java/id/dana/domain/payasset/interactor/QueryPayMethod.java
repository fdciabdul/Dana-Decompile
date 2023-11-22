package id.dana.domain.payasset.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.payasset.model.QueryPayMethodResponse;
import id.dana.domain.payasset.repository.PayAssetRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/payasset/interactor/QueryPayMethod;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/payasset/model/QueryPayMethodResponse;", "Lid/dana/domain/payasset/interactor/QueryPayMethod$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/payasset/interactor/QueryPayMethod$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/payasset/repository/PayAssetRepository;", "payAssetRepository", "Lid/dana/domain/payasset/repository/PayAssetRepository;", "<init>", "(Lid/dana/domain/payasset/repository/PayAssetRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class QueryPayMethod extends BaseUseCase<QueryPayMethodResponse, Params> {
    private final PayAssetRepository payAssetRepository;

    @Inject
    public QueryPayMethod(PayAssetRepository payAssetRepository) {
        Intrinsics.checkNotNullParameter(payAssetRepository, "");
        this.payAssetRepository = payAssetRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<QueryPayMethodResponse> buildUseCase(Params params) {
        Observable<QueryPayMethodResponse> queryPayMethod = this.payAssetRepository.queryPayMethod(params != null ? params.getUtdid() : null, params != null ? params.getScene() : null, params != null ? params.getInvalidateCache() : false);
        Intrinsics.checkNotNullExpressionValue(queryPayMethod, "");
        return queryPayMethod;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B'\b\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b"}, d2 = {"Lid/dana/domain/payasset/interactor/QueryPayMethod$Params;", "", "", "invalidateCache", "Z", "getInvalidateCache", "()Z", "", "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "utdid", "getUtdid", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean invalidateCache;
        private final String scene;
        private final String utdid;

        public /* synthetic */ Params(String str, String str2, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, z);
        }

        private Params(String str, String str2, boolean z) {
            this.utdid = str;
            this.scene = str2;
            this.invalidateCache = z;
        }

        /* synthetic */ Params(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? false : z);
        }

        @JvmName(name = "getUtdid")
        public final String getUtdid() {
            return this.utdid;
        }

        @JvmName(name = "getScene")
        public final String getScene() {
            return this.scene;
        }

        @JvmName(name = "getInvalidateCache")
        public final boolean getInvalidateCache() {
            return this.invalidateCache;
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/payasset/interactor/QueryPayMethod$Params$Companion;", "", "", "utdid", "", "invalidateCache", "Lid/dana/domain/payasset/interactor/QueryPayMethod$Params;", "forF2FPayUtdid", "(Ljava/lang/String;Z)Lid/dana/domain/payasset/interactor/QueryPayMethod$Params;", "scene", "forQueryAsset", "(Ljava/lang/String;Ljava/lang/String;Z)Lid/dana/domain/payasset/interactor/QueryPayMethod$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Params forF2FPayUtdid(String utdid, boolean invalidateCache) {
                Intrinsics.checkNotNullParameter(utdid, "");
                return new Params(utdid, null, invalidateCache, 2, null);
            }

            public final Params forQueryAsset(String utdid, String scene, boolean invalidateCache) {
                Intrinsics.checkNotNullParameter(utdid, "");
                Intrinsics.checkNotNullParameter(scene, "");
                return new Params(utdid, scene, invalidateCache, null);
            }
        }
    }
}
