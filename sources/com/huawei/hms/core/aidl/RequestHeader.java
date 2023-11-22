package com.huawei.hms.core.aidl;

import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.List;

/* loaded from: classes7.dex */
public class RequestHeader implements IMessageEntity {
    @Packed
    public String BuiltInFictitiousFunctionClassFactory;
    @Packed
    public int KClassImpl$Data$declaredNonStaticMembers$2;
    @Packed
    public int MyBillsEntityDataFactory;
    @Packed
    public String PlaceComponentResult;
    @Packed
    public List<String> getAuthRequestContext;
    @Packed
    public String getErrorConfigVersion;

    public RequestHeader() {
    }

    public RequestHeader(String str, String str2, String str3) {
        this.PlaceComponentResult = str;
        this.BuiltInFictitiousFunctionClassFactory = str2;
        this.MyBillsEntityDataFactory = 60500300;
        this.getErrorConfigVersion = str3;
    }
}
