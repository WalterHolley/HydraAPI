package com.umsl.hydra.api.model;

import java.util.List;

public interface Repository <V extends IDomainObject>{

    void put(V item);
    void delete(V item);
    List<V> getItems();
}
