package com.umsl.hydra.api.model;

import java.io.Serializable;

public interface IDomainObject extends Serializable {
    String getKey();
    String getObjectKey();
}
