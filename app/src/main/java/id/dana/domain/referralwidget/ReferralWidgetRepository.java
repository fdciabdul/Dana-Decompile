package id.dana.domain.referralwidget;

import id.dana.domain.referralwidget.model.ReferralWidget;
import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes2.dex */
public interface ReferralWidgetRepository {
    Observable<List<ReferralWidget>> getReferralWidget();
}
