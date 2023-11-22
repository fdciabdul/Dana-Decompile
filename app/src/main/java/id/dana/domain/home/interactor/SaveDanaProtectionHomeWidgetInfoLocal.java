package id.dana.domain.home.interactor;

import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.domain.home.HomeWidgetRepository;
import id.dana.domain.home.model.DanaProtectionHomeWidgetInfoModel;
import io.reactivex.Completable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/domain/home/interactor/SaveDanaProtectionHomeWidgetInfoLocal;", "Lid/dana/domain/core/usecase/CompletableUseCase;", "Lid/dana/domain/home/model/DanaProtectionHomeWidgetInfoModel;", "params", "Lio/reactivex/Completable;", "buildUseCase", "(Lid/dana/domain/home/model/DanaProtectionHomeWidgetInfoModel;)Lio/reactivex/Completable;", "Lid/dana/domain/home/HomeWidgetRepository;", "homeWidgetRepository", "Lid/dana/domain/home/HomeWidgetRepository;", "<init>", "(Lid/dana/domain/home/HomeWidgetRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SaveDanaProtectionHomeWidgetInfoLocal extends CompletableUseCase<DanaProtectionHomeWidgetInfoModel> {
    private final HomeWidgetRepository homeWidgetRepository;

    @Inject
    public SaveDanaProtectionHomeWidgetInfoLocal(HomeWidgetRepository homeWidgetRepository) {
        Intrinsics.checkNotNullParameter(homeWidgetRepository, "");
        this.homeWidgetRepository = homeWidgetRepository;
    }

    @Override // id.dana.domain.core.usecase.CompletableUseCase
    public final Completable buildUseCase(DanaProtectionHomeWidgetInfoModel params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.homeWidgetRepository.saveDanaProtectionHomeWidgetInfoLocal(params);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004"}, d2 = {"Lid/dana/domain/home/interactor/SaveDanaProtectionHomeWidgetInfoLocal$Params;", "", "Lid/dana/domain/home/model/DanaProtectionHomeWidgetInfoModel;", "component1", "()Lid/dana/domain/home/model/DanaProtectionHomeWidgetInfoModel;", "danaProtectionHomeWidgetInfoModel", "copy", "(Lid/dana/domain/home/model/DanaProtectionHomeWidgetInfoModel;)Lid/dana/domain/home/interactor/SaveDanaProtectionHomeWidgetInfoLocal$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/domain/home/model/DanaProtectionHomeWidgetInfoModel;", "getDanaProtectionHomeWidgetInfoModel", "<init>", "(Lid/dana/domain/home/model/DanaProtectionHomeWidgetInfoModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final /* data */ class Params {
        private final DanaProtectionHomeWidgetInfoModel danaProtectionHomeWidgetInfoModel;

        public static /* synthetic */ Params copy$default(Params params, DanaProtectionHomeWidgetInfoModel danaProtectionHomeWidgetInfoModel, int i, Object obj) {
            if ((i & 1) != 0) {
                danaProtectionHomeWidgetInfoModel = params.danaProtectionHomeWidgetInfoModel;
            }
            return params.copy(danaProtectionHomeWidgetInfoModel);
        }

        /* renamed from: component1  reason: from getter */
        public final DanaProtectionHomeWidgetInfoModel getDanaProtectionHomeWidgetInfoModel() {
            return this.danaProtectionHomeWidgetInfoModel;
        }

        public final Params copy(DanaProtectionHomeWidgetInfoModel danaProtectionHomeWidgetInfoModel) {
            Intrinsics.checkNotNullParameter(danaProtectionHomeWidgetInfoModel, "");
            return new Params(danaProtectionHomeWidgetInfoModel);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Params) && Intrinsics.areEqual(this.danaProtectionHomeWidgetInfoModel, ((Params) other).danaProtectionHomeWidgetInfoModel);
        }

        public final int hashCode() {
            return this.danaProtectionHomeWidgetInfoModel.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(danaProtectionHomeWidgetInfoModel=");
            sb.append(this.danaProtectionHomeWidgetInfoModel);
            sb.append(')');
            return sb.toString();
        }

        public Params(DanaProtectionHomeWidgetInfoModel danaProtectionHomeWidgetInfoModel) {
            Intrinsics.checkNotNullParameter(danaProtectionHomeWidgetInfoModel, "");
            this.danaProtectionHomeWidgetInfoModel = danaProtectionHomeWidgetInfoModel;
        }

        @JvmName(name = "getDanaProtectionHomeWidgetInfoModel")
        public final DanaProtectionHomeWidgetInfoModel getDanaProtectionHomeWidgetInfoModel() {
            return this.danaProtectionHomeWidgetInfoModel;
        }
    }
}
