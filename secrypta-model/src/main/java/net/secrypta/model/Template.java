package net.secrypta.model;

import info.archinnov.achilles.annotations.Column;
import info.archinnov.achilles.annotations.Entity;
import info.archinnov.achilles.annotations.Id;

import java.util.UUID;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.google.common.base.Objects;

@Entity(table = "item_template")
public class Template {

	@Id
	private UUID templateId;

	@Column
	private UUID parentTemplateId;

	@Column
	@NotBlank
	@Size(max = 255)
	private String name;

	@Column
	@NotBlank
	private boolean usable;

	public UUID getTemplateId() {
		return templateId;
	}

	public void setTemplateId(UUID templateId) {
		this.templateId = templateId;
	}

	public UUID getParentTemplateId() {
		return parentTemplateId;
	}

	public void setParentTemplateId(UUID parentTemplateId) {
		this.parentTemplateId = parentTemplateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isUsable() {
		return usable;
	}

	public void setUsable(boolean usable) {
		this.usable = usable;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Template)) {
			return false;
		}
		final Template other = (Template) obj;

		return Objects.equal(this.getTemplateId(), other.getTemplateId())
				&& Objects.equal(this.getParentTemplateId(),
						other.getParentTemplateId())
				&& Objects.equal(this.getName(), other.getName())
				&& Objects.equal(this.isUsable(), other.isUsable());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.getTemplateId(),
				this.getParentTemplateId(), this.getName(), this.isUsable());
	}

}
