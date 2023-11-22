package id.dana.rum;

import id.dana.rum.Rum;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/rum/NoOpWorkflow;", "Lid/dana/rum/Rum$Workflow;", "", "PlaceComponentResult", "()V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NoOpWorkflow implements Rum.Workflow {
    public static final NoOpWorkflow INSTANCE = new NoOpWorkflow();

    @Override // id.dana.rum.Rum.Workflow
    public final void PlaceComponentResult() {
    }

    private NoOpWorkflow() {
    }
}
