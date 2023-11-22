package com.ipification.mobile.sdk.android.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u001a\u0010\f\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0014\u0010\u0007\u001a\u0004\u0018\u00010\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010\u000e"}, d2 = {"Lcom/ipification/mobile/sdk/android/exception/IPificationError;", "", "", "BuiltInFictitiousFunctionClassFactory", "()Ljava/lang/String;", "getAuthRequestContext", "Ljava/lang/String;", "PlaceComponentResult", "MyBillsEntityDataFactory", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Ljava/lang/Exception;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "Ljava/lang/Integer;", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class IPificationError {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public Exception KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public Integer PlaceComponentResult = 0;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;

    public final String BuiltInFictitiousFunctionClassFactory() {
        String str;
        Exception exc = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (exc != null) {
            if (exc == null) {
                Intrinsics.throwNpe();
            }
            if (exc.getLocalizedMessage() != null && (str = this.MyBillsEntityDataFactory) != null && !Intrinsics.areEqual(str, "")) {
                StringBuilder sb = new StringBuilder();
                Exception exc2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (exc2 == null) {
                    Intrinsics.throwNpe();
                }
                sb.append((Object) exc2.getLocalizedMessage());
                sb.append(" - ");
                sb.append((Object) this.MyBillsEntityDataFactory);
                return sb.toString();
            }
        }
        Exception exc3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (exc3 != null) {
            if (exc3 == null) {
                Intrinsics.throwNpe();
            }
            if (exc3.getLocalizedMessage() != null) {
                Exception exc4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
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
        String str2 = this.MyBillsEntityDataFactory;
        if (str2 == null) {
            String str3 = this.BuiltInFictitiousFunctionClassFactory;
            return str3 == null ? Intrinsics.stringPlus("unknown_error ", this.PlaceComponentResult) : str3;
        }
        return str2;
    }
}
