package id.dana.data.wallet_v3.repository.source.local;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import id.dana.data.storage.SimpleSecureKeyPreference;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0019\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0006J\u001d\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/data/wallet_v3/repository/source/local/PersonalTabPreference;", "", "", "phoneNumber", "", "getKtpPopUpCheck", "(Ljava/lang/String;)Z", "isFirstTimeCheck", "saveFirstTimeCheck", "ktpIsSaved", "saveKtpPopUpCheck", "(Ljava/lang/String;Z)Z", "personalTabPreference", "Ljava/lang/String;", "Lid/dana/data/storage/PreferenceFacade;", "preferenceFacade", "Lid/dana/data/storage/PreferenceFacade;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lid/dana/data/storage/Serializer;", "serializer", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PersonalTabPreference {
    private static final String FIRST_TIME_CHECK = "FIRST_TIME_CHECK";
    private static final String SHOW_USER_CONSULT_POP_UP = "SHOW_USER_CONSULT_POP_UP";
    private final String personalTabPreference;
    private final PreferenceFacade preferenceFacade;

    @Inject
    public PersonalTabPreference(Context context, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.personalTabPreference = "PersonalTabPreferenceproduction";
        PreferenceFacade createData2 = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup("PersonalTabPreferenceproduction").setUseDrutherPreference(true).setSerializerFacade(serializer)).createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        this.preferenceFacade = new SimpleSecureKeyPreference(createData2);
    }

    public final boolean isFirstTimeCheck(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(FIRST_TIME_CHECK);
        sb.append(phoneNumber);
        Boolean bool = preferenceFacade.getBoolean(sb.toString(), true);
        Intrinsics.checkNotNullExpressionValue(bool, "");
        return bool.booleanValue();
    }

    public final boolean saveFirstTimeCheck(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(FIRST_TIME_CHECK);
        sb.append(phoneNumber);
        preferenceFacade.saveData(sb.toString(), Boolean.FALSE);
        return true;
    }

    public final boolean getKtpPopUpCheck(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(SHOW_USER_CONSULT_POP_UP);
        sb.append(phoneNumber);
        Boolean bool = preferenceFacade.getBoolean(sb.toString(), false);
        Intrinsics.checkNotNullExpressionValue(bool, "");
        return bool.booleanValue();
    }

    public final boolean saveKtpPopUpCheck(String phoneNumber, boolean ktpIsSaved) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(SHOW_USER_CONSULT_POP_UP);
        sb.append(phoneNumber);
        preferenceFacade.saveData(sb.toString(), Boolean.valueOf(ktpIsSaved));
        return true;
    }
}
