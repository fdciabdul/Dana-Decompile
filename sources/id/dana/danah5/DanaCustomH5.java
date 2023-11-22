package id.dana.danah5;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsService;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.app.BundleCompat;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.R;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.chrome.CustomTabEngine;
import id.dana.di.PerActivity;
import id.dana.lib.gcontainer.GContainer;
import id.dana.lib.gcontainer.extension.ContentExtKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u0011\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b#\u0010$J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\u0007J\u0019\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001d\u001a\u00020\u001c8G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b!\u0010\""}, d2 = {"Lid/dana/danah5/DanaCustomH5;", "", "Landroid/net/Uri;", "url", "", "Lid/dana/danah5/chrome/CustomTabEngine;", "applyCustomTabEnginePriority", "(Landroid/net/Uri;)Ljava/util/List;", "", "findPreferredCustomTabsPackage", "()Ljava/lang/String;", "getCustomTabsPackages", "getPreferredCustomTabsPackage", "(Landroid/net/Uri;)Ljava/lang/String;", "", "initialize", "()V", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, LogConstants.Mpm.EndNodeType.OPEN_URL, "(Landroid/app/Activity;Ljava/lang/String;)V", "warmUp", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "Landroidx/browser/customtabs/CustomTabsClient;", "customTabsClient", "Landroidx/browser/customtabs/CustomTabsClient;", "", "isInitialized", "()Z", "isInitializing", "Z", "preferredPackageName", "Ljava/lang/String;", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes2.dex */
public final class DanaCustomH5 {
    private static final String TAG = "DanaCustomH5";
    private final Context context;
    private CustomTabsClient customTabsClient;
    private boolean isInitializing;
    private String preferredPackageName;

    @Inject
    public DanaCustomH5(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.context = context;
        this.preferredPackageName = findPreferredCustomTabsPackage();
        initialize();
    }

    public final void initialize() {
        String findPreferredCustomTabsPackage;
        if (isInitialized() || this.isInitializing || (findPreferredCustomTabsPackage = findPreferredCustomTabsPackage()) == null) {
            return;
        }
        this.preferredPackageName = findPreferredCustomTabsPackage;
        this.isInitializing = true;
        if (CustomTabsClient.KClassImpl$Data$declaredNonStaticMembers$2(this.context, this.preferredPackageName, new CustomTabsServiceConnection() { // from class: id.dana.danah5.DanaCustomH5$initialize$connection$1
            @Override // androidx.browser.customtabs.CustomTabsServiceConnection
            public final void onCustomTabsServiceConnected(ComponentName name, CustomTabsClient client) {
                Intrinsics.checkNotNullParameter(name, "");
                Intrinsics.checkNotNullParameter(client, "");
                client.BuiltInFictitiousFunctionClassFactory();
                DanaCustomH5.this.customTabsClient = client;
                DanaCustomH5.this.isInitializing = false;
            }

            @Override // android.content.ServiceConnection
            public final void onServiceDisconnected(ComponentName name) {
                Intrinsics.checkNotNullParameter(name, "");
                DanaCustomH5.this.customTabsClient = null;
                DanaCustomH5.this.isInitializing = false;
            }
        })) {
            return;
        }
        this.customTabsClient = null;
    }

    @JvmName(name = "isInitialized")
    public final boolean isInitialized() {
        return this.customTabsClient != null;
    }

    public final void warmUp() {
        CustomTabsClient customTabsClient = this.customTabsClient;
        if (customTabsClient != null) {
            customTabsClient.BuiltInFictitiousFunctionClassFactory();
        } else if (this.isInitializing) {
        } else {
            initialize();
        }
    }

    public final void openUrl(Activity activity, String url) {
        Intrinsics.checkNotNullParameter(url, "");
        if (isInitialized()) {
            warmUp();
        } else {
            DanaLog.scheduleImpl(TAG, "ChromeCustomTabs has not been initialized yet. It will open any installed browser.");
        }
        CustomTabColorSchemeParams.Builder builder = new CustomTabColorSchemeParams.Builder();
        builder.PlaceComponentResult = Integer.valueOf(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.context, GContainer.getToolbarStyle().getToolbarBackgroundColor()) | (-16777216));
        CustomTabColorSchemeParams customTabColorSchemeParams = new CustomTabColorSchemeParams(builder.PlaceComponentResult, builder.MyBillsEntityDataFactory, builder.KClassImpl$Data$declaredNonStaticMembers$2, builder.getAuthRequestContext);
        Intrinsics.checkNotNullExpressionValue(customTabColorSchemeParams, "");
        CustomTabsIntent.Builder builder2 = new CustomTabsIntent.Builder();
        builder2.PlaceComponentResult = customTabColorSchemeParams.PlaceComponentResult();
        builder2.scheduleImpl = ActivityOptionsCompat.PlaceComponentResult(this.context, R.anim.MyBillsEntityDataFactory_res_0x7f010057, R.anim.PlaceComponentResult_res_0x7f01005d).MyBillsEntityDataFactory();
        builder2.lookAheadTest.putExtra("android.support.customtabs.extra.EXIT_ANIMATION_BUNDLE", ActivityOptionsCompat.PlaceComponentResult(this.context, R.anim.getAuthRequestContext_res_0x7f010056, R.anim.lookAheadTest).MyBillsEntityDataFactory());
        if (!builder2.lookAheadTest.hasExtra("android.support.customtabs.extra.SESSION")) {
            Bundle bundle = new Bundle();
            BundleCompat.KClassImpl$Data$declaredNonStaticMembers$2(bundle, "android.support.customtabs.extra.SESSION", null);
            builder2.lookAheadTest.putExtras(bundle);
        }
        ArrayList<Bundle> arrayList = builder2.moveToNextValue;
        if (arrayList != null) {
            builder2.lookAheadTest.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
        }
        ArrayList<Bundle> arrayList2 = builder2.BuiltInFictitiousFunctionClassFactory;
        if (arrayList2 != null) {
            builder2.lookAheadTest.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
        }
        builder2.lookAheadTest.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", builder2.KClassImpl$Data$declaredNonStaticMembers$2);
        Intent intent = builder2.lookAheadTest;
        CustomTabColorSchemeParams.Builder builder3 = builder2.getAuthRequestContext;
        intent.putExtras(new CustomTabColorSchemeParams(builder3.PlaceComponentResult, builder3.MyBillsEntityDataFactory, builder3.KClassImpl$Data$declaredNonStaticMembers$2, builder3.getAuthRequestContext).PlaceComponentResult());
        Bundle bundle2 = builder2.PlaceComponentResult;
        if (bundle2 != null) {
            builder2.lookAheadTest.putExtras(bundle2);
        }
        if (builder2.MyBillsEntityDataFactory != null) {
            Bundle bundle3 = new Bundle();
            bundle3.putSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS", builder2.MyBillsEntityDataFactory);
            builder2.lookAheadTest.putExtras(bundle3);
        }
        builder2.lookAheadTest.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", builder2.getErrorConfigVersion);
        CustomTabsIntent customTabsIntent = new CustomTabsIntent(builder2.lookAheadTest, builder2.scheduleImpl);
        if (activity == null) {
            customTabsIntent.BuiltInFictitiousFunctionClassFactory.setFlags(268468224);
        }
        if (this.preferredPackageName != null) {
            customTabsIntent.BuiltInFictitiousFunctionClassFactory.setPackage(this.preferredPackageName);
            Activity activity2 = activity != null ? activity : this.context;
            customTabsIntent.BuiltInFictitiousFunctionClassFactory.setData(Uri.parse(url));
            ContextCompat.MyBillsEntityDataFactory(activity2, customTabsIntent.BuiltInFictitiousFunctionClassFactory, customTabsIntent.MyBillsEntityDataFactory);
            return;
        }
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse(url));
        if (activity != null) {
            ContentExtKt.startActivitySafely(activity, intent2);
        } else {
            ContentExtKt.startActivitySafely(this.context, intent2);
        }
    }

    private final List<String> getCustomTabsPackages(Uri url) {
        PackageManager packageManager = this.context.getPackageManager();
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(new Intent("android.intent.action.VIEW", url), 0);
        Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "");
        ArrayList arrayList = new ArrayList();
        for (Object obj : queryIntentActivities) {
            Intent intent = new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION).setPackage(((ResolveInfo) obj).activityInfo.packageName);
            Intrinsics.checkNotNullExpressionValue(intent, "");
            if (packageManager.resolveService(intent, 0) != null) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((ResolveInfo) it.next()).activityInfo.packageName);
        }
        return arrayList3;
    }

    private final List<CustomTabEngine> applyCustomTabEnginePriority(Uri url) {
        CustomTabEngine customTabEngine;
        List<String> customTabsPackages = getCustomTabsPackages(url);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(customTabsPackages, 10));
        Iterator<T> it = customTabsPackages.iterator();
        while (true) {
            DefaultConstructorMarker defaultConstructorMarker = null;
            int i = 0;
            if (!it.hasNext()) {
                break;
            }
            arrayList.add(new CustomTabEngine((String) it.next(), i, 2, defaultConstructorMarker));
        }
        CustomTabEngine[] chromeApps = CustomTabEngine.INSTANCE.getChromeApps();
        ArrayList<CustomTabEngine> arrayList2 = arrayList;
        for (CustomTabEngine customTabEngine2 : arrayList2) {
            int length = chromeApps.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    customTabEngine = null;
                    break;
                }
                customTabEngine = chromeApps[i2];
                if (Intrinsics.areEqual(customTabEngine, customTabEngine2)) {
                    break;
                }
                i2++;
            }
            customTabEngine2.setPriority(customTabEngine != null ? customTabEngine.getPriority() : 10);
        }
        return CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: id.dana.danah5.DanaCustomH5$applyCustomTabEnginePriority$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((CustomTabEngine) t).getPriority()), Integer.valueOf(((CustomTabEngine) t2).getPriority()));
            }
        });
    }

    private final String getPreferredCustomTabsPackage(Uri url) {
        CustomTabEngine customTabEngine = (CustomTabEngine) CollectionsKt.firstOrNull((List) applyCustomTabEnginePriority(url));
        if (customTabEngine != null) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Found preferred CustomTabs package: ");
            sb.append(customTabEngine);
            DanaLog.MyBillsEntityDataFactory(str, sb.toString());
            return customTabEngine.getPackageName();
        }
        return null;
    }

    private final String findPreferredCustomTabsPackage() {
        Uri parse = Uri.parse("http://www.example.com/");
        Intrinsics.checkNotNullExpressionValue(parse, "");
        return getPreferredCustomTabsPackage(parse);
    }
}
