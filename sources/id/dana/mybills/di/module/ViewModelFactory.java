package id.dana.mybills.di.module;

import androidx.view.ViewModel;
import androidx.view.ViewModelProvider;
import androidx.view.viewmodel.CreationExtras;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B2\b\u0007\u0012'\u0010\u0005\u001a#\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0004\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t¢\u0006\u0002\b\n0\b¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R5\u0010\u000b\u001a#\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0004\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t¢\u0006\u0002\b\n0\b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/mybills/di/module/ViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "", "Ljavax/inject/Provider;", "Lkotlin/jvm/JvmSuppressWildcards;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/Map;", "<init>", "(Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ViewModelFactory implements ViewModelProvider.Factory {
    private final Map<Class<? extends ViewModel>, Provider<ViewModel>> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final /* synthetic */ ViewModel MyBillsEntityDataFactory(Class cls, CreationExtras creationExtras) {
        return ViewModelProvider.Factory.CC.BuiltInFictitiousFunctionClassFactory(this, cls, creationExtras);
    }

    @Inject
    public ViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> map) {
        Intrinsics.checkNotNullParameter(map, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = map;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final <T extends ViewModel> T BuiltInFictitiousFunctionClassFactory(Class<T> p0) {
        Object obj;
        Intrinsics.checkNotNullParameter(p0, "");
        Provider<ViewModel> provider = this.KClassImpl$Data$declaredNonStaticMembers$2.get(p0);
        if (provider == null) {
            Iterator<T> it = this.KClassImpl$Data$declaredNonStaticMembers$2.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (p0.isAssignableFrom((Class) ((Map.Entry) obj).getKey())) {
                    break;
                }
            }
            Map.Entry entry = (Map.Entry) obj;
            provider = entry != null ? (Provider) entry.getValue() : null;
            if (provider == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("unknown model class ");
                sb.append(p0);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        try {
            ViewModel viewModel = provider.get();
            if (viewModel != null) {
                return (T) viewModel;
            }
            throw new NullPointerException("null cannot be cast to non-null type T of id.dana.mybills.di.module.ViewModelFactory.create");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
