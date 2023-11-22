package id.dana.core.ui.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;

/* loaded from: classes.dex */
public class GlideRequest<TranscodeType> extends RequestBuilder<TranscodeType> implements Cloneable {
    public GlideRequest(Glide glide, RequestManager requestManager, Class<TranscodeType> cls, Context context) {
        super(glide, requestManager, cls, context);
    }

    public final GlideRequest<TranscodeType> KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        return (GlideRequest) super.BuiltInFictitiousFunctionClassFactory(z);
    }

    public final GlideRequest<TranscodeType> MyBillsEntityDataFactory(DiskCacheStrategy diskCacheStrategy) {
        return (GlideRequest) super.BuiltInFictitiousFunctionClassFactory(diskCacheStrategy);
    }

    public final GlideRequest<TranscodeType> getErrorConfigVersion(Drawable drawable) {
        return (GlideRequest) super.KClassImpl$Data$declaredNonStaticMembers$2(drawable);
    }

    public final GlideRequest<TranscodeType> getErrorConfigVersion(int i) {
        return (GlideRequest) super.MyBillsEntityDataFactory(i);
    }

    public final GlideRequest<TranscodeType> scheduleImpl(int i) {
        return (GlideRequest) super.getAuthRequestContext(i);
    }

    public final GlideRequest<TranscodeType> MyBillsEntityDataFactory(Drawable drawable) {
        return (GlideRequest) super.PlaceComponentResult(drawable);
    }

    public final GlideRequest<TranscodeType> PlaceComponentResult(int i) {
        return (GlideRequest) super.BuiltInFictitiousFunctionClassFactory(i);
    }

    public final GlideRequest<TranscodeType> getSupportButtonTintMode() {
        return (GlideRequest) super.getAuthRequestContext(true);
    }

    public final GlideRequest<TranscodeType> BuiltInFictitiousFunctionClassFactory(int i, int i2) {
        return (GlideRequest) super.PlaceComponentResult(i, i2);
    }

    public final GlideRequest<TranscodeType> whenAvailable() {
        return (GlideRequest) super.NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    public final GlideRequest<TranscodeType> SubSequence() {
        return (GlideRequest) super.lookAheadTest();
    }

    public final GlideRequest<TranscodeType> BuiltInFictitiousFunctionClassFactory(Transformation<Bitmap> transformation) {
        return (GlideRequest) super.MyBillsEntityDataFactory(transformation);
    }

    public final GlideRequest<TranscodeType> PlaceComponentResult(Transformation<Bitmap>... transformationArr) {
        return (GlideRequest) super.KClassImpl$Data$declaredNonStaticMembers$2(transformationArr);
    }

    public final GlideRequest<TranscodeType> BuiltInFictitiousFunctionClassFactory(BaseRequestOptions<?> baseRequestOptions) {
        return (GlideRequest) super.MyBillsEntityDataFactory(baseRequestOptions);
    }

    public final GlideRequest<TranscodeType> BuiltInFictitiousFunctionClassFactory(RequestListener<TranscodeType> requestListener) {
        return (GlideRequest) super.getAuthRequestContext(requestListener);
    }

    public final GlideRequest<TranscodeType> PlaceComponentResult(RequestListener<TranscodeType> requestListener) {
        return (GlideRequest) super.KClassImpl$Data$declaredNonStaticMembers$2(requestListener);
    }

    public final GlideRequest<TranscodeType> MyBillsEntityDataFactory(RequestBuilder<TranscodeType> requestBuilder) {
        return (GlideRequest) super.BuiltInFictitiousFunctionClassFactory((RequestBuilder) requestBuilder);
    }

    public final GlideRequest<TranscodeType> BuiltInFictitiousFunctionClassFactory(Object obj) {
        return (GlideRequest) super.MyBillsEntityDataFactory(obj);
    }

    public final GlideRequest<TranscodeType> BuiltInFictitiousFunctionClassFactory(Drawable drawable) {
        return (GlideRequest) super.getAuthRequestContext(drawable);
    }

    public final GlideRequest<TranscodeType> BuiltInFictitiousFunctionClassFactory(String str) {
        return (GlideRequest) super.PlaceComponentResult(str);
    }

    public final GlideRequest<TranscodeType> MyBillsEntityDataFactory(Uri uri) {
        return (GlideRequest) super.getAuthRequestContext(uri);
    }

    public final GlideRequest<TranscodeType> KClassImpl$Data$declaredNonStaticMembers$2(Integer num) {
        return (GlideRequest) super.getAuthRequestContext(num);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public final /* bridge */ /* synthetic */ RequestBuilder KClassImpl$Data$declaredNonStaticMembers$2(RequestListener requestListener) {
        return (GlideRequest) super.KClassImpl$Data$declaredNonStaticMembers$2(requestListener);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public final /* bridge */ /* synthetic */ RequestBuilder MyBillsEntityDataFactory(BaseRequestOptions baseRequestOptions) {
        return (GlideRequest) super.MyBillsEntityDataFactory((BaseRequestOptions<?>) baseRequestOptions);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.request.BaseRequestOptions
    public final /* synthetic */ BaseRequestOptions PlaceComponentResult(BaseRequestOptions baseRequestOptions) {
        return (GlideRequest) super.MyBillsEntityDataFactory((BaseRequestOptions<?>) baseRequestOptions);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final /* bridge */ /* synthetic */ BaseRequestOptions getAuthRequestContext() {
        return (GlideRequest) super.getAuthRequestContext();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final /* bridge */ /* synthetic */ BaseRequestOptions PlaceComponentResult() {
        return (GlideRequest) super.PlaceComponentResult();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final /* bridge */ /* synthetic */ BaseRequestOptions lookAheadTest() {
        return (GlideRequest) super.lookAheadTest();
    }

    @Override // com.bumptech.glide.RequestBuilder
    /* renamed from: BuiltInFictitiousFunctionClassFactory */
    public final /* bridge */ /* synthetic */ RequestBuilder MyBillsEntityDataFactory() {
        return (GlideRequest) super.MyBillsEntityDataFactory();
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: MyBillsEntityDataFactory */
    public final /* synthetic */ BaseRequestOptions clone() {
        return (GlideRequest) super.MyBillsEntityDataFactory();
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.request.BaseRequestOptions
    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return (GlideRequest) super.MyBillsEntityDataFactory();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final /* bridge */ /* synthetic */ BaseRequestOptions getAuthRequestContext(Class cls) {
        return (GlideRequest) super.getAuthRequestContext(cls);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final /* bridge */ /* synthetic */ BaseRequestOptions BuiltInFictitiousFunctionClassFactory(DiskCacheStrategy diskCacheStrategy) {
        return (GlideRequest) super.BuiltInFictitiousFunctionClassFactory(diskCacheStrategy);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final /* bridge */ /* synthetic */ BaseRequestOptions scheduleImpl() {
        return (GlideRequest) super.scheduleImpl();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final /* bridge */ /* synthetic */ BaseRequestOptions MyBillsEntityDataFactory(DownsampleStrategy downsampleStrategy) {
        return (GlideRequest) super.MyBillsEntityDataFactory(downsampleStrategy);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public final /* bridge */ /* synthetic */ RequestBuilder BuiltInFictitiousFunctionClassFactory(RequestBuilder requestBuilder) {
        return (GlideRequest) super.BuiltInFictitiousFunctionClassFactory(requestBuilder);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final /* bridge */ /* synthetic */ BaseRequestOptions BuiltInFictitiousFunctionClassFactory(int i) {
        return (GlideRequest) super.BuiltInFictitiousFunctionClassFactory(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final /* bridge */ /* synthetic */ BaseRequestOptions PlaceComponentResult(Drawable drawable) {
        return (GlideRequest) super.PlaceComponentResult(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final /* bridge */ /* synthetic */ BaseRequestOptions getAuthRequestContext(int i) {
        return (GlideRequest) super.getAuthRequestContext(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final /* bridge */ /* synthetic */ BaseRequestOptions NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return (GlideRequest) super.NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    @Override // com.bumptech.glide.RequestBuilder
    public final /* bridge */ /* synthetic */ RequestBuilder getAuthRequestContext(RequestListener requestListener) {
        return (GlideRequest) super.getAuthRequestContext(requestListener);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public final /* bridge */ /* synthetic */ RequestBuilder PlaceComponentResult(Bitmap bitmap) {
        return (GlideRequest) super.PlaceComponentResult(bitmap);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public final /* bridge */ /* synthetic */ RequestBuilder getAuthRequestContext(Drawable drawable) {
        return (GlideRequest) super.getAuthRequestContext(drawable);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public final /* bridge */ /* synthetic */ RequestBuilder getAuthRequestContext(Uri uri) {
        return (GlideRequest) super.getAuthRequestContext(uri);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public final /* bridge */ /* synthetic */ RequestBuilder getAuthRequestContext(Integer num) {
        return (GlideRequest) super.getAuthRequestContext(num);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public final /* bridge */ /* synthetic */ RequestBuilder MyBillsEntityDataFactory(Object obj) {
        return (GlideRequest) super.MyBillsEntityDataFactory(obj);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public final /* bridge */ /* synthetic */ RequestBuilder PlaceComponentResult(String str) {
        return (GlideRequest) super.PlaceComponentResult(str);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final /* bridge */ /* synthetic */ BaseRequestOptions NetworkUserEntityData$$ExternalSyntheticLambda5() {
        return (GlideRequest) super.NetworkUserEntityData$$ExternalSyntheticLambda5();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final /* bridge */ /* synthetic */ BaseRequestOptions BuiltInFictitiousFunctionClassFactory(boolean z) {
        return (GlideRequest) super.BuiltInFictitiousFunctionClassFactory(z);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final /* bridge */ /* synthetic */ BaseRequestOptions NetworkUserEntityData$$ExternalSyntheticLambda3() {
        return (GlideRequest) super.NetworkUserEntityData$$ExternalSyntheticLambda3();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final /* bridge */ /* synthetic */ BaseRequestOptions NetworkUserEntityData$$ExternalSyntheticLambda6() {
        return (GlideRequest) super.NetworkUserEntityData$$ExternalSyntheticLambda6();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final /* bridge */ /* synthetic */ BaseRequestOptions readMicros() {
        return (GlideRequest) super.readMicros();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final /* bridge */ /* synthetic */ BaseRequestOptions KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        return (GlideRequest) super.KClassImpl$Data$declaredNonStaticMembers$2(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final /* bridge */ /* synthetic */ BaseRequestOptions PlaceComponentResult(int i, int i2) {
        return (GlideRequest) super.PlaceComponentResult(i, i2);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final /* bridge */ /* synthetic */ BaseRequestOptions MyBillsEntityDataFactory(int i) {
        return (GlideRequest) super.MyBillsEntityDataFactory(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final /* bridge */ /* synthetic */ BaseRequestOptions KClassImpl$Data$declaredNonStaticMembers$2(Drawable drawable) {
        return (GlideRequest) super.KClassImpl$Data$declaredNonStaticMembers$2(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final /* bridge */ /* synthetic */ BaseRequestOptions KClassImpl$Data$declaredNonStaticMembers$2(Priority priority) {
        return (GlideRequest) super.KClassImpl$Data$declaredNonStaticMembers$2(priority);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final /* bridge */ /* synthetic */ BaseRequestOptions BuiltInFictitiousFunctionClassFactory(Option option, Object obj) {
        return (GlideRequest) super.BuiltInFictitiousFunctionClassFactory((Option<Option>) option, (Option) obj);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final /* bridge */ /* synthetic */ BaseRequestOptions KClassImpl$Data$declaredNonStaticMembers$2(Key key) {
        return (GlideRequest) super.KClassImpl$Data$declaredNonStaticMembers$2(key);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final /* bridge */ /* synthetic */ BaseRequestOptions KClassImpl$Data$declaredNonStaticMembers$2(float f) {
        return (GlideRequest) super.KClassImpl$Data$declaredNonStaticMembers$2(f);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final /* bridge */ /* synthetic */ BaseRequestOptions getAuthRequestContext(boolean z) {
        return (GlideRequest) super.getAuthRequestContext(z);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final /* bridge */ /* synthetic */ BaseRequestOptions MyBillsEntityDataFactory(Transformation transformation) {
        return (GlideRequest) super.MyBillsEntityDataFactory((Transformation<Bitmap>) transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final /* bridge */ /* synthetic */ BaseRequestOptions KClassImpl$Data$declaredNonStaticMembers$2(Transformation[] transformationArr) {
        return (GlideRequest) super.KClassImpl$Data$declaredNonStaticMembers$2(transformationArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @Deprecated
    public final /* bridge */ /* synthetic */ BaseRequestOptions getAuthRequestContext(Transformation[] transformationArr) {
        return (GlideRequest) super.getAuthRequestContext(transformationArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final /* bridge */ /* synthetic */ BaseRequestOptions PlaceComponentResult(boolean z) {
        return (GlideRequest) super.PlaceComponentResult(z);
    }
}
