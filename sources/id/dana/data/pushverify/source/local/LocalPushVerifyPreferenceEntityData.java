package id.dana.data.pushverify.source.local;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.pushverify.source.PushVerifyPreferenceEntityData;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0019\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00058\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/data/pushverify/source/local/LocalPushVerifyPreferenceEntityData;", "Lid/dana/data/pushverify/source/PushVerifyPreferenceEntityData;", "", "clearAll", "()V", "", "phoneNumber", "constructKey", "(Ljava/lang/String;)Ljava/lang/String;", "Lio/reactivex/Observable;", "", "isNotificationPromptDisabled", "(Ljava/lang/String;)Lio/reactivex/Observable;", "enabled", "Lio/reactivex/Completable;", "saveNotificationPromptPreference", "(Ljava/lang/String;Z)Lio/reactivex/Completable;", "Lid/dana/data/storage/PreferenceFacade;", "preferenceFacade", "Lid/dana/data/storage/PreferenceFacade;", "pushVerifyPreference", "Ljava/lang/String;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lid/dana/data/storage/Serializer;", "serializer", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalPushVerifyPreferenceEntityData implements PushVerifyPreferenceEntityData {
    private static final String KEY_NOTIFICATION_PROMPT_DISABLED = "KEY_NOTIFICATION_PROMPT_DISABLED";
    private final PreferenceFacade preferenceFacade;
    private final String pushVerifyPreference;

    @Inject
    public LocalPushVerifyPreferenceEntityData(Context context, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.pushVerifyPreference = "PushVerifyproduction";
        PreferenceFacade createData2 = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup("PushVerifyproduction").setUseDrutherPreference(true).setSerializerFacade(serializer)).createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        this.preferenceFacade = createData2;
    }

    @Override // id.dana.data.pushverify.source.PushVerifyPreferenceEntityData
    public final Completable saveNotificationPromptPreference(String phoneNumber, final boolean enabled) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        final String constructKey = constructKey(phoneNumber);
        Completable PlaceComponentResult = Completable.PlaceComponentResult(new Action() { // from class: id.dana.data.pushverify.source.local.LocalPushVerifyPreferenceEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Action
            public final void run() {
                LocalPushVerifyPreferenceEntityData.m1683saveNotificationPromptPreference$lambda1(LocalPushVerifyPreferenceEntityData.this, constructKey, enabled);
            }
        });
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveNotificationPromptPreference$lambda-1  reason: not valid java name */
    public static final void m1683saveNotificationPromptPreference$lambda1(LocalPushVerifyPreferenceEntityData localPushVerifyPreferenceEntityData, String str, boolean z) {
        Intrinsics.checkNotNullParameter(localPushVerifyPreferenceEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        localPushVerifyPreferenceEntityData.preferenceFacade.saveData(str, Boolean.valueOf(!z));
    }

    @Override // id.dana.data.pushverify.source.PushVerifyPreferenceEntityData
    public final Observable<Boolean> isNotificationPromptDisabled(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Boolean bool = this.preferenceFacade.getBoolean(constructKey(phoneNumber));
        Observable<Boolean> just = Observable.just(Boolean.valueOf(bool == null ? false : bool.booleanValue()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    public final void clearAll() {
        this.preferenceFacade.clearAllData();
    }

    private final String constructKey(String phoneNumber) {
        StringBuilder sb = new StringBuilder();
        sb.append("KEY_NOTIFICATION_PROMPT_DISABLED_");
        sb.append(phoneNumber);
        return sb.toString();
    }
}
