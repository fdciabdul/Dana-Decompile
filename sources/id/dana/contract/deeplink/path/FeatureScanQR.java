package id.dana.contract.deeplink.path;

import android.app.Activity;
import android.content.Intent;
import id.dana.di.PerActivity;
import id.dana.scanner.ScannerActivity;
import id.dana.scanner.TrackerQRScanner;
import id.dana.scanner.handler.ScannerActionFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\f\u0010\rJ1\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/contract/deeplink/path/FeatureScanQR;", "", "Landroid/app/Activity;", "p0", "", "p1", "", "p2", "p3", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes4.dex */
public final class FeatureScanQR {
    @Inject
    public FeatureScanQR() {
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Activity activity, String str, String str2) {
        Intrinsics.checkNotNullParameter(activity, "");
        TrackerQRScanner.PlaceComponentResult(str);
        Intent intent = new Intent(activity, ScannerActivity.class);
        if (str2 == null) {
            str2 = "";
        }
        intent.putExtra("scene", str2);
        intent.putExtra(ScannerActivity.CLOSE_AFTER_SCAN, false);
        activity.startActivityForResult(intent, ScannerActionFactory.BuiltInFictitiousFunctionClassFactory);
    }
}
