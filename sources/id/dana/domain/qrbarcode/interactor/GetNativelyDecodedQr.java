package id.dana.domain.qrbarcode.interactor;

import id.dana.data.constant.BranchLinkConstant;
import id.dana.domain.core.usecase.BaseUseCase;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u001d2*\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001dB\t\b\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\tJ9\u0010\f\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00040\u000b2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u000e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J3\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0012\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R0\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a"}, d2 = {"Lid/dana/domain/qrbarcode/interactor/GetNativelyDecodedQr;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "headerString", "internalQr", "", "attemptInternalDecode", "(Ljava/lang/String;Ljava/lang/String;)V", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Ljava/lang/String;)Lio/reactivex/Observable;", "qrShortString", "Lkotlin/Pair;", BranchLinkConstant.PathTarget.DECODE, "(Ljava/lang/String;)Lkotlin/Pair;", "qrString", "initialQrLogic", "(Ljava/lang/String;)Ljava/util/HashMap;", "", "qrStringPointer", "separate", "(ILjava/lang/String;)Lkotlin/Pair;", "hashMapResult", "Ljava/util/HashMap;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetNativelyDecodedQr extends BaseUseCase<HashMap<String, String>, String> {
    private static final int TAG_AND_LENGTH_SIZE = 4;
    private static final int TAG_ONLY_SIZE = 2;
    private final HashMap<String, String> hashMapResult = new HashMap<>();

    @Inject
    public GetNativelyDecodedQr() {
    }

    private final Pair<String, String> separate(int qrStringPointer, String qrString) {
        int i = qrStringPointer + 4;
        String substring = qrString.substring(qrStringPointer + 2, i);
        Intrinsics.checkNotNullExpressionValue(substring, "");
        String substring2 = qrString.substring(qrStringPointer, i + Integer.parseInt(substring));
        Intrinsics.checkNotNullExpressionValue(substring2, "");
        return decode(substring2);
    }

    private final Pair<String, String> decode(String qrShortString) {
        String substring = qrShortString.substring(0, 2);
        Intrinsics.checkNotNullExpressionValue(substring, "");
        String substring2 = qrShortString.substring(4);
        Intrinsics.checkNotNullExpressionValue(substring2, "");
        Pair<String, String> pair = new Pair<>(substring, substring2);
        attemptInternalDecode(pair.getFirst(), pair.getSecond());
        return pair;
    }

    private final HashMap<String, String> initialQrLogic(String qrString) {
        this.hashMapResult.clear();
        int i = 0;
        while (i < qrString.length()) {
            Pair<String, String> separate = separate(i, qrString);
            i += separate.getSecond().length() + 4;
            this.hashMapResult.put(separate.getFirst(), separate.getSecond());
        }
        return this.hashMapResult;
    }

    private final void attemptInternalDecode(String headerString, String internalQr) {
        int i = 0;
        while (i < internalQr.length()) {
            try {
                Pair<String, String> separate = separate(i, internalQr);
                i += separate.getSecond().length() + 4;
                HashMap<String, String> hashMap = this.hashMapResult;
                StringBuilder sb = new StringBuilder();
                sb.append(headerString);
                sb.append(separate.getFirst());
                hashMap.put(sb.toString(), separate.getSecond());
            } catch (Exception unused) {
                return;
            }
        }
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<HashMap<String, String>> buildUseCase(final String params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<HashMap<String, String>> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.domain.qrbarcode.interactor.GetNativelyDecodedQr$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                HashMap m2424buildUseCase$lambda0;
                m2424buildUseCase$lambda0 = GetNativelyDecodedQr.m2424buildUseCase$lambda0(GetNativelyDecodedQr.this, params);
                return m2424buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final HashMap m2424buildUseCase$lambda0(GetNativelyDecodedQr getNativelyDecodedQr, String str) {
        Intrinsics.checkNotNullParameter(getNativelyDecodedQr, "");
        Intrinsics.checkNotNullParameter(str, "");
        return getNativelyDecodedQr.initialQrLogic(str);
    }
}
