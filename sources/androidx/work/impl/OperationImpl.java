package androidx.work.impl;

import androidx.view.MutableLiveData;
import androidx.work.Operation;
import androidx.work.impl.utils.futures.SettableFuture;

/* loaded from: classes3.dex */
public class OperationImpl implements Operation {
    private final MutableLiveData<Operation.State> MyBillsEntityDataFactory = new MutableLiveData<>();
    private final SettableFuture<Operation.State.SUCCESS> getAuthRequestContext = SettableFuture.PlaceComponentResult();

    public OperationImpl() {
        MyBillsEntityDataFactory(Operation.PlaceComponentResult);
    }

    public final void MyBillsEntityDataFactory(Operation.State state) {
        this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory((MutableLiveData<Operation.State>) state);
        if (state instanceof Operation.State.SUCCESS) {
            this.getAuthRequestContext.getAuthRequestContext((SettableFuture<Operation.State.SUCCESS>) ((Operation.State.SUCCESS) state));
        } else if (state instanceof Operation.State.FAILURE) {
            this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(((Operation.State.FAILURE) state).BuiltInFictitiousFunctionClassFactory);
        }
    }
}
