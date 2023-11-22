package id.dana.sendmoney.ui.globalsend.form.fragment;

import dagger.MembersInjector;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.sendmoney.util.GlobalSendTrackerHelper;

/* loaded from: classes5.dex */
public final class ReceiverFormFragment_MembersInjector implements MembersInjector<ReceiverFormFragment> {
    public static void MyBillsEntityDataFactory(ReceiverFormFragment receiverFormFragment, ViewModelFactory viewModelFactory) {
        receiverFormFragment.viewModelFactory = viewModelFactory;
    }

    public static void BuiltInFictitiousFunctionClassFactory(ReceiverFormFragment receiverFormFragment, GlobalSendTrackerHelper globalSendTrackerHelper) {
        receiverFormFragment.globalSendTrackerHelper = globalSendTrackerHelper;
    }
}
