package id.dana.lib.toggle;

import id.dana.lib.toggle.ToggleServiceEndpoints;
import id.dana.lib.toggle.ToggleSyncConfig;
import io.split.android.client.ServiceEndpoints;
import io.split.android.client.SplitClientConfig;
import io.split.android.client.SplitFilter;
import io.split.android.client.SyncConfig;
import java.util.Iterator;

/* loaded from: classes5.dex */
public class ToggleClientConfig {
    private static volatile ToggleClientConfig getAuthRequestContext;
    public SplitClientConfig BuiltInFictitiousFunctionClassFactory;

    public static ToggleClientConfig MyBillsEntityDataFactory() {
        if (getAuthRequestContext == null) {
            synchronized (ToggleClientConfig.class) {
                if (getAuthRequestContext == null) {
                    getAuthRequestContext = new ToggleClientConfig();
                }
            }
        }
        return getAuthRequestContext;
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        public ToggleServiceEndpoints NetworkUserEntityData$$ExternalSyntheticLambda3;
        public ToggleSyncConfig newProxyInstance;
        public int scheduleImpl = 60;
        public int PrepareContext = 60;
        public int NetworkUserEntityData$$ExternalSyntheticLambda2 = 60;
        public int initRecordTimeStamp = 30000;
        private int NetworkUserEntityData$$ExternalSyntheticLambda6 = 2000;
        public int getAuthRequestContext = 15000;
        public int NetworkUserEntityData$$ExternalSyntheticLambda7 = 15000;
        public int NetworkUserEntityData$$ExternalSyntheticLambda8 = -1;
        private int FragmentBottomSheetPaymentSettingBinding = 1800;
        private int getSupportButtonTintMode = 5000;
        public long DatabaseTableConfigUtil = 2048;
        public int moveToNextValue = 10000;
        public long getErrorConfigVersion = 1800;
        public int NetworkUserEntityData$$ExternalSyntheticLambda0 = 2000;
        public String NetworkUserEntityData$$ExternalSyntheticLambda5 = null;
        public String lookAheadTest = "unknown";
        public String GetContactSyncConfig = "unknown";
        public String NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
        public boolean NetworkUserEntityData$$ExternalSyntheticLambda4 = false;
        public int KClassImpl$Data$declaredNonStaticMembers$2 = 15;
        public boolean PlaceComponentResult = true;
        public boolean MyBillsEntityDataFactory = false;
        public boolean isLayoutRequested = true;
        public boolean BuiltInFictitiousFunctionClassFactory = false;

        public Builder() {
            byte b = 0;
            ToggleServiceEndpoints.Builder authRequestContext = ToggleServiceEndpoints.getAuthRequestContext();
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = ToggleServiceEndpoints.getAuthRequestContext(ToggleServiceEndpoints.KClassImpl$Data$declaredNonStaticMembers$2(), ServiceEndpoints.builder().apiEndpoint(authRequestContext.MyBillsEntityDataFactory).eventsEndpoint(authRequestContext.PlaceComponentResult).sseAuthServiceEndpoint(authRequestContext.getAuthRequestContext).streamingServiceEndpoint(authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2).telemetryServiceEndpoint(authRequestContext.BuiltInFictitiousFunctionClassFactory).build());
            ToggleSyncConfig.Builder PlaceComponentResult = ToggleSyncConfig.PlaceComponentResult();
            SyncConfig.Builder builder = SyncConfig.builder();
            Iterator<SplitFilter> it = PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.iterator();
            while (it.hasNext()) {
                builder.addSplitFilter(it.next());
            }
            this.newProxyInstance = new ToggleSyncConfig(builder.build(), b);
        }
    }

    public static /* synthetic */ ToggleClientConfig PlaceComponentResult(ToggleClientConfig toggleClientConfig, SplitClientConfig splitClientConfig) {
        toggleClientConfig.BuiltInFictitiousFunctionClassFactory = splitClientConfig;
        return getAuthRequestContext;
    }
}
