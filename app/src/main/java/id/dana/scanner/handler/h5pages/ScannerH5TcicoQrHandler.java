package id.dana.scanner.handler.h5pages;

import android.content.Context;
import id.dana.model.ScanModel;
import id.dana.utils.danah5.DanaH5Listener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/scanner/handler/h5pages/ScannerH5TcicoQrHandler;", "Lid/dana/scanner/handler/h5pages/BaseScannerH5PageHandler;", "", "BuiltInFictitiousFunctionClassFactory", "()Ljava/lang/String;", "Landroid/content/Context;", "p0", "Lid/dana/utils/danah5/DanaH5Listener;", "p1", "Lid/dana/model/ScanModel;", "p2", "p3", "<init>", "(Landroid/content/Context;Lid/dana/utils/danah5/DanaH5Listener;Lid/dana/model/ScanModel;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ScannerH5TcicoQrHandler extends BaseScannerH5PageHandler {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScannerH5TcicoQrHandler(Context context, DanaH5Listener danaH5Listener, ScanModel scanModel, String str) {
        super(context, danaH5Listener, scanModel);
        Intrinsics.checkNotNullParameter(danaH5Listener, "");
        Intrinsics.checkNotNullParameter(scanModel, "");
        Intrinsics.checkNotNullParameter(str, "");
    }

    @Override // id.dana.scanner.handler.h5pages.BaseScannerH5PageHandler
    protected final String BuiltInFictitiousFunctionClassFactory() {
        String redirectUrl = getAuthRequestContext().getRedirectUrl();
        Intrinsics.checkNotNullExpressionValue(redirectUrl, "");
        return redirectUrl;
    }
}
