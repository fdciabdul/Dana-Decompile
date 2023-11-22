package com.bumptech.glide.request;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;

/* loaded from: classes3.dex */
public class RequestOptions extends BaseRequestOptions<RequestOptions> {
    private static RequestOptions PlaceComponentResult;

    public static RequestOptions BuiltInFictitiousFunctionClassFactory(Key key) {
        return new RequestOptions().KClassImpl$Data$declaredNonStaticMembers$2(key);
    }

    public static RequestOptions KClassImpl$Data$declaredNonStaticMembers$2() {
        if (PlaceComponentResult == null) {
            PlaceComponentResult = new RequestOptions().lookAheadTest().getAuthRequestContext();
        }
        return PlaceComponentResult;
    }

    public static RequestOptions getAuthRequestContext(Transformation<Bitmap> transformation) {
        return new RequestOptions().MyBillsEntityDataFactory(transformation);
    }
}
