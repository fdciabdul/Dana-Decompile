package id.dana.danah5.yellowai;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.alibaba.ariver.app.api.Page;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.base.UrlTransportEventHandler;
import id.dana.data.constant.DanaUrl;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u000e"}, d2 = {"Lid/dana/danah5/yellowai/YellowAiCatcherEventHandler;", "Lid/dana/danah5/base/UrlTransportEventHandler;", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "", "url", "", "handlePdf", "(Landroid/app/Activity;Ljava/lang/String;)Z", "Lcom/alibaba/ariver/app/api/Page;", "page", "interceptUrl", "(Lcom/alibaba/ariver/app/api/Page;Ljava/lang/String;)Z", "isNotDeeplink", "(Ljava/lang/String;)Z", "isValidYellowAiUrl", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class YellowAiCatcherEventHandler extends UrlTransportEventHandler {
    private static final String PDF_FILE_EXTENSION = ".pdf";
    private static final String YELLOWAI_BASE_URL = "https://cdn.yellowmessenger.com";

    @Override // id.dana.danah5.base.UrlTransportEventHandler, com.alibaba.griver.api.common.page.GriverInterceptUrlEvent
    public final boolean interceptUrl(Page page, String url) {
        Activity activity;
        if (page == null || (activity = BridgeExtensionExtKt.getActivity(page)) == null || url == null) {
            return false;
        }
        return handlePdf(activity, url);
    }

    private final boolean handlePdf(Activity activity, String url) {
        if (isValidYellowAiUrl(url)) {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
            return true;
        }
        return false;
    }

    private final boolean isValidYellowAiUrl(String url) {
        String str = url;
        return StringsKt.contains$default((CharSequence) str, (CharSequence) YELLOWAI_BASE_URL, false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) ".pdf", false, 2, (Object) null) && isNotDeeplink(url);
    }

    private final boolean isNotDeeplink(String url) {
        String str = url;
        return (StringsKt.contains$default((CharSequence) str, (CharSequence) DanaUrl.DEEPLINK_URL, false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) DanaUrl.TIX_ID, false, 2, (Object) null)) ? false : true;
    }
}
