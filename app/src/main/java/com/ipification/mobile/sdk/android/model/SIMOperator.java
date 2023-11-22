package com.ipification.mobile.sdk.android.model;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0007"}, d2 = {"Lcom/ipification/mobile/sdk/android/model/SIMOperator;", "", "", "PlaceComponentResult", "()Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "Ljava/lang/String;", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "p2", "p3", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class SIMOperator {
    public final String KClassImpl$Data$declaredNonStaticMembers$2;
    private final String MyBillsEntityDataFactory;
    private final String PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final String BuiltInFictitiousFunctionClassFactory;

    public SIMOperator(String str, String str2, String str3, String str4) {
        Intrinsics.checkParameterIsNotNull(str, "");
        Intrinsics.checkParameterIsNotNull(str2, "");
        Intrinsics.checkParameterIsNotNull(str3, "");
        Intrinsics.checkParameterIsNotNull(str4, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.BuiltInFictitiousFunctionClassFactory = str2;
        this.PlaceComponentResult = str3;
        this.MyBillsEntityDataFactory = str4;
    }

    public /* synthetic */ SIMOperator(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? "" : str4);
    }

    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.length() >= 3) {
            String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (str != null) {
                String substring = str.substring(0, 3);
                Intrinsics.checkExpressionValueIsNotNull(substring, "");
                return substring;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        return "";
    }

    public final String MyBillsEntityDataFactory() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.length() >= 3) {
            String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (str != null) {
                String substring = str.substring(3);
                Intrinsics.checkExpressionValueIsNotNull(substring, "");
                return substring;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        return "";
    }

    public final String PlaceComponentResult() {
        if (this.MyBillsEntityDataFactory.length() > 40) {
            String str = this.MyBillsEntityDataFactory;
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            Intrinsics.checkExpressionValueIsNotNull(str.substring(0, 30), "");
        }
        return this.MyBillsEntityDataFactory;
    }
}
