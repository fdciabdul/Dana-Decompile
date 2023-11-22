package id.dana.onlinemerchant.model;

import id.dana.globalsearch.model.PaySearchInfoModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0012\u0010\u000e\u001a\u00020\u0006X\u0087\u0002¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0012\u0010\f\u001a\u00020\u000fX\u0087\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010"}, d2 = {"Lid/dana/onlinemerchant/model/OnlineMerchantWrapper;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "I", "getAuthRequestContext", "Lid/dana/globalsearch/model/PaySearchInfoModel;", "Lid/dana/globalsearch/model/PaySearchInfoModel;", "p1", "<init>", "(ILid/dana/globalsearch/model/PaySearchInfoModel;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class OnlineMerchantWrapper {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public int getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public PaySearchInfoModel MyBillsEntityDataFactory;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof OnlineMerchantWrapper) {
            OnlineMerchantWrapper onlineMerchantWrapper = (OnlineMerchantWrapper) p0;
            return this.getAuthRequestContext == onlineMerchantWrapper.getAuthRequestContext && Intrinsics.areEqual(this.MyBillsEntityDataFactory, onlineMerchantWrapper.MyBillsEntityDataFactory);
        }
        return false;
    }

    public final int hashCode() {
        return (this.getAuthRequestContext * 31) + this.MyBillsEntityDataFactory.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OnlineMerchantWrapper(getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(')');
        return sb.toString();
    }

    public OnlineMerchantWrapper(int i, PaySearchInfoModel paySearchInfoModel) {
        Intrinsics.checkNotNullParameter(paySearchInfoModel, "");
        this.getAuthRequestContext = i;
        this.MyBillsEntityDataFactory = paySearchInfoModel;
    }
}
