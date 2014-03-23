package net.secrypta.model;

import info.archinnov.achilles.annotations.Column;
import info.archinnov.achilles.annotations.Entity;
import info.archinnov.achilles.annotations.Id;

import java.util.UUID;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.google.common.base.Objects;

@Entity(table = "group")
public class Group {

	@Id
	private UUID id;

	@Column
	@NotBlank
	@Size(max = 45)
	private String name;

	@Column
	@NotBlank
	private byte[] publicKey;

	@Column
	@NotBlank
	private byte[] privateKey;

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

	public byte[] getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(byte[] publicKey) {
		this.publicKey = publicKey;
	}

	public byte[] getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(byte[] privateKey) {
		this.privateKey = privateKey;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Group)) {
			return false;
		}
		final Group other = (Group) obj;

		return Objects.equal(this.getId(), other.getId())
				&& Objects.equal(this.getName(), other.getName())
				&& Objects.equal(this.getPublicKey(), other.getPublicKey());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.getId(), this.getName(),
				this.getPublicKey());
	}
}
