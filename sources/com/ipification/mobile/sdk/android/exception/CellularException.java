package com.ipification.mobile.sdk.android.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\tR\u001a\u0010\u000e\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\b\u001a\u0004\u0018\u00010\u000fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\u0010"}, d2 = {"Lcom/ipification/mobile/sdk/android/exception/CellularException;", "", "", "PlaceComponentResult", "()Ljava/lang/String;", "Lcom/ipification/mobile/sdk/android/exception/IPificationError;", "BuiltInFictitiousFunctionClassFactory", "()Lcom/ipification/mobile/sdk/android/exception/IPificationError;", "getAuthRequestContext", "Ljava/lang/String;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/Exception;", "MyBillsEntityDataFactory", "", "Ljava/lang/Integer;", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class CellularException {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public Integer getAuthRequestContext = 0;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public Exception MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String PlaceComponentResult;

    public final String PlaceComponentResult() {
        String str;
        Exception exc = this.MyBillsEntityDataFactory;
        if (exc != null) {
            if (exc == null) {
                Intrinsics.throwNpe();
            }
            if (exc.getLocalizedMessage() != null && (str = this.BuiltInFictitiousFunctionClassFactory) != null && !Intrinsics.areEqual(str, "")) {
                StringBuilder sb = new StringBuilder();
                Exception exc2 = this.MyBillsEntityDataFactory;
                if (exc2 == null) {
                    Intrinsics.throwNpe();
                }
                sb.append((Object) exc2.getLocalizedMessage());
                sb.append(" - ");
                sb.append((Object) this.BuiltInFictitiousFunctionClassFactory);
                return sb.toString();
            }
        }
        Exception exc3 = this.MyBillsEntityDataFactory;
        if (exc3 != null) {
            if (exc3 == null) {
                Intrinsics.throwNpe();
            }
            if (exc3.getLocalizedMessage() != null) {
                Exception exc4 = this.MyBillsEntityDataFactory;
                if (exc4 == null) {
                    Intrinsics.throwNpe();
                }
                String localizedMessage = exc4.getLocalizedMessage();
                if (localizedMessage == null) {
                    Intrinsics.throwNpe();
                }
                return localizedMessage;
            }
        }
        String str2 = this.BuiltInFictitiousFunctionClassFactory;
        if (str2 == null) {
            String str3 = this.PlaceComponentResult;
            return str3 == null ? Intrinsics.stringPlus("unknown_error ", this.getAuthRequestContext) : str3;
        }
        return str2;
    }

    public final IPificationError BuiltInFictitiousFunctionClassFactory() {
        IPificationError iPificationError = new IPificationError();
        iPificationError.PlaceComponentResult = this.getAuthRequestContext;
        iPificationError.BuiltInFictitiousFunctionClassFactory = this.PlaceComponentResult;
        iPificationError.MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory;
        iPificationError.KClassImpl$Data$declaredNonStaticMembers$2 = this.MyBillsEntityDataFactory;
        return iPificationError;
    }
}
