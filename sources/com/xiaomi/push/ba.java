package com.xiaomi.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.alipay.mobile.zebra.data.BoxData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public abstract class ba extends ay {
    protected Bitmap BuiltInFictitiousFunctionClassFactory;
    private boolean DatabaseTableConfigUtil;
    protected CharSequence KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    private String NetworkUserEntityData$$ExternalSyntheticLambda0;
    protected CharSequence PlaceComponentResult;
    protected Map<String, String> getAuthRequestContext;
    private int getErrorConfigVersion;
    private RemoteViews lookAheadTest;
    private boolean moveToNextValue;
    private ArrayList<Notification.Action> scheduleImpl;

    public ba(Context context, String str) {
        this(context, 0, str);
    }

    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return (TextUtils.isEmpty(MyBillsEntityDataFactory()) || TextUtils.isEmpty(this.NetworkUserEntityData$$ExternalSyntheticLambda0)) ? false : true;
    }

    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1() {
        return NetworkUserEntityData$$ExternalSyntheticLambda0() && initRecordTimeStamp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Bitmap PlaceComponentResult(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawRoundRect(new RectF(rect), 30.0f, 30.0f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean PlaceComponentResult(int i) {
        double red = Color.red(i);
        double green = Color.green(i);
        double blue = Color.blue(i);
        Double.isNaN(red);
        Double.isNaN(green);
        Double.isNaN(blue);
        return ((red * 0.299d) + (green * 0.587d)) + (blue * 0.114d) < 192.0d;
    }

    private boolean initRecordTimeStamp() {
        List<StatusBarNotification> MyBillsEntityDataFactory;
        if (Build.VERSION.SDK_INT >= 20 && (MyBillsEntityDataFactory = com.xiaomi.push.service.aq.PlaceComponentResult(PlaceComponentResult(), this.NetworkUserEntityData$$ExternalSyntheticLambda0).MyBillsEntityDataFactory()) != null && !MyBillsEntityDataFactory.isEmpty()) {
            for (StatusBarNotification statusBarNotification : MyBillsEntityDataFactory) {
                if (statusBarNotification.getId() == this.MyBillsEntityDataFactory) {
                    if (statusBarNotification.getNotification() == null) {
                        return false;
                    }
                    return !r0.extras.getBoolean("mipush.customCopyLayout", true);
                }
            }
        }
        return false;
    }

    private boolean moveToNextValue() {
        Map<String, String> map = this.getAuthRequestContext;
        return map != null && Boolean.parseBoolean(map.get("custom_builder_set_title"));
    }

    protected abstract boolean BuiltInFictitiousFunctionClassFactory();

    protected abstract String KClassImpl$Data$declaredNonStaticMembers$2();

    protected abstract String MyBillsEntityDataFactory();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int PlaceComponentResult(float f) {
        return (int) ((f * PlaceComponentResult().getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // com.xiaomi.push.ay
    public final ay PlaceComponentResult(Map<String, String> map) {
        this.getAuthRequestContext = map;
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
    public ba setLargeIcon(Bitmap bitmap) {
        this.BuiltInFictitiousFunctionClassFactory = bitmap;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void getErrorConfigVersion() {
        super.setContentTitle(this.PlaceComponentResult);
        super.setContentText(this.KClassImpl$Data$declaredNonStaticMembers$2);
        Bitmap bitmap = this.BuiltInFictitiousFunctionClassFactory;
        if (bitmap != null) {
            super.setLargeIcon(bitmap);
        }
    }

    public final RemoteViews lookAheadTest() {
        return this.lookAheadTest;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean scheduleImpl() {
        return this.moveToNextValue;
    }

    public ba(Context context, int i, String str) {
        super(context);
        this.scheduleImpl = new ArrayList<>();
        this.getErrorConfigVersion = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
        this.MyBillsEntityDataFactory = i;
        Resources resources = PlaceComponentResult().getResources();
        boolean NetworkUserEntityData$$ExternalSyntheticLambda1 = NetworkUserEntityData$$ExternalSyntheticLambda1();
        this.DatabaseTableConfigUtil = NetworkUserEntityData$$ExternalSyntheticLambda1;
        String MyBillsEntityDataFactory = NetworkUserEntityData$$ExternalSyntheticLambda1 ? MyBillsEntityDataFactory() : KClassImpl$Data$declaredNonStaticMembers$2();
        int identifier = TextUtils.isEmpty(MyBillsEntityDataFactory) ? 0 : resources.getIdentifier(MyBillsEntityDataFactory, BoxData.ATTR_LAYOUT, PlaceComponentResult().getPackageName());
        if (identifier == 0) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("create RemoteViews failed, no such layout resource was found");
            return;
        }
        this.lookAheadTest = new RemoteViews(PlaceComponentResult().getPackageName(), identifier);
        this.moveToNextValue = BuiltInFictitiousFunctionClassFactory();
    }

    @Override // android.app.Notification.Builder
    /* renamed from: PlaceComponentResult  reason: merged with bridge method [inline-methods] */
    public final ba addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        this.scheduleImpl.add(new Notification.Action(i, charSequence, pendingIntent));
        this.getErrorConfigVersion++;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.ay
    public void getAuthRequestContext() {
        super.getAuthRequestContext();
        Bundle bundle = new Bundle();
        if (NetworkUserEntityData$$ExternalSyntheticLambda0()) {
            bundle.putBoolean("mipush.customCopyLayout", this.DatabaseTableConfigUtil);
        } else {
            bundle.putBoolean("mipush.customCopyLayout", false);
        }
        bundle.putBoolean("miui.customHeight", false);
        bundle.putBoolean("mipush.customNotification", true);
        bundle.putInt("mipush.customLargeIconId", getAuthRequestContext("large_icon"));
        if (this.scheduleImpl.size() > 0) {
            Notification.Action[] actionArr = new Notification.Action[this.scheduleImpl.size()];
            this.scheduleImpl.toArray(actionArr);
            bundle.putParcelableArray("mipush.customActions", actionArr);
        }
        if (moveToNextValue() || !com.xiaomi.push.service.ar.getAuthRequestContext(PlaceComponentResult().getContentResolver())) {
            super.setContentTitle(this.PlaceComponentResult);
            super.setContentText(this.KClassImpl$Data$declaredNonStaticMembers$2);
        } else {
            bundle.putCharSequence("mipush.customTitle", this.PlaceComponentResult);
            bundle.putCharSequence("mipush.customContent", this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        MyBillsEntityDataFactory(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void getAuthRequestContext(int i) {
        Bitmap PlaceComponentResult = com.xiaomi.push.service.ag.PlaceComponentResult(com.xiaomi.channel.commonutils.android.a.MyBillsEntityDataFactory(PlaceComponentResult(), this.NetworkUserEntityData$$ExternalSyntheticLambda0));
        if (PlaceComponentResult != null) {
            this.lookAheadTest.setImageViewBitmap(i, PlaceComponentResult);
            return;
        }
        int PlaceComponentResult2 = com.xiaomi.channel.commonutils.android.a.PlaceComponentResult(PlaceComponentResult(), this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        if (PlaceComponentResult2 != 0) {
            this.lookAheadTest.setImageViewResource(i, PlaceComponentResult2);
        }
    }

    @Override // android.app.Notification.Builder
    public /* synthetic */ Notification.Builder addAction(Notification.Action action) {
        if (action != null) {
            this.scheduleImpl.add(action);
        }
        this.getErrorConfigVersion++;
        return this;
    }

    @Override // android.app.Notification.Builder
    public /* synthetic */ Notification.Builder setContentText(CharSequence charSequence) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = charSequence;
        return this;
    }

    @Override // android.app.Notification.Builder
    public /* synthetic */ Notification.Builder setContentTitle(CharSequence charSequence) {
        this.PlaceComponentResult = charSequence;
        return this;
    }
}
