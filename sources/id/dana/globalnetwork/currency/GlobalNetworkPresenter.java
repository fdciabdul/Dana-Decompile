package id.dana.globalnetwork.currency;

import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.alipay.iap.android.wallet.acl.oauth.OAuthResult;
import com.alipay.iap.android.wallet.acl.payment.PaymentResult;
import com.alipay.iap.android.wallet.acl.payment.PaymentType;
import com.alipay.imobile.network.quake.exception.ServerException;
import dagger.Lazy;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.contract.deeplink.DeeplinkSaveDataManager;
import id.dana.contract.deeplink.tracker.GlobalNetworkMethod;
import id.dana.data.globalnetwork.source.remote.PaymentServiceProvider;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.authcode.AuthCodeResult;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.globalnetwork.interactor.DecodeGnQr;
import id.dana.domain.globalnetwork.interactor.GetCountryCodeByLocationBlacklistedCountry;
import id.dana.domain.globalnetwork.interactor.GetGnCScanBBlacklistedCountry;
import id.dana.domain.globalnetwork.interactor.GetPayRequest;
import id.dana.domain.globalnetwork.interactor.GetWalletOauth;
import id.dana.domain.globalnetwork.interactor.IsAlipayConnectServiceFirstTime;
import id.dana.domain.globalnetwork.interactor.IsCScanBEnabled;
import id.dana.domain.globalnetwork.interactor.OpenMerchantCashier;
import id.dana.domain.globalnetwork.interactor.SaveAlipayConnectServiceFirstTime;
import id.dana.domain.globalnetwork.model.Auth;
import id.dana.domain.globalnetwork.model.Pay;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.globalnetwork.GnLoadTimeTracker;
import id.dana.globalnetwork.currency.GlobalNetworkContract;
import id.dana.globalnetwork.tracker.GlobalNetworkTracker;
import id.dana.miniprogram.ExtensionsKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.whenAvailable;
import org.greenrobot.eventbus.EventBus;

@PerActivity
/* loaded from: classes5.dex */
public class GlobalNetworkPresenter implements GlobalNetworkContract.Presenter {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda3 = 1;
    private static int newProxyInstance;
    private Lazy<GetAuthCode> BuiltInFictitiousFunctionClassFactory;
    private boolean DatabaseTableConfigUtil;
    private Lazy<GlobalNetworkTracker> GetContactSyncConfig;
    private String KClassImpl$Data$declaredNonStaticMembers$2;
    private final CompositeDisposable MyBillsEntityDataFactory;
    private final Lazy<GetUserInfoWithKyc> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Lazy<IsCScanBEnabled> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Lazy<OpenMerchantCashier> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Lazy<GlobalNetworkContract.View> NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final Lazy<DecodeGnQr> PlaceComponentResult;
    private String getAuthRequestContext;
    private Lazy<GetCountryCodeByLocationBlacklistedCountry> getErrorConfigVersion;
    private Lazy<IsAlipayConnectServiceFirstTime> initRecordTimeStamp;
    private Lazy<SaveAlipayConnectServiceFirstTime> isLayoutRequested;
    private final Lazy<GetGnCScanBBlacklistedCountry> lookAheadTest;
    private Lazy<GetWalletOauth> moveToNextValue;
    private Lazy<GetPayRequest> scheduleImpl;
    private static char[] PrepareContext = {42850, 21112, 19773, 30972, 29575, 28011, 6196, 5114, 3757, 14432, 13102};
    private static long NetworkUserEntityData$$ExternalSyntheticLambda8 = 9073346332216133232L;

    static /* synthetic */ String BuiltInFictitiousFunctionClassFactory(GlobalNetworkPresenter globalNetworkPresenter) {
        int i = newProxyInstance + 3;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        String str = globalNetworkPresenter.KClassImpl$Data$declaredNonStaticMembers$2;
        int i3 = newProxyInstance + 9;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
        if ((i3 % 2 == 0 ? 'E' : (char) 6) != 'E') {
            return str;
        }
        Object obj = null;
        obj.hashCode();
        return str;
    }

    static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(GlobalNetworkPresenter globalNetworkPresenter, String str) {
        try {
            int i = newProxyInstance + 51;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
            if ((i % 2 == 0 ? (char) 0 : 'b') != 0) {
                globalNetworkPresenter.getAuthRequestContext(str);
                return;
            }
            globalNetworkPresenter.getAuthRequestContext(str);
            int i2 = 46 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(GlobalNetworkPresenter globalNetworkPresenter, String str, String str2) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 35;
        newProxyInstance = i % 128;
        int i2 = i % 2;
        globalNetworkPresenter.getAuthRequestContext(str, str2);
        try {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 81;
            try {
                newProxyInstance = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static /* synthetic */ Lazy KClassImpl$Data$declaredNonStaticMembers$2(GlobalNetworkPresenter globalNetworkPresenter) {
        int i = newProxyInstance + 83;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        try {
            Lazy<GlobalNetworkTracker> lazy = globalNetworkPresenter.GetContactSyncConfig;
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 105;
            newProxyInstance = i3 % 128;
            int i4 = i3 % 2;
            return lazy;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(GlobalNetworkPresenter globalNetworkPresenter, Throwable th) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 25;
        newProxyInstance = i % 128;
        char c = i % 2 != 0 ? (char) 16 : 'R';
        globalNetworkPresenter.KClassImpl$Data$declaredNonStaticMembers$2(th);
        if (c != 16) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    static /* synthetic */ String MyBillsEntityDataFactory(GlobalNetworkPresenter globalNetworkPresenter) {
        String str;
        int i = newProxyInstance + 21;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        if ((i % 2 == 0 ? ')' : (char) 14) != ')') {
            str = globalNetworkPresenter.getAuthRequestContext;
        } else {
            try {
                str = globalNetworkPresenter.getAuthRequestContext;
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = newProxyInstance + 67;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i2 % 128;
        int i3 = i2 % 2;
        return str;
    }

    static /* synthetic */ boolean PlaceComponentResult(GlobalNetworkPresenter globalNetworkPresenter) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 107;
        newProxyInstance = i % 128;
        int i2 = i % 2;
        globalNetworkPresenter.DatabaseTableConfigUtil = false;
        int i3 = newProxyInstance + 29;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
        int i4 = i3 % 2;
        return false;
    }

    static /* synthetic */ Lazy getAuthRequestContext(GlobalNetworkPresenter globalNetworkPresenter) {
        int i = newProxyInstance + 113;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        if (i % 2 != 0) {
            return globalNetworkPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
        try {
            Lazy<GetUserInfoWithKyc> lazy = globalNetworkPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0;
            Object obj = null;
            obj.hashCode();
            return lazy;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ Lazy lookAheadTest(GlobalNetworkPresenter globalNetworkPresenter) {
        try {
            int i = newProxyInstance + 13;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
            int i2 = i % 2;
            Lazy<GlobalNetworkContract.View> lazy = globalNetworkPresenter.NetworkUserEntityData$$ExternalSyntheticLambda7;
            try {
                int i3 = newProxyInstance + 87;
                NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
                int i4 = i3 % 2;
                return lazy;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Inject
    public GlobalNetworkPresenter(Lazy<GlobalNetworkContract.View> lazy, Lazy<IsCScanBEnabled> lazy2, Lazy<DecodeGnQr> lazy3, Lazy<OpenMerchantCashier> lazy4, Lazy<GetGnCScanBBlacklistedCountry> lazy5, Lazy<GetUserInfoWithKyc> lazy6, Lazy<GlobalNetworkTracker> lazy7) {
        try {
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = lazy;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = lazy2;
            this.PlaceComponentResult = lazy3;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = lazy4;
            this.lookAheadTest = lazy5;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lazy6;
            this.GetContactSyncConfig = lazy7;
            this.MyBillsEntityDataFactory = new CompositeDisposable();
        } catch (Exception e) {
            throw e;
        }
    }

    @Inject
    public final void MyBillsEntityDataFactory(Lazy<GetCountryCodeByLocationBlacklistedCountry> lazy) {
        int i = newProxyInstance + 97;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        try {
            if ((i % 2 == 0 ? (char) 5 : '\n') != '\n') {
                this.getErrorConfigVersion = lazy;
                Object[] objArr = null;
                int length = objArr.length;
            } else {
                this.getErrorConfigVersion = lazy;
            }
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 77;
            newProxyInstance = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @Inject
    public final void MyBillsEntityDataFactory(Lazy<IsAlipayConnectServiceFirstTime> lazy, Lazy<SaveAlipayConnectServiceFirstTime> lazy2, Lazy<GetWalletOauth> lazy3, Lazy<GetAuthCode> lazy4) {
        try {
            int i = newProxyInstance + 67;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
            int i2 = i % 2;
            this.initRecordTimeStamp = lazy;
            this.isLayoutRequested = lazy2;
            this.moveToNextValue = lazy3;
            this.BuiltInFictitiousFunctionClassFactory = lazy4;
            try {
                int i3 = newProxyInstance + 63;
                NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
                if ((i3 % 2 == 0 ? 'P' : ':') != 'P') {
                    return;
                }
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Inject
    public final void BuiltInFictitiousFunctionClassFactory(Lazy<GetPayRequest> lazy) {
        int i = newProxyInstance + 17;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        try {
            if (!(i % 2 == 0)) {
                this.scheduleImpl = lazy;
            } else {
                this.scheduleImpl = lazy;
                Object obj = null;
                obj.hashCode();
            }
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 97;
            try {
                newProxyInstance = i2 % 128;
                int i3 = i2 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(String str) {
        try {
            int i = newProxyInstance + 27;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
            char c = i % 2 == 0 ? '1' : 'R';
            Object[] objArr = null;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            if (c == '1') {
                objArr.hashCode();
            }
            int i2 = newProxyInstance + 99;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i2 % 128;
            if ((i2 % 2 == 0 ? '=' : 'U') != 'U') {
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 27;
        newProxyInstance = i % 128;
        char c = i % 2 != 0 ? '3' : '!';
        Object[] objArr = null;
        this.getAuthRequestContext = str;
        if (c != '!') {
            int length = objArr.length;
        }
        int i2 = newProxyInstance + 1;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i2 % 128;
        if ((i2 % 2 == 0 ? '\r' : (char) 27) != '\r') {
            return;
        }
        objArr.hashCode();
    }

    @Override // id.dana.globalnetwork.currency.GlobalNetworkContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final String str, final String str2) {
        this.MyBillsEntityDataFactory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda1.get().execute(null).onErrorReturnItem(Boolean.FALSE).subscribe(new Consumer() { // from class: id.dana.globalnetwork.currency.GlobalNetworkPresenter$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GlobalNetworkPresenter.this.PlaceComponentResult(str, str2, (Boolean) obj);
            }
        }));
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 91;
        newProxyInstance = i % 128;
        int i2 = i % 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void PlaceComponentResult(String str, String str2, Boolean bool) throws Exception {
        if (!(!Boolean.TRUE.equals(bool))) {
            int i = newProxyInstance + 73;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
            int i2 = i % 2;
            BuiltInFictitiousFunctionClassFactory(str);
            KClassImpl$Data$declaredNonStaticMembers$2(str2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().PlaceComponentResult();
            try {
                int i3 = newProxyInstance + 35;
                NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
                if ((i3 % 2 == 0 ? '\n' : '/') != '/') {
                    Object obj = null;
                    obj.hashCode();
                    return;
                }
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().getAuthRequestContext();
    }

    @Override // id.dana.globalnetwork.currency.GlobalNetworkContract.Presenter
    public final void PlaceComponentResult() {
        this.lookAheadTest.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.globalnetwork.currency.GlobalNetworkPresenter$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GlobalNetworkPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2((List) obj);
            }
        }, new Function1() { // from class: id.dana.globalnetwork.currency.GlobalNetworkPresenter$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GlobalNetworkPresenter.BuiltInFictitiousFunctionClassFactory((Throwable) obj);
            }
        });
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 9;
            try {
                newProxyInstance = i % 128;
                if (i % 2 == 0) {
                    return;
                }
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Unit KClassImpl$Data$declaredNonStaticMembers$2(List list) {
        int i = newProxyInstance + 95;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        try {
            MyBillsEntityDataFactory(list);
            Unit unit = Unit.INSTANCE;
            int i3 = newProxyInstance + 41;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
            if (!(i3 % 2 == 0)) {
                return unit;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return unit;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit BuiltInFictitiousFunctionClassFactory(Throwable th) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 71;
        newProxyInstance = i % 128;
        int i2 = i % 2;
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GLOBAL_NETWORK, th.getMessage());
        Unit unit = Unit.INSTANCE;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 31;
        newProxyInstance = i3 % 128;
        int i4 = i3 % 2;
        return unit;
    }

    private void MyBillsEntityDataFactory(final List<String> list) {
        this.getErrorConfigVersion.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.globalnetwork.currency.GlobalNetworkPresenter$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GlobalNetworkPresenter.this.getAuthRequestContext(list, (String) obj);
            }
        }, new Function1() { // from class: id.dana.globalnetwork.currency.GlobalNetworkPresenter$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GlobalNetworkPresenter.PlaceComponentResult((Throwable) obj);
            }
        });
        int i = newProxyInstance + 91;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Unit getAuthRequestContext(List list, String str) {
        if (list.contains(str)) {
            int i = newProxyInstance + 93;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
            int i2 = i % 2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().KClassImpl$Data$declaredNonStaticMembers$2();
        } else {
            PlaceComponentResult(false);
        }
        try {
            Unit unit = Unit.INSTANCE;
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 115;
            newProxyInstance = i3 % 128;
            if ((i3 % 2 != 0 ? 'B' : (char) 20) != 20) {
                Object[] objArr = null;
                int length = objArr.length;
                return unit;
            }
            return unit;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit PlaceComponentResult(Throwable th) {
        try {
            int i = newProxyInstance + 15;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
            int i2 = i % 2;
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GLOBAL_NETWORK, th.getMessage());
            Unit unit = Unit.INSTANCE;
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 97;
            newProxyInstance = i3 % 128;
            if ((i3 % 2 != 0 ? Typography.less : 'L') != '<') {
                return unit;
            }
            int i4 = 92 / 0;
            return unit;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.globalnetwork.currency.GlobalNetworkContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        CompositeDisposable compositeDisposable = this.MyBillsEntityDataFactory;
        Observable<Boolean> execute = this.initRecordTimeStamp.get().execute(null);
        final GlobalNetworkContract.View view = this.NetworkUserEntityData$$ExternalSyntheticLambda7.get();
        Objects.requireNonNull(view);
        compositeDisposable.getAuthRequestContext(execute.subscribe(new Consumer() { // from class: id.dana.globalnetwork.currency.GlobalNetworkPresenter$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GlobalNetworkContract.View.this.MyBillsEntityDataFactory(((Boolean) obj).booleanValue());
            }
        }));
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 43;
            newProxyInstance = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.globalnetwork.currency.GlobalNetworkContract.Presenter
    public final void getAuthRequestContext() {
        int i = newProxyInstance + 51;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        if (i % 2 == 0) {
            this.MyBillsEntityDataFactory.getAuthRequestContext(this.isLayoutRequested.get().execute(Boolean.FALSE).subscribe());
            int i2 = 19 / 0;
            return;
        }
        this.MyBillsEntityDataFactory.getAuthRequestContext(this.isLayoutRequested.get().execute(Boolean.FALSE).subscribe());
    }

    @Override // id.dana.globalnetwork.currency.GlobalNetworkContract.Presenter
    public final void PlaceComponentResult(String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 47;
        newProxyInstance = i % 128;
        int i2 = i % 2;
        try {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            try {
                if ((!this.DatabaseTableConfigUtil ? 'b' : (char) 17) != 17) {
                    int i3 = newProxyInstance + 81;
                    NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
                    int i4 = i3 % 2;
                    this.DatabaseTableConfigUtil = true;
                    PlaceComponentResult(true);
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.globalnetwork.currency.GlobalNetworkContract.Presenter
    public final void getErrorConfigVersion() {
        try {
            try {
                this.scheduleImpl.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.globalnetwork.currency.GlobalNetworkPresenter$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlobalNetworkPresenter.this.PlaceComponentResult((Pay) obj);
                    }
                }, new Function1() { // from class: id.dana.globalnetwork.currency.GlobalNetworkPresenter$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlobalNetworkPresenter.this.MyBillsEntityDataFactory((Throwable) obj);
                    }
                });
                int i = newProxyInstance + 111;
                NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0056, code lost:
    
        if ((r1 == 2) != true) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0059, code lost:
    
        if (r1 != 2) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005b, code lost:
    
        r0 = id.dana.globalnetwork.currency.GlobalNetworkPresenter.NetworkUserEntityData$$ExternalSyntheticLambda3 + 39;
        id.dana.globalnetwork.currency.GlobalNetworkPresenter.newProxyInstance = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0064, code lost:
    
        if ((r0 % 2) == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0066, code lost:
    
        new java.lang.Object[1][1] = r7.getPaymentType();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006f, code lost:
    
        r7.getPaymentType();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0075, code lost:
    
        r6.NetworkUserEntityData$$ExternalSyntheticLambda7.get().BuiltInFictitiousFunctionClassFactory(java.lang.String.format(id.dana.data.constant.DanaUrl.CHECKOUT, r7.getPaymentString()), r7.isFromMiniProgram(), false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0091, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0092, code lost:
    
        throw r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0093, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0094, code lost:
    
        throw r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ kotlin.Unit PlaceComponentResult(id.dana.domain.globalnetwork.model.Pay r7) {
        /*
            r6 = this;
            r0 = 0
            r6.DatabaseTableConfigUtil = r0
            id.dana.analytics.firebase.Crashlytics r1 = id.dana.analytics.firebase.Crashlytics.BuiltInFictitiousFunctionClassFactory()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "watchForPayRequest() -> onNext() -> "
            r2.append(r3)
            java.lang.String r3 = r7.toString()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            com.google.firebase.crashlytics.FirebaseCrashlytics r1 = r1.getAuthRequestContext
            r1.log(r2)
            dagger.Lazy<id.dana.globalnetwork.currency.GlobalNetworkContract$View> r1 = r6.NetworkUserEntityData$$ExternalSyntheticLambda7
            java.lang.Object r1 = r1.get()
            id.dana.globalnetwork.currency.GlobalNetworkContract$View r1 = (id.dana.globalnetwork.currency.GlobalNetworkContract.View) r1
            r1.BuiltInFictitiousFunctionClassFactory()
            int[] r1 = id.dana.globalnetwork.currency.GlobalNetworkPresenter.AnonymousClass4.PlaceComponentResult
            com.alipay.iap.android.wallet.acl.payment.PaymentType r2 = r7.getPaymentType()
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 2
            r3 = 1
            if (r1 == r3) goto L95
            int r4 = id.dana.globalnetwork.currency.GlobalNetworkPresenter.newProxyInstance
            int r4 = r4 + 97
            int r5 = r4 % 128
            id.dana.globalnetwork.currency.GlobalNetworkPresenter.NetworkUserEntityData$$ExternalSyntheticLambda3 = r5
            int r4 = r4 % r2
            if (r4 != 0) goto L4e
            r4 = 1
            goto L4f
        L4e:
            r4 = 0
        L4f:
            if (r4 == 0) goto L59
            if (r1 == r2) goto L55
            r1 = 0
            goto L56
        L55:
            r1 = 1
        L56:
            if (r1 == r3) goto L73
            goto L5b
        L59:
            if (r1 == r2) goto L73
        L5b:
            int r0 = id.dana.globalnetwork.currency.GlobalNetworkPresenter.NetworkUserEntityData$$ExternalSyntheticLambda3
            int r0 = r0 + 39
            int r1 = r0 % 128
            id.dana.globalnetwork.currency.GlobalNetworkPresenter.newProxyInstance = r1
            int r0 = r0 % r2
            if (r0 == 0) goto L6f
            java.lang.Object[] r0 = new java.lang.Object[r3]
            com.alipay.iap.android.wallet.acl.payment.PaymentType r7 = r7.getPaymentType()
            r0[r3] = r7
            goto Lb1
        L6f:
            r7.getPaymentType()
            goto Lb1
        L73:
            dagger.Lazy<id.dana.globalnetwork.currency.GlobalNetworkContract$View> r1 = r6.NetworkUserEntityData$$ExternalSyntheticLambda7     // Catch: java.lang.Exception -> L93
            java.lang.Object r1 = r1.get()     // Catch: java.lang.Exception -> L91
            id.dana.globalnetwork.currency.GlobalNetworkContract$View r1 = (id.dana.globalnetwork.currency.GlobalNetworkContract.View) r1     // Catch: java.lang.Exception -> L91
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> L91
            java.lang.String r3 = r7.getPaymentString()     // Catch: java.lang.Exception -> L91
            r2[r0] = r3     // Catch: java.lang.Exception -> L91
            java.lang.String r3 = "https://m.dana.id/m/portal/cashier/confirmation?reloadRequest=true&cashierOrderId=%s"
            java.lang.String r2 = java.lang.String.format(r3, r2)     // Catch: java.lang.Exception -> L91
            boolean r7 = r7.isFromMiniProgram()     // Catch: java.lang.Exception -> L91
            r1.BuiltInFictitiousFunctionClassFactory(r2, r7, r0)     // Catch: java.lang.Exception -> L91
            goto Lb1
        L91:
            r7 = move-exception
            throw r7
        L93:
            r7 = move-exception
            throw r7
        L95:
            dagger.Lazy<id.dana.globalnetwork.currency.GlobalNetworkContract$View> r0 = r6.NetworkUserEntityData$$ExternalSyntheticLambda7
            java.lang.Object r0 = r0.get()
            id.dana.globalnetwork.currency.GlobalNetworkContract$View r0 = (id.dana.globalnetwork.currency.GlobalNetworkContract.View) r0
            java.lang.String r1 = r7.getPaymentString()
            boolean r7 = r7.isFromMiniProgram()
            r0.BuiltInFictitiousFunctionClassFactory(r1, r7, r3)
            int r7 = id.dana.globalnetwork.currency.GlobalNetworkPresenter.NetworkUserEntityData$$ExternalSyntheticLambda3
            int r7 = r7 + 97
            int r0 = r7 % 128
            id.dana.globalnetwork.currency.GlobalNetworkPresenter.newProxyInstance = r0
            int r7 = r7 % r2
        Lb1:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.globalnetwork.currency.GlobalNetworkPresenter.PlaceComponentResult(id.dana.domain.globalnetwork.model.Pay):kotlin.Unit");
    }

    /* renamed from: id.dana.globalnetwork.currency.GlobalNetworkPresenter$4  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[PaymentType.values().length];
            PlaceComponentResult = iArr;
            try {
                iArr[PaymentType.CASHIER_URL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                PlaceComponentResult[PaymentType.ORDER_ID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Unit MyBillsEntityDataFactory(Throwable th) {
        this.DatabaseTableConfigUtil = false;
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GLOBAL_NETWORK, th.getMessage());
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().BuiltInFictitiousFunctionClassFactory();
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().MyBillsEntityDataFactory();
        Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
        StringBuilder sb = new StringBuilder();
        sb.append("watchForPayRequest() -> onError() -> ");
        sb.append(th.getMessage());
        String obj = sb.toString();
        Intrinsics.checkNotNullParameter(obj, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log(obj);
        Intrinsics.checkNotNullParameter(th, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.recordException(th);
        Unit unit = Unit.INSTANCE;
        int i = newProxyInstance + 45;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        return unit;
    }

    @Override // id.dana.globalnetwork.currency.GlobalNetworkContract.Presenter
    public final void MyBillsEntityDataFactory() {
        try {
            int i = newProxyInstance + 93;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
            int i2 = i % 2;
            this.MyBillsEntityDataFactory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda2.get().execute(NoParams.INSTANCE).subscribe());
            int i3 = newProxyInstance + 111;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.globalnetwork.currency.GlobalNetworkContract.Presenter
    public final void getAuthRequestContext(boolean z, String str) {
        int i = newProxyInstance + 103;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        if (i % 2 == 0) {
            Object[] objArr = null;
            int length = objArr.length;
            if (!z) {
                return;
            }
        } else if (!z) {
            return;
        }
        PaymentResult paymentResult = new PaymentResult();
        try {
            paymentResult.setResultCode(str);
            EventBus.getDefault().post(new PaymentServiceProvider.MiniProgramPaymentCompletedMessageEvent(paymentResult));
            int i2 = newProxyInstance + 95;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.globalnetwork.currency.GlobalNetworkContract.Presenter
    public final void PlaceComponentResult(final String str, final String str2, String str3, final String str4, String str5, final String str6) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().lookAheadTest();
        this.BuiltInFictitiousFunctionClassFactory.get().execute(GetAuthCode.Params.forGetAuthCodeMpAgreements("https://m.dana.id/m/portal", str3, str4, true, str5), new Function1() { // from class: id.dana.globalnetwork.currency.GlobalNetworkPresenter$$ExternalSyntheticLambda12
            public final /* synthetic */ boolean MyBillsEntityDataFactory = true;

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GlobalNetworkPresenter.this.getAuthRequestContext(this.MyBillsEntityDataFactory, (AuthCodeResult) obj);
            }
        }, new Function1() { // from class: id.dana.globalnetwork.currency.GlobalNetworkPresenter$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GlobalNetworkPresenter.this.getAuthRequestContext(str6, str, str2, str4, (Throwable) obj);
            }
        });
        int i = newProxyInstance + 101;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        if (i % 2 == 0) {
            int i2 = 95 / 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Unit getAuthRequestContext(boolean z, AuthCodeResult authCodeResult) {
        try {
            int i = newProxyInstance + 61;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
                if (!(i % 2 == 0)) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().BuiltInFictitiousFunctionClassFactory();
                    this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().PlaceComponentResult(authCodeResult, z);
                    return null;
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().BuiltInFictitiousFunctionClassFactory();
                this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().PlaceComponentResult(authCodeResult, z);
                int i2 = 53 / 0;
                return null;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Unit getAuthRequestContext(String str, String str2, String str3, String str4, Throwable th) {
        int i = newProxyInstance + 31;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        try {
            try {
                Object[] objArr = new Object[1];
                a(TextUtils.indexOf((CharSequence) "", '0', 0) + 1, 11 - (ViewConfiguration.getTapTimeout() >> 16), (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 21601), objArr);
                DanaLog.BuiltInFictitiousFunctionClassFactory(((String) objArr[0]).intern(), th.getMessage());
                this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().BuiltInFictitiousFunctionClassFactory();
                if (!(th instanceof GetAuthCode.MissingRequiredUserInfoException)) {
                    return null;
                }
                int i3 = newProxyInstance + 95;
                NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
                int i4 = i3 % 2;
                ExtensionsKt.BuiltInFictitiousFunctionClassFactory((GetAuthCode.MissingRequiredUserInfoException) th, str, str2, str3, str4, "", "", false);
                return null;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.globalnetwork.currency.GlobalNetworkContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        try {
            try {
                this.moveToNextValue.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.globalnetwork.currency.GlobalNetworkPresenter$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlobalNetworkPresenter.this.getAuthRequestContext((Auth) obj);
                    }
                }, new Function1() { // from class: id.dana.globalnetwork.currency.GlobalNetworkPresenter$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlobalNetworkPresenter.getAuthRequestContext((Throwable) obj);
                    }
                });
                int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 59;
                newProxyInstance = i % 128;
                if ((i % 2 != 0 ? 'M' : '6') != '6') {
                    int i2 = 89 / 0;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Unit getAuthRequestContext(Auth auth) {
        int i = newProxyInstance + 81;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        if (!(i % 2 == 0)) {
            MyBillsEntityDataFactory(auth);
        } else {
            MyBillsEntityDataFactory(auth);
            int i2 = 9 / 0;
        }
        try {
            int i3 = newProxyInstance + 23;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
            int i4 = i3 % 2;
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit getAuthRequestContext(Throwable th) {
        int i = newProxyInstance + 61;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        Object[] objArr = null;
        try {
            if ((i % 2 == 0 ? (char) 23 : '%') != '%') {
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GLOBAL_NETWORK, th.getMessage());
                int length = objArr.length;
            } else {
                try {
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GLOBAL_NETWORK, th.getMessage());
                } catch (Exception e) {
                    throw e;
                }
            }
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 3;
            newProxyInstance = i2 % 128;
            int i3 = i2 % 2;
            return null;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void PlaceComponentResult(final boolean z) {
        try {
            try {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().execute(new DefaultObserver<UserInfoResponse>() { // from class: id.dana.globalnetwork.currency.GlobalNetworkPresenter.1
                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                    public /* synthetic */ void onNext(Object obj) {
                        UserInfoResponse userInfoResponse = (UserInfoResponse) obj;
                        GnLoadTimeTracker.KClassImpl$Data$declaredNonStaticMembers$2();
                        if (z) {
                            GlobalNetworkPresenter globalNetworkPresenter = GlobalNetworkPresenter.this;
                            GlobalNetworkPresenter.BuiltInFictitiousFunctionClassFactory(globalNetworkPresenter, GlobalNetworkPresenter.BuiltInFictitiousFunctionClassFactory(globalNetworkPresenter));
                        } else {
                            GlobalNetworkPresenter globalNetworkPresenter2 = GlobalNetworkPresenter.this;
                            GlobalNetworkPresenter.BuiltInFictitiousFunctionClassFactory(globalNetworkPresenter2, GlobalNetworkPresenter.BuiltInFictitiousFunctionClassFactory(globalNetworkPresenter2), GlobalNetworkPresenter.MyBillsEntityDataFactory(GlobalNetworkPresenter.this));
                        }
                        ((GetUserInfoWithKyc) GlobalNetworkPresenter.getAuthRequestContext(GlobalNetworkPresenter.this).get()).dispose();
                    }

                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                    public void onError(Throwable th) {
                        GlobalNetworkPresenter.PlaceComponentResult(GlobalNetworkPresenter.this);
                        GlobalNetworkPresenter.KClassImpl$Data$declaredNonStaticMembers$2(GlobalNetworkPresenter.this, th);
                    }
                }, GetUserInfoWithKyc.Params.forParams(true));
                int i = newProxyInstance + 91;
                NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void getAuthRequestContext(String str) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().lookAheadTest();
        this.PlaceComponentResult.get().execute(new DefaultObserver<String>() { // from class: id.dana.globalnetwork.currency.GlobalNetworkPresenter.2
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onComplete() {
                GlobalNetworkPresenter.PlaceComponentResult(GlobalNetworkPresenter.this);
                ((GlobalNetworkTracker) GlobalNetworkPresenter.KClassImpl$Data$declaredNonStaticMembers$2(GlobalNetworkPresenter.this).get()).BuiltInFictitiousFunctionClassFactory(GlobalNetworkMethod.DECODE, true);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                GlobalNetworkPresenter.PlaceComponentResult(GlobalNetworkPresenter.this);
                ((GlobalNetworkContract.View) GlobalNetworkPresenter.lookAheadTest(GlobalNetworkPresenter.this).get()).BuiltInFictitiousFunctionClassFactory();
                GlobalNetworkPresenter.KClassImpl$Data$declaredNonStaticMembers$2(GlobalNetworkPresenter.this, th);
            }
        }, DecodeGnQr.Params.forDecodeGnQr(this.KClassImpl$Data$declaredNonStaticMembers$2, "", true));
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 73;
            try {
                newProxyInstance = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void getAuthRequestContext(String str, String str2) {
        this.PlaceComponentResult.get().execute(new DefaultObserver<String>() { // from class: id.dana.globalnetwork.currency.GlobalNetworkPresenter.3
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                GlobalNetworkPresenter.KClassImpl$Data$declaredNonStaticMembers$2(GlobalNetworkPresenter.this, th);
            }
        }, DecodeGnQr.Params.forDecodeGnQr(str, str2, false));
        int i = newProxyInstance + 83;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
        this.GetContactSyncConfig.get().BuiltInFictitiousFunctionClassFactory(GlobalNetworkMethod.DECODE, false);
        String message = th.getMessage();
        if (th instanceof ServerException) {
            int i = newProxyInstance + 95;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
            int i2 = i % 2;
            message = th.getMessage();
            if (((ServerException) th).getCode() != 2000) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().BuiltInFictitiousFunctionClassFactory(th);
            } else {
                int i3 = newProxyInstance + 81;
                NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
                if (!(i3 % 2 == 0)) {
                    DeeplinkSaveDataManager.MyBillsEntityDataFactory().MyBillsEntityDataFactory = Boolean.TRUE;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().BuiltInFictitiousFunctionClassFactory(message);
                } else {
                    DeeplinkSaveDataManager.MyBillsEntityDataFactory().MyBillsEntityDataFactory = Boolean.TRUE;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().BuiltInFictitiousFunctionClassFactory(message);
                    Object[] objArr = null;
                    int length = objArr.length;
                }
            }
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().BuiltInFictitiousFunctionClassFactory(th);
        }
        try {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GLOBAL_NETWORK, message);
        } catch (Exception e) {
            throw e;
        }
    }

    private void MyBillsEntityDataFactory(final Auth auth) {
        this.BuiltInFictitiousFunctionClassFactory.get().execute(GetAuthCode.Params.forGetGnAuthCode("https://m.dana.id/m/portal", auth.getClientId(), auth.getScope(), true, "ALIPAY"), new Function1() { // from class: id.dana.globalnetwork.currency.GlobalNetworkPresenter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GlobalNetworkPresenter.KClassImpl$Data$declaredNonStaticMembers$2(Auth.this, (AuthCodeResult) obj);
            }
        }, new Function1() { // from class: id.dana.globalnetwork.currency.GlobalNetworkPresenter$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GlobalNetworkPresenter.BuiltInFictitiousFunctionClassFactory(Auth.this, (Throwable) obj);
            }
        });
        int i = newProxyInstance + 103;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit KClassImpl$Data$declaredNonStaticMembers$2(Auth auth, AuthCodeResult authCodeResult) {
        OAuthResult oAuthResult = new OAuthResult();
        try {
            oAuthResult.setAuthCode(authCodeResult.getAuthCode());
            Object obj = null;
            if ((auth.getAuthCallback() != null ? '4' : '(') != '(') {
                int i = newProxyInstance + 13;
                NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
                if ((i % 2 == 0 ? '!' : '1') != '!') {
                    auth.getAuthCallback().result(oAuthResult);
                } else {
                    auth.getAuthCallback().result(oAuthResult);
                    obj.hashCode();
                }
            }
            int i2 = newProxyInstance + 75;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i2 % 128;
            if (!(i2 % 2 != 0)) {
                obj.hashCode();
                return null;
            }
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001e, code lost:
    
        if (r0 != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:
    
        id.dana.miniprogram.ExtensionsKt.BuiltInFictitiousFunctionClassFactory((id.dana.domain.authcode.interactor.GetAuthCode.MissingRequiredUserInfoException) r12, "", r11.getDisplayName(), r11.getIconUrl(), r11.getScope(), "", "", false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003b, code lost:
    
        r0 = id.dana.globalnetwork.currency.GlobalNetworkPresenter.NetworkUserEntityData$$ExternalSyntheticLambda3 + 57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
    
        id.dana.globalnetwork.currency.GlobalNetworkPresenter.newProxyInstance = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
    
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0044, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
    
        throw r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0018, code lost:
    
        if ((r12 instanceof id.dana.domain.authcode.interactor.GetAuthCode.MissingRequiredUserInfoException) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ kotlin.Unit BuiltInFictitiousFunctionClassFactory(id.dana.domain.globalnetwork.model.Auth r11, java.lang.Throwable r12) {
        /*
            int r0 = id.dana.globalnetwork.currency.GlobalNetworkPresenter.newProxyInstance
            int r0 = r0 + 119
            int r1 = r0 % 128
            id.dana.globalnetwork.currency.GlobalNetworkPresenter.NetworkUserEntityData$$ExternalSyntheticLambda3 = r1
            int r0 = r0 % 2
            r1 = 76
            if (r0 != 0) goto L11
            r0 = 76
            goto L13
        L11:
            r0 = 50
        L13:
            r2 = 0
            if (r0 == r1) goto L1b
            boolean r0 = r12 instanceof id.dana.domain.authcode.interactor.GetAuthCode.MissingRequiredUserInfoException
            if (r0 == 0) goto L46
            goto L20
        L1b:
            boolean r0 = r12 instanceof id.dana.domain.authcode.interactor.GetAuthCode.MissingRequiredUserInfoException
            int r1 = r2.length     // Catch: java.lang.Throwable -> L5c
            if (r0 == 0) goto L46
        L20:
            r3 = r12
            id.dana.domain.authcode.interactor.GetAuthCode$MissingRequiredUserInfoException r3 = (id.dana.domain.authcode.interactor.GetAuthCode.MissingRequiredUserInfoException) r3
            java.lang.String r5 = r11.getDisplayName()
            java.lang.String r6 = r11.getIconUrl()
            java.lang.String r7 = r11.getScope()
            r10 = 0
            java.lang.String r4 = ""
            java.lang.String r8 = ""
            java.lang.String r9 = ""
            id.dana.miniprogram.ExtensionsKt.BuiltInFictitiousFunctionClassFactory(r3, r4, r5, r6, r7, r8, r9, r10)
            int r0 = id.dana.globalnetwork.currency.GlobalNetworkPresenter.NetworkUserEntityData$$ExternalSyntheticLambda3     // Catch: java.lang.Exception -> L44
            int r0 = r0 + 57
            int r1 = r0 % 128
            id.dana.globalnetwork.currency.GlobalNetworkPresenter.newProxyInstance = r1     // Catch: java.lang.Exception -> L44
            int r0 = r0 % 2
            goto L46
        L44:
            r11 = move-exception
            throw r11
        L46:
            java.lang.String r12 = r12.getMessage()
            java.lang.String r0 = "GlobalNetwork"
            id.dana.utils.foundation.logger.log.DanaLog.BuiltInFictitiousFunctionClassFactory(r0, r12)
            com.alipay.iap.android.wallet.acl.base.Callback r11 = r11.getAuthCallback()
            com.alipay.iap.android.wallet.acl.oauth.OAuthResult r12 = new com.alipay.iap.android.wallet.acl.oauth.OAuthResult
            r12.<init>()
            r11.result(r12)
            return r2
        L5c:
            r11 = move-exception
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.globalnetwork.currency.GlobalNetworkPresenter.BuiltInFictitiousFunctionClassFactory(id.dana.domain.globalnetwork.model.Auth, java.lang.Throwable):kotlin.Unit");
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 43;
        newProxyInstance = i % 128;
        int i2 = i % 2;
        this.MyBillsEntityDataFactory.dispose();
        this.moveToNextValue.get().dispose();
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
        this.PlaceComponentResult.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().dispose();
        try {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 35;
            try {
                newProxyInstance = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            if (whenavailable.BuiltInFictitiousFunctionClassFactory >= i2) {
                break;
            }
            try {
                int i3 = $10 + 85;
                $11 = i3 % 128;
                int i4 = i3 % 2;
                jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (PrepareContext[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ NetworkUserEntityData$$ExternalSyntheticLambda8))) ^ c;
                whenavailable.BuiltInFictitiousFunctionClassFactory++;
            } catch (Exception e) {
                throw e;
            }
            throw e;
        }
        char[] cArr = new char[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            if ((whenavailable.BuiltInFictitiousFunctionClassFactory < i2 ? '*' : 'N') != '*') {
                objArr[0] = new String(cArr);
                return;
            }
            cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
            int i5 = $10 + 73;
            $11 = i5 % 128;
            int i6 = i5 % 2;
        }
    }
}
