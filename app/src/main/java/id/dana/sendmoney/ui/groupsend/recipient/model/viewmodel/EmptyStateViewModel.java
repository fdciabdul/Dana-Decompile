package id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel;

import id.dana.sendmoney.R;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0017\u0010\r\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\u0002X\u0007¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0011\u0010\u000b\u001a\u00020\u0002X\u0007¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/EmptyStateViewModel;", "Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "", "FragmentBottomSheetPaymentSettingBinding", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "NetworkUserEntityData$$ExternalSyntheticLambda6", "BuiltInFictitiousFunctionClassFactory", "", "readMicros", "Z", "MyBillsEntityDataFactory", "()Z", "getAuthRequestContext", "NetworkUserEntityData$$ExternalSyntheticLambda5", "PlaceComponentResult", "NetworkUserEntityData$$ExternalSyntheticLambda4", "p0", "p1", "p2", "p3", "p4", "p5", "<init>", "(IIIIIZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EmptyStateViewModel extends RecipientViewModel {

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    public final int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    public final int MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    public final int PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    public final int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: readMicros  reason: from kotlin metadata */
    private final boolean getAuthRequestContext;

    public /* synthetic */ EmptyStateViewModel(int i, int i2, int i3, int i4, int i5, boolean z, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i6 & 2) != 0 ? R.drawable.res_0x7f0808e8_networkuserentitydata_externalsyntheticlambda5 : i2, (i6 & 4) != 0 ? R.string.contact_not_found : i3, (i6 & 8) != 0 ? R.string.contact_not_found_message : i4, (i6 & 16) != 0 ? R.string.contact_not_found_message : i5, (i6 & 32) != 0 ? false : z);
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    public EmptyStateViewModel(int i, int i2, int i3, int i4, int i5, boolean z) {
        super(i);
        this.PlaceComponentResult = i2;
        this.MyBillsEntityDataFactory = i3;
        this.BuiltInFictitiousFunctionClassFactory = i4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i5;
        this.getAuthRequestContext = z;
    }
}
