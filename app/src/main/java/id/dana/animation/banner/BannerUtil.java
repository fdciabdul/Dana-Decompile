package id.dana.animation.banner;

import android.content.Context;
import android.graphics.Bitmap;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.model.CdpContentModel;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.BitmapUtil;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.LocaleUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/home/banner/BannerUtil;", "", "Landroid/content/Context;", "p0", "Landroid/graphics/Bitmap;", "p1", "Lid/dana/model/CdpContentModel;", "p2", "", "p3", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;Landroid/graphics/Bitmap;Lid/dana/model/CdpContentModel;Ljava/lang/String;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BannerUtil {
    public static final BannerUtil INSTANCE = new BannerUtil();

    private BannerUtil() {
    }

    @JvmStatic
    public static final void KClassImpl$Data$declaredNonStaticMembers$2(Context p0, Bitmap p1, CdpContentModel p2, String p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        int PlaceComponentResult = BitmapUtil.PlaceComponentResult(p1) / 1024;
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(p0.getApplicationContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.PROMOTION_BANNER_DOWNLOAD_FINISH;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_CONTENT_ID, p2.NetworkUserEntityData$$ExternalSyntheticLambda2).MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_CONTENT_TYPE, p2.DatabaseTableConfigUtil).MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_CONTENT_NAME, p2.NetworkUserEntityData$$ExternalSyntheticLambda1).MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_EXPIRY_DATE, DateTimeUtil.MyBillsEntityDataFactory(p2.PrepareContext, "yyyy-MM-dd'T'HH:mm:ss", LocaleUtil.getAuthRequestContext())).MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_SPACE_CODE, p2.whenAvailable).PlaceComponentResult(TrackerKey.PromotionProperty.FILE_SIZE, PlaceComponentResult).MyBillsEntityDataFactory(TrackerKey.PromotionProperty.BANNER_URL, p2.GetContactSyncConfig).MyBillsEntityDataFactory("UUID", p3);
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
    }
}
