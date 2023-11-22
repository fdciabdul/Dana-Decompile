package id.dana.data.homeinfo.repository;

import id.dana.data.config.source.split.SplitConfigEntityData;
import id.dana.domain.homeinfo.repository.HomeConfigRepository;
import io.reactivex.Completable;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\t\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/homeinfo/repository/HomeConfigEntityRepository;", "Lid/dana/domain/homeinfo/repository/HomeConfigRepository;", "Lio/reactivex/Completable;", "getFeatureHoldLoginConfig", "()Lio/reactivex/Completable;", "Lio/reactivex/Observable;", "", "getStorageMixpanelConfig", "()Lio/reactivex/Observable;", "getVoiceAssistantConfig", "Lid/dana/data/config/source/split/SplitConfigEntityData;", "splitConfigEntityData", "Lid/dana/data/config/source/split/SplitConfigEntityData;", "<init>", "(Lid/dana/data/config/source/split/SplitConfigEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HomeConfigEntityRepository implements HomeConfigRepository {
    private final SplitConfigEntityData splitConfigEntityData;

    @Inject
    public HomeConfigEntityRepository(SplitConfigEntityData splitConfigEntityData) {
        Intrinsics.checkNotNullParameter(splitConfigEntityData, "");
        this.splitConfigEntityData = splitConfigEntityData;
    }

    @Override // id.dana.domain.homeinfo.repository.HomeConfigRepository
    public final Observable<Boolean> getStorageMixpanelConfig() {
        return this.splitConfigEntityData.isMixpanelStorageTrackEnabled();
    }

    @Override // id.dana.domain.homeinfo.repository.HomeConfigRepository
    public final Observable<Boolean> getVoiceAssistantConfig() {
        return this.splitConfigEntityData.isFeatureVoiceAssistantEnable();
    }

    @Override // id.dana.domain.homeinfo.repository.HomeConfigRepository
    public final Completable getFeatureHoldLoginConfig() {
        Completable ignoreElements = this.splitConfigEntityData.getFeatureHoldLoginConfig().ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "");
        return ignoreElements;
    }
}
