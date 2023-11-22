package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.ErrorRequestCoordinator;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.signature.AndroidResourceSignature;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class RequestBuilder<TranscodeType> extends BaseRequestOptions<RequestBuilder<TranscodeType>> implements Cloneable, ModelTypes<RequestBuilder<TranscodeType>> {
    protected static final RequestOptions PlaceComponentResult = new RequestOptions().BuiltInFictitiousFunctionClassFactory(DiskCacheStrategy.BuiltInFictitiousFunctionClassFactory).KClassImpl$Data$declaredNonStaticMembers$2(Priority.LOW).getAuthRequestContext(true);
    private boolean FragmentBottomSheetPaymentSettingBinding;
    private final Context GetContactSyncConfig;
    private Float NetworkUserEntityData$$ExternalSyntheticLambda3;
    private List<RequestListener<TranscodeType>> NetworkUserEntityData$$ExternalSyntheticLambda4;
    private Object NetworkUserEntityData$$ExternalSyntheticLambda5;
    private final RequestManager NetworkUserEntityData$$ExternalSyntheticLambda6;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final Glide NetworkUserEntityData$$ExternalSyntheticLambda8;
    private final GlideContext PrepareContext;
    private final Class<TranscodeType> SubSequence;
    private RequestBuilder<TranscodeType> isLayoutRequested;
    private boolean newProxyInstance = true;
    private TransitionOptions<?, ? super TranscodeType> readMicros;
    private RequestBuilder<TranscodeType> whenAvailable;

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* synthetic */ BaseRequestOptions PlaceComponentResult(BaseRequestOptions baseRequestOptions) {
        return MyBillsEntityDataFactory((BaseRequestOptions<?>) baseRequestOptions);
    }

    public RequestBuilder(Glide glide, RequestManager requestManager, Class<TranscodeType> cls, Context context) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = glide;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = requestManager;
        this.SubSequence = cls;
        this.GetContactSyncConfig = context;
        this.readMicros = requestManager.getAuthRequestContext((Class) cls);
        this.PrepareContext = glide.MyBillsEntityDataFactory;
        Iterator<RequestListener<Object>> it = requestManager.MyBillsEntityDataFactory.iterator();
        while (it.hasNext()) {
            KClassImpl$Data$declaredNonStaticMembers$2(it.next());
        }
        MyBillsEntityDataFactory((BaseRequestOptions<?>) requestManager.getAuthRequestContext());
    }

    public RequestBuilder<TranscodeType> MyBillsEntityDataFactory(BaseRequestOptions<?> baseRequestOptions) {
        Preconditions.PlaceComponentResult(baseRequestOptions);
        return (RequestBuilder) super.PlaceComponentResult(baseRequestOptions);
    }

    public RequestBuilder<TranscodeType> getAuthRequestContext(RequestListener<TranscodeType> requestListener) {
        if (GetContactSyncConfig()) {
            return MyBillsEntityDataFactory().getAuthRequestContext(requestListener);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = null;
        return KClassImpl$Data$declaredNonStaticMembers$2(requestListener);
    }

    public RequestBuilder<TranscodeType> KClassImpl$Data$declaredNonStaticMembers$2(RequestListener<TranscodeType> requestListener) {
        if (GetContactSyncConfig()) {
            return MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2(requestListener);
        }
        if (requestListener != null) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda4 == null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda4 = new ArrayList();
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda4.add(requestListener);
        }
        return getCallingPid();
    }

    public RequestBuilder<TranscodeType> BuiltInFictitiousFunctionClassFactory(RequestBuilder<TranscodeType> requestBuilder) {
        if (GetContactSyncConfig()) {
            return MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(requestBuilder);
        }
        this.isLayoutRequested = requestBuilder;
        return getCallingPid();
    }

    public RequestBuilder<TranscodeType> MyBillsEntityDataFactory(Object obj) {
        return PlaceComponentResult(obj);
    }

    private RequestBuilder<TranscodeType> PlaceComponentResult(Object obj) {
        RequestBuilder<TranscodeType> requestBuilder = this;
        while (requestBuilder.GetContactSyncConfig()) {
            requestBuilder = requestBuilder.MyBillsEntityDataFactory();
        }
        requestBuilder.NetworkUserEntityData$$ExternalSyntheticLambda5 = obj;
        requestBuilder.NetworkUserEntityData$$ExternalSyntheticLambda7 = true;
        return requestBuilder.getCallingPid();
    }

    public RequestBuilder<TranscodeType> PlaceComponentResult(Bitmap bitmap) {
        RequestOptions BuiltInFictitiousFunctionClassFactory;
        RequestBuilder<TranscodeType> PlaceComponentResult2 = PlaceComponentResult((Object) bitmap);
        BuiltInFictitiousFunctionClassFactory = new RequestOptions().BuiltInFictitiousFunctionClassFactory(DiskCacheStrategy.MyBillsEntityDataFactory);
        return PlaceComponentResult2.MyBillsEntityDataFactory((BaseRequestOptions<?>) BuiltInFictitiousFunctionClassFactory);
    }

    public RequestBuilder<TranscodeType> getAuthRequestContext(Drawable drawable) {
        RequestOptions BuiltInFictitiousFunctionClassFactory;
        RequestBuilder<TranscodeType> PlaceComponentResult2 = PlaceComponentResult((Object) drawable);
        BuiltInFictitiousFunctionClassFactory = new RequestOptions().BuiltInFictitiousFunctionClassFactory(DiskCacheStrategy.MyBillsEntityDataFactory);
        return PlaceComponentResult2.MyBillsEntityDataFactory((BaseRequestOptions<?>) BuiltInFictitiousFunctionClassFactory);
    }

    public RequestBuilder<TranscodeType> PlaceComponentResult(String str) {
        return PlaceComponentResult((Object) str);
    }

    public RequestBuilder<TranscodeType> getAuthRequestContext(Uri uri) {
        return PlaceComponentResult(uri);
    }

    public RequestBuilder<TranscodeType> getAuthRequestContext(Integer num) {
        return PlaceComponentResult(num).MyBillsEntityDataFactory((BaseRequestOptions<?>) RequestOptions.BuiltInFictitiousFunctionClassFactory(AndroidResourceSignature.getAuthRequestContext(this.GetContactSyncConfig)));
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: BuiltInFictitiousFunctionClassFactory */
    public RequestBuilder<TranscodeType> clone() {
        RequestBuilder<TranscodeType> requestBuilder = (RequestBuilder) super.clone();
        requestBuilder.readMicros = (TransitionOptions<?, ? super TranscodeType>) requestBuilder.readMicros.clone();
        if (requestBuilder.NetworkUserEntityData$$ExternalSyntheticLambda4 != null) {
            requestBuilder.NetworkUserEntityData$$ExternalSyntheticLambda4 = new ArrayList(requestBuilder.NetworkUserEntityData$$ExternalSyntheticLambda4);
        }
        RequestBuilder<TranscodeType> requestBuilder2 = requestBuilder.whenAvailable;
        if (requestBuilder2 != null) {
            requestBuilder.whenAvailable = requestBuilder2.MyBillsEntityDataFactory();
        }
        RequestBuilder<TranscodeType> requestBuilder3 = requestBuilder.isLayoutRequested;
        if (requestBuilder3 != null) {
            requestBuilder.isLayoutRequested = requestBuilder3.MyBillsEntityDataFactory();
        }
        return requestBuilder;
    }

    public final <Y extends Target<TranscodeType>> Y BuiltInFictitiousFunctionClassFactory(Y y, RequestListener<TranscodeType> requestListener, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        Preconditions.PlaceComponentResult(y);
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        Request MyBillsEntityDataFactory = MyBillsEntityDataFactory(new Object(), y, requestListener, null, this.readMicros, baseRequestOptions.initRecordTimeStamp(), baseRequestOptions.NetworkUserEntityData$$ExternalSyntheticLambda1(), baseRequestOptions.moveToNextValue(), baseRequestOptions, executor);
        Request request = y.getRequest();
        if (MyBillsEntityDataFactory.getAuthRequestContext(request) && !PlaceComponentResult(baseRequestOptions, request)) {
            if (!((Request) Preconditions.PlaceComponentResult(request)).moveToNextValue()) {
                request.PlaceComponentResult();
            }
            return y;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda6.getAuthRequestContext((Target<?>) y);
        y.setRequest(MyBillsEntityDataFactory);
        RequestManager requestManager = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        synchronized (requestManager) {
            requestManager.moveToNextValue.PlaceComponentResult.add(y);
            RequestTracker requestTracker = requestManager.KClassImpl$Data$declaredNonStaticMembers$2;
            requestTracker.KClassImpl$Data$declaredNonStaticMembers$2.add(MyBillsEntityDataFactory);
            if (!requestTracker.MyBillsEntityDataFactory) {
                MyBillsEntityDataFactory.PlaceComponentResult();
            } else {
                MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
                if (Log.isLoggable("RequestTracker", 2)) {
                    InstrumentInjector.log_v("RequestTracker", "Paused, delaying request");
                }
                requestTracker.BuiltInFictitiousFunctionClassFactory.add(MyBillsEntityDataFactory);
            }
        }
        return y;
    }

    private static boolean PlaceComponentResult(BaseRequestOptions<?> baseRequestOptions, Request request) {
        return !baseRequestOptions.NetworkUserEntityData$$ExternalSyntheticLambda8() && request.scheduleImpl();
    }

    public final ViewTarget<ImageView, TranscodeType> MyBillsEntityDataFactory(ImageView imageView) {
        RequestBuilder<TranscodeType> requestBuilder;
        Executor executor;
        Util.BuiltInFictitiousFunctionClassFactory();
        Preconditions.PlaceComponentResult(imageView);
        if (!FragmentBottomSheetPaymentSettingBinding() && NetworkUserEntityData$$ExternalSyntheticLambda7() && imageView.getScaleType() != null) {
            switch (AnonymousClass1.KClassImpl$Data$declaredNonStaticMembers$2[imageView.getScaleType().ordinal()]) {
                case 1:
                    requestBuilder = clone().NetworkUserEntityData$$ExternalSyntheticLambda3();
                    break;
                case 2:
                    requestBuilder = clone().NetworkUserEntityData$$ExternalSyntheticLambda6();
                    break;
                case 3:
                case 4:
                case 5:
                    requestBuilder = clone().readMicros();
                    break;
                case 6:
                    requestBuilder = clone().NetworkUserEntityData$$ExternalSyntheticLambda6();
                    break;
            }
            GlideContext glideContext = this.PrepareContext;
            Class<TranscodeType> cls = this.SubSequence;
            ImageViewTargetFactory imageViewTargetFactory = glideContext.moveToNextValue;
            ViewTarget PlaceComponentResult2 = ImageViewTargetFactory.PlaceComponentResult(imageView, cls);
            executor = Executors.PlaceComponentResult;
            return (ViewTarget) BuiltInFictitiousFunctionClassFactory(PlaceComponentResult2, null, requestBuilder, executor);
        }
        requestBuilder = this;
        GlideContext glideContext2 = this.PrepareContext;
        Class<TranscodeType> cls2 = this.SubSequence;
        ImageViewTargetFactory imageViewTargetFactory2 = glideContext2.moveToNextValue;
        ViewTarget PlaceComponentResult22 = ImageViewTargetFactory.PlaceComponentResult(imageView, cls2);
        executor = Executors.PlaceComponentResult;
        return (ViewTarget) BuiltInFictitiousFunctionClassFactory(PlaceComponentResult22, null, requestBuilder, executor);
    }

    /* renamed from: com.bumptech.glide.RequestBuilder$1 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;
        static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[Priority.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr;
            try {
                iArr[Priority.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Priority.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Priority.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Priority.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private Priority BuiltInFictitiousFunctionClassFactory(Priority priority) {
        int i = AnonymousClass1.BuiltInFictitiousFunctionClassFactory[priority.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3 || i == 4) {
                    return Priority.IMMEDIATE;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("unknown priority: ");
                sb.append(initRecordTimeStamp());
                throw new IllegalArgumentException(sb.toString());
            }
            return Priority.HIGH;
        }
        return Priority.NORMAL;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.bumptech.glide.request.BaseRequestOptions] */
    private Request MyBillsEntityDataFactory(Object obj, Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i, int i2, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        ErrorRequestCoordinator errorRequestCoordinator;
        ErrorRequestCoordinator errorRequestCoordinator2;
        ThumbnailRequestCoordinator KClassImpl$Data$declaredNonStaticMembers$2;
        Priority BuiltInFictitiousFunctionClassFactory;
        if (this.isLayoutRequested != null) {
            ErrorRequestCoordinator errorRequestCoordinator3 = new ErrorRequestCoordinator(obj, requestCoordinator);
            errorRequestCoordinator = errorRequestCoordinator3;
            errorRequestCoordinator2 = errorRequestCoordinator3;
        } else {
            errorRequestCoordinator = null;
            errorRequestCoordinator2 = requestCoordinator;
        }
        RequestBuilder<TranscodeType> requestBuilder = this.whenAvailable;
        if (requestBuilder != null) {
            if (this.FragmentBottomSheetPaymentSettingBinding) {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            TransitionOptions<?, ? super TranscodeType> transitionOptions2 = requestBuilder.newProxyInstance ? transitionOptions : requestBuilder.readMicros;
            if (requestBuilder.newProxyInstance()) {
                BuiltInFictitiousFunctionClassFactory = this.whenAvailable.initRecordTimeStamp();
            } else {
                BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(priority);
            }
            Priority priority2 = BuiltInFictitiousFunctionClassFactory;
            int NetworkUserEntityData$$ExternalSyntheticLambda1 = this.whenAvailable.NetworkUserEntityData$$ExternalSyntheticLambda1();
            int moveToNextValue = this.whenAvailable.moveToNextValue();
            if (Util.KClassImpl$Data$declaredNonStaticMembers$2(i, i2) && !this.whenAvailable.NetworkUserEntityData$$ExternalSyntheticLambda4()) {
                NetworkUserEntityData$$ExternalSyntheticLambda1 = baseRequestOptions.NetworkUserEntityData$$ExternalSyntheticLambda1();
                moveToNextValue = baseRequestOptions.moveToNextValue();
            }
            ThumbnailRequestCoordinator thumbnailRequestCoordinator = new ThumbnailRequestCoordinator(obj, errorRequestCoordinator2);
            ThumbnailRequestCoordinator thumbnailRequestCoordinator2 = thumbnailRequestCoordinator;
            Request KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(obj, target, requestListener, baseRequestOptions, thumbnailRequestCoordinator, transitionOptions, priority, i, i2, executor);
            this.FragmentBottomSheetPaymentSettingBinding = true;
            RequestBuilder<TranscodeType> requestBuilder2 = this.whenAvailable;
            Request MyBillsEntityDataFactory = requestBuilder2.MyBillsEntityDataFactory(obj, target, requestListener, thumbnailRequestCoordinator2, transitionOptions2, priority2, NetworkUserEntityData$$ExternalSyntheticLambda1, moveToNextValue, requestBuilder2, executor);
            this.FragmentBottomSheetPaymentSettingBinding = false;
            thumbnailRequestCoordinator2.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$22;
            thumbnailRequestCoordinator2.KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory;
            KClassImpl$Data$declaredNonStaticMembers$2 = thumbnailRequestCoordinator2;
        } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda3 != null) {
            ThumbnailRequestCoordinator thumbnailRequestCoordinator3 = new ThumbnailRequestCoordinator(obj, errorRequestCoordinator2);
            Request KClassImpl$Data$declaredNonStaticMembers$23 = KClassImpl$Data$declaredNonStaticMembers$2(obj, target, requestListener, baseRequestOptions, thumbnailRequestCoordinator3, transitionOptions, priority, i, i2, executor);
            Request KClassImpl$Data$declaredNonStaticMembers$24 = KClassImpl$Data$declaredNonStaticMembers$2(obj, target, requestListener, baseRequestOptions.clone().KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda3.floatValue()), thumbnailRequestCoordinator3, transitionOptions, BuiltInFictitiousFunctionClassFactory(priority), i, i2, executor);
            thumbnailRequestCoordinator3.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$23;
            thumbnailRequestCoordinator3.KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$24;
            KClassImpl$Data$declaredNonStaticMembers$2 = thumbnailRequestCoordinator3;
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(obj, target, requestListener, baseRequestOptions, errorRequestCoordinator2, transitionOptions, priority, i, i2, executor);
        }
        if (errorRequestCoordinator == null) {
            return KClassImpl$Data$declaredNonStaticMembers$2;
        }
        int NetworkUserEntityData$$ExternalSyntheticLambda12 = this.isLayoutRequested.NetworkUserEntityData$$ExternalSyntheticLambda1();
        int moveToNextValue2 = this.isLayoutRequested.moveToNextValue();
        if (Util.KClassImpl$Data$declaredNonStaticMembers$2(i, i2) && !this.isLayoutRequested.NetworkUserEntityData$$ExternalSyntheticLambda4()) {
            NetworkUserEntityData$$ExternalSyntheticLambda12 = baseRequestOptions.NetworkUserEntityData$$ExternalSyntheticLambda1();
            moveToNextValue2 = baseRequestOptions.moveToNextValue();
        }
        RequestBuilder<TranscodeType> requestBuilder3 = this.isLayoutRequested;
        Request MyBillsEntityDataFactory2 = requestBuilder3.MyBillsEntityDataFactory(obj, target, requestListener, errorRequestCoordinator, requestBuilder3.readMicros, requestBuilder3.initRecordTimeStamp(), NetworkUserEntityData$$ExternalSyntheticLambda12, moveToNextValue2, this.isLayoutRequested, executor);
        errorRequestCoordinator.getAuthRequestContext = KClassImpl$Data$declaredNonStaticMembers$2;
        errorRequestCoordinator.PlaceComponentResult = MyBillsEntityDataFactory2;
        return errorRequestCoordinator;
    }

    private Request KClassImpl$Data$declaredNonStaticMembers$2(Object obj, Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, BaseRequestOptions<?> baseRequestOptions, RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i, int i2, Executor executor) {
        Context context = this.GetContactSyncConfig;
        GlideContext glideContext = this.PrepareContext;
        return SingleRequest.getAuthRequestContext(context, glideContext, obj, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.SubSequence, baseRequestOptions, i, i2, priority, target, requestListener, this.NetworkUserEntityData$$ExternalSyntheticLambda4, requestCoordinator, glideContext.getAuthRequestContext, transitionOptions.KClassImpl$Data$declaredNonStaticMembers$2, executor);
    }

    public final FutureTarget<TranscodeType> KClassImpl$Data$declaredNonStaticMembers$2() {
        RequestFutureTarget requestFutureTarget = new RequestFutureTarget();
        return (FutureTarget) BuiltInFictitiousFunctionClassFactory(requestFutureTarget, requestFutureTarget, this, Executors.MyBillsEntityDataFactory());
    }
}
