package androidx.window.layout;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.window.core.Version;
import androidx.window.layout.ExtensionInterfaceCompat;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarProvider;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000 !2\u00020\u0001:\u0005!\"#$%B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0007\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\fH\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\fH\u0016J\u0016\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\fH\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\fH\u0002J\b\u0010\u001f\u001a\u00020 H\u0017R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/window/layout/SidecarCompat;", "Landroidx/window/layout/ExtensionInterfaceCompat;", HummerConstants.CONTEXT, "Landroid/content/Context;", "(Landroid/content/Context;)V", "sidecar", "Landroidx/window/sidecar/SidecarInterface;", "sidecarAdapter", "Landroidx/window/layout/SidecarAdapter;", "(Landroidx/window/sidecar/SidecarInterface;Landroidx/window/layout/SidecarAdapter;)V", "componentCallbackMap", "", "Landroid/app/Activity;", "Landroid/content/ComponentCallbacks;", "extensionCallback", "Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "getSidecar", "()Landroidx/window/sidecar/SidecarInterface;", "windowListenerRegisteredContexts", "Landroid/os/IBinder;", "getWindowLayoutInfo", "Landroidx/window/layout/WindowLayoutInfo;", AkuEventParamsKey.KEY_ACTIVITY, "onWindowLayoutChangeListenerAdded", "", "onWindowLayoutChangeListenerRemoved", DanaLogConstants.BizType.REGISTER, "windowToken", "registerConfigurationChangeListener", "setExtensionCallback", "unregisterComponentCallback", "validateExtensionInterface", "", "Companion", "DistinctElementCallback", "DistinctSidecarElementCallback", "FirstAttachAdapter", "TranslatingCallback", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SidecarCompat implements ExtensionInterfaceCompat {
    public static final Companion MyBillsEntityDataFactory = new Companion(null);
    private ExtensionInterfaceCompat.ExtensionCallbackInterface BuiltInFictitiousFunctionClassFactory;
    private final SidecarAdapter KClassImpl$Data$declaredNonStaticMembers$2;
    private final Map<Activity, ComponentCallbacks> PlaceComponentResult;
    private final SidecarInterface getAuthRequestContext;
    private final Map<IBinder, Activity> scheduleImpl;

    public SidecarCompat(SidecarInterface sidecarInterface, SidecarAdapter sidecarAdapter) {
        Intrinsics.checkNotNullParameter(sidecarAdapter, "");
        this.getAuthRequestContext = sidecarInterface;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = sidecarAdapter;
        this.scheduleImpl = new LinkedHashMap();
        this.PlaceComponentResult = new LinkedHashMap();
    }

    /* renamed from: PlaceComponentResult  reason: from getter */
    public final SidecarInterface getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SidecarCompat(Context context) {
        this(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(context), new SidecarAdapter((byte) 0));
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // androidx.window.layout.ExtensionInterfaceCompat
    public final void getAuthRequestContext(ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface) {
        Intrinsics.checkNotNullParameter(extensionCallbackInterface, "");
        this.BuiltInFictitiousFunctionClassFactory = new DistinctElementCallback(extensionCallbackInterface);
        SidecarInterface sidecarInterface = this.getAuthRequestContext;
        if (sidecarInterface != null) {
            sidecarInterface.setSidecarCallback(new DistinctSidecarElementCallback(this.KClassImpl$Data$declaredNonStaticMembers$2, new TranslatingCallback(this)));
        }
    }

    public final WindowLayoutInfo MyBillsEntityDataFactory(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
        IBinder MyBillsEntityDataFactory2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory(activity);
        if (MyBillsEntityDataFactory2 == null) {
            return new WindowLayoutInfo(CollectionsKt.emptyList());
        }
        SidecarInterface sidecarInterface = this.getAuthRequestContext;
        SidecarWindowLayoutInfo windowLayoutInfo = sidecarInterface == null ? null : sidecarInterface.getWindowLayoutInfo(MyBillsEntityDataFactory2);
        SidecarAdapter sidecarAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        SidecarInterface sidecarInterface2 = this.getAuthRequestContext;
        SidecarDeviceState deviceState = sidecarInterface2 != null ? sidecarInterface2.getDeviceState() : null;
        if (deviceState == null) {
            deviceState = new SidecarDeviceState();
        }
        return sidecarAdapter.MyBillsEntityDataFactory(windowLayoutInfo, deviceState);
    }

    @Override // androidx.window.layout.ExtensionInterfaceCompat
    public final void PlaceComponentResult(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
        IBinder MyBillsEntityDataFactory2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory(activity);
        if (MyBillsEntityDataFactory2 != null) {
            PlaceComponentResult(MyBillsEntityDataFactory2, activity);
            return;
        }
        activity.getWindow().getDecorView().addOnAttachStateChangeListener(new FirstAttachAdapter(this, activity));
    }

    public final void PlaceComponentResult(IBinder iBinder, Activity activity) {
        SidecarInterface sidecarInterface;
        Intrinsics.checkNotNullParameter(iBinder, "");
        Intrinsics.checkNotNullParameter(activity, "");
        this.scheduleImpl.put(iBinder, activity);
        SidecarInterface sidecarInterface2 = this.getAuthRequestContext;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerAdded(iBinder);
        }
        if (this.scheduleImpl.size() == 1 && (sidecarInterface = this.getAuthRequestContext) != null) {
            sidecarInterface.onDeviceStateListenersChanged(false);
        }
        ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = this.BuiltInFictitiousFunctionClassFactory;
        if (extensionCallbackInterface != null) {
            extensionCallbackInterface.PlaceComponentResult(activity, MyBillsEntityDataFactory(activity));
        }
        getAuthRequestContext(activity);
    }

    private final void getAuthRequestContext(final Activity activity) {
        if (this.PlaceComponentResult.get(activity) == null) {
            ComponentCallbacks componentCallbacks = new ComponentCallbacks() { // from class: androidx.window.layout.SidecarCompat$registerConfigurationChangeListener$configChangeObserver$1
                @Override // android.content.ComponentCallbacks
                public final void onLowMemory() {
                }

                @Override // android.content.ComponentCallbacks
                public final void onConfigurationChanged(Configuration p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = SidecarCompat.this.BuiltInFictitiousFunctionClassFactory;
                    if (extensionCallbackInterface != null) {
                        Activity activity2 = activity;
                        extensionCallbackInterface.PlaceComponentResult(activity2, SidecarCompat.this.MyBillsEntityDataFactory(activity2));
                    }
                }
            };
            this.PlaceComponentResult.put(activity, componentCallbacks);
            activity.registerComponentCallbacks(componentCallbacks);
        }
    }

    @Override // androidx.window.layout.ExtensionInterfaceCompat
    public final void BuiltInFictitiousFunctionClassFactory(Activity activity) {
        SidecarInterface sidecarInterface;
        Intrinsics.checkNotNullParameter(activity, "");
        IBinder MyBillsEntityDataFactory2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory(activity);
        if (MyBillsEntityDataFactory2 == null) {
            return;
        }
        SidecarInterface sidecarInterface2 = this.getAuthRequestContext;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerRemoved(MyBillsEntityDataFactory2);
        }
        KClassImpl$Data$declaredNonStaticMembers$2(activity);
        boolean z = this.scheduleImpl.size() == 1;
        this.scheduleImpl.remove(MyBillsEntityDataFactory2);
        if (!z || (sidecarInterface = this.getAuthRequestContext) == null) {
            return;
        }
        sidecarInterface.onDeviceStateListenersChanged(true);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(Activity activity) {
        activity.unregisterComponentCallbacks(this.PlaceComponentResult.get(activity));
        this.PlaceComponentResult.remove(activity);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0021 A[Catch: all -> 0x019c, TryCatch #1 {all -> 0x019c, blocks: (B:3:0x0002, B:13:0x0025, B:15:0x002d, B:17:0x0031, B:18:0x0034, B:20:0x0038, B:21:0x003b, B:31:0x005c, B:33:0x0064, B:43:0x0085, B:45:0x008d, B:55:0x00ad, B:57:0x00b5, B:59:0x00bb, B:65:0x00f2, B:66:0x010e, B:68:0x0112, B:70:0x0143, B:73:0x014c, B:74:0x0153, B:75:0x0154, B:76:0x015b, B:61:0x00be, B:63:0x00ea, B:77:0x015c, B:78:0x0163, B:79:0x0164, B:80:0x016b, B:81:0x016c, B:82:0x0177, B:54:0x00a9, B:48:0x0092, B:50:0x0098, B:83:0x0178, B:84:0x0183, B:42:0x0081, B:36:0x0069, B:38:0x006f, B:85:0x0184, B:86:0x018f, B:30:0x0058, B:24:0x0040, B:26:0x0046, B:87:0x0190, B:88:0x019b, B:12:0x0021, B:6:0x0008, B:8:0x000e), top: B:93:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002d A[Catch: all -> 0x019c, TryCatch #1 {all -> 0x019c, blocks: (B:3:0x0002, B:13:0x0025, B:15:0x002d, B:17:0x0031, B:18:0x0034, B:20:0x0038, B:21:0x003b, B:31:0x005c, B:33:0x0064, B:43:0x0085, B:45:0x008d, B:55:0x00ad, B:57:0x00b5, B:59:0x00bb, B:65:0x00f2, B:66:0x010e, B:68:0x0112, B:70:0x0143, B:73:0x014c, B:74:0x0153, B:75:0x0154, B:76:0x015b, B:61:0x00be, B:63:0x00ea, B:77:0x015c, B:78:0x0163, B:79:0x0164, B:80:0x016b, B:81:0x016c, B:82:0x0177, B:54:0x00a9, B:48:0x0092, B:50:0x0098, B:83:0x0178, B:84:0x0183, B:42:0x0081, B:36:0x0069, B:38:0x006f, B:85:0x0184, B:86:0x018f, B:30:0x0058, B:24:0x0040, B:26:0x0046, B:87:0x0190, B:88:0x019b, B:12:0x0021, B:6:0x0008, B:8:0x000e), top: B:93:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0058 A[Catch: all -> 0x019c, TryCatch #1 {all -> 0x019c, blocks: (B:3:0x0002, B:13:0x0025, B:15:0x002d, B:17:0x0031, B:18:0x0034, B:20:0x0038, B:21:0x003b, B:31:0x005c, B:33:0x0064, B:43:0x0085, B:45:0x008d, B:55:0x00ad, B:57:0x00b5, B:59:0x00bb, B:65:0x00f2, B:66:0x010e, B:68:0x0112, B:70:0x0143, B:73:0x014c, B:74:0x0153, B:75:0x0154, B:76:0x015b, B:61:0x00be, B:63:0x00ea, B:77:0x015c, B:78:0x0163, B:79:0x0164, B:80:0x016b, B:81:0x016c, B:82:0x0177, B:54:0x00a9, B:48:0x0092, B:50:0x0098, B:83:0x0178, B:84:0x0183, B:42:0x0081, B:36:0x0069, B:38:0x006f, B:85:0x0184, B:86:0x018f, B:30:0x0058, B:24:0x0040, B:26:0x0046, B:87:0x0190, B:88:0x019b, B:12:0x0021, B:6:0x0008, B:8:0x000e), top: B:93:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0064 A[Catch: all -> 0x019c, TryCatch #1 {all -> 0x019c, blocks: (B:3:0x0002, B:13:0x0025, B:15:0x002d, B:17:0x0031, B:18:0x0034, B:20:0x0038, B:21:0x003b, B:31:0x005c, B:33:0x0064, B:43:0x0085, B:45:0x008d, B:55:0x00ad, B:57:0x00b5, B:59:0x00bb, B:65:0x00f2, B:66:0x010e, B:68:0x0112, B:70:0x0143, B:73:0x014c, B:74:0x0153, B:75:0x0154, B:76:0x015b, B:61:0x00be, B:63:0x00ea, B:77:0x015c, B:78:0x0163, B:79:0x0164, B:80:0x016b, B:81:0x016c, B:82:0x0177, B:54:0x00a9, B:48:0x0092, B:50:0x0098, B:83:0x0178, B:84:0x0183, B:42:0x0081, B:36:0x0069, B:38:0x006f, B:85:0x0184, B:86:0x018f, B:30:0x0058, B:24:0x0040, B:26:0x0046, B:87:0x0190, B:88:0x019b, B:12:0x0021, B:6:0x0008, B:8:0x000e), top: B:93:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0081 A[Catch: all -> 0x019c, TryCatch #1 {all -> 0x019c, blocks: (B:3:0x0002, B:13:0x0025, B:15:0x002d, B:17:0x0031, B:18:0x0034, B:20:0x0038, B:21:0x003b, B:31:0x005c, B:33:0x0064, B:43:0x0085, B:45:0x008d, B:55:0x00ad, B:57:0x00b5, B:59:0x00bb, B:65:0x00f2, B:66:0x010e, B:68:0x0112, B:70:0x0143, B:73:0x014c, B:74:0x0153, B:75:0x0154, B:76:0x015b, B:61:0x00be, B:63:0x00ea, B:77:0x015c, B:78:0x0163, B:79:0x0164, B:80:0x016b, B:81:0x016c, B:82:0x0177, B:54:0x00a9, B:48:0x0092, B:50:0x0098, B:83:0x0178, B:84:0x0183, B:42:0x0081, B:36:0x0069, B:38:0x006f, B:85:0x0184, B:86:0x018f, B:30:0x0058, B:24:0x0040, B:26:0x0046, B:87:0x0190, B:88:0x019b, B:12:0x0021, B:6:0x0008, B:8:0x000e), top: B:93:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008d A[Catch: all -> 0x019c, TryCatch #1 {all -> 0x019c, blocks: (B:3:0x0002, B:13:0x0025, B:15:0x002d, B:17:0x0031, B:18:0x0034, B:20:0x0038, B:21:0x003b, B:31:0x005c, B:33:0x0064, B:43:0x0085, B:45:0x008d, B:55:0x00ad, B:57:0x00b5, B:59:0x00bb, B:65:0x00f2, B:66:0x010e, B:68:0x0112, B:70:0x0143, B:73:0x014c, B:74:0x0153, B:75:0x0154, B:76:0x015b, B:61:0x00be, B:63:0x00ea, B:77:0x015c, B:78:0x0163, B:79:0x0164, B:80:0x016b, B:81:0x016c, B:82:0x0177, B:54:0x00a9, B:48:0x0092, B:50:0x0098, B:83:0x0178, B:84:0x0183, B:42:0x0081, B:36:0x0069, B:38:0x006f, B:85:0x0184, B:86:0x018f, B:30:0x0058, B:24:0x0040, B:26:0x0046, B:87:0x0190, B:88:0x019b, B:12:0x0021, B:6:0x0008, B:8:0x000e), top: B:93:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a9 A[Catch: all -> 0x019c, TryCatch #1 {all -> 0x019c, blocks: (B:3:0x0002, B:13:0x0025, B:15:0x002d, B:17:0x0031, B:18:0x0034, B:20:0x0038, B:21:0x003b, B:31:0x005c, B:33:0x0064, B:43:0x0085, B:45:0x008d, B:55:0x00ad, B:57:0x00b5, B:59:0x00bb, B:65:0x00f2, B:66:0x010e, B:68:0x0112, B:70:0x0143, B:73:0x014c, B:74:0x0153, B:75:0x0154, B:76:0x015b, B:61:0x00be, B:63:0x00ea, B:77:0x015c, B:78:0x0163, B:79:0x0164, B:80:0x016b, B:81:0x016c, B:82:0x0177, B:54:0x00a9, B:48:0x0092, B:50:0x0098, B:83:0x0178, B:84:0x0183, B:42:0x0081, B:36:0x0069, B:38:0x006f, B:85:0x0184, B:86:0x018f, B:30:0x0058, B:24:0x0040, B:26:0x0046, B:87:0x0190, B:88:0x019b, B:12:0x0021, B:6:0x0008, B:8:0x000e), top: B:93:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b5 A[Catch: all -> 0x019c, TRY_LEAVE, TryCatch #1 {all -> 0x019c, blocks: (B:3:0x0002, B:13:0x0025, B:15:0x002d, B:17:0x0031, B:18:0x0034, B:20:0x0038, B:21:0x003b, B:31:0x005c, B:33:0x0064, B:43:0x0085, B:45:0x008d, B:55:0x00ad, B:57:0x00b5, B:59:0x00bb, B:65:0x00f2, B:66:0x010e, B:68:0x0112, B:70:0x0143, B:73:0x014c, B:74:0x0153, B:75:0x0154, B:76:0x015b, B:61:0x00be, B:63:0x00ea, B:77:0x015c, B:78:0x0163, B:79:0x0164, B:80:0x016b, B:81:0x016c, B:82:0x0177, B:54:0x00a9, B:48:0x0092, B:50:0x0098, B:83:0x0178, B:84:0x0183, B:42:0x0081, B:36:0x0069, B:38:0x006f, B:85:0x0184, B:86:0x018f, B:30:0x0058, B:24:0x0040, B:26:0x0046, B:87:0x0190, B:88:0x019b, B:12:0x0021, B:6:0x0008, B:8:0x000e), top: B:93:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x016c A[Catch: all -> 0x019c, TryCatch #1 {all -> 0x019c, blocks: (B:3:0x0002, B:13:0x0025, B:15:0x002d, B:17:0x0031, B:18:0x0034, B:20:0x0038, B:21:0x003b, B:31:0x005c, B:33:0x0064, B:43:0x0085, B:45:0x008d, B:55:0x00ad, B:57:0x00b5, B:59:0x00bb, B:65:0x00f2, B:66:0x010e, B:68:0x0112, B:70:0x0143, B:73:0x014c, B:74:0x0153, B:75:0x0154, B:76:0x015b, B:61:0x00be, B:63:0x00ea, B:77:0x015c, B:78:0x0163, B:79:0x0164, B:80:0x016b, B:81:0x016c, B:82:0x0177, B:54:0x00a9, B:48:0x0092, B:50:0x0098, B:83:0x0178, B:84:0x0183, B:42:0x0081, B:36:0x0069, B:38:0x006f, B:85:0x0184, B:86:0x018f, B:30:0x0058, B:24:0x0040, B:26:0x0046, B:87:0x0190, B:88:0x019b, B:12:0x0021, B:6:0x0008, B:8:0x000e), top: B:93:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0178 A[Catch: all -> 0x019c, TryCatch #1 {all -> 0x019c, blocks: (B:3:0x0002, B:13:0x0025, B:15:0x002d, B:17:0x0031, B:18:0x0034, B:20:0x0038, B:21:0x003b, B:31:0x005c, B:33:0x0064, B:43:0x0085, B:45:0x008d, B:55:0x00ad, B:57:0x00b5, B:59:0x00bb, B:65:0x00f2, B:66:0x010e, B:68:0x0112, B:70:0x0143, B:73:0x014c, B:74:0x0153, B:75:0x0154, B:76:0x015b, B:61:0x00be, B:63:0x00ea, B:77:0x015c, B:78:0x0163, B:79:0x0164, B:80:0x016b, B:81:0x016c, B:82:0x0177, B:54:0x00a9, B:48:0x0092, B:50:0x0098, B:83:0x0178, B:84:0x0183, B:42:0x0081, B:36:0x0069, B:38:0x006f, B:85:0x0184, B:86:0x018f, B:30:0x0058, B:24:0x0040, B:26:0x0046, B:87:0x0190, B:88:0x019b, B:12:0x0021, B:6:0x0008, B:8:0x000e), top: B:93:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0184 A[Catch: all -> 0x019c, TryCatch #1 {all -> 0x019c, blocks: (B:3:0x0002, B:13:0x0025, B:15:0x002d, B:17:0x0031, B:18:0x0034, B:20:0x0038, B:21:0x003b, B:31:0x005c, B:33:0x0064, B:43:0x0085, B:45:0x008d, B:55:0x00ad, B:57:0x00b5, B:59:0x00bb, B:65:0x00f2, B:66:0x010e, B:68:0x0112, B:70:0x0143, B:73:0x014c, B:74:0x0153, B:75:0x0154, B:76:0x015b, B:61:0x00be, B:63:0x00ea, B:77:0x015c, B:78:0x0163, B:79:0x0164, B:80:0x016b, B:81:0x016c, B:82:0x0177, B:54:0x00a9, B:48:0x0092, B:50:0x0098, B:83:0x0178, B:84:0x0183, B:42:0x0081, B:36:0x0069, B:38:0x006f, B:85:0x0184, B:86:0x018f, B:30:0x0058, B:24:0x0040, B:26:0x0046, B:87:0x0190, B:88:0x019b, B:12:0x0021, B:6:0x0008, B:8:0x000e), top: B:93:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0190 A[Catch: all -> 0x019c, TryCatch #1 {all -> 0x019c, blocks: (B:3:0x0002, B:13:0x0025, B:15:0x002d, B:17:0x0031, B:18:0x0034, B:20:0x0038, B:21:0x003b, B:31:0x005c, B:33:0x0064, B:43:0x0085, B:45:0x008d, B:55:0x00ad, B:57:0x00b5, B:59:0x00bb, B:65:0x00f2, B:66:0x010e, B:68:0x0112, B:70:0x0143, B:73:0x014c, B:74:0x0153, B:75:0x0154, B:76:0x015b, B:61:0x00be, B:63:0x00ea, B:77:0x015c, B:78:0x0163, B:79:0x0164, B:80:0x016b, B:81:0x016c, B:82:0x0177, B:54:0x00a9, B:48:0x0092, B:50:0x0098, B:83:0x0178, B:84:0x0183, B:42:0x0081, B:36:0x0069, B:38:0x006f, B:85:0x0184, B:86:0x018f, B:30:0x0058, B:24:0x0040, B:26:0x0046, B:87:0x0190, B:88:0x019b, B:12:0x0021, B:6:0x0008, B:8:0x000e), top: B:93:0x0002, inners: #0, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean MyBillsEntityDataFactory() {
        /*
            Method dump skipped, instructions count: 414
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.SidecarCompat.MyBillsEntityDataFactory():boolean");
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006R\u001e\u0010\f\u001a\f\u0012\b\u0012\u0006*\u00020\t0\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Landroidx/window/layout/SidecarCompat$FirstAttachAdapter;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "p0", "", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "MyBillsEntityDataFactory", "Ljava/lang/ref/WeakReference;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/window/layout/SidecarCompat;", "PlaceComponentResult", "Landroidx/window/layout/SidecarCompat;", "getAuthRequestContext", "p1", "<init>", "(Landroidx/window/layout/SidecarCompat;Landroid/app/Activity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    static final class FirstAttachAdapter implements View.OnAttachStateChangeListener {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        private final WeakReference<Activity> KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private final SidecarCompat getAuthRequestContext;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View p0) {
            Intrinsics.checkNotNullParameter(p0, "");
        }

        public FirstAttachAdapter(SidecarCompat sidecarCompat, Activity activity) {
            Intrinsics.checkNotNullParameter(sidecarCompat, "");
            Intrinsics.checkNotNullParameter(activity, "");
            this.getAuthRequestContext = sidecarCompat;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new WeakReference<>(activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.removeOnAttachStateChangeListener(this);
            Activity activity = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
            IBinder MyBillsEntityDataFactory = SidecarCompat.MyBillsEntityDataFactory.MyBillsEntityDataFactory(activity);
            if (activity == null || MyBillsEntityDataFactory == null) {
                return;
            }
            this.getAuthRequestContext.PlaceComponentResult(MyBillsEntityDataFactory, activity);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017¨\u0006\f"}, d2 = {"Landroidx/window/layout/SidecarCompat$TranslatingCallback;", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "(Landroidx/window/layout/SidecarCompat;)V", "onDeviceStateChanged", "", "newDeviceState", "Landroidx/window/sidecar/SidecarDeviceState;", "onWindowLayoutChanged", "windowToken", "Landroid/os/IBinder;", "newLayout", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class TranslatingCallback implements SidecarInterface.SidecarCallback {
        final /* synthetic */ SidecarCompat MyBillsEntityDataFactory;

        public TranslatingCallback(SidecarCompat sidecarCompat) {
            Intrinsics.checkNotNullParameter(sidecarCompat, "");
            this.MyBillsEntityDataFactory = sidecarCompat;
        }

        public final void onDeviceStateChanged(SidecarDeviceState newDeviceState) {
            SidecarInterface getAuthRequestContext;
            Intrinsics.checkNotNullParameter(newDeviceState, "");
            Collection<Activity> values = this.MyBillsEntityDataFactory.scheduleImpl.values();
            SidecarCompat sidecarCompat = this.MyBillsEntityDataFactory;
            for (Activity activity : values) {
                IBinder MyBillsEntityDataFactory = SidecarCompat.MyBillsEntityDataFactory.MyBillsEntityDataFactory(activity);
                SidecarWindowLayoutInfo sidecarWindowLayoutInfo = null;
                if (MyBillsEntityDataFactory != null && (getAuthRequestContext = sidecarCompat.getGetAuthRequestContext()) != null) {
                    sidecarWindowLayoutInfo = getAuthRequestContext.getWindowLayoutInfo(MyBillsEntityDataFactory);
                }
                ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = sidecarCompat.BuiltInFictitiousFunctionClassFactory;
                if (extensionCallbackInterface != null) {
                    extensionCallbackInterface.PlaceComponentResult(activity, sidecarCompat.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(sidecarWindowLayoutInfo, newDeviceState));
                }
            }
        }

        public final void onWindowLayoutChanged(IBinder windowToken, SidecarWindowLayoutInfo newLayout) {
            Intrinsics.checkNotNullParameter(windowToken, "");
            Intrinsics.checkNotNullParameter(newLayout, "");
            Activity activity = (Activity) this.MyBillsEntityDataFactory.scheduleImpl.get(windowToken);
            if (activity != null) {
                SidecarAdapter sidecarAdapter = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                SidecarInterface getAuthRequestContext = this.MyBillsEntityDataFactory.getGetAuthRequestContext();
                SidecarDeviceState deviceState = getAuthRequestContext == null ? null : getAuthRequestContext.getDeviceState();
                if (deviceState == null) {
                    deviceState = new SidecarDeviceState();
                }
                WindowLayoutInfo MyBillsEntityDataFactory = sidecarAdapter.MyBillsEntityDataFactory(newLayout, deviceState);
                ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
                if (extensionCallbackInterface != null) {
                    extensionCallbackInterface.PlaceComponentResult(activity, MyBillsEntityDataFactory);
                    return;
                }
                return;
            }
            InstrumentInjector.log_w("SidecarCompat", "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\nR\u0014\u0010\f\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u000f"}, d2 = {"Landroidx/window/layout/SidecarCompat$DistinctElementCallback;", "Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "Landroid/app/Activity;", "p0", "Landroidx/window/layout/WindowLayoutInfo;", "p1", "", "PlaceComponentResult", "(Landroid/app/Activity;Landroidx/window/layout/WindowLayoutInfo;)V", "Ljava/util/WeakHashMap;", "Ljava/util/WeakHashMap;", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    static final class DistinctElementCallback implements ExtensionInterfaceCompat.ExtensionCallbackInterface {
        private final ExtensionInterfaceCompat.ExtensionCallbackInterface KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private final WeakHashMap<Activity, WindowLayoutInfo> getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        private final ReentrantLock BuiltInFictitiousFunctionClassFactory;

        public DistinctElementCallback(ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface) {
            Intrinsics.checkNotNullParameter(extensionCallbackInterface, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = extensionCallbackInterface;
            this.BuiltInFictitiousFunctionClassFactory = new ReentrantLock();
            this.getAuthRequestContext = new WeakHashMap<>();
        }

        @Override // androidx.window.layout.ExtensionInterfaceCompat.ExtensionCallbackInterface
        public final void PlaceComponentResult(Activity p0, WindowLayoutInfo p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            ReentrantLock reentrantLock = this.BuiltInFictitiousFunctionClassFactory;
            reentrantLock.lock();
            try {
                if (Intrinsics.areEqual(p1, this.getAuthRequestContext.get(p0))) {
                    return;
                }
                this.getAuthRequestContext.put(p0, p1);
                reentrantLock.unlock();
                this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(p0, p1);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/window/layout/SidecarCompat$DistinctSidecarElementCallback;", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "sidecarAdapter", "Landroidx/window/layout/SidecarAdapter;", "callbackInterface", "(Landroidx/window/layout/SidecarAdapter;Landroidx/window/sidecar/SidecarInterface$SidecarCallback;)V", "lastDeviceState", "Landroidx/window/sidecar/SidecarDeviceState;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "mActivityWindowLayoutInfo", "Ljava/util/WeakHashMap;", "Landroid/os/IBinder;", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "onDeviceStateChanged", "", "newDeviceState", "onWindowLayoutChanged", "token", "newLayout", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    static final class DistinctSidecarElementCallback implements SidecarInterface.SidecarCallback {
        private final SidecarAdapter BuiltInFictitiousFunctionClassFactory;
        private SidecarDeviceState KClassImpl$Data$declaredNonStaticMembers$2;
        private final WeakHashMap<IBinder, SidecarWindowLayoutInfo> MyBillsEntityDataFactory;
        private final ReentrantLock PlaceComponentResult;
        private final SidecarInterface.SidecarCallback getAuthRequestContext;

        public DistinctSidecarElementCallback(SidecarAdapter sidecarAdapter, SidecarInterface.SidecarCallback sidecarCallback) {
            Intrinsics.checkNotNullParameter(sidecarAdapter, "");
            Intrinsics.checkNotNullParameter(sidecarCallback, "");
            this.BuiltInFictitiousFunctionClassFactory = sidecarAdapter;
            this.getAuthRequestContext = sidecarCallback;
            this.PlaceComponentResult = new ReentrantLock();
            this.MyBillsEntityDataFactory = new WeakHashMap<>();
        }

        public final void onDeviceStateChanged(SidecarDeviceState newDeviceState) {
            Intrinsics.checkNotNullParameter(newDeviceState, "");
            ReentrantLock reentrantLock = this.PlaceComponentResult;
            reentrantLock.lock();
            try {
                if (SidecarAdapter.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, newDeviceState)) {
                    return;
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2 = newDeviceState;
                this.getAuthRequestContext.onDeviceStateChanged(newDeviceState);
                Unit unit = Unit.INSTANCE;
            } finally {
                reentrantLock.unlock();
            }
        }

        public final void onWindowLayoutChanged(IBinder token, SidecarWindowLayoutInfo newLayout) {
            Intrinsics.checkNotNullParameter(token, "");
            Intrinsics.checkNotNullParameter(newLayout, "");
            synchronized (this.PlaceComponentResult) {
                if (SidecarAdapter.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.get(token), newLayout)) {
                    return;
                }
                this.MyBillsEntityDataFactory.put(token, newLayout);
                this.getAuthRequestContext.onWindowLayoutChanged(token, newLayout);
            }
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0002\b\rJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Landroidx/window/layout/SidecarCompat$Companion;", "", "()V", "TAG", "", "sidecarVersion", "Landroidx/window/core/Version;", "getSidecarVersion", "()Landroidx/window/core/Version;", "getActivityWindowToken", "Landroid/os/IBinder;", AkuEventParamsKey.KEY_ACTIVITY, "Landroid/app/Activity;", "getActivityWindowToken$window_release", "getSidecarCompat", "Landroidx/window/sidecar/SidecarInterface;", HummerConstants.CONTEXT, "Landroid/content/Context;", "getSidecarCompat$window_release", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Version getAuthRequestContext() {
            try {
                String apiVersion = SidecarProvider.getApiVersion();
                if (TextUtils.isEmpty(apiVersion)) {
                    return null;
                }
                Version.Companion companion = Version.INSTANCE;
                return Version.Companion.MyBillsEntityDataFactory(apiVersion);
            } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
                return null;
            }
        }

        public final SidecarInterface BuiltInFictitiousFunctionClassFactory(Context context) {
            Intrinsics.checkNotNullParameter(context, "");
            return SidecarProvider.getSidecarImpl(context.getApplicationContext());
        }

        public final IBinder MyBillsEntityDataFactory(Activity activity) {
            Window window;
            WindowManager.LayoutParams attributes;
            if (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) {
                return null;
            }
            return attributes.token;
        }
    }
}
