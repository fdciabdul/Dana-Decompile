package id.dana;

import android.content.Context;
import androidx.startup.Initializer;
import com.google.firebase.FirebaseApp;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\u00040\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/DanaAppInitializer;", "Landroidx/startup/Initializer;", "Lcom/google/firebase/FirebaseApp;", "", "Ljava/lang/Class;", "PlaceComponentResult", "()Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DanaAppInitializer implements Initializer<FirebaseApp> {
    @Override // androidx.startup.Initializer
    public final /* synthetic */ FirebaseApp getAuthRequestContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        FirebaseApp.initializeApp(context);
        FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2("app_ready_cold");
        FirebaseApp firebaseApp = FirebaseApp.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseApp, "");
        return firebaseApp;
    }

    @Override // androidx.startup.Initializer
    public final List<Class<? extends Initializer<?>>> PlaceComponentResult() {
        return CollectionsKt.emptyList();
    }
}
