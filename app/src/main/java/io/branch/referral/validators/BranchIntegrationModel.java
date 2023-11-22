package io.branch.referral.validators;

import android.content.Context;
import io.branch.referral.BranchAsyncTask;
import io.branch.referral.BranchUtil;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes9.dex */
class BranchIntegrationModel {
    final String BuiltInFictitiousFunctionClassFactory;
    final List<String> KClassImpl$Data$declaredNonStaticMembers$2;
    JSONObject MyBillsEntityDataFactory;
    boolean getAuthRequestContext;

    /* loaded from: classes9.dex */
    class getDeepLinkSchemeTasks extends BranchAsyncTask<Context, Void, JSONObject> {
        @Override // android.os.AsyncTask
        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return BranchUtil.BuiltInFictitiousFunctionClassFactory(((Context[]) objArr)[0]);
        }
    }
}
