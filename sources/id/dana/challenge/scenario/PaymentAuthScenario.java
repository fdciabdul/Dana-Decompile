package id.dana.challenge.scenario;

import android.os.Bundle;
import id.dana.base.BaseFragment;
import id.dana.challenge.pin.PinChallengeFragment;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class PaymentAuthScenario implements ScenarioFacade {
    private List<BaseFragment> PlaceComponentResult;

    public PaymentAuthScenario(Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        this.PlaceComponentResult = arrayList;
        arrayList.add(PinChallengeFragment.getAuthRequestContext(bundle));
    }

    @Override // id.dana.challenge.scenario.ScenarioFacade
    public final List<BaseFragment> getAuthRequestContext() {
        return this.PlaceComponentResult;
    }
}
