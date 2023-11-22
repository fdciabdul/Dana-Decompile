package id.dana.domain;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00052\u00060\u0001j\u0002`\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/domain/SynchronizedUseCaseException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SynchronizedUseCaseException extends Exception {
    private static final String MESSAGE = "failed on buildUseCaseObservable";

    public SynchronizedUseCaseException() {
        super(MESSAGE);
    }
}
