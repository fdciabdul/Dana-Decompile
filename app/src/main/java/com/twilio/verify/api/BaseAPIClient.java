package com.twilio.verify.api;

import com.twilio.verify.TwilioVerifyException;
import com.twilio.verify.data.DateProvider;
import com.twilio.verify.networking.FailureResponse;
import com.twilio.verify.networking.NetworkException;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011JG\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\b\u001a\u00020\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u0004H\u0004¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lcom/twilio/verify/api/BaseAPIClient;", "", "Lcom/twilio/verify/networking/NetworkException;", "p0", "Lkotlin/Function1;", "", "", "p1", "p2", "Lcom/twilio/verify/TwilioVerifyException;", "p3", "MyBillsEntityDataFactory", "(Lcom/twilio/verify/networking/NetworkException;Lkotlin/jvm/functions/Function1;ILkotlin/jvm/functions/Function1;)V", "Lcom/twilio/verify/data/DateProvider;", "getAuthRequestContext", "Lcom/twilio/verify/data/DateProvider;", "<init>", "(Lcom/twilio/verify/data/DateProvider;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public class BaseAPIClient {
    private final DateProvider getAuthRequestContext;

    public BaseAPIClient(DateProvider dateProvider) {
        Intrinsics.checkParameterIsNotNull(dateProvider, "");
        this.getAuthRequestContext = dateProvider;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void MyBillsEntityDataFactory(NetworkException p0, Function1<? super Integer, Unit> p1, int p2, Function1<? super TwilioVerifyException, Unit> p3) {
        List<String> list;
        String str;
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        Intrinsics.checkParameterIsNotNull(p3, "");
        if (p2 > 0) {
            FailureResponse failureResponse = p0.getFailureResponse();
            Integer valueOf = failureResponse != null ? Integer.valueOf(failureResponse.MyBillsEntityDataFactory) : null;
            if (valueOf == null || valueOf.intValue() != 401) {
                p3.invoke(new TwilioVerifyException(p0, TwilioVerifyException.ErrorCode.NetworkError));
                return;
            }
            Map<String, List<String>> map = p0.getFailureResponse().getAuthRequestContext;
            if (map == null || (list = map.get("Date")) == null || (str = (String) CollectionsKt.first((List) list)) == null) {
                p3.invoke(new TwilioVerifyException(p0, TwilioVerifyException.ErrorCode.NetworkError));
                return;
            }
            this.getAuthRequestContext.PlaceComponentResult(str);
            p1.invoke(Integer.valueOf(p2 - 1));
            return;
        }
        p3.invoke(new TwilioVerifyException(p0, TwilioVerifyException.ErrorCode.NetworkError));
    }
}
