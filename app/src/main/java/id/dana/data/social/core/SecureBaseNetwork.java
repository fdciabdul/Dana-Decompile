package id.dana.data.social.core;

import android.content.Context;
import com.alipayplus.mobile.component.common.facade.base.MobileEnvInfo;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.network.util.BaseNetworkUtils;
import io.michaelrocks.libphonenumber.android.NumberParseException;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;
import io.michaelrocks.libphonenumber.android.Phonenumber;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0004\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0004¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u000b\u001a\u00020\n8\u0007¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/data/social/core/SecureBaseNetwork;", "T", "Lid/dana/data/social/core/BaseNetwork;", "Lcom/alipayplus/mobile/component/common/facade/base/MobileEnvInfo;", "generateMobileEnvInfo", "()Lcom/alipayplus/mobile/component/common/facade/base/MobileEnvInfo;", "", "originFormat", "normalizePhoneNumber", "(Ljava/lang/String;)Ljava/lang/String;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "apSecurityFacade", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "getApSecurityFacade", "()Lid/dana/data/foundation/facade/ApSecurityFacade;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "<init>", "(Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SecureBaseNetwork<T> extends BaseNetwork<T> {
    private final ApSecurityFacade apSecurityFacade;

    @JvmName(name = "getApSecurityFacade")
    public final ApSecurityFacade getApSecurityFacade() {
        return this.apSecurityFacade;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SecureBaseNetwork(ApSecurityFacade apSecurityFacade, Context context, RpcConnector rpcConnector) {
        super(context, rpcConnector);
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        this.apSecurityFacade = apSecurityFacade;
    }

    public final MobileEnvInfo generateMobileEnvInfo() {
        MobileEnvInfo generateMobileEnvInfo = BaseNetworkUtils.generateMobileEnvInfo(this.apSecurityFacade, getContext());
        Intrinsics.checkNotNullExpressionValue(generateMobileEnvInfo, "");
        return generateMobileEnvInfo;
    }

    protected final String normalizePhoneNumber(String originFormat) {
        Intrinsics.checkNotNullParameter(originFormat, "");
        try {
            Phonenumber.PhoneNumber parse = PhoneNumberUtil.createInstance(getContext()).parse(originFormat, "ID");
            StringBuilder sb = new StringBuilder();
            sb.append(parse.getCountryCode());
            sb.append('-');
            sb.append(parse.getNationalNumber());
            return sb.toString();
        } catch (NumberParseException e) {
            return originFormat;
        }
    }
}
