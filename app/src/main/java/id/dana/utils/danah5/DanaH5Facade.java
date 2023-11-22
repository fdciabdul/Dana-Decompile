package id.dana.utils.danah5;

import android.os.Bundle;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005H&J8\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005H&J8\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Lid/dana/utils/danah5/DanaH5Facade;", "", "startContainerFullUrl", "", "url", "", "danaH5Listener", "Lid/dana/utils/danah5/DanaH5Listener;", "screenOrientation", "startContainerFullUrlWithSendCredentials", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, HummerConstants.BUNDLE, "Landroid/os/Bundle;", "startContainerFullUrlWithSendCredentialsWithoutTimeOut", "startContainerFullUrlWithoutTimeout", "core-utils_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface DanaH5Facade {
    void startContainerFullUrl(String url);

    void startContainerFullUrlWithSendCredentialsWithoutTimeOut(String url, DanaH5Listener listener, Bundle bundle, String screenOrientation);

    void startContainerFullUrlWithoutTimeout(String url, DanaH5Listener danaH5Listener);

    /* renamed from: id.dana.utils.danah5.DanaH5Facade$-CC  reason: invalid class name */
    /* loaded from: classes5.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void MyBillsEntityDataFactory(DanaH5Facade danaH5Facade, String str, DanaH5Listener danaH5Listener) {
            danaH5Facade.startContainerFullUrlWithSendCredentialsWithoutTimeOut(str, danaH5Listener, null, "portrait");
        }
    }
}
