package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zak;

/* loaded from: classes7.dex */
public abstract class zag {
    final zad zaa;
    protected int zab;

    public zag(Uri uri, int i) {
        this.zab = 0;
        this.zaa = new zad(uri);
        this.zab = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void zaa(Drawable drawable, boolean z, boolean z2, boolean z3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zab(Context context, zak zakVar, boolean z) {
        int i = this.zab;
        zaa(i != 0 ? InstrumentInjector.Resources_getDrawable(context.getResources(), i) : null, z, false, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zac(Context context, Bitmap bitmap, boolean z) {
        Asserts.checkNotNull(bitmap);
        zaa(new BitmapDrawable(context.getResources(), bitmap), false, false, true);
    }
}
