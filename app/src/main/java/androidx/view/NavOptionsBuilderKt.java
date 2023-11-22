package androidx.view;

import androidx.view.NavOptions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\u0006\u001a\u00020\u00052\u0019\u0010\u0004\u001a\u0015\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0000¢\u0006\u0002\b\u0003¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlin/Function1;", "Landroidx/navigation/NavOptionsBuilder;", "", "Lkotlin/ExtensionFunctionType;", "p0", "Landroidx/navigation/NavOptions;", "getAuthRequestContext", "(Lkotlin/jvm/functions/Function1;)Landroidx/navigation/NavOptions;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NavOptionsBuilderKt {
    public static final NavOptions getAuthRequestContext(Function1<? super NavOptionsBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        NavOptionsBuilder navOptionsBuilder = new NavOptionsBuilder();
        function1.invoke(navOptionsBuilder);
        NavOptions.Builder builder = navOptionsBuilder.getAuthRequestContext;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = navOptionsBuilder.KClassImpl$Data$declaredNonStaticMembers$2;
        builder.moveToNextValue = navOptionsBuilder.NetworkUserEntityData$$ExternalSyntheticLambda0;
        String str = navOptionsBuilder.BuiltInFictitiousFunctionClassFactory;
        if (str != null) {
            boolean z = navOptionsBuilder.PlaceComponentResult;
            boolean z2 = navOptionsBuilder.scheduleImpl;
            builder.scheduleImpl = str;
            builder.PlaceComponentResult = -1;
            builder.lookAheadTest = z;
            builder.getErrorConfigVersion = z2;
        } else {
            int i = navOptionsBuilder.MyBillsEntityDataFactory;
            boolean z3 = navOptionsBuilder.PlaceComponentResult;
            boolean z4 = navOptionsBuilder.scheduleImpl;
            builder.PlaceComponentResult = i;
            builder.scheduleImpl = null;
            builder.lookAheadTest = z3;
            builder.getErrorConfigVersion = z4;
        }
        return builder.KClassImpl$Data$declaredNonStaticMembers$2();
    }
}
