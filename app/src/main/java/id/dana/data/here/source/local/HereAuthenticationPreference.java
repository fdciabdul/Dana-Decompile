package id.dana.data.here.source.local;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.here.model.HereAuthentication;
import id.dana.data.here.model.HereBackoffData;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import id.dana.utils.foundation.logger.log.DanaLog;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0019\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b'\u0010(J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0019\u001a\u00020\u00188\u0007¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010#\u001a\u00020\"8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&"}, d2 = {"Lid/dana/data/here/source/local/HereAuthenticationPreference;", "", "Lid/dana/data/here/model/HereBackoffData;", "getBackoffData", "()Lid/dana/data/here/model/HereBackoffData;", "Lid/dana/data/here/model/HereAuthentication;", "getHereAuthentication", "()Lid/dana/data/here/model/HereAuthentication;", "", "resetBackoffData", "()Z", "backoffData", "saveBackoffData", "(Lid/dana/data/here/model/HereBackoffData;)Z", "auth", "saveHereAuthentication", "(Lid/dana/data/here/model/HereAuthentication;)Z", "", "key", "Lkotlin/Function0;", "", "action", "tryAndReturnBoolean", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Z", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "hereAuthPreferenceGroup", "Ljava/lang/String;", "Lid/dana/data/storage/PreferenceFacade;", "preferenceFacade", "Lid/dana/data/storage/PreferenceFacade;", "Lid/dana/data/storage/Serializer;", "serializer", "Lid/dana/data/storage/Serializer;", "getSerializer", "()Lid/dana/data/storage/Serializer;", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HereAuthenticationPreference {
    private static final String HERE_AUTH = "here_auth_key";
    private static final String HERE_BACK_OFF = "here_back_off";
    private final Context context;
    private final String hereAuthPreferenceGroup;
    private final PreferenceFacade preferenceFacade;
    private final Serializer serializer;

    @Inject
    public HereAuthenticationPreference(Context context, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.context = context;
        this.serializer = serializer;
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("production");
        String obj = sb.toString();
        this.hereAuthPreferenceGroup = obj;
        PreferenceFacade createData2 = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(obj).setUseDrutherPreference(true).setSerializerFacade(serializer)).createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        this.preferenceFacade = createData2;
    }

    @JvmName(name = "getContext")
    public final Context getContext() {
        return this.context;
    }

    @JvmName(name = "getSerializer")
    public final Serializer getSerializer() {
        return this.serializer;
    }

    public final boolean saveHereAuthentication(final HereAuthentication auth) {
        Intrinsics.checkNotNullParameter(auth, "");
        return tryAndReturnBoolean(HERE_AUTH, new Function0<Unit>() { // from class: id.dana.data.here.source.local.HereAuthenticationPreference$saveHereAuthentication$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PreferenceFacade preferenceFacade;
                preferenceFacade = HereAuthenticationPreference.this.preferenceFacade;
                preferenceFacade.saveData("here_auth_key", (String) auth);
            }
        });
    }

    public final HereAuthentication getHereAuthentication() {
        HereAuthentication hereAuthentication = (HereAuthentication) this.preferenceFacade.getObject(HERE_AUTH, HereAuthentication.class);
        return hereAuthentication == null ? new HereAuthentication(null, 0L, 3, null) : hereAuthentication;
    }

    public final boolean saveBackoffData(final HereBackoffData backoffData) {
        Intrinsics.checkNotNullParameter(backoffData, "");
        return tryAndReturnBoolean(HERE_BACK_OFF, new Function0<Unit>() { // from class: id.dana.data.here.source.local.HereAuthenticationPreference$saveBackoffData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PreferenceFacade preferenceFacade;
                preferenceFacade = HereAuthenticationPreference.this.preferenceFacade;
                preferenceFacade.saveData("here_back_off", (String) backoffData);
            }
        });
    }

    public final HereBackoffData getBackoffData() {
        HereBackoffData hereBackoffData = (HereBackoffData) this.preferenceFacade.getObject(HERE_BACK_OFF, HereBackoffData.class);
        return hereBackoffData == null ? new HereBackoffData(false, 0L, 0, 7, null) : hereBackoffData;
    }

    public final boolean resetBackoffData() {
        return tryAndReturnBoolean(HERE_BACK_OFF, new Function0<Unit>() { // from class: id.dana.data.here.source.local.HereAuthenticationPreference$resetBackoffData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PreferenceFacade preferenceFacade;
                preferenceFacade = HereAuthenticationPreference.this.preferenceFacade;
                preferenceFacade.saveData("here_back_off", (String) new HereBackoffData(false, System.currentTimeMillis(), 0, 5, null));
            }
        });
    }

    private final boolean tryAndReturnBoolean(String key, Function0<Unit> action) {
        try {
            action.invoke();
            return true;
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(this.hereAuthPreferenceGroup, key, e);
            return false;
        }
    }
}
