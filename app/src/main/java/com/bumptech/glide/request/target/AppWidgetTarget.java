package com.bumptech.glide.request.target;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes7.dex */
public class AppWidgetTarget extends CustomTarget<Bitmap> {
    private final int[] BuiltInFictitiousFunctionClassFactory;
    private final ComponentName KClassImpl$Data$declaredNonStaticMembers$2;
    private final RemoteViews MyBillsEntityDataFactory;
    private final Context PlaceComponentResult;
    private final int getAuthRequestContext;

    @Override // com.bumptech.glide.request.target.Target
    public /* synthetic */ void onResourceReady(Object obj, Transition transition) {
        MyBillsEntityDataFactory((Bitmap) obj);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
        MyBillsEntityDataFactory(null);
    }

    private void MyBillsEntityDataFactory(Bitmap bitmap) {
        this.MyBillsEntityDataFactory.setImageViewBitmap(this.getAuthRequestContext, bitmap);
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.PlaceComponentResult);
        ComponentName componentName = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (componentName != null) {
            appWidgetManager.updateAppWidget(componentName, this.MyBillsEntityDataFactory);
        } else {
            appWidgetManager.updateAppWidget(this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory);
        }
    }
}
