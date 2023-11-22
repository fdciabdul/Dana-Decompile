package id.dana.nearbyme.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.nearbyme.model.ContactAddress;
import id.dana.nearbyme.model.ContactAddressModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/nearbyme/mapper/ContactAddressMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/domain/nearbyme/model/ContactAddress;", "Lid/dana/nearbyme/model/ContactAddressModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContactAddressMapper extends BaseMapper<ContactAddress, ContactAddressModel> {
    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ ContactAddressModel map(ContactAddress contactAddress) {
        ContactAddress contactAddress2 = contactAddress;
        Intrinsics.checkNotNullParameter(contactAddress2, "");
        ContactAddressModel contactAddressModel = new ContactAddressModel();
        contactAddressModel.PlaceComponentResult = contactAddress2.getAddress1();
        contactAddressModel.BuiltInFictitiousFunctionClassFactory = contactAddress2.getAddress2();
        contactAddressModel.KClassImpl$Data$declaredNonStaticMembers$2 = contactAddress2.getArea();
        contactAddressModel.getAuthRequestContext = contactAddress2.getCity();
        contactAddressModel.MyBillsEntityDataFactory = contactAddress2.getContactAddressId();
        contactAddressModel.getErrorConfigVersion = contactAddress2.getContactAddressType();
        contactAddressModel.scheduleImpl = contactAddress2.getCountry();
        contactAddressModel.lookAheadTest = contactAddress2.isDefaultAddress();
        contactAddressModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = contactAddress2.getExtendInfo();
        contactAddressModel.moveToNextValue = contactAddress2.getProvince();
        contactAddressModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = contactAddress2.isVerified();
        contactAddressModel.initRecordTimeStamp = contactAddress2.getZipcode();
        return contactAddressModel;
    }

    @Inject
    public ContactAddressMapper() {
    }
}
