package id.dana.data.paymentsetting.repository.source.session;

import android.content.Context;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import id.dana.data.storage.SimpleSecureKeyPreference;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/data/paymentsetting/repository/source/session/PaymentSettingPreference;", "", "", "p0", "", "getAuthRequestContext", "(Ljava/lang/String;)Z", "MyBillsEntityDataFactory", "Ljava/lang/String;", "Lid/dana/data/storage/PreferenceFacade;", "PlaceComponentResult", "Lid/dana/data/storage/PreferenceFacade;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "Lid/dana/data/storage/Serializer;", "p1", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PaymentSettingPreference {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final String getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final PreferenceFacade BuiltInFictitiousFunctionClassFactory;

    @Inject
    public PaymentSettingPreference(Context context, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.getAuthRequestContext = "PaymentSettingPreferenceproduction";
        PreferenceFacade createData = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup("PaymentSettingPreferenceproduction").setUseDrutherPreference(true).setSerializerFacade(serializer)).createData("local");
        Intrinsics.checkNotNullExpressionValue(createData, "");
        this.BuiltInFictitiousFunctionClassFactory = new SimpleSecureKeyPreference(createData);
    }

    public final boolean getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PreferenceFacade preferenceFacade = this.BuiltInFictitiousFunctionClassFactory;
        StringBuilder sb = new StringBuilder();
        sb.append("BOTTOMSHEET_PAYMENT_SETTING_CHECK");
        sb.append(p0);
        Boolean bool = preferenceFacade.getBoolean(sb.toString(), true);
        Intrinsics.checkNotNullExpressionValue(bool, "");
        return bool.booleanValue();
    }

    public final boolean MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PreferenceFacade preferenceFacade = this.BuiltInFictitiousFunctionClassFactory;
        StringBuilder sb = new StringBuilder();
        sb.append("BOTTOMSHEET_PAYMENT_SETTING_CHECK");
        sb.append(p0);
        preferenceFacade.saveData(sb.toString(), Boolean.FALSE);
        return true;
    }
}
