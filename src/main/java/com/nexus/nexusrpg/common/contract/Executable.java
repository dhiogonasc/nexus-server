package com.nexus.nexusrpg.common.contract;

import com.nexus.nexusrpg.common.EntityStatus;

public interface Executable {
    EntityStatus getStatus();
    boolean isCurrent();
    void unlock();
    void complete();
}
