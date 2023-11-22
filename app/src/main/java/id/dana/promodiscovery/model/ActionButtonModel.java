package id.dana.promodiscovery.model;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0003\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0012\u0010\f\u001a\u00020\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0012\u0010\r\u001a\u00020\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\u000b"}, d2 = {"Lid/dana/promodiscovery/model/ActionButtonModel;", "", "", "BuiltInFictitiousFunctionClassFactory", "I", "Lkotlin/Function0;", "", "getAuthRequestContext", "Lkotlin/jvm/functions/Function0;", "MyBillsEntityDataFactory", "", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "p0", "p1", "p2", "p3", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActionButtonModel {
    public int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public Function0<Unit> MyBillsEntityDataFactory;

    public ActionButtonModel(int i, String str, String str2, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(function0, "");
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.PlaceComponentResult = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        this.MyBillsEntityDataFactory = function0;
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", BridgeDSL.INVOKE, "()V"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* renamed from: id.dana.promodiscovery.model.ActionButtonModel$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Function0
        public final /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }
}
