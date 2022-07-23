package edu.services;

import java.util.Date;
import java.util.UUID;

class BaseFields {
    protected final String uniqueId = UUID.randomUUID().toString();
    protected final Date createdAt = new Date();
    protected Date updatedAt = new Date();

    public String getUniqueId() {
        return uniqueId;
    }
}
