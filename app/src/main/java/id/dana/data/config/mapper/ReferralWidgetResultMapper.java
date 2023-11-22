package id.dana.data.config.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.config.source.amcs.result.ReferralWidgetButtonResult;
import id.dana.domain.featureconfig.model.ReferralWidgetButton;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes8.dex */
public class ReferralWidgetResultMapper extends BaseMapper<List<ReferralWidgetButtonResult>, List<ReferralWidgetButton>> {
    @Inject
    public ReferralWidgetResultMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public List<ReferralWidgetButton> map(List<ReferralWidgetButtonResult> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ReferralWidgetButtonResult referralWidgetButtonResult : list) {
            ReferralWidgetButton referralWidgetButton = new ReferralWidgetButton();
            referralWidgetButton.setName(referralWidgetButtonResult.getName());
            referralWidgetButton.setLink(referralWidgetButtonResult.getLink());
            referralWidgetButton.setEnable(referralWidgetButtonResult.isEnable());
            referralWidgetButton.setAction(referralWidgetButtonResult.getAction());
            referralWidgetButton.setWidgetId(referralWidgetButtonResult.getWidgetId());
            referralWidgetButton.setWidgetType(referralWidgetButtonResult.getWidgetType());
            arrayList.add(referralWidgetButton);
        }
        return arrayList;
    }
}
