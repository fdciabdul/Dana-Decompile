package id.dana.domain.home.interactor;

import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.domain.home.HomeWidgetRepository;
import id.dana.domain.home.model.PromoBannerContentModel;
import io.reactivex.Completable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/domain/home/interactor/SavePromoBannerCdpContentIntoPersistence;", "Lid/dana/domain/core/usecase/CompletableUseCase;", "Lid/dana/domain/home/interactor/SavePromoBannerCdpContentIntoPersistence$Params;", "params", "Lio/reactivex/Completable;", "buildUseCase", "(Lid/dana/domain/home/interactor/SavePromoBannerCdpContentIntoPersistence$Params;)Lio/reactivex/Completable;", "Lid/dana/domain/home/HomeWidgetRepository;", "homeWidgetRepository", "Lid/dana/domain/home/HomeWidgetRepository;", "<init>", "(Lid/dana/domain/home/HomeWidgetRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SavePromoBannerCdpContentIntoPersistence extends CompletableUseCase<Params> {
    private final HomeWidgetRepository homeWidgetRepository;

    @Inject
    public SavePromoBannerCdpContentIntoPersistence(HomeWidgetRepository homeWidgetRepository) {
        Intrinsics.checkNotNullParameter(homeWidgetRepository, "");
        this.homeWidgetRepository = homeWidgetRepository;
    }

    @Override // id.dana.domain.core.usecase.CompletableUseCase
    public final Completable buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.homeWidgetRepository.savePromoBannerCdpContentIntoPersistence(params.getPromoBannerContentModels());
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/domain/home/interactor/SavePromoBannerCdpContentIntoPersistence$Params;", "", "", "Lid/dana/domain/home/model/PromoBannerContentModel;", "promoBannerContentModels", "Ljava/util/List;", "getPromoBannerContentModels", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final List<PromoBannerContentModel> promoBannerContentModels;

        public Params(List<PromoBannerContentModel> list) {
            Intrinsics.checkNotNullParameter(list, "");
            this.promoBannerContentModels = list;
        }

        @JvmName(name = "getPromoBannerContentModels")
        public final List<PromoBannerContentModel> getPromoBannerContentModels() {
            return this.promoBannerContentModels;
        }
    }
}
