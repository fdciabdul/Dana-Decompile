package id.dana.network.base;

import android.content.Context;
import com.alipayplus.mobile.component.common.facade.base.MobileEnvInfo;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.network.util.BaseNetworkUtils;
import id.dana.utils.foundation.facede.ApSecurity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/network/base/BaseSecureRestNetwork;", "A", "Lid/dana/network/base/BaseRestNetwork;", "Lcom/alipayplus/mobile/component/common/facade/base/MobileEnvInfo;", "generateMobileEnvInfo", "()Lcom/alipayplus/mobile/component/common/facade/base/MobileEnvInfo;", "Lid/dana/utils/foundation/facede/ApSecurity;", "apSecurityFacade", "Lid/dana/utils/foundation/facede/ApSecurity;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;Lid/dana/utils/foundation/facede/ApSecurity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public class BaseSecureRestNetwork<A> extends BaseRestNetwork<A> {
    private final ApSecurity apSecurityFacade;
    private final Context context;

    public BaseSecureRestNetwork(Context context, ApSecurity apSecurity) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(apSecurity, "");
        this.context = context;
        this.apSecurityFacade = apSecurity;
    }

    public final MobileEnvInfo generateMobileEnvInfo() {
        MobileEnvInfo generateMobileEnvInfo = BaseNetworkUtils.generateMobileEnvInfo(this.apSecurityFacade, this.context);
        Intrinsics.checkNotNullExpressionValue(generateMobileEnvInfo, "");
        return generateMobileEnvInfo;
    }
}
