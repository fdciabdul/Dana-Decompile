package id.dana.danah5.easteregg;

import android.app.Activity;
import android.app.Application;
import android.graphics.Color;
import android.view.KeyEvent;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.griver.api.common.view.GriverTitleBarEvent;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.webview.GriverWebviewSetting;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.iap.ac.config.lite.ConfigCenter;
import com.iap.ac.config.lite.delegate.ConfigIdentifierProvider;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.base.UrlTransportEventHandler;
import id.dana.data.base.BasePersistenceDao;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.lib.gcontainer.GContainer;
import id.dana.utils.UtdIdUtil;
import id.dana.utils.VersionUtil;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B\u0007¢\u0006\u0004\b1\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\f\u0012\b\u0012\u0006*\u00020\u00060\u00060\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\bJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u0002¢\u0006\u0004\b\r\u0010\u000bJ#\u0010\u0012\u001a\u00020\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0016\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0005J!\u0010\u0019\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010&"}, d2 = {"Lid/dana/danah5/easteregg/EasterEggsEventHandler;", "Lcom/alibaba/griver/api/common/view/GriverTitleBarEvent;", "Lid/dana/danah5/base/UrlTransportEventHandler;", "", "getDatabaseVersion", "()V", "", "getInfoId", "()Ljava/lang/String;", "", "getPaths", "()Ljava/util/List;", "getVersionInformation", "helpUrl", "Lcom/alibaba/ariver/app/api/Page;", "page", "url", "", "interceptUrl", "(Lcom/alibaba/ariver/app/api/Page;Ljava/lang/String;)Z", "onFinalized", "onInitialized", "onTitleClick", "versionInformation", "infoIdCopy", "openEasterEggActivity", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "Landroid/app/Activity;", "Lid/dana/data/base/BasePersistenceDao;", "database", "Lid/dana/data/base/BasePersistenceDao;", "getDatabase", "()Lid/dana/data/base/BasePersistenceDao;", "setDatabase", "(Lid/dana/data/base/BasePersistenceDao;)V", "databaseVersion", "Ljava/lang/String;", "Lid/dana/data/config/DeviceInformationProvider;", "deviceInformationProvider", "Lid/dana/data/config/DeviceInformationProvider;", "getDeviceInformationProvider", "()Lid/dana/data/config/DeviceInformationProvider;", "setDeviceInformationProvider", "(Lid/dana/data/config/DeviceInformationProvider;)V", "Lid/dana/danah5/easteregg/QuickTap;", "quickTap", "Lid/dana/danah5/easteregg/QuickTap;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EasterEggsEventHandler extends UrlTransportEventHandler implements GriverTitleBarEvent {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 0;
    private static final String CLIP_BOARD_HINT = "The reference is also copied in clipboard :)";
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static char[] MyBillsEntityDataFactory;
    private static int getAuthRequestContext;
    private Activity activity;
    @Inject
    public BasePersistenceDao database;
    @Inject
    public DeviceInformationProvider deviceInformationProvider;
    private QuickTap quickTap;
    private String url = "";
    private String databaseVersion = "";

    /* renamed from: $r8$lambda$FHfxCri7v-d2_BX2DZfIAOBkBrQ  reason: not valid java name */
    public static /* synthetic */ void m651$r8$lambda$FHfxCri7vd2_BX2DZfIAOBkBrQ(EasterEggsEventHandler easterEggsEventHandler) {
        int i = getAuthRequestContext + 73;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        m653onTitleClick$lambda0(easterEggsEventHandler);
        int i3 = getAuthRequestContext + 83;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 0 : (char) 14) != 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public static /* synthetic */ void $r8$lambda$z7aspLO3EfPBguQA4oZiHuhlxGU(Task task) {
        int i = getAuthRequestContext + 73;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 == 0 ? 'G' : ']') == ']') {
            m652getVersionInformation$lambda9$lambda7(task);
            return;
        }
        try {
            m652getVersionInformation$lambda9$lambda7(task);
            int i2 = 24 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker] */
    static {
        getAuthRequestContext();
        ?? r1 = 0;
        INSTANCE = new Companion(r1);
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 95;
        getAuthRequestContext = i % 128;
        if ((i % 2 != 0 ? (char) 22 : (char) 25) != 22) {
            return;
        }
        int length = r1.length;
    }

    static void getAuthRequestContext() {
        BuiltInFictitiousFunctionClassFactory = (char) 42071;
        MyBillsEntityDataFactory = new char[]{42068, 37308, 37294, 37311};
    }

    @Override // id.dana.danah5.base.UrlTransportEventHandler, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onFinalized() {
        int i = getAuthRequestContext + 1;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 == 0 ? JSONLexer.EOI : 'E') != 'E') {
            Object obj = null;
            obj.hashCode();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0023, code lost:
    
        if ((r0 != null) != true) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0025, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002a, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002b, code lost:
    
        r4 = id.dana.danah5.easteregg.EasterEggsEventHandler.KClassImpl$Data$declaredNonStaticMembers$2 + 49;
        id.dana.danah5.easteregg.EasterEggsEventHandler.getAuthRequestContext = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0035, code lost:
    
        if ((r4 % 2) == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0038, code lost:
    
        if (r1 == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003a, code lost:
    
        r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0040, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        if (r0 != null) goto L19;
     */
    @kotlin.jvm.JvmName(name = "getDeviceInformationProvider")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.data.config.DeviceInformationProvider getDeviceInformationProvider() {
        /*
            r6 = this;
            int r0 = id.dana.danah5.easteregg.EasterEggsEventHandler.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 45
            int r1 = r0 % 128
            id.dana.danah5.easteregg.EasterEggsEventHandler.getAuthRequestContext = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            r3 = 0
            if (r0 == 0) goto L19
            id.dana.data.config.DeviceInformationProvider r0 = r6.deviceInformationProvider
            if (r0 == 0) goto L25
            goto L2b
        L19:
            id.dana.data.config.DeviceInformationProvider r0 = r6.deviceInformationProvider
            r4 = 27
            int r4 = r4 / r1
            if (r0 == 0) goto L22
            r4 = 1
            goto L23
        L22:
            r4 = 0
        L23:
            if (r4 == r2) goto L2b
        L25:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            return r3
        L2b:
            int r4 = id.dana.danah5.easteregg.EasterEggsEventHandler.KClassImpl$Data$declaredNonStaticMembers$2
            int r4 = r4 + 49
            int r5 = r4 % 128
            id.dana.danah5.easteregg.EasterEggsEventHandler.getAuthRequestContext = r5
            int r4 = r4 % 2
            if (r4 == 0) goto L38
            r1 = 1
        L38:
            if (r1 == 0) goto L40
            r3.hashCode()     // Catch: java.lang.Throwable -> L3e
            goto L40
        L3e:
            r0 = move-exception
            throw r0
        L40:
            return r0
        L41:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.easteregg.EasterEggsEventHandler.getDeviceInformationProvider():id.dana.data.config.DeviceInformationProvider");
    }

    @JvmName(name = "setDeviceInformationProvider")
    public final void setDeviceInformationProvider(DeviceInformationProvider deviceInformationProvider) {
        try {
            int i = getAuthRequestContext + 113;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if ((i % 2 == 0 ? '?' : 'N') != 'N') {
                Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
                this.deviceInformationProvider = deviceInformationProvider;
                Object obj = null;
                obj.hashCode();
                return;
            }
            try {
                Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
                this.deviceInformationProvider = deviceInformationProvider;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "getDatabase")
    public final BasePersistenceDao getDatabase() {
        int i = getAuthRequestContext + 39;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        BasePersistenceDao basePersistenceDao = this.database;
        if ((basePersistenceDao != null ? (char) 21 : (char) 1) != 21) {
            try {
                Intrinsics.throwUninitializedPropertyAccessException("");
                return null;
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 67;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            return basePersistenceDao;
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "setDatabase")
    public final void setDatabase(BasePersistenceDao basePersistenceDao) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 111;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            Intrinsics.checkNotNullParameter(basePersistenceDao, "");
            this.database = basePersistenceDao;
            int i3 = getAuthRequestContext + 89;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.danah5.base.UrlTransportEventHandler, com.alibaba.griver.api.common.page.GriverInterceptUrlEvent
    public final boolean interceptUrl(Page page, String url) {
        String pageURI;
        if (!(page == null)) {
            try {
                int i = getAuthRequestContext + 83;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                pageURI = page.getPageURI();
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 57;
                getAuthRequestContext = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } else {
            pageURI = null;
        }
        this.url = pageURI;
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002f, code lost:
    
        if (r3 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
    
        r0.PlaceComponentResult = (id.dana.di.component.ApplicationComponent) dagger.internal.Preconditions.getAuthRequestContext(((id.dana.DanaApplication) r3).getApplicationComponent());
        r0.getAuthRequestContext = (id.dana.di.modules.GContainerModule) dagger.internal.Preconditions.getAuthRequestContext(new id.dana.di.modules.GContainerModule());
        r0.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(r5);
        getDatabaseVersion();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0056, code lost:
    
        r0 = id.dana.danah5.easteregg.EasterEggsEventHandler.KClassImpl$Data$declaredNonStaticMembers$2 + 25;
        id.dana.danah5.easteregg.EasterEggsEventHandler.getAuthRequestContext = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0060, code lost:
    
        if ((r0 % 2) == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0062, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0065, code lost:
    
        if (r0 == true) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0067, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
    
        r0 = 21 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0075, code lost:
    
        throw new java.lang.NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
    
        if (r3 != null) goto L14;
     */
    @Override // id.dana.danah5.base.UrlTransportEventHandler, com.alibaba.ariver.kernel.api.extension.Extension
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onInitialized() {
        /*
            r5 = this;
            int r0 = id.dana.danah5.easteregg.EasterEggsEventHandler.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L78
            int r0 = r0 + 73
            int r1 = r0 % 128
            id.dana.danah5.easteregg.EasterEggsEventHandler.getAuthRequestContext = r1     // Catch: java.lang.Exception -> L78
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == r1) goto L21
            super.onInitialized()
            id.dana.di.component.DaggerGContainerComponent$Builder r0 = id.dana.di.component.DaggerGContainerComponent.PlaceComponentResult()
            android.app.Application r3 = com.alibaba.griver.base.common.env.GriverEnv.getApplicationContext()
            if (r3 == 0) goto L6e
            goto L31
        L21:
            super.onInitialized()
            id.dana.di.component.DaggerGContainerComponent$Builder r0 = id.dana.di.component.DaggerGContainerComponent.PlaceComponentResult()
            android.app.Application r3 = com.alibaba.griver.base.common.env.GriverEnv.getApplicationContext()
            r4 = 83
            int r4 = r4 / r2
            if (r3 == 0) goto L6e
        L31:
            id.dana.DanaApplication r3 = (id.dana.DanaApplication) r3
            id.dana.di.component.ApplicationComponent r3 = r3.getApplicationComponent()
            java.lang.Object r3 = dagger.internal.Preconditions.getAuthRequestContext(r3)
            id.dana.di.component.ApplicationComponent r3 = (id.dana.di.component.ApplicationComponent) r3
            r0.PlaceComponentResult = r3
            id.dana.di.modules.GContainerModule r3 = new id.dana.di.modules.GContainerModule
            r3.<init>()
            java.lang.Object r3 = dagger.internal.Preconditions.getAuthRequestContext(r3)
            id.dana.di.modules.GContainerModule r3 = (id.dana.di.modules.GContainerModule) r3
            r0.getAuthRequestContext = r3
            id.dana.di.component.GContainerComponent r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2()
            r0.BuiltInFictitiousFunctionClassFactory(r5)
            r5.getDatabaseVersion()
            int r0 = id.dana.danah5.easteregg.EasterEggsEventHandler.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L78
            int r0 = r0 + 25
            int r3 = r0 % 128
            id.dana.danah5.easteregg.EasterEggsEventHandler.getAuthRequestContext = r3     // Catch: java.lang.Exception -> L78
            int r0 = r0 % 2
            if (r0 == 0) goto L64
            r0 = 1
            goto L65
        L64:
            r0 = 0
        L65:
            if (r0 == r1) goto L68
            return
        L68:
            r0 = 21
            int r0 = r0 / r2
            return
        L6c:
            r0 = move-exception
            throw r0
        L6e:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type id.dana.DanaApplication"
            r0.<init>(r1)
            throw r0
        L76:
            r0 = move-exception
            throw r0
        L78:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.easteregg.EasterEggsEventHandler.onInitialized():void");
    }

    private final void getDatabaseVersion() {
        try {
            Object[] objArr = null;
            if (this.database != null) {
                int i = getAuthRequestContext + 97;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if (i % 2 != 0) {
                    this.databaseVersion = String.valueOf(getDatabase().getOpenHelper().getReadableDatabase().getVersion());
                } else {
                    this.databaseVersion = String.valueOf(getDatabase().getOpenHelper().getReadableDatabase().getVersion());
                    int length = objArr.length;
                }
            }
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 117;
            getAuthRequestContext = i2 % 128;
            if ((i2 % 2 != 0 ? 'L' : ']') != ']') {
                int length2 = objArr.length;
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: onTitleClick$lambda-0  reason: not valid java name */
    private static final void m653onTitleClick$lambda0(EasterEggsEventHandler easterEggsEventHandler) {
        int i = getAuthRequestContext + 57;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 == 0 ? (char) 14 : 'S') != 'S') {
            Intrinsics.checkNotNullParameter(easterEggsEventHandler, "");
            easterEggsEventHandler.openEasterEggActivity(easterEggsEventHandler.getVersionInformation(), easterEggsEventHandler.getInfoId());
            int i2 = 1 / 0;
            return;
        }
        Intrinsics.checkNotNullParameter(easterEggsEventHandler, "");
        easterEggsEventHandler.openEasterEggActivity(easterEggsEventHandler.getVersionInformation(), easterEggsEventHandler.getInfoId());
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
    
        if (r3.isEmpty() != false) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a5 A[Catch: Exception -> 0x00b9, TryCatch #0 {Exception -> 0x00b9, blocks: (B:9:0x001f, B:14:0x003d, B:16:0x0046, B:44:0x00a5, B:46:0x00a9, B:47:0x00ac, B:21:0x004c, B:24:0x0056, B:25:0x005a, B:30:0x0069, B:36:0x008b), top: B:58:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    @Override // com.alibaba.griver.api.common.view.GriverTitleBarEvent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onTitleClick() {
        /*
            Method dump skipped, instructions count: 204
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.easteregg.EasterEggsEventHandler.onTitleClick():void");
    }

    private final List<String> helpUrl() {
        try {
            int i = getAuthRequestContext + 37;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            List<String> listOf = CollectionsKt.listOf((Object[]) new String[]{"https://m.dana.id/m/standalone/help", "https://m.dana.id/m/standalone/help-center/main", "https://m.dana.id/i/dana-info/resolution-center/main?entryPoint=me", "https://m.dana.id/i/dana-info/resolution-center"});
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 61;
            getAuthRequestContext = i3 % 128;
            if (!(i3 % 2 != 0)) {
                return listOf;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return listOf;
        } catch (Exception e) {
            throw e;
        }
    }

    private final List<String> getPaths() {
        List<String> helpUrl = helpUrl();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(helpUrl, 10));
        Iterator<T> it = helpUrl.iterator();
        int i = getAuthRequestContext + 47;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        while (it.hasNext()) {
            try {
                try {
                    arrayList.add(new URI((String) it.next()).getRawPath());
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        return arrayList;
    }

    private final String getInfoId() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("utdid: ");
        sb2.append(UtdIdUtil.PlaceComponentResult());
        sb.append(sb2.toString());
        Intrinsics.checkNotNullExpressionValue(sb, "");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("local-utdid: ");
        sb3.append(getDeviceInformationProvider().getDeviceUtdId());
        sb.append(sb3.toString());
        Intrinsics.checkNotNullExpressionValue(sb, "");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "");
        StringBuilder sb4 = new StringBuilder();
        sb4.append("reference-utdid: ");
        sb4.append(UtdIdUtil.MyBillsEntityDataFactory());
        sb.append(sb4.toString());
        Intrinsics.checkNotNullExpressionValue(sb, "");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("local-reference-utdid: ");
        sb5.append(getDeviceInformationProvider().getReferenceUtdId());
        sb.append(sb5.toString());
        Intrinsics.checkNotNullExpressionValue(sb, "");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "");
        ConfigCenter configCenter = ConfigCenter.getInstance();
        if (!configCenter.isInitialized()) {
            try {
                int i = getAuthRequestContext + 11;
                try {
                    KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                    int i2 = i % 2;
                    configCenter = null;
                    int i3 = getAuthRequestContext + 53;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                    int i4 = i3 % 2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        if (configCenter != null) {
            ConfigIdentifierProvider identifierProvider = configCenter.getConfigContext().getIdentifierProvider();
            Intrinsics.checkNotNullExpressionValue(identifierProvider, "");
            String configUserId = identifierProvider.getConfigUserId(GContainer.getApplicationContext());
            Intrinsics.checkNotNullExpressionValue(configUserId, "");
            StringBuilder sb6 = new StringBuilder();
            sb6.append("reference-uid: ");
            sb6.append(configUserId);
            sb.append(sb6.toString());
            Intrinsics.checkNotNullExpressionValue(sb, "");
            sb.append('\n');
            Intrinsics.checkNotNullExpressionValue(sb, "");
        }
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    private final String getVersionInformation() {
        boolean z;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("App Version: ");
        sb2.append(VersionUtil.getAuthRequestContext(GriverEnv.getApplicationContext(), false));
        sb.append(sb2.toString());
        Intrinsics.checkNotNullExpressionValue(sb, "");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "");
        if ((this.databaseVersion.length() > 0 ? (char) 29 : '!') != '!') {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 19;
            getAuthRequestContext = i % 128;
            z = !(i % 2 != 0);
        } else {
            z = false;
        }
        if (z) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("databaseVersion: ");
            sb3.append(this.databaseVersion);
            sb.append(sb3.toString());
            Intrinsics.checkNotNullExpressionValue(sb, "");
            sb.append('\n');
            Intrinsics.checkNotNullExpressionValue(sb, "");
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("hash: ");
        Application applicationContext = GriverEnv.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "");
        sb4.append(CollectionsKt.joinToString$default(new AppSignatureHelper(applicationContext).getAppSignatures(), ", ", null, null, 0, null, null, 62, null));
        sb.append(sb4.toString());
        Intrinsics.checkNotNullExpressionValue(sb, "");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "");
        String fcmToken = FirebaseInfoHolder.INSTANCE.getFcmToken();
        if (fcmToken != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("fcmToken: ");
            sb5.append(fcmToken);
            sb.append(sb5.toString());
            Intrinsics.checkNotNullExpressionValue(sb, "");
            sb.append('\n');
            Intrinsics.checkNotNullExpressionValue(sb, "");
        } else {
            Intrinsics.checkNotNullExpressionValue(FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener() { // from class: id.dana.danah5.easteregg.EasterEggsEventHandler$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    EasterEggsEventHandler.$r8$lambda$z7aspLO3EfPBguQA4oZiHuhlxGU(task);
                }
            }), "");
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
            getAuthRequestContext = i2 % 128;
            int i3 = i2 % 2;
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("User Agent: ");
        sb6.append(GriverWebviewSetting.getUserAgent());
        sb.append(sb6.toString());
        Intrinsics.checkNotNullExpressionValue(sb, "");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "");
        ConfigCenter configCenter = ConfigCenter.getInstance();
        Intrinsics.checkNotNullExpressionValue(configCenter, "");
        if (configCenter.isInitialized()) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append("utdid: ");
            sb7.append(UtdIdUtil.PlaceComponentResult());
            sb.append(sb7.toString());
            Intrinsics.checkNotNullExpressionValue(sb, "");
            sb.append('\n');
            Intrinsics.checkNotNullExpressionValue(sb, "");
            StringBuilder sb8 = new StringBuilder();
            sb8.append("local-utdid: ");
            sb8.append(getDeviceInformationProvider().getDeviceUtdId());
            sb.append(sb8.toString());
            Intrinsics.checkNotNullExpressionValue(sb, "");
            sb.append('\n');
            Intrinsics.checkNotNullExpressionValue(sb, "");
            StringBuilder sb9 = new StringBuilder();
            sb9.append("reference-utdid: ");
            sb9.append(UtdIdUtil.MyBillsEntityDataFactory());
            sb.append(sb9.toString());
            Intrinsics.checkNotNullExpressionValue(sb, "");
            sb.append('\n');
            Intrinsics.checkNotNullExpressionValue(sb, "");
            StringBuilder sb10 = new StringBuilder();
            sb10.append("local-reference-utdid: ");
            sb10.append(getDeviceInformationProvider().getReferenceUtdId());
            sb.append(sb10.toString());
            Intrinsics.checkNotNullExpressionValue(sb, "");
            sb.append('\n');
            Intrinsics.checkNotNullExpressionValue(sb, "");
            ConfigIdentifierProvider identifierProvider = configCenter.getConfigContext().getIdentifierProvider();
            Intrinsics.checkNotNullExpressionValue(identifierProvider, "");
            String configUserId = identifierProvider.getConfigUserId(GContainer.getApplicationContext());
            Intrinsics.checkNotNullExpressionValue(configUserId, "");
            long lastUpdateVersion = configCenter.getLastUpdateVersion();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            StringBuilder sb11 = new StringBuilder();
            sb11.append("reference-uid: ");
            sb11.append(configUserId);
            sb.append(sb11.toString());
            Intrinsics.checkNotNullExpressionValue(sb, "");
            sb.append('\n');
            Intrinsics.checkNotNullExpressionValue(sb, "");
            StringBuilder sb12 = new StringBuilder();
            sb12.append("version: ");
            sb12.append(lastUpdateVersion);
            sb.append(sb12.toString());
            Intrinsics.checkNotNullExpressionValue(sb, "");
            sb.append('\n');
            Intrinsics.checkNotNullExpressionValue(sb, "");
            StringBuilder sb13 = new StringBuilder();
            sb13.append("versionDate: ");
            sb13.append(simpleDateFormat.format(new Date(lastUpdateVersion)));
            sb.append(sb13.toString());
            Intrinsics.checkNotNullExpressionValue(sb, "");
            sb.append('\n');
            Intrinsics.checkNotNullExpressionValue(sb, "");
            sb.append('\n');
            Intrinsics.checkNotNullExpressionValue(sb, "");
            sb.append('\n');
            Intrinsics.checkNotNullExpressionValue(sb, "");
            sb.append("apps: ");
            Object[] objArr = new Object[1];
            a(new char[]{3, 2, 1, 3}, (byte) (Color.green(0) + 54), 4 - KeyEvent.getDeadChar(0, 0), objArr);
            JSONObject sectionConfig = configCenter.getSectionConfig(((String) objArr[0]).intern());
            if (sectionConfig == null) {
                int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 67;
                getAuthRequestContext = i4 % 128;
                int i5 = i4 % 2;
                sb.append("null");
                Intrinsics.checkNotNullExpressionValue(sb, "");
                sb.append('\n');
                Intrinsics.checkNotNullExpressionValue(sb, "");
            } else {
                Iterator<String> keys = sectionConfig.keys();
                Intrinsics.checkNotNullExpressionValue(keys, "");
                while (true) {
                    if ((keys.hasNext() ? '\n' : '7') != '\n') {
                        break;
                    }
                    String next = keys.next();
                    if (next == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String obj = sectionConfig.get(next).toString();
                    StringBuilder sb14 = new StringBuilder();
                    sb14.append(next);
                    sb14.append(obj);
                    sb.append(sb14.toString());
                    Intrinsics.checkNotNullExpressionValue(sb, "");
                    sb.append('\n');
                    Intrinsics.checkNotNullExpressionValue(sb, "");
                }
            }
            sb.append('\n');
            Intrinsics.checkNotNullExpressionValue(sb, "");
            sb.append('\n');
            Intrinsics.checkNotNullExpressionValue(sb, "");
            sb.append(CLIP_BOARD_HINT);
            Intrinsics.checkNotNullExpressionValue(sb, "");
            sb.append('\n');
            Intrinsics.checkNotNullExpressionValue(sb, "");
        } else {
            sb.append("AMCS ConfigSdk not initialized!");
            Intrinsics.checkNotNullExpressionValue(sb, "");
            sb.append('\n');
            Intrinsics.checkNotNullExpressionValue(sb, "");
        }
        String obj2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj2, "");
        return obj2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
    
        if (r0 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002a, code lost:
    
        if (r3.isSuccessful() != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        id.dana.danah5.easteregg.FirebaseInfoHolder.INSTANCE.setFcmToken((java.lang.String) r3.getResult());
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        r3 = id.dana.danah5.easteregg.EasterEggsEventHandler.getAuthRequestContext + 9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003d, code lost:
    
        id.dana.danah5.easteregg.EasterEggsEventHandler.KClassImpl$Data$declaredNonStaticMembers$2 = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
    
        if ((r3 % 2) != 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0045, code lost:
    
        r3 = 'G';
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:
    
        r3 = 28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
    
        if (r3 == 28) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004c, code lost:
    
        r1.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0052, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0053, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0054, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0055, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0056, code lost:
    
        throw r3;
     */
    /* renamed from: getVersionInformation$lambda-9$lambda-7  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void m652getVersionInformation$lambda9$lambda7(com.google.android.gms.tasks.Task r3) {
        /*
            int r0 = id.dana.danah5.easteregg.EasterEggsEventHandler.getAuthRequestContext
            int r0 = r0 + 13
            int r1 = r0 % 128
            id.dana.danah5.easteregg.EasterEggsEventHandler.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            if (r0 != 0) goto Le
            r0 = 1
            goto Lf
        Le:
            r0 = 0
        Lf:
            r1 = 0
            java.lang.String r2 = ""
            if (r0 == 0) goto L23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            boolean r0 = r3.isSuccessful()
            r1.hashCode()     // Catch: java.lang.Throwable -> L21
            if (r0 == 0) goto L37
            goto L2c
        L21:
            r3 = move-exception
            throw r3
        L23:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            boolean r0 = r3.isSuccessful()
            if (r0 == 0) goto L37
        L2c:
            id.dana.danah5.easteregg.FirebaseInfoHolder r0 = id.dana.danah5.easteregg.FirebaseInfoHolder.INSTANCE
            java.lang.Object r3 = r3.getResult()
            java.lang.String r3 = (java.lang.String) r3
            r0.setFcmToken(r3)
        L37:
            int r3 = id.dana.danah5.easteregg.EasterEggsEventHandler.getAuthRequestContext     // Catch: java.lang.Exception -> L55
            int r3 = r3 + 9
            int r0 = r3 % 128
            id.dana.danah5.easteregg.EasterEggsEventHandler.KClassImpl$Data$declaredNonStaticMembers$2 = r0     // Catch: java.lang.Exception -> L53
            int r3 = r3 % 2
            r0 = 28
            if (r3 != 0) goto L48
            r3 = 71
            goto L4a
        L48:
            r3 = 28
        L4a:
            if (r3 == r0) goto L52
            r1.hashCode()     // Catch: java.lang.Throwable -> L50
            return
        L50:
            r3 = move-exception
            throw r3
        L52:
            return
        L53:
            r3 = move-exception
            throw r3
        L55:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.easteregg.EasterEggsEventHandler.m652getVersionInformation$lambda9$lambda7(com.google.android.gms.tasks.Task):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
    
        if (r0 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0024, code lost:
    
        if (r0 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0028, code lost:
    
        r5 = new android.content.Intent(r0, id.dana.myprofile.EasterEggActivity.class).putExtra("egg_message", r5).putExtra(id.dana.myprofile.EasterEggActivity.INFO_COPY, r6);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "");
        r0.startActivity(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
    
        r5 = id.dana.danah5.easteregg.EasterEggsEventHandler.KClassImpl$Data$declaredNonStaticMembers$2 + 45;
        id.dana.danah5.easteregg.EasterEggsEventHandler.getAuthRequestContext = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0050, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void openEasterEggActivity(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            int r0 = id.dana.danah5.easteregg.EasterEggsEventHandler.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 87
            int r1 = r0 % 128
            id.dana.danah5.easteregg.EasterEggsEventHandler.getAuthRequestContext = r1
            int r0 = r0 % 2
            r1 = 76
            if (r0 == 0) goto L11
            r0 = 57
            goto L13
        L11:
            r0 = 76
        L13:
            if (r0 == r1) goto L22
            android.app.Activity r0 = r4.activity     // Catch: java.lang.Exception -> L20
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L1e
            if (r0 == 0) goto L46
            goto L26
        L1e:
            r5 = move-exception
            throw r5
        L20:
            r5 = move-exception
            goto L45
        L22:
            android.app.Activity r0 = r4.activity
            if (r0 == 0) goto L46
        L26:
            android.content.Intent r1 = new android.content.Intent
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2     // Catch: java.lang.Exception -> L20
            java.lang.Class<id.dana.myprofile.EasterEggActivity> r3 = id.dana.myprofile.EasterEggActivity.class
            r1.<init>(r2, r3)     // Catch: java.lang.Exception -> L20
            java.lang.String r2 = "egg_message"
            android.content.Intent r5 = r1.putExtra(r2, r5)     // Catch: java.lang.Exception -> L20
            java.lang.String r1 = "info_copy"
            android.content.Intent r5 = r5.putExtra(r1, r6)     // Catch: java.lang.Exception -> L20
            java.lang.String r6 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch: java.lang.Exception -> L20
            r0.startActivity(r5)     // Catch: java.lang.Exception -> L20
            goto L46
        L45:
            throw r5
        L46:
            int r5 = id.dana.danah5.easteregg.EasterEggsEventHandler.KClassImpl$Data$declaredNonStaticMembers$2
            int r5 = r5 + 45
            int r6 = r5 % 128
            id.dana.danah5.easteregg.EasterEggsEventHandler.getAuthRequestContext = r6
            int r5 = r5 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.easteregg.EasterEggsEventHandler.openEasterEggActivity(java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0078, code lost:
    
        if (r0.MyBillsEntityDataFactory == r0.PlaceComponentResult) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008c, code lost:
    
        if (r0.MyBillsEntityDataFactory == r0.PlaceComponentResult) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0092, code lost:
    
        r3[r0.getAuthRequestContext] = (char) (r0.MyBillsEntityDataFactory - r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0098, code lost:
    
        r3[r0.getAuthRequestContext + 1] = (char) (r0.PlaceComponentResult - r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a1, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory = r0.MyBillsEntityDataFactory / r2;
        r0.scheduleImpl = r0.MyBillsEntityDataFactory % r2;
        r0.KClassImpl$Data$declaredNonStaticMembers$2 = r0.PlaceComponentResult / r2;
        r0.lookAheadTest = r0.PlaceComponentResult % r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b9, code lost:
    
        if (r0.scheduleImpl != r0.lookAheadTest) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00bb, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00bd, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00be, code lost:
    
        if (r6 == true) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c4, code lost:
    
        if (r0.BuiltInFictitiousFunctionClassFactory != r0.KClassImpl$Data$declaredNonStaticMembers$2) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c6, code lost:
    
        r0.scheduleImpl = ((r0.scheduleImpl + r2) - 1) % r2;
        r0.lookAheadTest = ((r0.lookAheadTest + r2) - 1) % r2;
        r6 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.scheduleImpl;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.lookAheadTest;
        r3[r0.getAuthRequestContext] = r1[r6];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
        r6 = id.dana.danah5.easteregg.EasterEggsEventHandler.$11 + 97;
        id.dana.danah5.easteregg.EasterEggsEventHandler.$10 = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00fa, code lost:
    
        r6 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.lookAheadTest;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.scheduleImpl;
        r3[r0.getAuthRequestContext] = r1[r6];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0116, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory = ((r0.BuiltInFictitiousFunctionClassFactory + r2) - 1) % r2;
        r0.KClassImpl$Data$declaredNonStaticMembers$2 = ((r0.KClassImpl$Data$declaredNonStaticMembers$2 + r2) - 1) % r2;
        r6 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.scheduleImpl;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.lookAheadTest;
        r3[r0.getAuthRequestContext] = r1[r6];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(char[] r10, byte r11, int r12, java.lang.Object[] r13) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.easteregg.EasterEggsEventHandler.a(char[], byte, int, java.lang.Object[]):void");
    }
}
