package id.dana.domain.permissionprompt.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.permissionprompt.PermissionPromptRepository;
import id.dana.domain.permissionprompt.model.NumberOfLocationPermissionPromptShown;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B\u0011\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ5\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\u000e\u0012\f\u0012\b\u0012\u0006*\u00020\u00020\u00020\u00050\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/domain/permissionprompt/interactor/SaveNumberOfLocationPermissionShownData;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/permissionprompt/interactor/SaveNumberOfLocationPermissionShownData$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/permissionprompt/interactor/SaveNumberOfLocationPermissionShownData$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/permissionprompt/model/NumberOfLocationPermissionPromptShown;", "getLocationPermissionPromptData", "()Lio/reactivex/Observable;", "", "currentTimestamp", "", "isNewUser", "Lkotlin/Function1;", "saveLocationPermissionPromptData", "(JZ)Lkotlin/jvm/functions/Function1;", "Lid/dana/domain/permissionprompt/PermissionPromptRepository;", "permissionPromptRepository", "Lid/dana/domain/permissionprompt/PermissionPromptRepository;", "<init>", "(Lid/dana/domain/permissionprompt/PermissionPromptRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SaveNumberOfLocationPermissionShownData extends BaseUseCase<Unit, Params> {
    private final PermissionPromptRepository permissionPromptRepository;

    @Inject
    public SaveNumberOfLocationPermissionShownData(PermissionPromptRepository permissionPromptRepository) {
        Intrinsics.checkNotNullParameter(permissionPromptRepository, "");
        this.permissionPromptRepository = permissionPromptRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Unit> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<NumberOfLocationPermissionPromptShown> locationPermissionPromptData = getLocationPermissionPromptData();
        final Function1<NumberOfLocationPermissionPromptShown, Observable<Unit>> saveLocationPermissionPromptData = saveLocationPermissionPromptData(params.getCurrentTimestamp(), params.getIsNewRegisteredUser());
        Observable flatMap = locationPermissionPromptData.flatMap(new Function() { // from class: id.dana.domain.permissionprompt.interactor.SaveNumberOfLocationPermissionShownData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2409buildUseCase$lambda0;
                m2409buildUseCase$lambda0 = SaveNumberOfLocationPermissionShownData.m2409buildUseCase$lambda0(Function1.this, (NumberOfLocationPermissionPromptShown) obj);
                return m2409buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final ObservableSource m2409buildUseCase$lambda0(Function1 function1, NumberOfLocationPermissionPromptShown numberOfLocationPermissionPromptShown) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (ObservableSource) function1.invoke(numberOfLocationPermissionPromptShown);
    }

    private final Observable<NumberOfLocationPermissionPromptShown> getLocationPermissionPromptData() {
        return this.permissionPromptRepository.getNumberOfLocationPermissionPromptShown();
    }

    private final Function1<NumberOfLocationPermissionPromptShown, Observable<Unit>> saveLocationPermissionPromptData(long currentTimestamp, boolean isNewUser) {
        return new SaveNumberOfLocationPermissionShownData$saveLocationPermissionPromptData$1(isNewUser, currentTimestamp, this);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n"}, d2 = {"Lid/dana/domain/permissionprompt/interactor/SaveNumberOfLocationPermissionShownData$Params;", "", "", "currentTimestamp", "J", "getCurrentTimestamp", "()J", "", "isNewRegisteredUser", "Z", "()Z", "<init>", "(JZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final long currentTimestamp;
        private final boolean isNewRegisteredUser;

        public Params(long j, boolean z) {
            this.currentTimestamp = j;
            this.isNewRegisteredUser = z;
        }

        @JvmName(name = "getCurrentTimestamp")
        public final long getCurrentTimestamp() {
            return this.currentTimestamp;
        }

        @JvmName(name = "isNewRegisteredUser")
        /* renamed from: isNewRegisteredUser  reason: from getter */
        public final boolean getIsNewRegisteredUser() {
            return this.isNewRegisteredUser;
        }
    }
}
