package id.dana.data.qriscrossborder.source.local;

import android.content.Context;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0019\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/data/qriscrossborder/source/local/QrisCrossBorderPreference;", "", "Lid/dana/data/storage/PreferenceFacade;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/storage/PreferenceFacade;", "getAuthRequestContext", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "Landroid/content/Context;", "p0", "Lid/dana/data/storage/Serializer;", "p1", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class QrisCrossBorderPreference {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final PreferenceFacade getAuthRequestContext;
    private final String KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public QrisCrossBorderPreference(Context context, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = "QrisCrossBorderPreferenceproduction";
        PreferenceFacade createData2 = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup("QrisCrossBorderPreferenceproduction").setUseDrutherPreference(true).setSerializerFacade(serializer)).createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        this.getAuthRequestContext = createData2;
    }
}
