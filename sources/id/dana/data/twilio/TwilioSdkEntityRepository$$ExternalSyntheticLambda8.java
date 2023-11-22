package id.dana.data.twilio;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

/* loaded from: classes4.dex */
public final /* synthetic */ class TwilioSdkEntityRepository$$ExternalSyntheticLambda8 implements SingleOnSubscribe {
    public final /* synthetic */ TwilioSdkEntityRepository PlaceComponentResult;

    public /* synthetic */ TwilioSdkEntityRepository$$ExternalSyntheticLambda8(TwilioSdkEntityRepository twilioSdkEntityRepository) {
        this.PlaceComponentResult = twilioSdkEntityRepository;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter singleEmitter) {
        TwilioSdkEntityRepository.PlaceComponentResult(this.PlaceComponentResult, singleEmitter);
    }
}
