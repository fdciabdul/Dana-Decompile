package id.dana.domain.version.interactor;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/domain/version/interactor/GetUpdateAvailability;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Observable;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "", "isGooglePlayServiceAvailable", "()Z", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetUpdateAvailability extends BaseUseCase<Integer, NoParams> {
    private final Context context;

    @Inject
    public GetUpdateAvailability(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.context = context;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Integer> buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<Integer> timeout = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.domain.version.interactor.GetUpdateAvailability$$ExternalSyntheticLambda3
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                GetUpdateAvailability.m2520buildUseCase$lambda3(GetUpdateAvailability.this, observableEmitter);
            }
        }).timeout(2L, TimeUnit.SECONDS);
        Intrinsics.checkNotNullExpressionValue(timeout, "");
        return timeout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-3  reason: not valid java name */
    public static final void m2520buildUseCase$lambda3(GetUpdateAvailability getUpdateAvailability, final ObservableEmitter observableEmitter) {
        Intrinsics.checkNotNullParameter(getUpdateAvailability, "");
        Intrinsics.checkNotNullParameter(observableEmitter, "");
        if (getUpdateAvailability.isGooglePlayServiceAvailable()) {
            AppUpdateManager create = AppUpdateManagerFactory.create(getUpdateAvailability.context);
            Intrinsics.checkNotNullExpressionValue(create, "");
            Task<AppUpdateInfo> appUpdateInfo = create.getAppUpdateInfo();
            Intrinsics.checkNotNullExpressionValue(appUpdateInfo, "");
            appUpdateInfo.addOnSuccessListener(new OnSuccessListener() { // from class: id.dana.domain.version.interactor.GetUpdateAvailability$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    GetUpdateAvailability.m2521buildUseCase$lambda3$lambda0(ObservableEmitter.this, (AppUpdateInfo) obj);
                }
            });
            appUpdateInfo.addOnFailureListener(new OnFailureListener() { // from class: id.dana.domain.version.interactor.GetUpdateAvailability$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    GetUpdateAvailability.m2522buildUseCase$lambda3$lambda1(ObservableEmitter.this, exc);
                }
            });
            appUpdateInfo.addOnCompleteListener(new OnCompleteListener() { // from class: id.dana.domain.version.interactor.GetUpdateAvailability$$ExternalSyntheticLambda2
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    GetUpdateAvailability.m2523buildUseCase$lambda3$lambda2(ObservableEmitter.this, task);
                }
            });
            return;
        }
        observableEmitter.onError(new GooglePlayServicesNotAvailableException(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-3$lambda-0  reason: not valid java name */
    public static final void m2521buildUseCase$lambda3$lambda0(ObservableEmitter observableEmitter, AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkNotNullParameter(observableEmitter, "");
        observableEmitter.onNext(Integer.valueOf(appUpdateInfo.updateAvailability()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-3$lambda-1  reason: not valid java name */
    public static final void m2522buildUseCase$lambda3$lambda1(ObservableEmitter observableEmitter, Exception exc) {
        Intrinsics.checkNotNullParameter(observableEmitter, "");
        Intrinsics.checkNotNullParameter(exc, "");
        observableEmitter.onError(exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-3$lambda-2  reason: not valid java name */
    public static final void m2523buildUseCase$lambda3$lambda2(ObservableEmitter observableEmitter, Task task) {
        Intrinsics.checkNotNullParameter(observableEmitter, "");
        Intrinsics.checkNotNullParameter(task, "");
        observableEmitter.onComplete();
    }

    @JvmName(name = "isGooglePlayServiceAvailable")
    private final boolean isGooglePlayServiceAvailable() {
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this.context) == 0;
    }
}
