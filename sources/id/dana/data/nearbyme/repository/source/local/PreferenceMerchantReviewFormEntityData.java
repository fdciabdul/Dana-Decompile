package id.dana.data.nearbyme.repository.source.local;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.contract.deeplink.path.FeatureParams;
import id.dana.data.nearbyme.repository.MerchantReviewFormEntityData;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import id.dana.data.storage.SimpleSecureKeyPreference;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u0019\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b#\u0010$J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\u00020\u00148\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\u00020\u001e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\""}, d2 = {"Lid/dana/data/nearbyme/repository/source/local/PreferenceMerchantReviewFormEntityData;", "Lid/dana/data/nearbyme/repository/MerchantReviewFormEntityData;", "", "clearAll", "()V", "", FeatureParams.SHOP_ID, "phoneNumber", "", "getDismissedMerchantReview", "(Ljava/lang/String;Ljava/lang/String;)Z", "", "getLastTimeMerchantReviewShown", "(Ljava/lang/String;)J", "lastTimeMerchantReviewShown", "saveLastTimeMerchantReviewShown", "(Ljava/lang/String;J)V", "isDismissed", "setDismissedMerchantReview", "(Ljava/lang/String;Ljava/lang/String;Z)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "merchantReviewPreference", "Ljava/lang/String;", "Lid/dana/data/storage/PreferenceFacade;", "preferenceFacade", "Lid/dana/data/storage/PreferenceFacade;", "Lid/dana/data/storage/Serializer;", "serializer", "Lid/dana/data/storage/Serializer;", "getSerializer", "()Lid/dana/data/storage/Serializer;", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PreferenceMerchantReviewFormEntityData implements MerchantReviewFormEntityData {
    private static final String LAST_TIME_MERCHANT_REVIEW_KEY = "LAST_TIME_MERCHANT_REVIEW_KEY";
    private static final String SHOP_ID_DISMISSED_FORM = "SHOP_ID_DISMISSED_FORM";
    private final Context context;
    private final String merchantReviewPreference;
    private final PreferenceFacade preferenceFacade;
    private final Serializer serializer;

    @Inject
    public PreferenceMerchantReviewFormEntityData(Context context, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.context = context;
        this.serializer = serializer;
        StringBuilder sb = new StringBuilder();
        sb.append("PreferenceMerchantReviewFormEntityData");
        sb.append("production");
        String obj = sb.toString();
        this.merchantReviewPreference = obj;
        PreferenceFacade createData2 = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(obj).setUseDrutherPreference(true).setSerializerFacade(serializer)).createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        this.preferenceFacade = new SimpleSecureKeyPreference(createData2);
    }

    @JvmName(name = "getContext")
    public final Context getContext() {
        return this.context;
    }

    @JvmName(name = "getSerializer")
    public final Serializer getSerializer() {
        return this.serializer;
    }

    @Override // id.dana.data.nearbyme.repository.MerchantReviewFormEntityData
    public final long getLastTimeMerchantReviewShown(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(phoneNumber);
        sb.append(LAST_TIME_MERCHANT_REVIEW_KEY);
        Long l = preferenceFacade.getLong(sb.toString());
        Intrinsics.checkNotNullExpressionValue(l, "");
        if (l.longValue() < 0) {
            return 0L;
        }
        return l.longValue();
    }

    @Override // id.dana.data.nearbyme.repository.MerchantReviewFormEntityData
    public final void saveLastTimeMerchantReviewShown(String phoneNumber, long lastTimeMerchantReviewShown) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(phoneNumber);
        sb.append(LAST_TIME_MERCHANT_REVIEW_KEY);
        preferenceFacade.saveData(sb.toString(), Long.valueOf(lastTimeMerchantReviewShown));
    }

    @Override // id.dana.data.nearbyme.repository.MerchantReviewFormEntityData
    public final void setDismissedMerchantReview(String shopId, String phoneNumber, boolean isDismissed) {
        Intrinsics.checkNotNullParameter(shopId, "");
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(shopId);
        sb.append(phoneNumber);
        sb.append(SHOP_ID_DISMISSED_FORM);
        preferenceFacade.saveData(sb.toString(), Boolean.valueOf(isDismissed));
    }

    @Override // id.dana.data.nearbyme.repository.MerchantReviewFormEntityData
    public final boolean getDismissedMerchantReview(String shopId, String phoneNumber) {
        Intrinsics.checkNotNullParameter(shopId, "");
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(shopId);
        sb.append(phoneNumber);
        sb.append(SHOP_ID_DISMISSED_FORM);
        Boolean bool = preferenceFacade.getBoolean(sb.toString());
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final void clearAll() {
        this.preferenceFacade.clearAllData();
    }
}
