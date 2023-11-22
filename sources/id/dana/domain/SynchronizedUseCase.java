package id.dana.domain;

/* loaded from: classes4.dex */
public abstract class SynchronizedUseCase<T, P> {
    private static final long MAX_EXECUTE_TIME = 100;

    protected abstract T buildUseCaseObservable(P p) throws SynchronizedUseCaseException;

    public T execute() throws SynchronizedUseCaseException {
        return execute(null);
    }

    public T execute(P p) throws SynchronizedUseCaseException {
        T buildUseCaseObservable;
        synchronized (this) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                buildUseCaseObservable = buildUseCaseObservable(p);
                int i = ((System.currentTimeMillis() - currentTimeMillis) > 100L ? 1 : ((System.currentTimeMillis() - currentTimeMillis) == 100L ? 0 : -1));
            } catch (Exception e) {
                throw e;
            }
        }
        return buildUseCaseObservable;
    }
}
