package id.dana.domain.version.interactor;

import id.dana.analytics.tracker.TrackerKey;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.version.VersionRepository;
import id.dana.domain.version.interactor.GetAppStatus;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/version/interactor/GetAppStatus;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/version/interactor/GetAppStatus$Status;", "", "params", "Lio/reactivex/Observable;", "buildUseCase", "(I)Lio/reactivex/Observable;", "Lid/dana/domain/version/VersionRepository;", "versionRepository", "Lid/dana/domain/version/VersionRepository;", "<init>", "(Lid/dana/domain/version/VersionRepository;)V", "Status"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class GetAppStatus extends BaseUseCase<Status, Integer> {
    private final VersionRepository versionRepository;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-6$lambda-4$lambda-2$lambda-1  reason: not valid java name */
    public static final Boolean m2515buildUseCase$lambda6$lambda4$lambda2$lambda1(Boolean bool, Boolean bool2) {
        Intrinsics.checkNotNullParameter(bool, "");
        Intrinsics.checkNotNullParameter(bool2, "");
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-6$lambda-4$lambda-3  reason: not valid java name */
    public static final Status m2516buildUseCase$lambda6$lambda4$lambda3(Status status, Boolean bool) {
        Intrinsics.checkNotNullParameter(status, "");
        Intrinsics.checkNotNullParameter(bool, "");
        return status;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<Status> buildUseCase(Integer num) {
        return buildUseCase(num.intValue());
    }

    @Inject
    public GetAppStatus(VersionRepository versionRepository) {
        Intrinsics.checkNotNullParameter(versionRepository, "");
        this.versionRepository = versionRepository;
    }

    public final Observable<Status> buildUseCase(final int params) {
        Observable flatMap = this.versionRepository.getAppVersionCode().flatMap(new Function() { // from class: id.dana.domain.version.interactor.GetAppStatus$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2511buildUseCase$lambda6;
                m2511buildUseCase$lambda6 = GetAppStatus.m2511buildUseCase$lambda6(GetAppStatus.this, params, (Integer) obj);
                return m2511buildUseCase$lambda6;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-6  reason: not valid java name */
    public static final ObservableSource m2511buildUseCase$lambda6(final GetAppStatus getAppStatus, final int i, Integer num) {
        Observable just;
        Intrinsics.checkNotNullParameter(getAppStatus, "");
        Intrinsics.checkNotNullParameter(num, "");
        if (num.intValue() <= 0) {
            just = getAppStatus.versionRepository.getStorageVersion().map(new Function() { // from class: id.dana.domain.version.interactor.GetAppStatus$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Boolean m2512buildUseCase$lambda6$lambda0;
                    m2512buildUseCase$lambda6$lambda0 = GetAppStatus.m2512buildUseCase$lambda6$lambda0((Integer) obj);
                    return m2512buildUseCase$lambda6$lambda0;
                }
            }).flatMap(new Function() { // from class: id.dana.domain.version.interactor.GetAppStatus$$ExternalSyntheticLambda3
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource m2513buildUseCase$lambda6$lambda4;
                    m2513buildUseCase$lambda6$lambda4 = GetAppStatus.m2513buildUseCase$lambda6$lambda4(GetAppStatus.this, i, (Boolean) obj);
                    return m2513buildUseCase$lambda6$lambda4;
                }
            });
        } else if (num.intValue() < i) {
            just = getAppStatus.versionRepository.setAppVersionCode(i).map(new Function() { // from class: id.dana.domain.version.interactor.GetAppStatus$$ExternalSyntheticLambda4
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    GetAppStatus.Status.Update m2517buildUseCase$lambda6$lambda5;
                    m2517buildUseCase$lambda6$lambda5 = GetAppStatus.m2517buildUseCase$lambda6$lambda5((Boolean) obj);
                    return m2517buildUseCase$lambda6$lambda5;
                }
            });
        } else {
            just = Observable.just(Status.NoUpdate.INSTANCE);
        }
        return just;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-6$lambda-0  reason: not valid java name */
    public static final Boolean m2512buildUseCase$lambda6$lambda0(Integer num) {
        Intrinsics.checkNotNullParameter(num, "");
        return Boolean.valueOf(num.intValue() <= 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-6$lambda-4  reason: not valid java name */
    public static final ObservableSource m2513buildUseCase$lambda6$lambda4(final GetAppStatus getAppStatus, int i, Boolean bool) {
        final Status.Update update;
        Intrinsics.checkNotNullParameter(getAppStatus, "");
        Intrinsics.checkNotNullParameter(bool, "");
        if (bool.booleanValue()) {
            update = Status.Install.INSTANCE;
        } else {
            update = Status.Update.INSTANCE;
        }
        return getAppStatus.versionRepository.setAppVersionCode(i).flatMap(new Function() { // from class: id.dana.domain.version.interactor.GetAppStatus$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2514buildUseCase$lambda6$lambda4$lambda2;
                m2514buildUseCase$lambda6$lambda4$lambda2 = GetAppStatus.m2514buildUseCase$lambda6$lambda4$lambda2(GetAppStatus.this, (Boolean) obj);
                return m2514buildUseCase$lambda6$lambda4$lambda2;
            }
        }).map(new Function() { // from class: id.dana.domain.version.interactor.GetAppStatus$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                GetAppStatus.Status m2516buildUseCase$lambda6$lambda4$lambda3;
                m2516buildUseCase$lambda6$lambda4$lambda3 = GetAppStatus.m2516buildUseCase$lambda6$lambda4$lambda3(GetAppStatus.Status.this, (Boolean) obj);
                return m2516buildUseCase$lambda6$lambda4$lambda3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-6$lambda-4$lambda-2  reason: not valid java name */
    public static final ObservableSource m2514buildUseCase$lambda6$lambda4$lambda2(GetAppStatus getAppStatus, final Boolean bool) {
        Intrinsics.checkNotNullParameter(getAppStatus, "");
        Intrinsics.checkNotNullParameter(bool, "");
        return getAppStatus.versionRepository.setStorageVersion(1).map(new Function() { // from class: id.dana.domain.version.interactor.GetAppStatus$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean m2515buildUseCase$lambda6$lambda4$lambda2$lambda1;
                m2515buildUseCase$lambda6$lambda4$lambda2$lambda1 = GetAppStatus.m2515buildUseCase$lambda6$lambda4$lambda2$lambda1(bool, (Boolean) obj);
                return m2515buildUseCase$lambda6$lambda4$lambda2$lambda1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-6$lambda-5  reason: not valid java name */
    public static final Status.Update m2517buildUseCase$lambda6$lambda5(Boolean bool) {
        Intrinsics.checkNotNullParameter(bool, "");
        return Status.Update.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t"}, d2 = {"Lid/dana/domain/version/interactor/GetAppStatus$Status;", "", "<init>", "()V", TrackerKey.AppUpdateAction.APP_UPDATE_INSTALL, "NoUpdate", "Update", "Lid/dana/domain/version/interactor/GetAppStatus$Status$Install;", "Lid/dana/domain/version/interactor/GetAppStatus$Status$Update;", "Lid/dana/domain/version/interactor/GetAppStatus$Status$NoUpdate;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static abstract class Status {
        public /* synthetic */ Status(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/version/interactor/GetAppStatus$Status$Install;", "Lid/dana/domain/version/interactor/GetAppStatus$Status;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes8.dex */
        public static final class Install extends Status {
            public static final Install INSTANCE = new Install();

            private Install() {
                super(null);
            }
        }

        private Status() {
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/version/interactor/GetAppStatus$Status$Update;", "Lid/dana/domain/version/interactor/GetAppStatus$Status;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes8.dex */
        public static final class Update extends Status {
            public static final Update INSTANCE = new Update();

            private Update() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/version/interactor/GetAppStatus$Status$NoUpdate;", "Lid/dana/domain/version/interactor/GetAppStatus$Status;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes8.dex */
        public static final class NoUpdate extends Status {
            public static final NoUpdate INSTANCE = new NoUpdate();

            private NoUpdate() {
                super(null);
            }
        }
    }
}
