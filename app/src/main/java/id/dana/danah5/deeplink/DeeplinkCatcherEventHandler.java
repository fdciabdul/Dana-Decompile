package id.dana.danah5.deeplink;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.griver.base.common.utils.H5UrlHelper;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.base.UrlTransportEventHandler;
import id.dana.data.constant.DanaUrl;
import id.dana.extension.lang.StringExtKt;
import id.dana.lib.gcontainer.GContainer;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000e\u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/danah5/deeplink/DeeplinkCatcherEventHandler;", "Lid/dana/danah5/base/UrlTransportEventHandler;", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "", "url", "Lcom/alibaba/ariver/app/api/Page;", "page", "", "handleDeepLinkIntent", "(Landroid/app/Activity;Ljava/lang/String;Lcom/alibaba/ariver/app/api/Page;)Z", "interceptUrl", "(Lcom/alibaba/ariver/app/api/Page;Ljava/lang/String;)Z", "", "onPageFinished", "(Lcom/alibaba/ariver/app/api/Page;Ljava/lang/String;)V", "deeplink", "Landroid/net/Uri;", "uri", "uriContainsDeepLink", "(Ljava/lang/String;Landroid/net/Uri;)Z", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DeeplinkCatcherEventHandler extends UrlTransportEventHandler {
    private static final String ACTION = "deepLinkH5_broadcast_filter";
    private static final String TAG;
    private static final String URL_DEEPLINK_EXTRA = "urlDeepLinkH5";

    @Override // id.dana.danah5.base.UrlTransportEventHandler, com.alibaba.griver.api.common.page.GriverInterceptUrlEvent
    public final boolean interceptUrl(Page page, String url) {
        Activity activity;
        if (page == null || (activity = BridgeExtensionExtKt.getActivity(page)) == null || url == null) {
            return false;
        }
        return handleDeepLinkIntent(activity, url, page);
    }

    @Override // id.dana.danah5.base.UrlTransportEventHandler, com.alibaba.griver.api.common.page.GriverPageHelperEvent
    public final void onPageFinished(Page page, String url) {
        PageContext pageContext;
        Activity activity;
        Uri parse = Uri.parse(page != null ? page.getPageURI() : null);
        Intrinsics.checkNotNullExpressionValue(parse, "");
        if (uriContainsDeepLink(DanaUrl.TIX_ID, parse)) {
            DanaLog.MyBillsEntityDataFactory(TAG, "Deeplik TIX url");
            if (page != null && (pageContext = page.getPageContext()) != null && (activity = pageContext.getActivity()) != null) {
                activity.finish();
            }
        }
        DeeplinkResolver.closePushWindow(page, url);
    }

    private final boolean handleDeepLinkIntent(Activity activity, String url, Page page) {
        Uri parseUrl = H5UrlHelper.parseUrl(url);
        if (parseUrl == null) {
            return false;
        }
        String host = parseUrl.getHost();
        if (!(host == null || StringsKt.isBlank(host)) && uriContainsDeepLink(DanaUrl.DEEPLINK_URL, parseUrl)) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("deeplink url ");
            sb.append(url);
            DanaLog.MyBillsEntityDataFactory(str, sb.toString());
            Intent putExtra = new Intent(ACTION).putExtra(URL_DEEPLINK_EXTRA, parseUrl.toString());
            Intrinsics.checkNotNullExpressionValue(putExtra, "");
            activity.sendBroadcast(putExtra);
            return true;
        }
        DeeplinkResolver.closePushWindow(page, url);
        String str2 = TAG;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("not deeplink url ");
        sb2.append(url);
        DanaLog.MyBillsEntityDataFactory(str2, sb2.toString());
        return DeeplinkResolver.resolveUrl(GContainer.getApplicationContext(), url, page);
    }

    private final boolean uriContainsDeepLink(String deeplink, Uri uri) {
        String obj = uri.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return StringsKt.contains$default((CharSequence) StringExtKt.PlaceComponentResult(obj), (CharSequence) deeplink, false, 2, (Object) null);
    }

    static {
        Intrinsics.checkNotNullExpressionValue("DeeplinkCatcherEventHandler", "");
        TAG = "DeeplinkCatcherEventHandler";
    }
}
