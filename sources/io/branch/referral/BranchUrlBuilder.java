package io.branch.referral;

import android.content.Context;
import com.alipay.plus.security.lite.SecLiteException;
import io.branch.referral.Branch;
import io.branch.referral.BranchUrlBuilder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class BranchUrlBuilder<T extends BranchUrlBuilder> {
    protected String BuiltInFictitiousFunctionClassFactory;
    private final Context GetContactSyncConfig;
    protected String MyBillsEntityDataFactory;
    protected JSONObject NetworkUserEntityData$$ExternalSyntheticLambda0;
    protected String PlaceComponentResult;
    protected String getErrorConfigVersion;
    protected String lookAheadTest;
    protected ArrayList<String> scheduleImpl;
    protected int moveToNextValue = 0;
    protected int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    protected Branch getAuthRequestContext = Branch.BuiltInFictitiousFunctionClassFactory();
    private boolean DatabaseTableConfigUtil = true;

    /* JADX INFO: Access modifiers changed from: protected */
    public BranchUrlBuilder(Context context) {
        this.GetContactSyncConfig = context.getApplicationContext();
    }

    public final T getAuthRequestContext(List<String> list) {
        if (this.scheduleImpl == null) {
            this.scheduleImpl = new ArrayList<>();
        }
        this.scheduleImpl.addAll(list);
        return this;
    }

    public final T KClassImpl$Data$declaredNonStaticMembers$2(String str, Object obj) {
        try {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new JSONObject();
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.put(str, obj);
        } catch (JSONException unused) {
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String MyBillsEntityDataFactory() {
        if (this.getAuthRequestContext != null) {
            return this.getAuthRequestContext.getAuthRequestContext(new ServerRequestCreateUrl(this.GetContactSyncConfig, this.PlaceComponentResult, this.moveToNextValue, this.KClassImpl$Data$declaredNonStaticMembers$2, this.scheduleImpl, this.BuiltInFictitiousFunctionClassFactory, this.lookAheadTest, this.getErrorConfigVersion, this.MyBillsEntityDataFactory, BranchUtil.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), null, false, this.DatabaseTableConfigUtil));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Branch.BranchLinkCreateListener branchLinkCreateListener) {
        KClassImpl$Data$declaredNonStaticMembers$2(branchLinkCreateListener, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Branch.BranchLinkCreateListener branchLinkCreateListener, boolean z) {
        if (this.getAuthRequestContext != null) {
            ServerRequestCreateUrl serverRequestCreateUrl = new ServerRequestCreateUrl(this.GetContactSyncConfig, this.PlaceComponentResult, this.moveToNextValue, this.KClassImpl$Data$declaredNonStaticMembers$2, this.scheduleImpl, this.BuiltInFictitiousFunctionClassFactory, this.lookAheadTest, this.getErrorConfigVersion, this.MyBillsEntityDataFactory, BranchUtil.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), branchLinkCreateListener, true, this.DatabaseTableConfigUtil);
            serverRequestCreateUrl.getErrorConfigVersion = z;
            this.getAuthRequestContext.getAuthRequestContext(serverRequestCreateUrl);
            return;
        }
        if (branchLinkCreateListener != null) {
            branchLinkCreateListener.onLinkCreate(null, new BranchError("session has not been initialized", SecLiteException.ERROR_API_KEY_OR_SIGN));
        }
        PrefHelper.MyBillsEntityDataFactory("Warning: User session has not been initialized");
    }
}
