package id.dana.data.referral.source.local;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.referral.source.local.model.ReferralDialogDailyLimitEntity;
import id.dana.data.referral.source.local.model.ReferralEngagementDialogCacheEntity;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import id.dana.utils.extension.JSONExtKt;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0019\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000e\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/data/referral/source/local/ReferralEngagementPreference;", "", "Lid/dana/data/referral/source/local/model/ReferralDialogDailyLimitEntity;", "getDailyLimitCache", "()Lid/dana/data/referral/source/local/model/ReferralDialogDailyLimitEntity;", "", "Lid/dana/data/referral/source/local/model/ReferralEngagementDialogCacheEntity;", "getDialogCaches", "()Ljava/util/List;", "dailyLimitEntity", "", "saveDailyLimit", "(Lid/dana/data/referral/source/local/model/ReferralDialogDailyLimitEntity;)V", "referralEngagementDialogCacheEntities", "saveDialogCache", "(Ljava/util/List;)V", "Lid/dana/data/storage/PreferenceFacade;", "preferenceFacade", "Lid/dana/data/storage/PreferenceFacade;", "Lid/dana/data/storage/Serializer;", "serializer", "Lid/dana/data/storage/Serializer;", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ReferralEngagementPreference {
    private static final String DAILY_LIMIT_KEY = "daily_limit";
    private static final String DIALOG_CACHE_KEY = "dialog_cache";
    private static final String REFERRAL_ENGAGEMENT_PREFERENCE;
    private final PreferenceFacade preferenceFacade;
    private final Serializer serializer;

    @Inject
    public ReferralEngagementPreference(Context context, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.serializer = serializer;
        PreferenceFacade createData2 = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(REFERRAL_ENGAGEMENT_PREFERENCE).setSerializerFacade(serializer)).createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        this.preferenceFacade = createData2;
    }

    public final void saveDialogCache(List<ReferralEngagementDialogCacheEntity> referralEngagementDialogCacheEntities) {
        Intrinsics.checkNotNullParameter(referralEngagementDialogCacheEntities, "");
        this.preferenceFacade.saveData(DIALOG_CACHE_KEY, this.serializer.serialize(referralEngagementDialogCacheEntities));
    }

    public final List<ReferralEngagementDialogCacheEntity> getDialogCaches() {
        List<ReferralEngagementDialogCacheEntity> deserializeList = this.serializer.deserializeList(this.preferenceFacade.getString(DIALOG_CACHE_KEY), ReferralEngagementDialogCacheEntity.class);
        Intrinsics.checkNotNullExpressionValue(deserializeList, "");
        return deserializeList;
    }

    public final void saveDailyLimit(ReferralDialogDailyLimitEntity dailyLimitEntity) {
        Intrinsics.checkNotNullParameter(dailyLimitEntity, "");
        this.preferenceFacade.saveData(DAILY_LIMIT_KEY, this.serializer.serialize(dailyLimitEntity));
    }

    public final ReferralDialogDailyLimitEntity getDailyLimitCache() {
        Object obj = null;
        try {
            obj = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(this.preferenceFacade.getString(DAILY_LIMIT_KEY), null), (Class<Object>) ReferralDialogDailyLimitEntity.class);
        } catch (Exception unused) {
        }
        return (ReferralDialogDailyLimitEntity) obj;
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("ReferralEngagementPreference");
        sb.append("production");
        REFERRAL_ENGAGEMENT_PREFERENCE = sb.toString();
    }
}
