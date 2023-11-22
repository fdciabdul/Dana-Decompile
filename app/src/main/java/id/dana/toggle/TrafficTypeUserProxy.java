package id.dana.toggle;

import android.text.TextUtils;
import id.dana.data.account.repository.source.preference.PreferenceAccountEntityData;
import id.dana.data.login.LoginLogoutSubject;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.data.toggle.traffictype.LazyTrafficTypeFactory;
import id.dana.data.toggle.traffictype.TrafficType;
import id.dana.domain.DefaultObserver;
import id.dana.toggle.userloginlogout.ILoginLogoutObserver;
import id.dana.toggle.userloginlogout.LoginLogoutObserver;
import io.reactivex.Observable;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0004\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0004\u0010\tR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/toggle/TrafficTypeUserProxy;", "Lid/dana/data/toggle/traffictype/LazyTrafficTypeFactory;", "Lio/reactivex/Observable;", "Lid/dana/data/toggle/traffictype/BaseTrafficType;", "getAuthRequestContext", "()Lio/reactivex/Observable;", "", "p0", "", "(Ljava/lang/String;)V", "Lio/reactivex/subjects/BehaviorSubject;", "BuiltInFictitiousFunctionClassFactory", "Lio/reactivex/subjects/BehaviorSubject;", "MyBillsEntityDataFactory", "Lid/dana/data/toggle/traffictype/BaseTrafficType;", "Lid/dana/toggle/userloginlogout/LoginLogoutObserver;", "Lid/dana/data/login/LoginLogoutSubject;", "p1", "Lid/dana/data/account/repository/source/preference/PreferenceAccountEntityData;", "p2", "p3", "<init>", "(Lid/dana/toggle/userloginlogout/LoginLogoutObserver;Lid/dana/data/login/LoginLogoutSubject;Lid/dana/data/account/repository/source/preference/PreferenceAccountEntityData;Lid/dana/data/toggle/traffictype/BaseTrafficType;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TrafficTypeUserProxy implements LazyTrafficTypeFactory {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final BehaviorSubject<BaseTrafficType> MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final BaseTrafficType getAuthRequestContext;

    @Inject
    public TrafficTypeUserProxy(LoginLogoutObserver loginLogoutObserver, final LoginLogoutSubject loginLogoutSubject, PreferenceAccountEntityData preferenceAccountEntityData, @TrafficType("Device") BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(loginLogoutObserver, "");
        Intrinsics.checkNotNullParameter(loginLogoutSubject, "");
        Intrinsics.checkNotNullParameter(preferenceAccountEntityData, "");
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        this.getAuthRequestContext = baseTrafficType;
        BehaviorSubject<BaseTrafficType> BuiltInFictitiousFunctionClassFactory = BehaviorSubject.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory;
        preferenceAccountEntityData.getUserId().subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(Schedulers.MyBillsEntityDataFactory()).subscribe(new DefaultObserver<String>() { // from class: id.dana.toggle.TrafficTypeUserProxy$obtainUserIdFromPreference$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                String str = (String) obj;
                Intrinsics.checkNotNullParameter(str, "");
                super.onNext(str);
                if (str.length() > 0) {
                    LoginLogoutSubject.this.setUserId(str);
                }
            }
        });
        loginLogoutObserver.KClassImpl$Data$declaredNonStaticMembers$2(new ILoginLogoutObserver() { // from class: id.dana.toggle.TrafficTypeUserProxy$addObserverLoginLogout$1
            @Override // id.dana.toggle.userloginlogout.ILoginLogoutObserver
            public final void PlaceComponentResult(LoginLogoutSubject.UserLogin p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.isLoggedIn()) {
                    TrafficTypeUserProxy.this.getAuthRequestContext(p0.getUserId());
                }
            }
        });
        Object obj = loginLogoutObserver.BuiltInFictitiousFunctionClassFactory.getSubject().getErrorConfigVersion.get();
        Object obj2 = null;
        Object value = (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? null : NotificationLite.getValue(obj);
        Intrinsics.checkNotNull(value);
        if (((LoginLogoutSubject.UserLogin) value).isLoggedIn()) {
            Object obj3 = loginLogoutObserver.BuiltInFictitiousFunctionClassFactory.getSubject().getErrorConfigVersion.get();
            Object value2 = (NotificationLite.isComplete(obj3) || NotificationLite.isError(obj3)) ? null : NotificationLite.getValue(obj3);
            Intrinsics.checkNotNull(value2);
            if (TextUtils.isEmpty(((LoginLogoutSubject.UserLogin) value2).getUserId())) {
                return;
            }
            Object obj4 = loginLogoutObserver.BuiltInFictitiousFunctionClassFactory.getSubject().getErrorConfigVersion.get();
            if (!NotificationLite.isComplete(obj4) && !NotificationLite.isError(obj4)) {
                obj2 = NotificationLite.getValue(obj4);
            }
            Intrinsics.checkNotNull(obj2);
            getAuthRequestContext(((LoginLogoutSubject.UserLogin) obj2).getUserId());
        }
    }

    public final void getAuthRequestContext(String p0) {
        if (!this.getAuthRequestContext.MyBillsEntityDataFactory()) {
            this.getAuthRequestContext.MyBillsEntityDataFactory("DANAID");
        }
        BehaviorSubject<BaseTrafficType> behaviorSubject = this.MyBillsEntityDataFactory;
        BaseTrafficType baseTrafficType = this.getAuthRequestContext;
        baseTrafficType.BuiltInFictitiousFunctionClassFactory(p0);
        behaviorSubject.onNext(baseTrafficType);
    }

    @Override // id.dana.data.toggle.traffictype.LazyTrafficTypeFactory
    public final Observable<BaseTrafficType> getAuthRequestContext() {
        BaseTrafficType baseTrafficType = this.getAuthRequestContext;
        baseTrafficType.getAuthRequestContext = baseTrafficType.BuiltInFictitiousFunctionClassFactory;
        return this.MyBillsEntityDataFactory;
    }
}
