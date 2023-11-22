package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.TargetTracker;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class RequestManager implements ComponentCallbacks2, LifecycleListener, ModelTypes<RequestBuilder<Drawable>> {
    private static final RequestOptions NetworkUserEntityData$$ExternalSyntheticLambda0;
    private static final RequestOptions getErrorConfigVersion;
    private static final RequestOptions scheduleImpl;
    final Lifecycle BuiltInFictitiousFunctionClassFactory;
    private boolean DatabaseTableConfigUtil;
    final RequestTracker KClassImpl$Data$declaredNonStaticMembers$2;
    final CopyOnWriteArrayList<RequestListener<Object>> MyBillsEntityDataFactory;
    private final RequestManagerTreeNode NetworkUserEntityData$$ExternalSyntheticLambda1;
    private RequestOptions NetworkUserEntityData$$ExternalSyntheticLambda2;
    protected final Context PlaceComponentResult;
    protected final Glide getAuthRequestContext;
    private final ConnectivityMonitor initRecordTimeStamp;
    private final Runnable lookAheadTest;
    final TargetTracker moveToNextValue;

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    static {
        RequestOptions authRequestContext;
        RequestOptions authRequestContext2;
        RequestOptions BuiltInFictitiousFunctionClassFactory;
        authRequestContext = new RequestOptions().getAuthRequestContext(Bitmap.class);
        scheduleImpl = authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda5();
        authRequestContext2 = new RequestOptions().getAuthRequestContext(GifDrawable.class);
        NetworkUserEntityData$$ExternalSyntheticLambda0 = authRequestContext2.NetworkUserEntityData$$ExternalSyntheticLambda5();
        BuiltInFictitiousFunctionClassFactory = new RequestOptions().BuiltInFictitiousFunctionClassFactory(DiskCacheStrategy.BuiltInFictitiousFunctionClassFactory);
        getErrorConfigVersion = BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(Priority.LOW).getAuthRequestContext(true);
    }

    public RequestManager(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
        this(glide, lifecycle, requestManagerTreeNode, new RequestTracker(), glide.getAuthRequestContext, context);
    }

    private RequestManager(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, RequestTracker requestTracker, ConnectivityMonitorFactory connectivityMonitorFactory, Context context) {
        this.moveToNextValue = new TargetTracker();
        Runnable runnable = new Runnable() { // from class: com.bumptech.glide.RequestManager.1
            @Override // java.lang.Runnable
            public void run() {
                RequestManager.this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(RequestManager.this);
            }
        };
        this.lookAheadTest = runnable;
        this.getAuthRequestContext = glide;
        this.BuiltInFictitiousFunctionClassFactory = lifecycle;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = requestManagerTreeNode;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = requestTracker;
        this.PlaceComponentResult = context;
        ConnectivityMonitor MyBillsEntityDataFactory = connectivityMonitorFactory.MyBillsEntityDataFactory(context.getApplicationContext(), new RequestManagerConnectivityListener(requestTracker));
        this.initRecordTimeStamp = MyBillsEntityDataFactory;
        if (Util.PlaceComponentResult()) {
            Util.BuiltInFictitiousFunctionClassFactory(runnable);
        } else {
            lifecycle.PlaceComponentResult(this);
        }
        lifecycle.PlaceComponentResult(MyBillsEntityDataFactory);
        this.MyBillsEntityDataFactory = new CopyOnWriteArrayList<>(glide.MyBillsEntityDataFactory.MyBillsEntityDataFactory);
        PlaceComponentResult(glide.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory());
        synchronized (glide.KClassImpl$Data$declaredNonStaticMembers$2) {
            if (glide.KClassImpl$Data$declaredNonStaticMembers$2.contains(this)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            glide.KClassImpl$Data$declaredNonStaticMembers$2.add(this);
        }
    }

    public void PlaceComponentResult(RequestOptions requestOptions) {
        synchronized (this) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = requestOptions.clone().getAuthRequestContext();
        }
    }

    private void BuiltInFictitiousFunctionClassFactory() {
        synchronized (this) {
            RequestTracker requestTracker = this.KClassImpl$Data$declaredNonStaticMembers$2;
            requestTracker.MyBillsEntityDataFactory = true;
            for (Request request : Util.KClassImpl$Data$declaredNonStaticMembers$2(requestTracker.KClassImpl$Data$declaredNonStaticMembers$2)) {
                if (request.moveToNextValue() || request.scheduleImpl()) {
                    request.KClassImpl$Data$declaredNonStaticMembers$2();
                    requestTracker.BuiltInFictitiousFunctionClassFactory.add(request);
                }
            }
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        synchronized (this) {
            synchronized (this) {
                RequestTracker requestTracker = this.KClassImpl$Data$declaredNonStaticMembers$2;
                requestTracker.MyBillsEntityDataFactory = false;
                for (Request request : Util.KClassImpl$Data$declaredNonStaticMembers$2(requestTracker.KClassImpl$Data$declaredNonStaticMembers$2)) {
                    if (!request.scheduleImpl() && !request.moveToNextValue()) {
                        request.PlaceComponentResult();
                    }
                }
                requestTracker.BuiltInFictitiousFunctionClassFactory.clear();
            }
        }
        this.moveToNextValue.onStart();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        synchronized (this) {
            synchronized (this) {
                RequestTracker requestTracker = this.KClassImpl$Data$declaredNonStaticMembers$2;
                requestTracker.MyBillsEntityDataFactory = true;
                for (Request request : Util.KClassImpl$Data$declaredNonStaticMembers$2(requestTracker.KClassImpl$Data$declaredNonStaticMembers$2)) {
                    if (request.moveToNextValue()) {
                        request.lookAheadTest();
                        requestTracker.BuiltInFictitiousFunctionClassFactory.add(request);
                    }
                }
            }
        }
        this.moveToNextValue.onStop();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
        synchronized (this) {
            this.moveToNextValue.onDestroy();
            for (Target<?> target : Util.KClassImpl$Data$declaredNonStaticMembers$2(this.moveToNextValue.PlaceComponentResult)) {
                if (target != null) {
                    MyBillsEntityDataFactory(target);
                }
            }
            this.moveToNextValue.PlaceComponentResult.clear();
            RequestTracker requestTracker = this.KClassImpl$Data$declaredNonStaticMembers$2;
            Iterator it = Util.KClassImpl$Data$declaredNonStaticMembers$2(requestTracker.KClassImpl$Data$declaredNonStaticMembers$2).iterator();
            while (it.hasNext()) {
                requestTracker.PlaceComponentResult((Request) it.next());
            }
            requestTracker.BuiltInFictitiousFunctionClassFactory.clear();
            this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(this);
            this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(this.initRecordTimeStamp);
            Util.KClassImpl$Data$declaredNonStaticMembers$2().removeCallbacks(this.lookAheadTest);
            Glide glide = this.getAuthRequestContext;
            synchronized (glide.KClassImpl$Data$declaredNonStaticMembers$2) {
                if (!glide.KClassImpl$Data$declaredNonStaticMembers$2.contains(this)) {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                }
                glide.KClassImpl$Data$declaredNonStaticMembers$2.remove(this);
            }
        }
    }

    public RequestBuilder<Bitmap> PlaceComponentResult() {
        return BuiltInFictitiousFunctionClassFactory(Bitmap.class).MyBillsEntityDataFactory((BaseRequestOptions<?>) scheduleImpl);
    }

    public RequestBuilder<Drawable> KClassImpl$Data$declaredNonStaticMembers$2() {
        return BuiltInFictitiousFunctionClassFactory(Drawable.class);
    }

    public RequestBuilder<Drawable> PlaceComponentResult(Bitmap bitmap) {
        return KClassImpl$Data$declaredNonStaticMembers$2().PlaceComponentResult(bitmap);
    }

    public RequestBuilder<Drawable> MyBillsEntityDataFactory(Drawable drawable) {
        return KClassImpl$Data$declaredNonStaticMembers$2().getAuthRequestContext(drawable);
    }

    public RequestBuilder<Drawable> getAuthRequestContext(String str) {
        return KClassImpl$Data$declaredNonStaticMembers$2().PlaceComponentResult(str);
    }

    public RequestBuilder<Drawable> KClassImpl$Data$declaredNonStaticMembers$2(Uri uri) {
        return KClassImpl$Data$declaredNonStaticMembers$2().getAuthRequestContext(uri);
    }

    public RequestBuilder<Drawable> getAuthRequestContext(Integer num) {
        return KClassImpl$Data$declaredNonStaticMembers$2().getAuthRequestContext(num);
    }

    public RequestBuilder<Drawable> getAuthRequestContext(Object obj) {
        return KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory(obj);
    }

    public <ResourceType> RequestBuilder<ResourceType> BuiltInFictitiousFunctionClassFactory(Class<ResourceType> cls) {
        return new RequestBuilder<>(this.getAuthRequestContext, this, cls, this.PlaceComponentResult);
    }

    public final void getAuthRequestContext(Target<?> target) {
        if (target == null) {
            return;
        }
        MyBillsEntityDataFactory(target);
    }

    private void MyBillsEntityDataFactory(Target<?> target) {
        boolean PlaceComponentResult = PlaceComponentResult(target);
        Request request = target.getRequest();
        if (PlaceComponentResult || this.getAuthRequestContext.PlaceComponentResult(target) || request == null) {
            return;
        }
        target.setRequest(null);
        request.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean PlaceComponentResult(Target<?> target) {
        synchronized (this) {
            Request request = target.getRequest();
            if (request == null) {
                return true;
            }
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(request)) {
                this.moveToNextValue.PlaceComponentResult.remove(target);
                target.setRequest(null);
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final RequestOptions getAuthRequestContext() {
        RequestOptions requestOptions;
        synchronized (this) {
            requestOptions = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        }
        return requestOptions;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <T> TransitionOptions<?, T> getAuthRequestContext(Class<T> cls) {
        GlideContext glideContext = this.getAuthRequestContext.MyBillsEntityDataFactory;
        TransitionOptions<?, T> transitionOptions = (TransitionOptions<?, T>) glideContext.KClassImpl$Data$declaredNonStaticMembers$2.get(cls);
        if (transitionOptions == null) {
            for (Map.Entry<Class<?>, TransitionOptions<?, ?>> entry : glideContext.KClassImpl$Data$declaredNonStaticMembers$2.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    transitionOptions = (TransitionOptions<?, T>) entry.getValue();
                }
            }
        }
        return transitionOptions == null ? (TransitionOptions<?, T>) GlideContext.PlaceComponentResult : transitionOptions;
    }

    public String toString() {
        String obj;
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append("{tracker=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", treeNode=");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            sb.append("}");
            obj = sb.toString();
        }
        return obj;
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (i == 60 && this.DatabaseTableConfigUtil) {
            synchronized (this) {
                BuiltInFictitiousFunctionClassFactory();
                Iterator<RequestManager> it = this.NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory().iterator();
                while (it.hasNext()) {
                    it.next().BuiltInFictitiousFunctionClassFactory();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    class RequestManagerConnectivityListener implements ConnectivityMonitor.ConnectivityListener {
        private final RequestTracker KClassImpl$Data$declaredNonStaticMembers$2;

        RequestManagerConnectivityListener(RequestTracker requestTracker) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = requestTracker;
        }

        @Override // com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener
        public final void MyBillsEntityDataFactory(boolean z) {
            if (z) {
                synchronized (RequestManager.this) {
                    RequestTracker requestTracker = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    for (Request request : Util.KClassImpl$Data$declaredNonStaticMembers$2(requestTracker.KClassImpl$Data$declaredNonStaticMembers$2)) {
                        if (!request.scheduleImpl() && !request.MyBillsEntityDataFactory()) {
                            request.KClassImpl$Data$declaredNonStaticMembers$2();
                            if (!requestTracker.MyBillsEntityDataFactory) {
                                request.PlaceComponentResult();
                            } else {
                                requestTracker.BuiltInFictitiousFunctionClassFactory.add(request);
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class ClearTarget extends CustomViewTarget<View, Object> {
        @Override // com.bumptech.glide.request.target.CustomViewTarget
        public final void MyBillsEntityDataFactory(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(Object obj, Transition<? super Object> transition) {
        }

        public ClearTarget(View view) {
            super(view);
        }
    }
}
