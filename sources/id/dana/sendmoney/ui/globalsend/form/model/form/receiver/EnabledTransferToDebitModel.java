package id.dana.sendmoney.ui.globalsend.form.model.form.receiver;

import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0011\u0010\u0003\u001a\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/model/form/receiver/EnabledTransferToDebitModel;", "Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormModel;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/ui/globalsend/form/model/form/receiver/DefaultFormModel;", "Lid/dana/sendmoney/ui/globalsend/form/model/form/receiver/DefaultFormModel;", "scheduleImpl", "p0", "p1", "p2", "p3", "<init>", "(IIILid/dana/sendmoney/ui/globalsend/form/model/form/receiver/DefaultFormModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EnabledTransferToDebitModel extends GlobalSendFormModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final int MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final int getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final DefaultFormModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final int BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnabledTransferToDebitModel(int i, int i2, int i3, DefaultFormModel defaultFormModel) {
        super(15, 0, 2, null);
        Intrinsics.checkNotNullParameter(defaultFormModel, "");
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.getAuthRequestContext = i2;
        this.MyBillsEntityDataFactory = i3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = defaultFormModel;
    }
}
