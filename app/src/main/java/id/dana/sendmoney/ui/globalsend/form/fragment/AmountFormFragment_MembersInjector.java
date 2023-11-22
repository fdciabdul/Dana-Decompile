package id.dana.sendmoney.ui.globalsend.form.fragment;

import dagger.MembersInjector;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.sendmoney.util.GlobalSendTrackerHelper;

/* loaded from: classes5.dex */
public final class AmountFormFragment_MembersInjector implements MembersInjector<AmountFormFragment> {
    public static void PlaceComponentResult(AmountFormFragment amountFormFragment, ViewModelFactory viewModelFactory) {
        amountFormFragment.viewModelFactory = viewModelFactory;
    }

    public static void PlaceComponentResult(AmountFormFragment amountFormFragment, GlobalSendTrackerHelper globalSendTrackerHelper) {
        amountFormFragment.globalSendTrackerHelper = globalSendTrackerHelper;
    }
}
