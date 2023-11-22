package id.dana.sendmoney.util;

import androidx.view.ViewModel;
import androidx.view.ViewModelProvider;
import androidx.view.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/sendmoney/util/ViewModelExtKt$callOnCleared$viewModelProvider$1;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class ViewModelExtKt$callOnCleared$viewModelProvider$1 implements ViewModelProvider.Factory {
    final /* synthetic */ ViewModel KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final /* synthetic */ ViewModel MyBillsEntityDataFactory(Class cls, CreationExtras creationExtras) {
        return ViewModelProvider.Factory.CC.BuiltInFictitiousFunctionClassFactory(this, cls, creationExtras);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final <T extends ViewModel> T BuiltInFictitiousFunctionClassFactory(Class<T> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return (T) this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
