package id.dana.feeds.domain.share.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.feeds.domain.share.FeedsShareRepository;
import id.dana.feeds.domain.share.model.PreviewActivityData;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000bB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/feeds/domain/share/interactor/SkipShareableActivity;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/feeds/domain/share/interactor/SkipShareableActivity$Params;", "Lid/dana/feeds/domain/share/FeedsShareRepository;", "getAuthRequestContext", "Lid/dana/feeds/domain/share/FeedsShareRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Lid/dana/feeds/domain/share/FeedsShareRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SkipShareableActivity extends BaseUseCase<Boolean, Params> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final FeedsShareRepository KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<Boolean> buildUseCase(Params params) {
        Params params2 = params;
        Intrinsics.checkNotNullParameter(params2, "");
        return this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(params2.BuiltInFictitiousFunctionClassFactory);
    }

    @Inject
    public SkipShareableActivity(FeedsShareRepository feedsShareRepository) {
        Intrinsics.checkNotNullParameter(feedsShareRepository, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = feedsShareRepository;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/feeds/domain/share/interactor/SkipShareableActivity$Params;", "", "Lid/dana/feeds/domain/share/model/PreviewActivityData;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/feeds/domain/share/model/PreviewActivityData;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Lid/dana/feeds/domain/share/model/PreviewActivityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Params {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final PreviewActivityData BuiltInFictitiousFunctionClassFactory;

        public Params(PreviewActivityData previewActivityData) {
            Intrinsics.checkNotNullParameter(previewActivityData, "");
            this.BuiltInFictitiousFunctionClassFactory = previewActivityData;
        }
    }
}
