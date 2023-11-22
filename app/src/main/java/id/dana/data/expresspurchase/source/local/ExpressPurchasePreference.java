package id.dana.data.expresspurchase.source.local;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0019\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b'\u0010(J%\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0019\u001a\u00020\u00188\u0007¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010#\u001a\u00020\"8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&"}, d2 = {"Lid/dana/data/expresspurchase/source/local/ExpressPurchasePreference;", "", "", "refUserId", "addonId", "type", "", "getLastOfferCancelAction", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)J", "getLastOfferSucceedAction", "(Ljava/lang/String;Ljava/lang/String;)J", "key", "", "saveCurrentTimemilisWithKey", "(Ljava/lang/String;)Z", "saveLastOfferCancelAction", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "saveLastOfferSucceedAction", "(Ljava/lang/String;Ljava/lang/String;)Z", "Lkotlin/Function0;", "", "action", "tryAndReturnBoolean", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Z", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "expressPurchasePreferenceGroup", "Ljava/lang/String;", "Lid/dana/data/storage/PreferenceFacade;", "preferenceFacade", "Lid/dana/data/storage/PreferenceFacade;", "Lid/dana/data/storage/Serializer;", "serializer", "Lid/dana/data/storage/Serializer;", "getSerializer", "()Lid/dana/data/storage/Serializer;", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ExpressPurchasePreference {
    private static final String LAST_OFFER_DISMISS_ACTION = "last_offer_dismiss_action";
    private static final String LAST_OFFER_SUCCEED_ACTION = "last_offer_succeed_action";
    private final Context context;
    private final String expressPurchasePreferenceGroup;
    private final PreferenceFacade preferenceFacade;
    private final Serializer serializer;

    @Inject
    public ExpressPurchasePreference(Context context, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.context = context;
        this.serializer = serializer;
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("production");
        String obj = sb.toString();
        this.expressPurchasePreferenceGroup = obj;
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

    public final boolean saveLastOfferCancelAction(String refUserId, String addonId, String type) {
        Intrinsics.checkNotNullParameter(refUserId, "");
        Intrinsics.checkNotNullParameter(addonId, "");
        Intrinsics.checkNotNullParameter(type, "");
        StringBuilder sb = new StringBuilder();
        sb.append(refUserId);
        sb.append(addonId);
        sb.append(type);
        sb.append(LAST_OFFER_DISMISS_ACTION);
        return saveCurrentTimemilisWithKey(sb.toString());
    }

    public final boolean saveLastOfferSucceedAction(String refUserId, String addonId) {
        Intrinsics.checkNotNullParameter(refUserId, "");
        Intrinsics.checkNotNullParameter(addonId, "");
        StringBuilder sb = new StringBuilder();
        sb.append(refUserId);
        sb.append(addonId);
        sb.append(LAST_OFFER_SUCCEED_ACTION);
        return saveCurrentTimemilisWithKey(sb.toString());
    }

    public final long getLastOfferCancelAction(String refUserId, String addonId, String type) {
        Intrinsics.checkNotNullParameter(refUserId, "");
        Intrinsics.checkNotNullParameter(addonId, "");
        Intrinsics.checkNotNullParameter(type, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(refUserId);
        sb.append(addonId);
        sb.append(type);
        sb.append(LAST_OFFER_DISMISS_ACTION);
        Long l = preferenceFacade.getLong(sb.toString());
        Intrinsics.checkNotNullExpressionValue(l, "");
        return l.longValue();
    }

    public final long getLastOfferSucceedAction(String refUserId, String addonId) {
        Intrinsics.checkNotNullParameter(refUserId, "");
        Intrinsics.checkNotNullParameter(addonId, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(refUserId);
        sb.append(addonId);
        sb.append(LAST_OFFER_SUCCEED_ACTION);
        Long l = preferenceFacade.getLong(sb.toString());
        Intrinsics.checkNotNullExpressionValue(l, "");
        return l.longValue();
    }

    private final boolean saveCurrentTimemilisWithKey(final String key) {
        return tryAndReturnBoolean(key, new Function0<Unit>() { // from class: id.dana.data.expresspurchase.source.local.ExpressPurchasePreference$saveCurrentTimemilisWithKey$1
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
                preferenceFacade = ExpressPurchasePreference.this.preferenceFacade;
                preferenceFacade.saveData(key, Long.valueOf(System.currentTimeMillis()));
            }
        });
    }

    private final boolean tryAndReturnBoolean(String key, Function0<Unit> action) {
        try {
            action.invoke();
            return true;
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(this.expressPurchasePreferenceGroup, key, e);
            return false;
        }
    }
}
