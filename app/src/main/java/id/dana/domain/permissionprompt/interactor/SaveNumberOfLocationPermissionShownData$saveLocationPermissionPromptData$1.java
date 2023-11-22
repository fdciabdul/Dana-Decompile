package id.dana.domain.permissionprompt.interactor;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.domain.permissionprompt.PermissionPromptRepository;
import id.dana.domain.permissionprompt.model.NumberOfLocationPermissionPromptShown;
import io.reactivex.Observable;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\f\u0012\b\u0012\u0006*\u00020\u00030\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/domain/permissionprompt/model/NumberOfLocationPermissionPromptShown;", "currentPromptData", "Lio/reactivex/Observable;", "", BridgeDSL.INVOKE, "(Lid/dana/domain/permissionprompt/model/NumberOfLocationPermissionPromptShown;)Lio/reactivex/Observable;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SaveNumberOfLocationPermissionShownData$saveLocationPermissionPromptData$1 extends Lambda implements Function1<NumberOfLocationPermissionPromptShown, Observable<Unit>> {
    final /* synthetic */ long $$currentTimestamp;
    final /* synthetic */ boolean $$isNewUser;
    final /* synthetic */ SaveNumberOfLocationPermissionShownData this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaveNumberOfLocationPermissionShownData$saveLocationPermissionPromptData$1(boolean z, long j, SaveNumberOfLocationPermissionShownData saveNumberOfLocationPermissionShownData) {
        super(1);
        this.$$isNewUser = z;
        this.$$currentTimestamp = j;
        this.this$0 = saveNumberOfLocationPermissionShownData;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Observable<Unit> invoke(NumberOfLocationPermissionPromptShown numberOfLocationPermissionPromptShown) {
        final NumberOfLocationPermissionPromptShown numberOfLocationPermissionPromptShown2;
        Intrinsics.checkNotNullParameter(numberOfLocationPermissionPromptShown, "");
        if (this.$$isNewUser) {
            numberOfLocationPermissionPromptShown2 = new NumberOfLocationPermissionPromptShown(0, this.$$currentTimestamp);
        } else {
            numberOfLocationPermissionPromptShown2 = new NumberOfLocationPermissionPromptShown(numberOfLocationPermissionPromptShown.getTotalReminderUIShowed() + 1, this.$$currentTimestamp);
        }
        final SaveNumberOfLocationPermissionShownData saveNumberOfLocationPermissionShownData = this.this$0;
        return Observable.fromCallable(new Callable() { // from class: id.dana.domain.permissionprompt.interactor.SaveNumberOfLocationPermissionShownData$saveLocationPermissionPromptData$1$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit m2411invoke$lambda0;
                m2411invoke$lambda0 = SaveNumberOfLocationPermissionShownData$saveLocationPermissionPromptData$1.m2411invoke$lambda0(SaveNumberOfLocationPermissionShownData.this, numberOfLocationPermissionPromptShown2);
                return m2411invoke$lambda0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final Unit m2411invoke$lambda0(SaveNumberOfLocationPermissionShownData saveNumberOfLocationPermissionShownData, NumberOfLocationPermissionPromptShown numberOfLocationPermissionPromptShown) {
        PermissionPromptRepository permissionPromptRepository;
        Intrinsics.checkNotNullParameter(saveNumberOfLocationPermissionShownData, "");
        Intrinsics.checkNotNullParameter(numberOfLocationPermissionPromptShown, "");
        permissionPromptRepository = saveNumberOfLocationPermissionShownData.permissionPromptRepository;
        permissionPromptRepository.saveNumberOfLocationPermissionPromptShown(numberOfLocationPermissionPromptShown);
        return Unit.INSTANCE;
    }
}
