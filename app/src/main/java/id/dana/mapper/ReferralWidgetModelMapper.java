package id.dana.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.referralwidget.model.ReferralWidget;
import id.dana.model.ReferralWidgetModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class ReferralWidgetModelMapper extends BaseMapper<List<ReferralWidget>, List<ReferralWidgetModel>> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ List<ReferralWidgetModel> map(List<ReferralWidget> list) {
        ReferralWidgetModel referralWidgetModel;
        List<ReferralWidget> list2 = list;
        if (list2 != null) {
            ArrayList arrayList = new ArrayList();
            for (ReferralWidget referralWidget : list2) {
                if (referralWidget != null) {
                    referralWidgetModel = new ReferralWidgetModel();
                    referralWidgetModel.getAuthRequestContext = referralWidget.isEnable();
                    referralWidgetModel.KClassImpl$Data$declaredNonStaticMembers$2 = referralWidget.getTitle();
                    referralWidgetModel.BuiltInFictitiousFunctionClassFactory = referralWidget.getRedirectUrl();
                } else {
                    referralWidgetModel = null;
                }
                arrayList.add(referralWidgetModel);
            }
            return arrayList;
        }
        return null;
    }

    @Inject
    public ReferralWidgetModelMapper() {
    }
}
