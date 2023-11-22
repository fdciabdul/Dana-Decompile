package com.xiaomi.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.iap.ac.android.acs.plugin.downgrade.constant.ApiDowngradeConstant;
import id.dana.data.constant.BranchLinkConstant;

/* loaded from: classes8.dex */
public class az extends ba {
    private int MyBillsEntityDataFactory;
    private PendingIntent NetworkUserEntityData$$ExternalSyntheticLambda0;
    private Bitmap getErrorConfigVersion;
    private int lookAheadTest;
    private CharSequence moveToNextValue;
    private int scheduleImpl;

    public az(Context context, int i, String str) {
        super(context, i, str);
        this.MyBillsEntityDataFactory = 16777216;
        this.scheduleImpl = 16777216;
        this.lookAheadTest = 16777216;
    }

    private static Drawable KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2, int i3, float f) {
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(new RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, null, null));
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.setIntrinsicWidth(i2);
        shapeDrawable.setIntrinsicHeight(i3);
        return shapeDrawable;
    }

    private az KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        if (scheduleImpl() && !TextUtils.isEmpty(str)) {
            try {
                this.lookAheadTest = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("parse colorful notification image text color error");
            }
        }
        return this;
    }

    public final az BuiltInFictitiousFunctionClassFactory(String str) {
        if (scheduleImpl() && !TextUtils.isEmpty(str)) {
            try {
                this.MyBillsEntityDataFactory = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("parse colorful notification bg color error");
            }
        }
        return this;
    }

    public final az KClassImpl$Data$declaredNonStaticMembers$2(Bitmap bitmap) {
        if (scheduleImpl() && bitmap != null) {
            if (bitmap.getWidth() != 984 || bitmap.getHeight() < 177 || bitmap.getHeight() > 207) {
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("colorful notification bg image resolution error, must [984*177, 984*207]");
            } else {
                this.getErrorConfigVersion = bitmap;
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.ba
    protected final String KClassImpl$Data$declaredNonStaticMembers$2() {
        return "notification_colorful";
    }

    @Override // com.xiaomi.push.ba
    protected final String MyBillsEntityDataFactory() {
        return "notification_colorful_copy";
    }

    public final az PlaceComponentResult(String str) {
        if (scheduleImpl() && !TextUtils.isEmpty(str)) {
            try {
                this.scheduleImpl = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("parse colorful notification button bg color error");
            }
        }
        return this;
    }

    public final az getAuthRequestContext(CharSequence charSequence, PendingIntent pendingIntent) {
        if (scheduleImpl()) {
            super.addAction(0, charSequence, pendingIntent);
            this.moveToNextValue = charSequence;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = pendingIntent;
        }
        return this;
    }

    @Override // com.xiaomi.push.ba, com.xiaomi.push.ay
    public final void getAuthRequestContext() {
        RemoteViews lookAheadTest;
        Bitmap bitmap;
        RemoteViews lookAheadTest2;
        boolean z;
        RemoteViews lookAheadTest3;
        int i;
        float f;
        if (!scheduleImpl()) {
            getErrorConfigVersion();
            return;
        }
        super.getAuthRequestContext();
        Resources resources = PlaceComponentResult().getResources();
        String packageName = PlaceComponentResult().getPackageName();
        int identifier = !TextUtils.isEmpty("icon") ? resources.getIdentifier("icon", "id", packageName) : 0;
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            getAuthRequestContext(identifier);
        } else {
            lookAheadTest().setImageViewBitmap(identifier, this.BuiltInFictitiousFunctionClassFactory);
        }
        int identifier2 = !TextUtils.isEmpty("title") ? resources.getIdentifier("title", "id", packageName) : 0;
        int identifier3 = !TextUtils.isEmpty("content") ? resources.getIdentifier("content", "id", packageName) : 0;
        lookAheadTest().setTextViewText(identifier2, this.PlaceComponentResult);
        lookAheadTest().setTextViewText(identifier3, this.KClassImpl$Data$declaredNonStaticMembers$2);
        if (!TextUtils.isEmpty(this.moveToNextValue)) {
            int identifier4 = !TextUtils.isEmpty("buttonContainer") ? resources.getIdentifier("buttonContainer", "id", packageName) : 0;
            int identifier5 = !TextUtils.isEmpty(ApiDowngradeConstant.JsonKeys.BUTTON) ? resources.getIdentifier(ApiDowngradeConstant.JsonKeys.BUTTON, "id", packageName) : 0;
            int identifier6 = !TextUtils.isEmpty("buttonBg") ? resources.getIdentifier("buttonBg", "id", packageName) : 0;
            lookAheadTest().setViewVisibility(identifier4, 0);
            lookAheadTest().setTextViewText(identifier5, this.moveToNextValue);
            lookAheadTest().setOnClickPendingIntent(identifier4, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            if (this.scheduleImpl != 16777216) {
                int PlaceComponentResult = PlaceComponentResult(70.0f);
                int PlaceComponentResult2 = PlaceComponentResult(29.0f);
                lookAheadTest().setImageViewBitmap(identifier6, com.xiaomi.push.service.ag.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2(this.scheduleImpl, PlaceComponentResult, PlaceComponentResult2, PlaceComponentResult2 / 2.0f)));
                lookAheadTest().setTextColor(identifier5, PlaceComponentResult(this.scheduleImpl) ? -1 : -16777216);
            }
        }
        int identifier7 = !TextUtils.isEmpty("bg") ? resources.getIdentifier("bg", "id", packageName) : 0;
        int identifier8 = !TextUtils.isEmpty(BranchLinkConstant.PathTarget.CONTAINER) ? resources.getIdentifier(BranchLinkConstant.PathTarget.CONTAINER, "id", packageName) : 0;
        if (this.MyBillsEntityDataFactory != 16777216) {
            PlaceComponentResult();
            if (com.xiaomi.channel.commonutils.android.f.getAuthRequestContext() >= 10) {
                lookAheadTest3 = lookAheadTest();
                i = this.MyBillsEntityDataFactory;
                f = 30.0f;
            } else {
                lookAheadTest3 = lookAheadTest();
                i = this.MyBillsEntityDataFactory;
                f = 0.0f;
            }
            lookAheadTest3.setImageViewBitmap(identifier7, com.xiaomi.push.service.ag.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2(i, 984, 192, f)));
            lookAheadTest2 = lookAheadTest();
            z = PlaceComponentResult(this.MyBillsEntityDataFactory);
        } else if (this.getErrorConfigVersion == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                lookAheadTest().setViewVisibility(identifier, 8);
                lookAheadTest().setViewVisibility(identifier7, 8);
                try {
                    z.getAuthRequestContext(this, "setStyle", com.xiaomi.channel.commonutils.android.j.PlaceComponentResult(PlaceComponentResult(), "android.app.Notification$DecoratedCustomViewStyle").getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception unused) {
                    com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("load class DecoratedCustomViewStyle failed");
                }
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            MyBillsEntityDataFactory(bundle);
            MyBillsEntityDataFactory(lookAheadTest());
        } else {
            PlaceComponentResult();
            if (com.xiaomi.channel.commonutils.android.f.getAuthRequestContext() >= 10) {
                lookAheadTest = lookAheadTest();
                bitmap = PlaceComponentResult(this.getErrorConfigVersion);
            } else {
                lookAheadTest = lookAheadTest();
                bitmap = this.getErrorConfigVersion;
            }
            lookAheadTest.setImageViewBitmap(identifier7, bitmap);
            if (this.getAuthRequestContext != null && this.lookAheadTest == 16777216) {
                KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.get("notification_image_text_color"));
            }
            int i2 = this.lookAheadTest;
            boolean z2 = i2 == 16777216 || !PlaceComponentResult(i2);
            lookAheadTest2 = lookAheadTest();
            z = z2;
        }
        int PlaceComponentResult3 = PlaceComponentResult(6.0f);
        lookAheadTest2.setViewPadding(identifier8, PlaceComponentResult3, 0, PlaceComponentResult3, 0);
        int i3 = z ? -1 : -16777216;
        lookAheadTest2.setTextColor(identifier2, i3);
        lookAheadTest2.setTextColor(identifier3, i3);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("miui.customHeight", true);
        MyBillsEntityDataFactory(bundle2);
        MyBillsEntityDataFactory(lookAheadTest());
    }

    @Override // com.xiaomi.push.ba
    protected final boolean BuiltInFictitiousFunctionClassFactory() {
        if (com.xiaomi.channel.commonutils.android.f.BuiltInFictitiousFunctionClassFactory()) {
            Resources resources = PlaceComponentResult().getResources();
            String packageName = PlaceComponentResult().getPackageName();
            return ((!TextUtils.isEmpty("icon") ? resources.getIdentifier("icon", "id", packageName) : 0) == 0 || (!TextUtils.isEmpty("title") ? resources.getIdentifier("title", "id", packageName) : 0) == 0 || (!TextUtils.isEmpty("content") ? resources.getIdentifier("content", "id", packageName) : 0) == 0) ? false : true;
        }
        return false;
    }
}
