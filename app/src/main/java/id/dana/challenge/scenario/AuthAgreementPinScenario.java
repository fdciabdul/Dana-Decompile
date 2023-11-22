package id.dana.challenge.scenario;

import android.os.Bundle;
import id.dana.challenge.pin.PinChallengeFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0004\u001a\f\u0012\b\u0012\u0006*\u00020\u00030\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\b\u001a\f\u0012\b\u0012\u0006*\u00020\u00030\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/challenge/scenario/AuthAgreementPinScenario;", "Lid/dana/challenge/scenario/ScenarioFacade;", "", "Lid/dana/challenge/pin/PinChallengeFragment;", "getAuthRequestContext", "()Ljava/util/List;", "PlaceComponentResult", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "Landroid/os/Bundle;", "p0", "<init>", "(Landroid/os/Bundle;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuthAgreementPinScenario implements ScenarioFacade {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final List<PinChallengeFragment> BuiltInFictitiousFunctionClassFactory;

    public AuthAgreementPinScenario(Bundle bundle) {
        this.BuiltInFictitiousFunctionClassFactory = CollectionsKt.mutableListOf(PinChallengeFragment.getAuthRequestContext(bundle));
    }

    @Override // id.dana.challenge.scenario.ScenarioFacade
    public final List<PinChallengeFragment> getAuthRequestContext() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
