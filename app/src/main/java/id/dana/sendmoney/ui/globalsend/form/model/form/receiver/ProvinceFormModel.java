package id.dana.sendmoney.ui.globalsend.form.model.form.receiver;

import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormModel;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormOptionModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u000e\u0012\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u000e\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u000b\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u001f\u0010 R\u0012\u0010\u0005\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0003\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0011\u0010\n\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0012\u0010\t\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u000eX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u000eX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/model/form/receiver/ProvinceFormModel;", "Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormModel;", "", "getAuthRequestContext", "Ljava/lang/String;", "MyBillsEntityDataFactory", "", "BuiltInFictitiousFunctionClassFactory", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "", "moveToNextValue", "Z", "Lkotlin/Function1;", "getErrorConfigVersion", "Lkotlin/jvm/functions/Function1;", "", "lookAheadTest", "", "Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormOptionModel;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/util/List;", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "<init>", "(IILjava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProvinceFormModel extends GlobalSendFormModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final int getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final int PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final List<GlobalSendFormOptionModel> lookAheadTest;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final Function1<String, Boolean> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final Function1<String, Unit> moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;

    public /* synthetic */ ProvinceFormModel(int i, int i2, String str, Function1 function1, Function1 function12, int i3, boolean z, List list, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i4 & 4) != 0 ? "" : str, (i4 & 8) != 0 ? new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.model.form.receiver.ProvinceFormModel.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str2) {
                Intrinsics.checkNotNullParameter(str2, "");
                return Boolean.FALSE;
            }
        } : function1, (i4 & 16) != 0 ? new Function1<String, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.model.form.receiver.ProvinceFormModel.2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str2) {
                Intrinsics.checkNotNullParameter(str2, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str2) {
                invoke2(str2);
                return Unit.INSTANCE;
            }
        } : function12, (i4 & 64) != 0 ? false : z, list);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    private ProvinceFormModel(int i, int i2, String str, Function1<? super String, Boolean> function1, Function1<? super String, Unit> function12, boolean z, List<GlobalSendFormOptionModel> list) {
        super(16, 0, 2, null);
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(function12, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.getAuthRequestContext = i;
        this.PlaceComponentResult = i2;
        this.MyBillsEntityDataFactory = str;
        this.BuiltInFictitiousFunctionClassFactory = function1;
        this.moveToNextValue = function12;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        this.lookAheadTest = list;
    }
}
