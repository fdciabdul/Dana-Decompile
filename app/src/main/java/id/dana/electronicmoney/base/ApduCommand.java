package id.dana.electronicmoney.base;

import android.nfc.tech.IsoDep;
import id.dana.electronicmoney.util.ElectronicMoneyUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\n\u001a\u00020\u00068\u0005X\u0084\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/electronicmoney/base/ApduCommand;", "", "", "p0", "PlaceComponentResult", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/nfc/tech/IsoDep;", "Landroid/nfc/tech/IsoDep;", "MyBillsEntityDataFactory", "()Landroid/nfc/tech/IsoDep;", "getAuthRequestContext", "<init>", "(Landroid/nfc/tech/IsoDep;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public abstract class ApduCommand {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final IsoDep getAuthRequestContext;

    public ApduCommand(IsoDep isoDep) {
        Intrinsics.checkNotNullParameter(isoDep, "");
        this.getAuthRequestContext = isoDep;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final IsoDep getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    public final String PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ElectronicMoneyUtils electronicMoneyUtils = ElectronicMoneyUtils.INSTANCE;
        IsoDep isoDep = this.getAuthRequestContext;
        ElectronicMoneyUtils electronicMoneyUtils2 = ElectronicMoneyUtils.INSTANCE;
        byte[] transceive = isoDep.transceive(ElectronicMoneyUtils.BuiltInFictitiousFunctionClassFactory(p0));
        Intrinsics.checkNotNullExpressionValue(transceive, "");
        return ElectronicMoneyUtils.PlaceComponentResult(transceive);
    }
}
