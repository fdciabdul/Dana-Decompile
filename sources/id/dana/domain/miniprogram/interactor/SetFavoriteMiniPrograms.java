package id.dana.domain.miniprogram.interactor;

import id.dana.analytics.tracker.TrackerKey;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.miniprogram.MiniProgramRepository;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/miniprogram/interactor/SetFavoriteMiniPrograms;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/miniprogram/interactor/SetFavoriteMiniPrograms$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/miniprogram/interactor/SetFavoriteMiniPrograms$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/miniprogram/MiniProgramRepository;", "repository", "Lid/dana/domain/miniprogram/MiniProgramRepository;", "<init>", "(Lid/dana/domain/miniprogram/MiniProgramRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SetFavoriteMiniPrograms extends BaseUseCase<Unit, Params> {
    private final MiniProgramRepository repository;

    @Inject
    public SetFavoriteMiniPrograms(MiniProgramRepository miniProgramRepository) {
        Intrinsics.checkNotNullParameter(miniProgramRepository, "");
        this.repository = miniProgramRepository;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ4\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0007¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u0018\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\f\u0010\u0007"}, d2 = {"Lid/dana/domain/miniprogram/interactor/SetFavoriteMiniPrograms$Params;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "", "component3", "()Ljava/util/List;", "appId", TrackerKey.SendMoneyProperties.IS_FAVORITE, "allMiniProgramAppIds", "copy", "(Ljava/lang/String;ZLjava/util/List;)Lid/dana/domain/miniprogram/interactor/SetFavoriteMiniPrograms$Params;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/util/List;", "getAllMiniProgramAppIds", "Ljava/lang/String;", "getAppId", "Z", "<init>", "(Ljava/lang/String;ZLjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final List<String> allMiniProgramAppIds;
        private final String appId;
        private final boolean isFavorite;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Params copy$default(Params params, String str, boolean z, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.appId;
            }
            if ((i & 2) != 0) {
                z = params.isFavorite;
            }
            if ((i & 4) != 0) {
                list = params.allMiniProgramAppIds;
            }
            return params.copy(str, z, list);
        }

        /* renamed from: component1  reason: from getter */
        public final String getAppId() {
            return this.appId;
        }

        /* renamed from: component2  reason: from getter */
        public final boolean getIsFavorite() {
            return this.isFavorite;
        }

        public final List<String> component3() {
            return this.allMiniProgramAppIds;
        }

        public final Params copy(String appId, boolean isFavorite, List<String> allMiniProgramAppIds) {
            Intrinsics.checkNotNullParameter(appId, "");
            Intrinsics.checkNotNullParameter(allMiniProgramAppIds, "");
            return new Params(appId, isFavorite, allMiniProgramAppIds);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return Intrinsics.areEqual(this.appId, params.appId) && this.isFavorite == params.isFavorite && Intrinsics.areEqual(this.allMiniProgramAppIds, params.allMiniProgramAppIds);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int hashCode = this.appId.hashCode();
            boolean z = this.isFavorite;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return (((hashCode * 31) + i) * 31) + this.allMiniProgramAppIds.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(appId=");
            sb.append(this.appId);
            sb.append(", isFavorite=");
            sb.append(this.isFavorite);
            sb.append(", allMiniProgramAppIds=");
            sb.append(this.allMiniProgramAppIds);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, boolean z, List<String> list) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(list, "");
            this.appId = str;
            this.isFavorite = z;
            this.allMiniProgramAppIds = list;
        }

        @JvmName(name = "getAppId")
        public final String getAppId() {
            return this.appId;
        }

        @JvmName(name = TrackerKey.SendMoneyProperties.IS_FAVORITE)
        public final boolean isFavorite() {
            return this.isFavorite;
        }

        @JvmName(name = "getAllMiniProgramAppIds")
        public final List<String> getAllMiniProgramAppIds() {
            return this.allMiniProgramAppIds;
        }
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Unit> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.repository.setFavoriteMiniPrograms(params.getAppId(), params.isFavorite(), params.getAllMiniProgramAppIds());
    }
}
