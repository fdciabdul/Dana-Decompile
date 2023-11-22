package id.dana.social.presenter;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "it", "", BridgeDSL.INVOKE, "(Ljava/lang/Exception;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final class RelationshipBottomSheetPresenter$startFetchingReciprocal$1 extends Lambda implements Function1<Exception, Unit> {
    public static final RelationshipBottomSheetPresenter$startFetchingReciprocal$1 INSTANCE = new RelationshipBottomSheetPresenter$startFetchingReciprocal$1();

    RelationshipBottomSheetPresenter$startFetchingReciprocal$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
        invoke2(exc);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "");
        StringBuilder sb = new StringBuilder();
        sb.append("onError: ");
        sb.append(exc.getMessage());
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, sb.toString());
    }
}
