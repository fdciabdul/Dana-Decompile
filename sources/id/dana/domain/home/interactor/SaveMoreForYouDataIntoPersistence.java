package id.dana.domain.home.interactor;

import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.domain.home.HomeWidgetRepository;
import id.dana.domain.home.model.MoreForYouData;
import io.reactivex.Completable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/domain/home/interactor/SaveMoreForYouDataIntoPersistence;", "Lid/dana/domain/core/usecase/CompletableUseCase;", "Lid/dana/domain/home/interactor/SaveMoreForYouDataIntoPersistence$Params;", "params", "Lio/reactivex/Completable;", "buildUseCase", "(Lid/dana/domain/home/interactor/SaveMoreForYouDataIntoPersistence$Params;)Lio/reactivex/Completable;", "Lid/dana/domain/home/HomeWidgetRepository;", "homeWidgetRepository", "Lid/dana/domain/home/HomeWidgetRepository;", "<init>", "(Lid/dana/domain/home/HomeWidgetRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SaveMoreForYouDataIntoPersistence extends CompletableUseCase<Params> {
    private final HomeWidgetRepository homeWidgetRepository;

    @Inject
    public SaveMoreForYouDataIntoPersistence(HomeWidgetRepository homeWidgetRepository) {
        Intrinsics.checkNotNullParameter(homeWidgetRepository, "");
        this.homeWidgetRepository = homeWidgetRepository;
    }

    @Override // id.dana.domain.core.usecase.CompletableUseCase
    public final Completable buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.homeWidgetRepository.saveMoreForYouDataIntoPersistence(params.getMoreForYouData());
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005"}, d2 = {"Lid/dana/domain/home/interactor/SaveMoreForYouDataIntoPersistence$Params;", "", "", "Lid/dana/domain/home/model/MoreForYouData;", "component1", "()Ljava/util/List;", "moreForYouData", "copy", "(Ljava/util/List;)Lid/dana/domain/home/interactor/SaveMoreForYouDataIntoPersistence$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getMoreForYouData", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final List<MoreForYouData> moreForYouData;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Params copy$default(Params params, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = params.moreForYouData;
            }
            return params.copy(list);
        }

        public final List<MoreForYouData> component1() {
            return this.moreForYouData;
        }

        public final Params copy(List<MoreForYouData> moreForYouData) {
            Intrinsics.checkNotNullParameter(moreForYouData, "");
            return new Params(moreForYouData);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Params) && Intrinsics.areEqual(this.moreForYouData, ((Params) other).moreForYouData);
        }

        public final int hashCode() {
            return this.moreForYouData.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(moreForYouData=");
            sb.append(this.moreForYouData);
            sb.append(')');
            return sb.toString();
        }

        public Params(List<MoreForYouData> list) {
            Intrinsics.checkNotNullParameter(list, "");
            this.moreForYouData = list;
        }

        @JvmName(name = "getMoreForYouData")
        public final List<MoreForYouData> getMoreForYouData() {
            return this.moreForYouData;
        }
    }
}
