package id.dana.data.promocenter.repository.source.local;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.data.promocenter.repository.source.local.model.UserCoordinateEntityData;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import id.dana.data.storage.SimpleSecureKeyPreference;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0019\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ$\u0010\u0007\u001a\u00020\u00062\r\u0010\u0004\u001a\t\u0018\u00010\u0002¢\u0006\u0002\b\u00032\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/data/promocenter/repository/source/local/PromoAdsPreferences;", "", "", "Lorg/jetbrains/annotations/NotNull;", "phoneNumber", "source", "", "getCurrentAdsPageNumber", "(Ljava/lang/String;Ljava/lang/String;)I", "Lid/dana/data/promocenter/repository/source/local/model/UserCoordinateEntityData;", "getUserLastCoordinate", "(Ljava/lang/String;)Lid/dana/data/promocenter/repository/source/local/model/UserCoordinateEntityData;", ZdocRecordService.PAGE_NUMBER, "", "saveCurrentAdsPageNumber", "(Ljava/lang/String;ILjava/lang/String;)V", "userCoordinateEntityData", "", "saveUserLastCoordinate", "(Ljava/lang/String;Lid/dana/data/promocenter/repository/source/local/model/UserCoordinateEntityData;)Z", "Lid/dana/data/storage/PreferenceFacade;", "preferenceFacade", "Lid/dana/data/storage/PreferenceFacade;", "Lid/dana/data/storage/Serializer;", "serializer", "Lid/dana/data/storage/Serializer;", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PromoAdsPreferences {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String PROMO_ADS_PREFERENCES;
    private final PreferenceFacade preferenceFacade;
    private final Serializer serializer;

    @Inject
    public PromoAdsPreferences(Context context, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.serializer = serializer;
        PreferenceFacade createData2 = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(PROMO_ADS_PREFERENCES).setSerializerFacade(serializer)).createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        this.preferenceFacade = new SimpleSecureKeyPreference(createData2);
    }

    public final UserCoordinateEntityData getUserLastCoordinate(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Object object = this.preferenceFacade.getObject(INSTANCE.getUsersCoordinatePreferenceKey(phoneNumber), UserCoordinateEntityData.class);
        Intrinsics.checkNotNullExpressionValue(object, "");
        return (UserCoordinateEntityData) object;
    }

    public final boolean saveUserLastCoordinate(String phoneNumber, UserCoordinateEntityData userCoordinateEntityData) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Intrinsics.checkNotNullParameter(userCoordinateEntityData, "");
        this.preferenceFacade.saveData(INSTANCE.getUsersCoordinatePreferenceKey(phoneNumber), this.serializer.serialize(userCoordinateEntityData));
        Unit unit = Unit.INSTANCE;
        return true;
    }

    public final void saveCurrentAdsPageNumber(String phoneNumber, int pageNumber, String source) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Intrinsics.checkNotNullParameter(source, "");
        this.preferenceFacade.saveData(INSTANCE.getAdsCurrentPagePreferenceKey(phoneNumber, source), Integer.valueOf(pageNumber));
    }

    public final int getCurrentAdsPageNumber(String phoneNumber, String source) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Intrinsics.checkNotNullParameter(source, "");
        Integer integer = this.preferenceFacade.getInteger(INSTANCE.getAdsCurrentPagePreferenceKey(phoneNumber, source));
        if (integer == null || integer.intValue() != -1) {
            Intrinsics.checkNotNullExpressionValue(integer, "");
            return integer.intValue();
        }
        return 0;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/data/promocenter/repository/source/local/PromoAdsPreferences$Companion;", "", "", "phoneNumber", "source", "getAdsCurrentPagePreferenceKey", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "getUsersCoordinatePreferenceKey", "(Ljava/lang/String;)Ljava/lang/String;", "PROMO_ADS_PREFERENCES", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getUsersCoordinatePreferenceKey(String phoneNumber) {
            StringBuilder sb = new StringBuilder();
            sb.append("user_[");
            sb.append(phoneNumber);
            sb.append("]_promo_ads_coordinate_lat_long");
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getAdsCurrentPagePreferenceKey(String phoneNumber, String source) {
            if (source.length() > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("user_[");
                sb.append(phoneNumber);
                sb.append("]_source_[");
                sb.append(source);
                sb.append("]_promo_ads_current_page");
                return sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("user_[");
            sb2.append(phoneNumber);
            sb2.append("]_promo_ads_current_page");
            return sb2.toString();
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("PromoAdsPreferences");
        sb.append("production");
        PROMO_ADS_PREFERENCES = sb.toString();
    }
}
