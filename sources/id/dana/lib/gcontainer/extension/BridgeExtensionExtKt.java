package id.dana.lib.gcontainer.extension;

import android.app.Activity;
import android.content.Context;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PageContext;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u00008G¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0017\u0010\t\u001a\u0004\u0018\u00010\u0006*\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0017\u0010\t\u001a\u0004\u0018\u00010\u0006*\u00020\u00008G¢\u0006\u0006\u001a\u0004\b\u0007\u0010\n"}, d2 = {"Lcom/alibaba/ariver/app/api/Page;", "Landroid/app/Activity;", "getActivity", "(Lcom/alibaba/ariver/app/api/Page;)Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "Lcom/alibaba/ariver/app/api/App;", "Landroid/content/Context;", "getContext", "(Lcom/alibaba/ariver/app/api/App;)Landroid/content/Context;", HummerConstants.CONTEXT, "(Lcom/alibaba/ariver/app/api/Page;)Landroid/content/Context;"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class BridgeExtensionExtKt {
    @JvmName(name = "getContext")
    public static final Context getContext(Page page) {
        Activity activity;
        Intrinsics.checkNotNullParameter(page, "");
        PageContext pageContext = page.getPageContext();
        if (pageContext == null || (activity = pageContext.getActivity()) == null) {
            return null;
        }
        return activity.getApplicationContext();
    }

    @JvmName(name = "getActivity")
    public static final Activity getActivity(Page page) {
        Intrinsics.checkNotNullParameter(page, "");
        PageContext pageContext = page.getPageContext();
        if (pageContext == null) {
            return null;
        }
        return pageContext.getActivity();
    }

    @JvmName(name = "getContext")
    public static final Context getContext(App app) {
        Context context;
        Intrinsics.checkNotNullParameter(app, "");
        AppContext appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            return null;
        }
        return context.getApplicationContext();
    }
}
