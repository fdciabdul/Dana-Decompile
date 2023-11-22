package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class GifFrameLoader {
    final BitmapPool BuiltInFictitiousFunctionClassFactory;
    int DatabaseTableConfigUtil;
    private final Handler GetContactSyncConfig;
    final List<FrameCallback> KClassImpl$Data$declaredNonStaticMembers$2;
    int MyBillsEntityDataFactory;
    boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    final RequestManager NetworkUserEntityData$$ExternalSyntheticLambda2;
    private Transformation<Bitmap> NetworkUserEntityData$$ExternalSyntheticLambda7;
    public Bitmap PlaceComponentResult;
    private OnEveryFrameListener PrepareContext;
    DelayTarget getAuthRequestContext;
    boolean getErrorConfigVersion;
    DelayTarget initRecordTimeStamp;
    private RequestBuilder<Bitmap> isLayoutRequested;
    DelayTarget lookAheadTest;
    public final GifDecoder moveToNextValue;
    private boolean newProxyInstance;
    int scheduleImpl;

    /* loaded from: classes3.dex */
    public interface FrameCallback {
        void MyBillsEntityDataFactory();
    }

    /* loaded from: classes3.dex */
    interface OnEveryFrameListener {
    }

    private GifFrameLoader(BitmapPool bitmapPool, RequestManager requestManager, GifDecoder gifDecoder, RequestBuilder<Bitmap> requestBuilder, Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = requestManager;
        Handler handler = new Handler(Looper.getMainLooper(), new FrameLoaderCallback());
        this.BuiltInFictitiousFunctionClassFactory = bitmapPool;
        this.GetContactSyncConfig = handler;
        this.isLayoutRequested = requestBuilder;
        this.moveToNextValue = gifDecoder;
        BuiltInFictitiousFunctionClassFactory(transformation, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory(Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = (Transformation) Preconditions.PlaceComponentResult(transformation);
        this.PlaceComponentResult = (Bitmap) Preconditions.PlaceComponentResult(bitmap);
        this.isLayoutRequested = this.isLayoutRequested.MyBillsEntityDataFactory((BaseRequestOptions<?>) new RequestOptions().MyBillsEntityDataFactory(transformation));
        this.MyBillsEntityDataFactory = Util.getAuthRequestContext(bitmap);
        this.DatabaseTableConfigUtil = bitmap.getWidth();
        this.scheduleImpl = bitmap.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void getAuthRequestContext() {
        Executor executor;
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0 || this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            return;
        }
        if (this.newProxyInstance) {
            Preconditions.BuiltInFictitiousFunctionClassFactory(this.initRecordTimeStamp == null, "Pending target must be null when starting from the first frame");
            this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda0();
            this.newProxyInstance = false;
        }
        DelayTarget delayTarget = this.initRecordTimeStamp;
        if (delayTarget != null) {
            this.initRecordTimeStamp = null;
            PlaceComponentResult(delayTarget);
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
        int lookAheadTest = this.moveToNextValue.lookAheadTest();
        this.moveToNextValue.BuiltInFictitiousFunctionClassFactory();
        this.lookAheadTest = new DelayTarget(this.GetContactSyncConfig, this.moveToNextValue.getAuthRequestContext(), SystemClock.uptimeMillis() + lookAheadTest);
        RequestBuilder<Bitmap> MyBillsEntityDataFactory = this.isLayoutRequested.MyBillsEntityDataFactory((BaseRequestOptions<?>) RequestOptions.BuiltInFictitiousFunctionClassFactory(new ObjectKey(Double.valueOf(Math.random())))).MyBillsEntityDataFactory(this.moveToNextValue);
        DelayTarget delayTarget2 = this.lookAheadTest;
        executor = Executors.PlaceComponentResult;
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(delayTarget2, null, MyBillsEntityDataFactory, executor);
    }

    final void PlaceComponentResult(DelayTarget delayTarget) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
        if (this.getErrorConfigVersion) {
            this.GetContactSyncConfig.obtainMessage(2, delayTarget).sendToTarget();
        } else if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            if (this.newProxyInstance) {
                this.GetContactSyncConfig.obtainMessage(2, delayTarget).sendToTarget();
            } else {
                this.initRecordTimeStamp = delayTarget;
            }
        } else {
            if (delayTarget.PlaceComponentResult != null) {
                Bitmap bitmap = this.PlaceComponentResult;
                if (bitmap != null) {
                    this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(bitmap);
                    this.PlaceComponentResult = null;
                }
                DelayTarget delayTarget2 = this.getAuthRequestContext;
                this.getAuthRequestContext = delayTarget;
                for (int size = this.KClassImpl$Data$declaredNonStaticMembers$2.size() - 1; size >= 0; size--) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.get(size).MyBillsEntityDataFactory();
                }
                if (delayTarget2 != null) {
                    this.GetContactSyncConfig.obtainMessage(2, delayTarget2).sendToTarget();
                }
            }
            getAuthRequestContext();
        }
    }

    /* loaded from: classes3.dex */
    class FrameLoaderCallback implements Handler.Callback {
        FrameLoaderCallback() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                GifFrameLoader.this.PlaceComponentResult((DelayTarget) message.obj);
                return true;
            } else if (message.what == 2) {
                GifFrameLoader.this.NetworkUserEntityData$$ExternalSyntheticLambda2.getAuthRequestContext((Target<?>) ((DelayTarget) message.obj));
                return false;
            } else {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class DelayTarget extends CustomTarget<Bitmap> {
        final int BuiltInFictitiousFunctionClassFactory;
        private final long MyBillsEntityDataFactory;
        Bitmap PlaceComponentResult;
        private final Handler getAuthRequestContext;

        @Override // com.bumptech.glide.request.target.Target
        public /* synthetic */ void onResourceReady(Object obj, Transition transition) {
            this.PlaceComponentResult = (Bitmap) obj;
            this.getAuthRequestContext.sendMessageAtTime(this.getAuthRequestContext.obtainMessage(1, this), this.MyBillsEntityDataFactory);
        }

        DelayTarget(Handler handler, int i, long j) {
            this.getAuthRequestContext = handler;
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.MyBillsEntityDataFactory = j;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable drawable) {
            this.PlaceComponentResult = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GifFrameLoader(com.bumptech.glide.Glide r8, com.bumptech.glide.gifdecoder.GifDecoder r9, int r10, int r11, com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r12, android.graphics.Bitmap r13) {
        /*
            r7 = this;
            com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r1 = r8.BuiltInFictitiousFunctionClassFactory
            com.bumptech.glide.GlideContext r0 = r8.MyBillsEntityDataFactory
            android.content.Context r0 = r0.getBaseContext()
            com.bumptech.glide.RequestManager r2 = com.bumptech.glide.Glide.KClassImpl$Data$declaredNonStaticMembers$2(r0)
            com.bumptech.glide.GlideContext r8 = r8.MyBillsEntityDataFactory
            android.content.Context r8 = r8.getBaseContext()
            com.bumptech.glide.RequestManager r8 = com.bumptech.glide.Glide.KClassImpl$Data$declaredNonStaticMembers$2(r8)
            com.bumptech.glide.RequestBuilder r8 = r8.PlaceComponentResult()
            com.bumptech.glide.load.engine.DiskCacheStrategy r0 = com.bumptech.glide.load.engine.DiskCacheStrategy.MyBillsEntityDataFactory
            com.bumptech.glide.request.RequestOptions r0 = com.bumptech.glide.request.RequestOptions.KClassImpl$Data$declaredNonStaticMembers$2(r0)
            r3 = 1
            com.bumptech.glide.request.BaseRequestOptions r0 = r0.PlaceComponentResult(r3)
            com.bumptech.glide.request.RequestOptions r0 = (com.bumptech.glide.request.RequestOptions) r0
            com.bumptech.glide.request.BaseRequestOptions r0 = r0.getAuthRequestContext(r3)
            com.bumptech.glide.request.RequestOptions r0 = (com.bumptech.glide.request.RequestOptions) r0
            com.bumptech.glide.request.BaseRequestOptions r10 = r0.PlaceComponentResult(r10, r11)
            com.bumptech.glide.RequestBuilder r4 = r8.MyBillsEntityDataFactory(r10)
            r0 = r7
            r3 = r9
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.gif.GifFrameLoader.<init>(com.bumptech.glide.Glide, com.bumptech.glide.gifdecoder.GifDecoder, int, int, com.bumptech.glide.load.Transformation, android.graphics.Bitmap):void");
    }
}
