package com.twilio.verify.domain.factor;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/twilio/verify/domain/factor/FactorMigrations;", "", "Lcom/twilio/verify/domain/factor/FactorMapper;", "PlaceComponentResult", "Lcom/twilio/verify/domain/factor/FactorMapper;", "MyBillsEntityDataFactory", "Landroid/content/SharedPreferences;", "getAuthRequestContext", "Landroid/content/SharedPreferences;", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "<init>", "(Landroid/content/SharedPreferences;Lcom/twilio/verify/domain/factor/FactorMapper;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class FactorMigrations {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final FactorMapper MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final SharedPreferences BuiltInFictitiousFunctionClassFactory;

    private FactorMigrations(SharedPreferences sharedPreferences, FactorMapper factorMapper) {
        Intrinsics.checkParameterIsNotNull(sharedPreferences, "");
        Intrinsics.checkParameterIsNotNull(factorMapper, "");
        this.BuiltInFictitiousFunctionClassFactory = sharedPreferences;
        this.MyBillsEntityDataFactory = factorMapper;
    }

    public /* synthetic */ FactorMigrations(SharedPreferences sharedPreferences, FactorMapper factorMapper, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sharedPreferences, (i & 2) != 0 ? new FactorMapper() : factorMapper);
    }
}
