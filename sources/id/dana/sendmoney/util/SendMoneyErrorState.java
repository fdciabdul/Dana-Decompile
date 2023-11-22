package id.dana.sendmoney.util;

import id.dana.core.ui.model.UiTextModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\b\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0011\u0010\t\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\t\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/util/SendMoneyErrorState;", "", "", "getAuthRequestContext", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/core/ui/model/UiTextModel;", "Lid/dana/core/ui/model/UiTextModel;", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "p0", "p1", "p2", "<init>", "(Ljava/lang/String;Lid/dana/core/ui/model/UiTextModel;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendMoneyErrorState {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final UiTextModel BuiltInFictitiousFunctionClassFactory;
    public final String PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    public SendMoneyErrorState(@SendMoneyErrorType String str, UiTextModel uiTextModel, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(uiTextModel, "");
        this.PlaceComponentResult = str;
        this.BuiltInFictitiousFunctionClassFactory = uiTextModel;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
    }
}
