package id.dana.lib.toggle.factory;

import android.content.Context;
import android.text.TextUtils;
import id.dana.lib.toggle.ToggleClientConfig;
import io.split.android.client.SplitClient;
import io.split.android.client.SplitClientConfig;
import io.split.android.client.SplitFactory;
import io.split.android.client.SplitFactoryBuilder;
import io.split.android.client.api.Key;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class AbstractToggleFactory {
    private final String BuiltInFictitiousFunctionClassFactory;
    private final SplitClientConfig KClassImpl$Data$declaredNonStaticMembers$2;
    public boolean MyBillsEntityDataFactory;
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private SplitFactory PlaceComponentResult;
    private final Context getAuthRequestContext;
    public HashMap<String, SplitClient> lookAheadTest = new HashMap<>();

    public AbstractToggleFactory(Context context, ToggleClientConfig toggleClientConfig, String str) {
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.getAuthRequestContext = context.getApplicationContext();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = toggleClientConfig.BuiltInFictitiousFunctionClassFactory;
    }

    public final void getErrorConfigVersion(String str) {
        try {
            SplitFactory build = SplitFactoryBuilder.build(this.BuiltInFictitiousFunctionClassFactory, new Key(str, null), this.KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext);
            this.PlaceComponentResult = build;
            this.lookAheadTest.put(str, build.client());
        } catch (Exception unused) {
        }
    }

    public final void PlaceComponentResult(String str) {
        SplitFactory splitFactory = this.PlaceComponentResult;
        if (splitFactory != null) {
            this.lookAheadTest.put(str, splitFactory.client(str));
        }
    }

    public final SplitClient moveToNextValue(String str) {
        return TextUtils.isEmpty(str) ? this.lookAheadTest.get(0) : this.lookAheadTest.get(str);
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public final boolean PlaceComponentResult() {
        return this.MyBillsEntityDataFactory;
    }
}
