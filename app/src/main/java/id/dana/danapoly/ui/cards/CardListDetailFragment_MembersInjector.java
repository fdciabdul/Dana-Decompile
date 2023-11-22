package id.dana.danapoly.ui.cards;

import dagger.MembersInjector;
import id.dana.core.ui.di.module.ViewModelFactory;

/* loaded from: classes4.dex */
public final class CardListDetailFragment_MembersInjector implements MembersInjector<CardListDetailFragment> {
    public static void MyBillsEntityDataFactory(CardListDetailFragment cardListDetailFragment, ViewModelFactory viewModelFactory) {
        cardListDetailFragment.viewModelFactory = viewModelFactory;
    }
}
