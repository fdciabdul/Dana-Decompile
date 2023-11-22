package id.dana.domain.util;

import com.alipay.iap.android.wallet.acl.WalletServiceManager;
import com.alipay.iap.android.wallet.acl.base.BaseService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u0005\u001a\u00020\u0004\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u0002H\u0086\b¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/util/AlipayConnectUtils;", "", "Lcom/alipay/iap/android/wallet/acl/base/BaseService;", "T", "", "registerProvider", "()Z", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AlipayConnectUtils {
    public static final AlipayConnectUtils INSTANCE = new AlipayConnectUtils();

    private AlipayConnectUtils() {
    }

    public final /* synthetic */ <T extends BaseService> boolean registerProvider() {
        try {
            WalletServiceManager walletServiceManager = WalletServiceManager.getInstance();
            Intrinsics.reifiedOperationMarker(4, "T");
            walletServiceManager.registerServices(BaseService.class);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
