package id.dana.data.miniprogram.provider;

import android.graphics.Bitmap;
import com.alipay.iap.android.wallet.acl.base.APIContext;
import com.alipay.iap.android.wallet.acl.base.Callback;
import com.alipay.iap.android.wallet.foundation.code.CodeImageOption;
import com.alipay.iap.android.wallet.foundation.code.CodeService;
import com.alipay.iap.android.wallet.foundation.code.ScannerOption;
import com.alipay.iap.android.wallet.foundation.code.ScannerResult;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/data/miniprogram/provider/CodeServiceProvider;", "Lcom/alipay/iap/android/wallet/foundation/code/CodeService;", "Lcom/alipay/iap/android/wallet/foundation/code/CodeImageOption;", "p0", "Lcom/alipay/iap/android/wallet/acl/base/APIContext;", "p1", "Landroid/graphics/Bitmap;", "generateCodeImage", "(Lcom/alipay/iap/android/wallet/foundation/code/CodeImageOption;Lcom/alipay/iap/android/wallet/acl/base/APIContext;)Landroid/graphics/Bitmap;", "Lcom/alipay/iap/android/wallet/foundation/code/ScannerOption;", "Lcom/alipay/iap/android/wallet/acl/base/Callback;", "Lcom/alipay/iap/android/wallet/foundation/code/ScannerResult;", "p2", "", "scan", "(Lcom/alipay/iap/android/wallet/foundation/code/ScannerOption;Lcom/alipay/iap/android/wallet/acl/base/APIContext;Lcom/alipay/iap/android/wallet/acl/base/Callback;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CodeServiceProvider implements CodeService {
    @Override // com.alipay.iap.android.wallet.foundation.code.CodeService
    public final void scan(ScannerOption p0, APIContext p1, Callback<ScannerResult> p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p2, "");
        StringBuilder sb = new StringBuilder();
        sb.append("An operation is not implemented: ");
        sb.append("VAS20-2160 by Regina F.");
        throw new NotImplementedError(sb.toString());
    }

    @Override // com.alipay.iap.android.wallet.foundation.code.CodeService
    public final Bitmap generateCodeImage(CodeImageOption p0, APIContext p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        StringBuilder sb = new StringBuilder();
        sb.append("An operation is not implemented: ");
        sb.append("VAS20-2160 by Regina F.");
        throw new NotImplementedError(sb.toString());
    }
}
