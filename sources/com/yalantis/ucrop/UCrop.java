package com.yalantis.ucrop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/* loaded from: classes8.dex */
public class UCrop {
    public Intent BuiltInFictitiousFunctionClassFactory = new Intent();
    public Bundle PlaceComponentResult;

    /* loaded from: classes8.dex */
    public static class Options {
        public final Bundle PlaceComponentResult = new Bundle();
    }

    public static UCrop KClassImpl$Data$declaredNonStaticMembers$2(Uri uri, Uri uri2) {
        return new UCrop(uri, uri2);
    }

    private UCrop(Uri uri, Uri uri2) {
        Bundle bundle = new Bundle();
        this.PlaceComponentResult = bundle;
        bundle.putParcelable("com.yalantis.ucrop.InputUri", uri);
        this.PlaceComponentResult.putParcelable("com.yalantis.ucrop.OutputUri", uri2);
    }

    public static Uri BuiltInFictitiousFunctionClassFactory(Intent intent) {
        return (Uri) intent.getParcelableExtra("com.yalantis.ucrop.OutputUri");
    }
}
