package id.dana.data.holdlogin.v2.interceptor;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.data.security.CookieRewriteThrowable;
import id.dana.utils.android.OSUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.holdlogin.v2.HoldLoginConfig;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Singleton
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001fB\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J)\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00180\u0017H\u0000¢\u0006\u0002\b\u0019J\u0012\u0010\u001a\u001a\u00020\u00182\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\b\u0010\u001b\u001a\u00020\u0018H\u0003J\u0012\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\u001d*\u00020\u001eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lid/dana/data/holdlogin/v2/interceptor/SetCookieInterceptor;", "", HummerConstants.CONTEXT, "Landroid/content/Context;", "holdLoginConfig", "Lid/dana/utils/holdlogin/v2/HoldLoginConfig;", "(Landroid/content/Context;Lid/dana/utils/holdlogin/v2/HoldLoginConfig;)V", "enableRewriteSession", "", "getEnableRewriteSession", "()Z", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "state", "Lid/dana/data/holdlogin/v2/interceptor/SetCookieInterceptor$State;", "getState$data_productionRelease", "()Lid/dana/data/holdlogin/v2/interceptor/SetCookieInterceptor$State;", "setState$data_productionRelease", "(Lid/dana/data/holdlogin/v2/interceptor/SetCookieInterceptor$State;)V", "create2ndCookieSession", "", "cookie", "log", "Lkotlin/Function1;", "", "create2ndCookieSession$data_productionRelease", "setCookie", "setCookieSession", "getSessionIds", "", "Landroid/webkit/CookieManager;", TrackerKey.Property.STATE, "data_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SetCookieInterceptor {
    private final HoldLoginConfig BuiltInFictitiousFunctionClassFactory;
    public State MyBillsEntityDataFactory;
    private final Context PlaceComponentResult;
    private ReentrantLock getAuthRequestContext;

    @Inject
    public SetCookieInterceptor(Context context, HoldLoginConfig holdLoginConfig) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(holdLoginConfig, "");
        this.PlaceComponentResult = context;
        this.BuiltInFictitiousFunctionClassFactory = holdLoginConfig;
        this.getAuthRequestContext = new ReentrantLock();
    }

    @JvmName(name = "getEnableRewriteSession")
    private final boolean MyBillsEntityDataFactory() {
        return this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2().getKClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static /* synthetic */ void getAuthRequestContext(SetCookieInterceptor setCookieInterceptor) {
        State state = setCookieInterceptor.MyBillsEntityDataFactory;
        setCookieInterceptor.MyBillsEntityDataFactory(state != null ? state.MyBillsEntityDataFactory : null);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void MyBillsEntityDataFactory(java.lang.String r14) {
        /*
            r13 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "setCookie "
            r0.append(r1)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "HOLD_LOGIN_V2"
            id.dana.utils.foundation.logger.log.DanaLog.MyBillsEntityDataFactory(r1, r0)
            java.util.concurrent.locks.ReentrantLock r0 = r13.getAuthRequestContext
            r0.lock()
            r0 = r14
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1 = 0
            if (r0 == 0) goto L29
            int r2 = r0.length()
            if (r2 == 0) goto L29
            r2 = 0
            goto L2a
        L29:
            r2 = 1
        L2a:
            if (r2 != 0) goto L93
            java.lang.String r2 = "ALIPAYJSESSIONID"
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 2
            r4 = 0
            boolean r0 = kotlin.text.StringsKt.contains$default(r0, r2, r1, r3, r4)
            if (r0 == 0) goto L93
            boolean r0 = r13.MyBillsEntityDataFactory()
            if (r0 == 0) goto L93
            id.dana.data.holdlogin.v2.interceptor.SetCookieInterceptor$State r0 = r13.MyBillsEntityDataFactory
            if (r0 == 0) goto L54
            if (r0 == 0) goto L47
            java.lang.String r0 = r0.MyBillsEntityDataFactory
            goto L48
        L47:
            r0 = r4
        L48:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r14)
            if (r0 == 0) goto L54
            id.dana.data.holdlogin.v2.interceptor.SetCookieInterceptor$State r14 = r13.MyBillsEntityDataFactory
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14)
            goto L6b
        L54:
            long r0 = java.lang.System.currentTimeMillis()
            long r2 = id.dana.data.holdlogin.v2.ConstantsKt.getAuthRequestContext()
            id.dana.data.holdlogin.v2.interceptor.SetCookieInterceptor$State r12 = new id.dana.data.holdlogin.v2.interceptor.SetCookieInterceptor$State
            long r7 = r0 + r2
            r9 = 0
            r10 = 4
            r11 = 0
            r5 = r12
            r6 = r14
            r5.<init>(r6, r7, r9, r10, r11)
            r13.MyBillsEntityDataFactory = r12
            r14 = r12
        L6b:
            long r0 = r14.PlaceComponentResult
            long r2 = java.lang.System.currentTimeMillis()
            int r14 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r14 >= 0) goto L7d
            r13.MyBillsEntityDataFactory = r4
            java.util.concurrent.locks.ReentrantLock r14 = r13.getAuthRequestContext
            r14.unlock()
            return
        L7d:
            kotlinx.coroutines.MainCoroutineDispatcher r14 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r14 = (kotlin.coroutines.CoroutineContext) r14
            id.dana.data.holdlogin.v2.interceptor.SetCookieInterceptor$setCookie$1 r0 = new id.dana.data.holdlogin.v2.interceptor.SetCookieInterceptor$setCookie$1
            r0.<init>(r13, r4)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            kotlinx.coroutines.BuildersKt.runBlocking(r14, r0)
            java.util.concurrent.locks.ReentrantLock r14 = r13.getAuthRequestContext
            r14.unlock()
            return
        L93:
            java.util.concurrent.locks.ReentrantLock r14 = r13.getAuthRequestContext
            r14.unlock()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.holdlogin.v2.interceptor.SetCookieInterceptor.MyBillsEntityDataFactory(java.lang.String):void");
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\f\u001a\u0004\u0018\u00010\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0011\u0010\u0011\u001a\u00020\u0010X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/data/holdlogin/v2/interceptor/SetCookieInterceptor$State;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "Ljava/lang/String;", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "", "PlaceComponentResult", "J", "p1", "p2", "<init>", "(Ljava/lang/String;JLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class State {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        String getAuthRequestContext;
        final long PlaceComponentResult;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final String MyBillsEntityDataFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof State) {
                State state = (State) p0;
                return Intrinsics.areEqual(this.MyBillsEntityDataFactory, state.MyBillsEntityDataFactory) && this.PlaceComponentResult == state.PlaceComponentResult && Intrinsics.areEqual(this.getAuthRequestContext, state.getAuthRequestContext);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = this.MyBillsEntityDataFactory.hashCode();
            int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.PlaceComponentResult);
            String str = this.getAuthRequestContext;
            return (((hashCode * 31) + m) * 31) + (str == null ? 0 : str.hashCode());
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("State(MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(')');
            return sb.toString();
        }

        private State(String str, long j, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            this.MyBillsEntityDataFactory = str;
            this.PlaceComponentResult = j;
            this.getAuthRequestContext = str2;
        }

        public /* synthetic */ State(String str, long j, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, j, (i & 4) != 0 ? null : str2);
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SetCookieInterceptor setCookieInterceptor) {
        List list;
        String str;
        String str2 = "HOLD_LOGIN_V2";
        DanaLog.MyBillsEntityDataFactory("HOLD_LOGIN_V2", "setCookieSession");
        Crashlytics.Companion companion = Crashlytics.INSTANCE;
        final Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
        CookieSyncManager createInstance = CookieSyncManager.createInstance(setCookieInterceptor.PlaceComponentResult);
        CookieManager cookieManager = CookieManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(cookieManager, "");
        String cookie = cookieManager.getCookie("https://mgs-gw.m.dana.id/mgw.htm");
        String str3 = cookie;
        if (str3 == null || str3.length() == 0) {
            list = CollectionsKt.emptyList();
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator it = StringsKt.split$default((CharSequence) cookie.toString(), new String[]{";"}, false, 0, 6, (Object) null).iterator();
            while (it.hasNext()) {
                List split$default = StringsKt.split$default((CharSequence) ((String) it.next()), new String[]{"="}, false, 0, 6, (Object) null);
                if (split$default.size() == 2 && StringsKt.equals(StringsKt.trim((CharSequence) ((String) split$default.get(0))).toString(), "ALIPAYJSESSIONID", true)) {
                    arrayList.add(StringsKt.trim((CharSequence) ((String) split$default.get(1))).toString());
                }
            }
            list = arrayList;
        }
        String cookie2 = cookieManager.getCookie("https://mgs-gw.m.dana.id/mgw.htm");
        StringBuilder sb = new StringBuilder();
        sb.append("before : ");
        sb.append(cookie2);
        DanaLog.MyBillsEntityDataFactory("HOLD_LOGIN_V2", sb.toString());
        State state = setCookieInterceptor.MyBillsEntityDataFactory;
        if (state != null) {
            cookieManager.setCookie("https://mgs-gw.m.dana.id/mgw.htm", state.MyBillsEntityDataFactory);
            Intrinsics.checkNotNullParameter("setCookie 1st cookie session", "");
            authRequestContext.getAuthRequestContext.log("setCookie 1st cookie session");
            if (list.size() > 1) {
                if (state.getAuthRequestContext == null) {
                    String str4 = state.MyBillsEntityDataFactory;
                    Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: id.dana.data.holdlogin.v2.interceptor.SetCookieInterceptor$setCookieSession$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(String str5) {
                            invoke2(str5);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(String str5) {
                            Intrinsics.checkNotNullParameter(str5, "");
                            Crashlytics crashlytics = Crashlytics.this;
                            Intrinsics.checkNotNullParameter(str5, "");
                            crashlytics.getAuthRequestContext.log(str5);
                        }
                    };
                    Intrinsics.checkNotNullParameter(str4, "");
                    Intrinsics.checkNotNullParameter(function1, "");
                    DanaLog.MyBillsEntityDataFactory("HOLD_LOGIN_V2", "create2ndCookieSession");
                    StringBuilder sb2 = new StringBuilder();
                    String str5 = str4;
                    List split$default2 = StringsKt.split$default((CharSequence) str5, new String[]{";"}, false, 0, 6, (Object) null);
                    String str6 = "Domain";
                    if (StringsKt.contains$default((CharSequence) str5, (CharSequence) "Domain", false, 2, (Object) null)) {
                        function1.invoke("create 2nd cookie session remove domain");
                        Iterator it2 = split$default2.iterator();
                        int i = 0;
                        while (it2.hasNext()) {
                            Object next = it2.next();
                            if (i < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            Iterator it3 = it2;
                            String str7 = (String) next;
                            String str8 = str2;
                            String str9 = str6;
                            if (!StringsKt.contains$default((CharSequence) str7, (CharSequence) str6, false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) str7, (CharSequence) "Secure", false, 2, (Object) null)) {
                                if (i == split$default2.size() - 1) {
                                    sb2.append(StringsKt.trim((CharSequence) str7).toString());
                                } else {
                                    sb2.append(StringsKt.trim((CharSequence) str7).toString());
                                    sb2.append("; ");
                                }
                            }
                            i++;
                            it2 = it3;
                            str2 = str8;
                            str6 = str9;
                        }
                        str = str2;
                    } else {
                        str = "HOLD_LOGIN_V2";
                        int i2 = 0;
                        String host = new URI("https://mgs-gw.m.dana.id/mgw.htm").getHost();
                        Intrinsics.checkNotNullExpressionValue(host, "");
                        String replace$default = StringsKt.replace$default(host, "mgs-gw.", "", false, 4, (Object) null);
                        function1.invoke("create 2nd cookie session add domain");
                        for (Object obj : split$default2) {
                            if (i2 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            String str10 = (String) obj;
                            if (i2 == split$default2.size() - 1) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("Domain=");
                                sb3.append(replace$default);
                                sb2.append(sb3.toString());
                                sb2.append("; ");
                                sb2.append("Secure");
                                sb2.append("; ");
                                sb2.append(StringsKt.trim((CharSequence) str10).toString());
                            } else {
                                sb2.append(StringsKt.trim((CharSequence) str10).toString());
                                sb2.append("; ");
                            }
                            i2++;
                        }
                    }
                    String obj2 = sb2.toString();
                    Intrinsics.checkNotNullExpressionValue(obj2, "");
                    state.getAuthRequestContext = obj2;
                } else {
                    str = "HOLD_LOGIN_V2";
                }
                cookieManager.setCookie("https://mgs-gw.m.dana.id/mgw.htm", state.getAuthRequestContext);
                Intrinsics.checkNotNullParameter("setCookie 2nd cookie session", "");
                authRequestContext.getAuthRequestContext.log("setCookie 2nd cookie session");
            } else {
                str = "HOLD_LOGIN_V2";
            }
            OSUtil oSUtil = OSUtil.INSTANCE;
            if (OSUtil.BuiltInFictitiousFunctionClassFactory() >= 21) {
                cookieManager.flush();
            } else {
                createInstance.sync();
            }
            CookieRewriteThrowable cookieRewriteThrowable = new CookieRewriteThrowable();
            Intrinsics.checkNotNullParameter(cookieRewriteThrowable, "");
            authRequestContext.getAuthRequestContext.recordException(cookieRewriteThrowable);
        } else {
            str = "HOLD_LOGIN_V2";
        }
        String cookie3 = cookieManager.getCookie("https://mgs-gw.m.dana.id/mgw.htm");
        StringBuilder sb4 = new StringBuilder();
        sb4.append("after : ");
        sb4.append(cookie3);
        DanaLog.MyBillsEntityDataFactory(str, sb4.toString());
    }
}
