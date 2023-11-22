package id.dana.sync_engine.data.entity;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.sync_engine.data.source.ContactEntityData;
import id.dana.sync_engine.data.source.device.ContactEntityDataDevice;
import id.dana.sync_engine.data.source.local.ContactEntityDataLocal;
import id.dana.sync_engine.data.source.network.ContactEntityDataNetwork;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0005\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\b\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/sync_engine/data/entity/ContactEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/sync_engine/data/source/ContactEntityData;", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Lid/dana/sync_engine/data/source/ContactEntityData;", "Lid/dana/sync_engine/data/source/device/ContactEntityDataDevice;", "MyBillsEntityDataFactory", "Lid/dana/sync_engine/data/source/device/ContactEntityDataDevice;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sync_engine/data/source/local/ContactEntityDataLocal;", "Lid/dana/sync_engine/data/source/local/ContactEntityDataLocal;", "Lid/dana/sync_engine/data/source/network/ContactEntityDataNetwork;", "getAuthRequestContext", "Lid/dana/sync_engine/data/source/network/ContactEntityDataNetwork;", "PlaceComponentResult", "p1", "p2", "<init>", "(Lid/dana/sync_engine/data/source/local/ContactEntityDataLocal;Lid/dana/sync_engine/data/source/device/ContactEntityDataDevice;Lid/dana/sync_engine/data/source/network/ContactEntityDataNetwork;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ContactEntityDataFactory extends AbstractEntityDataFactory<ContactEntityData> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final ContactEntityDataLocal MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final ContactEntityDataDevice BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final ContactEntityDataNetwork PlaceComponentResult;

    @Inject
    public ContactEntityDataFactory(ContactEntityDataLocal contactEntityDataLocal, ContactEntityDataDevice contactEntityDataDevice, ContactEntityDataNetwork contactEntityDataNetwork) {
        Intrinsics.checkNotNullParameter(contactEntityDataLocal, "");
        Intrinsics.checkNotNullParameter(contactEntityDataDevice, "");
        Intrinsics.checkNotNullParameter(contactEntityDataNetwork, "");
        this.MyBillsEntityDataFactory = contactEntityDataLocal;
        this.BuiltInFictitiousFunctionClassFactory = contactEntityDataDevice;
        this.PlaceComponentResult = contactEntityDataNetwork;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
    public final ContactEntityData createData2(String p0) {
        if (p0 != null) {
            int hashCode = p0.hashCode();
            if (hashCode != -1335157162) {
                if (hashCode != 103145323) {
                    if (hashCode == 1843485230 && p0.equals("network")) {
                        return this.PlaceComponentResult;
                    }
                } else if (p0.equals("local")) {
                    return this.MyBillsEntityDataFactory;
                }
            } else if (p0.equals("device")) {
                return this.BuiltInFictitiousFunctionClassFactory;
            }
        }
        throw new UnsupportedOperationException();
    }
}
