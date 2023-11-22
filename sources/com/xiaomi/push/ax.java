package com.xiaomi.push;

import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;

/* loaded from: classes8.dex */
public class ax extends ba {
    private int MyBillsEntityDataFactory;
    private Bitmap lookAheadTest;
    private Bitmap moveToNextValue;

    public ax(Context context, String str) {
        super(context, str);
        this.MyBillsEntityDataFactory = 16777216;
    }

    private ax BuiltInFictitiousFunctionClassFactory(String str) {
        if (scheduleImpl() && !TextUtils.isEmpty(str)) {
            try {
                this.MyBillsEntityDataFactory = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("parse banner notification image text color error");
            }
        }
        return this;
    }

    public final ax BuiltInFictitiousFunctionClassFactory(Bitmap bitmap) {
        if (scheduleImpl() && bitmap != null) {
            if (bitmap.getWidth() != 984 || 184 > bitmap.getHeight() || bitmap.getHeight() > 1678) {
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("colorful notification banner image resolution error, must belong to [984*184, 984*1678]");
            } else {
                this.moveToNextValue = bitmap;
            }
        }
        return this;
    }

    public final ax KClassImpl$Data$declaredNonStaticMembers$2(Bitmap bitmap) {
        if (scheduleImpl() && bitmap != null) {
            this.lookAheadTest = bitmap;
        }
        return this;
    }

    @Override // com.xiaomi.push.ba
    protected final String KClassImpl$Data$declaredNonStaticMembers$2() {
        return "notification_banner";
    }

    @Override // com.xiaomi.push.ba
    protected final String MyBillsEntityDataFactory() {
        return null;
    }

    @Override // com.xiaomi.push.ba
    /* renamed from: getAuthRequestContext */
    public final ba setLargeIcon(Bitmap bitmap) {
        return this;
    }

    @Override // com.xiaomi.push.ba, android.app.Notification.Builder
    public /* synthetic */ Notification.Builder setLargeIcon(Bitmap bitmap) {
        return this;
    }

    @Override // com.xiaomi.push.ba, com.xiaomi.push.ay
    public final void getAuthRequestContext() {
        RemoteViews lookAheadTest;
        Bitmap bitmap;
        if (!scheduleImpl() || this.moveToNextValue == null) {
            getErrorConfigVersion();
            return;
        }
        super.getAuthRequestContext();
        Resources resources = PlaceComponentResult().getResources();
        String packageName = PlaceComponentResult().getPackageName();
        int identifier = !TextUtils.isEmpty("bg") ? resources.getIdentifier("bg", "id", packageName) : 0;
        PlaceComponentResult();
        if (com.xiaomi.channel.commonutils.android.f.getAuthRequestContext() >= 10) {
            lookAheadTest = lookAheadTest();
            bitmap = PlaceComponentResult(this.moveToNextValue);
        } else {
            lookAheadTest = lookAheadTest();
            bitmap = this.moveToNextValue;
        }
        lookAheadTest.setImageViewBitmap(identifier, bitmap);
        int identifier2 = !TextUtils.isEmpty("icon") ? resources.getIdentifier("icon", "id", packageName) : 0;
        if (this.lookAheadTest != null) {
            lookAheadTest().setImageViewBitmap(identifier2, this.lookAheadTest);
        } else {
            getAuthRequestContext(identifier2);
        }
        int identifier3 = TextUtils.isEmpty("title") ? 0 : resources.getIdentifier("title", "id", packageName);
        lookAheadTest().setTextViewText(identifier3, this.PlaceComponentResult);
        if (this.getAuthRequestContext != null && this.MyBillsEntityDataFactory == 16777216) {
            BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.get("notification_image_text_color"));
        }
        RemoteViews lookAheadTest2 = lookAheadTest();
        int i = this.MyBillsEntityDataFactory;
        lookAheadTest2.setTextColor(identifier3, (i == 16777216 || !PlaceComponentResult(i)) ? -1 : -16777216);
        MyBillsEntityDataFactory(lookAheadTest());
        Bundle bundle = new Bundle();
        bundle.putBoolean("miui.customHeight", true);
        MyBillsEntityDataFactory(bundle);
    }

    @Override // com.xiaomi.push.ba
    protected final boolean BuiltInFictitiousFunctionClassFactory() {
        if (com.xiaomi.channel.commonutils.android.f.BuiltInFictitiousFunctionClassFactory()) {
            Resources resources = PlaceComponentResult().getResources();
            String packageName = PlaceComponentResult().getPackageName();
            int identifier = !TextUtils.isEmpty("bg") ? PlaceComponentResult().getResources().getIdentifier("bg", "id", PlaceComponentResult().getPackageName()) : 0;
            int identifier2 = !TextUtils.isEmpty("icon") ? resources.getIdentifier("icon", "id", packageName) : 0;
            int identifier3 = !TextUtils.isEmpty("title") ? resources.getIdentifier("title", "id", packageName) : 0;
            if (identifier == 0 || identifier2 == 0 || identifier3 == 0) {
                return false;
            }
            PlaceComponentResult();
            return com.xiaomi.channel.commonutils.android.f.getAuthRequestContext() >= 9;
        }
        return false;
    }
}
