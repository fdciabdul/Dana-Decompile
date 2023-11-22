package id.dana.sendmoney.ui.globalsend.form.model.form.receiver;

import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormModel;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormOptionModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u0012\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\u0012\u0012\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00150\u0012\u0012\b\b\u0002\u0010\u001c\u001a\u00020\t\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u001f\u0010 R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0007\u001a\u00020\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0011\u0010\n\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0011\u0010\r\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0012\u0010\u0011\u001a\u00020\u000eX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\u0012X\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00150\u0012X\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/model/form/receiver/CityFormModel;", "Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormModel;", "", "Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormOptionModel;", "getAuthRequestContext", "Ljava/util/List;", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "lookAheadTest", "MyBillsEntityDataFactory", "", "getErrorConfigVersion", "Z", "PlaceComponentResult", "Lkotlin/Function1;", "moveToNextValue", "Lkotlin/jvm/functions/Function1;", "", "scheduleImpl", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "<init>", "(IILjava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CityFormModel extends GlobalSendFormModel {
    public String BuiltInFictitiousFunctionClassFactory;
    public final int KClassImpl$Data$declaredNonStaticMembers$2;
    public List<GlobalSendFormOptionModel> getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public boolean PlaceComponentResult;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final int MyBillsEntityDataFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final Function1<String, Boolean> getErrorConfigVersion;
    public final Function1<String, Unit> scheduleImpl;

    public /* synthetic */ CityFormModel(int i, int i2, String str, Function1 function1, Function1 function12, int i3, boolean z, List list, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i4 & 4) != 0 ? "" : str, (i4 & 8) != 0 ? new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.model.form.receiver.CityFormModel.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str2) {
                Intrinsics.checkNotNullParameter(str2, "");
                return Boolean.FALSE;
            }
        } : function1, (i4 & 16) != 0 ? new Function1<String, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.model.form.receiver.CityFormModel.2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str2) {
                Intrinsics.checkNotNullParameter(str2, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str2) {
                invoke2(str2);
                return Unit.INSTANCE;
            }
        } : function12, (i4 & 64) != 0 ? false : z, (i4 & 128) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    private CityFormModel(int i, int i2, String str, Function1<? super String, Boolean> function1, Function1<? super String, Unit> function12, boolean z, List<GlobalSendFormOptionModel> list) {
        super(17, 0, 2, null);
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(function12, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.MyBillsEntityDataFactory = i2;
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.getErrorConfigVersion = function1;
        this.scheduleImpl = function12;
        this.PlaceComponentResult = z;
        this.getAuthRequestContext = list;
    }
}
