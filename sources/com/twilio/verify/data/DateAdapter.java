package com.twilio.verify.data;

import android.content.SharedPreferences;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/twilio/verify/data/DateAdapter;", "Lcom/twilio/verify/data/DateProvider;", "", "getAuthRequestContext", "()J", "", "p0", "", "PlaceComponentResult", "(Ljava/lang/String;)V", "Landroid/content/SharedPreferences;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class DateAdapter implements DateProvider {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final SharedPreferences getAuthRequestContext;

    public DateAdapter(SharedPreferences sharedPreferences) {
        Intrinsics.checkParameterIsNotNull(sharedPreferences, "");
        this.getAuthRequestContext = sharedPreferences;
    }

    @Override // com.twilio.verify.data.DateProvider
    public final long getAuthRequestContext() {
        return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) + this.getAuthRequestContext.getLong("timeCorrection", 0L);
    }

    @Override // com.twilio.verify.data.DateProvider
    public final void PlaceComponentResult(String p0) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        this.getAuthRequestContext.edit().putLong("timeCorrection", TimeUnit.MILLISECONDS.toSeconds(DateParserKt.MyBillsEntityDataFactory(p0).getTime()) - TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())).apply();
    }
}
