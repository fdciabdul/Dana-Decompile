package id.dana.data.splitbill.mapper;

import android.text.TextUtils;
import id.dana.data.base.BaseMapper;
import id.dana.domain.splitbill.model.SplitBillDeeplink;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class SplitBillEncodeEntityMapper extends BaseMapper<String, SplitBillDeeplink> {
    private String splitBillId;

    @Inject
    public SplitBillEncodeEntityMapper() {
    }

    public void setSplitBillId(String str) {
        this.splitBillId = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public SplitBillDeeplink map(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SplitBillDeeplink(str, this.splitBillId);
    }
}
