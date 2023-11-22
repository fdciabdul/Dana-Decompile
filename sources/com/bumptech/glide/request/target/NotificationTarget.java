package com.bumptech.glide.request.target;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes7.dex */
public class NotificationTarget extends CustomTarget<Bitmap> {
    private final int BuiltInFictitiousFunctionClassFactory;
    private final RemoteViews KClassImpl$Data$declaredNonStaticMembers$2;
    private final String MyBillsEntityDataFactory;
    private final Notification PlaceComponentResult;
    private final Context getAuthRequestContext;
    private final int moveToNextValue;

    @Override // com.bumptech.glide.request.target.Target
    public /* synthetic */ void onResourceReady(Object obj, Transition transition) {
        getAuthRequestContext((Bitmap) obj);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
        getAuthRequestContext(null);
    }

    private void getAuthRequestContext(Bitmap bitmap) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.setImageViewBitmap(this.moveToNextValue, bitmap);
        ((NotificationManager) Preconditions.PlaceComponentResult((NotificationManager) this.getAuthRequestContext.getSystemService("notification"))).notify(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult);
    }
}
