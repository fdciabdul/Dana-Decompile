package com.google.api;

import com.google.api.Billing;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes7.dex */
public interface BillingOrBuilder extends MessageLiteOrBuilder {
    Billing.BillingDestination getConsumerDestinations(int i);

    int getConsumerDestinationsCount();

    List<Billing.BillingDestination> getConsumerDestinationsList();
}
