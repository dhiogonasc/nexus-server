package com.nexus.nexusrpg.common.contract;

import com.nexus.nexusrpg.user.User;

public interface Usable extends Executable, Rewardable {
    User getUser();
}
