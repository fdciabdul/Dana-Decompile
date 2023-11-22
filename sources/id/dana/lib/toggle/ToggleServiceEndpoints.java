package id.dana.lib.toggle;

import io.split.android.client.ServiceEndpoints;

/* loaded from: classes5.dex */
public class ToggleServiceEndpoints {
    private static volatile ToggleServiceEndpoints PlaceComponentResult;
    public ServiceEndpoints MyBillsEntityDataFactory;

    /* loaded from: classes5.dex */
    public static final class Builder {
        String MyBillsEntityDataFactory = "https://sdk.split.io/api";
        String PlaceComponentResult = "https://events.split.io/api";
        String getAuthRequestContext = "https://auth.split.io/api/v2";
        String KClassImpl$Data$declaredNonStaticMembers$2 = "https://streaming.split.io/sse";
        String BuiltInFictitiousFunctionClassFactory = "https://telemetry.split.io/api/v1";
    }

    public static Builder getAuthRequestContext() {
        return new Builder();
    }

    public static ToggleServiceEndpoints KClassImpl$Data$declaredNonStaticMembers$2() {
        if (PlaceComponentResult == null) {
            synchronized (ToggleServiceEndpoints.class) {
                if (PlaceComponentResult == null) {
                    PlaceComponentResult = new ToggleServiceEndpoints();
                }
            }
        }
        return PlaceComponentResult;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ToggleServiceEndpoints getAuthRequestContext(ToggleServiceEndpoints toggleServiceEndpoints, ServiceEndpoints serviceEndpoints) {
        toggleServiceEndpoints.MyBillsEntityDataFactory = serviceEndpoints;
        return PlaceComponentResult;
    }
}
