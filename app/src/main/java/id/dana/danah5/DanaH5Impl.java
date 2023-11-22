package id.dana.danah5;

import android.os.Bundle;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import id.dana.utils.danah5.DanaH5Facade;
import id.dana.utils.danah5.DanaH5Listener;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\tJ+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u000bJ7\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\u0011\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J!\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\t"}, d2 = {"Lid/dana/danah5/DanaH5Impl;", "Lid/dana/utils/danah5/DanaH5Facade;", "", "url", "", "startContainerFullUrl", "(Ljava/lang/String;)V", "Lid/dana/utils/danah5/DanaH5Listener;", "danaH5Listener", "(Ljava/lang/String;Lid/dana/utils/danah5/DanaH5Listener;)V", "screenOrientation", "(Ljava/lang/String;Lid/dana/utils/danah5/DanaH5Listener;Ljava/lang/String;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/os/Bundle;", HummerConstants.BUNDLE, "startContainerFullUrlWithSendCredentials", "(Ljava/lang/String;Lid/dana/utils/danah5/DanaH5Listener;Landroid/os/Bundle;Ljava/lang/String;)V", "startContainerFullUrlWithSendCredentialsWithoutTimeOut", "startContainerFullUrlWithoutTimeout", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DanaH5Impl implements DanaH5Facade {
    @Inject
    public DanaH5Impl() {
    }

    @Override // id.dana.utils.danah5.DanaH5Facade
    public final void startContainerFullUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "");
        DanaH5.startContainerFullUrl(url);
    }

    public final void startContainerFullUrl(String url, DanaH5Listener danaH5Listener) {
        Intrinsics.checkNotNullParameter(url, "");
        DanaH5.startContainerFullUrl(url, danaH5Listener);
    }

    public final void startContainerFullUrl(String url, DanaH5Listener danaH5Listener, String screenOrientation) {
        Intrinsics.checkNotNullParameter(url, "");
        DanaH5.startContainerFullUrl(url, danaH5Listener, screenOrientation);
    }

    @Override // id.dana.utils.danah5.DanaH5Facade
    public final void startContainerFullUrlWithoutTimeout(String url, DanaH5Listener danaH5Listener) {
        Intrinsics.checkNotNullParameter(url, "");
        DanaH5.startContainerFullUrlWithoutTimeout(url, danaH5Listener);
    }

    public final void startContainerFullUrlWithSendCredentials(String url, DanaH5Listener listener, Bundle bundle, String screenOrientation) {
        DanaH5.startContainerFullUrlWithSendCredentials(url, listener, bundle, screenOrientation);
    }

    @Override // id.dana.utils.danah5.DanaH5Facade
    public final void startContainerFullUrlWithSendCredentialsWithoutTimeOut(String url, DanaH5Listener listener, Bundle bundle, String screenOrientation) {
        DanaH5.startContainerFullUrlWithSendCredentialsWithoutTimeOut(url, listener, bundle, screenOrientation);
    }
}
