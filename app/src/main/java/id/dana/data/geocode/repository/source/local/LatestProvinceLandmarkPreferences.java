package id.dana.data.geocode.repository.source.local;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/data/geocode/repository/source/local/LatestProvinceLandmarkPreferences;", "", "", "getLatestProvinceLandmark", "()Ljava/lang/String;", "provinceName", "", "saveLatestProvinceLandmark", "(Ljava/lang/String;)Z", "Lid/dana/data/storage/PreferenceFacade;", "preferenceFacade", "Lid/dana/data/storage/PreferenceFacade;", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LatestProvinceLandmarkPreferences {
    private static final String LATEST_PROVINCE_LANDMARK = "LATEST_PROVINCE_LANDMARK";
    private static final String LATEST_PROVINCE_LANDMARK_PREFERENCE = "LatestProvinceLandmarkPreferencesproduction";
    private final PreferenceFacade preferenceFacade;

    @Inject
    public LatestProvinceLandmarkPreferences(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        PreferenceFacade createData = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(LATEST_PROVINCE_LANDMARK_PREFERENCE).setUseDrutherPreference(true)).createData("local");
        Intrinsics.checkNotNullExpressionValue(createData, "");
        this.preferenceFacade = createData;
    }

    public final String getLatestProvinceLandmark() {
        String string = this.preferenceFacade.getString(LATEST_PROVINCE_LANDMARK);
        return string == null ? "" : string;
    }

    public final boolean saveLatestProvinceLandmark(String provinceName) {
        Intrinsics.checkNotNullParameter(provinceName, "");
        this.preferenceFacade.saveData(LATEST_PROVINCE_LANDMARK, provinceName);
        return true;
    }
}
