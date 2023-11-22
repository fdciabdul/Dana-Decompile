package id.dana.wallet_v3;

import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.google.common.primitives.SignedBytes;
import dagger.Lazy;
import id.dana.danah5.DanaH5;
import id.dana.danah5.DanaH5Key;
import id.dana.data.constant.UrlParam;
import id.dana.domain.DefaultObserver;
import id.dana.domain.h5event.interactor.GetCheckoutH5Event;
import id.dana.lib.gcontainer.GContainer;
import id.dana.mapper.ThirdPartyServicesUrlMapper;
import id.dana.model.ThirdPartyService;
import id.dana.utils.UrlUtil;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.wallet_v3.listener.H5ServicesClickListener;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J3\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004\"\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/wallet_v3/WalletH5ServicesImplementation;", "Lid/dana/wallet_v3/listener/H5ServicesClickListener;", "Lid/dana/utils/danah5/DanaH5Listener;", "createH5AppListener", "()Lid/dana/utils/danah5/DanaH5Listener;", "", "doOnOpenH5", "()V", "Lid/dana/model/ThirdPartyService;", "thirdPartyService", "", "url", "authCode", UrlParam.REQUEST_ID, "openH5", "(Lid/dana/model/ThirdPartyService;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Ldagger/Lazy;", "Lid/dana/domain/h5event/interactor/GetCheckoutH5Event;", "getCheckoutH5Event", "Ldagger/Lazy;", "walletH5Listener", "Lid/dana/utils/danah5/DanaH5Listener;", "getWalletH5Listener", "setWalletH5Listener", "(Lid/dana/utils/danah5/DanaH5Listener;)V", "<init>", "(Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WalletH5ServicesImplementation implements H5ServicesClickListener {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1257195688;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = -1475088285;
    private static short[] MyBillsEntityDataFactory = null;
    private static int lookAheadTest = 0;
    private static int scheduleImpl = 1;
    private final Lazy<GetCheckoutH5Event> getCheckoutH5Event;
    private DanaH5Listener walletH5Listener;
    private static byte[] getAuthRequestContext = {67, 79, -73, -66, 73, SignedBytes.MAX_POWER_OF_TWO, 95, -97};
    private static int PlaceComponentResult = -212792869;

    @Inject
    public WalletH5ServicesImplementation(Lazy<GetCheckoutH5Event> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.getCheckoutH5Event = lazy;
    }

    public static final /* synthetic */ Lazy access$getGetCheckoutH5Event$p(WalletH5ServicesImplementation walletH5ServicesImplementation) {
        int i = scheduleImpl + 5;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        Lazy<GetCheckoutH5Event> lazy = walletH5ServicesImplementation.getCheckoutH5Event;
        int i3 = scheduleImpl + 81;
        lookAheadTest = i3 % 128;
        int i4 = i3 % 2;
        return lazy;
    }

    @JvmName(name = "getWalletH5Listener")
    public final DanaH5Listener getWalletH5Listener() {
        DanaH5Listener danaH5Listener;
        int i = lookAheadTest + 69;
        scheduleImpl = i % 128;
        Object[] objArr = null;
        if (!(i % 2 == 0)) {
            danaH5Listener = this.walletH5Listener;
        } else {
            danaH5Listener = this.walletH5Listener;
            int length = objArr.length;
        }
        int i2 = scheduleImpl + 99;
        lookAheadTest = i2 % 128;
        if (i2 % 2 != 0) {
            int length2 = objArr.length;
            return danaH5Listener;
        }
        return danaH5Listener;
    }

    @JvmName(name = "setWalletH5Listener")
    public final void setWalletH5Listener(DanaH5Listener danaH5Listener) {
        int i = lookAheadTest + 15;
        scheduleImpl = i % 128;
        if (!(i % 2 == 0)) {
            this.walletH5Listener = danaH5Listener;
            return;
        }
        try {
            this.walletH5Listener = danaH5Listener;
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.wallet_v3.listener.H5ServicesClickListener
    public final void openH5(ThirdPartyService thirdPartyService, String url, String authCode, String requestId) {
        Intrinsics.checkNotNullParameter(thirdPartyService, "");
        Intrinsics.checkNotNullParameter(url, "");
        GContainer.closeAllContainers();
        if (GContainer.isOpeningH5()) {
            return;
        }
        String KClassImpl$Data$declaredNonStaticMembers$22 = ThirdPartyServicesUrlMapper.KClassImpl$Data$declaredNonStaticMembers$2(url, authCode, requestId, thirdPartyService);
        Bundle bundle = new Bundle();
        bundle.putString(DanaH5.SERVICE_KEY, thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda8);
        if ((Intrinsics.areEqual(thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda8, "service_akulaku") ? 'a' : (char) 29) != 29) {
            int i = lookAheadTest + 45;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            Object[] objArr = new Object[1];
            a((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 1178713787, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 48, (short) ((-1) - TextUtils.lastIndexOf("", '0', 0)), 486754135 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (byte) ((-47) - TextUtils.indexOf((CharSequence) "", '0', 0)), objArr);
            String authRequestContext = UrlUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, ((String) objArr[0]).intern());
            Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
            bundle.putString("url", DanaH5.correctedUrl(authRequestContext));
            bundle.putString(DanaH5Key.Param.ADJUSTRESIZE, "YES");
            DanaH5.startContainerFullUrlWithSendCredentials$default(null, createH5AppListener(), bundle, null, 9, null);
            doOnOpenH5();
            return;
        }
        DanaH5.startContainerFullUrlWithSendCredentials$default(KClassImpl$Data$declaredNonStaticMembers$22, createH5AppListener(), bundle, null, 8, null);
        doOnOpenH5();
        int i3 = lookAheadTest + 37;
        scheduleImpl = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return;
        }
        int i4 = 88 / 0;
    }

    private final DanaH5Listener createH5AppListener() {
        DanaH5Listener danaH5Listener = new DanaH5Listener() { // from class: id.dana.wallet_v3.WalletH5ServicesImplementation$createH5AppListener$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle bundle) {
                DanaH5Listener.CC.getAuthRequestContext();
                DanaH5Listener walletH5Listener = WalletH5ServicesImplementation.this.getWalletH5Listener();
                if (walletH5Listener != null) {
                    walletH5Listener.onContainerCreated(bundle);
                }
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle bundle) {
                ((GetCheckoutH5Event) WalletH5ServicesImplementation.access$getGetCheckoutH5Event$p(WalletH5ServicesImplementation.this).get()).dispose();
                DanaH5.dispose();
                DanaH5Listener walletH5Listener = WalletH5ServicesImplementation.this.getWalletH5Listener();
                if (walletH5Listener != null) {
                    walletH5Listener.onContainerDestroyed(bundle);
                }
            }
        };
        int i = lookAheadTest + 13;
        scheduleImpl = i % 128;
        if (!(i % 2 != 0)) {
            Object[] objArr = null;
            int length = objArr.length;
            return danaH5Listener;
        }
        return danaH5Listener;
    }

    private final void doOnOpenH5() {
        try {
            this.getCheckoutH5Event.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.wallet_v3.WalletH5ServicesImplementation$doOnOpenH5$1
                public final void onNext(boolean success) {
                }

                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final /* synthetic */ void onNext(Object obj) {
                    onNext(((Boolean) obj).booleanValue());
                }
            });
            int i = scheduleImpl + 63;
            lookAheadTest = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c3, code lost:
    
        if (r3 != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d0, code lost:
    
        if (r3 != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d2, code lost:
    
        r3 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d4, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r13, int r14, short r15, int r16, byte r17, java.lang.Object[] r18) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.WalletH5ServicesImplementation.a(int, int, short, int, byte, java.lang.Object[]):void");
    }
}
