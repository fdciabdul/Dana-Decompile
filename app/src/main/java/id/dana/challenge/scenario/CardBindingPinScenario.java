package id.dana.challenge.scenario;

import android.os.Bundle;
import id.dana.challenge.pin.CardBindingPinChallengeFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0006"}, d2 = {"Lid/dana/challenge/scenario/CardBindingPinScenario;", "Lid/dana/challenge/scenario/ScenarioFacade;", "", "Lid/dana/challenge/pin/CardBindingPinChallengeFragment;", "getAuthRequestContext", "()Ljava/util/List;", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "Landroid/os/Bundle;", "p0", "<init>", "(Landroid/os/Bundle;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CardBindingPinScenario implements ScenarioFacade {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final List<CardBindingPinChallengeFragment> BuiltInFictitiousFunctionClassFactory;

    public CardBindingPinScenario(Bundle bundle) {
        CardBindingPinChallengeFragment.Companion companion = CardBindingPinChallengeFragment.INSTANCE;
        this.BuiltInFictitiousFunctionClassFactory = CollectionsKt.mutableListOf(CardBindingPinChallengeFragment.Companion.KClassImpl$Data$declaredNonStaticMembers$2(bundle));
    }

    @Override // id.dana.challenge.scenario.ScenarioFacade
    public final List<CardBindingPinChallengeFragment> getAuthRequestContext() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
