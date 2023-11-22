package id.dana.data.miniprogram.source.local;

import android.content.Context;
import id.dana.data.account.repository.source.SecuredAccountPreferences;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.foundation.utils.CommonUtil;
import id.dana.data.globalnetwork.model.GnAuthResult;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u0006\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/data/miniprogram/source/local/MiniProgramPreference;", "", "Ljava/util/HashMap;", "", "Lid/dana/data/globalnetwork/model/GnAuthResult;", "Lkotlin/collections/HashMap;", "getAuthRequestContext", "()Ljava/util/HashMap;", "p0", "p1", "", "(Ljava/lang/String;Lid/dana/data/globalnetwork/model/GnAuthResult;)V", "Lid/dana/data/storage/PreferenceFacade;", "Lid/dana/data/storage/PreferenceFacade;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/account/repository/source/SecuredAccountPreferences;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/account/repository/source/SecuredAccountPreferences;", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MiniProgramPreference {
    private static final String KClassImpl$Data$declaredNonStaticMembers$2;
    public final SecuredAccountPreferences BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final PreferenceFacade KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public MiniProgramPreference(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        PreferenceFacade createData2 = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(KClassImpl$Data$declaredNonStaticMembers$2).setUseDrutherPreference(true).setSerializerFacade(null)).createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = createData2;
        SecuredAccountPreferences securedAccountPreferences = new SecuredAccountPreferences(context, null);
        this.BuiltInFictitiousFunctionClassFactory = securedAccountPreferences;
        securedAccountPreferences.init(CommonUtil.MyBillsEntityDataFactory(new SecurityGuardFacade(context), ""));
    }

    public final void getAuthRequestContext(String p0, GnAuthResult p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        p1.setCallback(null);
        HashMap<String, GnAuthResult> authRequestContext = getAuthRequestContext();
        authRequestContext.put(p0, p1);
        this.KClassImpl$Data$declaredNonStaticMembers$2.saveData("CACHE_AUTH_RESULT", (String) authRequestContext);
    }

    public final HashMap<String, GnAuthResult> getAuthRequestContext() {
        HashMap<String, GnAuthResult> hashMap = (HashMap) this.KClassImpl$Data$declaredNonStaticMembers$2.getObject("CACHE_AUTH_RESULT", new HashMap().getClass());
        return hashMap == null ? new HashMap<>() : hashMap;
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        StringBuilder sb = new StringBuilder();
        sb.append(Reflection.getOrCreateKotlinClass(companion.getClass()).getSimpleName());
        sb.append("production");
        KClassImpl$Data$declaredNonStaticMembers$2 = sb.toString();
    }
}
