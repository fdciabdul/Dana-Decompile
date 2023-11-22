package id.dana.domain.profilemenu.interactor;

import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.domain.profilemenu.SettingRepository;
import io.reactivex.Completable;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/domain/profilemenu/interactor/SaveLastHideRedDotTimestamp;", "Lid/dana/domain/core/usecase/CompletableUseCase;", "", "params", "Lio/reactivex/Completable;", "buildUseCase", "(Ljava/lang/String;)Lio/reactivex/Completable;", "Lid/dana/domain/profilemenu/SettingRepository;", "settingRepository", "Lid/dana/domain/profilemenu/SettingRepository;", "<init>", "(Lid/dana/domain/profilemenu/SettingRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SaveLastHideRedDotTimestamp extends CompletableUseCase<String> {
    private final SettingRepository settingRepository;

    @Inject
    public SaveLastHideRedDotTimestamp(SettingRepository settingRepository) {
        Intrinsics.checkNotNullParameter(settingRepository, "");
        this.settingRepository = settingRepository;
    }

    @Override // id.dana.domain.core.usecase.CompletableUseCase
    public final Completable buildUseCase(String params) {
        Intrinsics.checkNotNullParameter(params, "");
        this.settingRepository.saveLastHideSettingRedDotTimestamp(params);
        Completable ignoreElements = Observable.just(Unit.INSTANCE).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "");
        return ignoreElements;
    }
}
