package id.dana.base;

import com.zhuinden.simplestack.Backstack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/base/NavigationManager;", "", "Lcom/zhuinden/simplestack/Backstack;", "BuiltInFictitiousFunctionClassFactory", "Lcom/zhuinden/simplestack/Backstack;", "getAuthRequestContext", "p0", "<init>", "(Lcom/zhuinden/simplestack/Backstack;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class NavigationManager {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Backstack getAuthRequestContext;

    public NavigationManager(Backstack backstack) {
        Intrinsics.checkNotNullParameter(backstack, "");
        this.getAuthRequestContext = backstack;
    }
}
