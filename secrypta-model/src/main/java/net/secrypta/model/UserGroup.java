package net.secrypta.model;

import info.archinnov.achilles.annotations.Column;
import info.archinnov.achilles.annotations.EmbeddedId;
import info.archinnov.achilles.annotations.Entity;
import info.archinnov.achilles.annotations.Order;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.google.common.base.Objects;

@Entity(table = "user_group")
public class UserGroup {

    @EmbeddedId
    private CompositeKey id = new CompositeKey();

    @Column
    @NotBlank
    private byte[] privateKey;

    public CompositeKey getId() {
        return id;
    }

    public void setId(CompositeKey id) {
        this.id = id;
    }

    public byte[] getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(byte[] privateKey) {
        this.privateKey = privateKey;
    }

    public static class CompositeKey {

        @Order(1)
        @NotNull
        private UUID groupId;

        @Order(2)
        @NotNull
        private UUID userId;

        public UUID getGroupId() {
            return groupId;
        }

        public void setGroupId(UUID groupId) {
            this.groupId = groupId;
        }

        public UUID getUserId() {
            return userId;
        }

        public void setUserId(UUID userId) {
            this.userId = userId;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof UserGroup)) {
            return false;
        }
        final UserGroup other = (UserGroup) obj;

        return Objects.equal(this.getId(), other.getId()) && Objects.equal(this.getPrivateKey(), other.getPrivateKey());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getId(), this.getPrivateKey());
    }
}
