package id.dana.data.referralwidget.repository.source;

import id.dana.data.referralwidget.model.ReferralWidgetResult;
import io.reactivex.Observable;
import java.util.Map;

/* loaded from: classes2.dex */
public interface ReferralWidgetEntityData {
    Observable<Map<String, ReferralWidgetResult>> getReferralWidgets();
}
