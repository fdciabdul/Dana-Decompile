package id.dana.data.toggle.traffictype.user;

import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.lib.toggle.ToggleManager;
import id.dana.utils.foundation.logger.log.DanaLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\b"}, d2 = {"Lid/dana/data/toggle/traffictype/user/TrafficTypeUser;", "Lid/dana/data/toggle/traffictype/BaseTrafficType;", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V", "MyBillsEntityDataFactory", "()Ljava/lang/String;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class TrafficTypeUser extends BaseTrafficType {
    @Override // id.dana.data.toggle.traffictype.BaseTrafficType
    public final String BuiltInFictitiousFunctionClassFactory() {
        return "User";
    }

    @Override // id.dana.data.toggle.traffictype.ITrafficTypeFactory
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.data.toggle.traffictype.ITrafficTypeFactory
    public final void MyBillsEntityDataFactory(String p0) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(p0, "");
            if (!MyBillsEntityDataFactory()) {
                DanaLog.getAuthRequestContext("Split", "Creating Traffic Type User");
                getErrorConfigVersion(p0);
                ToggleManager.MyBillsEntityDataFactory().MyBillsEntityDataFactory("User", this);
                StringBuilder sb = new StringBuilder();
                sb.append("Traffic Type User created with matching key ");
                sb.append(p0);
                DanaLog.getAuthRequestContext("Split", sb.toString());
            }
        }
    }
}
