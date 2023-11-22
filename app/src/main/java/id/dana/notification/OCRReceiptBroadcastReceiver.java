package id.dana.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ap.zoloz.hummer.biz.HummerConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/notification/OCRReceiptBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Lid/dana/notification/OCRReceiptBroadcastReceiver$OnOCRReceiptBroadcastReceiver;", "getAuthRequestContext", "Lid/dana/notification/OCRReceiptBroadcastReceiver$OnOCRReceiptBroadcastReceiver;", "PlaceComponentResult", "onOCRReceiptBroadcastReceiver", "<init>", "(Lid/dana/notification/OCRReceiptBroadcastReceiver$OnOCRReceiptBroadcastReceiver;)V", "OnOCRReceiptBroadcastReceiver"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class OCRReceiptBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final OnOCRReceiptBroadcastReceiver PlaceComponentResult;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/notification/OCRReceiptBroadcastReceiver$OnOCRReceiptBroadcastReceiver;", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public interface OnOCRReceiptBroadcastReceiver {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
    }

    public OCRReceiptBroadcastReceiver(OnOCRReceiptBroadcastReceiver onOCRReceiptBroadcastReceiver) {
        Intrinsics.checkNotNullParameter(onOCRReceiptBroadcastReceiver, "");
        this.PlaceComponentResult = onOCRReceiptBroadcastReceiver;
    }
}
