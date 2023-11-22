package id.dana.sendmoney.data.repository.globalsend.source.local;

import android.content.Context;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/data/repository/globalsend/source/local/GlobalSendPreference;", "", "Lid/dana/data/storage/PreferenceFacade;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/storage/PreferenceFacade;", "Landroid/content/Context;", "p0", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GlobalSendPreference {
    final PreferenceFacade BuiltInFictitiousFunctionClassFactory;

    @Inject
    public GlobalSendPreference(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        PreferenceFacade createData = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup("GlobalSendPreferenceproduction").setUseDrutherPreference(true)).createData("local");
        Intrinsics.checkNotNullExpressionValue(createData, "");
        this.BuiltInFictitiousFunctionClassFactory = createData;
    }
}
