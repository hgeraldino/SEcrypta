package net.secrypta.model;

import info.archinnov.achilles.annotations.Column;
import info.archinnov.achilles.annotations.Entity;
import info.archinnov.achilles.annotations.Id;

import java.util.UUID;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.google.common.base.Objects;

@Entity(table = "bucket")
public class Bucket {

	@Id
	private UUID id;

	@Column
	@NotBlank
	@Size(max = 255)
	private String name;

	@Column
	private UUID parentId;

	@Column
	private String path;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getParentId() {
		return parentId;
	}

	public void setParentId(UUID parentId) {
		this.parentId = parentId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Bucket)) {
			return false;
		}
		final Bucket other = (Bucket) obj;

		return Objects.equal(this.getId(), other.getId())
				&& Objects.equal(this.getName(), other.getName())
				&& Objects.equal(this.getPath(), other.getPath())
				&& Objects.equal(this.getParentId(), other.getParentId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.getId(), this.getName(), this.getPath(),
				this.getParentId());
	}

}
