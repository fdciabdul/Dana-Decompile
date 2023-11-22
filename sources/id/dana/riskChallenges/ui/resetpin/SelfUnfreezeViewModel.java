package id.dana.riskChallenges.ui.resetpin;

import androidx.view.ViewModel;
import id.dana.domain.resetpin.interactor.SaveDanaVizPromptAfterResetPin;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/SelfUnfreezeViewModel;", "Landroidx/lifecycle/ViewModel;", "Lid/dana/domain/resetpin/interactor/SaveDanaVizPromptAfterResetPin;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/resetpin/interactor/SaveDanaVizPromptAfterResetPin;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Lid/dana/domain/resetpin/interactor/SaveDanaVizPromptAfterResetPin;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelfUnfreezeViewModel extends ViewModel {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final SaveDanaVizPromptAfterResetPin BuiltInFictitiousFunctionClassFactory;

    @Inject
    public SelfUnfreezeViewModel(SaveDanaVizPromptAfterResetPin saveDanaVizPromptAfterResetPin) {
        Intrinsics.checkNotNullParameter(saveDanaVizPromptAfterResetPin, "");
        this.BuiltInFictitiousFunctionClassFactory = saveDanaVizPromptAfterResetPin;
    }
}
