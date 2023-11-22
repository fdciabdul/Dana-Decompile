package id.dana.sendmoney.voucher;

import dagger.MembersInjector;
import id.dana.data.dynamicurl.DynamicUrlWrapper;

/* loaded from: classes5.dex */
public final class VoucherDetailActivity_MembersInjector implements MembersInjector<VoucherDetailActivity> {
    public static void getAuthRequestContext(VoucherDetailActivity voucherDetailActivity, DynamicUrlWrapper dynamicUrlWrapper) {
        voucherDetailActivity.dynamicUrlWrapper = dynamicUrlWrapper;
    }
}
