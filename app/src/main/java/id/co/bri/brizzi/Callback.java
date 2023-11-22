package id.co.bri.brizzi;

import id.co.bri.brizzi.exception.BrizziException;

/* loaded from: classes8.dex */
public interface Callback {
    void onFailure(BrizziException brizziException);

    void onSuccess(CardData cardData);
}
