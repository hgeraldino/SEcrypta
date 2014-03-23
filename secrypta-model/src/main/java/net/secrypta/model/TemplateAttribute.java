package net.secrypta.model;

import info.archinnov.achilles.annotations.Column;
import info.archinnov.achilles.annotations.Entity;
import info.archinnov.achilles.annotations.Id;

import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.google.common.base.Objects;

@Entity(table = "template_attribute")
public class TemplateAttribute {

    @Id
    private UUID templateAttributeId;

    @Column
    private UUID templateId;

    @Column
    @NotBlank
    @Pattern(regexp = "[A-Za-z_]{3, 255}", message = "Must be between 3 and 255 alphabet characters, underscores allowed")
    private String name;

    @Column
    @Size(max = 255)
    private String displayName;

    @Column
    @NotNull
    private int displayOrder;

    @Column
    @Size(max = 255)
    private String validationExpression;

    @Column
    @Size(max = 255)
    private String errorMessage;

    @Column
    private boolean secured;

    @Column
    private boolean required;

    public UUID getTemplateAttributeId() {
        return templateAttributeId;
    }

    public void setTemplateAttributeId(UUID templateAttributeId) {
        this.templateAttributeId = templateAttributeId;
    }

    public UUID getTemplateId() {
        return templateId;
    }

    public void setTemplateId(UUID templateId) {
        this.templateId = templateId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getValidationExpression() {
        return validationExpression;
    }

    public void setValidationExpression(String validationExpression) {
        this.validationExpression = validationExpression;
    }

    public boolean isSecured() {
        return secured;
    }

    public void setSecured(boolean secured) {
        this.secured = secured;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof TemplateAttribute)) {
            return false;
        }
        final TemplateAttribute other = (TemplateAttribute) obj;

        return Objects.equal(this.getTemplateAttributeId(), other.getTemplateAttributeId()) && Objects.equal(this.getTemplateId(), other.getTemplateId())
                && Objects.equal(this.getName(), other.getName()) && Objects.equal(this.getDisplayName(), other.getDisplayName())
                && Objects.equal(this.getDisplayOrder(), other.getDisplayOrder())
                && Objects.equal(this.getValidationExpression(), other.getValidationExpression()) && Objects.equal(this.isRequired(), other.isRequired());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getTemplateAttributeId(), this.getTemplateId(), this.getName(), this.getDisplayName(), this.getDisplayOrder(),
                this.getValidationExpression(), this.isRequired());
    }

}
