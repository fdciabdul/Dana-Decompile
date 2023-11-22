package com.alipay.iap.android.wallet.acl.contact;

import com.alipay.iap.android.wallet.acl.base.BaseResult;

/* loaded from: classes2.dex */
public class ContactRetrieveResult extends BaseResult {
    public ContactInfo[] contactList;

    public ContactRetrieveResult(ContactInfo... contactInfoArr) {
        this.contactList = contactInfoArr;
    }
}
