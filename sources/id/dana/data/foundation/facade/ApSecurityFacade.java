package id.dana.data.foundation.facade;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.alipaysecuritysdk.apdid.face.APSecuritySdk;
import com.alipay.alipaysecuritysdk.apdid.face.Configuration;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.lib.bio.DANABio;
import id.dana.utils.config.DeviceInformation;
import id.dana.utils.foundation.facede.ApSecurity;
import id.dana.utils.foundation.facede.ApdIdTokenCacheEmptyError;
import id.dana.utils.foundation.facede.ApdIdTokenEmptyError;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleOnErrorReturn;
import io.reactivex.internal.operators.single.SingleSubscribeOn;
import io.reactivex.internal.operators.single.SingleTimeout;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

@Singleton
/* loaded from: classes2.dex */
public class ApSecurityFacade implements ApSecurity {
    public final Context BuiltInFictitiousFunctionClassFactory;
    public final DeviceInformation MyBillsEntityDataFactory;
    String KClassImpl$Data$declaredNonStaticMembers$2 = "";
    String getAuthRequestContext = "";

    @Inject
    public ApSecurityFacade(Context context, DeviceInformation deviceInformation) {
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.MyBillsEntityDataFactory = deviceInformation;
        getAuthRequestContext();
    }

    @Override // id.dana.utils.foundation.facede.ApSecurity
    public final void getAuthRequestContext() {
        APSecuritySdk.getInstance(this.BuiltInFictitiousFunctionClassFactory).setConfiguration(Configuration.getConfiguration(Configuration.Locale.Indonesia, 0));
        moveToNextValue();
        HashMap hashMap = new HashMap();
        hashMap.put("tid", this.MyBillsEntityDataFactory.generateDeviceId());
        APSecuritySdk.getInstance(this.BuiltInFictitiousFunctionClassFactory).initToken(hashMap, new APSecuritySdk.InitResultListener() { // from class: id.dana.data.foundation.facade.ApSecurityFacade$$ExternalSyntheticLambda2
            @Override // com.alipay.alipaysecuritysdk.apdid.face.APSecuritySdk.InitResultListener
            public final void onResult(APSecuritySdk.TokenResult tokenResult) {
                ApSecurityFacade apSecurityFacade = ApSecurityFacade.this;
                String str = tokenResult.apdidToken;
                if (!TextUtils.isEmpty(str) && !str.equals(apSecurityFacade.KClassImpl$Data$declaredNonStaticMembers$2)) {
                    apSecurityFacade.KClassImpl$Data$declaredNonStaticMembers$2 = str;
                }
                if (TextUtils.isEmpty(tokenResult.apdidToken)) {
                    return;
                }
                DANABio.KClassImpl$Data$declaredNonStaticMembers$2();
                DANABio.BuiltInFictitiousFunctionClassFactory(apSecurityFacade.BuiltInFictitiousFunctionClassFactory, tokenResult.apdidToken);
            }
        });
    }

    private void moveToNextValue() {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        if (this.getAuthRequestContext.isEmpty()) {
            Single PlaceComponentResult = Single.PlaceComponentResult(new Callable() { // from class: id.dana.data.foundation.facade.ApSecurityFacade$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return AdvertisingIdClient.getAdvertisingIdInfo(ApSecurityFacade.this.BuiltInFictitiousFunctionClassFactory).getId();
                }
            });
            TimeUnit timeUnit = TimeUnit.SECONDS;
            KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
            ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
            ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, "scheduler is null");
            Single BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleTimeout(PlaceComponentResult, 10L, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2));
            ObjectHelper.PlaceComponentResult("", "value is null");
            Single BuiltInFictitiousFunctionClassFactory2 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleOnErrorReturn(BuiltInFictitiousFunctionClassFactory, null, ""));
            Scheduler MyBillsEntityDataFactory = Schedulers.MyBillsEntityDataFactory();
            ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory, "scheduler is null");
            RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleSubscribeOn(BuiltInFictitiousFunctionClassFactory2, MyBillsEntityDataFactory)).MyBillsEntityDataFactory(new Consumer() { // from class: id.dana.data.foundation.facade.ApSecurityFacade$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    ApSecurityFacade apSecurityFacade = ApSecurityFacade.this;
                    String str = (String) obj;
                    if (str.isEmpty()) {
                        return;
                    }
                    apSecurityFacade.getAuthRequestContext = str;
                }
            }, Functions.DatabaseTableConfigUtil);
        }
    }

    @Override // id.dana.utils.foundation.facede.ApSecurity
    public final String BuiltInFictitiousFunctionClassFactory() {
        APSecuritySdk.TokenResult tokenResult = APSecuritySdk.getInstance(this.BuiltInFictitiousFunctionClassFactory).getTokenResult();
        String str = tokenResult.apdidToken;
        if (!TextUtils.isEmpty(str) && !str.equals(this.KClassImpl$Data$declaredNonStaticMembers$2)) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        }
        if (TextUtils.isEmpty(str)) {
            Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
            StringBuilder sb = new StringBuilder();
            sb.append("apdidToken: ");
            sb.append(tokenResult.apdidToken);
            String obj = sb.toString();
            Intrinsics.checkNotNullParameter(obj, "");
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log(obj);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("apdid: ");
            sb2.append(tokenResult.apdid);
            String obj2 = sb2.toString();
            Intrinsics.checkNotNullParameter(obj2, "");
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log(obj2);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("clientKey: ");
            sb3.append(tokenResult.clientKey);
            String obj3 = sb3.toString();
            Intrinsics.checkNotNullParameter(obj3, "");
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log(obj3);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("umidToken: ");
            sb4.append(tokenResult.umidToken);
            String obj4 = sb4.toString();
            Intrinsics.checkNotNullParameter(obj4, "");
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log(obj4);
            ApdIdTokenEmptyError apdIdTokenEmptyError = new ApdIdTokenEmptyError();
            Intrinsics.checkNotNullParameter(apdIdTokenEmptyError, "");
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.recordException(apdIdTokenEmptyError);
            if (TextUtils.isEmpty(this.KClassImpl$Data$declaredNonStaticMembers$2)) {
                Crashlytics BuiltInFictitiousFunctionClassFactory2 = Crashlytics.BuiltInFictitiousFunctionClassFactory();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("apdidToken: ");
                sb5.append(tokenResult.apdidToken);
                String obj5 = sb5.toString();
                Intrinsics.checkNotNullParameter(obj5, "");
                BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.log(obj5);
                StringBuilder sb6 = new StringBuilder();
                sb6.append("apdid: ");
                sb6.append(tokenResult.apdid);
                String obj6 = sb6.toString();
                Intrinsics.checkNotNullParameter(obj6, "");
                BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.log(obj6);
                StringBuilder sb7 = new StringBuilder();
                sb7.append("clientKey: ");
                sb7.append(tokenResult.clientKey);
                String obj7 = sb7.toString();
                Intrinsics.checkNotNullParameter(obj7, "");
                BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.log(obj7);
                StringBuilder sb8 = new StringBuilder();
                sb8.append("umidToken: ");
                sb8.append(tokenResult.umidToken);
                String obj8 = sb8.toString();
                Intrinsics.checkNotNullParameter(obj8, "");
                BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.log(obj8);
                ApdIdTokenCacheEmptyError apdIdTokenCacheEmptyError = new ApdIdTokenCacheEmptyError();
                Intrinsics.checkNotNullParameter(apdIdTokenCacheEmptyError, "");
                BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.recordException(apdIdTokenCacheEmptyError);
            }
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        return str;
    }

    @Override // id.dana.utils.foundation.facede.ApSecurity
    public final String MyBillsEntityDataFactory() {
        return APSecuritySdk.getInstance(this.BuiltInFictitiousFunctionClassFactory).getTokenResult().clientKey;
    }

    @Override // id.dana.utils.foundation.facede.ApSecurity
    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory.getDeviceUtdId();
    }

    @Override // id.dana.utils.foundation.facede.ApSecurity
    public final String PlaceComponentResult() {
        moveToNextValue();
        return this.getAuthRequestContext;
    }
}
