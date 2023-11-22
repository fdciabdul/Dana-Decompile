package com.alibaba.ariver.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppManager;
import com.alibaba.ariver.app.api.point.app.AppCreatePoint;
import com.alibaba.ariver.app.api.point.app.AppStartPoint;
import com.alibaba.ariver.app.api.service.TinyAppInnerProxy;
import com.alibaba.ariver.app.proxy.RVAppFactory;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.resource.api.prepare.PrepareAppInfoGetPoint;
import java.util.Iterator;
import java.util.Stack;

/* loaded from: classes6.dex */
public final class AppManagerImpl extends NodeInstance implements AppManager {
    public static final Parcelable.Creator<AppManagerImpl> CREATOR = new Parcelable.Creator<AppManagerImpl>() { // from class: com.alibaba.ariver.app.AppManagerImpl.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AppManagerImpl createFromParcel(Parcel parcel) {
            return new AppManagerImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AppManagerImpl[] newArray(int i) {
            return new AppManagerImpl[i];
        }
    };
    private final Stack<App> mAppStack;

    public AppManagerImpl() {
        this.mAppStack = new Stack<>();
    }

    public AppManagerImpl(Parcel parcel) {
        super(parcel);
        this.mAppStack = new Stack<>();
    }

    @Override // com.alibaba.ariver.app.api.AppManager
    public final Stack<App> getAppStack() {
        Stack<App> stack;
        synchronized (this) {
            stack = new Stack<>();
            Iterator<App> it = this.mAppStack.iterator();
            while (it.hasNext()) {
                stack.push(it.next());
            }
        }
        return stack;
    }

    @Override // com.alibaba.ariver.app.api.AppManager
    public final App startApp(final String str, Bundle bundle, Bundle bundle2) {
        final App findAppByToken;
        synchronized (this) {
            RVLogger.printPerformanceLog("App", "Start create app");
            RVTraceUtils.traceBeginSection(RVTraceKey.RV_App_createApp);
            findAppByToken = findAppByToken(BundleUtils.getLong(bundle2, RVConstants.EXTRA_START_TOKEN, 0L));
            if (findAppByToken != null) {
                findAppByToken.init(str, bundle, bundle2);
            } else {
                findAppByToken = ((RVAppFactory) RVProxy.get(RVAppFactory.class)).createApp();
                RVTraceUtils.traceEndSection(RVTraceKey.RV_App_createApp);
                findAppByToken.init(str, bundle, bundle2);
                pushChild(findAppByToken);
            }
            if (RVProxy.get(TinyAppInnerProxy.class) != null) {
                ExecutorUtils.runNotOnMain(ExecutorType.NORMAL, new Runnable() { // from class: com.alibaba.ariver.app.AppManagerImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        StringBuilder sb = new StringBuilder();
                        sb.append("appId = ");
                        sb.append(str);
                        sb.append(" isInner ");
                        sb.append(((TinyAppInnerProxy) RVProxy.get(TinyAppInnerProxy.class)).isInner(findAppByToken));
                        RVLogger.d("App", sb.toString());
                    }
                });
            }
            ((PrepareAppInfoGetPoint) ExtensionPoint.as(PrepareAppInfoGetPoint.class).node(findAppByToken).create()).onAppStart(findAppByToken, bundle, bundle2);
            RVTraceUtils.traceBeginSection(RVTraceKey.RV_App_onAppStart);
            ((AppStartPoint) ExtensionPoint.as(AppStartPoint.class).node(findAppByToken).create()).onAppStart(findAppByToken);
            RVTraceUtils.traceEndSection(RVTraceKey.RV_App_onAppStart);
            this.mAppStack.push(findAppByToken);
        }
        return findAppByToken;
    }

    @Override // com.alibaba.ariver.app.api.AppManager
    public final App preCreateApp(String str, Bundle bundle, Bundle bundle2) {
        AppNode createApp;
        synchronized (this) {
            createApp = ((RVAppFactory) RVProxy.get(RVAppFactory.class)).createApp();
            AppNode appNode = createApp;
            createApp.preCreateInit(str, bundle, bundle2);
            ((PrepareAppInfoGetPoint) ExtensionPoint.as(PrepareAppInfoGetPoint.class).node(createApp).create()).onAppPrepare(createApp, bundle, bundle2, null);
            ((AppCreatePoint) ExtensionPoint.as(AppCreatePoint.class).node(createApp).create()).onAppCreate(createApp);
            pushChild(createApp);
        }
        return createApp;
    }

    @Override // com.alibaba.ariver.app.api.AppManager
    public final App findAppByAppId(String str) {
        synchronized (this) {
            Iterator<App> it = this.mAppStack.iterator();
            while (it.hasNext()) {
                App next = it.next();
                if (TextUtils.equals(next.getAppId(), str)) {
                    return next;
                }
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                App app = (App) getChildAt(i);
                if (TextUtils.equals(app.getAppId(), str)) {
                    return app;
                }
            }
            return null;
        }
    }

    @Override // com.alibaba.ariver.app.api.AppManager
    public final App findApp(long j) {
        App app;
        synchronized (this) {
            app = (App) getChild(j);
        }
        return app;
    }

    @Override // com.alibaba.ariver.app.api.AppManager
    public final App findAppByToken(long j) {
        synchronized (this) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                App app = (App) getChildAt(i);
                if (app.getStartToken() == j) {
                    return app;
                }
            }
            return null;
        }
    }

    @Override // com.alibaba.ariver.app.api.AppManager
    public final void exitApp(long j) {
        synchronized (this) {
            App findApp = findApp(j);
            if (findApp != null) {
                findApp.exit();
                this.mAppStack.remove(findApp);
            }
            if (findApp != null) {
                removeChild(findApp);
            }
        }
    }

    @Override // com.alibaba.ariver.app.NodeInstance, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
