package net.secrypta.model;

import info.archinnov.achilles.annotations.Column;
import info.archinnov.achilles.annotations.Entity;
import info.archinnov.achilles.annotations.Id;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.google.common.base.Objects;

@Entity(table = "item")
public class Item extends Template {

    @Id
    private UUID itemId;

    @Column
    @NotNull
    private UUID bucketId;

    @Column
    @NotBlank
    @Size(max = 255)
    private String name;

    @Column
    @Size(max = 500)
    private String description;

    @Column
    private String notes;

    @Column
    private Date expirationDate;

    @Column
    private boolean deleted;

    @Column
    @NotNull
    private boolean inheritPermissions = true;

    @Column
    private Set<UUID> attributeIds;

    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }

    public UUID getBucketId() {
        return bucketId;
    }

    public void setBucketId(UUID bucketId) {
        this.bucketId = bucketId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isInheritPermissions() {
        return inheritPermissions;
    }

    public void setInheritPermissions(boolean inheritPermissions) {
        this.inheritPermissions = inheritPermissions;
    }

    public Set<UUID> getAttributeIds() {
        return attributeIds;
    }

    public void setAttributeIds(Set<UUID> attributeIds) {
        this.attributeIds = attributeIds;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Item)) {
            return false;
        }
        final Item other = (Item) obj;

        return Objects.equal(this.getItemId(), other.getItemId()) && Objects.equal(this.getBucketId(), other.getBucketId())
                && Objects.equal(this.getName(), other.getName()) && Objects.equal(this.isInheritPermissions(), other.isInheritPermissions());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getItemId(), this.getBucketId(), this.getName(), this.isInheritPermissions());
    }

}
