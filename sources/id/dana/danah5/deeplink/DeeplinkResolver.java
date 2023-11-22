package id.dana.danah5.deeplink;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alibaba.ariver.app.api.Page;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.lib.gcontainer.GContainer;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.lib.gcontainer.extension.ContentExtKt;
import id.dana.scanner.ScannerActivity;
import id.dana.utils.OSUtil;
import id.dana.utils.android.AppUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010 \n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b7\u00108J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001f\u001a\u00020\u00152\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b!\u0010\u001cJ\u0019\u0010\"\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\"\u0010#J\u0019\u0010$\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b$\u0010%J!\u0010&\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b&\u0010\u0019J\u001f\u0010'\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b'\u0010\u0017J'\u0010'\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b)\u0010\u001cR\u0014\u0010*\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010+R\u0014\u0010-\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010+R\u0014\u0010.\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010+R\u0014\u0010/\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u0010+R\u0014\u00100\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u0010+R\u0014\u00101\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u0010+R\u0014\u00102\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010+R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00105"}, d2 = {"Lid/dana/danah5/deeplink/DeeplinkResolver;", "", "", "url", "", "closeAllGContainer", "(Ljava/lang/String;)V", "Lcom/alibaba/ariver/app/api/Page;", "page", "closePushWindow", "(Lcom/alibaba/ariver/app/api/Page;Ljava/lang/String;)V", "Landroid/content/Intent;", "uriSchemeIntent", "getFallbackUrl", "(Landroid/content/Intent;)Ljava/lang/String;", "getMarketIntentWithPackage", "(Landroid/content/Intent;)Landroid/content/Intent;", "handleToOpenScanner", "(Lcom/alibaba/ariver/app/api/Page;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "", "hasActivityToOpen", "(Landroid/content/Context;Ljava/lang/String;)Z", "hasAppToOpenWithIntentScheme", "(Landroid/content/Context;Landroid/content/Intent;)Z", "fallbackUrl", "isMarketProtocol", "(Ljava/lang/String;)Z", "Landroid/content/pm/PackageManager;", "packageManager", "isParkeeNotInstalled", "(Ljava/lang/String;Landroid/content/pm/PackageManager;)Z", "isUrlWhitelisted", "openFallbackUrlFromIntent", "(Landroid/content/Intent;)Z", "parseIntentScheme", "(Ljava/lang/String;)Landroid/content/Intent;", "playstoreCanOpen", "resolveUrl", "(Landroid/content/Context;Ljava/lang/String;Lcom/alibaba/ariver/app/api/Page;)Z", "skipThirdPartyAppDeepLinkIfNotInstalled", "DEEPLINK_BASE_PARKEE", "Ljava/lang/String;", "DEEPLINK_PARKEE_BRANCH_REFERRER", "DEEPLINK_PARKEE_CLICK_ID", "FALLBACK_URL_EXTRA_KEY", "LANDINGPAGE_OPEN_PARKEE_APP", "MARKET_DETAILS_URL_SCHEME", "PACKAGE_PARKEE_APP", "TAG", "", "whitelistedThirdPartyDeepLinks", "Ljava/util/List;", "whitelistedUrls", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DeeplinkResolver {
    private static final String DEEPLINK_BASE_PARKEE = "parkee://open";
    private static final String DEEPLINK_PARKEE_BRANCH_REFERRER = "parkee://open?_branch_referrer";
    private static final String DEEPLINK_PARKEE_CLICK_ID = "parkee://open?link_click_id";
    private static final String FALLBACK_URL_EXTRA_KEY = "browser_fallback_url";
    private static final String LANDINGPAGE_OPEN_PARKEE_APP = "https://parkee.app.link/selectedWalletConfiguration?wallet=dana";
    private static final String MARKET_DETAILS_URL_SCHEME = "market://details";
    private static final String PACKAGE_PARKEE_APP = "com.parkee";
    private static final String TAG;
    private static final List<String> whitelistedUrls;
    public static final DeeplinkResolver INSTANCE = new DeeplinkResolver();
    private static final List<String> whitelistedThirdPartyDeepLinks = CollectionsKt.listOf((Object[]) new String[]{"bukalapak://", "lazada://"});

    private DeeplinkResolver() {
    }

    static {
        Intrinsics.checkNotNullExpressionValue("DeeplinkResolver", "");
        TAG = "DeeplinkResolver";
        whitelistedUrls = CollectionsKt.listOf((Object[]) new String[]{DanaUrl.TIX_ID, DanaUrl.BLIBLI, DanaUrl.PLAY_STORE, DanaUrl.LAZADA_C});
    }

    @JvmStatic
    public static final boolean resolveUrl(Context context, String url) {
        DeeplinkResolver deeplinkResolver;
        Intent parseIntentScheme;
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(url, "");
        if ((!URLUtil.isNetworkUrl(url) || INSTANCE.isUrlWhitelisted(url)) && (parseIntentScheme = (deeplinkResolver = INSTANCE).parseIntentScheme(url)) != null) {
            return deeplinkResolver.hasActivityToOpen(context, url) || deeplinkResolver.hasAppToOpenWithIntentScheme(context, parseIntentScheme) || deeplinkResolver.playstoreCanOpen(context, parseIntentScheme) || deeplinkResolver.openFallbackUrlFromIntent(parseIntentScheme) || deeplinkResolver.skipThirdPartyAppDeepLinkIfNotInstalled(url);
        }
        return false;
    }

    private final boolean isUrlWhitelisted(String url) {
        List<String> list = whitelistedUrls;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (StringsKt.contains$default((CharSequence) url, (CharSequence) ((String) it.next()), false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final boolean resolveUrl(Context context, String url, Page page) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(url, "");
        Intrinsics.checkNotNullParameter(page, "");
        DeeplinkResolver deeplinkResolver = INSTANCE;
        PackageManager packageManager = context.getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "");
        if (deeplinkResolver.isParkeeNotInstalled(url, packageManager)) {
            DanaLog.MyBillsEntityDataFactory(TAG, "Treatment parkee app when not installed");
            handleToOpenScanner(page);
            closePushWindow(page, url);
            return false;
        }
        return resolveUrl(context, url);
    }

    @JvmStatic
    public static final void handleToOpenScanner(Page page) {
        Activity activity;
        Intent intent = new Intent(page != null ? BridgeExtensionExtKt.getActivity(page) : null, ScannerActivity.class);
        if (page == null || (activity = BridgeExtensionExtKt.getActivity(page)) == null) {
            return;
        }
        activity.startActivity(intent);
    }

    @JvmStatic
    public static final void closePushWindow(Page page, String url) {
        if (StringsKt.contains$default((CharSequence) String.valueOf(url), (CharSequence) DEEPLINK_PARKEE_BRANCH_REFERRER, false, 2, (Object) null) || StringsKt.contains$default((CharSequence) String.valueOf(url), (CharSequence) DEEPLINK_PARKEE_CLICK_ID, false, 2, (Object) null)) {
            if (page != null) {
                page.exit(false);
            }
            DanaLog.MyBillsEntityDataFactory(TAG, "Close new tab push window griver");
        }
    }

    private final Intent parseIntentScheme(String url) {
        try {
            Intent parseUri = Intent.parseUri(url, 1);
            parseUri.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            return parseUri;
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory("DeeplinkResolver", "Error parsing Uri", e);
            return null;
        }
    }

    private final boolean hasActivityToOpen(Context context, String url) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
        if (ContentExtKt.hasActivityHandler(intent, context)) {
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            context.startActivity(intent);
            closeAllGContainer(url);
            return true;
        } else if (OSUtil.BuiltInFictitiousFunctionClassFactory()) {
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setFlags(268436480);
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                String str = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("Activity not found, ");
                sb.append(url);
                sb.append(", ");
                String message = e.getMessage();
                if (message == null) {
                    message = "";
                }
                sb.append(message);
                sb.append(InputCardNumberView.DIVIDER);
                DanaLog.MyBillsEntityDataFactory(str, sb.toString());
            }
            closeAllGContainer(url);
            return true;
        } else {
            return false;
        }
    }

    private final void closeAllGContainer(String url) {
        if (StringsKt.contains$default((CharSequence) url, (CharSequence) DanaUrl.TIX_ID, false, 2, (Object) null)) {
            GContainer.closeAllContainers();
        }
    }

    private final boolean hasAppToOpenWithIntentScheme(Context context, Intent uriSchemeIntent) {
        if (ContentExtKt.hasActivityHandler(uriSchemeIntent, context)) {
            context.startActivity(uriSchemeIntent);
            return true;
        }
        return false;
    }

    private final boolean playstoreCanOpen(Context context, Intent uriSchemeIntent) {
        if (isMarketProtocol(getFallbackUrl(uriSchemeIntent))) {
            Intent marketIntentWithPackage = getMarketIntentWithPackage(uriSchemeIntent);
            if (ContentExtKt.hasActivityHandler(marketIntentWithPackage, context)) {
                marketIntentWithPackage.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                context.startActivity(marketIntentWithPackage);
                return true;
            }
            return false;
        }
        return false;
    }

    private final boolean openFallbackUrlFromIntent(Intent uriSchemeIntent) {
        String fallbackUrl = getFallbackUrl(uriSchemeIntent);
        if (TextUtils.isEmpty(fallbackUrl)) {
            return false;
        }
        DanaH5.startContainerFullUrl(fallbackUrl);
        return false;
    }

    private final boolean isMarketProtocol(String fallbackUrl) {
        return StringsKt.isBlank(fallbackUrl) && StringsKt.startsWith$default(fallbackUrl, MARKET_DETAILS_URL_SCHEME, false, 2, (Object) null);
    }

    private final String getFallbackUrl(Intent uriSchemeIntent) {
        String stringExtra = uriSchemeIntent != null ? uriSchemeIntent.getStringExtra(FALLBACK_URL_EXTRA_KEY) : null;
        return stringExtra == null ? "" : stringExtra;
    }

    private final Intent getMarketIntentWithPackage(Intent uriSchemeIntent) {
        StringBuilder sb = new StringBuilder();
        sb.append("market://details?id=");
        sb.append(uriSchemeIntent != null ? uriSchemeIntent.getPackage() : null);
        return new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
    }

    private final boolean skipThirdPartyAppDeepLinkIfNotInstalled(String url) {
        List<String> list = whitelistedThirdPartyDeepLinks;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (StringsKt.startsWith$default(url, (String) it.next(), false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    private final boolean isParkeeNotInstalled(String url, PackageManager packageManager) {
        return Intrinsics.areEqual(url, LANDINGPAGE_OPEN_PARKEE_APP) && !AppUtil.getAuthRequestContext(PACKAGE_PARKEE_APP, packageManager);
    }
}
