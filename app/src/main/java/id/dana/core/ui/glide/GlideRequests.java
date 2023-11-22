package id.dana.core.ui.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.request.RequestOptions;

/* loaded from: classes.dex */
public class GlideRequests extends RequestManager {
    public GlideRequests(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
        super(glide, lifecycle, requestManagerTreeNode, context);
    }

    public final <ResourceType> GlideRequest<ResourceType> PlaceComponentResult(Class<ResourceType> cls) {
        return new GlideRequest<>(this.getAuthRequestContext, this, cls, this.PlaceComponentResult);
    }

    public final GlideRequest<Bitmap> MyBillsEntityDataFactory() {
        return (GlideRequest) super.PlaceComponentResult();
    }

    public final GlideRequest<Drawable> getAuthRequestContext(Bitmap bitmap) {
        return (GlideRequest) super.PlaceComponentResult(bitmap);
    }

    public final GlideRequest<Drawable> PlaceComponentResult(Drawable drawable) {
        return (GlideRequest) super.MyBillsEntityDataFactory(drawable);
    }

    public final GlideRequest<Drawable> PlaceComponentResult(String str) {
        return (GlideRequest) super.getAuthRequestContext(str);
    }

    public final GlideRequest<Drawable> MyBillsEntityDataFactory(Uri uri) {
        return (GlideRequest) super.KClassImpl$Data$declaredNonStaticMembers$2(uri);
    }

    public final GlideRequest<Drawable> PlaceComponentResult(Integer num) {
        return (GlideRequest) super.getAuthRequestContext(num);
    }

    public final GlideRequest<Drawable> MyBillsEntityDataFactory(Object obj) {
        return (GlideRequest) super.getAuthRequestContext(obj);
    }

    @Override // com.bumptech.glide.RequestManager
    public final void PlaceComponentResult(RequestOptions requestOptions) {
        if (requestOptions instanceof GlideOptions) {
            super.PlaceComponentResult(requestOptions);
        } else {
            super.PlaceComponentResult(new GlideOptions().getAuthRequestContext(requestOptions));
        }
    }

    @Override // com.bumptech.glide.RequestManager
    public final /* synthetic */ RequestBuilder BuiltInFictitiousFunctionClassFactory(Class cls) {
        return new GlideRequest(this.getAuthRequestContext, this, cls, this.PlaceComponentResult);
    }

    @Override // com.bumptech.glide.RequestManager
    public final /* bridge */ /* synthetic */ RequestBuilder PlaceComponentResult() {
        return (GlideRequest) super.PlaceComponentResult();
    }

    @Override // com.bumptech.glide.RequestManager
    public final /* bridge */ /* synthetic */ RequestBuilder KClassImpl$Data$declaredNonStaticMembers$2() {
        return (GlideRequest) super.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // com.bumptech.glide.RequestManager
    public final /* bridge */ /* synthetic */ RequestBuilder PlaceComponentResult(Bitmap bitmap) {
        return (GlideRequest) super.PlaceComponentResult(bitmap);
    }

    @Override // com.bumptech.glide.RequestManager
    public final /* bridge */ /* synthetic */ RequestBuilder MyBillsEntityDataFactory(Drawable drawable) {
        return (GlideRequest) super.MyBillsEntityDataFactory(drawable);
    }

    @Override // com.bumptech.glide.RequestManager
    public final /* bridge */ /* synthetic */ RequestBuilder KClassImpl$Data$declaredNonStaticMembers$2(Uri uri) {
        return (GlideRequest) super.KClassImpl$Data$declaredNonStaticMembers$2(uri);
    }

    @Override // com.bumptech.glide.RequestManager
    public final /* bridge */ /* synthetic */ RequestBuilder getAuthRequestContext(Integer num) {
        return (GlideRequest) super.getAuthRequestContext(num);
    }

    @Override // com.bumptech.glide.RequestManager
    public final /* bridge */ /* synthetic */ RequestBuilder getAuthRequestContext(Object obj) {
        return (GlideRequest) super.getAuthRequestContext(obj);
    }

    @Override // com.bumptech.glide.RequestManager
    public final /* bridge */ /* synthetic */ RequestBuilder getAuthRequestContext(String str) {
        return (GlideRequest) super.getAuthRequestContext(str);
    }
}
