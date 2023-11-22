package id.dana.data.auth.face.repository.source.local;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0011\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u0007R\u0011\u0010\u0011\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0016\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0004R\u0011\u0010\u0018\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/data/auth/face/repository/source/local/FaceAuthSuggestionPreference;", "", "", "clearFaceAuthSuggestionState", "()Z", "hasShown", "saveFaceAuthSuggestionState", "(Z)Z", "", "currentTimeStamp", "", "saveFaceAuthSuggestionStateSavingTime", "(J)V", "shouldNeverShow", "saveNeverShowFaceAuthSuggestionState", "getFaceAuthSuggestionStateSavingTime", "()J", "faceAuthSuggestionStateSavingTime", "Lid/dana/data/storage/PreferenceFacade;", "preferenceFacade", "Lid/dana/data/storage/PreferenceFacade;", "getShouldNeverShowFaceAuthSuggestion", "shouldNeverShowFaceAuthSuggestion", "getShouldSuggestFaceAuth", "shouldSuggestFaceAuth", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FaceAuthSuggestionPreference {
    private static final String DIALOG_ON_BOARDING_FACE_LOGIN = "dialog_face_login_suggestion";
    private static final String DIALOG_ON_BOARDING_FACE_LOGIN_LAST_SAVE = "dialog_face_login_suggestion_last_save";
    private static final String NEVER_SHOW_DIALOG_ON_BOARDING_FACE_LOGIN = "never_show_dialog_face_login_suggestion";
    public static final String USER_EDUCATION_PREFERENCE = "UserEducationPreferenceproduction";
    private final PreferenceFacade preferenceFacade;

    @Inject
    public FaceAuthSuggestionPreference(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        PreferenceFacade createData = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup("UserEducationPreferenceproduction").setUseDrutherPreference(true)).createData("local");
        Intrinsics.checkNotNullExpressionValue(createData, "");
        this.preferenceFacade = createData;
    }

    @JvmName(name = "getShouldSuggestFaceAuth")
    public final boolean getShouldSuggestFaceAuth() {
        Boolean bool = this.preferenceFacade.getBoolean(DIALOG_ON_BOARDING_FACE_LOGIN, true);
        Intrinsics.checkNotNullExpressionValue(bool, "");
        return bool.booleanValue();
    }

    @JvmName(name = "getShouldNeverShowFaceAuthSuggestion")
    public final boolean getShouldNeverShowFaceAuthSuggestion() {
        Boolean bool = this.preferenceFacade.getBoolean(NEVER_SHOW_DIALOG_ON_BOARDING_FACE_LOGIN, false);
        Intrinsics.checkNotNullExpressionValue(bool, "");
        return bool.booleanValue();
    }

    public final boolean saveFaceAuthSuggestionState(boolean hasShown) {
        this.preferenceFacade.saveData(DIALOG_ON_BOARDING_FACE_LOGIN, Boolean.valueOf(!hasShown));
        return true;
    }

    public final boolean saveNeverShowFaceAuthSuggestionState(boolean shouldNeverShow) {
        this.preferenceFacade.saveData(NEVER_SHOW_DIALOG_ON_BOARDING_FACE_LOGIN, Boolean.valueOf(shouldNeverShow));
        return true;
    }

    public final boolean clearFaceAuthSuggestionState() {
        this.preferenceFacade.clearData(DIALOG_ON_BOARDING_FACE_LOGIN);
        return true;
    }

    public final void saveFaceAuthSuggestionStateSavingTime(long currentTimeStamp) {
        this.preferenceFacade.saveData(DIALOG_ON_BOARDING_FACE_LOGIN_LAST_SAVE, Long.valueOf(currentTimeStamp));
    }

    @JvmName(name = "getFaceAuthSuggestionStateSavingTime")
    public final long getFaceAuthSuggestionStateSavingTime() {
        Long l = this.preferenceFacade.getLong(DIALOG_ON_BOARDING_FACE_LOGIN_LAST_SAVE);
        Intrinsics.checkNotNullExpressionValue(l, "");
        return l.longValue();
    }
}
