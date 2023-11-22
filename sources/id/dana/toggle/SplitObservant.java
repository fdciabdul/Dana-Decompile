package id.dana.toggle;

import android.content.Context;
import android.provider.Settings;
import com.alipay.iap.android.lbs.LBSLocation;
import id.dana.data.account.repository.source.SecuredAccountPreferences;
import id.dana.data.login.LoginLogoutSubject;
import id.dana.data.toggle.SplitFacade;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.GetLatestTransaction;
import id.dana.domain.account.model.Transaction;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.geocode.interactor.GetIndoSubdivisionsByLocation;
import id.dana.domain.geocode.model.IndoSubdivisions;
import id.dana.domain.tracker.HereMixPanelTrackerData;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.model.KycInfo;
import id.dana.myprofile.UserInfoMapper;
import id.dana.toggle.locationpermission.ILocationPermissionObserver;
import id.dana.toggle.locationpermission.LocationPermissionObserver;
import id.dana.toggle.userloginlogout.ILoginLogoutObserver;
import id.dana.toggle.userloginlogout.LoginLogoutObserver;
import id.dana.utils.OSUtil;
import id.dana.utils.foundation.facede.LbsFacade;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001BI\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u0005\u0012\u0006\u0010\u001e\u001a\u00020\u0011\u0012\u0006\u0010\u001f\u001a\u00020\u0013\u0012\u0006\u0010 \u001a\u00020\u0017\u0012\u0006\u0010!\u001a\u00020\b\u0012\u0006\u0010\"\u001a\u00020\f\u0012\u0006\u0010#\u001a\u00020\u000f\u0012\u0006\u0010$\u001a\u00020\u001b¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\t\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u0014\u0010\r\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0018\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001c"}, d2 = {"Lid/dana/toggle/SplitObservant;", "", "", "PlaceComponentResult", "()Z", "Landroid/content/Context;", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/geocode/interactor/GetIndoSubdivisionsByLocation;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/geocode/interactor/GetIndoSubdivisionsByLocation;", "getAuthRequestContext", "Lid/dana/domain/account/interactor/GetLatestTransaction;", "MyBillsEntityDataFactory", "Lid/dana/domain/account/interactor/GetLatestTransaction;", "Lid/dana/domain/user/interactor/GetUserInfo;", "Lid/dana/domain/user/interactor/GetUserInfo;", "Lid/dana/toggle/locationpermission/LocationPermissionObserver;", "Lid/dana/toggle/locationpermission/LocationPermissionObserver;", "Lid/dana/toggle/userloginlogout/LoginLogoutObserver;", "getErrorConfigVersion", "Lid/dana/toggle/userloginlogout/LoginLogoutObserver;", "scheduleImpl", "Lid/dana/data/toggle/SplitFacade;", "moveToNextValue", "Lid/dana/data/toggle/SplitFacade;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/myprofile/UserInfoMapper;", "Lid/dana/myprofile/UserInfoMapper;", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "<init>", "(Landroid/content/Context;Lid/dana/toggle/locationpermission/LocationPermissionObserver;Lid/dana/toggle/userloginlogout/LoginLogoutObserver;Lid/dana/data/toggle/SplitFacade;Lid/dana/domain/geocode/interactor/GetIndoSubdivisionsByLocation;Lid/dana/domain/account/interactor/GetLatestTransaction;Lid/dana/domain/user/interactor/GetUserInfo;Lid/dana/myprofile/UserInfoMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SplitObservant {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final GetUserInfo PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final GetIndoSubdivisionsByLocation getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GetLatestTransaction KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final UserInfoMapper moveToNextValue;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Context BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final LocationPermissionObserver MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final LoginLogoutObserver scheduleImpl;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final SplitFacade NetworkUserEntityData$$ExternalSyntheticLambda0;

    @Inject
    public SplitObservant(Context context, LocationPermissionObserver locationPermissionObserver, LoginLogoutObserver loginLogoutObserver, SplitFacade splitFacade, GetIndoSubdivisionsByLocation getIndoSubdivisionsByLocation, GetLatestTransaction getLatestTransaction, GetUserInfo getUserInfo, UserInfoMapper userInfoMapper) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(locationPermissionObserver, "");
        Intrinsics.checkNotNullParameter(loginLogoutObserver, "");
        Intrinsics.checkNotNullParameter(splitFacade, "");
        Intrinsics.checkNotNullParameter(getIndoSubdivisionsByLocation, "");
        Intrinsics.checkNotNullParameter(getLatestTransaction, "");
        Intrinsics.checkNotNullParameter(getUserInfo, "");
        Intrinsics.checkNotNullParameter(userInfoMapper, "");
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.MyBillsEntityDataFactory = locationPermissionObserver;
        this.scheduleImpl = loginLogoutObserver;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = splitFacade;
        this.getAuthRequestContext = getIndoSubdivisionsByLocation;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getLatestTransaction;
        this.PlaceComponentResult = getUserInfo;
        this.moveToNextValue = userInfoMapper;
        ILocationPermissionObserver iLocationPermissionObserver = new ILocationPermissionObserver() { // from class: id.dana.toggle.SplitObservant$initLocationPermissionObserver$1
            @Override // id.dana.toggle.locationpermission.ILocationPermissionObserver
            public final void MyBillsEntityDataFactory(boolean p0) {
                SplitObservant.getAuthRequestContext(SplitObservant.this, p0);
            }
        };
        synchronized (locationPermissionObserver) {
            Intrinsics.checkNotNullParameter(iLocationPermissionObserver, "");
            if (!locationPermissionObserver.KClassImpl$Data$declaredNonStaticMembers$2.contains(iLocationPermissionObserver)) {
                locationPermissionObserver.KClassImpl$Data$declaredNonStaticMembers$2.addElement(iLocationPermissionObserver);
            }
        }
        this.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2(new ILoginLogoutObserver() { // from class: id.dana.toggle.SplitObservant$initLoginLogoutObserver$1
            @Override // id.dana.toggle.userloginlogout.ILoginLogoutObserver
            public final void PlaceComponentResult(LoginLogoutSubject.UserLogin p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.isLoggedIn()) {
                    SplitObservant.PlaceComponentResult(SplitObservant.this, p0.getUserId());
                }
            }
        });
    }

    private final boolean PlaceComponentResult() {
        return OSUtil.NetworkUserEntityData$$ExternalSyntheticLambda0() && Settings.Secure.getString(this.BuiltInFictitiousFunctionClassFactory.getContentResolver(), "mock_location") != "0";
    }

    public static final /* synthetic */ void PlaceComponentResult(SplitObservant splitObservant, IndoSubdivisions indoSubdivisions) {
        HashMap hashMap = new HashMap();
        hashMap.put("province", indoSubdivisions.getProviceName());
        hashMap.put("city", indoSubdivisions.getCityName());
        hashMap.put("country_code", indoSubdivisions.getCountryCode());
        hashMap.put("country_name", indoSubdivisions.getCountryName());
        hashMap.put("district", indoSubdivisions.getDistrictName());
        SplitFacade splitFacade = splitObservant.NetworkUserEntityData$$ExternalSyntheticLambda0;
        SplitFacade.PlaceComponentResult(hashMap);
    }

    public static final /* synthetic */ void getAuthRequestContext(SplitObservant splitObservant, Transaction transaction) {
        if (transaction.getDate().length() > 0) {
            if (transaction.getType().length() > 0) {
                Map mapOf = MapsKt.mapOf(TuplesKt.to("last_transaction_type", transaction.getType()), TuplesKt.to("last_transaction_date", transaction.getDate()));
                SplitFacade splitFacade = splitObservant.NetworkUserEntityData$$ExternalSyntheticLambda0;
                SplitFacade.PlaceComponentResult(mapOf);
            }
        }
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SplitObservant splitObservant, UserInfoResponse userInfoResponse) {
        KycInfo kycInfo = splitObservant.moveToNextValue.MyBillsEntityDataFactory(userInfoResponse).DatabaseTableConfigUtil;
        String str = kycInfo != null ? kycInfo.PlaceComponentResult : null;
        String str2 = str;
        String str3 = (str2 == null || str2.length() == 0) ^ true ? str : null;
        if (str3 != null) {
            SplitFacade splitFacade = splitObservant.NetworkUserEntityData$$ExternalSyntheticLambda0;
            SplitFacade.PlaceComponentResult("kyc_level", str3);
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(final SplitObservant splitObservant, boolean z) {
        LBSLocation authRequestContext;
        GetIndoSubdivisionsByLocation.Params forLocation;
        if (z && (authRequestContext = LbsFacade.getAuthRequestContext(splitObservant.BuiltInFictitiousFunctionClassFactory)) != null) {
            GetIndoSubdivisionsByLocation getIndoSubdivisionsByLocation = splitObservant.getAuthRequestContext;
            DefaultObserver<IndoSubdivisions> defaultObserver = new DefaultObserver<IndoSubdivisions>() { // from class: id.dana.toggle.SplitObservant$obtainLatestLocationAttribute$1$1
                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final /* synthetic */ void onNext(Object obj) {
                    IndoSubdivisions indoSubdivisions = (IndoSubdivisions) obj;
                    Intrinsics.checkNotNullParameter(indoSubdivisions, "");
                    SplitObservant.PlaceComponentResult(SplitObservant.this, indoSubdivisions);
                }

                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final void onError(Throwable p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    StringBuilder sb = new StringBuilder();
                    sb.append(getClass().getName());
                    sb.append(p0.getMessage());
                    DanaLog.BuiltInFictitiousFunctionClassFactory("Split", sb.toString(), p0);
                }
            };
            forLocation = GetIndoSubdivisionsByLocation.Params.INSTANCE.forLocation(authRequestContext, (r13 & 2) != 0 ? false : true, (r13 & 4) != 0 ? false : splitObservant.PlaceComponentResult(), new HereMixPanelTrackerData("Split", null, false, null, null, 30, null), (r13 & 16) != 0 ? false : false);
            getIndoSubdivisionsByLocation.executeInBackground(defaultObserver, forLocation);
        }
        SplitFacade splitFacade = splitObservant.NetworkUserEntityData$$ExternalSyntheticLambda0;
        SplitFacade.PlaceComponentResult("location_permission", Boolean.valueOf(z));
    }

    public static final /* synthetic */ void PlaceComponentResult(final SplitObservant splitObservant, String str) {
        SplitFacade splitFacade = splitObservant.NetworkUserEntityData$$ExternalSyntheticLambda0;
        SplitFacade.PlaceComponentResult(SecuredAccountPreferences.Key.USER_ID, str);
        splitObservant.PlaceComponentResult.execute(new GetUserInfo.Param(false), new Function1<UserInfoResponse, Unit>() { // from class: id.dana.toggle.SplitObservant$setUserAttribute$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(UserInfoResponse userInfoResponse) {
                invoke2(userInfoResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserInfoResponse userInfoResponse) {
                Intrinsics.checkNotNullParameter(userInfoResponse, "");
                SplitObservant.BuiltInFictitiousFunctionClassFactory(SplitObservant.this, userInfoResponse);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.toggle.SplitObservant$setUserAttribute$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                StringBuilder sb = new StringBuilder();
                sb.append(SplitObservant.this.getClass().getName());
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory("Split", sb.toString(), th);
            }
        });
        splitObservant.KClassImpl$Data$declaredNonStaticMembers$2.executeInBackground(NoParams.INSTANCE, new Function1<Transaction, Unit>() { // from class: id.dana.toggle.SplitObservant$obtainLastTransactionAttribute$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Transaction transaction) {
                invoke2(transaction);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Transaction transaction) {
                Intrinsics.checkNotNullParameter(transaction, "");
                SplitObservant.getAuthRequestContext(SplitObservant.this, transaction);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.toggle.SplitObservant$obtainLastTransactionAttribute$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                StringBuilder sb = new StringBuilder();
                sb.append(SplitObservant.this.getClass().getName());
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory("Split", sb.toString(), th);
            }
        });
    }
}
