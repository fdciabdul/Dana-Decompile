package id.dana.domain.miniprogram.interactor;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.domain.miniprogram.MiniProgramRepository;
import io.reactivex.Completable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/domain/miniprogram/interactor/SetRecentMiniProgram;", "Lid/dana/domain/core/usecase/CompletableUseCase;", "Lid/dana/domain/miniprogram/interactor/SetRecentMiniProgram$Params;", "params", "Lio/reactivex/Completable;", "buildUseCase", "(Lid/dana/domain/miniprogram/interactor/SetRecentMiniProgram$Params;)Lio/reactivex/Completable;", "Lid/dana/domain/miniprogram/MiniProgramRepository;", "repository", "Lid/dana/domain/miniprogram/MiniProgramRepository;", "<init>", "(Lid/dana/domain/miniprogram/MiniProgramRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SetRecentMiniProgram extends CompletableUseCase<Params> {
    private final MiniProgramRepository repository;

    @Inject
    public SetRecentMiniProgram(MiniProgramRepository miniProgramRepository) {
        Intrinsics.checkNotNullParameter(miniProgramRepository, "");
        this.repository = miniProgramRepository;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007"}, d2 = {"Lid/dana/domain/miniprogram/interactor/SetRecentMiniProgram$Params;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()J", "appId", "lastOpen", "copy", "(Ljava/lang/String;J)Lid/dana/domain/miniprogram/interactor/SetRecentMiniProgram$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAppId", "J", "getLastOpen", "<init>", "(Ljava/lang/String;J)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final String appId;
        private final long lastOpen;

        public static /* synthetic */ Params copy$default(Params params, String str, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.appId;
            }
            if ((i & 2) != 0) {
                j = params.lastOpen;
            }
            return params.copy(str, j);
        }

        /* renamed from: component1  reason: from getter */
        public final String getAppId() {
            return this.appId;
        }

        /* renamed from: component2  reason: from getter */
        public final long getLastOpen() {
            return this.lastOpen;
        }

        public final Params copy(String appId, long lastOpen) {
            Intrinsics.checkNotNullParameter(appId, "");
            return new Params(appId, lastOpen);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return Intrinsics.areEqual(this.appId, params.appId) && this.lastOpen == params.lastOpen;
            }
            return false;
        }

        public final int hashCode() {
            return (this.appId.hashCode() * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.lastOpen);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(appId=");
            sb.append(this.appId);
            sb.append(", lastOpen=");
            sb.append(this.lastOpen);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, long j) {
            Intrinsics.checkNotNullParameter(str, "");
            this.appId = str;
            this.lastOpen = j;
        }

        @JvmName(name = "getAppId")
        public final String getAppId() {
            return this.appId;
        }

        public /* synthetic */ Params(String str, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? System.currentTimeMillis() : j);
        }

        @JvmName(name = "getLastOpen")
        public final long getLastOpen() {
            return this.lastOpen;
        }
    }

    @Override // id.dana.domain.core.usecase.CompletableUseCase
    public final Completable buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Completable ignoreElements = this.repository.setRecentMiniProgram(params.getAppId(), params.getLastOpen()).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "");
        return ignoreElements;
    }
}
