package id.dana.data.referralwidget.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.referralwidget.model.ReferralWidgetResult;
import id.dana.domain.referralwidget.model.ReferralWidget;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class ReferralWidgetMapper extends BaseMapper<Map<String, ReferralWidgetResult>, List<ReferralWidget>> {
    @Inject
    public ReferralWidgetMapper() {
    }

    private List<ReferralWidget> transform(Map<String, ReferralWidgetResult> map) {
        if (map != null) {
            ArrayList arrayList = new ArrayList(map.values());
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(transform((ReferralWidgetResult) it.next()));
            }
            return arrayList2;
        }
        return null;
    }

    private ReferralWidget transform(ReferralWidgetResult referralWidgetResult) {
        if (referralWidgetResult != null) {
            ReferralWidget referralWidget = new ReferralWidget();
            referralWidget.setTitle(referralWidgetResult.title);
            referralWidget.setRedirectUrl(referralWidgetResult.redirectUrl);
            referralWidget.setKey(referralWidgetResult.key);
            referralWidget.setEnable(referralWidgetResult.enable);
            return referralWidget;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public List<ReferralWidget> map(Map<String, ReferralWidgetResult> map) {
        return transform(map);
    }
}
