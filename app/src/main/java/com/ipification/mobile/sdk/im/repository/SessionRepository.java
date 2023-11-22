package com.ipification.mobile.sdk.im.repository;

import android.content.Context;
import com.ipification.mobile.sdk.android.model.IMSession;
import com.ipification.mobile.sdk.im.data.SessionResponse;
import com.ipification.mobile.sdk.im.util.SingleLiveEvent;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u0003\u0010\rJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000eH&¢\u0006\u0004\b\u0003\u0010\u0011"}, d2 = {"Lcom/ipification/mobile/sdk/im/repository/SessionRepository;", "", "", "PlaceComponentResult", "()V", "Landroid/content/Context;", "p0", "Lcom/ipification/mobile/sdk/im/util/SingleLiveEvent;", "Lcom/ipification/mobile/sdk/im/data/SessionResponse;", "getAuthRequestContext", "(Landroid/content/Context;)Lcom/ipification/mobile/sdk/im/util/SingleLiveEvent;", "", "p1", "(Landroid/content/Context;Ljava/lang/String;)Lcom/ipification/mobile/sdk/im/util/SingleLiveEvent;", "Lcom/ipification/mobile/sdk/android/model/IMSession;", "MyBillsEntityDataFactory", "()Lcom/ipification/mobile/sdk/android/model/IMSession;", "(Lcom/ipification/mobile/sdk/android/model/IMSession;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface SessionRepository {
    IMSession MyBillsEntityDataFactory();

    SingleLiveEvent<String> PlaceComponentResult(Context p0, String p1);

    void PlaceComponentResult();

    void PlaceComponentResult(IMSession p0);

    SingleLiveEvent<SessionResponse> getAuthRequestContext(Context p0);
}
