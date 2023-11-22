package id.dana.animation;

import android.content.DialogInterface;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.R;
import id.dana.scanner.ScannerMaterialDialog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lid/dana/scanner/ScannerMaterialDialog;", BridgeDSL.INVOKE, "()Lid/dana/scanner/ScannerMaterialDialog;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
final class ScanQrLoyaltyActivity$scanFailedDialog$2 extends Lambda implements Function0<ScannerMaterialDialog> {
    final /* synthetic */ ScanQrLoyaltyActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScanQrLoyaltyActivity$scanFailedDialog$2(ScanQrLoyaltyActivity scanQrLoyaltyActivity) {
        super(0);
        this.this$0 = scanQrLoyaltyActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final ScannerMaterialDialog invoke() {
        return new ScannerMaterialDialog(this.this$0, new DialogInterface.OnDismissListener() { // from class: id.dana.loyalty.ScanQrLoyaltyActivity$scanFailedDialog$2$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
            }
        }, this.this$0.getString(R.string.failed_scan_message));
    }
}
