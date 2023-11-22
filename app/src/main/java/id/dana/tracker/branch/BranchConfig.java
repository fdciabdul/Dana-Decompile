package id.dana.tracker.branch;

import android.text.TextUtils;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.tracker.EventConfig;
import id.dana.tracker.EventConfigProperty;
import io.branch.referral.Branch;

/* loaded from: classes2.dex */
public class BranchConfig implements EventConfig {
    private final EventConfigProperty getAuthRequestContext;

    @Override // id.dana.tracker.EventConfig
    public final void getAuthRequestContext() {
    }

    public BranchConfig(EventConfigProperty eventConfigProperty) {
        this.getAuthRequestContext = eventConfigProperty;
    }

    @Override // id.dana.tracker.EventConfig
    public final void MyBillsEntityDataFactory() {
        String str;
        String str2;
        String str3;
        EventConfigProperty eventConfigProperty = this.getAuthRequestContext;
        if (eventConfigProperty != null) {
            str = eventConfigProperty.PlaceComponentResult.getErrorConfigVersion;
            if (TextUtils.isEmpty(str)) {
                str3 = this.getAuthRequestContext.PlaceComponentResult.lookAheadTest;
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                Branch.BuiltInFictitiousFunctionClassFactory().NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory(TrackerKey.DefaultMixpanel.DISTINCT_ID, str3);
                return;
            }
            str2 = this.getAuthRequestContext.PlaceComponentResult.getErrorConfigVersion;
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            Branch.BuiltInFictitiousFunctionClassFactory().NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory(TrackerKey.DefaultMixpanel.DISTINCT_ID, str2);
        }
    }

    @Override // id.dana.tracker.EventConfig
    public final void PlaceComponentResult() {
        String str;
        str = this.getAuthRequestContext.PlaceComponentResult.getErrorConfigVersion;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Branch.BuiltInFictitiousFunctionClassFactory().NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory(TrackerKey.DefaultMixpanel.DISTINCT_ID, str);
    }

    @Override // id.dana.tracker.EventConfig
    public final void BuiltInFictitiousFunctionClassFactory() {
        String str;
        str = this.getAuthRequestContext.PlaceComponentResult.getErrorConfigVersion;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Branch.BuiltInFictitiousFunctionClassFactory().NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory(TrackerKey.DefaultMixpanel.DISTINCT_ID, str);
    }
}
