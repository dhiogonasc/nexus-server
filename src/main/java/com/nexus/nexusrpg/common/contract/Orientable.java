package com.nexus.nexusrpg.common.contract;

public interface Orientable {
    int getOrder();
    default int getNextOrder() {
        return getOrder() + 1;
    }
    default boolean isFirst() {
        return getOrder() == 1;
    }
    boolean isLast();
}