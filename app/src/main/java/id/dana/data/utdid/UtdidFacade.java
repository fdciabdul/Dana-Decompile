package id.dana.data.utdid;

import android.content.Context;
import android.text.TextUtils;
import com.ut.device.UTDevice;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.utils.storage.AppInfo;
import id.dana.utils.storage.UTDidInfo;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

@Singleton
/* loaded from: classes2.dex */
public class UtdidFacade implements UTDidInfo {
    private final AppInfo appInfo;
    private final Context context;
    private String utdid;

    @Inject
    public UtdidFacade(Context context, AppInfo appInfo) {
        this.context = context;
        this.appInfo = appInfo;
    }

    @Override // id.dana.utils.storage.UTDidInfo
    public String getUtdid() {
        synchronized (this) {
            if (!TextUtils.isEmpty(this.utdid)) {
                return this.utdid;
            }
            String utdid = this.appInfo.getUtdid();
            if (TextUtils.isEmpty(utdid)) {
                String utdid2 = UTDevice.getUtdid(this.context);
                this.utdid = utdid2;
                if (TextUtils.isEmpty(utdid2)) {
                    Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
                    UtdIdEmpty utdIdEmpty = new UtdIdEmpty("Generate UTDID in UtdidFacade");
                    Intrinsics.checkNotNullParameter(utdIdEmpty, "");
                    BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.recordException(utdIdEmpty);
                }
                this.appInfo.saveUtdid(this.utdid);
            } else {
                this.utdid = utdid;
            }
            return this.utdid;
        }
    }

    @Override // id.dana.utils.storage.UTDidInfo
    public String getUtdIdPref() {
        String utdIdForMixpanel;
        synchronized (this) {
            utdIdForMixpanel = this.appInfo.getUtdIdForMixpanel();
        }
        return utdIdForMixpanel;
    }

    @Override // id.dana.utils.storage.UTDidInfo
    public void saveUtdIdForMixpanel(String str) {
        synchronized (this) {
            this.appInfo.saveUtdIdForMixpanel(str);
        }
    }
}
