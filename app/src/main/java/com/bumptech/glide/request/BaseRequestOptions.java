package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;
import com.bumptech.glide.load.resource.gif.GifOptions;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class BaseRequestOptions<T extends BaseRequestOptions<T>> implements Cloneable {
    Drawable BuiltInFictitiousFunctionClassFactory;
    private boolean GetContactSyncConfig;
    int MyBillsEntityDataFactory;
    Resources.Theme NetworkUserEntityData$$ExternalSyntheticLambda2;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda3;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda5;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda7;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda8;
    private int PlaceComponentResult;
    Drawable getAuthRequestContext;
    int getErrorConfigVersion;
    private boolean getSupportButtonTintMode;
    Drawable lookAheadTest;
    int scheduleImpl;
    float initRecordTimeStamp = 1.0f;
    DiskCacheStrategy KClassImpl$Data$declaredNonStaticMembers$2 = DiskCacheStrategy.getAuthRequestContext;
    private Priority NetworkUserEntityData$$ExternalSyntheticLambda6 = Priority.NORMAL;
    private boolean isLayoutRequested = true;
    private int FragmentBottomSheetPaymentSettingBinding = -1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda4 = -1;
    Key NetworkUserEntityData$$ExternalSyntheticLambda1 = EmptySignature.MyBillsEntityDataFactory();
    private boolean PrepareContext = true;
    Options NetworkUserEntityData$$ExternalSyntheticLambda0 = new Options();
    Map<Class<?>, Transformation<?>> DatabaseTableConfigUtil = new CachedHashCodeArrayMap();
    Class<?> moveToNextValue = Object.class;
    private boolean newProxyInstance = true;

    private static boolean MyBillsEntityDataFactory(int i, int i2) {
        return (i & i2) != 0;
    }

    public T KClassImpl$Data$declaredNonStaticMembers$2(float f) {
        if (this.GetContactSyncConfig) {
            return (T) clone().KClassImpl$Data$declaredNonStaticMembers$2(f);
        }
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.initRecordTimeStamp = f;
        this.PlaceComponentResult |= 2;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return this;
    }

    public T PlaceComponentResult(boolean z) {
        if (this.GetContactSyncConfig) {
            return (T) clone().PlaceComponentResult(z);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = z;
        this.PlaceComponentResult |= CrashCombineUtils.DEFAULT_MAX_INFO_LEN;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return this;
    }

    public T BuiltInFictitiousFunctionClassFactory(boolean z) {
        if (this.GetContactSyncConfig) {
            return (T) clone().BuiltInFictitiousFunctionClassFactory(z);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = z;
        this.PlaceComponentResult |= 524288;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return this;
    }

    public T BuiltInFictitiousFunctionClassFactory(DiskCacheStrategy diskCacheStrategy) {
        if (this.GetContactSyncConfig) {
            return (T) clone().BuiltInFictitiousFunctionClassFactory(diskCacheStrategy);
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (DiskCacheStrategy) Preconditions.PlaceComponentResult(diskCacheStrategy);
        this.PlaceComponentResult |= 4;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return this;
    }

    public T KClassImpl$Data$declaredNonStaticMembers$2(Priority priority) {
        if (this.GetContactSyncConfig) {
            return (T) clone().KClassImpl$Data$declaredNonStaticMembers$2(priority);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = (Priority) Preconditions.PlaceComponentResult(priority);
        this.PlaceComponentResult |= 8;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return this;
    }

    public T KClassImpl$Data$declaredNonStaticMembers$2(Drawable drawable) {
        if (this.GetContactSyncConfig) {
            return (T) clone().KClassImpl$Data$declaredNonStaticMembers$2(drawable);
        }
        this.lookAheadTest = drawable;
        int i = this.PlaceComponentResult;
        this.scheduleImpl = 0;
        this.PlaceComponentResult = (i | 64) & (-129);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return this;
    }

    public T MyBillsEntityDataFactory(int i) {
        if (this.GetContactSyncConfig) {
            return (T) clone().MyBillsEntityDataFactory(i);
        }
        this.scheduleImpl = i;
        int i2 = this.PlaceComponentResult;
        this.lookAheadTest = null;
        this.PlaceComponentResult = (i2 | 128) & (-65);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return this;
    }

    public T getAuthRequestContext(int i) {
        if (this.GetContactSyncConfig) {
            return (T) clone().getAuthRequestContext(i);
        }
        this.getErrorConfigVersion = i;
        int i2 = this.PlaceComponentResult;
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.PlaceComponentResult = (i2 | 16384) & (-8193);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return this;
    }

    public T PlaceComponentResult(Drawable drawable) {
        if (this.GetContactSyncConfig) {
            return (T) clone().PlaceComponentResult(drawable);
        }
        this.getAuthRequestContext = drawable;
        int i = this.PlaceComponentResult;
        this.MyBillsEntityDataFactory = 0;
        this.PlaceComponentResult = (i | 16) & (-33);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return this;
    }

    public T BuiltInFictitiousFunctionClassFactory(int i) {
        if (this.GetContactSyncConfig) {
            return (T) clone().BuiltInFictitiousFunctionClassFactory(i);
        }
        this.MyBillsEntityDataFactory = i;
        int i2 = this.PlaceComponentResult;
        this.getAuthRequestContext = null;
        this.PlaceComponentResult = (i2 | 32) & (-17);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return this;
    }

    public T getAuthRequestContext(boolean z) {
        if (this.GetContactSyncConfig) {
            return (T) clone().getAuthRequestContext(true);
        }
        this.isLayoutRequested = !z;
        this.PlaceComponentResult |= 256;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return this;
    }

    public T PlaceComponentResult(int i, int i2) {
        if (this.GetContactSyncConfig) {
            return (T) clone().PlaceComponentResult(i, i2);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = i;
        this.FragmentBottomSheetPaymentSettingBinding = i2;
        this.PlaceComponentResult |= 512;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return this;
    }

    public T KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        return PlaceComponentResult(i, i);
    }

    public T KClassImpl$Data$declaredNonStaticMembers$2(Key key) {
        if (this.GetContactSyncConfig) {
            return (T) clone().KClassImpl$Data$declaredNonStaticMembers$2(key);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = (Key) Preconditions.PlaceComponentResult(key);
        this.PlaceComponentResult |= 1024;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return this;
    }

    @Override // 
    /* renamed from: MyBillsEntityDataFactory */
    public T clone() {
        try {
            T t = (T) super.clone();
            Options options = new Options();
            t.NetworkUserEntityData$$ExternalSyntheticLambda0 = options;
            options.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2);
            CachedHashCodeArrayMap cachedHashCodeArrayMap = new CachedHashCodeArrayMap();
            t.DatabaseTableConfigUtil = cachedHashCodeArrayMap;
            cachedHashCodeArrayMap.putAll(this.DatabaseTableConfigUtil);
            t.NetworkUserEntityData$$ExternalSyntheticLambda7 = false;
            t.GetContactSyncConfig = false;
            return t;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public <Y> T BuiltInFictitiousFunctionClassFactory(Option<Y> option, Y y) {
        if (this.GetContactSyncConfig) {
            return (T) clone().BuiltInFictitiousFunctionClassFactory(option, y);
        }
        Preconditions.PlaceComponentResult(option);
        Preconditions.PlaceComponentResult(y);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2.put(option, y);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return this;
    }

    public T getAuthRequestContext(Class<?> cls) {
        if (this.GetContactSyncConfig) {
            return (T) clone().getAuthRequestContext(cls);
        }
        this.moveToNextValue = (Class) Preconditions.PlaceComponentResult(cls);
        this.PlaceComponentResult |= 4096;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return this;
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda7() {
        return this.PrepareContext;
    }

    public final boolean FragmentBottomSheetPaymentSettingBinding() {
        return PlaceComponentResult(2048);
    }

    public T MyBillsEntityDataFactory(DownsampleStrategy downsampleStrategy) {
        return BuiltInFictitiousFunctionClassFactory((Option<Option>) DownsampleStrategy.scheduleImpl, (Option) Preconditions.PlaceComponentResult(downsampleStrategy));
    }

    public T NetworkUserEntityData$$ExternalSyntheticLambda3() {
        DownsampleStrategy downsampleStrategy = DownsampleStrategy.KClassImpl$Data$declaredNonStaticMembers$2;
        CenterCrop centerCrop = new CenterCrop();
        if (this.GetContactSyncConfig) {
            BaseRequestOptions clone = clone();
            while (clone.GetContactSyncConfig) {
                clone = clone.clone();
            }
            clone.MyBillsEntityDataFactory(downsampleStrategy);
            return (T) clone.BuiltInFictitiousFunctionClassFactory((Transformation<Bitmap>) centerCrop, false);
        }
        MyBillsEntityDataFactory(downsampleStrategy);
        return BuiltInFictitiousFunctionClassFactory((Transformation<Bitmap>) centerCrop, false);
    }

    public T PlaceComponentResult() {
        DownsampleStrategy downsampleStrategy = DownsampleStrategy.KClassImpl$Data$declaredNonStaticMembers$2;
        CenterCrop centerCrop = new CenterCrop();
        if (this.GetContactSyncConfig) {
            BaseRequestOptions clone = clone();
            while (clone.GetContactSyncConfig) {
                clone = clone.clone();
            }
            clone.MyBillsEntityDataFactory(downsampleStrategy);
            return (T) clone.MyBillsEntityDataFactory(centerCrop);
        }
        MyBillsEntityDataFactory(downsampleStrategy);
        return MyBillsEntityDataFactory(centerCrop);
    }

    public T readMicros() {
        return KClassImpl$Data$declaredNonStaticMembers$2(DownsampleStrategy.moveToNextValue, new FitCenter());
    }

    public T NetworkUserEntityData$$ExternalSyntheticLambda0() {
        T MyBillsEntityDataFactory;
        DownsampleStrategy downsampleStrategy = DownsampleStrategy.moveToNextValue;
        FitCenter fitCenter = new FitCenter();
        if (this.GetContactSyncConfig) {
            BaseRequestOptions clone = clone();
            while (clone.GetContactSyncConfig) {
                clone = clone.clone();
            }
            clone.MyBillsEntityDataFactory(downsampleStrategy);
            MyBillsEntityDataFactory = (T) clone.MyBillsEntityDataFactory(fitCenter);
        } else {
            MyBillsEntityDataFactory(downsampleStrategy);
            MyBillsEntityDataFactory = MyBillsEntityDataFactory(fitCenter);
        }
        MyBillsEntityDataFactory.newProxyInstance = true;
        return MyBillsEntityDataFactory;
    }

    public T NetworkUserEntityData$$ExternalSyntheticLambda6() {
        return KClassImpl$Data$declaredNonStaticMembers$2(DownsampleStrategy.MyBillsEntityDataFactory, new CenterInside());
    }

    public T lookAheadTest() {
        DownsampleStrategy downsampleStrategy = DownsampleStrategy.MyBillsEntityDataFactory;
        CircleCrop circleCrop = new CircleCrop();
        if (this.GetContactSyncConfig) {
            BaseRequestOptions clone = clone();
            while (clone.GetContactSyncConfig) {
                clone = clone.clone();
            }
            clone.MyBillsEntityDataFactory(downsampleStrategy);
            return (T) clone.MyBillsEntityDataFactory(circleCrop);
        }
        MyBillsEntityDataFactory(downsampleStrategy);
        return MyBillsEntityDataFactory(circleCrop);
    }

    public T MyBillsEntityDataFactory(Transformation<Bitmap> transformation) {
        return BuiltInFictitiousFunctionClassFactory(transformation, true);
    }

    public T KClassImpl$Data$declaredNonStaticMembers$2(Transformation<Bitmap>... transformationArr) {
        if (transformationArr.length > 1) {
            return BuiltInFictitiousFunctionClassFactory((Transformation<Bitmap>) new MultiTransformation(transformationArr), true);
        }
        if (transformationArr.length == 1) {
            return MyBillsEntityDataFactory(transformationArr[0]);
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return this;
    }

    @Deprecated
    public T getAuthRequestContext(Transformation<Bitmap>... transformationArr) {
        return BuiltInFictitiousFunctionClassFactory((Transformation<Bitmap>) new MultiTransformation(transformationArr), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private T BuiltInFictitiousFunctionClassFactory(Transformation<Bitmap> transformation, boolean z) {
        BaseRequestOptions<T> baseRequestOptions = this;
        while (baseRequestOptions.GetContactSyncConfig) {
            baseRequestOptions = baseRequestOptions.clone();
        }
        DrawableTransformation drawableTransformation = new DrawableTransformation(transformation, z);
        baseRequestOptions.MyBillsEntityDataFactory(Bitmap.class, transformation, z);
        baseRequestOptions.MyBillsEntityDataFactory(Drawable.class, drawableTransformation, z);
        baseRequestOptions.MyBillsEntityDataFactory(BitmapDrawable.class, drawableTransformation, z);
        baseRequestOptions.MyBillsEntityDataFactory(GifDrawable.class, new GifDrawableTransformation(transformation), z);
        if (baseRequestOptions.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return baseRequestOptions;
    }

    private <Y> T MyBillsEntityDataFactory(Class<Y> cls, Transformation<Y> transformation, boolean z) {
        BaseRequestOptions<T> baseRequestOptions = this;
        while (baseRequestOptions.GetContactSyncConfig) {
            baseRequestOptions = baseRequestOptions.clone();
        }
        Preconditions.PlaceComponentResult(cls);
        Preconditions.PlaceComponentResult(transformation);
        baseRequestOptions.DatabaseTableConfigUtil.put(cls, transformation);
        int i = baseRequestOptions.PlaceComponentResult;
        baseRequestOptions.PrepareContext = true;
        int i2 = i | 2048 | 65536;
        baseRequestOptions.PlaceComponentResult = i2;
        baseRequestOptions.newProxyInstance = false;
        if (z) {
            baseRequestOptions.PlaceComponentResult = i2 | AntDetector.SCENE_ID_LOGIN_REGIST;
            baseRequestOptions.NetworkUserEntityData$$ExternalSyntheticLambda8 = true;
        }
        if (baseRequestOptions.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return baseRequestOptions;
    }

    public T scheduleImpl() {
        return BuiltInFictitiousFunctionClassFactory((Option<Option>) GifOptions.getAuthRequestContext, (Option) Boolean.TRUE);
    }

    public T PlaceComponentResult(BaseRequestOptions<?> baseRequestOptions) {
        if (this.GetContactSyncConfig) {
            return (T) clone().PlaceComponentResult(baseRequestOptions);
        }
        if (MyBillsEntityDataFactory(baseRequestOptions.PlaceComponentResult, 2)) {
            this.initRecordTimeStamp = baseRequestOptions.initRecordTimeStamp;
        }
        if (MyBillsEntityDataFactory(baseRequestOptions.PlaceComponentResult, 262144)) {
            this.getSupportButtonTintMode = baseRequestOptions.getSupportButtonTintMode;
        }
        if (MyBillsEntityDataFactory(baseRequestOptions.PlaceComponentResult, CrashCombineUtils.DEFAULT_MAX_INFO_LEN)) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = baseRequestOptions.NetworkUserEntityData$$ExternalSyntheticLambda5;
        }
        if (MyBillsEntityDataFactory(baseRequestOptions.PlaceComponentResult, 4)) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = baseRequestOptions.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        if (MyBillsEntityDataFactory(baseRequestOptions.PlaceComponentResult, 8)) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = baseRequestOptions.NetworkUserEntityData$$ExternalSyntheticLambda6;
        }
        if (MyBillsEntityDataFactory(baseRequestOptions.PlaceComponentResult, 16)) {
            this.getAuthRequestContext = baseRequestOptions.getAuthRequestContext;
            this.MyBillsEntityDataFactory = 0;
            this.PlaceComponentResult &= -33;
        }
        if (MyBillsEntityDataFactory(baseRequestOptions.PlaceComponentResult, 32)) {
            this.MyBillsEntityDataFactory = baseRequestOptions.MyBillsEntityDataFactory;
            this.getAuthRequestContext = null;
            this.PlaceComponentResult &= -17;
        }
        if (MyBillsEntityDataFactory(baseRequestOptions.PlaceComponentResult, 64)) {
            this.lookAheadTest = baseRequestOptions.lookAheadTest;
            this.scheduleImpl = 0;
            this.PlaceComponentResult &= -129;
        }
        if (MyBillsEntityDataFactory(baseRequestOptions.PlaceComponentResult, 128)) {
            this.scheduleImpl = baseRequestOptions.scheduleImpl;
            this.lookAheadTest = null;
            this.PlaceComponentResult &= -65;
        }
        if (MyBillsEntityDataFactory(baseRequestOptions.PlaceComponentResult, 256)) {
            this.isLayoutRequested = baseRequestOptions.isLayoutRequested;
        }
        if (MyBillsEntityDataFactory(baseRequestOptions.PlaceComponentResult, 512)) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = baseRequestOptions.NetworkUserEntityData$$ExternalSyntheticLambda4;
            this.FragmentBottomSheetPaymentSettingBinding = baseRequestOptions.FragmentBottomSheetPaymentSettingBinding;
        }
        if (MyBillsEntityDataFactory(baseRequestOptions.PlaceComponentResult, 1024)) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = baseRequestOptions.NetworkUserEntityData$$ExternalSyntheticLambda1;
        }
        if (MyBillsEntityDataFactory(baseRequestOptions.PlaceComponentResult, 4096)) {
            this.moveToNextValue = baseRequestOptions.moveToNextValue;
        }
        if (MyBillsEntityDataFactory(baseRequestOptions.PlaceComponentResult, 8192)) {
            this.BuiltInFictitiousFunctionClassFactory = baseRequestOptions.BuiltInFictitiousFunctionClassFactory;
            this.getErrorConfigVersion = 0;
            this.PlaceComponentResult &= -16385;
        }
        if (MyBillsEntityDataFactory(baseRequestOptions.PlaceComponentResult, 16384)) {
            this.getErrorConfigVersion = baseRequestOptions.getErrorConfigVersion;
            this.BuiltInFictitiousFunctionClassFactory = null;
            this.PlaceComponentResult &= -8193;
        }
        if (MyBillsEntityDataFactory(baseRequestOptions.PlaceComponentResult, 32768)) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = baseRequestOptions.NetworkUserEntityData$$ExternalSyntheticLambda2;
        }
        if (MyBillsEntityDataFactory(baseRequestOptions.PlaceComponentResult, 65536)) {
            this.PrepareContext = baseRequestOptions.PrepareContext;
        }
        if (MyBillsEntityDataFactory(baseRequestOptions.PlaceComponentResult, AntDetector.SCENE_ID_LOGIN_REGIST)) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = baseRequestOptions.NetworkUserEntityData$$ExternalSyntheticLambda8;
        }
        if (MyBillsEntityDataFactory(baseRequestOptions.PlaceComponentResult, 2048)) {
            this.DatabaseTableConfigUtil.putAll(baseRequestOptions.DatabaseTableConfigUtil);
            this.newProxyInstance = baseRequestOptions.newProxyInstance;
        }
        if (MyBillsEntityDataFactory(baseRequestOptions.PlaceComponentResult, 524288)) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = baseRequestOptions.NetworkUserEntityData$$ExternalSyntheticLambda3;
        }
        if (!this.PrepareContext) {
            this.DatabaseTableConfigUtil.clear();
            int i = this.PlaceComponentResult;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = false;
            this.PlaceComponentResult = i & (-2049) & (-131073);
            this.newProxyInstance = true;
        }
        this.PlaceComponentResult |= baseRequestOptions.PlaceComponentResult;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(baseRequestOptions.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof BaseRequestOptions) {
            BaseRequestOptions baseRequestOptions = (BaseRequestOptions) obj;
            return Float.compare(baseRequestOptions.initRecordTimeStamp, this.initRecordTimeStamp) == 0 && this.MyBillsEntityDataFactory == baseRequestOptions.MyBillsEntityDataFactory && Util.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext, baseRequestOptions.getAuthRequestContext) && this.scheduleImpl == baseRequestOptions.scheduleImpl && Util.BuiltInFictitiousFunctionClassFactory(this.lookAheadTest, baseRequestOptions.lookAheadTest) && this.getErrorConfigVersion == baseRequestOptions.getErrorConfigVersion && Util.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, baseRequestOptions.BuiltInFictitiousFunctionClassFactory) && this.isLayoutRequested == baseRequestOptions.isLayoutRequested && this.FragmentBottomSheetPaymentSettingBinding == baseRequestOptions.FragmentBottomSheetPaymentSettingBinding && this.NetworkUserEntityData$$ExternalSyntheticLambda4 == baseRequestOptions.NetworkUserEntityData$$ExternalSyntheticLambda4 && this.NetworkUserEntityData$$ExternalSyntheticLambda8 == baseRequestOptions.NetworkUserEntityData$$ExternalSyntheticLambda8 && this.PrepareContext == baseRequestOptions.PrepareContext && this.getSupportButtonTintMode == baseRequestOptions.getSupportButtonTintMode && this.NetworkUserEntityData$$ExternalSyntheticLambda3 == baseRequestOptions.NetworkUserEntityData$$ExternalSyntheticLambda3 && this.KClassImpl$Data$declaredNonStaticMembers$2.equals(baseRequestOptions.KClassImpl$Data$declaredNonStaticMembers$2) && this.NetworkUserEntityData$$ExternalSyntheticLambda6 == baseRequestOptions.NetworkUserEntityData$$ExternalSyntheticLambda6 && this.NetworkUserEntityData$$ExternalSyntheticLambda0.equals(baseRequestOptions.NetworkUserEntityData$$ExternalSyntheticLambda0) && this.DatabaseTableConfigUtil.equals(baseRequestOptions.DatabaseTableConfigUtil) && this.moveToNextValue.equals(baseRequestOptions.moveToNextValue) && Util.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1, baseRequestOptions.NetworkUserEntityData$$ExternalSyntheticLambda1) && Util.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2, baseRequestOptions.NetworkUserEntityData$$ExternalSyntheticLambda2);
        }
        return false;
    }

    public int hashCode() {
        return Util.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda2, Util.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda1, Util.PlaceComponentResult(this.moveToNextValue, Util.PlaceComponentResult(this.DatabaseTableConfigUtil, Util.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda0, Util.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda6, Util.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, Util.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda3, Util.PlaceComponentResult(this.getSupportButtonTintMode, Util.PlaceComponentResult(this.PrepareContext, Util.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda8, Util.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda4, Util.getAuthRequestContext(this.FragmentBottomSheetPaymentSettingBinding, Util.PlaceComponentResult(this.isLayoutRequested, Util.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, Util.getAuthRequestContext(this.getErrorConfigVersion, Util.PlaceComponentResult(this.lookAheadTest, Util.getAuthRequestContext(this.scheduleImpl, Util.PlaceComponentResult(this.getAuthRequestContext, Util.getAuthRequestContext(this.MyBillsEntityDataFactory, Util.BuiltInFictitiousFunctionClassFactory(this.initRecordTimeStamp)))))))))))))))))))));
    }

    public T NetworkUserEntityData$$ExternalSyntheticLambda5() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = true;
        return this;
    }

    public T getAuthRequestContext() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 && !this.GetContactSyncConfig) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.GetContactSyncConfig = true;
        return NetworkUserEntityData$$ExternalSyntheticLambda5();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final T getCallingPid() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean GetContactSyncConfig() {
        return this.GetContactSyncConfig;
    }

    public final boolean PrepareContext() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda8;
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda8() {
        return this.isLayoutRequested;
    }

    public final boolean newProxyInstance() {
        return PlaceComponentResult(8);
    }

    public final Priority initRecordTimeStamp() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda6;
    }

    public final int NetworkUserEntityData$$ExternalSyntheticLambda1() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda4;
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda4() {
        return Util.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.FragmentBottomSheetPaymentSettingBinding);
    }

    public final int moveToNextValue() {
        return this.FragmentBottomSheetPaymentSettingBinding;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isLayoutRequested() {
        return this.newProxyInstance;
    }

    private boolean PlaceComponentResult(int i) {
        return MyBillsEntityDataFactory(this.PlaceComponentResult, i);
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda2() {
        return this.getSupportButtonTintMode;
    }

    public final boolean DatabaseTableConfigUtil() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda5;
    }

    public final boolean getErrorConfigVersion() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda3;
    }

    private T KClassImpl$Data$declaredNonStaticMembers$2(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation) {
        T BuiltInFictitiousFunctionClassFactory;
        if (this.GetContactSyncConfig) {
            BaseRequestOptions clone = clone();
            while (clone.GetContactSyncConfig) {
                clone = clone.clone();
            }
            clone.MyBillsEntityDataFactory(downsampleStrategy);
            BuiltInFictitiousFunctionClassFactory = (T) clone.BuiltInFictitiousFunctionClassFactory(transformation, false);
        } else {
            MyBillsEntityDataFactory(downsampleStrategy);
            BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(transformation, false);
        }
        BuiltInFictitiousFunctionClassFactory.newProxyInstance = true;
        return BuiltInFictitiousFunctionClassFactory;
    }
}
