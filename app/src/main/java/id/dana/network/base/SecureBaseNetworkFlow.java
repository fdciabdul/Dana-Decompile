package id.dana.network.base;

import android.content.Context;
import com.alipayplus.mobile.component.common.facade.base.MobileEnvInfo;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.network.rpc.RpcConnector;
import id.dana.network.util.BaseNetworkUtils;
import id.dana.utils.foundation.facede.ApSecurity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0004\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/network/base/SecureBaseNetworkFlow;", "T", "Lid/dana/network/base/BaseNetworkFlow;", "Lcom/alipayplus/mobile/component/common/facade/base/MobileEnvInfo;", "generateMobileEnvInfo", "()Lcom/alipayplus/mobile/component/common/facade/base/MobileEnvInfo;", "Lid/dana/utils/foundation/facede/ApSecurity;", "apSecurityFacade", "Lid/dana/utils/foundation/facede/ApSecurity;", "getApSecurityFacade", "()Lid/dana/utils/foundation/facede/ApSecurity;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "<init>", "(Lid/dana/utils/foundation/facede/ApSecurity;Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SecureBaseNetworkFlow<T> extends BaseNetworkFlow<T> {
    private final ApSecurity apSecurityFacade;

    @JvmName(name = "getApSecurityFacade")
    public final ApSecurity getApSecurityFacade() {
        return this.apSecurityFacade;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SecureBaseNetworkFlow(ApSecurity apSecurity, Context context, RpcConnector rpcConnector) {
        super(context, rpcConnector);
        Intrinsics.checkNotNullParameter(apSecurity, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        this.apSecurityFacade = apSecurity;
    }

    public final MobileEnvInfo generateMobileEnvInfo() {
        MobileEnvInfo generateMobileEnvInfo = BaseNetworkUtils.generateMobileEnvInfo(this.apSecurityFacade, getContext());
        Intrinsics.checkNotNullExpressionValue(generateMobileEnvInfo, "");
        return generateMobileEnvInfo;
    }
}
