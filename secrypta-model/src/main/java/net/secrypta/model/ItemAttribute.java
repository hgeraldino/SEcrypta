package net.secrypta.model;

import info.archinnov.achilles.annotations.Column;
import info.archinnov.achilles.annotations.Entity;
import info.archinnov.achilles.annotations.Id;

import java.util.UUID;

import com.google.common.base.Objects;

@Entity(table = "item_attribute")
public class ItemAttribute extends TemplateAttribute {

    @Id
    private UUID itemAttributeId;

    @Column
    private UUID itemId;

    @Column(name = "Value")
    private String value;

    private String transientValue;

    @Column(name = "IV")
    private byte[] IV;

    public UUID getItemAttributeId() {
        return itemAttributeId;
    }

    public void setItemAttributeId(UUID itemAttributeId) {
        this.itemAttributeId = itemAttributeId;
    }

    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
        if (this.isSecured()) {
            this.transientValue = value;
        }
    }

    public String getTransientValue() {
        return transientValue;
    }

    public void setTransientValue(String transientValue) {
        this.transientValue = transientValue;
    }

    public byte[] getIV() {
        return IV;
    }

    public void setIV(byte[] iV) {
        IV = iV;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ItemAttribute)) {
            return false;
        }
        final ItemAttribute other = (ItemAttribute) obj;

        return Objects.equal(this.getItemAttributeId(), other.getItemAttributeId()) && Objects.equal(this.getItemId(), other.getItemId())
                && Objects.equal(this.getValue(), other.getValue()) && Objects.equal(this.getIV(), other.getIV());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getItemAttributeId(), this.getItemId(), this.getValue(), this.getIV());
    }

}
