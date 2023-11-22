package id.dana.data.resetpin.source.local;

import android.content.Context;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import id.dana.data.storage.SimpleSecureKeyPreference;
import id.dana.utils.extension.StringExtKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u000f\u0012\u0006\u0010\b\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\tJ\u001d\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\tR\u0014\u0010\u0007\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/data/resetpin/source/local/ResetPinPreference;", "", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Z", "PlaceComponentResult", "p1", "(Ljava/lang/String;Z)Z", "Lid/dana/data/storage/PreferenceFacade;", "MyBillsEntityDataFactory", "Lid/dana/data/storage/PreferenceFacade;", "getAuthRequestContext", "Ljava/lang/String;", "Landroid/content/Context;", "Lid/dana/data/storage/Serializer;", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ResetPinPreference {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final PreferenceFacade PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final String MyBillsEntityDataFactory;

    @Inject
    public ResetPinPreference(Context context, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.MyBillsEntityDataFactory = "ResetPinPreferenceproduction";
        PreferenceFacade createData2 = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup("ResetPinPreferenceproduction").setUseDrutherPreference(true).setSerializerFacade(serializer)).createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        this.PlaceComponentResult = new SimpleSecureKeyPreference(createData2);
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0, boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        PreferenceFacade preferenceFacade = this.PlaceComponentResult;
        StringBuilder sb = new StringBuilder();
        sb.append(StringExtKt.PlaceComponentResult(p0));
        sb.append("_dana_viz_prompt_after_reset_pin");
        preferenceFacade.saveData(sb.toString(), Boolean.valueOf(p1));
        return true;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PreferenceFacade preferenceFacade = this.PlaceComponentResult;
        StringBuilder sb = new StringBuilder();
        sb.append(StringExtKt.PlaceComponentResult(p0));
        sb.append("_dana_viz_prompt_after_reset_pin");
        Boolean bool = preferenceFacade.getBoolean(sb.toString(), false);
        Intrinsics.checkNotNullExpressionValue(bool, "");
        return bool.booleanValue();
    }

    public final boolean PlaceComponentResult(String p0, boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        PreferenceFacade preferenceFacade = this.PlaceComponentResult;
        StringBuilder sb = new StringBuilder();
        sb.append(StringExtKt.PlaceComponentResult(p0));
        sb.append("_force_dana_viz_prompt");
        preferenceFacade.saveData(sb.toString(), Boolean.valueOf(p1));
        return true;
    }

    public final boolean PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PreferenceFacade preferenceFacade = this.PlaceComponentResult;
        StringBuilder sb = new StringBuilder();
        sb.append(StringExtKt.PlaceComponentResult(p0));
        sb.append("_force_dana_viz_prompt");
        Boolean bool = preferenceFacade.getBoolean(sb.toString(), false);
        Intrinsics.checkNotNullExpressionValue(bool, "");
        return bool.booleanValue();
    }
}
