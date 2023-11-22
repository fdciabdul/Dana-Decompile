package io.branch.referral.util;

import android.content.Context;
import io.branch.indexing.BranchUniversalObject;
import io.branch.referral.Branch;
import io.branch.referral.Defines;
import io.branch.referral.ServerRequest;
import io.branch.referral.ServerResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class BranchEvent {
    private final JSONObject BuiltInFictitiousFunctionClassFactory;
    private final String KClassImpl$Data$declaredNonStaticMembers$2;
    private final List<BranchUniversalObject> MyBillsEntityDataFactory;
    private final boolean PlaceComponentResult;
    private final JSONObject getAuthRequestContext;

    public BranchEvent(BRANCH_STANDARD_EVENT branch_standard_event) {
        this(branch_standard_event.getName());
    }

    public BranchEvent(String str) {
        this.BuiltInFictitiousFunctionClassFactory = new JSONObject();
        this.getAuthRequestContext = new JSONObject();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        BRANCH_STANDARD_EVENT[] values = BRANCH_STANDARD_EVENT.values();
        int length = values.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            } else if (str.equals(values[i].getName())) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        this.PlaceComponentResult = z;
        this.MyBillsEntityDataFactory = new ArrayList();
    }

    public final BranchEvent MyBillsEntityDataFactory(String str, String str2) {
        try {
            this.getAuthRequestContext.put(str, str2);
        } catch (JSONException unused) {
        }
        return this;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(Context context) {
        String path = (this.PlaceComponentResult ? Defines.RequestPath.TrackStandardEvent : Defines.RequestPath.TrackCustomEvent).getPath();
        if (Branch.BuiltInFictitiousFunctionClassFactory() != null) {
            Branch.BuiltInFictitiousFunctionClassFactory().getAuthRequestContext(new ServerRequestLogEvent(context, path));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ServerRequestLogEvent extends ServerRequest {
        @Override // io.branch.referral.ServerRequest
        public final boolean GetContactSyncConfig() {
            return true;
        }

        @Override // io.branch.referral.ServerRequest
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        }

        @Override // io.branch.referral.ServerRequest
        public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
            return false;
        }

        @Override // io.branch.referral.ServerRequest
        public final boolean NetworkUserEntityData$$ExternalSyntheticLambda1() {
            return true;
        }

        @Override // io.branch.referral.ServerRequest
        public final void PlaceComponentResult(int i, String str) {
        }

        @Override // io.branch.referral.ServerRequest
        public final void getAuthRequestContext(ServerResponse serverResponse, Branch branch) {
        }

        @Override // io.branch.referral.ServerRequest
        public final boolean getAuthRequestContext(Context context) {
            return false;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        ServerRequestLogEvent(Context context, String str) {
            super(context, str);
            BranchEvent.this = r2;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Defines.Jsonkey.Name.getKey(), r2.KClassImpl$Data$declaredNonStaticMembers$2);
                if (r2.getAuthRequestContext.length() > 0) {
                    jSONObject.put(Defines.Jsonkey.CustomData.getKey(), r2.getAuthRequestContext);
                }
                if (r2.BuiltInFictitiousFunctionClassFactory.length() > 0) {
                    jSONObject.put(Defines.Jsonkey.EventData.getKey(), r2.BuiltInFictitiousFunctionClassFactory);
                }
                if (r2.MyBillsEntityDataFactory.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    jSONObject.put(Defines.Jsonkey.ContentItems.getKey(), jSONArray);
                    Iterator it = r2.MyBillsEntityDataFactory.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(((BranchUniversalObject) it.next()).getAuthRequestContext());
                    }
                }
                MyBillsEntityDataFactory(jSONObject);
            } catch (JSONException unused) {
            }
            getAuthRequestContext(jSONObject);
        }

        @Override // io.branch.referral.ServerRequest
        public final ServerRequest.BRANCH_API_VERSION PlaceComponentResult() {
            return ServerRequest.BRANCH_API_VERSION.V2;
        }
    }
}
